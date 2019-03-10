package mindbadger.football.repository;

import mindbadger.football.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.List;

public interface TeamStatisticCrudRepository extends CrudRepository<TeamStatisticImpl, TeamStatisticId>, JpaRepository<TeamStatisticImpl, TeamStatisticId> {

    @Query("SELECT f FROM TeamStatisticImpl f where f.season = :season and f.division = :division and f.team = :team and f.fixtureDate = :fixtureDate")
    List<TeamStatistic> findTeamStatisticsForSeasonDivisionTeamOnDate (
            @Param("season") Season season,
            @Param("division") Division division,
            @Param("team") Team team,
            @Param("fixtureDate") Calendar fixtureDate);

}
