package com.example.julolopop.tulevasi.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.pojo.Catalogo;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by Julolopop on 14/01/2018.
 */

public class CatalogoAdapter extends ArrayAdapter<Catalogo> {
    public CatalogoAdapter(@NonNull Context context) {
        super(context, R.layout.items_mesas,new ArrayList<Catalogo>());
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CatalogoHotler holder;
        Bundle bundle = new Bundle();
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items_mesas,null);
            holder = new CatalogoHotler();

            holder.icon = (MaterialLetterIcon) convertView.findViewById(R.id.Micon);
            holder.txv_Name = (TextView) convertView.findViewById(R.id.txv_name);
            convertView.setTag(holder);

            convertView.setTag(holder);
        }else{
            holder = (CatalogoHotler) convertView.getTag();
        }



        holder.icon.setLetter(String.valueOf(getItem(position).getId()));
        holder.txv_Name.setText(getItem(position).getNombre());

        return convertView;

    }

    class CatalogoHotler{
        MaterialLetterIcon icon;
        TextView txv_Name;
    }
}
