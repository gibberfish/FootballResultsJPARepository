package mindbadger.football.repository;

import java.util.*;
import java.util.stream.Collectors;

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
	public TeamMapping findOne(MappingId teamMappingId) {
		if (teamMappingId == null) return null;
		Optional<TeamMappingImpl> optional = teamMappingCrudRepository.findById(teamMappingId);
		return (optional == null || !optional.isPresent() ? null : optional.get());
	}

	@Override
	public TeamMapping save(TeamMapping teamMapping) {
		return teamMappingCrudRepository.save((TeamMappingImpl)teamMapping);
	}


	@Override
	public List<TeamMapping> findAll() {
		List<? extends TeamMapping> teamMappings = teamMappingCrudRepository.findAll();
		return (List<TeamMapping>) teamMappings;
	}

	@Override
	public List<? extends TeamMapping> saveAll(List<? extends TeamMapping> teamMappings) {
		return teamMappingCrudRepository.saveAll(teamMappings.stream()
				.filter(obj -> obj instanceof TeamMappingImpl)
				.map(obj -> (TeamMappingImpl) obj).collect(Collectors.toList()));
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
