package com.prueba.hexagonal.neoris.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.prueba.hexagonal.neoris.domain.enums.TipoMovimientoEnum;
import com.prueba.hexagonal.neoris.domain.enums.convertEnum.MovimientoEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoDto implements Serializable {
    private Long id;

    @NotNull(message = "La fecha es obligatoria")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    @JsonDeserialize(converter = MovimientoEnumConverter.class)
    private TipoMovimientoEnum tipoMovimiento;

    @NotNull(message = "El valor del movimiento es obligatorio")
    private BigDecimal valor;

    @NotNull(message = "El saldo del movimiento es obligatorio")
    private BigDecimal saldo;

    @NotNull(message = "La cuenta es obligatoria")
    private CuentaDto cuenta;
}
