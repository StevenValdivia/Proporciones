package org.example.usecase;

import org.example.domain.Proporcion;

public class ProporcionUseCase implements ProporcionUseCaseInput{

    @Override
    public ProporcionResponse calcular(ProporcionRequest request) {

        int[] medidas = asegurarProporcion(request.getTotal());
        int medida1 = medidas[0];
        int medida2 = medidas[1];

        int valorAjustado = calcularValorAjustado(request.getSeparador());

        int[] espacios = calcularEspacios(medida1, medida2, valorAjustado);
        int espacio1 = espacios[0];
        int espacio2 = espacios[1];

        ProporcionResponse response = new ProporcionResponse();
        response.setTotal(request.getTotal());
        response.setMedida1(espacio1);
        response.setMedida2(espacio2);
        response.setSeparador(request.getSeparador());
        response.setEspacios(valorAjustado);

        return response;
    }

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
