package com.wipro.bestcar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.wipro.bestcar.model.Cars;
import com.wipro.bestcar.service.CarsService;

@Controller
public class CarsController {

	@Autowired
	CarsService carsService;

	@GetMapping({"/","/home","/index"})
	public String home() {
		return "home";
	}

	@GetMapping("/carByBrand")
	public String carByBrand() {

		return "carbybrand";
	}

	@GetMapping("/carByPrice")
	public String carByPrice() {

		return "carbyprice";
	}

	@GetMapping(path = "/findCarbyModel",params = "findModel")
	public ModelAndView findAllCarsByModels(@RequestParam("brand") String carBrand){

		ModelAndView mav = new ModelAndView();		
		List<Cars> carsListByModel = carsService.findAllCarModels(carBrand);

		mav.addObject("carsList", carsListByModel);
		mav.setViewName("carslistbymodel");

		return mav;


	}

	@GetMapping(path = "/findCarbyModel",params = "back")
	public String carHomePageBrand() {
		return "home";
	}

	@GetMapping(path = "/findCarbyPrice",params = "findYourCar")
	public ModelAndView findCarbyPrice(@RequestParam("5 Lakh") String price){

		ModelAndView mv = new ModelAndView();
		List<Cars> carsListByPrice=null;
		
		if(price.equalsIgnoreCase(">5 Lakh")) {
			price="500000";
			carsListByPrice = carsService.findCarsPriceGreaterThan(price);
			mv.addObject("carsList",carsListByPrice);
			mv.setViewName("carslistbyprice");
			return mv;
		}
		else {
			price="500000";
			carsListByPrice = carsService.findCarsPriceLessThan(price);
			mv.addObject("carsList",carsListByPrice);
			mv.setViewName("carslistbyprice");
			return mv;
		}
	}

	@GetMapping(path = "/findCarbyPrice",params = "back")
	public String carHomePagePrice() {
		return "home";
	}
	
	@PostMapping(path="/succCarBooking", params="bookCar")
	public String succCarBooking(@RequestParam("cars") String[] bookedCar, Model model) {
		
		System.out.println("Cars : "+bookedCar.toString());
		model.addAttribute("brand",bookedCar[1]);
		model.addAttribute("model",bookedCar[2]);
		
		return "succcarbook";
		
	}

	@PostMapping(path="/succCarBooking",params = "home")
	public String showHome() {
		
		return "home";
		
	}
	
	@PostMapping(path="/succCarBooking",params = "mBack")
	public String showPrevmPage() {
		
		return "carbybrand";
		
	}
	
	@PostMapping(path="/succCarBooking",params = "pBack")
	public String showPrevpPage() {
		
		return "carbyprice";
		
	}
}
