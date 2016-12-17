package br.com.newtry.mylab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.newtry.mylab.model.Planeta;
import br.com.newtry.mylab.repository.Planetas;

@Service
public class PlanetaService extends ServiceMyLab<Planeta> {

	@Autowired
	private Planetas planetas;

	@Override
	public void salvar(Planeta entity) {
		this.planetas.save(entity);
	}

	@Override
	public List<Planeta> listarTodos() {
		return this.planetas.findAll();
	}
	
}
