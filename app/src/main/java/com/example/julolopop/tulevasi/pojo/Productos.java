package com.example.julolopop.tulevasi.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Julolopop on 18/11/2017.
 */

public class Productos implements Parcelable,Comparable<Productos> {

    public static String ID = "IDProductos";

    private int Id;
    private int id_Categoria;
    private String img;
    private float Precio;
    private String nombre;

    public Productos(int id, int id_Categoria, String img, float precio, String nombre) {
        Id = id;
        this.id_Categoria = id_Categoria;
        this.img = img;
        Precio = precio;
        this.nombre = nombre;
    }

    protected Productos(Parcel in) {
        Id = in.readInt();
        id_Categoria = in.readInt();
        img = in.readString();
        Precio = in.readFloat();
        nombre = in.readString();
    }

    public static final Creator<Productos> CREATOR = new Creator<Productos>() {
        @Override
        public Productos createFromParcel(Parcel in) {
            return new Productos(in);
        }

        @Override
        public Productos[] newArray(int size) {
            return new Productos[size];
        }
    };

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(@NonNull Productos o) {
        return this.nombre.compareTo(o.nombre);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeInt(id_Categoria);
        dest.writeString(img);
        dest.writeFloat(Precio);
        dest.writeString(nombre);
    }
}
