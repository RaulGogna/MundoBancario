package es.eoi.mundoBancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.mundoBancario.entity.Cuenta;
import es.eoi.mundoBancario.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService{

	@Autowired
	private CuentaRepository repository;
	
	@Override
	public void create(Cuenta dto) {
		Cuenta cuenta = new Cuenta();
		cuenta.setCliente(dto.getCliente());
		cuenta.setBanco(dto.getBanco());
		cuenta.setSaldo(dto.getSaldo());
		repository.save(cuenta);
	}

	@Override
	public Optional<Cuenta> find(String id) {
		return repository.findById(Integer.valueOf(id));
	}
	
	@Override
	public List<Cuenta> findAll(){
		return repository.findAll();
	}

	@Override
	public void update(Cuenta dto) {
		Optional<Cuenta> cuenta = this.find(String.valueOf(dto.getId()));
		if(!cuenta.equals(null)) {
			Cuenta cuent = cuenta.get();
			cuent.setSaldo(dto.getSaldo());
			repository.save(cuent);			
		}
	}

	@Override
	public void remove(int id) {
		repository.deleteById(id);
	}

	
}
