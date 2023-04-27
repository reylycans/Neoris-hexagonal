package com.prueba.hexagonal.neoris.application.port.in.command;

import com.prueba.hexagonal.neoris.application.dto.CuentaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaCommand {
    private CuentaDto cuenta;
}
