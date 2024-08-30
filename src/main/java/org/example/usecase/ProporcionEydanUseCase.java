package org.example.usecase;

import org.example.domain.Proporcion;

public class ProporcionEydanUseCase implements ProporcionUseCaseInput{

    private ProporcionUseCaseOutput proporcionUseCaseOutput;

    private  ProporcionRepository proporcionRepository;

    public ProporcionEydanUseCase  (ProporcionUseCaseOutput proporcionUseCaseOutput, ProporcionRepository proporcionRepository){
        this.proporcionUseCaseOutput = proporcionUseCaseOutput;
        this.proporcionRepository = proporcionRepository;
    }

    @Override
    public void calcular(ProporcionRequest request) {
        Proporcion proporcion = new Proporcion();
        proporcion.setTotal(request.getTotal());
        proporcion.setMedida1(request.getMedida1());
        proporcion.setMedida2(request.getMedida2());
        proporcion.setSeparador(request.getSeparador());
        proporcionRepository.save(proporcion);

        ProporcionResponse response = new ProporcionResponse();
        response.setTotal(request.getTotal());
        response.setMedida1(proporcion.calcularPrimeraDistancia(request.getMedida1(), request.getSeparador()));
        response.setMedida2(proporcion.calcularSegundaDistancia(request.getTotal(), request.getMedida1(), request.getSeparador()));
        response.setSeparador(request.getSeparador());
        response.setEspacios(request.getSeparador());
        proporcionUseCaseOutput.crearViewModel(response);
    }
}