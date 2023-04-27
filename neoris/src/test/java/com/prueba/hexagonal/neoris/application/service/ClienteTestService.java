package com.prueba.hexagonal.neoris.application.service;

import com.prueba.hexagonal.neoris.application.dto.PersonaDto;
import com.prueba.hexagonal.neoris.application.port.in.command.ClienteCommand;
import com.prueba.hexagonal.neoris.application.port.out.ClienteServicesPort;
import com.prueba.hexagonal.neoris.application.services.ClienteServicesImpl;
import com.prueba.hexagonal.neoris.databuilder.ClienteTestDataBuilder;
import com.prueba.hexagonal.neoris.domain.enums.GeneroEnum;
import com.prueba.hexagonal.neoris.domain.exception.DomainException;
import com.prueba.hexagonal.neoris.domain.mapper.ClienteDataMapper;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class ClienteTestService {

    private final Long ID_CLIENTE = 5L;

    @Test
    public void validarCrearCliente(){
        ClienteCommand clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conIdCliente(null).conPersona(PersonaDto.builder()
                                                .direccion("test direccion")
                                                .edad(30L)
                                                .genero(GeneroEnum.MASCULINO)
                                                .nombre("Manuel")
                                                .telefono("30058643")
                                                .identificacion("12345").build()).buildComando();

        ClienteServicesPort clienteServicesPort = mock(ClienteServicesPort.class);

        ClienteDataMapper clienteDataMapper = new ClienteDataMapper();
        ClienteServicesImpl clienteServices = new ClienteServicesImpl(clienteServicesPort,clienteDataMapper);
        ResponseEntity responseEntity = clienteServices.crearCliente(clienteTestDataBuilder);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
    @Test
    public void editarClienteNoExisteUsuario(){
        ClienteCommand clienteTestDataBuilder = new ClienteTestDataBuilder()
                                        .conIdCliente(5L).conPersona(PersonaDto.builder()
                                                            .id(1L)
                                                            .direccion("test direccion")
                                                            .edad(30L)
                                                            .genero(GeneroEnum.MASCULINO)
                                                            .nombre("Manuel de avila")
                                                            .telefono("30058643")
                                                             .identificacion("12345")
                                                            .build()).buildComando();

        ClienteServicesPort clienteServicesPort = mock(ClienteServicesPort.class);

        ClienteDataMapper clienteDataMapper = new ClienteDataMapper();
        ClienteServicesImpl clienteServices = new ClienteServicesImpl(clienteServicesPort,clienteDataMapper);

        DomainException domainException = assertThrows(DomainException.class,
                () -> clienteServices.editarCliente(clienteTestDataBuilder));
        assertEquals("No existe usuario con el id: " + ID_CLIENTE, domainException.getMessage());
    }
}
