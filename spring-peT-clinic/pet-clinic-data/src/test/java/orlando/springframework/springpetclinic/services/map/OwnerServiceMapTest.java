package orlando.springframework.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import orlando.springframework.springpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId=1L;
    final String lastName="hello";



    @BeforeEach
    void setUp() {
        ownerServiceMap=new OwnerServiceMap(new PetServiceMap(),new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet=ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());

    }

    @Test
    void findById() {
        Owner owner=ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id=2L;
        Owner owner2=Owner.builder().id(id).build();
        Owner savedOwner=ownerServiceMap.save(owner2);
        assertEquals(id,savedOwner.getId());

    }

    @Test
    void saveNoId() {
        Owner savedOwner=ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
        
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteByID(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner3=ownerServiceMap.findByLastName(lastName);
        assertNotNull(owner3);
        assertEquals(ownerId,owner3.getId());
    }
    @Test
    void findByLastNameNotFound() {
        Owner owner3=ownerServiceMap.findByLastName("what");
        assertNull(owner3);

    }
}