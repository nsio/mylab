package br.com.newtry.mylab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.newtry.mylab.model.Usuario;
import br.com.newtry.mylab.repository.Usuarios;

@Service
public class UsuarioService extends ServiceMyLab<Usuario> {
	
	@Autowired
	private Usuarios usuarios;
	
	@Override
	public void salvar(Usuario entity) {
		this.usuarios.save(entity);
	}
	
	@Override
	public List<Usuario> listarTodos() {
		return this.usuarios.findAll();
	}
	
	@Override
	public Usuario recuperPeloId(Long id) {
		return this.usuarios.findOne(id);
	}
	
}
