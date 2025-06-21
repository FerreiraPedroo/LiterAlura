package br.com.alura.LiterAlura.principal;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.LiterAlura.DTO.DadosDTO;
import br.com.alura.LiterAlura.DTO.LivroDTO;
import br.com.alura.LiterAlura.models.Autor;
import br.com.alura.LiterAlura.models.Livro;
import br.com.alura.LiterAlura.repositories.AutorRepository;
import br.com.alura.LiterAlura.repositories.LivroRepository;
import br.com.alura.LiterAlura.services.ConsumoApiService;
import br.com.alura.LiterAlura.services.ConversorService;
import br.com.alura.LiterAlura.services.TUIService;
import br.com.alura.LiterAlura.utils.FormatarTextoUtil;

public class Principal {

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

    private Scanner teclado = new Scanner(System.in);

    public Principal(LivroRepository livroRepositorio, AutorRepository autorRepositorio,
            TUIService textoInterfaceServico, ConsumoApiService consumoApiServico, ConversorService converteLivro) {
        this.livroRepositorio = livroRepositorio;
        this.autorRepositorio = autorRepositorio;
        this.textoInterfaceServico = textoInterfaceServico;
        this.consumoApiServico = consumoApiServico;
        this.converteLivro = converteLivro;
    }

    public void exibirMenu() {
        textoInterfaceServico.limparTela();
        var menuSelecionado = 0;
        boolean menuRodando = true;

        while (menuRodando) {
            switch (menuSelecionado) {
                case 0:
                    textoInterfaceServico.exibirMenuPrincipal();
                    menuSelecionado = teclado.nextInt();
                    teclado.nextLine();

                    if (menuSelecionado == 0) {
                        menuRodando = false;
                        continue;
                    }

                    textoInterfaceServico.limparTela();
                    break;

                case 1:
                    textoInterfaceServico.exibirBuscarLivro();
                    var textoDigitado = teclado.nextLine();

                    if (textoDigitado == "0") {
                        textoInterfaceServico.limparTela();
                        menuSelecionado = 0;
                    } else {
                        String textoFormatado = FormatarTextoUtil.substituirEspacos(textoDigitado);
                        String respostaAPI = consumoApiServico.obterLivro(textoFormatado);

                        var dadosBusca = converteLivro.obterDados(respostaAPI, DadosDTO.class);

                        Optional<LivroDTO> dadosLivro = dadosBusca.resultado().stream()
                                .filter(livro -> livro.titulo().toUpperCase().contains(textoFormatado.toUpperCase()))
                                .findFirst();

                        if (dadosLivro.isPresent()) {
                            LivroDTO livro = dadosLivro.get();

                            Optional<Livro> livroModel = livroRepositorio.buscarLivroPorTitulo(livro.titulo());

                            if (livroModel.isPresent()) {
                                System.out.println("Livro encontrado");
                            } else {
                                Autor autorInfo;

                                Optional<Autor> autorEncontrado = autorRepositorio
                                        .buscarAutorPorNome(livro.autores().get(0).nome());

                                if (!autorEncontrado.isPresent()) {
                                    Autor novoAutor = new Autor();
                                    novoAutor.setNome(livro.autores().get(0).nome());
                                    novoAutor.setData_nascimento(livro.autores().get(0).data_nascimento());
                                    novoAutor.setData_falecimento(livro.autores().get(0).data_falecimento());

                                    autorInfo = autorRepositorio.save(novoAutor);
                                    System.out.println(autorInfo);
                                } else {
                                    autorInfo = autorEncontrado.get();
                                }

                                Livro novoLivro = new Livro();
                                novoLivro.setTitulo(livro.titulo());
                                novoLivro.setAutor(autorInfo);
                                novoLivro.setContagem_downloads(livro.contagem_downloads());

                                Livro livroInfo = livroRepositorio.save(novoLivro);

                            }
                            textoInterfaceServico.exibirLivroEncontrado(livro);

                        } else {
                            textoInterfaceServico.exibirLivroNaoEncontrado();
                            teclado.nextLine();
                            textoInterfaceServico.limparTela();
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

        textoInterfaceServico.limparTela();
        textoInterfaceServico.exibirSairPrograma();

    }
}
