package com.example.julolopop.tulevasi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.pojo.Ticked;

import java.util.ArrayList;

/**
 * Created by Julolopop on 24/12/2017.
 */

public class PedidosAdapter extends ArrayAdapter<Ticked> {
    public PedidosAdapter(@NonNull Context context) {
        super(context, R.layout.items_ticked,new ArrayList<Ticked>());
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TickedHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items_ticked,null);
            holder = new TickedHolder();

            holder.txv_name = (TextView) convertView.findViewById(R.id.txv_Nombre);
            holder.txv_cantidad = (TextView) convertView.findViewById(R.id.txv_cantidad);
            holder.txv_Total = (TextView) convertView.findViewById(R.id.txv_Precio);

            convertView.setTag(holder);
        }else{
            holder = (TickedHolder) convertView.getTag();
        }


        holder.txv_name.setText(getItem(position).getNombre());
        holder.txv_cantidad.setText(String.valueOf(getItem(position).getCantidad()));
        holder.txv_Total.setText(String.valueOf(getItem(position).getPrecioTotal()));


        return convertView;
    }

    class TickedHolder {
        TextView txv_name;
        TextView txv_cantidad;
        TextView txv_Total;
    }
}
