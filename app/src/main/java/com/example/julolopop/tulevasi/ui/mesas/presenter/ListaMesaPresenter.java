package com.example.julolopop.tulevasi.ui.mesas.presenter;

import android.os.Bundle;

import com.example.julolopop.tulevasi.ui.mesas.ListaMesaFragment;
import com.example.julolopop.tulevasi.ui.mesas.ListaMesasFragment;
import com.example.julolopop.tulevasi.ui.mesas.interactor.ListaMesaInteractor;
import com.example.julolopop.tulevasi.ui.mesas.interactor.ListaMesasInteractor;

/**
 * Created by Julolopop on 24/12/2017.
 */

public class ListaMesaPresenter {
    ListaMesaFragment view;
    ListaMesaInteractor interactor;

    public ListaMesaPresenter(ListaMesaFragment view) {
        this.view = view;
        this.interactor = new ListaMesaInteractor(this);
    }



    public void ActualizarPresenter() {
    interactor.ActualizarInteractor();
    }

    public void onSusses() {
        view.ActualizarVista();
    }
}
