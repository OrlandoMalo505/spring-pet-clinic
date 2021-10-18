package orlando.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import orlando.springframework.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
