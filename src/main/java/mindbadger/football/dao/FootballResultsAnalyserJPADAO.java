package mindbadger.football.dao;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.footballresultsanalyser.dao.FootballResultsAnalyserDAO;
import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.DomainObjectFactory;
import mindbadger.footballresultsanalyser.domain.Fixture;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.SeasonDivisionTeam;
import mindbadger.footballresultsanalyser.domain.Team;
import mindbadger.footballresultsanalyser.repository.DivisionRepository;
import mindbadger.footballresultsanalyser.repository.FixtureRepository;
import mindbadger.footballresultsanalyser.repository.SeasonRepository;
import mindbadger.footballresultsanalyser.repository.TeamRepository;

@Component
public class FootballResultsAnalyserJPADAO implements FootballResultsAnalyserDAO {

	@Autowired
	private DivisionRepository divisionRepository;
	
	@Autowired
	private SeasonRepository seasonRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private FixtureRepository fixtureRepository;
	
	@Autowired
	private DomainObjectFactory domainObjectFactory;
	
	@Override
	public Division addDivision(String name) {
		Division division = domainObjectFactory.createDivision(name);
		
		division = divisionRepository.save(division);
		
		return division;
	}

	@Override
	public Fixture addFixture(Season season, Calendar fixtureDate, Division division, Team homeTeam, Team awayTeam, Integer homeGoals,
			Integer awayGoals) {
		
		Fixture fixture = domainObjectFactory.createFixture(season, homeTeam, awayTeam);
		
		fixture.setDivision(division);
		fixture.setFixtureDate(fixtureDate);
		if (homeGoals != null) {
			fixture.setHomeGoals(homeGoals);
		}
		if (awayGoals != null) {
			fixture.setAwayGoals(awayGoals);
		}

		fixture = fixtureRepository.save(fixture);
		
		return fixture;
	}

	@Override
	public Season addSeason(Integer seasonNumber) {
		Season season = domainObjectFactory.createSeason(seasonNumber);
		
		season = seasonRepository.save(season);
		
		return season;
	}

	@Override
	public SeasonDivision addSeasonDivision(Season season, Division division, int position) {
		SeasonDivision seasonDivision = domainObjectFactory.createSeasonDivision(season, division, position);
		
		season.getSeasonDivisions().add(seasonDivision);
		
		seasonRepository.save(season);

		return seasonDivision;
	}

	@Override
	public SeasonDivisionTeam addSeasonDivisionTeam(SeasonDivision seasonDivision, Team team) {
		SeasonDivisionTeam seasonDivisionTeam = domainObjectFactory.createSeasonDivisionTeam(seasonDivision, team);
		
		seasonDivision.getSeasonDivisionTeams().add(seasonDivisionTeam);
		
		Season season = seasonDivision.getSeason();
		
		seasonRepository.save(season);
		
		return seasonDivisionTeam;
	}

	@Override
	public Team addTeam(String name) {
		Team team = domainObjectFactory.createTeam(name);
		
		team = teamRepository.save(team);

		return team;
	}

	@Override
	public void closeSession() {
		// Not required for This implementation
	}

	@Override
	public Map<String, Division> getAllDivisions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Team> getAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Division getDivision(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeasonDivision> getDivisionsForSeason(Season arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fixture getFixture(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fixture> getFixtures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision arg0, Team arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fixture> getFixturesWithNoFixtureDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Season getSeason(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeasonDivision getSeasonDivision(Season arg0, Division arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Season> getSeasons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getTeam(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeasonDivisionTeam> getTeamsForDivisionInSeason(SeasonDivision arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fixture> getUnplayedFixturesBeforeToday() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startSession() {
		// Not required for This implementation

	}

}
