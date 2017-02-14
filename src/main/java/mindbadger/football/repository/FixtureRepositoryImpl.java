package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

	@Override
	public Iterable<Fixture> findAll() {
		Iterable<FixtureImpl> allFixtureImpls = fixtureCrudRepository.findAll();
		Set<Fixture> allFixtures = new HashSet<Fixture> ();
		
		Iterator<FixtureImpl> iterator = allFixtureImpls.iterator();
		
		while (iterator.hasNext()) {
			FixtureImpl fixtureImpl = iterator.next();
			allFixtures.add(fixtureImpl);
		}
		
		return allFixtures;
	}
}
