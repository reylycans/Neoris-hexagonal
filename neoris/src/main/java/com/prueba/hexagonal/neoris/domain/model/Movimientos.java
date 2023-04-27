package com.prueba.hexagonal.neoris.domain.model;

import com.prueba.hexagonal.neoris.domain.enums.TipoMovimientoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movimientos {
    private Long id;
    private LocalDate fecha;
    private TipoMovimientoEnum tipoMovimiento;
    private BigDecimal valor;
    private BigDecimal saldo;
    private Cuenta cuenta;

    private Movimientos(Builder builder) {
        id = builder.id;
        fecha = builder.fecha;
        tipoMovimiento = builder.tipoMovimiento;
        valor = builder.valor;
        saldo = builder.saldo;
        cuenta = builder.cuenta;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public TipoMovimientoEnum getTipoMovimiento() {
        return tipoMovimiento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private LocalDate fecha;
        private TipoMovimientoEnum tipoMovimiento;
        private BigDecimal valor;
        private BigDecimal saldo;
        private Cuenta cuenta;

        private Builder() {
        }


        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder fecha(LocalDate val) {
            fecha = val;
            return this;
        }

        public Builder tipoMovimiento(TipoMovimientoEnum val) {
            tipoMovimiento = val;
            return this;
        }

        public Builder valor(BigDecimal val) {
            valor = val;
            return this;
        }

        public Builder saldo(BigDecimal val) {
            saldo = val;
            return this;
        }

        public Builder cuenta(Cuenta val) {
            cuenta = val;
            return this;
        }

        public Movimientos build() {
            return new Movimientos(this);
        }
    }
}
