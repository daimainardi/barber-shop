package com.daimainardi.barbershop.stub;

import com.daimainardi.barbershop.entity.AddressEntity;
import com.daimainardi.barbershop.entity.BarberEntity;
import com.daimainardi.barbershop.entity.BarberServiceEntity;
import com.daimainardi.barbershop.entity.WorkShift;
import com.daimainardi.barbershop.request.AddressRequestDTO;
import com.daimainardi.barbershop.request.BarberRequestDTO;
import com.daimainardi.barbershop.request.BarberServiceRequestDTO;
import com.daimainardi.barbershop.request.UpdateDataBarberDTO;
import com.daimainardi.barbershop.response.AddressResponseDTO;
import com.daimainardi.barbershop.response.BarberServiceResponseDTO;

import java.util.List;

public class StubBuilder {
    public static AddressRequestDTO addressRequestDTO() {
        return new AddressRequestDTO("Rua Santana", "11", "01", "Partenon",
                "90620260", "Portão", "Rio");
    }
    public static AddressResponseDTO addressResponseDTO(){
        return new AddressResponseDTO("Rua Santana", "11", "01", "Partenon",
                "90620260", "Portão", "Rio");
    }

    public static AddressEntity addressEntity() {
        return new AddressEntity("Rua Santana", "11", "01", "Partenon",
                "90620260", "Portão", "Rio");
    }

    public static List<WorkShift> shiftList() {
        return List.of(WorkShift.AFTERNOON);
    }

    public static List<BarberServiceRequestDTO> barberServiceRequestDTOList() {
        return List.of(new BarberServiceRequestDTO("Barba", 20.00));
    }
    public static List<BarberServiceResponseDTO> barberServiceResponseDTOList(){
        return List.of(new BarberServiceResponseDTO("555", "Barba", 20.00));
    }

    public static List<BarberServiceEntity> barberServiceEntityList() {
        return List.of(new BarberServiceEntity("555", "Barba", 20.00));
    }

    public static BarberRequestDTO barberRequestDTO() {
        return new BarberRequestDTO("joão", "51999997563", "joao@gmail.com", "00762345098",
                StubBuilder.addressRequestDTO(), StubBuilder.shiftList(), StubBuilder.barberServiceRequestDTOList(),
                10);
    }

    public static UpdateDataBarberDTO updateDataBarberDTO() {
        return new UpdateDataBarberDTO("Tiago", "51988774455", "tiago@gmail.com", StubBuilder.shiftList(),
                StubBuilder.barberServiceRequestDTOList(), 15);
    }

    public static BarberEntity barberEntity() {
        return new BarberEntity("123", "joão", "51999997563", "joao@gmail.com", "00762345098", StubBuilder.addressEntity(),
                StubBuilder.shiftList(), StubBuilder.barberServiceEntityList(), 10);
    }

    public static BarberEntity barberEntityUpdated(){
        return new BarberEntity(barberEntity().getId(), updateDataBarberDTO().name(), updateDataBarberDTO().phone(),
                updateDataBarberDTO().email(), barberEntity().getCpf(),StubBuilder.addressEntity(), barberEntity().getShift(),
                StubBuilder.barberServiceEntityList(), updateDataBarberDTO().discount());
    }


}
