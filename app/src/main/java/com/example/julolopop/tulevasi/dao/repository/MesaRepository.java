package com.example.julolopop.tulevasi.dao.repository;

import android.accounts.Account;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.julolopop.tulevasi.dao.MesasDao;
import com.example.julolopop.tulevasi.pojo.Mesa;

import java.util.ArrayList;

/**
 * Created by Julolopop on 23/12/2017.
 */

public class MesaRepository {

    private ArrayList<Mesa> mesaArray;

    public MesaRepository(Context context, int zona) {
        this.mesaArray = new ArrayList<>();

        MesasDao mesasDao = new MesasDao(context, "DBUsuarios", null, 1);

        SQLiteDatabase db = mesasDao.getReadableDatabase();

        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Mesa WHERE id_Zona=" + zona, null);
            if (c != null) {
                while (c.moveToNext()) {
                    Mesa acc = new Mesa(c.getPosition(),c.getInt(0),c.getString(1));
                    mesaArray.add(acc);
                }
            }
        }


        db.close();
    }


    public void addMesa(Mesa mesa) {
        mesaArray.add(mesa);
    }

    public ArrayList<Mesa> getMesaArray() {
        return mesaArray;
    }
}
