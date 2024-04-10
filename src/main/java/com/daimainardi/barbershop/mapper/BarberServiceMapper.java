package com.daimainardi.barbershop.mapper;

import com.daimainardi.barbershop.entity.BarberServiceEntity;
import com.daimainardi.barbershop.request.BarberServiceRequestDTO;
import com.daimainardi.barbershop.response.BarberServiceResponseDTO;

import java.util.List;

public class BarberServiceMapper {

    public static List<BarberServiceEntity> mapServiceList(List<BarberServiceRequestDTO> barberServiceDto) {
        return barberServiceDto.stream()
                .map(barberServiceRequestDTO -> BarberServiceEntity.builder()
                        .description(barberServiceRequestDTO.description())
                        .price(barberServiceRequestDTO.price())
                        .build())
                .toList();
    }

    public static List<BarberServiceResponseDTO> mapServiceResponseList(List<BarberServiceEntity> barberServiceEntityList) {
        return barberServiceEntityList.stream()
                .map(barberServiceEntity -> new BarberServiceResponseDTO(barberServiceEntity.getDescription(), barberServiceEntity.getPrice()))
                .toList();
    }
}