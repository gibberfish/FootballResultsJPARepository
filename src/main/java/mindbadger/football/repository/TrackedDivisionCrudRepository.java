package mindbadger.football.repository;

import org.springframework.data.repository.CrudRepository;

import mindbadger.football.domain.TrackedDivisionId;
import mindbadger.football.domain.TrackedDivisionImpl;

public interface TrackedDivisionCrudRepository extends CrudRepository<TrackedDivisionImpl, TrackedDivisionId> {
}
