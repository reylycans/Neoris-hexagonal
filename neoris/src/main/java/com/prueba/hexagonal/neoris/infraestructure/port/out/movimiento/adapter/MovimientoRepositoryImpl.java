package com.prueba.hexagonal.neoris.infraestructure.port.out.movimiento.adapter;

import com.prueba.hexagonal.neoris.application.port.out.MovimientoServicesPort;
import com.prueba.hexagonal.neoris.domain.model.Movimientos;
import com.prueba.hexagonal.neoris.infraestructure.port.out.movimiento.mapper.MovimientoDataEntityMapper;
import com.prueba.hexagonal.neoris.infraestructure.port.out.movimiento.repository.MovimientoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovimientoRepositoryImpl implements MovimientoServicesPort {

    private final MovimientoRepository movimientoRepository;
    private final MovimientoDataEntityMapper movimientoDataEntityMapper;
    public MovimientoRepositoryImpl(MovimientoRepository movimientoRepository,
                                    MovimientoDataEntityMapper movimientoDataEntityMapper){
        this.movimientoRepository = movimientoRepository;
        this.movimientoDataEntityMapper = movimientoDataEntityMapper;
    }

    @Override
    @Transactional
    public Movimientos crearMovimiento(Movimientos movimientos) {
        return movimientoDataEntityMapper.entityToDoman(movimientoRepository.save(movimientoDataEntityMapper.domainToEntity(movimientos)));
    }

    @Override
    public Optional<Movimientos> obtenerMovimientoPorId(Long idMovimiento) {
        return movimientoRepository.findById(idMovimiento).map(movimientoDataEntityMapper::entityToDoman);
    }

    @Override
    public Movimientos editarMovimiento(Movimientos movimientoDto) {
        return movimientoDataEntityMapper.entityToDoman(movimientoRepository.save(movimientoDataEntityMapper.domainToEntity(movimientoDto)));
    }

    @Override
    public Movimientos actualizarMovimiento(Movimientos movimientoDto) {
        return movimientoDataEntityMapper.entityToDoman(movimientoRepository.save(movimientoDataEntityMapper.domainToEntity(movimientoDto)));
    }

    @Override
    public Movimientos eliminarMovimiento(Long id) {
        Optional<Movimientos> movimientos = obtenerMovimientoPorId(id);
        movimientoRepository.deleteById(id);
        return movimientos.get();
    }

    @Override
    public List<Movimientos> obtenerMovimientosPorRangoFecha(LocalDate fechaInicial, LocalDate fechaFinal) {
        return movimientoRepository.obtenerMovimientosPorRangoFecha(fechaInicial,fechaFinal)
                                   .stream().map(movimientoEntity -> movimientoDataEntityMapper.entityToDoman(movimientoEntity))
                                   .collect(Collectors.toList());
    }
}
