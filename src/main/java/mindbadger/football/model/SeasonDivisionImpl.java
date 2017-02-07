package mindbadger.football.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.SeasonDivisionTeam;

@Entity
@Table(name = "season_division")
@IdClass(SeasonDivisionId.class)
public class SeasonDivisionImpl implements SeasonDivision, Serializable {
	private static final long serialVersionUID = 1L;
	
	public SeasonDivisionImpl () {
	}
	
	public SeasonDivisionImpl (Season season, Division division, int divisionPosition) {
		this.season = season;
		this.division = division;
		this.divisionPosition = divisionPosition;
	}
	
	@Id
	@ManyToOne(targetEntity=SeasonImpl.class, cascade=CascadeType.DETACH)
	@JoinColumn(name = "ssn_num", referencedColumnName="ssn_num")
	private Season season;

	@Id
	@ManyToOne(targetEntity=DivisionImpl.class, cascade=CascadeType.DETACH)
	@JoinColumn(name = "div_id", referencedColumnName="div_id")
	private Division division;

	@Column(name = "div_pos")
	private int divisionPosition;

	@OneToMany(mappedBy = "seasonDivisionId", targetEntity=SeasonDivisionTeamImpl.class, fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
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
