package com.daimainardi.barbershop.request;

import com.daimainardi.barbershop.entity.WorkShift;

import java.util.List;

public record UpdateDataBarberDTO(
        String name,
        String phone,
        String email,
        List<WorkShift> shift,
        List<BarberServiceRequestDTO> listServices,
        Integer discount
) {
}