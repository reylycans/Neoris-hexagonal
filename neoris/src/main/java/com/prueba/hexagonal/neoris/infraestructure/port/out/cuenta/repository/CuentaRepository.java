package com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.repository;

import com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<CuentaEntity,Long> {
    Optional<CuentaEntity> findByNumeroCuenta(String numeroCuenta);
}
