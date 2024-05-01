package com.daimainardi.barbershop.response;

public record CustomerResponseDTO(String id,
                                  String name,
                                  String phone,
                                  String email,
                                  String cpf,
                                  AddressResponseDTO address) {
}