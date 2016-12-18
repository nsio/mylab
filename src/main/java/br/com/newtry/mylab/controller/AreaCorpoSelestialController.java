package br.com.newtry.mylab.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.newtry.mylab.model.AreaCorpoSelestial;
import br.com.newtry.mylab.model.CorpoSelestial;
import br.com.newtry.mylab.model.UnidadeMedida;
import br.com.newtry.mylab.model.enuns.TipoArea;
import br.com.newtry.mylab.service.AreaCorpoSelestialService;
import br.com.newtry.mylab.service.CorpoSelestialService;
import br.com.newtry.mylab.service.UnidadeMedidaService;

@Controller
@RequestMapping("/areaCorpoSelestial")
public class AreaCorpoSelestialController {
	
	@Autowired
	private AreaCorpoSelestialService areaCorpoSelestialService;
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	@Autowired
	private CorpoSelestialService corpoSelestialService;
	
	@RequestMapping
	public ModelAndView load(){
		ModelAndView mv = new ModelAndView("/forms/areaCorpoSelestial/AreaCorpoSelestial");
		mv.addObject("areas", this.areaCorpoSelestialService.listarTodos());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/forms/areaCorpoSelestial/novo/NovoAreaCorpoSelestial");
		mv.addObject(new AreaCorpoSelestial());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated AreaCorpoSelestial areaCorpoSelestial, Errors errors, RedirectAttributes redirectAttributes){
		if(errors.hasErrors()){
			return "/forms/areaCorpoSelestial/novo/NovoAreaCorpoSelestial";
		}
		this.areaCorpoSelestialService.salvar(areaCorpoSelestial);
		redirectAttributes.addFlashAttribute("mensagem", "Área do Corpo Selestial foi salvo com sucesso");
		return "redirect:/areaCorpoSelestial/novo";
	}
	
	@ModelAttribute("unidadesMedida")
	public List<UnidadeMedida> unidadesMedida(){
		return this.unidadeMedidaService.listarTodos();
	}
	
	@ModelAttribute("corposSelestiais")
	public List<CorpoSelestial> corposSelestiais(){
		return this.corpoSelestialService.listarTodos();
	}
	
	@ModelAttribute("tiposAreasCpSeleste")
	public List<TipoArea> tiposAresCpSeleste(){
		return Arrays.asList(TipoArea.values());
	}
	
}
