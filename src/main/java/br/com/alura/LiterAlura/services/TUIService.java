package br.com.alura.LiterAlura.services;

import java.util.Arrays;
import java.util.List;

import br.com.alura.LiterAlura.models.Autor;
import br.com.alura.LiterAlura.models.Livro;
import org.springframework.stereotype.Service;

import br.com.alura.LiterAlura.DTO.LivroDTO;
import br.com.alura.LiterAlura.utils.FormatarTextoUtil;

@Service
public class TUIService {

    public void exibirMenuCabecalho() {
        System.out.println("┌──────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                                                          │");
        System.out.println("│                               LITER ALURA                                │");
        System.out.println("│                                                                          │");
        System.out.println("├──────────────────────────────────────────────────────────────────────────┤");
    }

    public void exibirMenuPrincipal() {
        this.limparTela();
        System.out.println("┌──────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                                                          │");
        System.out.println("│                               LITER ALURA                                │");
        System.out.println("│                                                                          │");
        System.out.println("├──────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│    MENU PRINCIPAL                                                        │");
        System.out.println("│                                                                          │");
        System.out.println("│  1 - Buscar livro pelo título                                            │");
        System.out.println("│  2 - Listar livros registrados                                           │");
        System.out.println("│  3 - Listar autores registrados                                          │");
        System.out.println("│  4 - Listar autores vivos em um deteminado ano                           │");
        System.out.println("│  5 - Listar livros em um deteminado idioma                               │");
        System.out.println("│                                                                          │");
        System.out.println("│  0 - Sair                                                                │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirBuscarLivro() {
        this.limparTela();
        System.out.println("┌──────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                                                          │");
        System.out.println("│                               LITER ALURA                                │");
        System.out.println("│                                                                          │");
        System.out.println("├──────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│    BUSCAR LIVRO PELO TITULO                                              │");
        System.out.println("│                                                                          │");
        System.out.println("│    Digite o nome do livro:                                               │");
        System.out.println("│                                                                          │");
        System.out.println("│  0 - Voltar                                                              │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirLivrosRegistrados(List<LivroDTO> livros) {
        this.limparTela();
        this.exibirMenuCabecalho();

        System.out.println("│    LIVROS REGISTRADOS                                                    │");
        System.out.println("│                                                                          │");

        for (LivroDTO livro : livros) {
            String tituloCompletar = FormatarTextoUtil.caractersCompletar(livro.titulo(), 14, 1);
            String autorCompletar = FormatarTextoUtil.caractersCompletar(livro.autor().get(0).nome(), 14, 1);
            String idiomaCompletar = FormatarTextoUtil.caractersCompletar(Arrays.stream(livro.idiomas()).reduce("", (acc, cur) -> cur == "" ? acc : acc + cur + " | "), 14, 1);
            String contagemDownloadsCompletar = FormatarTextoUtil.caractersCompletar(Integer.toString(livro.contagem_downloads()).trim(), 27, 1);

            System.out.println("│    -----------------------------------------------------------------     │");
            System.out.println("│     Titulo: " + livro.titulo() + tituloCompletar + "│");
            System.out.println("│     Autor : " + livro.autor().get(0).nome() + autorCompletar + "│");
            System.out.println("│     Idioma: " + Arrays.stream(livro.idiomas()).reduce("", (acc, cur) -> cur == "" ? acc : acc + cur + " | ") + idiomaCompletar + "│");
            System.out.println("│     Número de downloads: " + livro.contagem_downloads() + contagemDownloadsCompletar + "│");
            System.out.println("│    -----------------------------------------------------------------     │");
            System.out.println("│                                                                          │");

        }
        System.out.println("│                                                                          │");
        System.out.println("│  [ENTER] - Voltar                                                        │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirAutoresRegistrados(List<Autor> autores) {
        this.limparTela();
        this.exibirMenuCabecalho();

        System.out.println("│    AUTORES REGISTRADOS                                                   │");
        System.out.println("│                                                                          │");

        for (Autor autor : autores) {
            String nomeCompletar = FormatarTextoUtil.caractersCompletar(autor.getNome(), 12, 1);
            String nascimentoCompletar = FormatarTextoUtil.caractersCompletar(Integer.toString(autor.getData_nascimento()), 26, 1);
            String falecimentoCompletar = FormatarTextoUtil.caractersCompletar(Integer.toString(autor.getData_falecimento()), 27, 1);

            System.out.println("│    -----------------------------------------------------------------     │");
            System.out.println("│     Nome: " + autor.getNome() + nomeCompletar + "│");
            System.out.println("│     Data de nascimento: " + autor.getData_nascimento() + nascimentoCompletar + "│");
            System.out.println("│     Data de falecimento: " + autor.getData_falecimento() + falecimentoCompletar + "│");
            System.out.println("│    -----------------------------------------------------------------     │");
            System.out.println("│                                                                          │");
        }
        System.out.println("│                                                                          │");
        System.out.println("│  [ENTER] - Voltar                                                        │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirLivroEncontrado(LivroDTO livro) {
        this.limparTela();
        this.exibirMenuCabecalho();

        System.out.println("│    LIVRO ENCONTRADO                                                      │");
        System.out.println("│                                                                          │");

        String tituloCompletar = FormatarTextoUtil.caractersCompletar(livro.titulo(), 14, 1);
        String autorCompletar = FormatarTextoUtil.caractersCompletar(livro.autor().get(0).nome(), 14, 1);
        String idiomaCompletar = FormatarTextoUtil.caractersCompletar(livro.idiomas()[0], 14, 1);
        String contagemDownloadsCompletar = FormatarTextoUtil.caractersCompletar(Integer.toString(livro.contagem_downloads()).trim(), 27, 1);

        System.out.println("│    -----------------------------------------------------------------     │");
        System.out.println("│     Titulo: " + livro.titulo() + tituloCompletar + "│");
        System.out.println("│     Autor : " + livro.autor().get(0).nome() + autorCompletar + "│");
        System.out.println("│     Idioma: " + livro.idiomas()[0] + idiomaCompletar + "│");
        System.out.println("│     Número de downloads: " + livro.contagem_downloads() + contagemDownloadsCompletar + "│");
        System.out.println("│    -----------------------------------------------------------------     │");
        System.out.println("│                                                                          │");
        System.out.println("│                                                                          │");
        System.out.println("│  [ENTER] - Voltar                                                        │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirLivroNaoEncontrado() {
        this.limparTela();
        this.exibirMenuCabecalho();

        System.out.println("│    LIVRO NÃO ENCONTRADO                                                  │");
        System.out.println("│                                                                          │");
        System.out.println("│                                                                          │");
        System.out.println("│  [ENTER] - Voltar                                                        │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirAutorVivoDeterminadoAno(List<Autor> autores) {
        this.limparTela();
        this.exibirMenuCabecalho();

        System.out.println("│    AUTORES VIVOS                                                         │");
        System.out.println("│                                                                          │");

        if (autores.isEmpty()) {
            System.out.println("│    NENHUM AUTOR ENCONTRADO                                               │");
        } else {
            for (Autor autor : autores) {
                String nomeCompletar = FormatarTextoUtil.caractersCompletar(autor.getNome(), 12, 1);
                String nascimentoCompletar = FormatarTextoUtil.caractersCompletar(Integer.toString(autor.getData_nascimento()), 26, 1);
                String falecimentoCompletar = FormatarTextoUtil.caractersCompletar(Integer.toString(autor.getData_falecimento()), 27, 1);

                System.out.println("│    -----------------------------------------------------------------     │");
                System.out.println("│     Nome: " + autor.getNome() + nomeCompletar + "│");
                System.out.println("│     Data de nascimento: " + autor.getData_nascimento() + nascimentoCompletar + "│");
                System.out.println("│     Data de falecimento: " + autor.getData_falecimento() + falecimentoCompletar + "│");
                System.out.println("│    -----------------------------------------------------------------     │");
                System.out.println("│                                                                          │");
            }
        }

        System.out.println("│                                                                          │");
        System.out.println("│  [ENTER] - Voltar                                                        │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirBuscaAutorPorAno() {
        this.limparTela();
        System.out.println("┌──────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                                                          │");
        System.out.println("│                               LITER ALURA                                │");
        System.out.println("│                                                                          │");
        System.out.println("├──────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│    BUSCAR AUTORES VIVOS EM DETERMINADO ANO                               │");
        System.out.println("│                                                                          │");
        System.out.println("│    Digite o ano:                                                         │");
        System.out.println("│                                                                          │");
        System.out.println("│  0 - Voltar                                                              │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirAnoDigitadoInvalido() {
        this.limparTela();
        this.exibirMenuCabecalho();

        System.out.println("│    ANO INVÁLIDO                                                          │");
        System.out.println("│                                                                          │");
        System.out.println("│                                                                          │");
        System.out.println("│  [ENTER] - Voltar                                                        │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirEscolherLivroDeteminadoIdioma() {
        this.limparTela();
        this.exibirMenuCabecalho();
        System.out.println("│    ESCOLHA UM IDIOMA                                                     │");
        System.out.println("│                                                                          │");
        System.out.println("│    [es] - Espanhol                                                       │");
        System.out.println("│    [fr] - Francês                                                        │");
        System.out.println("│    [en] - Inglês                                                         │");
        System.out.println("│    [pt] - Português                                                      │");
        System.out.println("│                                                                          │");
        System.out.println("│  0 - Voltar                                                              │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirLivrosPorIdioma(List<Livro> livros) {
        this.limparTela();
        this.exibirMenuCabecalho();

        System.out.println("│    LIVROS ENCONTRADOS                                                    │");
        System.out.println("│                                                                          │");
        for (Livro livro : livros) {
            String tituloCompletar = FormatarTextoUtil.caractersCompletar(livro.getTitulo(), 14, 1);
            String autorCompletar = FormatarTextoUtil.caractersCompletar(livro.getAutor().getNome(), 14, 1);
            String idiomaCompletar = FormatarTextoUtil.caractersCompletar(Arrays.stream(livro.getIdiomas()).reduce("", (acc, cur) -> cur == "" ? acc : acc + cur + " | "), 14, 1);
            String contagemDownloadsCompletar = FormatarTextoUtil.caractersCompletar(Integer.toString(livro.getContagem_downloads()).trim(), 27, 1);

            System.out.println("│    -----------------------------------------------------------------     │");
            System.out.println("│     Titulo: " + livro.getTitulo() + tituloCompletar + "│");
            System.out.println("│     Autor : " + livro.getAutor().getNome() + autorCompletar + "│");
            System.out.println("│     Idioma: " + Arrays.stream(livro.getIdiomas()).reduce("", (acc, cur) -> cur == "" ? acc : acc + cur + " | ") + idiomaCompletar + "│");
            System.out.println("│     Número de downloads: " + livro.getContagem_downloads() + contagemDownloadsCompletar + "│");
            System.out.println("│    -----------------------------------------------------------------     │");
            System.out.println("│                                                                          │");

        }
        System.out.println("│                                                                          │");
        System.out.println("│  [ENTER] - Voltar                                                        │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirLivroNoIdiomaNaoEncontrado() {
        this.limparTela();
        this.exibirMenuCabecalho();

        System.out.println("│    NENHUM LIVRO NO IDIOMA SELECIONADO FOI ENCONTRADO                     │");
        System.out.println("│                                                                          │");
        System.out.println("│                                                                          │");
        System.out.println("│  [ENTER] - Voltar                                                        │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirIdiomaInvalido() {
        this.limparTela();
        this.exibirMenuCabecalho();

        System.out.println("│    IDIOMA INVÁLIDO                                                       │");
        System.out.println("│                                                                          │");
        System.out.println("│                                                                          │");
        System.out.println("│  [ENTER] - Voltar                                                        │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirSairPrograma() {
        System.out.println("┌──────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                  DESAFIO                                 │");
        System.out.println("│                                LITER ALURA                               │");
        System.out.println("├──────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│                                                                          │");
        System.out.println("│    Desenvolvido por: Pedro Ferreira                                      │");
        System.out.println("│                                                                          │");
        System.out.println("│    Agradecimentos  : Alura                                               │");
        System.out.println("│                      Oracle ONE                                          │");
        System.out.println("│                                                                          │");
        System.out.println("│                                                                   @2025  │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void limparTela() {
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }

    }
}
