package mindbadger.football.repository;

import java.util.Calendar;
import java.util.List;

import mindbadger.football.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FixtureCrudRepository extends CrudRepository<FixtureImpl, String>, JpaRepository<FixtureImpl, String> {
	
	@Query("SELECT f FROM FixtureImpl f where f.fixtureDate is null") 
	public List<Fixture> getFixturesWithNoFixtureDate();
	
	@Query("SELECT f FROM FixtureImpl f where f.seasonDivision = :seasonDivision")
	public List<Fixture> getFixturesForDivisionInSeason(@Param("seasonDivision") SeasonDivision season);
	
	@Query("SELECT f FROM FixtureImpl f where f.seasonDivision = :seasonDivision and (f.homeTeam = :team or f.awayTeam = :team)")
	public List<Fixture> getFixturesForTeamInDivisionInSeason(@Param("seasonDivision") SeasonDivision seasonDivision,
			@Param("team") Team teamId);
	
	@Query("SELECT f FROM FixtureImpl f where f.fixtureDate < CURRENT_DATE and f.homeGoals is null") 
	public List<Fixture> getUnplayedFixturesBeforeToday();
	
	@Query("SELECT f FROM FixtureImpl f where f.seasonDivision = :seasonDivision and f.homeTeam = :homeTeam and f.awayTeam = :awayTeam")
	public Fixture getExistingFixture(@Param("season") SeasonDivision seasonDivision,
		@Param("homeTeam") Team homeTeamId,
		@Param("awayTeam") Team awayTeamId);

	@Query("SELECT f FROM FixtureImpl f where f.fixtureDate = :fixtureDate and f.homeGoals is null")
	public List<Fixture> getUnplayedFixturesOnDate(@Param("fixtureDate") Calendar fixtureDate);

	@Query("SELECT f FROM FixtureImpl f where f.seasonDivision = :seasonDivision and f.fixtureDate = :fixtureDate")
	List<Fixture> getFixturesForDivisionInSeasonOnDate(@Param("seasonDivision") SeasonDivision seasonDivision,
													   @Param("fixtureDate") Calendar fixtureDate);

	@Query("SELECT distinct f.fixtureDate FROM FixtureImpl f where f.seasonDivision = :seasonDivision ORDER BY f.fixtureDate")
	List<Calendar> getFixtureDatesForDivisionInSeason(@Param("seasonDivision") SeasonDivision seasonDivision);
}
