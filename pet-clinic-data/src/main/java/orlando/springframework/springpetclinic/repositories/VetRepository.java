package orlando.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import orlando.springframework.springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
