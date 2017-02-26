package mindbadger.football.repository;

import org.springframework.data.repository.CrudRepository;

import mindbadger.football.domain.MappingId;
import mindbadger.football.domain.TeamMappingImpl;

public interface TeamMappingCrudRepository extends CrudRepository<TeamMappingImpl, MappingId> {
}
