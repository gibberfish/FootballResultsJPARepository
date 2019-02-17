package mindbadger.football.repository;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.football.domain.Fixture;
import mindbadger.football.domain.FixtureImpl;
import mindbadger.football.domain.Season;
import mindbadger.football.domain.SeasonDivision;
import mindbadger.football.domain.Team;

@Component ("fixtureRepository")
public class FixtureRepositoryImpl extends AbstractFixtureRepository {
	@Autowired
	private FixtureCrudRepository fixtureCrudRepository;
	
	@Override
	public void delete(Fixture fixture) {
		fixtureCrudRepository.delete((FixtureImpl)fixture);
	}

	@Override
	public Fixture findOne(String fixtureId) {
		return (fixtureId == null ? null : fixtureCrudRepository.findById(fixtureId).get());
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

	@Override
	public List<Fixture> getFixturesWithNoFixtureDate() {
		return fixtureCrudRepository.getFixturesWithNoFixtureDate();
	}

	@Override
	public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision) {
		return fixtureCrudRepository.getFixturesForDivisionInSeason(seasonDivision);
	}

	@Override
	public List<Fixture> getFixturesForDivisionInSeasonOnDate(SeasonDivision seasonDivision, Calendar fixtureDate) {
		return fixtureCrudRepository.getFixturesForDivisionInSeasonOnDate(seasonDivision, fixtureDate);
	}

	@Override
	public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team) {
		return fixtureCrudRepository.getFixturesForTeamInDivisionInSeason(seasonDivision, team);
	}

	@Override
	public List<Fixture> getUnplayedFixturesBeforeToday() {
		return fixtureCrudRepository.getUnplayedFixturesBeforeToday();
	}

	@Override
	public Fixture getExistingFixture(SeasonDivision seasonDivision, Team homeTeam, Team awayTeam) {
		return fixtureCrudRepository.getExistingFixture(seasonDivision,	homeTeam, awayTeam);
	}

	@Override
	public List<Fixture> getUnplayedFixturesOnDate(Calendar fixtureDate) {
		return fixtureCrudRepository.getUnplayedFixturesOnDate(fixtureDate);
	}

	@Override
	public List<Calendar> getFixtureDatesForDivisionInSeason(SeasonDivision seasonDivision) {
		return fixtureCrudRepository.getFixtureDatesForDivisionInSeason(seasonDivision);
	}


}
