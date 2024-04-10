package com.daimainardi.barbershop.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{4}-?\\d{4}")
        String phone,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @CPF
        String cpf,
        @NotNull
        @Valid
        AddressRequestDTO address) {
}
