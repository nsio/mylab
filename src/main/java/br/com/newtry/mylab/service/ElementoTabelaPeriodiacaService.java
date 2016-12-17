package br.com.newtry.mylab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.newtry.mylab.model.ElementoTabelaPeriodica;
import br.com.newtry.mylab.repository.ElementosTabelaPeriodica;

@Service
public class ElementoTabelaPeriodiacaService extends ServiceMyLab<ElementoTabelaPeriodica> {
	
	@Autowired
	private ElementosTabelaPeriodica elementos;
	
	@Override
	public void salvar(ElementoTabelaPeriodica elemento){
		this.elementos.save(elemento);
	}
	
	@Override
	public List<ElementoTabelaPeriodica> listarTodos(){
		return this.elementos.findAll();
	}
	
}
