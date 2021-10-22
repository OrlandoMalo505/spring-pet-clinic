package orlando.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import orlando.springframework.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
