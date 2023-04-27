package com.prueba.hexagonal.neoris.infraestructure.port.out.cliente.repository;

import com.prueba.hexagonal.neoris.infraestructure.port.out.cliente.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
    @Query("SELECT C FROM ClienteEntity C WHERE C.persona.identificacion = :identificacion")
    Optional<ClienteEntity> findByIdentificacion(String identificacion);
}
