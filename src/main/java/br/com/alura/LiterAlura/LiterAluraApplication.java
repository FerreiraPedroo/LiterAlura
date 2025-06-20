package br.com.alura.LiterAlura;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.LiterAlura.dto.LivroDTO;
import br.com.alura.LiterAlura.models.AutorModel;
import br.com.alura.LiterAlura.models.LivroModel;
import br.com.alura.LiterAlura.repositories.AutorRepository;
import br.com.alura.LiterAlura.repositories.LivroRepository;
import br.com.alura.LiterAlura.services.ApiService;
import br.com.alura.LiterAlura.services.TUIService;
import br.com.alura.LiterAlura.utils.FormatarTextoUtil;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Autowired
	TUIService textoInterfaceServico;

	@Autowired
	ApiService api;

	@Autowired
	LivroRepository livroRepositorio;

	@Autowired
	AutorRepository autorRepository;

	@Override
	public void run(String... args) throws Exception {
		Scanner leitura = new Scanner(System.in);
		int menuSelecionado = 0;
		boolean menuRodando = true;

		while (menuRodando) {

			switch (menuSelecionado) {
				case 0:
					textoInterfaceServico.exibirMenuPrincipal();
					menuSelecionado = leitura.nextInt();
					leitura.nextLine();

					if (menuSelecionado == 0) {
						menuRodando = false;
						continue;
					}

					textoInterfaceServico.limparTela();
					break;

				case 1:
					textoInterfaceServico.exibirBuscarLivro();
					var textoDigitado = leitura.nextLine();

					if (textoDigitado == "0") {
						textoInterfaceServico.limparTela();
						menuSelecionado = 0;
					} else {
						String textoFormatado = FormatarTextoUtil.substituirEspacos(textoDigitado);
						List<LivroDTO> livros = api.obterLivros(textoFormatado);

						List<AutorModel> atores = List.of();

						for (LivroDTO livro : livros) {

							// VERIFICA SE O LIVRO EXISTE
							Optional<LivroModel> livroModel = livroRepositorio.buscarLivroPorTitulo(livro.getTitulo());
							if (livroModel.isPresent()) {
								System.out.println("Livro encontrado");
								continue;
							}

							// SE NÃO EXISTIR O LIVRO VERIFICAR SE O AUTOR EXISTE.
							Optional<AutorModel> autorEncontrado = autorRepository
									.buscarAutorPorNome(livro.getAutores().get(0).getNome());

							if (!autorEncontrado.isPresent()) {
								AutorModel novoAutor = new AutorModel();
								novoAutor.setNome(livro.getAutores().get(0).getNome());
								novoAutor.setData_nascimento(livro.getAutores().get(0).getData_nascimento());
								novoAutor.setData_falecimento(livro.getAutores().get(0).getData_falecimento());

								AutorModel autor = autorRepository.save(novoAutor);
								System.out.println(autor);

							}

						}

						// textoInterfaceServico.exibirLivrosBuscados(livros);

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

		textoInterfaceServico.limparTela();
		textoInterfaceServico.exibirSairPrograma();
	}

}
