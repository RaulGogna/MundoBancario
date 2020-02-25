package es.eoi.mundoBancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.mundoBancario.entity.Banco;
import es.eoi.mundoBancario.entity.Cliente;
import es.eoi.mundoBancario.entity.Cuenta;
import es.eoi.mundoBancario.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService{

	@Autowired
	private CuentaRepository repository;
	
	@Override
	public void create(Cliente cliente, Banco banco, double saldo) {
		Cuenta cuenta = new Cuenta();
		cuenta.setCliente(cliente);
		cuenta.setBanco(banco);
		cuenta.setSaldo(saldo);
		repository.save(cuenta);
	}

	@Override
	public Cuenta find(int id) {
		Optional<Cuenta> cuenta = repository.findById(id);
		if(!cuenta.isEmpty())
			return cuenta.get();
		return null;
	}
	
	@Override
	public List<Cuenta> findAll(){
		return repository.findAll();
	}

	
	@Override
	public void update(Cuenta dto) {
		Cuenta cuenta = repository.findById(dto.getId()).get();
		cuenta.setSaldo(dto.getSaldo());
		repository.save(cuenta);
	}

	@Override
	public void remove(int id) {
		repository.deleteById(id);
	}

	
}
