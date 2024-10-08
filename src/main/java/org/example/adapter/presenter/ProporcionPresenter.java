package org.example.adapter.presenter;

import org.example.usecase.ProporcionResponse;
import org.example.usecase.ProporcionUseCaseOutput;

public class ProporcionPresenter implements ProporcionUseCaseOutput {

    private ProporcionViewModel viewModel;

    @Override
    public void crearViewModel(ProporcionResponse response) {
        viewModel = new ProporcionViewModel();
        viewModel.setTotal(response.getTotal());
        viewModel.setSeparador(response.getSeparador());
        viewModel.setMedida1(response.getMedida1());
        viewModel.setMedida2(response.getMedida2());
        viewModel.setEspacios(response.getEspacios());
    }
    public ProporcionViewModel getViewModel() {
        return viewModel;
    }
}
