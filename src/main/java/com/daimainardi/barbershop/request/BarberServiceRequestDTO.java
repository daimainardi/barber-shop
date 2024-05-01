package com.daimainardi.barbershop.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BarberServiceRequestDTO(
        @NotBlank
        String description,
        @NotNull
        Double price) {
}
