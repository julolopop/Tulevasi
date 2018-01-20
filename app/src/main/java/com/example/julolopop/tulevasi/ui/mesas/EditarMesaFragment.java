package com.example.julolopop.tulevasi.ui.mesas;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.dao.repository.TickedRepository;
import com.example.julolopop.tulevasi.pojo.Mesa;
import com.example.julolopop.tulevasi.pojo.Ticked;


public class EditarMesaFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "EditarMesaFragment";
    private Ticked ticked;
    private TextView txv_nombre;
    private TextView txv_precioTotal;
    private EditText edt_precio;
    private EditText edt_Cantidad;
    private Button btn_ok;
    private Button btn_cancel;
    private OnFragmentEditarMesaListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ticked = getArguments().getParcelable(Ticked.PEDIDOS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editar_mesa, container, false);

        txv_nombre = (TextView)view.findViewById(R.id.txv_nombre);
        txv_precioTotal = (TextView)view.findViewById(R.id.txv_PrecioTotal);
        edt_precio = (EditText)view.findViewById(R.id.edt_Precio);
        edt_Cantidad = (EditText)view.findViewById(R.id.edt_Cantidad);
        btn_ok = (Button)view.findViewById(R.id.btn_ok);
        btn_cancel = (Button)view.findViewById(R.id.btn_cancel);



        if (getArguments() != null) {
            txv_nombre.setText(ticked.getNombre());
            edt_precio.setText(String.valueOf(ticked.getPrecio()));
            edt_Cantidad.setText(String.valueOf(ticked.getCantidad()));
            txv_precioTotal.setText(String.valueOf(ticked.getPrecioTotal()));
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_ok.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentEditarMesaListener) {
            listener = (OnFragmentEditarMesaListener) activity;
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ok:
                ticked.setCantidad(Integer.parseInt(edt_Cantidad.getText().toString()));
                ticked.setPrecio(Float.parseFloat(edt_precio.getText().toString()));
                ticked.setPrecioTotal(ticked.getPrecio()* ticked.getCantidad());

                new TickedRepository(getContext()).EditarTicked(ticked);
                Bundle bundle = new Bundle();
                bundle.putInt(Mesa.ID,getArguments().getInt(Mesa.ID));
                listener.onAbrirMesaActivity(bundle);
                break;
            case R.id.btn_cancel:
                listener.onBack();
                break;
        }
    }

    public interface OnFragmentEditarMesaListener {
        void onAbrirMesaActivity(Bundle bundle);
        void onBack();
    }
}
