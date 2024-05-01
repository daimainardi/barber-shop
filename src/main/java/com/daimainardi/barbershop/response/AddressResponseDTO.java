package com.daimainardi.barbershop.response;

public record AddressResponseDTO(
        String street,
        String number,
        String complement,
        String neighborhood,
        String zipCode,
        String city,
        String state) {
}
