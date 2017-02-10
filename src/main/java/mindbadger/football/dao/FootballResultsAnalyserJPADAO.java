package mindbadger.football.dao;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.football.repository.DivisionRepository;
import mindbadger.football.repository.FixtureRepository;
import mindbadger.football.repository.SeasonRepository;
import mindbadger.football.repository.TeamRepository;
import mindbadger.footballresultsanalyser.dao.FootballResultsAnalyserDAO;
import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Fixture;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.SeasonDivisionTeam;
import mindbadger.footballresultsanalyser.domain.Team;

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
	
	@Override
	public Division addDivision(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fixture addFixture(Season arg0, Calendar arg1, Division arg2, Team arg3, Team arg4, Integer arg5,
			Integer arg6) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Season addSeason(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeasonDivision addSeasonDivision(Season arg0, Division arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeasonDivisionTeam addSeasonDivisionTeam(SeasonDivision arg0, Team arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team addTeam(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeSession() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
