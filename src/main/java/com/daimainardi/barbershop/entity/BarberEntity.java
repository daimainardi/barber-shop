package com.daimainardi.barbershop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "barber")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BarberEntity {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    @Indexed(unique = true)
    private String cpf;
    private AddressEntity address;
    private List<WorkShift> shift;
    private List<BarberServiceEntity> listServices;
    private Integer discount;
}
