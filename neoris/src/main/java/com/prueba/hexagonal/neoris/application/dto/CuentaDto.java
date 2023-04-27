package com.prueba.hexagonal.neoris.application.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.prueba.hexagonal.neoris.domain.enums.TipoCuentaEnum;
import com.prueba.hexagonal.neoris.domain.enums.convertEnum.TipoCuentaEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDto implements Serializable {
    private Long id;
    @NotNull(message = "El numero de cuenta es obligatorio")
    @NotEmpty(message = "El numero de cuenta es obligatorio")
    @Size(max=6, message = "El numero de cuenta es demasiado larga, por favor verifique la informacion")
    private String numeroCuenta;

    @JsonDeserialize(converter = TipoCuentaEnumConverter.class)
    private TipoCuentaEnum tipoCuenta;

    @NotNull(message = "El saldo inicial es obligatorio")
    private BigDecimal saldoInicial;

    @NotNull(message = "El estado de la cueneta es obligatorio")
    private Boolean estado;

    @NotNull(message = "El id del cliente es obligatorio")
    private ClienteDto cliente;
}
