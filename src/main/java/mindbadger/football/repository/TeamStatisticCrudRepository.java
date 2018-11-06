package mindbadger.football.repository;

import mindbadger.football.domain.SeasonDivisionTeam;
import mindbadger.football.domain.TeamStatistic;
import mindbadger.football.domain.TeamStatisticImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.List;

public interface TeamStatisticCrudRepository extends CrudRepository<TeamStatisticImpl, String> {

    @Query("SELECT f FROM TeamStatisticImpl f where f.seasonDivisionTeam = :seasonDivisionTeam and f.fixtureDate = :fixtureDate")
    List<TeamStatistic> findTeamStatisticsForSeasonDivisionTeamOnDate (
            @Param("seasonDivisionTeam") SeasonDivisionTeam seasonDivisionTeam,
            @Param("fixtureDate") Calendar fixtureDate);

}
