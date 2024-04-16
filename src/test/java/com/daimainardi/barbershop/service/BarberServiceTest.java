package com.daimainardi.barbershop.service;

import com.daimainardi.barbershop.entity.BarberEntity;
import com.daimainardi.barbershop.exception.BarberNotFoundException;
import com.daimainardi.barbershop.mapper.BarberMapper;
import com.daimainardi.barbershop.repository.BarberRepository;
import com.daimainardi.barbershop.request.BarberRequestDTO;
import com.daimainardi.barbershop.request.UpdateDataBarberDTO;
import com.daimainardi.barbershop.response.BarberDTO;
import com.daimainardi.barbershop.response.BarberResponseDTO;
import com.daimainardi.barbershop.stub.StubBuilder;
import com.mongodb.DuplicateKeyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class BarberServiceTest {
    @Mock
    private BarberRepository barberRepository;
    @InjectMocks
    private BarberService barberService;

    @Test
    @DisplayName("Quando tentar cadastrar cpf existente deve dar exceção DuplicateKeyException")
    void shouldNotRegisterBarber() {
        BDDMockito.given(barberRepository.save(BarberMapper.mapRequestToEntity(StubBuilder.barberRequestDTO())))
                .willThrow(DuplicateKeyException.class);
        Assertions.assertThrows(DuplicateKeyException.class,
                () -> barberService.createBarber(StubBuilder.barberRequestDTO()));
    }

    @Test
    @DisplayName("Quando tentar cadastrar cpf inexistente não deve dar exceção")
    void shouldRegisterBarber() {
        BDDMockito.given(barberRepository.save(BarberMapper.mapRequestToEntity(StubBuilder.barberRequestDTO())))
                .willReturn(BarberMapper.mapRequestToEntity(StubBuilder.barberRequestDTO()));
        Assertions.assertDoesNotThrow(() -> barberService.createBarber(StubBuilder.barberRequestDTO()));
    }

    @Test
    @DisplayName("Deve encontrar barbeiro com Id existente")
    void shouldFindBarberById() {
        BDDMockito.given(barberRepository.findById(StubBuilder.barberEntity().getId()))
                .willReturn(Optional.of(StubBuilder.barberEntity()));
        Assertions.assertDoesNotThrow(() -> barberService.findBarberById(StubBuilder.barberEntity().getId()));

    }

    @Test
    @DisplayName("Não deve encontrar barbeiro, Id inexistente, BarberNotFoundException")
    void shouldNotFindBarberIdNotFound() {
        BDDMockito.given(barberRepository.findById(StubBuilder.barberEntity().getId()))
                .willThrow(BarberNotFoundException.class);
        Assertions.assertThrows(BarberNotFoundException.class,
                () -> barberService.findBarberById(StubBuilder.barberEntity().getId()));
    }

    @Test
    @DisplayName("Deve retornar uma lista de BarberDTO")
    void shouldFindAllBarber() {
        List<BarberEntity> barberStub = List.of(StubBuilder.barberEntity());
        BDDMockito.when(barberRepository.findAll()).thenReturn(barberStub);
        List<BarberDTO> barberDTOList = barberService.findAll();
        BDDMockito.verify(barberRepository, Mockito.times(1)).findAll();
        Assertions.assertEquals(1, barberDTOList.size());
        Assertions.assertEquals("joão", barberDTOList.get(0).name());
    }

    @Test
    @DisplayName("Deve atualizar todos os campos nos dados do barbeiro, id encontrado")
    void shouldUpdateData() {
        BDDMockito.given(barberRepository.findById(StubBuilder.barberEntity().getId()))
                .willReturn(Optional.of(StubBuilder.barberEntity()));
        BDDMockito.given(barberRepository.save(StubBuilder.barberEntityUpdated())).willReturn(StubBuilder.barberEntityUpdated());
        var response = barberService.update(StubBuilder.barberEntity().getId(), StubBuilder.updateDataBarberDTO());
        Mockito.verify(barberRepository).save(StubBuilder.barberEntityUpdated());
        Assertions.assertEquals("Tiago", response.name());
        Assertions.assertEquals(15, response.discount());
    }


    @Test
    @DisplayName("Deve atualizar somente o campo nome nos dados do barbeiro, id encontrado")
    void shouldUpdateDataName() {
        BDDMockito.given(barberRepository.findById(StubBuilder.barberEntity().getId()))
                .willReturn(Optional.of(StubBuilder.barberEntity()));
        BDDMockito.given(barberRepository.save(StubBuilder.barberEntityUpdateName())).willReturn(StubBuilder.barberEntityUpdateName());
        var response = barberService.update(StubBuilder.barberEntity().getId(), StubBuilder.updateName());
        Mockito.verify(barberRepository).save(StubBuilder.barberEntityUpdateName());
        Assertions.assertEquals("Tiago", response.name());
        Assertions.assertEquals("51999997563", response.phone());
    }

    @Test
    @DisplayName("Não deve atualizar os dados do barbeiro, id não encontrado, BarberNotFoundException")
    void shouldNotUpdateData() {
        BDDMockito.given(barberRepository.findById(StubBuilder.barberEntity().getId()))
                .willThrow(BarberNotFoundException.class);
        Assertions.assertThrows(BarberNotFoundException.class,
                () -> barberService.update(StubBuilder.barberEntity().getId(), StubBuilder.updateDataBarberDTO()));
    }

    @Test
    @DisplayName("Deve atualizar os dados do barbeiro, id encontrado")
    void shouldUpdatedData() {
        BDDMockito.given(barberRepository.findById(StubBuilder.barberEntity().getId()))
                .willReturn(Optional.of(StubBuilder.barberEntity()));
        BDDMockito.given(barberRepository.save(StubBuilder.barberEntityUpdated())).willReturn(StubBuilder.barberEntityUpdated());
        Assertions.assertDoesNotThrow(() -> barberService.update(StubBuilder.barberEntity().getId(), StubBuilder.updateDataBarberDTO()));
    }

    @Test
    @DisplayName("Deve deletar os dados do barbeiro, id encontrado")
    void shouldDeleteBarberById() {
        BDDMockito.given(barberRepository.findById(StubBuilder.barberEntity().getId()))
                .willReturn(Optional.of(StubBuilder.barberEntity()));
        Assertions.assertDoesNotThrow(() -> barberService.delete(StubBuilder.barberEntity().getId()));
        BDDMockito.verify(barberRepository).deleteById(StubBuilder.barberEntity().getId());
    }

    @Test
    @DisplayName("Não deve deletar os dados do barbeiro, id não encontrado, BarberNotFoundException")
    void shouldNotDeleteBarberIdNotFound() {
        BDDMockito.given(barberRepository.findById(StubBuilder.barberEntity().getId()))
                .willThrow(BarberNotFoundException.class);
        Assertions.assertThrows(BarberNotFoundException.class,
                () -> barberService.delete(StubBuilder.barberEntity().getId()));
    }
}
