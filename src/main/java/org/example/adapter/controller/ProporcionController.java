package org.example.adapter.controller;

import org.example.usecase.ProporcionCarlosUseCase;
import org.example.usecase.ProporcionRequest;
import org.example.usecase.ProporcionResponse;

public class ProporcionController
{
    public ProporcionResponse calcular(ProporcionRequest request)
    {
        ProporcionCarlosUseCase proporcionUseCase = new ProporcionCarlosUseCase();
        return proporcionUseCase.calcular(request);
    }
}