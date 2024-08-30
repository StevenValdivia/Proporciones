package org.example.adapter.controller;

import org.example.usecase.ProporcionRequest;
import org.example.usecase.ProporcionUseCaseInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProporcionController {
    @Autowired
    private ProporcionUseCaseInput proporcionUseCaseInput;

    public void calcular(ProporcionRequest request) {
        proporcionUseCaseInput.calcular(request);
    }
}