package com.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.api.models.User;
import com.api.services.RegistationService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistationService registrationService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegisterView() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping(value="/registerProcess", method = RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute User user) {
		
		registrationService.save(user);
		ModelAndView mav = new ModelAndView("successregister");
		mav.addObject("value", 3);
		return mav;
	}
}
