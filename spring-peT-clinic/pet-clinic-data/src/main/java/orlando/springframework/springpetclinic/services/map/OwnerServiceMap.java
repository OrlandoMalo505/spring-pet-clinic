package orlando.springframework.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import orlando.springframework.springpetclinic.model.Owner;
import orlando.springframework.springpetclinic.model.Pet;
import orlando.springframework.springpetclinic.services.OwnerService;
import orlando.springframework.springpetclinic.services.PetService;
import orlando.springframework.springpetclinic.services.PetTypeService;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if(object.getPets()!=null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType()!=null){
                        if(pet.getPetType().getId()==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                        if(pet.getId()==null){
                            Pet savedPet=petService.save(pet);
                            pet.setId(savedPet.getId());
                        }
                    }
                    else{
                        throw new RuntimeException("PetType is required.");
                    }
                });
            }

            return super.save(object);
        }
        else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteByID(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
