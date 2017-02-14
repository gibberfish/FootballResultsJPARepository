package mindbadger.football.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mindbadger.footballresultsanalyser.domain.Team;
import mindbadger.footballresultsanalyser.domain.TeamImpl;
import mindbadger.footballresultsanalyser.repository.TeamRepository;

@Component
public class TeamRepositoryImpl implements TeamRepository {
	@Autowired
	private TeamCrudRepository teamCrudRepository;

	@Override
	public void delete(Team team) {
		teamCrudRepository.delete((TeamImpl)team);
	}

	@Override
	public Team findOne(String teamId) {
		return teamCrudRepository.findOne(teamId);
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
}
