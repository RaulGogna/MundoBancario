package es.eoi.mundoBancario.dto;

import es.eoi.mundoBancario.entity.Banco;
import es.eoi.mundoBancario.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaDto {

	private int id;
	
	private double saldo;

	private Cliente cliente;
	
	private Banco banco;	

}