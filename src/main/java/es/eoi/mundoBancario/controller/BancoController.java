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
import es.eoi.mundoBancario.entity.Banco;
import es.eoi.mundoBancario.service.BancoService;

@RestController
@RequestMapping(value = "/banco")
public class BancoController {

	@Autowired
	private BancoService service;

	@Autowired
	private ModelMapper model;

	@PostMapping
	public ResponseEntity<String> create(@RequestBody BancoDto banco) {
		if(service.find(banco.getId())!= null)
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		else {			
			service.create(model.map(banco, Banco.class));
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<BancoDto> find(@PathVariable int id) {
		Banco banco = service.find(id);
		if(banco == null)
			return new ResponseEntity<BancoDto>(HttpStatus.NOT_FOUND);
		BancoDto dto = model.map(banco, BancoDto.class);
		return new ResponseEntity<BancoDto>(dto, HttpStatus.OK);
	}

	@GetMapping
	public List<BancoDto> findAll() {
		List<BancoDto> dtos = service.findAll()
				.stream()
				.map(c -> model.map(c, BancoDto.class))
				.collect(Collectors.toList());
		return dtos;
	}

	@PutMapping("/{id}")
	public void update(@RequestBody BancoDto dto) {
		Banco banco = model.map(dto, Banco.class);
		service.create(banco);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		service.remove(id);
	}
}
