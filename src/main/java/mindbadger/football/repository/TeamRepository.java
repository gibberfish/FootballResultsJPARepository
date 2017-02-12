package mindbadger.football.repository;

import org.springframework.data.repository.CrudRepository;

import mindbadger.footballresultsanalyser.domain.TeamImpl;

public interface TeamRepository extends CrudRepository<TeamImpl, String> {

}
