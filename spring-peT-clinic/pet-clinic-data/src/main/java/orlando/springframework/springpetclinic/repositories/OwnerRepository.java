package orlando.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import orlando.springframework.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

}
