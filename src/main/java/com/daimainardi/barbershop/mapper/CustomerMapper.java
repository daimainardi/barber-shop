package com.daimainardi.barbershop.mapper;

import com.daimainardi.barbershop.request.CustomerRequestDTO;
import com.daimainardi.barbershop.entity.CustomerEntity;

import static com.daimainardi.barbershop.mapper.AddressMapper.mapAddressToEntity;

public class CustomerMapper {
    public static CustomerEntity mapToEntity(CustomerRequestDTO customerRequestDTO) {
        return CustomerEntity.builder()
                .name(customerRequestDTO.name())
                .phone(customerRequestDTO.phone())
                .email(customerRequestDTO.email())
                .cpf(customerRequestDTO.cpf())
                .address(mapAddressToEntity(customerRequestDTO.address()))
                .build();
    }
}