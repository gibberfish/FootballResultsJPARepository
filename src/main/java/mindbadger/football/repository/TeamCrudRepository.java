package mindbadger.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mindbadger.football.domain.Team;
import mindbadger.football.domain.TeamImpl;

public interface TeamCrudRepository extends CrudRepository<TeamImpl, String>, JpaRepository<TeamImpl, String> {

	@Query("SELECT t FROM TeamImpl t where t.name = :name")
	Team findTeamByName(@Param("name") String name);

}
