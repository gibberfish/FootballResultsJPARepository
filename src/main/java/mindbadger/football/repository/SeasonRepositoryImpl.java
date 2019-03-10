package mindbadger.football.repository;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import mindbadger.football.domain.Season;
import mindbadger.football.domain.SeasonImpl;
import mindbadger.football.repository.AbstractSeasonRepository;

@Component ("seasonRepository")
public class SeasonRepositoryImpl extends AbstractSeasonRepository {
	@Autowired
	private SeasonCrudRepository seasonCrudRepository;
	
	@Override
	public void delete(Season season) {
		seasonCrudRepository.delete((SeasonImpl)season);
	}

	@Override
	public Season findOne(Integer seasonId) {
		if (seasonId == null) return null;
		Optional<SeasonImpl> optional = seasonCrudRepository.findById(seasonId);
		return (optional == null || !optional.isPresent() ? null : optional.get());
	}

	@Override
	public Season save(Season season) {
		return seasonCrudRepository.save((SeasonImpl)season);
	}

	@Override
	public List<Season> findAll() {
		List<? extends Season> seasons = seasonCrudRepository.findAll();
		return (List<Season>) seasons;
	}

	@Override
	public List<? extends Season> saveAll(List<? extends Season> seasons) {
		return seasonCrudRepository.saveAll(seasons.stream()
				.filter(obj -> obj instanceof SeasonImpl)
				.map(obj -> (SeasonImpl) obj).collect(Collectors.toList()));
	}
}
