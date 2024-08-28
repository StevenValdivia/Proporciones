package org.example.usecase;

import org.example.domain.Proporcion;

public class ProporcioEydanUseCase implements ProporcionUseCaseInput
{
    @Override
    public ProporcionResponse calcular(ProporcionRequest request) {
        Proporcion proporcion = new Proporcion();




        ProporcionResponse response = new ProporcionResponse();
        response.setTotal(request.getTotal());
        response.setMedida1(calcularPrimeraDistancia(request.getMedida1(), request.getSeparador()));
        response.setMedida2(calcularSegundaDistancia(request.getTotal(), request.getMedida1(), request.getSeparador()));
        response.setSeparador(request.getSeparador());
        response.setEspacios(0);
        return response;
    }

    public int calcularPrimeraDistancia(int medida1, int separador)
    {
        return medida1 - (separador*3/2);
    }

    public int calcularSegundaDistancia(int medidaTotal, int medida1, int separador)
    {
        return medidaTotal - medida1 - (separador*3/2);
    }
}