package com.prueba.hexagonal.neoris.domain.mapper;

import com.prueba.hexagonal.neoris.application.port.in.command.MovimientoCommand;
import com.prueba.hexagonal.neoris.domain.model.Cliente;
import com.prueba.hexagonal.neoris.domain.model.Cuenta;
import com.prueba.hexagonal.neoris.domain.model.Movimientos;
import com.prueba.hexagonal.neoris.domain.model.Persona;
import org.springframework.stereotype.Component;

@Component
public class MovimientoDataMapper {

    public Movimientos commandToDomain(MovimientoCommand movimientoCommand){
       return Movimientos.builder()
                .id(movimientoCommand.getMovimiento().getId())
                .fecha(movimientoCommand.getMovimiento().getFecha())
                .tipoMovimiento(movimientoCommand.getMovimiento().getTipoMovimiento())
                .cuenta(Cuenta.builder()
                        .id(movimientoCommand.getMovimiento().getCuenta().getId())
                        .build())
                .valor(movimientoCommand.getMovimiento().getValor())
                .saldo(movimientoCommand.getMovimiento().getSaldo())
                .build();
    }
}
