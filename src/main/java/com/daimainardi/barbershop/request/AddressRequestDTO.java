package com.daimainardi.barbershop.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressRequestDTO(
        @NotBlank
        String street,
        @NotBlank
        String number,
        String complement,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Size(min = 8, max = 8)
        String zipCode,
        @NotBlank
        String city,
        @NotBlank
        String state) {
}
