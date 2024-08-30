package org.example.adapter.controller;

import org.example.usecase.ProporcionRequest;
import org.example.usecase.ProporcionUseCaseInput;

public class ProporcionController {

    private ProporcionUseCaseInput proporcionUseCaseInput;

    public ProporcionController (ProporcionUseCaseInput proporcionUseCaseInput) {
        this.proporcionUseCaseInput = proporcionUseCaseInput;
    }

    public void calcular(ProporcionRequest request) {
        proporcionUseCaseInput.calcular(request);
    }
}