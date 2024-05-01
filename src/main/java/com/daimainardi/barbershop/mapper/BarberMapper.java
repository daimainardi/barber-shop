package com.daimainardi.barbershop.mapper;

import com.daimainardi.barbershop.entity.BarberEntity;
import com.daimainardi.barbershop.request.BarberRequestDTO;
import com.daimainardi.barbershop.response.BarberDTO;
import com.daimainardi.barbershop.response.BarberResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.daimainardi.barbershop.mapper.AddressMapper.mapAddressToEntity;
import static com.daimainardi.barbershop.mapper.AddressMapper.mapAddressToResponse;
import static com.daimainardi.barbershop.mapper.BarberServiceMapper.mapServiceList;
import static com.daimainardi.barbershop.mapper.BarberServiceMapper.mapServiceResponseList;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BarberMapper {
    public static BarberEntity mapRequestToEntity(BarberRequestDTO barberRequestDTO) {
        return BarberEntity.builder()
                .name(barberRequestDTO.name())
                .phone(barberRequestDTO.phone())
                .email(barberRequestDTO.email())
                .cpf(barberRequestDTO.cpf())
                .address(mapAddressToEntity(barberRequestDTO.address()))
                .shift(barberRequestDTO.shift())
                .listServices(mapServiceList(barberRequestDTO.listServices()))
                .discount(barberRequestDTO.discount())
                .build();
    }

    public static BarberResponseDTO mapEntityToResponse(BarberEntity barberEntity) {
        var addressResponseDTO = mapAddressToResponse(barberEntity.getAddress());
        var barberServiceResponseDTOS = mapServiceResponseList(barberEntity.getListServices());
        return new BarberResponseDTO(barberEntity.getId(), barberEntity.getName(), barberEntity.getPhone(),
                barberEntity.getEmail(), barberEntity.getCpf(), addressResponseDTO, barberEntity.getShift(),
                barberServiceResponseDTOS, barberEntity.getDiscount());
    }

    public static List<BarberDTO> mapResponseBarberDTO(List<BarberEntity> barberEntityList) {
        return barberEntityList.stream()
                .map(barberEntity -> new BarberDTO(barberEntity.getId(), barberEntity.getName(), barberEntity.getPhone(),
                        barberEntity.getEmail(), barberEntity.getShift(), mapServiceResponseList(barberEntity.getListServices()),
                        barberEntity.getDiscount()))
                .toList();
    }
}