package mindbadger.football.repository;

import mindbadger.football.domain.TrackedDivisionId;
import org.springframework.data.repository.CrudRepository;

import mindbadger.football.domain.TrackedDivisionImpl;

public interface TrackedDivisionCrudRepository extends CrudRepository<TrackedDivisionImpl, TrackedDivisionId> {
}
