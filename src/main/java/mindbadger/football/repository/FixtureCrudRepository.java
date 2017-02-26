package mindbadger.football.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mindbadger.football.domain.Fixture;
import mindbadger.football.domain.FixtureImpl;
import mindbadger.football.domain.Season;
import mindbadger.football.domain.Team;

public interface FixtureCrudRepository extends CrudRepository<FixtureImpl, String>, JpaRepository<FixtureImpl, String> {
	
	@Query("SELECT f FROM FixtureImpl f where f.fixtureDate is null") 
	public List<Fixture> getFixturesWithNoFixtureDate();
	
	@Query("SELECT f FROM FixtureImpl f where f.season = :seasonNumber and f.division = :divisionId") 
	public List<Fixture> getFixturesForDivisionInSeason(@Param("seasonNumber") Integer seasonNumber, @Param("divisionId") String divisionId);
	
	@Query("SELECT f FROM FixtureImpl f where f.season = :seasonNumber and f.division = :divisionId and (f.homeTeam = :teamId or f.awayTeam = :teamId)")
	public List<Fixture> getFixturesForTeamInDivisionInSeason(@Param("seasonNumber") Integer seasonNumber,
			@Param("divisionId") String divisionId,
			@Param("teamId") String teamId);
	
	@Query("SELECT f FROM FixtureImpl f where f.fixtureDate < CURRENT_DATE and f.homeGoals is null") 
	public List<Fixture> getUnplayedFixturesBeforeToday();
	
	@Query("SELECT f FROM FixtureImpl f where f.season = :seasonNumber and f.homeTeam = :homeTeamId and f.awayTeam = :awayTeamId")
	public Fixture getExistingFixture(@Param("seasonNumber") Season season,
		@Param("homeTeamId") Team homeTeamId,
		@Param("awayTeamId") Team awayTeamId);

}
