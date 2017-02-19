package mindbadger.football.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mindbadger.footballresultsanalyser.domain.Team;
import mindbadger.footballresultsanalyser.domain.TeamImpl;

public interface TeamCrudRepository extends CrudRepository<TeamImpl, String> {

	@Query("SELECT t FROM TeamImpl t where t.name = :name")
	Team findTeamByName(@Param("name") String name);

}
