package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	public Iterable<TrackedDivision> findAll() {
		Iterable<TrackedDivisionImpl> allTrackedDivisionImpls = trackedDivisionCrudRepository.findAll();
		Set<TrackedDivision> allTrackedDivisions = new HashSet<TrackedDivision> ();
		
		Iterator<TrackedDivisionImpl> iterator = allTrackedDivisionImpls.iterator();
		
		while (iterator.hasNext()) {
			TrackedDivisionImpl trackedDivisionImpl = iterator.next();
			allTrackedDivisions.add(trackedDivisionImpl);
		}
		
		return allTrackedDivisions;
	}
	
	@Override
	public TrackedDivision findOne(TrackedDivisionId trackedDivisionId) {
		if (trackedDivisionId == null) return null;
		
//		TrackedDivisionId trackedDivisionId = new TrackedDivisionId ();
//		trackedDivisionId.setDialect(trackedDivisionId.getDialect());
//		trackedDivisionId.setSourceId(trackedDivisionId.getSourceId());
		
		return trackedDivisionCrudRepository.findOne(trackedDivisionId);
	}
	
	@Override
	public TrackedDivision save(TrackedDivision trackedDivision) {
		return trackedDivisionCrudRepository.save((TrackedDivisionImpl)trackedDivision);
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
