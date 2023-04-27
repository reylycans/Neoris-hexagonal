package com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.adapter;

import com.prueba.hexagonal.neoris.application.port.out.CuentaServicesPort;
import com.prueba.hexagonal.neoris.domain.model.Cuenta;
import com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.mapper.CuentaEntityMapper;
import com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.repository.CuentaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class CuentaRepositoryImpl implements CuentaServicesPort {

    private final CuentaRepository cuentaRepository;
    private final CuentaEntityMapper cuentaEntityMapper;
    public CuentaRepositoryImpl(CuentaRepository cuentaRepository,
                                CuentaEntityMapper cuentaEntityMapper){
        this.cuentaRepository = cuentaRepository;
        this.cuentaEntityMapper = cuentaEntityMapper;
    }

    @Override
    @Transactional
    public Cuenta crearCuenta(Cuenta cuenta) {
        return cuentaEntityMapper.entityToDomain(
                cuentaRepository.save(cuentaEntityMapper.domainToEntity(cuenta)));
    }

    @Override
    public Optional<Cuenta> obtenerCuentaPorId(Long idCuenta) {
        return cuentaRepository.findById(idCuenta).map(cuentaEntityMapper::entityToDomain);
    }

    @Override
    public Cuenta editarCuenta(Cuenta cuenta) {
        return cuentaEntityMapper.entityToDomain(
                cuentaRepository.save(cuentaEntityMapper.domainToEntity(cuenta)));
    }

    @Override
    public Cuenta actualizarCuenta(Cuenta cuenta) {
        return cuentaEntityMapper.entityToDomain(
                cuentaRepository.save(cuentaEntityMapper.domainToEntity(cuenta)));
    }

    @Override
    public Cuenta eliminarCuenta(Long id) {
        Optional<Cuenta> cuentaResult = obtenerCuentaPorId(id);
        cuentaRepository.deleteById(id);
        return cuentaResult.get();
    }

    @Override
    public Boolean consultarExistenciaCuenta(String numeroCuenta) {
        if(cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .map(cuentaEntityMapper::entityToDomain).isPresent()){
            return true;
        }
        return false;
    }
}
