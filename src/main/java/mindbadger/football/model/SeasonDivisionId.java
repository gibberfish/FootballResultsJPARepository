package mindbadger.football.model;

import java.io.Serializable;
import java.util.Objects;

public class SeasonDivisionId implements Serializable {
	private static final long serialVersionUID = 8013910648038828574L;

	private Integer season;
	private String division;

	@Override
	public int hashCode() {
		return Objects.hash(season, division);	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof SeasonDivisionId)) return false;
		SeasonDivisionId seasonDivsionId = (SeasonDivisionId) obj;
		
		boolean seasonEqual = (season == seasonDivsionId.getSeason());
		//boolean divisionEqual = Objects.equals(division, seasonDivsionId.getDivision());
		boolean divisionEqual = obj.equals(seasonDivsionId.getDivision());
		
		return (seasonEqual && divisionEqual);
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

