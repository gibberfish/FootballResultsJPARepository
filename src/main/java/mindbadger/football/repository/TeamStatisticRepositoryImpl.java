package mindbadger.football.repository;

import mindbadger.football.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component ("teamStatisticRepository")
public class TeamStatisticRepositoryImpl extends AbstractTeamStatisticRepository {
    @Autowired
    TeamStatisticCrudRepository teamStatisticCrudRepository;

    @Override
    public List<TeamStatistic> findTeamStatisticsForSeasonDivisionTeamOnDate(SeasonDivisionTeam seasonDivisionTeam, Calendar fixtureDate) {
        return teamStatisticCrudRepository.findTeamStatisticsForSeasonDivisionTeamOnDate(
                seasonDivisionTeam.getSeasonDivision().getSeason(),
                seasonDivisionTeam.getSeasonDivision().getDivision(),
                seasonDivisionTeam.getTeam(),
                fixtureDate);
    }

    @Override
    public TeamStatistic save(TeamStatistic teamStatistic) {
        return teamStatisticCrudRepository.save((TeamStatisticImpl)teamStatistic);
    }

    @Override
    public TeamStatistic findOne(TeamStatisticId teamStatisticId) {

        if (teamStatisticId == null) return null;
        Optional<TeamStatisticImpl> optional = teamStatisticCrudRepository.findById(teamStatisticId);

        System.out.println(">>>>>>>>>>>>>> SEASON: " + teamStatisticId.getSeason());
        System.out.println(">>>>>>>>>>>>>> DIVISION: " + teamStatisticId.getDivision());
        System.out.println(">>>>>>>>>>>>>> TEAM: " + teamStatisticId.getTeam());
        System.out.println(">>>>>>>>>>>>>> FIXTURE DATE: " + teamStatisticId.getFixtureDate());
        System.out.println(">>>>>>>>>>>>>> STAT: " + teamStatisticId.getStatistic());

        return (optional == null || !optional.isPresent() ? null : optional.get());
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

    @Override
    public TeamStatisticId getIDFor(TeamStatistic teamStatistic) {
        SeasonDivisionId seasonDivisionId = new SeasonDivisionId(
                teamStatistic.getSeason().getSeasonNumber(),
                teamStatistic.getDivision().getDivisionId()
                );

        SeasonDivisionTeamId seasonDivisionTeamId = new SeasonDivisionTeamId(
                seasonDivisionId,
                teamStatistic.getTeam().getTeamId()
                );

        return new TeamStatisticId(seasonDivisionTeamId.getSeasonDivision().getSeason(),
                seasonDivisionTeamId.getSeasonDivision().getDivision(),
                seasonDivisionTeamId.getTeam(),
                teamStatistic.getFixtureDate(),
                teamStatistic.getStatistic());
    }
}
