package com.example.julolopop.tulevasi.dao.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.julolopop.tulevasi.dao.MesasDao;
import com.example.julolopop.tulevasi.pojo.Ticked;

import java.util.ArrayList;

/**
 * Created by Julolopop on 24/12/2017.
 */

public class TickedRepository {
    private ArrayList<Ticked> arrayTicked;
    private MesasDao mesasDao;


    public TickedRepository(Context context) {
        arrayTicked = new ArrayList<>();


        mesasDao = new MesasDao(context, "DBUsuarios", null, 1);


    }


    public void addTicked(int id) {

        SQLiteDatabase db = mesasDao.getReadableDatabase();


        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Ticked WHERE id_Mesa=" + id + " AND estado=1", null);
            if (c != null) {
                while (c.moveToNext()) {
                    Ticked acc = new Ticked(c.getPosition(), c.getInt(0), c.getInt(1), c.getInt(2), c.getInt(3)
                            , c.getInt(4), c.getString(5), c.getInt(6), c.getInt(7), c.getString(8), c.getInt(9));
                    arrayTicked.add(acc);
                }
            }
        }


        db.close();
    }


    public void EditarTicked(Ticked ticked) {

        SQLiteDatabase db = mesasDao.getReadableDatabase();

        if (db != null) {
            db.execSQL("UPDATE Ticked SET cantidad=" + ticked.getCantidad() + ", precio=" + ticked.getPrecio() + ", PrecioTotal=" + ticked.getPrecioTotal()
                    + " WHERE nombre='" + ticked.getNombre() + "' AND  id_Mesa=" + ticked.getID_Mesa() + " AND  estado=" + ticked.getEstado() + "");

        }

        db.close();
    }

    public void AnadirTicked(Ticked ticked) {

        SQLiteDatabase db = mesasDao.getReadableDatabase();

        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Ticked WHERE id_Mesa=" + ticked.getID_Mesa() + " AND estado=1 AND nombre='" + ticked.getNombre() + "'", null);
            if (c.getCount() == 0) {
                db.execSQL("INSERT INTO Ticked VALUES (" + ticked.getID_Productos() + "," + ticked.getID_Categoria() + "," + ticked.getCantidad() + "," + ticked.getPrecio() + "," + ticked.getPrecioTotal() + ",'" + ticked.getNombre() + "'," + ticked.getID_Mesa() + "," + ticked.getID_trabajador() + ",'" + ticked.getFecha_Ini() + "'," + ticked.getEstado() + ")");
            }else{
                ticked.setCantidadmasmas();
                ticked.setPrecioTotal(ticked.getPrecio()+ticked.getCantidad());
                db.execSQL("UPDATE Ticked SET cantidad=" + ticked.getCantidad() + ", precio=" + ticked.getPrecio() + ", PrecioTotal=" + ticked.getPrecioTotal()
                        + " WHERE nombre='" + ticked.getNombre() + "' AND  id_Mesa=" + ticked.getID_Mesa() + " AND  estado=" + ticked.getEstado() + "");
            }
        }


        db.close();
    }


    public ArrayList<Ticked> getArrayTicked() {
        return arrayTicked;
    }

    public void eliminar(String nombre, int idmesa) {

        SQLiteDatabase db = mesasDao.getReadableDatabase();

        if (db != null) {
            db.execSQL("DELETE FROM Ticked WHERE id_Mesa="+idmesa+" AND nombre='"+nombre+"' AND estado=1");

        }

    }
}
