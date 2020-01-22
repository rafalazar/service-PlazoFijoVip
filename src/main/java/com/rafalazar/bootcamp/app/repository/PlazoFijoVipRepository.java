package com.rafalazar.bootcamp.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rafalazar.bootcamp.app.document.PlazoFijoVip;

public interface PlazoFijoVipRepository extends ReactiveMongoRepository<PlazoFijoVip, String>{

}
