package br.com.oracle.apiLivraria.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter{
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convertData(String json, Class<T> wantedClass) {
        try{
            return mapper.readValue(json, wantedClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
