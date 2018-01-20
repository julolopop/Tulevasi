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
import com.example.julolopop.tulevasi.pojo.Productos;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by Julolopop on 14/01/2018.
 */

public class ProductosAdapter extends ArrayAdapter<Productos> {
    public ProductosAdapter(@NonNull Context context) {
        super(context, R.layout.item_catalogo,new ArrayList<Productos>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ProductosHotler hotler;


        if(convertView == null){
            hotler = new ProductosHotler();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_catalogo,null);

            hotler.nombre = (TextView)convertView.findViewById(R.id.txv_name);
            hotler.precio = (TextView)convertView.findViewById(R.id.txv_SortName);
            hotler.icon = (MaterialLetterIcon)convertView.findViewById(R.id.Micon);


            convertView.setTag(hotler);
        }else{
            hotler = (ProductosHotler) convertView.getTag();
        }

        hotler.nombre.setText(getItem(position).getNombre());
        hotler.precio.setText(String.valueOf(getItem(position).getPrecio()));
        hotler.icon.setLetter(getItem(position).getNombre().substring(0,1));


        return convertView;
    }

    class ProductosHotler{
        TextView nombre;
        TextView precio;
        MaterialLetterIcon icon;
    }
}
