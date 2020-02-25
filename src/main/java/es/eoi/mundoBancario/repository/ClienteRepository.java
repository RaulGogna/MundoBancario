package es.eoi.mundoBancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eoi.mundoBancario.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
}
