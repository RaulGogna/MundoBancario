package es.eoi.mundoBancario.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.mundoBancario.dto.BancoDto;
import es.eoi.mundoBancario.dto.ClienteDto;
import es.eoi.mundoBancario.dto.CuentaDto;
import es.eoi.mundoBancario.entity.Banco;
import es.eoi.mundoBancario.entity.Cliente;
import es.eoi.mundoBancario.entity.Cuenta;
import es.eoi.mundoBancario.service.CuentaService;

@RestController
@RequestMapping(value = "/cuenta")
public class CuentaController {

	@Autowired
	private CuentaService service;
	
	@Autowired
	private ModelMapper model;
	
	@PostMapping
	public void create(@RequestBody ClienteDto clienteDto, @RequestBody BancoDto bancoDto, @RequestBody double saldo) {
		service.create(model.map(clienteDto, Cliente.class), 
					   model.map(bancoDto, Banco.class), 
					   saldo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CuentaDto> find(@PathVariable int id) {
		Cuenta cuenta = service.find(id);
		if(cuenta == null)
			return new ResponseEntity<CuentaDto>(HttpStatus.NOT_FOUND);
		CuentaDto dto = model.map(cuenta, CuentaDto.class);
		return new ResponseEntity<CuentaDto>(dto, HttpStatus.OK);
	}
	
	@GetMapping
	public List<CuentaDto> findAll(){
		List<CuentaDto> cuentas = service.findAll()
				.stream()
				.map(c -> model.map(c, CuentaDto.class))
				.collect(Collectors.toList());
		
		return cuentas;
	}

	@PutMapping("/{id}")
	public void update(@RequestBody CuentaDto dto) {
		Cuenta cuenta = model.map(dto, Cuenta.class);
		service.update(cuenta);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		service.remove(id);
	}
}
