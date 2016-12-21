package br.com.newtry.mylab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.newtry.mylab.model.TipoCorpoSelestial;
import br.com.newtry.mylab.service.TipoCorpoSelestialService;

@Controller
@RequestMapping("/tipoCorpoSelestial")
public class TipoCorpoSelestialController {
	
	@Autowired
	private TipoCorpoSelestialService tpsCorposSelestiais;
	
	@RequestMapping
	public ModelAndView load(){
		ModelAndView mv = new ModelAndView("/forms/tipoCorpoSelestial/TipoCorpoSelestial");
		mv.addObject("tiposCorposSelestiais", this.tpsCorposSelestiais.listarTodos());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/forms/tipoCorpoSelestial/novo/NovoTipoCorpoSelestial");
		mv.addObject(new TipoCorpoSelestial());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated TipoCorpoSelestial tipoCorpoSelestial, Errors errors, RedirectAttributes redirectAttributes){
		if(errors.hasErrors()){
			return "/forms/tipoCorpoSelestial/novo/NovoTipoCorpoSelestial";
		}
		this.tpsCorposSelestiais.salvar(tipoCorpoSelestial);
		redirectAttributes.addFlashAttribute("mensagem", "O Tipo Corpo Selestial foi salvo com sucesso");
		
		return "redirect:/tipoCorpoSelestial/novo";
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes redirectAttributes){
		this.tpsCorposSelestiais.deletar(codigo);
		redirectAttributes.addFlashAttribute("mensagem", "O Tipo de Corpo Selestial foi excuído com sucesso");
		return "redirect:/tipoCorpoSelestial";
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") TipoCorpoSelestial tipoCorpoSelestial){
		ModelAndView mv = new ModelAndView("/forms/tipoCorpoSelestial/novo/NovoTipoCorpoSelestial");
		mv.addObject(tipoCorpoSelestial);
		return mv;
	}
	
}
