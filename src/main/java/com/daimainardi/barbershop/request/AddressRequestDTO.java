package com.daimainardi.barbershop.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRequestDTO(
        @NotBlank
        String street,
        @NotBlank
        String number,
        String complement,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{5}-\\d{3}")
        String zipCode,
        @NotBlank
        String city,
        @NotBlank
        String state) {
}
