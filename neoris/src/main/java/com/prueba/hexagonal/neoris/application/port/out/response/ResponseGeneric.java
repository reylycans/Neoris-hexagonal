package com.prueba.hexagonal.neoris.application.port.out.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseGeneric<T> {
    private T objectDto;

    private List<T> listObjectDto;

    public ResponseGeneric(T objectDto){
        this.objectDto = objectDto;
    }

    public ResponseGeneric(List<T> listObjectDto){
        this.listObjectDto = listObjectDto;
    }

    public T getObjetoRespuestaDto(){
        return this.objectDto;
    }

    public List<T> getListObjetoRespuestaDto(){
        return this.listObjectDto;
    }
}
