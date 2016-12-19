package br.com.newtry.mylab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.newtry.mylab.model.CorpoSelestial;
import br.com.newtry.mylab.model.TipoCorpoSelestial;
import br.com.newtry.mylab.model.UnidadeMedida;
import br.com.newtry.mylab.service.CorpoSelestialService;
import br.com.newtry.mylab.service.TipoCorpoSelestialService;
import br.com.newtry.mylab.service.UnidadeMedidaService;

@Controller
@RequestMapping("/corpoSelestial")
public class CorpoSelestialController {
	
	@Autowired
	private CorpoSelestialService corpoSelestialService;
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	@Autowired
	private TipoCorpoSelestialService tpCorpoSelestialService;
	
	@RequestMapping
	public ModelAndView load(){
		ModelAndView mv = new ModelAndView("/forms/corpoSelestial/CorpoSelestial");
		mv.addObject("corposSelestiais", this.corpoSelestialService.listarTodos());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/forms/corpoSelestial/novo/NovoCorpoSelestial");
		mv.addObject(new CorpoSelestial());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated CorpoSelestial corpoSelestial, Errors errors, RedirectAttributes redirectAttributes){
		if(errors.hasErrors()){
			return "/forms/corpoSelestial/novo/NovoCorpoSelestial";
		}
		this.corpoSelestialService.salvar(corpoSelestial);
		redirectAttributes.addFlashAttribute("mensagem", "O Corpo Selestial foi salvo com sucesso");
		
		return "redirect:/corpoSelestial/novo";
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") CorpoSelestial corpoSelestial){
		ModelAndView mv = new ModelAndView("/forms/corpoSelestial/novo/NovoCorpoSelestial");
		mv.addObject(corpoSelestial);
		return mv;
	}
	
	@ModelAttribute("unidadesMedida")
	public List<UnidadeMedida> unidadesMedida(){
		return this.unidadeMedidaService.listarTodos();
	}
	
	@ModelAttribute("tiposCorposSelestiais")
	public List<TipoCorpoSelestial> tiposCorposSelestiais(){
		return this.tpCorpoSelestialService.listarTodos();
	}
	
}
