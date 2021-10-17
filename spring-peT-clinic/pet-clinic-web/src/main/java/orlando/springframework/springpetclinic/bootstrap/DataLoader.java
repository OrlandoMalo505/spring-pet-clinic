package orlando.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import orlando.springframework.springpetclinic.model.*;
import orlando.springframework.springpetclinic.services.OwnerService;
import orlando.springframework.springpetclinic.services.PetTypeService;
import orlando.springframework.springpetclinic.services.SpecialityService;
import orlando.springframework.springpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count=petTypeService.findAll().size();
        if(count==0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("dog");
        PetType savedDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("cat");
        PetType savedCatPetType=petTypeService.save(cat);

        Speciality radiology=new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology=specialityService.save(radiology);

        Speciality surgery=new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery=specialityService.save(surgery);

        Speciality dentistry=new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry=specialityService.save(dentistry);

        Owner owner1=new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Rruga Barrikadave");
        owner1.setCity("Tirane");
        owner1.setTelephone("0686868686868");

        Pet mikePet=new Pet();
        mikePet.setName("haci");
        mikePet.setPetType(savedDogPetType);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setOwner(owner1);
        owner1.getPets().add(mikePet);

        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenane");
        owner2.setAddress("Rruga Antipatrea");
        owner2.setCity("Berat");
        owner2.setTelephone("0778855625");

        Pet fionaPet=new Pet();
        fionaPet.setName("tom");
        fionaPet.setPetType(savedCatPetType);
        fionaPet.setOwner(owner2);
        fionaPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1=new Vet();
        vet1.setFirstName("Ben");
        vet1.setLastName("Afleck");
        vet1.getSpecialities().add(savedRadiology);


        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vet2.getSpecialities().add(savedSurgery);


        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
