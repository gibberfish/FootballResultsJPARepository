package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.football.domain.Division;
import mindbadger.football.domain.DivisionImpl;
import mindbadger.football.repository.AbstractDivisionRepository;

@Component ("divisionRepository")
public class DivisionRepositoryImpl extends AbstractDivisionRepository {
	@Autowired
	private DivisionCrudRepository divisionCrudRepository;

	@Override
	public void delete(Division division) {
		divisionCrudRepository.delete((DivisionImpl)division);
	}

	@Override
	public Division findOne(String divisionId) {
		return (divisionId == null ? null : divisionCrudRepository.findOne(divisionId));
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
}
