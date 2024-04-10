package com.daimainardi.barbershop.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerEntity{

    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    @Indexed(unique = true)
    private String cpf;
    private AddressEntity address;
}
