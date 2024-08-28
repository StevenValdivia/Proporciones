package org.example.usecase;

import org.example.domain.Proporcion;

public class ProporcionUseCase implements ProporcionUseCaseInput{

    @Override
    public ProporcionResponse calcular(ProporcionRequest request) {
        Proporcion proporcion = new Proporcion();

        int[] medidas = proporcion.asegurarProporcion(request.getTotal());
        int medida1 = medidas[0];
        int medida2 = medidas[1];

        int valorAjustado = proporcion.calcularValorAjustado(request.getSeparador());

        int[] espacios = proporcion.calcularEspacios(medida1, medida2, valorAjustado);
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
}
