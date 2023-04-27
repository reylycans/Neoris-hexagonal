package com.prueba.hexagonal.neoris.application.port.in;
import com.prueba.hexagonal.neoris.application.port.in.command.MovimientoCommand;
import com.prueba.hexagonal.neoris.domain.exception.DomainException;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface MovimientoPort {
    ResponseEntity crearMovimiento(MovimientoCommand movimientoCommand) throws DomainException;
    ResponseEntity obtenerMovimientoPorId(Long idMovimiento) throws DomainException;
    ResponseEntity editarMovimiento(MovimientoCommand movimientoCommand) throws DomainException;
    ResponseEntity actualizarMovimiento(Long idMovimiento, MovimientoCommand movimientoCommand);
    ResponseEntity eliminarMovimiento(Long idMovimiento) throws DomainException;
    ResponseEntity obtenerReportePorFechas(LocalDate fechaInicial, LocalDate fechaFinal, Long idCliente) throws DomainException;
}
