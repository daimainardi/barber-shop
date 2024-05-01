package com.daimainardi.barbershop.repository;

import com.daimainardi.barbershop.entity.BarberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends MongoRepository<BarberEntity, String> {

}
