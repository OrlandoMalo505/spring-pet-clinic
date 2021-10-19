package orlando.springframework.springpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import orlando.springframework.springpetclinic.model.Speciality;
import orlando.springframework.springpetclinic.services.SpecialityService;

import java.util.Set;
@Service
@Profile({"default","map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality,Long> implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteByID(id);

    }
}
