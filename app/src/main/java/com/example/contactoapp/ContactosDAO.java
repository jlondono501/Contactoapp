package com.example.contactoapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

//import com.example.contactoapp.Contactos;

import java.util.List;


//CREAMOS EL DAO CON LOS RESPECTIVOS MÉTODOS PARA LAS FUNCIONES DE LA DB

@Dao
public interface ContactosDAO {

    @Query("select * from contactos")
    List<Contactos> obtenertodo();

    @Insert
    void insertarElemento(Contactos miniCarro);

    @Update
    void editar(Contactos miniCarro);

    @Delete
    void eliminar(Contactos miniCarro);

    @Query("select * from contactos where identificador=:parametro")
    Contactos obtenerPorIdentificador(int parametro);
}
