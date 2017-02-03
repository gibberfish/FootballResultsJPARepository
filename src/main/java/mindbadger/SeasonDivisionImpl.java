package mindbadger;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;

@Entity
@Table(name = "season_division")
public class SeasonDivisionImpl implements SeasonDivision, Serializable {
	private static final long serialVersionUID = 1L;
	
	private Season season;
	private Division division;
	private int divisionPosition;
	
	public SeasonDivisionImpl () {
	}
	
	public SeasonDivisionImpl (Season season, Division division, int divisionPosition) {
		this.season = season;
		this.division = division;
		this.divisionPosition = divisionPosition;
	}
	
	@Id
	@Override
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=SeasonImpl.class)
	//@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "ssn_num", referencedColumnName="ssn_num")
	public Season getSeason() {
		return this.season;
	}

	@Id
	@Override
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=DivisionImpl.class)
	//@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "div_id", referencedColumnName="div_id")
	public Division getDivision() {
		return this.division;
	}

	@Override
	@Column(name = "div_pos")
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
