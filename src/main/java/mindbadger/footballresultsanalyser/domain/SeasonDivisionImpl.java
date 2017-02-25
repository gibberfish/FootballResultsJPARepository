package mindbadger.footballresultsanalyser.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "season_division")
@IdClass (SeasonDivisionId.class)
public class SeasonDivisionImpl implements SeasonDivision, Serializable {
	private static final long serialVersionUID = 1L;
	
	public SeasonDivisionImpl () {
		seasonDivisionTeams = new HashSet<SeasonDivisionTeam> ();
	}
	
	public SeasonDivisionImpl (Season season, Division division, int divisionPosition) {
		seasonDivisionTeams = new HashSet<SeasonDivisionTeam> ();
		this.season = season;
		this.division = division;
		this.divisionPosition = divisionPosition;
	}

	@Id
	@ManyToOne(targetEntity=SeasonImpl.class)
	@JoinColumn(name = "ssn_num", referencedColumnName="ssn_num")
	private Season season;

	@Id
	@ManyToOne(targetEntity=DivisionImpl.class)
	@JoinColumn(name = "div_id", referencedColumnName="div_id")
	private Division division;

	@Column(name = "div_pos")
	private int divisionPosition;

	//@Transient
	@OneToMany(mappedBy = "seasonDivision", targetEntity=SeasonDivisionTeamImpl.class, fetch = FetchType.LAZY, orphanRemoval=true)
	private Set<SeasonDivisionTeam> seasonDivisionTeams; 
	
	@Override
	public Set<SeasonDivisionTeam> getSeasonDivisionTeams() {
		return seasonDivisionTeams;
	}
	
	@Override
	public void setSeasonDivisionTeams(Set<SeasonDivisionTeam> seasonDivisionTeams) {
		this.seasonDivisionTeams = seasonDivisionTeams;
	}

	@Override
	public Season getSeason() {
		return this.season;
	}

	@Override
	public Division getDivision() {
		return this.division;
	}

	
	@Override
	public int getDivisionPosition() {
		return this.divisionPosition;
	}
	
	@Override
	public void setSeason(Season season) {
		this.season = season;
	}

	@Override
	public void setDivision(Division division) {
		this.division = division;
	}

	@Override
	public void setDivisionPosition(int divisionPosition) {
		this.divisionPosition = divisionPosition;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(season, division);	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof SeasonDivisionImpl)) return false;
		SeasonDivisionImpl seasonDivsion = (SeasonDivisionImpl) obj;

		boolean seasonIdEqual = (season == seasonDivsion.getSeason());
		boolean divisionIdEqual = division.equals(seasonDivsion.getDivision());
		
		return (seasonIdEqual && divisionIdEqual);
	}

	
	@Override
	public int compareTo(SeasonDivision compareTo) {
		//TODO This was copied from the couchbase dao code - consider an abstract superclass
		if (compareTo.getSeason().getSeasonNumber() != this.getSeason().getSeasonNumber()) {
			return this.getSeason().getSeasonNumber() - compareTo.getSeason().getSeasonNumber();
		} else if (compareTo.getDivisionPosition() != this.getDivisionPosition()) {
			return this.getDivisionPosition() - compareTo.getDivisionPosition();
		} else {
			return this.getDivision().getDivisionName().compareTo(compareTo.getDivision().getDivisionName());
		}
	}
}
