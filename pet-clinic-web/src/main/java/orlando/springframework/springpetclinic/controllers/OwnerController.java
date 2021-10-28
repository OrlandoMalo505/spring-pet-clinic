package orlando.springframework.springpetclinic.controllers;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import orlando.springframework.springpetclinic.model.Owner;
import orlando.springframework.springpetclinic.services.OwnerService;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }



    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Model model, Owner owner, BindingResult result){
        if(owner.getLastName()==null){
            owner.setLastName("");
        }

        List<Owner> results=ownerService.findAllByLastNameLike(owner.getLastName());

        if(results.isEmpty()){
            result.rejectValue("lastName","notFound","not found");
            return "owners/findOwners";
        }
        else if(results.size()==1){
            owner=results.iterator().next();
            return "redirect:/owners/"+owner.getId();
        }
        else{
            model.addAttribute("selections",results);
            return "owners/ownersList";
        }


    }


    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
        ModelAndView mav=new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

}
