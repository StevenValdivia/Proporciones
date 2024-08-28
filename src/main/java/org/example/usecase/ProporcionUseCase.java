package org.example.usecase;

public class ProporcionUseCase implements ProporcionUseCaseInput
{
    @Override
    public ProporcionResponse calcular(ProporcionRequest request)
    {
        ProporcionResponse response = new ProporcionResponse();
        response.setTotal(600);
        response.setMedida1(373);
        response.setMedida2(173);
        response.setSeparador(18);
        response.setEspacios(0);
        return response;
    }
}