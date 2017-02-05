package mindbadger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SeasonRepository extends CrudRepository<SeasonImpl, Integer>, JpaRepository<SeasonImpl, Integer>{

}
