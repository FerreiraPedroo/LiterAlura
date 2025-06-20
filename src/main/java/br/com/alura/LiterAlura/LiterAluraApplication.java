package br.com.alura.LiterAlura;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.LiterAlura.dto.LivroDTO;
import br.com.alura.LiterAlura.services.ApiService;
import br.com.alura.LiterAlura.services.MenuService;
import br.com.alura.LiterAlura.utils.FormatarTextoUtil;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Autowired
	MenuService menuServico;

	@Autowired
	ApiService api;

	@Override
	public void run(String... args) throws Exception {
		Scanner leitura = new Scanner(System.in);
		int menuSelecionado = 0;
		boolean menuRodando = true;

		while (menuRodando) {

			switch (menuSelecionado) {
				case 0:
					menuServico.exibirMenuPrincipal();
					menuSelecionado = leitura.nextInt();

					if (menuSelecionado == 0) {
						menuRodando = false;
						continue;
					}

					menuServico.limparTela();
					break;

				case 1:
					menuServico.exibirBuscarLivro();
					var textoDigitado = leitura.nextLine();

					if (textoDigitado == "0") {
						menuServico.limparTela();
						menuSelecionado = 1;
					} else {
						String textoFormatado = FormatarTextoUtil.substituirEspacos(textoDigitado);
						List<LivroDTO> livros = api.obterLivros(textoFormatado);

						for (LivroDTO livroDTO : livros) {

							System.out.println(livroDTO.getTitulo());

							
						}
					}

					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
			}
		}

		menuServico.limparTela();
		menuServico.exibirSairPrograma();
	}

}
