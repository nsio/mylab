package br.com.newtry.mylab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.newtry.mylab.model.TipoCorpoSelestial;
import br.com.newtry.mylab.repository.TiposCorposSelestiais;

@Service
public class TipoCorpoSelestialService extends ServiceMyLab<TipoCorpoSelestial> {
	
	@Autowired
	private TiposCorposSelestiais tpsCorposSelesciaisRepo;
	
	@Override
	public void salvar(TipoCorpoSelestial entity) {
		this.tpsCorposSelesciaisRepo.save(entity);
	}
	
	@Override
	public List<TipoCorpoSelestial> listarTodos() {
		return this.tpsCorposSelesciaisRepo.findAll();
	}
	
}
