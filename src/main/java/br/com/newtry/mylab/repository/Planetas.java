package br.com.newtry.mylab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.newtry.mylab.model.Planeta;

public interface Planetas extends JpaRepository<Planeta, Long> {

}
