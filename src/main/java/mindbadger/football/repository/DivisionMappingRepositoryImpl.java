package mindbadger.football.repository;

import java.util.*;
import java.util.stream.Collectors;

import mindbadger.football.domain.MappingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.football.domain.DivisionMapping;
import mindbadger.football.domain.DivisionMappingImpl;

@Component
public class DivisionMappingRepositoryImpl implements DivisionMappingRepository {
	@Autowired
	private DivisionMappingCrudRepository divisionMappingCrudRepository;

	@Override
	public void delete(DivisionMapping divisionMapping) {
		divisionMappingCrudRepository.delete((DivisionMappingImpl)divisionMapping);
	}

	@Override
	public DivisionMapping findOne(MappingId divisionMappingId) {
		if (divisionMappingId == null) return null;
		Optional<DivisionMappingImpl> optional = divisionMappingCrudRepository.findById(divisionMappingId);
		return (optional == null || !optional.isPresent() ? null : optional.get());
	}

	@Override
	public DivisionMapping save(DivisionMapping divisionMapping) {
		return divisionMappingCrudRepository.save((DivisionMappingImpl)divisionMapping);
	}

	@Override
	public List<DivisionMapping> findAll() {
		List<? extends DivisionMapping> divisionMappings = divisionMappingCrudRepository.findAll();
		return (List<DivisionMapping>) divisionMappings;
	}

	@Override
	public List<? extends DivisionMapping> saveAll(List<? extends DivisionMapping> divisionMappings) {
		return divisionMappingCrudRepository.saveAll(divisionMappings.stream()
				.filter(obj -> obj instanceof DivisionMappingImpl)
				.map(obj -> (DivisionMappingImpl) obj).collect(Collectors.toList()));
	}

	/* vvvvvvvvvvvvvvvvvvvvvv NOT IMPLEMENTED vvvvvvvvvvvvvvvvvvvvv */
	
	@Override
	public DivisionMapping findMatching(DivisionMapping divisionMapping) {
		throw new RuntimeException("This method is not implemented for DivisionMappings");
	}
	
	@Override
	public DivisionMapping createOrUpdate(DivisionMapping divisionMapping) {
		throw new RuntimeException("This method is not implemented for DivisionMappings");
	}
}
