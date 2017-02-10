package mindbadger.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import mindbadger.football.model.FixtureImpl;

public interface FixtureRepository extends CrudRepository<FixtureImpl, Integer>, JpaRepository<FixtureImpl, Integer> {

}
