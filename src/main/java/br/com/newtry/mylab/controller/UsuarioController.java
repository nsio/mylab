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

import br.com.newtry.mylab.model.Usuario;
import br.com.newtry.mylab.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping
	public ModelAndView load(){
		ModelAndView mv = new ModelAndView("forms/Usuario/Usuario");
		mv.addObject("usuarios", this.usuarioService.listarTodos());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novoUsuario(){
		ModelAndView mv = new ModelAndView("/forms/usuario/novo/NovoUsuario");
		mv.addObject(new Usuario());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes){
		if(errors.hasErrors()){
			return "/forms/usuario/novo/NovoUsuario";
		}
		this.usuarioService.salvar(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário criado com sucesso.");
		return "redirect:/usuario/novo";
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Usuario usuario){
		ModelAndView mv = new ModelAndView("/forms/usuario/novo/NovoUsuario");
		mv.addObject(usuario);
		return mv;
	}
	
}
