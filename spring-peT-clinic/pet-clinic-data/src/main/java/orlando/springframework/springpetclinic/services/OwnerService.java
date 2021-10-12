package orlando.springframework.springpetclinic.services;

import orlando.springframework.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long{

    Owner findByLastName(String lastName);

}
