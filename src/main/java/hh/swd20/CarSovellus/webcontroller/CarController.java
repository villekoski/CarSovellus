package hh.swd20.CarSovellus.webcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.CarSovellus.domain.Car;
import hh.swd20.CarSovellus.domain.CarRepository;
import hh.swd20.CarSovellus.domain.Owner;
import hh.swd20.CarSovellus.domain.OwnerRepository;
@CrossOrigin
@Controller

public class CarController {
	
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    

    @RequestMapping(value="/cars", method = RequestMethod.GET)
    public @ResponseBody List<Car> carListRest() {	
        return (List<Car>) carRepository.findAll();
    }    

    @RequestMapping(value="/cars/{carid}", method = RequestMethod.GET)
    public @ResponseBody Optional<Car> findCarRest(@PathVariable("id") Long carid) {	
    	return carRepository.findById(carid);
    }   
    @RequestMapping(value="/cars", method = RequestMethod.POST)
    public @ResponseBody Car saveCarRest(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @RequestMapping("/")
    public String carList(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "carlist";
    }
    @RequestMapping(value ="/add")
    public String addCar(Model model,  Car car) {
    	   model.addAttribute("owner", ownerRepository.findAll());
        model.addAttribute("car", new Car());
        return "addcar";
    }
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@Valid Car car, BindingResult bindingResult, Model model) {
    	 model.addAttribute("owner", ownerRepository.findAll());
    	if (bindingResult.hasErrors()) {
    		return "addcar";
    	}else{
    		carRepository.save(car);
    		 return "redirect:/";
    	}
    }
    
   @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
   @PreAuthorize("hasRole('ADMIN')")
    public String deleteCar(@PathVariable("id") Long carid, Model model) {
        carRepository.deleteById(carid);
        return "redirect:../";
    
    }
    @RequestMapping(value = "/edit/{id}")
    public String editCar(@PathVariable("id") Long carid, Model model) {
    	 model.addAttribute("owner", ownerRepository.findAll());
        model.addAttribute("car", carRepository.findById(carid));
        return "editcar";
    }
    
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }
 
    }