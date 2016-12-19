package br.com.newtry.mylab.controller;

import java.util.Arrays;
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

import br.com.newtry.mylab.model.ElementoTabelaPeriodica;
import br.com.newtry.mylab.model.enuns.TipoElemento;
import br.com.newtry.mylab.service.ElementoTabelaPeriodiacaService;

@Controller
@RequestMapping("/forms/periodica")
public class PeriodicaController {
	
	private static final String FORMS_PERIODICA = "/forms/Periodica";
	@Autowired
	private ElementoTabelaPeriodiacaService elementoService;
	
	@RequestMapping
	public ModelAndView loadTabelaPeriodica(){
		ModelAndView mv = new ModelAndView(FORMS_PERIODICA);
		mv.addObject("elementos", this.elementoService.listarTodos());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novoElemento(){
		ModelAndView mv = new ModelAndView("/forms/novo/NovoElemento");
		mv.addObject(new ElementoTabelaPeriodica());
		return mv;
	}
	
	// O ENVIO DO FORM VEM DIRETOR PARA ESSE MÉTODO MAPEADO PARA RECEBER AS REQUISIÇÃO 
	// COM O MÉTODO PARA TIPO POST
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated ElementoTabelaPeriodica elemento, Errors errors, RedirectAttributes redirectAttributes){
		// A ANOTAÇÃO @Validated, É UMA META INFORMAÇÃO QUE SOLICITA AO SPRING QUE FAÇA A VALIDAÇÃO DO BEAN, LOGICAMENTE, TEMOS META INFORMAÇÕES
		// NO BEAN, COM BEAN VALIDATIONS
		// AO ANOTAR COM @Validated, O SPRING CRIA AUTOMATICAMENTE O OBJETO ERROR, É PARA COLOCAR ESSE OBJETO COM PARA, QUE O SPRING ENTREGA ESSE OBJETO PREENCHIDO
		if(errors.hasErrors()){
			return "/forms/novo/NovoElemento";
		}
		this.elementoService.salvar(elemento);
		// QUANDO FOR SALVO COM SUCESSO, VAMOS MANDAR O BROWSER FAZER UMA NOVA REQUISIÇÃO, PARA O MESMO ENDERÇO
		// ASSIM, NÃO PRECISAMOS INSTANCIAR E ADICIONAR UM NOVO OBJETO, NESSE CASO SERIA UM OBJETO INSTANCIADO E SEM VALORES
		// POR ISSO NESSE MÉTODO, TEMOS COMO PARAM O OBJETO RedirectAttributes, ESSE OBJETO MANTÉM OS DADOS QUE PRECISAMOS ENVIAR
		// PARA URL REDIRECIONADA, ASSIM, SE PRECISAMOS ENVIAR ALGUM DADO DA URL ORIGINAL, É PRECISO ADICIONAR NO OBJETO RedirectAttributes
		// VEJA:
		redirectAttributes.addFlashAttribute("mensagem", "Elemento salvo com sucesso!");
		
		return "redirect:/forms/periodica/novo";
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") ElementoTabelaPeriodica elemento){
		ModelAndView mv = new ModelAndView("/forms/novo/NovoElemento");
		mv.addObject(elemento);
		return mv;
		
	}
	
	// ESSE MÉTODO ANOTADO COM @MODELATTRIBUTE, EVITA DE ADICIONAR VARIAS VEZES A MESMA COLEÇÃO
	// USANDO O MODELANDVIEW, SEM ESSE METÓDO, A CADA VEZ QUE O USUÁRIO REQUISITAR UMA PÁGINA QUE PRECISA
	// DA COLEÇÃO DE TIPOS DE ELEMENTOS, SERIA NECESSÁRIO CHAMAR O MÉTODO ADDOBJECT
	// COM O MÉTODO ABAIXO O SPRING MANTE´M A COLEÇÃO SEMPRE QUE PRECISARMOS
	//------- IMPORTANTE -------
	// O NOME QUE USAMOS NA PÁGINA, PARA O THIMELEAF ENCONTRAR A COLEÇÃO, É O NOME DO OBJETO DA COLEÇÃO
	// PARA ESSE CASO TipoElemento, NÃO É O NOME DO MÉTODO, ENTÃO O RESULTADO FINAL, O NOME QUE VAMOS USAR É:
	// tipoElementoList
	// OU COLOCAR UM NOME PARA O MODELATTRIBUTE, APÓS A ANOTAÇÃO
	@ModelAttribute("tiposElementos")
	public List<TipoElemento> tiposElementos(){
		return Arrays.asList(TipoElemento.values());
	}
	
}
