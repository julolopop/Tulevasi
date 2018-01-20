package com.example.julolopop.tulevasi.ui.mesas.interactor;

import android.os.Bundle;

import com.example.julolopop.tulevasi.dao.repository.TickedRepository;
import com.example.julolopop.tulevasi.ui.mesas.presenter.ListaMesaPresenter;
import com.example.julolopop.tulevasi.ui.mesas.presenter.ListaMesasPresenter;

/**
 * Created by Julolopop on 24/12/2017.
 */

public class ListaMesaInteractor {

    private ListaMesaPresenter presenter;

    public ListaMesaInteractor(ListaMesaPresenter presenter) {
        this.presenter = presenter;
    }



    public void ActualizarInteractor() {
        presenter.onSusses();
    }
}
