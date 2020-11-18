package hh.swd20.CarSovellus.webcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.CarSovellus.domain.Car;
import hh.swd20.CarSovellus.domain.CarRepository;
import hh.swd20.CarSovellus.domain.Owner;
import hh.swd20.CarSovellus.domain.OwnerRepository;

@Controller
public class OwnerController {
	@Autowired
	private OwnerRepository ownerRepository;
	
	@RequestMapping("/ownerlist")
	 public String ownerList(Model model) {
        model.addAttribute("owner", ownerRepository.findAll());
        return "ownerlist";
	}
	  @RequestMapping(value ="/addO")
	    public String addOwner(Model model) {
		  model.addAttribute("owners", ownerRepository.findAll());
		  model.addAttribute("owner", new Owner());
		  return "newowner";
	}
	  @RequestMapping(value = "/saveO", method = RequestMethod.POST)
	  	public String save(@Valid Owner owner, BindingResult bindingResult, Model model) {
		  model.addAttribute("owners", ownerRepository.findAll());
		  if (bindingResult.hasErrors()) {
	    		return "newowner";
	    	}else{
	    		ownerRepository.save(owner);
	    		 return "redirect:/";
	    	}
		
	  }
}
