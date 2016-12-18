package br.com.newtry.mylab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.newtry.mylab.model.ComposicaoMassa;

public interface ComposicoesMassa extends JpaRepository<ComposicaoMassa, Long> {
	
}
