package com.example.sqlitefoto;

import android.graphics.Bitmap;

public class Fotografia {
    Bitmap imagen;
    String nombre, descripcion;


    public Fotografia(Bitmap imagen, String nombre, String descripcion)
    {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    public Fotografia(Bitmap imagen,String descripcion ) {
    }

    public Bitmap getImagen()
    {
        return imagen;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public String getNombre()
    {
        return nombre;
    }

}