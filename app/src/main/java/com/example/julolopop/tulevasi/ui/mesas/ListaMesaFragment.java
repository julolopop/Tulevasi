package com.example.julolopop.tulevasi.ui.mesas;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.adapter.PedidosAdapter;
import com.example.julolopop.tulevasi.dao.repository.MesaRepository;
import com.example.julolopop.tulevasi.dao.repository.TickedRepository;
import com.example.julolopop.tulevasi.pojo.Mesa;
import com.example.julolopop.tulevasi.pojo.Ticked;
import com.example.julolopop.tulevasi.ui.mesas.presenter.ListaMesaPresenter;
import com.example.julolopop.tulevasi.utils.Utils;

import java.util.ArrayList;


public class ListaMesaFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener {

    public static final String TAG = "ListaMesaFragment";
    private int id;
    private OnFragmentListaMesaListener listener;
    ListView lista;
    PedidosAdapter adapter;
    TickedRepository tickedRepository;
    Button btn_agregar;
    ListaMesaPresenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(Mesa.ID);
        }
        presenter = new ListaMesaPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_mesa, container, false);
        lista = (ListView)view.findViewById(android.R.id.list);
        adapter = new PedidosAdapter(getContext());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lista.setAdapter(adapter);
        adapter.clear();

        tickedRepository = new TickedRepository(getContext());
        tickedRepository.addTicked(id);

        btn_agregar = (Button) view.findViewById(R.id.btn_agregar);

        adapter.addAll(tickedRepository.getArrayTicked());

        lista.setOnItemClickListener(this);
        btn_agregar.setOnClickListener(this);
        lista.setOnItemLongClickListener(this);


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentListaMesaListener) {
            listener = (OnFragmentListaMesaListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnCatalogoFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();


        bundle.putParcelable(Ticked.PEDIDOS, tickedRepository.getArrayTicked().get(position));
        bundle.putInt(Mesa.ID, this.id);

        listener.abrirEditarFragment(bundle);
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();

        bundle.putInt(Mesa.ID, this.id);

        listener.abrirCatalogo(bundle);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Utils.Alertdialog(getContext(),tickedRepository.getArrayTicked().get(position).getNombre(),this.id,presenter).show();
        return true;
    }

    public void ActualizarVista() {
        tickedRepository = new TickedRepository(getContext());
        tickedRepository.addTicked(id);

        adapter.clear();
        adapter.addAll(tickedRepository.getArrayTicked());

    }

    public interface OnFragmentListaMesaListener {
        void abrirEditarFragment(Bundle bundle);
        void abrirCatalogo(Bundle bundle);
    }
}
