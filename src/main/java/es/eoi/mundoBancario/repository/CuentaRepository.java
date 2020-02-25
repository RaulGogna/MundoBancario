package es.eoi.mundoBancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eoi.mundoBancario.entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{

}
