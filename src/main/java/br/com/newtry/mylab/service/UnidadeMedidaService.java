package br.com.newtry.mylab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.newtry.mylab.model.UnidadeMedida;
import br.com.newtry.mylab.repository.UnidadesMedida;

@Service
public class UnidadeMedidaService extends ServiceMyLab<UnidadeMedida> {

	@Autowired
	private UnidadesMedida unidadesMedida;

	@Override
	public void salvar(UnidadeMedida entity) {
		this.unidadesMedida.save(entity);
	}

	@Override
	public List<UnidadeMedida> listarTodos() {
		return this.unidadesMedida.findAll();
	}
	
}
