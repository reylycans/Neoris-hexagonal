package com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.mapper;

import com.prueba.hexagonal.neoris.domain.model.Cliente;
import com.prueba.hexagonal.neoris.domain.model.Cuenta;
import com.prueba.hexagonal.neoris.infraestructure.port.out.cliente.entity.ClienteEntity;
import com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.entity.CuentaEntity;
import org.springframework.stereotype.Component;

@Component
public class CuentaEntityMapper {

    public Cuenta entityToDomain(CuentaEntity cuentaEntity){
        return Cuenta.builder()
                .id(cuentaEntity.getId())
                .numeroCuenta(cuentaEntity.getNumeroCuenta())
                .tipoCuenta(cuentaEntity.getTipoCuenta())
                .saldoIninial(cuentaEntity.getSaldoInicial())
                .estado(cuentaEntity.getEstado())
                .cliente(Cliente.builder()
                        .id(cuentaEntity.getCliente().getId())
                                .build())
                     .build();
    }

    public CuentaEntity domainToEntity(Cuenta cuenta){
        return CuentaEntity.builder()
                .id(cuenta.getId())
                .numeroCuenta(cuenta.getNumeroCuenta())
                .tipoCuenta(cuenta.getTipoCuenta())
                .saldoInicial(cuenta.getSaldoIninial())
                .estado(cuenta.getEstado())
                .cliente(ClienteEntity.builder()
                                .id(cuenta.getCliente().getId())
                                .build())
                .build();
    }
}
