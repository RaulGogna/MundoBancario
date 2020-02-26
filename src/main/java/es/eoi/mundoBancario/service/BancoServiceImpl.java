package es.eoi.mundoBancario.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.mundoBancario.entity.Banco;
import es.eoi.mundoBancario.repository.BancoRepository;

@Service
public class BancoServiceImpl implements BancoService{

	@Autowired
	private BancoRepository repository;
	
	@Override
	public void create(Banco banco) {
		repository.save(banco);
	}

	@Override
	public Optional<Banco> find(int id) {
		Optional<Banco> banco = repository.findById(id);
		if(!banco.isEmpty())
			return banco;
		return null;
	}
	
	public List<Banco> findAll(){
		return repository.findAll();
	}

	@Override
	public void remove(int id) {
		repository.deleteById(id);
	}

}
