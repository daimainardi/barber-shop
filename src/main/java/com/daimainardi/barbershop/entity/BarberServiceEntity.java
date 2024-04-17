package com.daimainardi.barbershop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BarberServiceEntity {
    @Id
    private String id;
    private String description;
    private Double price;
}

