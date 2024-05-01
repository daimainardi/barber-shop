package com.daimainardi.barbershop.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddressEntity {
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;

}