package orlando.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import orlando.springframework.springpetclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality,Long> {
}
