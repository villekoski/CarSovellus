package hh.swd20.CarSovellus.webcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.CarSovellus.domain.Car;
import hh.swd20.CarSovellus.domain.CarRepository;
import hh.swd20.CarSovellus.domain.OwnerRepository;
@CrossOrigin
@Controller

public class BookController {
	
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

    @RequestMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "/booklist";
    }
    @RequestMapping(value ="/add")
    public String addBook(Model model) {
    	   model.addAttribute("owner", ownerRepository.findAll());
        model.addAttribute("car", new Car());
        return "addbook";
    }
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Car car) {
        carRepository.save(car);
        return "redirect:/booklist";
    }
   @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
   //@PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable("id") Long carid, Model model) {
        carRepository.deleteById(carid);
        return "redirect:../booklist";
    
    }
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long carid, Model model) {
    	 model.addAttribute("owner", ownerRepository.findAll());
        model.addAttribute("car", carRepository.findById(carid));
        return "editbook";
    }
    
  /*  @RequestMapping(value="/login")
    public String login() {
        return "/login";
    }*/
 
    }