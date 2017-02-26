package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Objects;

public class SeasonDivisionTeamId implements Serializable {
	private static final long serialVersionUID = 7195048183491291063L;

	private String team;
	private SeasonDivisionId seasonDivision;
	
	public SeasonDivisionTeamId () {}
	
	@Override
	public int hashCode() {
		return Objects.hash(seasonDivision, team);	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof SeasonDivisionId)) return false;
		SeasonDivisionTeamId seasonDivisionTeamId = (SeasonDivisionTeamId) obj;
		
		boolean seasonDivisionEqual = seasonDivision.equals(seasonDivisionTeamId.seasonDivision);
		boolean teamEqual = team.equals(seasonDivisionTeamId.team);
		
		return (seasonDivisionEqual && teamEqual);
	}
}
