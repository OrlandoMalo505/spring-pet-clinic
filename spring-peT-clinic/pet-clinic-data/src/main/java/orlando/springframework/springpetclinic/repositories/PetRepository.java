package orlando.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import orlando.springframework.springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
