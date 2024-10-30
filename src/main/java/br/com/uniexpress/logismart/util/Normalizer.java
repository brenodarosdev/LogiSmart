package br.com.uniexpress.logismart.util;

public class Normalizer {
    public static String normalizar(String valor) {
        if (valor == null) {
            return null;
        }
        return valor.replaceAll("[^\\d\\.-/]", "").replaceAll("[^\\d]", "");    }
}
