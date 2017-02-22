package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.SeasonDivisionTeam;
import mindbadger.footballresultsanalyser.domain.SeasonImpl;
import mindbadger.footballresultsanalyser.domain.Team;
import mindbadger.footballresultsanalyser.repository.AbstractRepository;
import mindbadger.footballresultsanalyser.repository.SeasonRepository;

@Component
public class SeasonRepositoryImpl extends AbstractRepository<Season, Integer> implements SeasonRepository {
	@Autowired
	private SeasonCrudRepository seasonCrudRepository;
	
	@Override
	public void delete(Season season) {
		seasonCrudRepository.delete((SeasonImpl)season);
	}

	@Override
	public Season findOne(Integer seasonId) {
		return seasonCrudRepository.findOne(seasonId);
	}

	@Override
	public Season save(Season season) {
		return seasonCrudRepository.save((SeasonImpl)season);
	}
	
	@Override
	public Iterable<Season> findAll() {
		Iterable<SeasonImpl> allSeasonImpls = seasonCrudRepository.findAll();
		Set<Season> allSeasons = new HashSet<Season> ();
		
		Iterator<SeasonImpl> iterator = allSeasonImpls.iterator();
		
		while (iterator.hasNext()) {
			SeasonImpl seasonImpl = iterator.next();
			allSeasons.add(seasonImpl);
		}
		
		return allSeasons;
	}

	@Override
	public Season findMatching(Season season) {
		return findOne(getIDFor(season));
	}

	@Override
	public SeasonDivision getSeasonDivision(Season season, Division division) {
		Season retrievedSeason = findMatching(season);
		for (SeasonDivision seasonDivision : retrievedSeason.getSeasonDivisions()) {
			if (division.getDivisionId().equals(seasonDivision.getDivision().getDivisionId())) {
				return seasonDivision;
			}
		}
		return null;
	}

	@Override
	public SeasonDivisionTeam getSeasonDivisionTeam(SeasonDivision seasonDivision, Team team) {
		for (SeasonDivisionTeam seasonDivisionTeam : seasonDivision.getSeasonDivisionTeams()) {
			if (team.getTeamId().equals(seasonDivisionTeam.getTeam().getTeamId())) {
				return seasonDivisionTeam;
			}
		}
		return null;
	}

	@Override
	public Integer getIDFor(Season season) {
		return season.getSeasonNumber();
	}

	@Override
	public Season update(Season seasonToUpdate, Season seasonToCopyValuesFrom) {
		seasonToUpdate.setSeasonDivisions(seasonToCopyValuesFrom.getSeasonDivisions());
		return seasonToUpdate;
	}
}
