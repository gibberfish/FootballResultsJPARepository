package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

	@Override
	public Iterable<Division> findAll() {
		Iterable<DivisionImpl> allDivisionImpls = divisionCrudRepository.findAll();
		Set<Division> allDivisions = new HashSet<Division> ();
		
		Iterator<DivisionImpl> iterator = allDivisionImpls.iterator();
		
		while (iterator.hasNext()) {
			DivisionImpl divisionImpl = iterator.next();
			allDivisions.add(divisionImpl);
		}
		
		return allDivisions;
	}
}
