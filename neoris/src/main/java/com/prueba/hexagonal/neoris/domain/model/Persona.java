package com.prueba.hexagonal.neoris.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.prueba.hexagonal.neoris.domain.enums.GeneroEnum;
import com.prueba.hexagonal.neoris.domain.enums.convertEnum.GeneroEnumConverter;

public class Persona {

    private Long id;
    private String nombre;
    @JsonDeserialize(converter = GeneroEnumConverter.class)
    private GeneroEnum genero;
    private Long edad;
    private String identificacion;
    private String direccion;
    private String telefono;

    private Persona(Builder builder) {
        id = builder.id;
        nombre = builder.nombre;
        genero = builder.genero;
        edad = builder.edad;
        identificacion = builder.identificacion;
        direccion = builder.direccion;
        telefono = builder.telefono;
    }


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public Long getEdad() {
        return edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private Long id;
        private String nombre;
        private GeneroEnum genero;
        private Long edad;
        private String identificacion;
        private String direccion;
        private String telefono;

        private Builder() {
        }



        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder nombre(String val) {
            nombre = val;
            return this;
        }

        public Builder genero(GeneroEnum val) {
            genero = val;
            return this;
        }

        public Builder edad(Long val) {
            edad = val;
            return this;
        }

        public Builder identificacion(String val) {
            identificacion = val;
            return this;
        }

        public Builder direccion(String val) {
            direccion = val;
            return this;
        }

        public Builder telefono(String val) {
            telefono = val;
            return this;
        }

        public Persona build() {
            return new Persona(this);
        }
    }
}
