package com.prueba.hexagonal.neoris.application.port.out;

import com.prueba.hexagonal.neoris.domain.model.Cuenta;

import java.util.Optional;

public interface CuentaServicesPort {
    Cuenta crearCuenta(Cuenta cuenta) ;
    Optional<Cuenta> obtenerCuentaPorId(Long idCuenta) ;
    Cuenta editarCuenta(Cuenta cuenta);
    Cuenta actualizarCuenta( Cuenta cuenta) ;
    Cuenta eliminarCuenta(Long id);
    Boolean consultarExistenciaCuenta(String numeroCuenta);
}
