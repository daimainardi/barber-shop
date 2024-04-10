package com.daimainardi.barbershop.repository;

import com.daimainardi.barbershop.entity.BarberServiceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberServiceRepository extends MongoRepository<BarberServiceEntity, String> {
}
