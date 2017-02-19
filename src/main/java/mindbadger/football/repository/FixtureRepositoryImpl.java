package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.footballresultsanalyser.domain.Fixture;
import mindbadger.footballresultsanalyser.domain.FixtureImpl;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.Team;
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

	@Override
	public List<Fixture> getFixturesWithNoFixtureDate() {
		return fixtureCrudRepository.getFixturesWithNoFixtureDate();
	}

	@Override
	public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision) {
		return fixtureCrudRepository.getFixturesForDivisionInSeason(seasonDivision.getSeason().getSeasonNumber(),
				seasonDivision.getDivision().getDivisionId());
	}

	@Override
	public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team) {
		return fixtureCrudRepository.getFixturesForTeamInDivisionInSeason(seasonDivision.getSeason().getSeasonNumber(),
				seasonDivision.getDivision().getDivisionId(),
				team.getTeamId());
	}

	@Override
	public List<Fixture> getUnplayedFixturesBeforeToday() {
		return fixtureCrudRepository.getUnplayedFixturesBeforeToday();
	}

	@Override
	public Fixture getExistingFixture(Season season, Team homeTeam, Team awayTeam) {
		return fixtureCrudRepository.getExistingFixture(season,	homeTeam, awayTeam);

	}

	@Override
	public Fixture findMatching(Fixture fixture) {
		return getExistingFixture(fixture.getSeason(), fixture.getHomeTeam(), fixture.getAwayTeam());
	}
}
