package org.example.adapter.controller;

import org.example.usecase.*;

public class ProporcionController
{

    public ProporcionResponse calcular(ProporcionRequest request) {
        ProporcioEydanUseCase proporcionUseCase = new ProporcioEydanUseCase();
        ProporcionResponse response = proporcionUseCase.calcular(request);

      return response;

    }
}