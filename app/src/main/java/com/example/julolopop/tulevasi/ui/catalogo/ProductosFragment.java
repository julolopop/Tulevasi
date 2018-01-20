package com.example.julolopop.tulevasi.ui.catalogo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.adapter.ProductosAdapter;
import com.example.julolopop.tulevasi.dao.repository.ProductosRepository;
import com.example.julolopop.tulevasi.dao.repository.TickedRepository;
import com.example.julolopop.tulevasi.pojo.Catalogo;
import com.example.julolopop.tulevasi.pojo.Mesa;
import com.example.julolopop.tulevasi.pojo.Productos;
import com.example.julolopop.tulevasi.pojo.Ticked;

import java.util.ArrayList;
import java.util.Date;


public class ProductosFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    public static String TAG = "ProductosFragment";
    private OnFragmentProductosListener listener;
    private int idmesa;
    private int idCategoria;
    ArrayList<Productos> arrayList;
    private Button btn_agregar;

    ListView listView;
    ProductosAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idCategoria = getArguments().getInt(Catalogo.ID);
            idmesa = getArguments().getInt(Mesa.ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productos, container, false);

        listView = (ListView)view.findViewById(android.R.id.list);
        btn_agregar = (Button)view.findViewById(R.id.btn_agregar);

        adapter = new ProductosAdapter(getContext());

        arrayList = new ProductosRepository(getContext()).getProductosArrayList(idCategoria);
        adapter.clear();
        adapter.addAll(arrayList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        btn_agregar.setOnClickListener(this);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentProductosListener) {
            listener = (OnFragmentProductosListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentProductosListener");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();


        new TickedRepository(getContext()).AnadirTicked(new Ticked(0,arrayList.get(position).getId(),arrayList.get(position).getId_Categoria(),1
                ,arrayList.get(position).getPrecio(),arrayList.get(position).getPrecio(),arrayList.get(position).getNombre(),idmesa,1, new Date().toString(),1));


        bundle.putInt(Mesa.ID,idmesa);
        listener.onAbrirMesaActivity(bundle);
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();


        bundle.putInt(Catalogo.ID,idCategoria);
        bundle.putInt(Mesa.ID,idmesa);
        listener.onAnadirNuevoProducto(bundle);
    }


    public interface OnFragmentProductosListener {
        void onAbrirMesaActivity(Bundle bundle);
        void onAnadirNuevoProducto(Bundle bundle);
    }
}
