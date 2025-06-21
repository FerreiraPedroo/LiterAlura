package br.com.alura.LiterAlura.services;

import java.util.List;

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
    };

    public void exibirBuscarLivro() {
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

    public void exibirLivrosBuscados(List<LivroDTO> livros) {
        this.exibirMenuCabecalho();

        // System.out.println("│    LIVROS ENCONTRADOS                                                    │");
        // System.out.println("│                                                                          │");

        // for (LivroDTO livro : livros) {
        //     String tituloCompletar = FormatarTextoUtil.caractersCompletar(livro.getTitulo(), 14, 1);
        //     String autorCompletar = FormatarTextoUtil.caractersCompletar(livro.getAutores().get(0).getNome(), 14, 1);
        //     String idiomaCompletar = FormatarTextoUtil.caractersCompletar(livro.getIdiomas().get(0), 14, 1);
        //     String contagemDownloadsCompletar = FormatarTextoUtil
        //             .caractersCompletar(Integer.toString(livro.getContagem_downloads()).trim(), 27, 1);

        //     System.out.println("│    -----------------------------------------------------------------     │");
        //     System.out.println("│     Titulo: " + livro.getTitulo() + tituloCompletar + "│");
        //     System.out.println("│     Autor : " + livro.getAutores().get(0).getNome() + autorCompletar + "│");
        //     System.out.println("│     Idioma: " + livro.getIdiomas().get(0) + idiomaCompletar + "│");
        //     System.out.println(
        //             "│     Número de downloads: " + livro.getContagem_downloads() + contagemDownloadsCompletar + "│");
        //     System.out.println("│    -----------------------------------------------------------------     │");
        //     System.out.println("│                                                                          │");

        // }
        // System.out.println("│                                                                          │");
        // System.out.println("│  0 - Voltar                                                              │");
        // System.out.println("│                                                                          │");
        // System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirLivroEncontrado(LivroDTO livro) {
        this.exibirMenuCabecalho();

        System.out.println("│    LIVRO ENCONTRADO                                                      │");
        System.out.println("│                                                                          │");

        String tituloCompletar = FormatarTextoUtil.caractersCompletar(livro.titulo(), 14, 1);
        String autorCompletar = FormatarTextoUtil.caractersCompletar(livro.autores().get(0).nome(), 14, 1);
        String idiomaCompletar = FormatarTextoUtil.caractersCompletar(livro.idiomas().get(0), 14, 1);
        String contagemDownloadsCompletar = FormatarTextoUtil
                .caractersCompletar(Integer.toString(livro.contagem_downloads()).trim(), 27, 1);

        System.out.println("│    -----------------------------------------------------------------     │");
        System.out.println("│     Titulo: " + livro.titulo() + tituloCompletar + "│");
        System.out.println("│     Autor : " + livro.autores().get(0).nome() + autorCompletar + "│");
        System.out.println("│     Idioma: " + livro.idiomas().get(0) + idiomaCompletar + "│");
        System.out.println(
                "│     Número de downloads: " + livro.contagem_downloads() + contagemDownloadsCompletar + "│");
        System.out.println("│    -----------------------------------------------------------------     │");
        System.out.println("│                                                                          │");
        System.out.println("│                                                                          │");
        System.out.println("│  0 - Voltar                                                              │");
        System.out.println("│                                                                          │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }

    public void exibirLivroNaoEncontrado() {
        this.exibirMenuCabecalho();

        System.out.println("│    LIVRO NÃO ENCONTRADO                                                  │");
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
        for (int i = 0; i < 25; i++) {
            System.out.println("");
        }

    }
}
