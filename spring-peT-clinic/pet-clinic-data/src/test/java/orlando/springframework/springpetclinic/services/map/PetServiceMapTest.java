package orlando.springframework.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import orlando.springframework.springpetclinic.model.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PetServiceMapTest {

    PetServiceMap petServiceMap;
    final Long id=2L;

    @BeforeEach
    void setUp() {
        petServiceMap=new PetServiceMap();
        Pet pet=new Pet();
        pet.setId(id);
        petServiceMap.save(pet);
    }

    @Test
    void findAll() {
        Set<Pet> petSet=petServiceMap.findAll();
        assertEquals(1,petSet.size());
    }

    @Test
    void findById() {
        Pet pet1=petServiceMap.findById(id);
        assertEquals(id,pet1.getId());
    }

    @Test
    void saveExistingId() {
        Long ID=3L;
        Pet pet2=new Pet();
        pet2.setId(ID);
        Pet savedPet=petServiceMap.save(pet2);
        assertEquals(ID,savedPet.getId());
    }

    @Test
    void saveNoId() {
        Pet savedPet=petServiceMap.save(new Pet());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(id));
        assertEquals(0,petServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(id);
        assertEquals(0,petServiceMap.findAll().size());

    }
}