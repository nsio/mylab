package br.com.newtry.mylab.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.newtry.mylab.model.ComposicaoMassa;
import br.com.newtry.mylab.repository.ComposicoesMassa;

@Service
public class ComposicaoMassaService extends ServiceMyLab<ComposicaoMassa> {
	
	@Autowired
	private ComposicoesMassa composicoesMassa;
	
	@Override
	public void salvar(ComposicaoMassa entity) {
		this.composicoesMassa.save(entity);
	}
	
	@Override
	public List<ComposicaoMassa> listarTodos() {
		return this.composicoesMassa.findAll();
	}

	@Override
	public ComposicaoMassa recuperPeloId(Long id) {
		return this.composicoesMassa.findOne(id);
	}

	@Override
	public void deletar(Long id) {
		this.composicoesMassa.delete(id);
	}
	
}
