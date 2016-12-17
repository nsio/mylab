package br.com.newtry.mylab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.newtry.mylab.model.Planeta;
import br.com.newtry.mylab.service.PlanetaService;
import br.com.newtry.mylab.service.UnidadeMedidaService;

@Controller
@RequestMapping("/planeta")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;
	
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	
	@RequestMapping
	public ModelAndView load(){
		ModelAndView mv = new ModelAndView("/forms/planeta/Planeta");
		mv.addObject("planetas", this.planetaService.listarTodos());
		mv.addObject("unidadesMedidas", this.unidadeMedidaService.listarTodos());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/forms/planeta/novo/NovoPlaneta");
		mv.addObject(new Planeta());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Planeta planeta, Errors errors, RedirectAttributes redirectAttributes){
		if(errors.hasErrors()){
			return "/forms/planeta/novo/NovoPlaneta";
		}
		this.planetaService.salvar(planeta);
		redirectAttributes.addFlashAttribute("mensagem", "O Planeta foi salvo com sucesso");
		
		return "redirect:/planeta/novo";
	}
	
}
