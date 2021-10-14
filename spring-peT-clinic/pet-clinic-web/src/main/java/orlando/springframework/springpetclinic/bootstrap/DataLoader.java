package orlando.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import orlando.springframework.springpetclinic.model.Owner;
import orlando.springframework.springpetclinic.model.Vet;
import orlando.springframework.springpetclinic.services.OwnerService;
import orlando.springframework.springpetclinic.services.VetService;
import orlando.springframework.springpetclinic.services.map.OwnerServiceMap;
import orlando.springframework.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    public DataLoader() {
        ownerService=new OwnerServiceMap();
        vetService=new VetServiceMap();

    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenane");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ben");
        vet1.setLastName("Afleck");
        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}