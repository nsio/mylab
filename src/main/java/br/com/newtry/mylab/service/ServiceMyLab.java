package br.com.newtry.mylab.service;

import java.util.List;

public abstract class ServiceMyLab<T> {
	
	public abstract void salvar(T entity);
	public abstract List<T> listarTodos();
	public abstract T recuperPeloId(Long id);
	
}
