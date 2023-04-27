package com.prueba.hexagonal.neoris.databuilder;

import com.prueba.hexagonal.neoris.application.dto.MovimientoDto;
import com.prueba.hexagonal.neoris.application.port.in.command.MovimientoCommand;

public class MovimientoTestDataBuilder {

    private MovimientoDto movimiento;

    public MovimientoTestDataBuilder conMovimiento(MovimientoDto movimiento) {
        this.movimiento=movimiento;
        return this;
    }

    public MovimientoCommand buildComando() {
        return new MovimientoCommand(movimiento);
    }
}
