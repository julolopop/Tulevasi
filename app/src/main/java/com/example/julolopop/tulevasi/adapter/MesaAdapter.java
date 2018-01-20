package com.example.julolopop.tulevasi.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.pojo.Mesa;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by Julolopop on 23/12/2017.
 */

public class MesaAdapter extends ArrayAdapter<Mesa> {
    public MesaAdapter(@NonNull Context context) {
        super(context, R.layout.items_mesas , new ArrayList<Mesa>());
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MesaHolder holder;
        Bundle bundle = new Bundle();
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items_mesas,null);
            holder = new MesaHolder();

            holder.icon = (MaterialLetterIcon) convertView.findViewById(R.id.Micon);
            holder.txv_Name = (TextView) convertView.findViewById(R.id.txv_name);
            holder.mesa=(ConstraintLayout)convertView.findViewById(R.id.mesa);
            convertView.setTag(holder);

            convertView.setTag(holder);
        }else{
            holder = (MesaHolder) convertView.getTag();
        }



        holder.icon.setLetter(String.valueOf(getItem(position).getId()));
        holder.txv_Name.setText(getItem(position).getNombre());
        bundle.putInt(Mesa.ID,getItem(position).getId());
        holder.txv_Name.setTag(bundle);


        return convertView;

    }


    class MesaHolder {
        MaterialLetterIcon icon;
        TextView txv_Name;
        ConstraintLayout mesa;
    }
}
