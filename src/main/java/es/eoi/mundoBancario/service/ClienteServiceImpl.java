package es.eoi.mundoBancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.mundoBancario.entity.Cliente;
import es.eoi.mundoBancario.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public void create(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	public Cliente find(String dni) {
		Optional<Cliente> client = repository.findById(dni);
		if(!client.isEmpty())
			return client.get();
		return null;
	}
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}

	@Override
	public void remove(String dni) {
		repository.deleteById(dni);
	}

}
