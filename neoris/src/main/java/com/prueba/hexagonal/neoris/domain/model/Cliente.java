package com.prueba.hexagonal.neoris.domain.model;

public class Cliente {
    private Long id;
    private Persona persona;
    private String contrasena;
    private Boolean estado;

    private Cliente(Builder builder) {
        id = builder.id;
        persona = builder.persona;
        contrasena = builder.contrasena;
        estado = builder.estado;
    }

    public Long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Boolean getEstado() {
        return estado;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Persona persona;
        private String contrasena;
        private Boolean estado;

        private Builder() {
        }



        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder persona(Persona val) {
            persona = val;
            return this;
        }

        public Builder contrasena(String val) {
            contrasena = val;
            return this;
        }

        public Builder estado(Boolean val) {
            estado = val;
            return this;
        }

        public Cliente build() {
            return new Cliente(this);
        }
    }
}
