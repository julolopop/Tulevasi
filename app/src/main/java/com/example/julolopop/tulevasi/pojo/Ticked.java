package com.example.julolopop.tulevasi.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Julolopop on 18/11/2017.
 */

public class Ticked implements Parcelable {

    private int Id;
    private int ID_Mesa;
    private int ID_trabajador;
    private String fecha_Ini;
    private int estado;

    public static String PEDIDOS = "pedidos";
    private int ID_Productos;
    private int ID_Categoria;
    private int cantidad;
    private float precio;
    private float precioTotal;
    private String nombre;

    public void setId(int id) {
        Id = id;
    }

    public void setID_Mesa(int ID_Mesa) {
        this.ID_Mesa = ID_Mesa;
    }

    public void setID_trabajador(int ID_trabajador) {
        this.ID_trabajador = ID_trabajador;
    }

    public void setFecha_Ini(String fecha_Ini) {
        this.fecha_Ini = fecha_Ini;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setID_Productos(int ID_Productos) {
        this.ID_Productos = ID_Productos;
    }

    public void setID_Categoria(int ID_Categoria) {
        this.ID_Categoria = ID_Categoria;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setCantidadmasmas() {
        this.cantidad++;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ticked(int id, int ID_Productos, int ID_Categoria, int cantidad, float precio, float precioTotal, String nombre, int ID_Mesa, int ID_trabajador, String fecha_Ini, int estado) {
        Id = id;
        this.ID_Mesa = ID_Mesa;
        this.ID_trabajador = ID_trabajador;
        this.fecha_Ini = fecha_Ini;
        this.estado = estado;
        this.ID_Productos = ID_Productos;
        this.ID_Categoria = ID_Categoria;
        this.cantidad = cantidad;
        this.precio = precio;
        this.precioTotal = precioTotal;
        this.nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public int getID_Mesa() {
        return ID_Mesa;
    }

    public int getID_trabajador() {
        return ID_trabajador;
    }

    public String getFecha_Ini() {
        return fecha_Ini;
    }

    public int getEstado() {
        return estado;
    }

    public int getID_Productos() {
        return ID_Productos;
    }

    public int getID_Categoria() {
        return ID_Categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public String getNombre() {
        return nombre;
    }

    protected Ticked(Parcel in) {
        Id = in.readInt();
        ID_Mesa = in.readInt();
        ID_trabajador = in.readInt();
        fecha_Ini = in.readString();
        estado = in.readInt();
        ID_Productos = in.readInt();
        ID_Categoria = in.readInt();
        cantidad = in.readInt();
        precio = in.readFloat();
        precioTotal = in.readFloat();
        nombre = in.readString();
    }

    public static final Creator<Ticked> CREATOR = new Creator<Ticked>() {
        @Override
        public Ticked createFromParcel(Parcel in) {
            return new Ticked(in);
        }

        @Override
        public Ticked[] newArray(int size) {
            return new Ticked[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeInt(ID_Mesa);
        dest.writeInt(ID_trabajador);
        dest.writeString(fecha_Ini);
        dest.writeInt(estado);
        dest.writeInt(ID_Productos);
        dest.writeInt(ID_Categoria);
        dest.writeInt(cantidad);
        dest.writeFloat(precio);
        dest.writeFloat(precioTotal);
        dest.writeString(nombre);
    }
}
