package mindbadger.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import mindbadger.football.domain.SeasonImpl;

public interface SeasonCrudRepository extends CrudRepository<SeasonImpl, Integer>, JpaRepository<SeasonImpl, Integer>{

}
