package com.rafalazar.bootcamp.app.controller;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rafalazar.bootcamp.app.document.PlazoFijoVip;
import com.rafalazar.bootcamp.app.service.PlazoFijoVipService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/plazoFijoVip")
public class PlazoFijoVipController {
	
	@Autowired
	private PlazoFijoVipService service;
	
	@GetMapping("/findAll")
	Flux<PlazoFijoVip> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/findById/{id}")
	Mono<PlazoFijoVip> findById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@PostMapping("/create")
	public Mono<ResponseEntity<PlazoFijoVip>> create(@RequestBody PlazoFijoVip pfijov) {
	
		return service.save(pfijov).map(p -> ResponseEntity.created(URI.create("/plazoFijoVip/".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON).body(p));
	}
	
	//Esta es la forma correcta de eliminar un producto.F!
	@DeleteMapping("/deleteById/{id}")
	Mono<ResponseEntity<Void>> deleteById(@PathVariable String id) {
		return service.findById(id)
				.flatMap(p -> {
					return service.delete(p)
							.then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
				}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
}
