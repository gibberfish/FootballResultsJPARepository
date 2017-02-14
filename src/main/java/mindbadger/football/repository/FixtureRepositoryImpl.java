package mindbadger.football.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.footballresultsanalyser.domain.Fixture;
import mindbadger.footballresultsanalyser.domain.FixtureImpl;
import mindbadger.footballresultsanalyser.repository.FixtureRepository;

@Component
public class FixtureRepositoryImpl implements FixtureRepository {
	@Autowired
	private FixtureCrudRepository fixtureCrudRepository;
	
	@Override
	public void delete(Fixture fixture) {
		fixtureCrudRepository.delete((FixtureImpl)fixture);
	}

	@Override
	public Fixture findOne(String fixtureId) {
		return fixtureCrudRepository.findOne(fixtureId);
	}

	@Override
	public Fixture save(Fixture fixture) {
		return fixtureCrudRepository.save((FixtureImpl)fixture);
	}

}
