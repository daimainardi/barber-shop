package com.daimainardi.barbershop.controller;

import com.daimainardi.barbershop.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class BarberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BarberService barberService;


}
