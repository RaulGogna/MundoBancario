package es.eoi.mundoBancario.service;

import java.util.List;

import es.eoi.mundoBancario.entity.Cliente;

public interface ClienteService {

	void create(Cliente cliente);

	Cliente find(String dni);

	List<Cliente> findAll();

	void remove(String dni);

}
