package br.com.alura.LiterAlura.services;

import org.springframework.stereotype.Service;


@Service
public class MenuService {

    public void exibirMenuPrincipal() {
        System.out.println("┌──────────────────────────────────────────────────┐");
        System.out.println("│                                                  │");
        System.out.println("│                    LITER ALURA                   │");
        System.out.println("│                                                  │");
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│    MENU PRINCIPAL                                │");
        System.out.println("│                                                  │");
        System.out.println("│  1 - Buscar livro pelo título                    │");
        System.out.println("│  2 - Listar livros registrados                   │");
        System.out.println("│  3 - Listar autores registrados                  │");
        System.out.println("│  4 - Listar autores vivos em um deteminado ano   │");
        System.out.println("│  5 - Listar livros em um deteminado idioma       │");
        System.out.println("│                                                  │");
        System.out.println("│  0 - Sair                                        │");
        System.out.println("│                                                  │");
        System.out.println("└──────────────────────────────────────────────────┘");
    };

    public void exibirBuscarLivro() {
        System.out.println("┌──────────────────────────────────────────────────┐");
        System.out.println("│                                                  │");
        System.out.println("│                    LITER ALURA                   │");
        System.out.println("│                                                  │");
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│    BUSCAR LIVRO PELO TITULO                      │");
        System.out.println("│                                                  │");
        System.out.println("│    Digite o nome do livro:                       │");
        System.out.println("│                                                  │");
        System.out.println("│  0 - Voltar                                      │");
        System.out.println("│                                                  │");
        System.out.println("└──────────────────────────────────────────────────┘");
    }

    public void limparTela() {
        for (int i = 0; i < 25; i++) {
            System.out.println("");
        }

    }

    public void exibirSairPrograma() {
        System.out.println("┌──────────────────────────────────────────────────┐");
        System.out.println("│                      DESAFIO                     │");
        System.out.println("│                    LITER ALURA                   │");
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│                                                  │");
        System.out.println("│    Desenvolvido por: Pedro Ferreira              │");
        System.out.println("│                                                  │");
        System.out.println("│    Agradecimentos  : Alura                       │");
        System.out.println("│                      Oracle ONE                  │");
        System.out.println("│                                                  │");
        System.out.println("│                                           @2025  │");
        System.out.println("│                                                  │");
        System.out.println("└──────────────────────────────────────────────────┘");
    }
}
