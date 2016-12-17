package br.com.newtry.mylab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.newtry.mylab.model.CorpoSelestial;
import br.com.newtry.mylab.repository.CorposSelestiais;

@Service
public class CorpoSelestialService extends ServiceMyLab<CorpoSelestial> {

	@Autowired
	private CorposSelestiais corposSelestiais;

	@Override
	public void salvar(CorpoSelestial entity) {
		this.corposSelestiais.save(entity);
	}

	@Override
	public List<CorpoSelestial> listarTodos() {
		return this.corposSelestiais.findAll();
	}
	
}
