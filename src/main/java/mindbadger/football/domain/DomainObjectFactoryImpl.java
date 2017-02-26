package mindbadger.football.domain;

import org.springframework.stereotype.Component;

import mindbadger.football.domain.Division;
import mindbadger.football.domain.DomainObjectFactory;
import mindbadger.football.domain.Fixture;
import mindbadger.football.domain.Season;
import mindbadger.football.domain.SeasonDivision;
import mindbadger.football.domain.SeasonDivisionTeam;
import mindbadger.football.domain.Team;

@Component
public class DomainObjectFactoryImpl implements DomainObjectFactory {

	@Override
	public Division createDivision(String divisionName) {
		Division division = new DivisionImpl ();
		division.setDivisionName(divisionName);
		return division;
	}
	
	@Override
	public Team createTeam(String teamName) {
		Team team = new TeamImpl();
		team.setTeamName(teamName);
		return team;
	}

	@Override
	public Season createSeason(Integer seasonNumber) {
		Season season = new SeasonImpl();
		season.setSeasonNumber(seasonNumber);
		return season;
	}

	@Override
	public SeasonDivision createSeasonDivision(Season season, Division division, int position) {
		SeasonDivision seasonDivision = new SeasonDivisionImpl();
		seasonDivision.setSeason(season);
		seasonDivision.setDivision(division);
		seasonDivision.setDivisionPosition(position);
		return seasonDivision;
	}

	@Override
	public SeasonDivisionTeam createSeasonDivisionTeam(SeasonDivision seasonDivision, Team team) {
		SeasonDivisionTeam seasonDivisionTeam = new SeasonDivisionTeamImpl();
		seasonDivisionTeam.setSeasonDivision(seasonDivision);
		seasonDivisionTeam.setTeam(team);
		return seasonDivisionTeam;
	}

	
	@Override
	public Fixture createFixture(Season season, Team homeTeam, Team awayTeam) {
		Fixture fixture = new FixtureImpl ();
		fixture.setSeason(season);
		fixture.setHomeTeam(homeTeam);
		fixture.setAwayTeam(awayTeam);
		return fixture;
	}
}
