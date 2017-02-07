package mindbadger.football.model;

import java.io.Serializable;
import java.util.Objects;

public class SeasonDivisionTeamId implements Serializable {
	private static final long serialVersionUID = 7195048183491291063L;

	private Integer season;
	private String division;
	private String team;

	public SeasonDivisionTeamId () {}
	
	public SeasonDivisionTeamId (SeasonDivisionId seasonDivision, String team) {
		this.team = team;
		this.division = seasonDivision.getDivision();
		this.season = seasonDivision.getSeason();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(season, division, team);	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof SeasonDivisionId)) return false;
		SeasonDivisionTeamId seasonDivisionTeamId = (SeasonDivisionTeamId) obj;
		
		boolean seasonEqual = season.equals(seasonDivisionTeamId.getSeason());
		boolean divisionEqual = division.equals(seasonDivisionTeamId.getDivision());		
		boolean teamEqual = team.equals(seasonDivisionTeamId.getTeam());
		
		return (seasonEqual && divisionEqual && teamEqual);
	}
	

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	public Integer getSeason() {
		return season;
	}
	
	public void setSeason(Integer season) {
		this.season = season;
	}
	
	public String getDivision() {
		return division;
	}
	
	public void setDivision(String division) {
		this.division = division;
	}
}
