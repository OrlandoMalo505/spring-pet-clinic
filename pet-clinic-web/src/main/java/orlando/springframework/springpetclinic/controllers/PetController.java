package orlando.springframework.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import orlando.springframework.springpetclinic.model.Owner;
import orlando.springframework.springpetclinic.model.PetType;
import orlando.springframework.springpetclinic.services.OwnerService;
import orlando.springframework.springpetclinic.services.PetService;
import orlando.springframework.springpetclinic.services.PetTypeService;

import java.util.Collection;

@RequestMapping("/owners/{ownerId}")
@Controller
public class PetController {
    private final PetService petService;
    private final OwnerService ownerService;
    private  final PetTypeService petTypeService;
    private static final String VIEWS_PET_CREATE_OR_UPDATE_FORM="pets/createOrUpdatePetForm";

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }
    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId){
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }


}
