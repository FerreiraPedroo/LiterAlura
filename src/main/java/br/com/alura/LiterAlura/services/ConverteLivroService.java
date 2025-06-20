package br.com.alura.LiterAlura.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.LiterAlura.interfaces.IConverteLivro;

@Service
public class ConverteLivroService implements IConverteLivro {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> List<T> obterDados(String json, Class<T> classe) {

        try {
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, classe);
            JsonNode node = mapper.readTree(json);
            JsonNode results = node.get("results");

            return mapper.readValue(results.toString(), type);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
