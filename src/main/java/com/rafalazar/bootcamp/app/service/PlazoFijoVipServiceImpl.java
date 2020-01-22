package com.rafalazar.bootcamp.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafalazar.bootcamp.app.document.PlazoFijoVip;
import com.rafalazar.bootcamp.app.repository.PlazoFijoVipRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlazoFijoVipServiceImpl implements PlazoFijoVipService{

	@Autowired
	private PlazoFijoVipRepository repo;
	
	@Override
	public Flux<PlazoFijoVip> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<PlazoFijoVip> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<PlazoFijoVip> update(PlazoFijoVip pfijov) {
		return repo.findById(pfijov.getId())
				.map(pv -> pfijov)
				.flatMap(repo::save);
	}

	@Override
	public Mono<Void> delete(PlazoFijoVip pfijov) {
		return repo.delete(pfijov);
	}

	@Override
	public Mono<PlazoFijoVip> save(PlazoFijoVip pfijov) {
		return repo.save(pfijov);
	}

}
