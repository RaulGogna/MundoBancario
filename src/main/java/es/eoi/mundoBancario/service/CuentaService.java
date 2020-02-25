package es.eoi.mundoBancario.service;

import java.util.List;

import es.eoi.mundoBancario.entity.Banco;
import es.eoi.mundoBancario.entity.Cliente;
import es.eoi.mundoBancario.entity.Cuenta;

public interface CuentaService {

	void create(Cliente cliente, Banco banco, double saldo);

	Cuenta find(int id);

	List<Cuenta> findAll();

	void update(Cuenta cuenta);

	void remove(int id);
}
