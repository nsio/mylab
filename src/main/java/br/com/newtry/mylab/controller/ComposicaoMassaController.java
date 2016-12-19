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

import br.com.newtry.mylab.model.ComposicaoMassa;
import br.com.newtry.mylab.model.CorpoSelestial;
import br.com.newtry.mylab.model.ElementoTabelaPeriodica;
import br.com.newtry.mylab.model.UnidadeMedida;
import br.com.newtry.mylab.service.ComposicaoMassaService;
import br.com.newtry.mylab.service.CorpoSelestialService;
import br.com.newtry.mylab.service.ElementoTabelaPeriodiacaService;
import br.com.newtry.mylab.service.UnidadeMedidaService;

@Controller
@RequestMapping("/composicaoMassa")
public class ComposicaoMassaController {
	
	@Autowired
	private ComposicaoMassaService composicaoMassaService;
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	@Autowired
	private ElementoTabelaPeriodiacaService elementoTabelaPeriodiacaService;
	@Autowired
	private CorpoSelestialService corpoSelestialService;
	
	@RequestMapping
	public ModelAndView load(){
		ModelAndView mv = new ModelAndView("/forms/composicaoMassa/ComposicaoMassa");
		mv.addObject("compsMassa", this.composicaoMassaService.listarTodos());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/forms/composicaoMassa/novo/NovoComposicaoMassa");
		mv.addObject(new ComposicaoMassa());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated ComposicaoMassa composicaoMassa, Errors errors, RedirectAttributes redirectAttributes){
		if(errors.hasErrors()){
			return "/forms/composicaoMassa/novo/NovoComposicaoMassa";
		}
		this.composicaoMassaService.salvar(composicaoMassa);
		redirectAttributes.addFlashAttribute("mensagem", "Composição da Massa foi salvo com sucesso");
		return "redirect:/composicaoMassa/novo";
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") ComposicaoMassa composicaoMassa){
		ModelAndView mv = new ModelAndView("/forms/composicaoMassa/novo/NovoComposicaoMassa");
		mv.addObject(composicaoMassa);
		return mv;
	}
	
	@ModelAttribute("unidadesMedida")
	public List<UnidadeMedida> unidadesMedida(){
		return this.unidadeMedidaService.listarTodos();
	}
	
	@ModelAttribute("elementosTabelaPeriodica")
	public List<ElementoTabelaPeriodica> elementosTabelaPeriodica(){
		return this.elementoTabelaPeriodiacaService.listarTodos();
	}
	
	@ModelAttribute("corposSelestiais")
	public List<CorpoSelestial> corposSelestiais(){
		return this.corpoSelestialService.listarTodos();
	}
	
}
