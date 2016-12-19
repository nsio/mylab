package br.com.newtry.mylab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.newtry.mylab.model.AreaCorpoSelestial;
import br.com.newtry.mylab.repository.AreasCorpoSelestial;

@Service
public class AreaCorpoSelestialService extends ServiceMyLab<AreaCorpoSelestial> {
	
	@Autowired
	private AreasCorpoSelestial areasCorpoSelestial;
	
	@Override
	public void salvar(AreaCorpoSelestial entity) {
		this.areasCorpoSelestial.save(entity);
	}
	
	@Override
	public List<AreaCorpoSelestial> listarTodos() {
		return this.areasCorpoSelestial.findAll();
	}
	
	@Override
	public AreaCorpoSelestial recuperPeloId(Long id) {
		return this.areasCorpoSelestial.findOne(id);
	}
	
}
