package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import mindbadger.football.domain.MappingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.football.domain.TeamMapping;
import mindbadger.football.domain.TeamMappingImpl;

@Component
public class TeamMappingRepositoryImpl implements TeamMappingRepository {
	@Autowired
	private TeamMappingCrudRepository teamMappingCrudRepository;

	@Override
	public void delete(TeamMapping teamMapping) {
		teamMappingCrudRepository.delete((TeamMappingImpl)teamMapping);
	}

	@Override
	public Iterable<TeamMapping> findAll() {
		Iterable<TeamMappingImpl> allTeamMappingImpls = teamMappingCrudRepository.findAll();
		Set<TeamMapping> allTeamMappings = new HashSet<TeamMapping> ();
		
		Iterator<TeamMappingImpl> iterator = allTeamMappingImpls.iterator();
		
		while (iterator.hasNext()) {
			TeamMappingImpl teamMappingImpl = iterator.next();
			allTeamMappings.add(teamMappingImpl);
		}
		
		return allTeamMappings;
	}

	@Override
	public TeamMapping findOne(MappingId teamMappingId) {
		if (teamMappingId == null) return null;
		Optional<TeamMappingImpl> optional = teamMappingCrudRepository.findById(teamMappingId);
		return (optional == null || !optional.isPresent() ? null : optional.get());
	}

	@Override
	public TeamMapping save(TeamMapping teamMapping) {
		return teamMappingCrudRepository.save((TeamMappingImpl)teamMapping);
	}

	/* vvvvvvvvvvvvvvvvvvvvvv NOT IMPLEMENTED vvvvvvvvvvvvvvvvvvvvv */
	
	@Override
	public TeamMapping createOrUpdate(TeamMapping teamMapping) {
		throw new RuntimeException("This method is not implemented for TeamMappings");
	}
	
	@Override
	public TeamMapping findMatching(TeamMapping teamMapping) {
		throw new RuntimeException("This method is not implemented for TeamMappings");
	}
	
}
