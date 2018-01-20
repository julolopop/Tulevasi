package com.example.julolopop.tulevasi.dao.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.julolopop.tulevasi.dao.MesasDao;
import com.example.julolopop.tulevasi.pojo.Catalogo;
import com.example.julolopop.tulevasi.pojo.Mesa;

import java.util.ArrayList;

/**
 * Created by Julolopop on 14/01/2018.
 */

public class CatalogoRepository {

    private ArrayList<Catalogo> catalogoArrayList;

    public CatalogoRepository(Context context) {
        catalogoArrayList = new ArrayList<>();


        MesasDao mesasDao = new MesasDao(context, "DBUsuarios", null, 1);

        SQLiteDatabase db = mesasDao.getReadableDatabase();

        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Catalogo", null);
            if (c != null) {
                while (c.moveToNext()) {
                    Catalogo acc = new Catalogo(c.getPosition(), c.getString(0));
                    catalogoArrayList.add(acc);
                }
            }
        }


        db.close();

    }

    public ArrayList<Catalogo> getCatalogoArrayList() {
        return catalogoArrayList;
    }
}
