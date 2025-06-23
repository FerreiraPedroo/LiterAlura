package br.com.alura.LiterAlura.principal;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import br.com.alura.LiterAlura.DTO.AutorDTO;
import org.springframework.aot.hint.TypeReference;
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

    private ConsumoApiService consumoApiServico = new ConsumoApiService();
    private ConversorService converteLivro = new ConversorService();
    private TUIService textoInterfaceServico = new TUIService();
    private Scanner teclado = new Scanner(System.in);

    public Principal(LivroRepository livroRepositorio, AutorRepository autorRepositorio) {
        this.livroRepositorio = livroRepositorio;
        this.autorRepositorio = autorRepositorio;
    }

    public void exibirMenu() {
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

                    break;

                case 1:
                    textoInterfaceServico.exibirBuscarLivro();
                    var textoDigitado = teclado.nextLine();

                    if (textoDigitado.equals("0")) {
                        menuSelecionado = 0;
                    } else if (textoDigitado.equals("")) {
                        textoInterfaceServico.exibirLivroNaoEncontrado();
                        teclado.nextLine();
                    } else {
                        String tituloFormatado = FormatarTextoUtil.substituirEspacos(textoDigitado);

                        String respostaAPI = consumoApiServico.obterLivro(tituloFormatado);

                        var dadosLivroConvertido = converteLivro.obterDados(respostaAPI, DadosDTO.class);

                        Optional<LivroDTO> dadosLivro = dadosLivroConvertido.resultados().stream().filter(livro -> livro.titulo().toUpperCase().contains(tituloFormatado.toUpperCase())).findFirst();

                        if (dadosLivro.isPresent()) {
                            LivroDTO livroDados = dadosLivro.get();

                            Optional<Livro> livroModel = livroRepositorio.buscarLivroPorTitulo(livroDados.titulo());

                            if (livroModel.isPresent()) {
                                textoInterfaceServico.exibirLivroEncontrado(livroDados);
                            } else {
                                Autor autorInfo;
                                Optional<Autor> autorEncontrado = autorRepositorio.buscarAutorPorNome(livroDados.autor().get(0).nome());

                                if (!autorEncontrado.isPresent()) {
                                    Autor novoAutor = new Autor();
                                    novoAutor.setNome(livroDados.autor().get(0).nome());
                                    novoAutor.setData_nascimento(livroDados.autor().get(0).data_nascimento());
                                    novoAutor.setData_falecimento(livroDados.autor().get(0).data_falecimento());

                                    autorInfo = autorRepositorio.save(novoAutor);
                                    System.out.println(autorInfo);
                                } else {
                                    autorInfo = autorEncontrado.get();
                                }

                                Livro novoLivro = new Livro();
                                novoLivro.setTitulo(livroDados.titulo());
                                novoLivro.setAutor(autorInfo);
                                novoLivro.setIdiomas(livroDados.idiomas());
                                novoLivro.setContagem_downloads(livroDados.contagem_downloads());

                                Livro livroInfo = livroRepositorio.save(novoLivro);

                                AutorDTO autor = new AutorDTO(livroInfo.getAutor().getNome(), livroInfo.getAutor().getData_nascimento(), livroInfo.getAutor().getData_falecimento());

                                LivroDTO livro = new LivroDTO(livroInfo.getTitulo(), List.of(autor), livroInfo.getIdiomas(), livroInfo.getContagem_downloads()

                                );

                                textoInterfaceServico.exibirLivroEncontrado(livro);
                            }

                            teclado.nextLine();

                        } else {
                            textoInterfaceServico.exibirLivroNaoEncontrado();
                            teclado.nextLine();
                        }


                    }

                    break;


                case 2:
                    List<Livro> livros = livroRepositorio.findAll();

                    List<LivroDTO> livrosInfo = livros.stream().map(livro -> new LivroDTO(livro.getTitulo(), List.of(new AutorDTO(livro.getAutor().getNome(), livro.getAutor().getData_nascimento(), livro.getAutor().getData_falecimento())), livro.getIdiomas(), livro.getContagem_downloads())).toList();

                    textoInterfaceServico.exibirLivrosRegistrados(livrosInfo);

                    teclado.nextLine();
                    menuSelecionado = 0;

                    break;


                case 3:
                    List<Autor> autores = autorRepositorio.findAll();
//                    List<Autor> autoresInfo = autores.stream().map(autor -> new AutorDTO(autor.getNome(), autor.getData_nascimento(), autor.getData_falecimento())).toList();

                    textoInterfaceServico.exibirAutoresRegistrados(autores);

                    teclado.nextLine();
                    menuSelecionado = 0;

                    break;


                case 4:
                    textoInterfaceServico.exibirBuscaAutorPorAno();
                    var anoDigitado = teclado.nextLine();

                    int anoNumerico;
                    try {
                        anoNumerico = Integer.parseInt(anoDigitado);
                    } catch (NumberFormatException e) {
                        textoInterfaceServico.exibirAnoDigitadoInvalido();
                        teclado.nextLine();
                        continue;
                    }

                    if (anoNumerico == 0) {
                        menuSelecionado = 0;
                        continue;
                    }

                    Optional<Autor> autoresPorAno = autorRepositorio.buscaAutorPorAno(anoNumerico);
                    List<Autor> autoresPorAnoLista = autoresPorAno.stream().toList();

                    textoInterfaceServico.exibirAutorVivoDeterminadoAno(autoresPorAnoLista);

                    teclado.nextLine();
                    menuSelecionado = 0;

                    break;


                case 5:
                    textoInterfaceServico.exibirEscolherLivroDeteminadoIdioma();

                    var idiomaDigitado = teclado.nextLine();

                    if (idiomaDigitado.equals("0")) {
                        menuSelecionado = 0;
                        continue;
                    }

                    List<String> idiomas = List.of("pt", "fr", "en", "es");

                    if (!idiomas.stream().filter(i -> Objects.equals(i, idiomaDigitado)).toList().isEmpty()) {

                        List<Livro> livrosPorIdioma = livroRepositorio.buscarLivroPorIdioma(idiomaDigitado);

                        if (!livrosPorIdioma.isEmpty()) {
                            textoInterfaceServico.exibirLivrosPorIdioma(livrosPorIdioma.stream().toList());
                            teclado.nextLine();
                            continue;
                        }
                        textoInterfaceServico.exibirLivroNoIdiomaNaoEncontrado();
                        teclado.nextLine();
                        continue;
                    }
                    textoInterfaceServico.exibirIdiomaInvalido();
                    teclado.nextLine();
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

        textoInterfaceServico.exibirSairPrograma();

    }
}
