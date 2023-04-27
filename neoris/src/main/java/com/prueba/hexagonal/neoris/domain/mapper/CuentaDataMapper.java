package com.prueba.hexagonal.neoris.domain.mapper;

import com.prueba.hexagonal.neoris.application.port.in.command.CuentaCommand;
import com.prueba.hexagonal.neoris.domain.model.Cliente;
import com.prueba.hexagonal.neoris.domain.model.Cuenta;
import com.prueba.hexagonal.neoris.domain.model.Persona;
import org.springframework.stereotype.Component;

@Component
public class CuentaDataMapper {

    public Cuenta commandToDomain(CuentaCommand cuentaCommand){
       return Cuenta.builder()
                .id(cuentaCommand.getCuenta().getId())
                .estado(cuentaCommand.getCuenta().getEstado())
                .saldoIninial(cuentaCommand.getCuenta().getSaldoInicial())
                .numeroCuenta(cuentaCommand.getCuenta().getNumeroCuenta())
                .tipoCuenta(cuentaCommand.getCuenta().getTipoCuenta())
                .cliente(Cliente.builder()
                        .id(cuentaCommand.getCuenta().getCliente().getId())
                       .build())
                .build();
    }
}
