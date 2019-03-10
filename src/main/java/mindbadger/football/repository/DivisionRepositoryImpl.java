package mindbadger.football.repository;

import java.util.*;
import java.util.stream.Collectors;

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
		if (divisionId == null) return null;
		Optional<DivisionImpl> divisionOptional = divisionCrudRepository.findById(divisionId);
		return (divisionOptional == null || !divisionOptional.isPresent() ? null : divisionOptional.get());
	}

	@Override
	public Division save(Division division) {
		return divisionCrudRepository.save((DivisionImpl)division);
	}

	@Override
	public Division findDivisionByName(String name) {
		return divisionCrudRepository.findDivisionByName (name);
	}

	@Override
	public List<Division> findAll() {
		List<? extends Division> divisions = divisionCrudRepository.findAll();
		return (List<Division>) divisions;
	}

	@Override
	public List<? extends Division> saveAll(List<? extends Division> divisions) {
		return divisionCrudRepository.saveAll(divisions.stream()
				.filter(obj -> obj instanceof DivisionImpl)
				.map(obj -> (DivisionImpl) obj).collect(Collectors.toList()));
	}
}
