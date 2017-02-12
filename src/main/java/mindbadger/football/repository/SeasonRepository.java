package mindbadger.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import mindbadger.footballresultsanalyser.domain.SeasonImpl;

public interface SeasonRepository extends CrudRepository<SeasonImpl, Integer>, JpaRepository<SeasonImpl, Integer>{

}
