package com.prueba.hexagonal.neoris.application.service;


import com.prueba.hexagonal.neoris.application.dto.ClienteDto;
import com.prueba.hexagonal.neoris.application.dto.CuentaDto;
import com.prueba.hexagonal.neoris.application.port.in.command.CuentaCommand;
import com.prueba.hexagonal.neoris.application.port.out.CuentaServicesPort;
import com.prueba.hexagonal.neoris.application.services.CuentaServiceImpl;
import com.prueba.hexagonal.neoris.databuilder.CuentaTestDataBuilder;
import com.prueba.hexagonal.neoris.domain.enums.TipoCuentaEnum;
import com.prueba.hexagonal.neoris.domain.exception.DomainException;
import com.prueba.hexagonal.neoris.domain.mapper.CuentaDataMapper;
import org.junit.Test;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CuentaTestService {
    @Test
    public void numeroCuentaExistente() {
        CuentaCommand cuentaCommand = new CuentaTestDataBuilder()
                .conCuenta(CuentaDto.builder().tipoCuenta(TipoCuentaEnum.AHORRO)
                                                .numeroCuenta("000988")
                                                .estado(true)
                                                .saldoInicial(new BigDecimal(700000))
                                                .cliente(ClienteDto.builder()
                                                .id(1L)
                                                .build()).build()).buildComando();


        CuentaServicesPort cuentaServicesPort = mock(CuentaServicesPort.class);
        CuentaDataMapper cuentaDataMapper = new CuentaDataMapper();

        when(cuentaServicesPort.consultarExistenciaCuenta(cuentaCommand.getCuenta().getNumeroCuenta())).thenReturn(Boolean.TRUE);

        CuentaServiceImpl cuentaService = new CuentaServiceImpl(cuentaServicesPort, cuentaDataMapper);

        DomainException domainException = assertThrows(DomainException.class,
                () -> cuentaService.crearCuenta(cuentaCommand));
        assertEquals("El numero de cuenta: " + cuentaCommand.getCuenta().getNumeroCuenta() + " ya existe", domainException.getMessage());
    }
}
