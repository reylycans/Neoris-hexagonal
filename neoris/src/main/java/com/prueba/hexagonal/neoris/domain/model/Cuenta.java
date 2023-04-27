package com.prueba.hexagonal.neoris.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.prueba.hexagonal.neoris.domain.enums.TipoCuentaEnum;
import com.prueba.hexagonal.neoris.domain.enums.convertEnum.TipoCuentaEnumConverter;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cuenta implements Serializable {

    private Long id;
    private String numeroCuenta;
    @JsonDeserialize(converter = TipoCuentaEnumConverter.class)
    private TipoCuentaEnum tipoCuenta;
    private BigDecimal saldoIninial;
    private Boolean estado;
    private Cliente cliente;

    private Cuenta(Builder builder) {
        id = builder.id;
        numeroCuenta = builder.numeroCuenta;
        tipoCuenta = builder.tipoCuenta;
        saldoIninial = builder.saldoIninial;
        estado = builder.estado;
        cliente = builder.cliente;
    }

    public Long getId() {
        return id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public TipoCuentaEnum getTipoCuenta() {
        return tipoCuenta;
    }

    public BigDecimal getSaldoIninial() {
        return saldoIninial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private Long id;
        private String numeroCuenta;
        @JsonDeserialize(converter = TipoCuentaEnumConverter.class)
        private TipoCuentaEnum tipoCuenta;
        private BigDecimal saldoIninial;
        private Boolean estado;
        private Cliente cliente;

        private Builder() {
        }


        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder numeroCuenta(String val) {
            numeroCuenta = val;
            return this;
        }

        public Builder tipoCuenta(TipoCuentaEnum val) {
            tipoCuenta = val;
            return this;
        }

        public Builder saldoIninial(BigDecimal val) {
            saldoIninial = val;
            return this;
        }

        public Builder estado(Boolean val) {
            estado = val;
            return this;
        }

        public Builder cliente(Cliente val) {
            cliente = val;
            return this;
        }

        public Cuenta build() {
            return new Cuenta(this);
        }
    }
}
