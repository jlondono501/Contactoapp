package com.example.contactoapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;



//  SE CREA LA ENTIDAD DE LA BASE DE DATOS CON SUS RESPECTIVOS ATRIBUTOS


@Entity(tableName = "contactos")
public class Contactos implements Serializable {


    //SE INSTANCIAN ATRIBUTOS
    @PrimaryKey(autoGenerate = true)
    private int identificador;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "apellido")
    private String apellido;

    @ColumnInfo(name = "ncelular")
    private String ncelular;

    @ColumnInfo(name = "ocupacion")
    private String ocupacion;

    @ColumnInfo(name = "imgperfil")
    private String imgperfil;
// CONSTRUCTOR
    Contactos(String nombre, String apellido, String ncelular, String ocupacion, String imgperfil) {
        this.identificador = 0;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ncelular = ncelular;
        this.ocupacion = ocupacion;
        this.imgperfil = imgperfil;
    }

    // GETTERS AND SETTERS

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNcelular() {
        return ncelular;
    }

    public void setNcelular(String ncelular) {
        this.ncelular = ncelular;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getImgperfil() {
        return imgperfil;
    }

    public void setImgperfil(String imgperfil) {
        this.imgperfil = imgperfil;
    }
}
