package com.prueba.hexagonal.neoris.databuilder;

import com.prueba.hexagonal.neoris.application.dto.CuentaDto;
import com.prueba.hexagonal.neoris.application.port.in.command.CuentaCommand;


public class CuentaTestDataBuilder {

    private CuentaDto cuenta;

    public CuentaTestDataBuilder conCuenta(CuentaDto cuenta) {
        this.cuenta=cuenta;
        return this;
    }

    public CuentaCommand buildComando() {
        return new CuentaCommand(cuenta);
    }
}
