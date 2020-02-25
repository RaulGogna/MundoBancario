package es.eoi.mundoBancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eoi.mundoBancario.entity.Banco;

public interface BancoRepository extends JpaRepository<Banco, Integer> {

}
