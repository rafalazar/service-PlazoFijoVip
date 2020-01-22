package com.rafalazar.bootcamp.app.service;

import com.rafalazar.bootcamp.app.document.PlazoFijoVip;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlazoFijoVipService {
	
	public Flux<PlazoFijoVip> findAll();
	public Mono<PlazoFijoVip> findById(String id);
	public Mono<PlazoFijoVip> update(PlazoFijoVip pfijov);
	public Mono<Void> delete(PlazoFijoVip pfijov);
	public Mono<PlazoFijoVip> save(PlazoFijoVip pfijov);

}
