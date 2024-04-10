package com.daimainardi.barbershop.response;

import com.daimainardi.barbershop.entity.WorkShift;

import java.util.List;


public record BarberDTO(String id,
                        String name,
                        String phone,
                        String email,
                        List<WorkShift> shift,
                        List<BarberServiceResponseDTO> listServices,
                        Integer discount) {

}
