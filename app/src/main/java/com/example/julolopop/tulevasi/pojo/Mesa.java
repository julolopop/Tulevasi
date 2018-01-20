package com.example.julolopop.tulevasi.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Julolopop on 18/11/2017.
 */

public class Mesa implements Parcelable,Comparable<Mesa> {

    public static final String ID = "ID";

    private int Id;
    private int ID_Zona;
    private String nombre;

    public Mesa(int id, int ID_Zona, String nombre) {
        this.Id = id;
        this.ID_Zona = ID_Zona;
        this.nombre = nombre;
    }

    protected Mesa(Parcel in) {
        Id = in.readInt();
        ID_Zona = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<Mesa> CREATOR = new Creator<Mesa>() {
        @Override
        public Mesa createFromParcel(Parcel in) {
            return new Mesa(in);
        }

        @Override
        public Mesa[] newArray(int size) {
            return new Mesa[size];
        }
    };

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getID_Zona() {
        return ID_Zona;
    }

    public void setID_Zona(int ID_Zona) {
        this.ID_Zona = ID_Zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeInt(ID_Zona);
        dest.writeString(nombre);
    }

   @Override
    public int compareTo(@NonNull Mesa o) {
        return this.nombre.compareTo(o.nombre);
    }
}
