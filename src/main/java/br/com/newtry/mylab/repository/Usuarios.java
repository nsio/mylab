package br.com.newtry.mylab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.newtry.mylab.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {

}
