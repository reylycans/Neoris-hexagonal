package com.prueba.hexagonal.neoris.application.port.out;
import com.prueba.hexagonal.neoris.domain.model.Cliente;

import java.util.Optional;

public interface ClienteServicesPort {
    Cliente crearCliente(Cliente cliente);
    Optional<Cliente> obtenerClientePorId(Long idCliente);
    Optional<Cliente> consultarExistencia(String identificacion);
    Cliente editarCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    Cliente eliminarCliente(Long id);
}
