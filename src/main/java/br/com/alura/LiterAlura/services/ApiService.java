package br.com.alura.LiterAlura.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.alura.LiterAlura.dto.LivroDTO;
import br.com.alura.LiterAlura.models.LivroModel;

@Service
public class ApiService {

    private ConverteLivroService converteLivro;

    @Autowired
    public ApiService(ConverteLivroService converteLivro) {
        this.converteLivro = converteLivro;
    }

    public List<LivroDTO> obterLivros(String param) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://gutendex.com/books/?search="+param))
                .build();

        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("ERRO:" + e);
            throw new RuntimeException(e);
        }

        List<LivroDTO> json = converteLivro.obterDados(response.body(), LivroDTO.class);

        return json;

    }
}
