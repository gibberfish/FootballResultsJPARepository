package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.football.domain.DivisionMapping;
import mindbadger.football.domain.DivisionMappingImpl;
import mindbadger.football.domain.MappingId;

@Component
public class DivisionMappingRepositoryImpl implements DivisionMappingRepository {
	@Autowired
	private DivisionMappingCrudRepository divisionMappingCrudRepository;

	@Override
	public void delete(DivisionMapping divisionMapping) {
		divisionMappingCrudRepository.delete((DivisionMappingImpl)divisionMapping);
	}

	@Override
	public Iterable<DivisionMapping> findAll() {
		Iterable<DivisionMappingImpl> allDivisionMappingImpls = divisionMappingCrudRepository.findAll();
		Set<DivisionMapping> allDivisionMappings = new HashSet<DivisionMapping> ();
		
		Iterator<DivisionMappingImpl> iterator = allDivisionMappingImpls.iterator();
		
		while (iterator.hasNext()) {
			DivisionMappingImpl divisionMappingImpl = iterator.next();
			allDivisionMappings.add(divisionMappingImpl);
		}
		
		return allDivisionMappings;
	}

	@Override
	public DivisionMapping findOne(DivisionMapping divisionMapping) {
		MappingId mappingId = new MappingId ();
		mappingId.setDialect(divisionMapping.getDialect());
		mappingId.setSourceId(divisionMapping.getSourceId());
		mappingId.setFraId(divisionMapping.getFraId());
		
		return divisionMappingCrudRepository.findOne(mappingId);
	}

	@Override
	public DivisionMapping save(DivisionMapping divisionMapping) {
		return divisionMappingCrudRepository.save((DivisionMappingImpl)divisionMapping);
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
