package br.com.alura.LiterAlura.interfaces;

import java.util.List;

public interface IConverteLivro {
    <T> T obterDados(String json, Class<T> classe);
}
