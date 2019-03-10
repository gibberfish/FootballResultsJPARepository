package mindbadger.football.repository;

import java.util.*;
import java.util.stream.Collectors;

import mindbadger.football.domain.TrackedDivisionId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.football.domain.TrackedDivision;
import mindbadger.football.domain.TrackedDivisionImpl;

@Component
public class TrackedDivisionRepositoryImpl implements TrackedDivisionRepository {

	@Autowired
	private TrackedDivisionCrudRepository trackedDivisionCrudRepository;
	
	@Override
	public void delete(TrackedDivision trackedDivision) {
		trackedDivisionCrudRepository.delete((TrackedDivisionImpl)trackedDivision);
	}
	
	@Override
	public TrackedDivision findOne(TrackedDivisionId trackedDivisionId) {
		if (trackedDivisionId == null) return null;
		Optional<TrackedDivisionImpl> optional = trackedDivisionCrudRepository.findById(trackedDivisionId);
		return (optional == null || !optional.isPresent() ? null : optional.get());
	}

	@Override
	public TrackedDivision save(TrackedDivision trackedDivision) {
		return trackedDivisionCrudRepository.save((TrackedDivisionImpl)trackedDivision);
	}

	@Override
	public List<TrackedDivision> findAll() {
		List<? extends TrackedDivision> divisions = trackedDivisionCrudRepository.findAll();
		return (List<TrackedDivision>) divisions;
	}

	@Override
	public List<? extends TrackedDivision> saveAll(List<? extends TrackedDivision> divisions) {
		return trackedDivisionCrudRepository.saveAll(divisions.stream()
				.filter(obj -> obj instanceof TrackedDivisionImpl)
				.map(obj -> (TrackedDivisionImpl) obj).collect(Collectors.toList()));
	}

	/* vvvvvvvvvvvvvvvvvvvvvv NOT IMPLEMENTED vvvvvvvvvvvvvvvvvvvvv */

	@Override
	public TrackedDivision createOrUpdate(TrackedDivision trackedDivision) {
		throw new RuntimeException("This method is not implemented for TrackedDivisions");
	}

	@Override
	public TrackedDivision findMatching(TrackedDivision arg0) {
		throw new RuntimeException("This method is not implemented for TrackedDivisions");
	}
}
