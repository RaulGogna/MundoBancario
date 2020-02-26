package es.eoi.mundoBancario.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaDto {

	private String id;
	
	private double saldo;

	private String dniCliente;
	
	private String idBanco;	

}