package com.example.sqlitefoto;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlitefoto.transacciones.Transacciones;

import java.util.ArrayList;

public class listaImagenes extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imagenes);

        ListView simpleGridView = (ListView) findViewById(R.id.listView);

        com.example.sqlitefoto.SQLiteConexion help = new com.example.sqlitefoto.SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        ArrayList<com.example.sqlitefoto.Fotografia> listaImagenes = new ArrayList<>();
        Cursor c= help.getAll();
        int i=0;
        if(c.getCount()>0)
        {
            c.moveToFirst();
            while(c.isAfterLast()==false)
            {

                byte[] bytes=c.getBlob(c.getColumnIndex(Transacciones.blobImagen));
                String descripcion=c.getString(c.getColumnIndex(Transacciones.descripcion));
                String nombre=c.getString(c.getColumnIndex(Transacciones.nombre));

                com.example.sqlitefoto.Fotografia fotografia = new com.example.sqlitefoto.Fotografia(BitmapFactory.decodeByteArray(bytes, 0, bytes.length), nombre, descripcion);
                listaImagenes.add(fotografia);
                c.moveToNext();
                i++;
            }

            com.example.sqlitefoto.Adaptador myAdapter=new com.example.sqlitefoto.Adaptador(this,R.layout.grid_view_items,listaImagenes);
            simpleGridView.setAdapter(myAdapter);
        }
    }
}