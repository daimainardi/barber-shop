package com.daimainardi.barbershop.mapper;

import com.daimainardi.barbershop.request.AddressRequestDTO;
import com.daimainardi.barbershop.entity.AddressEntity;
import com.daimainardi.barbershop.response.AddressResponseDTO;

class AddressMapper {
    public static AddressEntity mapAddressToEntity(AddressRequestDTO address) {
        //return new AddressEntity(address.street(), address.number(), address.complement(), address.neighborhood(),
        //address.zipCode(), address.city(), address.state());
        return AddressEntity.builder()
                .street(address.street())
                .number(address.number())
                .complement(address.complement())
                .neighborhood(address.neighborhood())
                .zipCode(address.zipCode())
                .city(address.city())
                .state(address.state())
                .build();
    }
    public static AddressResponseDTO mapAddressToResponse(AddressEntity addressEntity){
        return new AddressResponseDTO(addressEntity.getStreet(), addressEntity.getNumber(), addressEntity.getComplement(),
                addressEntity.getNeighborhood(), addressEntity.getZipCode(), addressEntity.getCity(), addressEntity.getState());
    }
}
