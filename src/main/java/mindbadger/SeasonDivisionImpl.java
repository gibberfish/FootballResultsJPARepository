package mindbadger;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;

@Entity
@Table(name = "season_division")
@IdClass(SeasonDivisionId.class)
public class SeasonDivisionImpl implements SeasonDivision, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(SeasonDivisionImpl.class);
	
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
	
	public SeasonDivisionImpl () {
	}
	
	public SeasonDivisionImpl (Season season, Division division, int divisionPosition) {
		this.season = season;
		this.division = division;
		this.divisionPosition = divisionPosition;
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
		//log.info("compareTo called on SeasonDivison");
		//TODO This was copied from the couchbase dao code - consider an abstract superclass
		if (compareTo.getSeason().getSeasonNumber() != this.getSeason().getSeasonNumber()) {
			return this.getSeason().getSeasonNumber() - compareTo.getSeason().getSeasonNumber();
		} else if (compareTo.getDivisionPosition() != this.getDivisionPosition()) {
			return this.getDivisionPosition() - compareTo.getDivisionPosition();
		} else {
			return this.getDivision().getDivisionName().compareTo(compareTo.getDivision().getDivisionName());
		}
	}

//	@Override
//	public boolean equals(Object obj) {
//		//log.info("equals called on SeasonDivison");
//		if (obj instanceof SeasonDivision) {
//			SeasonDivision compareTo = (SeasonDivision) obj;
//			Integer ssnNumToCompare = (compareTo.getSeason() == null ? null : compareTo.getSeason().getSeasonNumber());
//			String divIdToCompare = (compareTo.getDivision() == null ? null : compareTo.getDivision().getDivisionId());
//			
//			Integer ssnNum = (season == null ? null : season.getSeasonNumber());
//			String divId = (division == null ? null : division.getDivisionId());
//			
//			return (ssnNum != null && (ssnNumToCompare == ssnNum && divIdToCompare == divId));
//			
//		}
//		return super.equals(obj);
//	}
//
//	@Override
//	public int hashCode() {
//		//log.info("hashCode called on SeasonDivison");
//		Integer ssnNum = (season == null ? null : season.getSeasonNumber());
//		String divId = (division == null ? null : division.getDivisionId());
//
//		return Objects.hash(ssnNum, divId);
//	}

}
