package com.daimainardi.barbershop.mapper;

import com.daimainardi.barbershop.entity.CustomerEntity;
import com.daimainardi.barbershop.request.CustomerRequestDTO;
import com.daimainardi.barbershop.response.CustomerResponseDTO;

import static com.daimainardi.barbershop.mapper.AddressMapper.mapAddressToEntity;
import static com.daimainardi.barbershop.mapper.AddressMapper.mapAddressToResponse;

public class CustomerMapper {
    public static CustomerEntity mapToEntity (CustomerRequestDTO customerRequestDTO){
        return CustomerEntity.builder()
                .name(customerRequestDTO.name())
                .phone(customerRequestDTO.phone())
                .email(customerRequestDTO.email())
                .cpf(customerRequestDTO.cpf())
                .address(mapAddressToEntity(customerRequestDTO.address()))
                .build();
    }
    public static CustomerResponseDTO mapToResponse(CustomerEntity customerEntity){
        return new CustomerResponseDTO(customerEntity.getId(), customerEntity.getName(), customerEntity.getPhone(),
                customerEntity.getEmail(), customerEntity.getCpf(), mapAddressToResponse(customerEntity.getAddress()));
    }
}
