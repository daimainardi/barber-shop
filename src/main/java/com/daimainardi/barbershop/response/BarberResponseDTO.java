package com.daimainardi.barbershop.response;

import com.daimainardi.barbershop.entity.WorkShift;

import java.util.List;

public record BarberResponseDTO(String id,
                                String name,
                                String phone,
                                String email,
                                String cpf,
                                AddressResponseDTO address,
                                List<WorkShift> shift,
                                List<BarberServiceResponseDTO> listServices,
                                Integer discount) {
}