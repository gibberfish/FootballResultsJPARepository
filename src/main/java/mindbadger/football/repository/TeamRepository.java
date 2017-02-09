package mindbadger.football.repository;

import org.springframework.data.repository.CrudRepository;

import mindbadger.football.model.TeamImpl;

public interface TeamRepository extends CrudRepository<TeamImpl, String> {

}
