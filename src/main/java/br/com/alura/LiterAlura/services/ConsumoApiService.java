package br.com.alura.LiterAlura.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class ConsumoApiService {

    public String obterLivro(String nomeLivro) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://gutendex.com/books/?search=" + nomeLivro))
                .build();

        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("ERRO:" + e);
            throw new RuntimeException(e);
        }

        return response.body();
    }
}
