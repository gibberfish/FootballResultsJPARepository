package mindbadger.football.repository;

import java.util.*;
import java.util.stream.Collectors;

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
		if (fixtureId == null) return null;
		Optional<FixtureImpl> optional = fixtureCrudRepository.findById(fixtureId);
		return (optional == null || !optional.isPresent() ? null : optional.get());
	}

	@Override
	public Fixture save(Fixture fixture) {
		return fixtureCrudRepository.save((FixtureImpl)fixture);
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

	@Override
	public List<Fixture> findAll() {
		List<? extends Fixture> divisions = fixtureCrudRepository.findAll();
		return (List<Fixture>) divisions;
	}

	@Override
	public List<? extends Fixture> saveAll(List<? extends Fixture> divisions) {
		return fixtureCrudRepository.saveAll(divisions.stream()
				.filter(obj -> obj instanceof FixtureImpl)
				.map(obj -> (FixtureImpl) obj).collect(Collectors.toList()));
	}
}
