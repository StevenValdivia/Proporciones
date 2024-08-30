package org.example.infrastructure.view;

import org.example.adapter.presenter.ProporcionPresenter;
import org.example.adapter.presenter.ProporcionViewModel;
import org.example.usecase.ProporcionRepository;
import org.example.usecase.ProporcionRequest;
import org.example.adapter.controller.ProporcionController;
import org.example.usecase.ProporcionUseCaseInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class ProporcionView {

    @Autowired
    private ProporcionRepository proporcionRepository;

    @Autowired
    private ProporcionPresenter proporcionPresenter;

    @Autowired
    private ProporcionUseCaseInput proporcionUseCaseInput;

    @Autowired
    private ProporcionController proporcionController;

    public void view() {
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

        proporcionController.calcular(request);

        ProporcionViewModel viewModel = proporcionPresenter.getViewModel();

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