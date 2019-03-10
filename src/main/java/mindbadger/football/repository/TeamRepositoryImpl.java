package mindbadger.football.repository;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.football.domain.Team;
import mindbadger.football.domain.TeamImpl;
import mindbadger.football.repository.AbstractTeamRepository;

@Component ("teamRepository")
public class TeamRepositoryImpl extends AbstractTeamRepository {
	@Autowired
	private TeamCrudRepository teamCrudRepository;

	@Override
	public void delete(Team team) {
		teamCrudRepository.delete((TeamImpl) team);
	}

	@Override
	public Team findOne(String teamId) {
		if (teamId == null) return null;
		Optional<TeamImpl> optional = teamCrudRepository.findById(teamId);
		return (optional == null || !optional.isPresent() ? null : optional.get());
	}

	@Override
	public Team save(Team team) {
		return teamCrudRepository.save((TeamImpl) team);
	}

	@Override
	public Team findTeamByName(String name) {
		return teamCrudRepository.findTeamByName(name);
	}

	@Override
	public List<Team> findAll() {
		List<? extends Team> teams = teamCrudRepository.findAll();
		return (List<Team>) teams;
	}

	@Override
	public List<? extends Team> saveAll(List<? extends Team> teams) {
		return teamCrudRepository.saveAll(teams.stream()
				.filter(obj -> obj instanceof TeamImpl)
				.map(obj -> (TeamImpl) obj).collect(Collectors.toList()));
	}
}