package com.daimainardi.barbershop.service;

import com.daimainardi.barbershop.entity.BarberEntity;
import com.daimainardi.barbershop.exception.BarberNotFoundException;
import com.daimainardi.barbershop.mapper.BarberMapper;
import com.daimainardi.barbershop.mapper.BarberServiceMapper;
import com.daimainardi.barbershop.repository.BarberRepository;
import com.daimainardi.barbershop.request.BarberRequestDTO;
import com.daimainardi.barbershop.request.UpdateDataBarberDTO;
import com.daimainardi.barbershop.response.BarberDTO;
import com.daimainardi.barbershop.response.BarberResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BarberService {

    private final BarberRepository barberRepository;

    public BarberResponseDTO createBarber(BarberRequestDTO barberRequestDTO) {
        BarberEntity barber = barberRepository.save(BarberMapper.mapRequestToEntity(barberRequestDTO));
        return BarberMapper.mapEntityToResponse(barber);
    }

    public BarberResponseDTO findBarberById(String id) {
        BarberEntity barber = barberRepository.findById(id).orElseThrow(() ->
                new BarberNotFoundException("barber not found", HttpStatus.NOT_FOUND));
        return BarberMapper.mapEntityToResponse(barber);
    }

    public List<BarberDTO> findAll() {
        return BarberMapper.mapResponseBarberDTO(barberRepository.findAll());
    }

    public BarberResponseDTO update(String id, UpdateDataBarberDTO updateDataBarberDTO) {
        log.info("trying to update barber id {} with data {}",id,updateDataBarberDTO);
        BarberEntity barberEntity = barberRepository.findById(id).orElseThrow(() ->
                new BarberNotFoundException("barber not found", HttpStatus.NOT_FOUND));
        log.info("barber entity found {}", barberEntity);
        var updatedData = updateData(barberEntity, updateDataBarberDTO);
        var barberResponseDTO = BarberMapper.mapEntityToResponse(barberRepository.save(updatedData));
        log.info("Barber updated successfully {}", barberResponseDTO);
        return barberResponseDTO;
    }

    private BarberEntity updateData(BarberEntity barberEntity, UpdateDataBarberDTO updateDataBarberDTO) {
        if (updateDataBarberDTO.name() != null) {
            barberEntity.setName(updateDataBarberDTO.name());
        }
        if (updateDataBarberDTO.phone() != null) {
            barberEntity.setPhone(updateDataBarberDTO.phone());
        }
        if (updateDataBarberDTO.email() != null) {
            barberEntity.setEmail(updateDataBarberDTO.email());
        }
        if (updateDataBarberDTO.shift() != null) {
            barberEntity.setShift(updateDataBarberDTO.shift());
        }
        if (updateDataBarberDTO.listServices() != null) {
            barberEntity.setListServices(BarberServiceMapper.mapServiceList(updateDataBarberDTO.listServices()));
        }
        if (updateDataBarberDTO.discount() != null) {
            barberEntity.setDiscount(updateDataBarberDTO.discount());
        }
        return barberEntity;
    }

    public void delete(String id) {
        findBarberById(id);
        barberRepository.deleteById(id);
    }
}
