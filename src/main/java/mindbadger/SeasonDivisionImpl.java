package mindbadger;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;

@Entity
@Table(name = "season_division")
public class SeasonDivisionImpl implements SeasonDivision, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(SeasonDivisionImpl.class);
	
	private Season season;
	private Division division;
	private int divisionPosition;
	
	public SeasonDivisionImpl () {
		log.info("Creating a new instance of SeasonDivisionImpl using default constructor");
	}
	
	public SeasonDivisionImpl (Season season, Division division, int divisionPosition) {
		log.info("Creating a new instance of SeasonDivisionImpl using values constructor");
		this.season = season;
		this.division = division;
		this.divisionPosition = divisionPosition;
	}
	
	@Id
	@Override
	@ManyToOne(targetEntity=SeasonImpl.class)
	@JoinColumn(name = "ssn_num", referencedColumnName="ssn_num")
	public Season getSeason() {
		log.info("Returning season from SeasonDivision: " + (this.season == null ? "NULL" : this.season.getSeasonNumber()) );
		return this.season;
	}

	@Id
	@Override
	@ManyToOne(targetEntity=DivisionImpl.class)
	@JoinColumn(name = "div_id")//, referencedColumnName="div_id")
	public Division getDivision() {
		log.info("Returning division from SeasonDivision: " + (this.division == null ? "NULL" : this.division.getDivisionId() + " / " + this.division.getDivisionName()));
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
		log.info("compareTo called on SeasonDivison");
		//TODO This was copied from the couchbase dao code - consider an abstract superclass
		if (compareTo.getSeason().getSeasonNumber() != this.getSeason().getSeasonNumber()) {
			return this.getSeason().getSeasonNumber() - compareTo.getSeason().getSeasonNumber();
		} else if (compareTo.getDivisionPosition() != this.getDivisionPosition()) {
			return this.getDivisionPosition() - compareTo.getDivisionPosition();
		} else {
			return this.getDivision().getDivisionName().compareTo(compareTo.getDivision().getDivisionName());
		}
	}

	@Override
	public boolean equals(Object obj) {
		log.info("equals called on SeasonDivison");
		if (obj instanceof SeasonDivision) {
			SeasonDivision compareTo = (SeasonDivision) obj;
			Integer ssnNumToCompare = (compareTo.getSeason() == null ? null : compareTo.getSeason().getSeasonNumber());
			String divIdToCompare = (compareTo.getDivision() == null ? null : compareTo.getDivision().getDivisionId());
			
			Integer ssnNum = (this.getSeason() == null ? null : this.getSeason().getSeasonNumber());
			String divId = (this.getDivision() == null ? null : this.getDivision().getDivisionId());
			
			return (ssnNum != null && (ssnNumToCompare == ssnNum && divIdToCompare == divId));
			
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		log.info("hashCode called on SeasonDivison");
		Integer ssnNum = (this.getSeason() == null ? null : this.getSeason().getSeasonNumber());
		String divId = (this.getDivision() == null ? null : this.getDivision().getDivisionId());

		return Objects.hash(ssnNum, divId);
	}

}
