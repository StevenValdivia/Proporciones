package org.example;

import org.example.adapter.presenter.ProporcionPresenter;
import org.example.adapter.presenter.ProporcionViewModel;
import org.example.usecase.ProporcionRequest;
import org.example.usecase.ProporcionResponse;
import org.example.adapter.controller.ProporcionController;
import org.example.usecase.ProporcionUseCase;
import org.example.usecase.ProporcionUseCaseInput;

import java.util.Scanner;

public class CalcularMedida {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProporcionRequest request = new ProporcionRequest();

        System.out.print("Ingresa el valor total: ");
        request.setTotal(scanner.nextInt());

        System.out.print("Ingresa el valor de medida1 (inicial, se ajustará): ");
        request.setMedida1(scanner.nextInt());

        System.out.print("Ingresa el valor de medida2 (inicial, se ajustará): ");
        request.setMedida2(scanner.nextInt());

        System.out.print("Ingresa el valor del separador: ");
        request.setSeparador(scanner.nextInt());

        //ProporcionUseCase useCase = new ProporcionUseCase();
        //ProporcionResponse response = useCase.calcular(request);
        ProporcionUseCaseInput useCase = new ProporcionUseCase();
        ProporcionController proporcionController = new ProporcionController();
        //proporcionController.setProporcionUseCaseInput(useCase);


        //ProporcionPresenter proporcionPresenter = new ProporcionPresenter();
        //proporcionPresenter.present()
        ProporcionResponse response = proporcionController.calcular(request);
        ProporcionPresenter proporcionPresenter1 = new ProporcionPresenter();
        ProporcionViewModel viewModel = proporcionPresenter1.present(response);


        System.out.println("Resultados:");
        System.out.println("Total: " + viewModel.getTotal());
        System.out.println("Medida 1 (2x): " + viewModel.getMedida1());
        System.out.println("Medida 2 (x): " + viewModel.getMedida2());
        System.out.println("Separador: " + viewModel.getSeparador());
        System.out.println("Valor Ajustado: " + viewModel.getEspacios());
        System.out.println("Espacio 1 (medida1 - valorAjustado): " + (viewModel.getMedida1()));
        System.out.println("Espacio 2 (medida2 - valorAjustado): " + (viewModel.getMedida2()));

        scanner.close();
    }
}
