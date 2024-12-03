package br.com.oracle.apiLivraria.util;

import java.util.Arrays;
import java.util.List;

public final class Constants {
    public String menu = """
                    
                    ***************************** MENU *****************************
                    Digite a opção desejada:
                    
                     1- Buscar livro pelo título
                     2- Listar livros registrados
                     3- Listar autores registrados
                     4- Listar autores vivos em um determinado ano
                     5- Listar livros em um determinado idioma
                    
                     0- Sair
                    ****************************************************************
                    """;

    public static String languagesOptions = """
                    1- Inglês - en
                    2- Espanhol - es
                    3- Francês - fr
                    4- Portugues - pt
                    """;

    public static List<String> languagesTranslator = Arrays.asList("en", "es", "fr", "pt");

    public static String addressURL = "https://gutendex.com/books/?search=%20";
}
