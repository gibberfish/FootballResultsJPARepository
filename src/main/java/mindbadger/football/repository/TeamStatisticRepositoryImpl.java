package mindbadger.football.repository;

import mindbadger.football.domain.SeasonDivisionTeam;
import mindbadger.football.domain.TeamStatistic;
import mindbadger.football.domain.TeamStatisticImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TeamStatisticRepositoryImpl extends AbstractTeamStatisticRepository {
    @Autowired
    TeamStatisticCrudRepository teamStatisticCrudRepository;

    @Override
    public List<TeamStatistic> findTeamStatisticsForSeasonDivisionTeamOnDate(SeasonDivisionTeam seasonDivisionTeam, Calendar fixtureDate) {
        return teamStatisticCrudRepository.findTeamStatisticsForSeasonDivisionTeamOnDate(seasonDivisionTeam, fixtureDate);
    }

    @Override
    public TeamStatistic save(TeamStatistic teamStatistic) {
        return teamStatisticCrudRepository.save((TeamStatisticImpl)teamStatistic);
    }

    @Override
    public TeamStatistic findOne(String teamStatisticId) {
        return (teamStatisticId == null ? null : teamStatisticCrudRepository.findOne(teamStatisticId));
    }

    @Override
    public void delete(TeamStatistic teamStatistic) {
        teamStatisticCrudRepository.delete((TeamStatisticImpl) teamStatistic);
    }

    @Override
    public Iterable<TeamStatistic> findAll() {
            Iterable<TeamStatisticImpl> allTeamStatisticImpls = teamStatisticCrudRepository.findAll();
            Set<TeamStatistic> allTeamStatistics = new HashSet<>();

            Iterator<TeamStatisticImpl> iterator = allTeamStatisticImpls.iterator();

            while (iterator.hasNext()) {
                TeamStatisticImpl teamStatisticImpl = iterator.next();
                allTeamStatistics.add(teamStatisticImpl);
            }

            return allTeamStatistics;
    }
}
