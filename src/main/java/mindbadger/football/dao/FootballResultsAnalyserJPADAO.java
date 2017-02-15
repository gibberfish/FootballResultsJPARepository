package mindbadger.football.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
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
	public void closeSession() {
		// Not required for This implementation
	}
	
	@Override
	public void startSession() {
		// Not required for This implementation
	}
	
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
	public Division getDivision(String id) {
		return divisionRepository.findOne(id);
	}
	
	@Override
	public Fixture getFixture(String id) {
		return fixtureRepository.findOne(id);
	}
	
	@Override
	public Season getSeason(Integer seasonNumber) {
		return seasonRepository.findOne(seasonNumber);
	}
	
	@Override
	public Team getTeam(String id) {
		return teamRepository.findOne(id);
	}

	

	
	
	

	@Override
	public Map<String, Division> getAllDivisions() {
		Iterable<Division> divisions = divisionRepository.findAll();
		Map<String, Division> divisionsMap = new HashMap<String, Division> ();
		
		for (Division division : divisions) {
			divisionsMap.put(division.getDivisionId(), division);
		}
		
		return divisionsMap;
	}

	@Override
	public Map<String, Team> getAllTeams() {
		Iterable<Team> teams = teamRepository.findAll();
		Map<String, Team> teamsMap = new HashMap<String, Team> ();
		
		for (Team team : teams) {
			teamsMap.put(team.getTeamId(), team);
		}
		
		return teamsMap;
	}

	@Override
	public List<Season> getSeasons() {
		Iterable<Season> seasons = seasonRepository.findAll();
		List<Season> seasonsList = new ArrayList<Season> ();
		
		for (Season season : seasons) {
			seasonsList.add(season);
		}
		
		return seasonsList;
	}

	@Override
	public List<Fixture> getFixtures() {
		Iterable<Fixture> fixtures = fixtureRepository.findAll();
		List<Fixture> fixturesList = new ArrayList<Fixture> ();
		
		for (Fixture fixture : fixtures) {
			fixturesList.add(fixture);
		}
		
		return fixturesList;
	}

	@Override
	public List<SeasonDivision> getDivisionsForSeason(Season season) {
		Integer seasonNumber = season.getSeasonNumber();
		Season retrievedSeason = seasonRepository.findOne(seasonNumber);
		return new ArrayList<SeasonDivision> (retrievedSeason.getSeasonDivisions());
	}

	@Override
	public List<SeasonDivisionTeam> getTeamsForDivisionInSeason(SeasonDivision seasonDivision) {
		Integer seasonNumber = seasonDivision.getSeason().getSeasonNumber();
		Season retrievedSeason = seasonRepository.findOne(seasonNumber);
		
		for (SeasonDivision retrievedSeasonDivision : retrievedSeason.getSeasonDivisions()) {
			
			if (seasonDivision.getDivision().getDivisionId().equals(retrievedSeasonDivision.getDivision().getDivisionId())) {
				return new ArrayList<SeasonDivisionTeam> (seasonDivision.getSeasonDivisionTeams());
			}
		}
		
		return null;
	}

	@Override
	public SeasonDivision getSeasonDivision(Season season, Division division) {
		Integer seasonNumber = season.getSeasonNumber();
		Season retrievedSeason = seasonRepository.findOne(seasonNumber);
		for (SeasonDivision seasonDivision : retrievedSeason.getSeasonDivisions()) {
			if (division.getDivisionId().equals(seasonDivision.getDivision().getDivisionId())) {
				return seasonDivision;
			}
		}
		
		return null;
	}

	@Override
	public List<Fixture> getFixturesWithNoFixtureDate() {
		return fixtureRepository.getFixturesWithNoFixtureDate();
	}

	@Override
	public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team) {
		return fixtureRepository.getFixturesForTeamInDivisionInSeason(seasonDivision, team);
	}

	@Override
	public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision) {
		return fixtureRepository.getFixturesForDivisionInSeason(seasonDivision);
	}

	@Override
	public List<Fixture> getUnplayedFixturesBeforeToday() {
		return fixtureRepository.getUnplayedFixturesBeforeToday();
	}

}
