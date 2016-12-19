package br.com.newtry.mylab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.newtry.mylab.model.UnidadeMedida;
import br.com.newtry.mylab.service.UnidadeMedidaService;

@Controller
@RequestMapping("/unidadeMedida")
public class UnidadeMedidaController {
	
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	
	@RequestMapping
	public ModelAndView load(){
		ModelAndView mv = new ModelAndView("/forms/unidadeMedida/UnidadeMedida");
		mv.addObject("unidadesMedida", this.unidadeMedidaService.listarTodos());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novoUnidadeMedida(){
		ModelAndView mv = new ModelAndView("/forms/unidadeMedida/novo/NovaUnidadeMedida");
		mv.addObject(new UnidadeMedida());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated UnidadeMedida unidadeMedida, Errors errors, RedirectAttributes redirectAttributes){
		if(errors.hasErrors()){
			return "/forms/unidadeMedida/novo/NovaUnidadeMedida";
		}
		this.unidadeMedidaService.salvar(unidadeMedida);
		redirectAttributes.addFlashAttribute("mensagem", "Unidade de Medida salva com sucesso.");
		return "redirect:/unidadeMedida/novo";
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") UnidadeMedida unidadeMedida){
		ModelAndView mv = new ModelAndView("/forms/unidadeMedida/novo/NovaUnidadeMedida");
		mv.addObject(unidadeMedida);
		return mv;
	}
	
}
