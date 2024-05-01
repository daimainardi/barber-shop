package com.daimainardi.barbershop.controller;

import com.daimainardi.barbershop.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
@RequiredArgsConstructor
@Tag(name = "Customer", description = "Customer management")
public class CustomerController {
    private final CustomerService customerService;
}
