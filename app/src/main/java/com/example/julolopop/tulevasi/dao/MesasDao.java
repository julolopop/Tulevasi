package com.example.julolopop.tulevasi.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Julolopop on 23/12/2017.
 */

public class MesasDao extends SQLiteOpenHelper {

    String sqlCreateMesa = "CREATE TABLE Mesa (id_Zona INTEGER, nombre TEXT)";
    String sqlCreateTicked = "CREATE TABLE Ticked (id_Productos INTEGER,id_Catalogo INTEGER,cantidad INTEGER,precio FLOAT,PrecioTotal FLOAT, nombre TEXT,id_Mesa INTEGER,id_Trabajador INTEGER,fechaIni TEXT, estado INTEGER)";
    String sqlCreateProductos = "CREATE TABLE Productos (id_Categoria INTEGER,img TEXT,precio FLOAT,nombre TEXT)";
    String sqlCreateCatalogo = "CREATE TABLE Catalogo (nombre TEXT)";


    public MesasDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla

        crear(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        crear(db);
    }



    public void crear(SQLiteDatabase db){


        db.execSQL("DROP TABLE IF EXISTS Mesa");
        db.execSQL("DROP TABLE IF EXISTS Ticked");
        db.execSQL("DROP TABLE IF EXISTS Productos");
        db.execSQL("DROP TABLE IF EXISTS Catalogo");

        db.execSQL(sqlCreateMesa);
        db.execSQL(sqlCreateTicked);
        db.execSQL(sqlCreateProductos);
        db.execSQL(sqlCreateCatalogo);


        for (int i = 1; i <= 5; i++) {
            //Generamos los datos
            int zona = 1;
            String nombre = "Mesa" + i;

            //Insertamos los datos en la tabla Usuarios
            db.execSQL("INSERT INTO Mesa " +
                    "VALUES (" + zona + ", '" + nombre + "')");
        }




        for (int i = 1; i <= 5; i++) {
            //Generamos los datos
            int pedido = i;
            int mesa = 1;
            int trabajador = 1;
            Date fecha = new Date();
            int estado = 1;
            int producto = i;
            int catalogo = 1;
            int cantidad = i;
            float dinero = 2;
            String nombre = "pedido" + i;

            //Insertamos los datos en la tabla Usuarios
            db.execSQL("INSERT INTO Ticked " +
                    "VALUES ("  + producto + ", " + catalogo + ", " +cantidad+" , "+ dinero + ", " + dinero + ", '"  + nombre  + "', " + mesa + ", "+ trabajador + ", '" + fecha + "', "  + estado + ")");
        }



        for (int i = 1; i <= 5; i++) {
            //Generamos los datos
            int categoria = 1;
            String img = null;
            float precio = i;
            String nombre = "producto "+i;

            //Insertamos los datos en la tabla Usuarios
            db.execSQL("INSERT INTO Productos " +
                    "VALUES (" + categoria + ", " + img + ", "+ precio + ", '" + nombre + "')");
        }

        for (int i = 1; i <= 5; i++) {
            //Generamos los datos
            String catalogo = "catalogo "+i;

            //Insertamos los datos en la tabla Usuarios
            db.execSQL("INSERT INTO Catalogo " +
                    "VALUES ('" + catalogo +"')");
        }


        db.close();
    }

}
