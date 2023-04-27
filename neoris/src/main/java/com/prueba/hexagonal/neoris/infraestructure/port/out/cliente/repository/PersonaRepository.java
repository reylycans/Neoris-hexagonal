package com.prueba.hexagonal.neoris.infraestructure.port.out.cliente.repository;

import com.prueba.hexagonal.neoris.infraestructure.port.out.cliente.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity,Long> {

}
