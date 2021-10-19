package orlando.springframework.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import orlando.springframework.springpetclinic.model.PetType;
import orlando.springframework.springpetclinic.services.PetTypeService;

import java.util.Set;
@Service
public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteByID(id);

    }
}
