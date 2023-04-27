package com.prueba.hexagonal.neoris.application.port.in;

import com.prueba.hexagonal.neoris.application.port.in.command.ClienteCommand;
import com.prueba.hexagonal.neoris.domain.exception.DomainException;
import org.springframework.http.ResponseEntity;

public interface ClientePort {
    ResponseEntity crearCliente(ClienteCommand cliente) throws DomainException;
    ResponseEntity obtenerClientePorId(Long idCliente) throws DomainException;
    ResponseEntity editarCliente(ClienteCommand cliente) throws DomainException;
    ResponseEntity actualizarCliente(Long idCliente, ClienteCommand cliente);
    ResponseEntity eliminarCliente(Long id) throws DomainException;
}
