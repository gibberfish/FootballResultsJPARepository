package mindbadger.football.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mindbadger.football.domain.Division;
import mindbadger.football.domain.Fixture;
import mindbadger.football.domain.FixtureImpl;
import mindbadger.football.domain.Season;
import mindbadger.football.domain.Team;

public interface FixtureCrudRepository extends CrudRepository<FixtureImpl, String>, JpaRepository<FixtureImpl, String> {
	
	@Query("SELECT f FROM FixtureImpl f where f.fixtureDate is null") 
	public List<Fixture> getFixturesWithNoFixtureDate();
	
	@Query("SELECT f FROM FixtureImpl f where f.season = :season and f.division = :division") 
	public List<Fixture> getFixturesForDivisionInSeason(@Param("season") Season season,
			@Param("division") Division divisionIdd);
	
	@Query("SELECT f FROM FixtureImpl f where f.season = :season and f.division = :division and (f.homeTeam = :team or f.awayTeam = :team)")
	public List<Fixture> getFixturesForTeamInDivisionInSeason(@Param("season") Season season,
			@Param("division") Division divisionId,
			@Param("team") Team teamId);
	
	@Query("SELECT f FROM FixtureImpl f where f.fixtureDate < CURRENT_DATE and f.homeGoals is null") 
	public List<Fixture> getUnplayedFixturesBeforeToday();
	
	@Query("SELECT f FROM FixtureImpl f where f.season = :season and f.homeTeam = :homeTeam and f.awayTeam = :awayTeam")
	public Fixture getExistingFixture(@Param("season") Season season,
		@Param("homeTeam") Team homeTeamId,
		@Param("awayTeam") Team awayTeamId);

	@Query("SELECT f FROM FixtureImpl f where f.fixtureDate = :fixtureDate and f.homeGoals is null")
	public List<Fixture> getUnplayedFixturesOnDate(@Param("fixtureDate") Calendar fixtureDate);
}
