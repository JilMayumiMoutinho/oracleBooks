package br.com.oracle.apiLivraria.service;

public interface IDataConverter {
    <T> T convertData(String json, Class<T> Class);
}
