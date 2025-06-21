package br.com.alura.LiterAlura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.LiterAlura.principal.Principal;
import br.com.alura.LiterAlura.repositories.AutorRepository;
import br.com.alura.LiterAlura.repositories.LivroRepository;
import br.com.alura.LiterAlura.services.ConsumoApiService;
import br.com.alura.LiterAlura.services.ConversorService;
import br.com.alura.LiterAlura.services.TUIService;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository livroRepositorio;
	@Autowired
	private AutorRepository autorRepositorio;
	@Autowired
	private TUIService textoInterfaceServico;
	@Autowired
	private ConsumoApiService consumoApiServico;
	@Autowired
	private ConversorService converteLivro;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livroRepositorio, autorRepositorio, textoInterfaceServico,
				consumoApiServico, converteLivro);
		principal.exibirMenu();

	}

}
