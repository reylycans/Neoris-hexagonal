package com.prueba.hexagonal.neoris.infraestructure.port.out.cliente.entity;

import com.prueba.hexagonal.neoris.domain.enums.GeneroEnum;
import com.prueba.hexagonal.neoris.domain.enums.convertEnum.GeneroEnumConverter;
import lombok.*;

import javax.persistence.*;
import javax.persistence.GenerationType;


@Getter
@Setter
@Entity
@Table(name = "persona")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 8, nullable = false)
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "genero", length = 9)
    @Convert(converter = GeneroEnumConverter.class)
    private GeneroEnum genero;

    @Column(name = "edad", length = 3)
    private Long edad;

    @Column(name = "identificacion", length = 10)
    private String identificacion;

    @Column(name = "direccion", length = 60)
    private String direccion;

    @Column(name = "telefono", length = 10)
    private String telefono;
}
