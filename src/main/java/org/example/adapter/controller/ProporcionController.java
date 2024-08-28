package org.example.adapter.controller;

import org.example.usecase.ProporcionRequest;
import org.example.usecase.ProporcionResponse;
import org.example.usecase.ProporcionUseCase;
import org.example.usecase.ProporcionUseCaseInput;

public class ProporcionController
{

    public ProporcionResponse calcular(ProporcionRequest request) {
        ProporcionUseCase proporcionUseCase = new ProporcionUseCase();
        ProporcionResponse response = proporcionUseCase.calcular(request);

        return response;

    }
}