package com.prueba.hexagonal.neoris.infraestructure.port.out.movimiento.mapper;


import com.prueba.hexagonal.neoris.domain.model.Cuenta;
import com.prueba.hexagonal.neoris.domain.model.Movimientos;

import com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.entity.CuentaEntity;
import com.prueba.hexagonal.neoris.infraestructure.port.out.movimiento.entity.MovimientoEntity;
import org.springframework.stereotype.Component;

@Component
public class MovimientoDataEntityMapper {

    public Movimientos entityToDoman(MovimientoEntity movimientoEntity){
       return Movimientos.builder()
                .id(movimientoEntity.getId())
                .valor(movimientoEntity.getValor())
                .saldo(movimientoEntity.getSaldo())
                .fecha(movimientoEntity.getFecha())
                .tipoMovimiento(movimientoEntity.getTipoMovimiento())
                .cuenta(Cuenta.builder()
                        .id(movimientoEntity.getCuenta().getId())
                        .build())
                   .build();
    }

    public MovimientoEntity domainToEntity(Movimientos movimientos){
        return MovimientoEntity.builder()
                .id(movimientos.getId())
                .valor(movimientos.getValor())
                .saldo(movimientos.getSaldo())
                .fecha(movimientos.getFecha())
                .tipoMovimiento(movimientos.getTipoMovimiento())
                .cuenta(CuentaEntity.builder()
                        .id(movimientos.getCuenta().getId())
                        .build())
                .build();
    }
}
