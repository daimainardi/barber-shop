package com.daimainardi.barbershop.repository;

import com.daimainardi.barbershop.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity,String> {
}
