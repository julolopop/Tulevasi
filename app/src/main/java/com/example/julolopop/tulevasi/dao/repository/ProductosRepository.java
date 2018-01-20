package com.example.julolopop.tulevasi.dao.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.julolopop.tulevasi.dao.MesasDao;
import com.example.julolopop.tulevasi.pojo.Productos;

import java.util.ArrayList;

/**
 * Created by Julolopop on 14/01/2018.
 */

public class ProductosRepository {
    ArrayList<Productos> productosArrayList;
    MesasDao mesasDao;

    public ProductosRepository(Context context) {
        this.productosArrayList = new ArrayList<>();


        mesasDao = new MesasDao(context, "DBUsuarios", null, 1);
    }


    public void ProductosAnadir(Productos productos) {


        SQLiteDatabase db = mesasDao.getReadableDatabase();


        if (db != null) {
            db.execSQL("INSERT INTO Productos VALUES (" + productos.getId_Categoria() + ", 'null'," + productos.getPrecio() + ",'" + productos.getNombre() + "')");


            db.close();
        }
    }

    public ArrayList<Productos> getProductosArrayList(int id) {

        SQLiteDatabase db = mesasDao.getReadableDatabase();

        if (db != null)

        {
            Cursor c = db.rawQuery("SELECT * FROM Productos WHERE id_Categoria=" + id, null);
            if (c != null) {
                while (c.moveToNext()) {
                    Productos acc = new Productos(c.getPosition(), c.getInt(0), c.getString(1), c.getFloat(2), c.getString(3));
                    productosArrayList.add(acc);
                }
            }
        }


        db.close();


        return productosArrayList;

    }
}
