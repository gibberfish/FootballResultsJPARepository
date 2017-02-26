package mindbadger.football.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mindbadger.football.domain.Division;
import mindbadger.football.domain.DivisionImpl;

public interface DivisionCrudRepository extends CrudRepository<DivisionImpl, String>{

	@Query("SELECT d FROM DivisionImpl d where d.name = :name")
	public Division findDivisionByName(@Param("name") String name);

}
