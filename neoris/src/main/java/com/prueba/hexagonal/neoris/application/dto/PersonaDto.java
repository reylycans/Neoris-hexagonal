package com.prueba.hexagonal.neoris.application.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.prueba.hexagonal.neoris.domain.enums.GeneroEnum;
import com.prueba.hexagonal.neoris.domain.enums.convertEnum.GeneroEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {
    private Long id;
    @NotNull(message = "El nombre obligatorio")
    @NotEmpty(message = "El nombre es obligatorio")
    @Size(max=50, message = "El nombre es demasiado largo, por favor verifique la informacion")
    private String nombre;

    @JsonDeserialize(converter = GeneroEnumConverter.class)
    private GeneroEnum genero;

    @NotNull(message = "La edad es obligatoria")
    private Long edad;

    @NotNull(message = "El número de indentificacion es obligatorio")
    @NotEmpty(message = "El número de indentificacion es obligatorio")
    @Size(max=10, message = "El número de indentifiacion es demasiado largo, por favor verifique la informacion")
    private String identificacion;

    @NotNull(message = "La direccion es obligatoria")
    @NotEmpty(message = "LA direccion es obligatoria")
    @Size(max=60, message = "La dirección es demasiado larga, por favor verifique la informacion")
    private String direccion;


    @NotNull(message = "El telefono es obligatorio")
    @NotEmpty(message = "El telefono es obligatorio")
    @Size(max=10, message = "El número de telefono es demasiado largo, por favor verifique la informacion")
    private String telefono;
}
