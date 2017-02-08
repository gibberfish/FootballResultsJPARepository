package mindbadger.football.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class SeasonDivisionId implements Serializable {
	private static final long serialVersionUID = 8013910648038828574L;

//	@Column(name="season")
	private Integer season;
	
//	@Column(name="division")
	private String division;

	@Override
	public int hashCode() {
		return Objects.hash(season, division);	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof SeasonDivisionId)) return false;
		SeasonDivisionId seasonDivsionId = (SeasonDivisionId) obj;
		
		boolean seasonIdEqual = (season == seasonDivsionId.getSeason());
		boolean divisionIdEqual = division.equals(seasonDivsionId.getDivision());
		
		return (seasonIdEqual && divisionIdEqual);
	}
	
	public Integer getSeason() {
		return season;
	}
	
	public String getDivision() {
		return division;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}
	
	public void setDivision(String division) {
		this.division = division;
	}
}

