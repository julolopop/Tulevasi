package com.example.julolopop.tulevasi.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Julolopop on 18/11/2017.
 */

public class Catalogo implements Parcelable,Comparable<Catalogo> {

    public static String ID = "IDCATAlOGO";

    private int Id;
    private String nombre;

    public Catalogo(int id, String nombre) {
        Id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected Catalogo(Parcel in) {
        Id = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<Catalogo> CREATOR = new Creator<Catalogo>() {
        @Override
        public Catalogo createFromParcel(Parcel in) {
            return new Catalogo(in);
        }

        @Override
        public Catalogo[] newArray(int size) {
            return new Catalogo[size];
        }
    };

    @Override
    public int compareTo(@NonNull Catalogo o) {
        return this.nombre.compareTo(o.nombre);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeString(nombre);
    }
}
