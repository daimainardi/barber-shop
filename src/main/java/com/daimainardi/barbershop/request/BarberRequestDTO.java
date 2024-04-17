package com.daimainardi.barbershop.request;

import com.daimainardi.barbershop.entity.WorkShift;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record BarberRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        @Pattern(regexp = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9\\d)\\d{3}-?\\d{4}$")
        String phone,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @CPF
        String cpf,
        @NotNull
        @Valid
        AddressRequestDTO address,
        List<WorkShift> shift,
        List<BarberServiceRequestDTO> listServices,
        Integer discount
        ) {
}
