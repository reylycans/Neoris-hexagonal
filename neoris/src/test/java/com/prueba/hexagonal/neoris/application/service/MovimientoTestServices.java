package com.prueba.hexagonal.neoris.application.service;

import com.prueba.hexagonal.neoris.application.dto.CuentaDto;
import com.prueba.hexagonal.neoris.application.dto.MovimientoDto;
import com.prueba.hexagonal.neoris.application.port.in.command.MovimientoCommand;
import com.prueba.hexagonal.neoris.application.port.out.ClienteServicesPort;
import com.prueba.hexagonal.neoris.application.port.out.CuentaServicesPort;
import com.prueba.hexagonal.neoris.application.port.out.MovimientoServicesPort;
import com.prueba.hexagonal.neoris.application.services.MovimientoServicesImpl;
import com.prueba.hexagonal.neoris.databuilder.MovimientoTestDataBuilder;
import com.prueba.hexagonal.neoris.domain.enums.TipoCuentaEnum;
import com.prueba.hexagonal.neoris.domain.enums.TipoMovimientoEnum;
import com.prueba.hexagonal.neoris.domain.exception.DomainException;
import com.prueba.hexagonal.neoris.domain.mapper.MovimientoDataMapper;
import com.prueba.hexagonal.neoris.domain.model.Cliente;
import com.prueba.hexagonal.neoris.domain.model.Cuenta;
import com.prueba.hexagonal.neoris.domain.model.Movimientos;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovimientoTestServices {

    @Test
    public void noExisteCuentaAsociada(){
        MovimientoCommand movimientoCommand = new MovimientoTestDataBuilder()
                .conMovimiento(MovimientoDto.builder()
                        .tipoMovimiento(TipoMovimientoEnum.DEBITO)
                        .fecha(LocalDate.now())
                        .saldo(new BigDecimal(0))
                        .valor(new BigDecimal(100000))
                        .cuenta(CuentaDto.builder()
                                .id(5L).build()).build()).buildComando();

        MovimientoServicesPort movimientoServicesPort = mock(MovimientoServicesPort.class);
        CuentaServicesPort cuentaServicesPort = mock(CuentaServicesPort.class);
        ClienteServicesPort clienteServicesPort = mock(ClienteServicesPort.class);
        MovimientoDataMapper movimientoDataMapper = new MovimientoDataMapper();

        when(cuentaServicesPort.obtenerCuentaPorId(56L)).thenReturn(Optional.empty());

        MovimientoServicesImpl movimientoServices = new MovimientoServicesImpl(movimientoServicesPort,movimientoDataMapper,
                                                                               cuentaServicesPort,clienteServicesPort);

        DomainException domainException = assertThrows(DomainException.class,
                () -> movimientoServices.crearMovimiento(movimientoCommand));
        assertEquals("No existe una cuenta asociada.", domainException.getMessage());
    }
    @Test
    public void saldoNoDisponible(){
        MovimientoCommand movimientoCommand = new MovimientoTestDataBuilder()
                .conMovimiento(MovimientoDto.builder()
                        .tipoMovimiento(TipoMovimientoEnum.DEBITO)
                        .fecha(LocalDate.now())
                        .saldo(new BigDecimal(0))
                        .valor(new BigDecimal(100000))
                        .cuenta(CuentaDto.builder()
                                .id(5L).build()).build()).buildComando();

        MovimientoServicesPort movimientoServicesPort = mock(MovimientoServicesPort.class);
        CuentaServicesPort cuentaServicesPort = mock(CuentaServicesPort.class);
        ClienteServicesPort clienteServicesPort = mock(ClienteServicesPort.class);
        MovimientoDataMapper movimientoDataMapper = new MovimientoDataMapper();
        Optional<Cuenta> cuenta = dataCuenta();
        when(cuentaServicesPort.obtenerCuentaPorId(5L)).thenReturn(cuenta);

        MovimientoServicesImpl movimientoServices = new MovimientoServicesImpl(movimientoServicesPort,movimientoDataMapper,
                cuentaServicesPort,clienteServicesPort);

        DomainException domainException = assertThrows(DomainException.class,
                () -> movimientoServices.crearMovimiento(movimientoCommand));
        assertEquals("Saldo no disponible.", domainException.getMessage());
    }

    public Optional<Cuenta> dataCuenta(){
        return Optional.of(Cuenta.builder().tipoCuenta(TipoCuentaEnum.AHORRO)
                                           .id(5L)
                                           .numeroCuenta("128645")
                                           .estado(true)
                                           .saldoIninial(new BigDecimal(100000))
                                            .cliente(Cliente.builder()
                                            .id(1L)
                                            .build()).build());
    }
    @Test
    public void noExisteMovimientoRangoFecha(){

        MovimientoServicesPort movimientoServicesPort = mock(MovimientoServicesPort.class);
        CuentaServicesPort cuentaServicesPort = mock(CuentaServicesPort.class);
        ClienteServicesPort clienteServicesPort = mock(ClienteServicesPort.class);
        MovimientoDataMapper movimientoDataMapper = new MovimientoDataMapper();
        List<Movimientos> movimientosList = null;
        Optional<Cliente> cliente = dataCliente();
        when(clienteServicesPort.obtenerClientePorId(1L)).thenReturn(cliente);
        when(movimientoServicesPort.obtenerMovimientosPorRangoFecha(LocalDate.now(),LocalDate.now())).thenReturn(movimientosList);

        MovimientoServicesImpl movimientoServices = new MovimientoServicesImpl(movimientoServicesPort,movimientoDataMapper,
                cuentaServicesPort,clienteServicesPort);

        DomainException domainException = assertThrows(DomainException.class,
                () -> movimientoServices.obtenerReportePorFechas(LocalDate.now(),LocalDate.now(),1L));
        assertEquals("No existe movimientos en el rango de las fechas.", domainException.getMessage());
    }

    public Optional<Cliente> dataCliente(){
        return Optional.of(Cliente.builder()
                                    .id(1L)
                                    .build());
    }

}
