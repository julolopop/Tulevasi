package com.example.julolopop.tulevasi.ui.catalogo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.adapter.CatalogoAdapter;
import com.example.julolopop.tulevasi.adapter.MesaAdapter;
import com.example.julolopop.tulevasi.dao.repository.CatalogoRepository;
import com.example.julolopop.tulevasi.pojo.Catalogo;
import com.example.julolopop.tulevasi.pojo.Mesa;


public class CatalogoFragment extends Fragment implements AdapterView.OnItemClickListener {

    public  static String TAG = "CatalogoFragment";
    private OnCatalogoFragmentListener listener;
    private int idmesa;

    ListView listView;
    CatalogoAdapter adapter;
    CatalogoRepository catalogoRepository;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idmesa = getArguments().getInt(Mesa.ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_catalogo, container, false);

        listView = (ListView)view.findViewById(android.R.id.list);
        adapter = new CatalogoAdapter(getContext());
        catalogoRepository = new CatalogoRepository(getContext());

        adapter.clear();
        adapter.addAll(catalogoRepository.getCatalogoArrayList());


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnCatalogoFragmentListener) {
            listener = (OnCatalogoFragmentListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnCatalogoFragmentListener");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();

        bundle.putInt(Catalogo.ID,catalogoRepository.getCatalogoArrayList().get(position).getId());
        bundle.putInt(Mesa.ID,idmesa);


        listener.abrirListaProductos(bundle);
    }

    public interface OnCatalogoFragmentListener {
        void abrirListaProductos(Bundle bundle);
    }
}
