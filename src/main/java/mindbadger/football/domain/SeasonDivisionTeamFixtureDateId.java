package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

public class SeasonDivisionTeamFixtureDateId implements Serializable {
	private static final long serialVersionUID = 7135048182491291063L;

	private SeasonDivisionTeamId seasonDivisionTeam;
	private Calendar fixtureDate;
	private String statistic;

	public SeasonDivisionTeamFixtureDateId() {}
	
	@Override
	public int hashCode() {
		return Objects.hash(seasonDivisionTeam, fixtureDate);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof SeasonDivisionTeamFixtureDateId)) return false;
		SeasonDivisionTeamFixtureDateId seasonDivisionTeamFixtureId = (SeasonDivisionTeamFixtureDateId) obj;
		
		boolean seasonDivisionTeamEqual = seasonDivisionTeam.equals(seasonDivisionTeamFixtureId.seasonDivisionTeam);
		boolean fixtureDateEqual = fixtureDate.equals(seasonDivisionTeamFixtureId.fixtureDate);
		boolean statisticEqual = fixtureDate.equals(seasonDivisionTeamFixtureId.statistic);
		
		return (seasonDivisionTeamEqual && fixtureDateEqual && statisticEqual);
	}
}
