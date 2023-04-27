package com.prueba.hexagonal.neoris.domain.enums.convertEnum;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.prueba.hexagonal.neoris.domain.enums.TipoMovimientoEnum;
import org.springframework.util.ObjectUtils;

import javax.persistence.AttributeConverter;

public class MovimientoEnumConverter extends StdConverter<String, TipoMovimientoEnum> implements AttributeConverter<TipoMovimientoEnum, String> {
    @Override
    public String convertToDatabaseColumn(TipoMovimientoEnum attribute) {
        if(!ObjectUtils.isEmpty(attribute)) {
            return attribute.getMovimiento();
        }
        return null;
    }

    @Override
    public TipoMovimientoEnum convertToEntityAttribute(String dbData) {
        if(!ObjectUtils.isEmpty(dbData)) {
            return TipoMovimientoEnum.getEnumByMovimiento(dbData);
        }
        return null;
    }

    @Override
    public TipoMovimientoEnum convert(String value) {
        return TipoMovimientoEnum.getEnumByMovimiento(value);
    }
}
