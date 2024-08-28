package org.example.adapter.presenter;

import org.example.usecase.ProporcionResponse;

public class ProporcionPresenter

{
    public ProporcionViewModel present(ProporcionResponse response){
    ProporcionViewModel viewModel = new ProporcionViewModel();
    viewModel.setTotal(response.getTotal());
    viewModel.setSeparador(response.getTotal());
    viewModel.setMedida1(response.getMedida1());
    viewModel.setMedida2(response.getMedida2());
    viewModel.setEspacios(response.getEspacios());

    return viewModel;
    }
}