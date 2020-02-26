package es.eoi.mundoBancario.controller;

import java.util.List;
import java.util.Optional;
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

import es.eoi.mundoBancario.dto.CuentaDto;
import es.eoi.mundoBancario.entity.Banco;
import es.eoi.mundoBancario.entity.Cliente;
import es.eoi.mundoBancario.entity.Cuenta;
import es.eoi.mundoBancario.service.BancoService;
import es.eoi.mundoBancario.service.ClienteService;
import es.eoi.mundoBancario.service.CuentaService;

@RestController
@RequestMapping(value = "/cuenta")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private BancoService bancoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ModelMapper model;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody CuentaDto dto) {
		Optional<Cliente> cliente = clienteService.find(dto.getDniCliente());
		Optional<Banco> banco = bancoService.find(Integer.parseInt(dto.getIdBanco()));
		
		if(!cliente.isPresent() || !banco.isPresent())
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		else {
			Cuenta cuenta = new Cuenta();
			cuenta.setCliente(cliente.get());
			cuenta.setBanco(banco.get());
			cuenta.setSaldo(dto.getSaldo());
			cuentaService.create(model.map(cuenta, Cuenta.class));
		}
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CuentaDto> find(@PathVariable String id) {
		///TODO fix id
		CuentaDto cuenta = model.map(cuentaService.find(id), CuentaDto.class);
		if(cuenta.equals(null))
			return new ResponseEntity<CuentaDto>(HttpStatus.NOT_FOUND);
		CuentaDto dto = model.map(cuenta, CuentaDto.class);
		return new ResponseEntity<CuentaDto>(dto, HttpStatus.OK);
	}
	
	@GetMapping
	public List<CuentaDto> findAll(){
		List<CuentaDto> cuentas = cuentaService.findAll()
				.stream()
				.map(c -> model.map(c, CuentaDto.class))
				.collect(Collectors.toList());
		
		return cuentas;
	}

	@PutMapping("/{id}")
	public void update(@RequestBody CuentaDto dto) {
		Cuenta cuenta = model.map(dto, Cuenta.class);
		cuentaService.update(cuenta);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		cuentaService.remove(id);
	}
}
