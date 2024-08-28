package org.example.domain;

public class Proporcion {

    public int[] asegurarProporcion(int total) {
        int medida2 = total / 3;
        int medida1 = medida2 * 2;
        return new int[]{medida1, medida2};
    }

    public int calcularValorAjustado(int separador) {
        return (separador * 3) / 2;
    }

    public int[] calcularEspacios(int medida1, int medida2, int valorAjustado) {
        int espacio1 = medida1 - valorAjustado;
        int espacio2 = medida2 - valorAjustado;
        return new int[]{espacio1, espacio2};
    }
}