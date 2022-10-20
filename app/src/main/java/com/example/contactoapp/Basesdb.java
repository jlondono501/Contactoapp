package com.example.contactoapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contactos.class},version = 1)
public abstract class Basesdb extends RoomDatabase {

    public  abstract ContactosDAO contactosDAO();

    private static Basesdb instancia = null;


    //SE CREA LA CLASE ABSTRACTA QUE INICIALIZA LA BASE DE DATOS Y EL ROOM
    public static Basesdb obtenerInstacia(Context micontexto){
        if(instancia==null){
            instancia = Room.databaseBuilder(micontexto,Basesdb.class,"carrosrecycle.db").allowMainThreadQueries().build();
        }

        return instancia;
    }


}
