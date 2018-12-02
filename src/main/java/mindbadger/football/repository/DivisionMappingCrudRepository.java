package mindbadger.football.repository;

import mindbadger.football.domain.MappingId;
import org.springframework.data.repository.CrudRepository;

import mindbadger.football.domain.DivisionMappingImpl;

public interface DivisionMappingCrudRepository extends CrudRepository<DivisionMappingImpl, MappingId> {
}
