package com.daimainardi.barbershop.controller;

import com.daimainardi.barbershop.entity.BarberEntity;
import com.daimainardi.barbershop.request.BarberRequestDTO;
import com.daimainardi.barbershop.request.UpdateDataBarberDTO;
import com.daimainardi.barbershop.response.BarberDTO;
import com.daimainardi.barbershop.response.BarberResponseDTO;
import com.daimainardi.barbershop.service.BarberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/barbers")
@RequiredArgsConstructor
@Tag(name = "Barber", description = "Barber management")
public class BarberController {

    private final BarberService barberService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Create a new Barber")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Barber successfully registered",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BarberEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "An error occurred on the server")
    })
    @Transactional
    @PostMapping
    public BarberResponseDTO create(@RequestBody @Valid BarberRequestDTO barberRequestDTO) {
        return barberService.createBarber(barberRequestDTO);
    }

    @Operation(summary = "Find a Barber by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the barber",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BarberEntity.class))}),
            @ApiResponse(responseCode = "404", description = "Barber not found"),
            @ApiResponse(responseCode = "500", description = "Bad server")
    })
    @GetMapping(value = "/{id}")
    public BarberResponseDTO findById(@Parameter(description = "id of the barber to be searched") @PathVariable String id) {
        return barberService.findBarberById(id);
    }

    @Operation(summary = "Find a list of barbers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Barbers found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BarberEntity.class))}),
            @ApiResponse(responseCode = "404", description = "Barbers not found"),
            @ApiResponse(responseCode = "500", description = "Bad server")
    })
    @GetMapping
    public List<BarberDTO> findAll() {
        return barberService.findAll();
    }

    @Operation(summary = "Update barber")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated barber",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BarberEntity.class))}),
            @ApiResponse(responseCode = "404", description = "Barber not found"),
            @ApiResponse(responseCode = "500", description = "Bad server")
    })
    @Transactional
    @PutMapping(value = "/{id}")
    public BarberResponseDTO update(@Parameter(description = "barber id to be updated") @PathVariable String id,
                                    @RequestBody @Valid UpdateDataBarberDTO updateDataDTO) {
        return barberService.update(id, updateDataDTO);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete barber")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Barber deleted"),
            @ApiResponse(responseCode = "404", description = "Barber not found"),
            @ApiResponse(responseCode = "500", description = "Bad server")
    })
    @Transactional
    @DeleteMapping(value = "/{id}")
    public void deleteById(@Parameter(description = "barber id to be deleted") @PathVariable String id) {
        barberService.delete(id);
    }
}
