package mindbadger.football.repository;

import mindbadger.football.domain.MappingId;
import mindbadger.football.domain.TeamMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import mindbadger.football.domain.TeamMappingImpl;

public interface TeamMappingCrudRepository extends CrudRepository<TeamMappingImpl, MappingId>, JpaRepository<TeamMappingImpl, MappingId> {
}
