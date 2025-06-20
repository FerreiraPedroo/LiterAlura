package br.com.alura.LiterAlura.utils;

import java.util.Arrays;

public class FormatarTextoUtil {

    public static String substituirEspacos(String texto) {
        return texto.replace(" ", "+");
    }

    public static String caractersCompletar(String textoVariavel, int caracteresInicial, int caracteresFinal) {
        int caracteresTextoVariavel = textoVariavel.length();

        int numeroDeCaractereRestante = 76 - (caracteresInicial + caracteresTextoVariavel + caracteresFinal);

        if (numeroDeCaractereRestante <= 0) {
            numeroDeCaractereRestante = 1;
        }

        char[] caracteresParaCompletar = new char[numeroDeCaractereRestante];
        Arrays.fill(caracteresParaCompletar, ' ');
        return new String(caracteresParaCompletar);

    }

}
