package mindbadger.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import mindbadger.footballresultsanalyser.domain.FixtureImpl;

public interface FixtureCrudRepository extends CrudRepository<FixtureImpl, String>, JpaRepository<FixtureImpl, String> {

}
