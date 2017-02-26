package mindbadger.football.repository;

import org.springframework.data.repository.CrudRepository;

import mindbadger.football.domain.DivisionMappingImpl;
import mindbadger.football.domain.MappingId;

public interface DivisionMappingCrudRepository extends CrudRepository<DivisionMappingImpl, MappingId> {
}
