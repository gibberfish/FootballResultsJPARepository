package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonImpl;
import mindbadger.footballresultsanalyser.repository.SeasonRepository;

@Component
public class SeasonRepositoryImpl implements SeasonRepository {
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
}
