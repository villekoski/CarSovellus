package hh.swd20.CarSovellus.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.CarSovellus.domain.Car;
import hh.swd20.CarSovellus.domain.CarRepository;
import hh.swd20.CarSovellus.domain.Owner;
import hh.swd20.CarSovellus.domain.OwnerRepository;

@Controller
public class CategoryController {
	@Autowired
	private OwnerRepository ownerRepository;
	
	@RequestMapping("/categorylist")
	 public String categoryList(Model model) {
        model.addAttribute("owner", ownerRepository.findAll());
        return "categorylist";
	}
	  @RequestMapping(value ="/addC")
	    public String addCategory(Model model) {
		  model.addAttribute("owners", ownerRepository.findAll());
		  model.addAttribute("owner", new Owner());
		  return "newcategory";
	}
	  @RequestMapping(value = "/saveC", method = RequestMethod.POST)
	  	public String save(Owner owner) {
		  ownerRepository.save(owner);
		  return "redirect:/";
	  }
}
