package com.example.julolopop.tulevasi.ui.mesas.presenter;

import android.content.Context;
import android.os.Bundle;

import com.example.julolopop.tulevasi.ui.mesas.ListaMesasFragment;
import com.example.julolopop.tulevasi.ui.mesas.interactor.ListaMesasInteractor;

/**
 * Created by Julolopop on 24/12/2017.
 */

public class ListaMesasPresenter {
    ListaMesasFragment view;
    ListaMesasInteractor interactor;

    public ListaMesasPresenter(ListaMesasFragment view) {
        this.view = view;
        this.interactor = new ListaMesasInteractor(this);
    }


    public void abrirMesaPresenter(Object obj) {
        interactor.abrirMesaInteractor(obj);
    }

    public void onAbrirMesaPresenter(Bundle bundle) {
        view.onAbrirMesa(bundle);
    }

    public void Error() {
        view.Error();
    }


}
