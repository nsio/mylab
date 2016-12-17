package br.com.newtry.mylab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping
	public ModelAndView loadHome(){
		ModelAndView mv = new ModelAndView("/home/home");
		return mv;
	}
	
}
