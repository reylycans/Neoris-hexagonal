package com.prueba.hexagonal.neoris.application.services;

import com.prueba.hexagonal.neoris.application.port.in.ClientePort;
import com.prueba.hexagonal.neoris.application.port.in.command.ClienteCommand;
import com.prueba.hexagonal.neoris.application.port.out.ClienteServicesPort;
import com.prueba.hexagonal.neoris.application.port.out.response.ResponseGeneric;
import com.prueba.hexagonal.neoris.application.port.out.response.ResponseServices;
import com.prueba.hexagonal.neoris.domain.exception.DomainException;
import com.prueba.hexagonal.neoris.domain.mapper.ClienteDataMapper;
import com.prueba.hexagonal.neoris.domain.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ClienteServicesImpl implements ClientePort {

    private final ClienteServicesPort clienteServicesPort;
    private final ClienteDataMapper clienteDataMapper;

    public ClienteServicesImpl(ClienteServicesPort clienteServicesPort,
                               ClienteDataMapper clienteDataMapper){
        this.clienteServicesPort = clienteServicesPort;
        this.clienteDataMapper = clienteDataMapper;
    }

    @Override
    public ResponseEntity crearCliente(ClienteCommand cliente) throws DomainException {
        Cliente clienteMapper = clienteDataMapper.commandToDomain(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseServices.builder()
                        .codigo(HttpStatus.OK.value())
                        .detalle(HttpStatus.OK.getReasonPhrase())
                        .objetoRespuesta(new ResponseGeneric(clienteServicesPort.crearCliente(clienteMapper)))
                        .build()
        );
    }

    @Override
    public ResponseEntity obtenerClientePorId(Long idCliente) throws DomainException {

        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseServices.builder()
                        .codigo(HttpStatus.OK.value())
                        .detalle(HttpStatus.OK.getReasonPhrase())
                        .objetoRespuesta(new ResponseGeneric(clienteServicesPort.obtenerClientePorId(idCliente)))
                        .build()
        );
    }

    @Override
    public ResponseEntity editarCliente(ClienteCommand cliente) throws DomainException {
        Cliente clienteMapper = clienteDataMapper.commandToDomain(cliente);
        if(!clienteServicesPort.obtenerClientePorId(cliente.getId()).isPresent()){
            throw new DomainException("No existe usuario con el id: " + cliente.getId(),HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseServices.builder()
                        .codigo(HttpStatus.OK.value())
                        .detalle(HttpStatus.OK.getReasonPhrase())
                        .objetoRespuesta(new ResponseGeneric(clienteServicesPort.editarCliente(clienteMapper)))
                        .build()
        );
    }

    @Override
    public ResponseEntity actualizarCliente(Long idCliente, ClienteCommand cliente) {
        cliente.setId(idCliente);
        Cliente clienteMapper = clienteDataMapper.commandToDomain(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseServices.builder()
                        .codigo(HttpStatus.OK.value())
                        .detalle(HttpStatus.OK.getReasonPhrase())
                        .objetoRespuesta(new ResponseGeneric(clienteServicesPort.actualizarCliente(clienteMapper)))
                        .build()
        );
    }

    @Override
    public ResponseEntity eliminarCliente(Long id) throws DomainException {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseServices.builder()
                        .codigo(HttpStatus.OK.value())
                        .detalle(HttpStatus.OK.getReasonPhrase())
                        .objetoRespuesta(new ResponseGeneric(clienteServicesPort.eliminarCliente(id)))
                        .build()
        );
    }
}
