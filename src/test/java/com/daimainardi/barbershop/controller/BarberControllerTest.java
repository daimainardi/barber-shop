package com.daimainardi.barbershop.controller;

import com.daimainardi.barbershop.entity.BarberEntity;
import com.daimainardi.barbershop.mapper.BarberMapper;
import com.daimainardi.barbershop.repository.BarberRepository;
import com.daimainardi.barbershop.stub.StubBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BarberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BarberRepository barberRepository;

    @Test
    void ShouldCreateNewBarber() throws Exception {
        BarberEntity barberEntity = new BarberEntity("123", "joão", "51999997563",
                "joao@gmail.com", "00762345098", StubBuilder.addressEntity(), StubBuilder.shiftList(),
                StubBuilder.barberServiceEntityList(), 10);
        BDDMockito.given(barberRepository.save(BarberMapper.mapRequestToEntity(StubBuilder.barberRequestDTO())))
                .willReturn(barberEntity);
        mockMvc.perform(post("/barbers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(StubBuilder.barberRequestDTO())))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("joão"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("51999997563"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("00762345098"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address.street").value("Rua Santana"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.listServices.[0].id").value("456"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.listServices.[0].description").value("Barba"));


    }
}
