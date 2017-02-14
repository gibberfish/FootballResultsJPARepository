package mindbadger.football.repository;

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

}
