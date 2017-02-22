package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.DivisionImpl;
import mindbadger.footballresultsanalyser.repository.AbstractRepository;
import mindbadger.footballresultsanalyser.repository.DivisionRepository;

@Component
public class DivisionRepositoryImpl extends AbstractRepository<Division, String> implements DivisionRepository {
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

	@Override
	public Division findDivisionByName(String name) {
		return divisionCrudRepository.findDivisionByName (name);
	}

	@Override
	public Division findMatching(Division division) {
		return findDivisionByName(division.getDivisionName());
	}

	@Override
	public String getIDFor(Division division) {
		return division.getDivisionId();
	}

	@Override
	public Division update(Division divisionToUpdate, Division divisionToCopyValuesFrom) {
		divisionToUpdate.setDivisionName(divisionToCopyValuesFrom.getDivisionName());
		return divisionToUpdate;
	}
}
