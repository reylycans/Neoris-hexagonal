package com.prueba.hexagonal.neoris.application.port.in.command;

import com.prueba.hexagonal.neoris.application.dto.MovimientoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoCommand {
   private MovimientoDto movimiento;
}
