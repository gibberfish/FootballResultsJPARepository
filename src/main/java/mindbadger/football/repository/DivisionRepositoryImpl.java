package mindbadger.football.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.DivisionImpl;
import mindbadger.footballresultsanalyser.repository.DivisionRepository;

@Component
public class DivisionRepositoryImpl implements DivisionRepository {
	@Autowired
	private DivisionCrudRepository divisionCrudRepository;

	@Override
	public void delete(Division division) {
		divisionCrudRepository.delete((DivisionImpl)division);
	}

	@Override
	public Division findOne(String divisionId) {
		return divisionCrudRepository.findOne(divisionId);
	}

	@Override
	public Division save(Division division) {
		return divisionCrudRepository.save((DivisionImpl)division);
	}
}
