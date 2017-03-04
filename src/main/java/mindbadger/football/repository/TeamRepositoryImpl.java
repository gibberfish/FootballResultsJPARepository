package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.football.domain.Team;
import mindbadger.football.domain.TeamImpl;
import mindbadger.football.repository.AbstractTeamRepository;

@Component
public class TeamRepositoryImpl extends AbstractTeamRepository {
	@Autowired
	private TeamCrudRepository teamCrudRepository;

	@Override
	public void delete(Team team) {
		teamCrudRepository.delete((TeamImpl)team);
	}

	@Override
	public Team findOne(String teamId) {
		return (teamId == null ? null : teamCrudRepository.findOne(teamId));
	}

	@Override
	public Team save(Team team) {
		return teamCrudRepository.save((TeamImpl)team);
	}
	
	@Override
	public Iterable<Team> findAll() {
		Iterable<TeamImpl> allTeamImpls = teamCrudRepository.findAll();
		Set<Team> allTeams = new HashSet<Team> ();
		
		Iterator<TeamImpl> iterator = allTeamImpls.iterator();
		
		while (iterator.hasNext()) {
			TeamImpl teamImpl = iterator.next();
			allTeams.add(teamImpl);
		}
		
		return allTeams;
	}

	@Override
	public Team findTeamByName(String name) {
		return teamCrudRepository.findTeamByName(name);
	}
}

