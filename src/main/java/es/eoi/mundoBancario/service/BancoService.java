package es.eoi.mundoBancario.service;

import java.util.List;
import java.util.Optional;

import es.eoi.mundoBancario.entity.Banco;

public interface BancoService {

	void create(Banco banco);

	Optional<Banco> find(int id);
	
	List<Banco> findAll();

	void remove(int id);

}
