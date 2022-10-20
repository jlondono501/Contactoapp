package com.example.contactoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgregarContacto extends AppCompatActivity {
    EditText etNombre , etApellido , etUrlPortada,etCelular,etOcupacion;
    Button btGuardada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        referenciarElementos();
    }
    private  void referenciarElementos(){
        etNombre= findViewById(R.id.fn_nom);
        etApellido= findViewById(R.id.fn_apell);
        etCelular=findViewById(R.id.fn_cel);
        etOcupacion=findViewById(R.id.fn_ocup);
        //etUrlPortada= findViewById(R.id.urlf);
        btGuardada= findViewById(R.id.fm_btguar);


    }
    public  void clickguardar(View view){
        String nombre=etNombre.getText().toString();
        String desc=etApellido.getText().toString();
        String num=etCelular.getText().toString();
        String ocup=etOcupacion.getText().toString();
        //String uurl=etUrlPortada.getText().toString();
        if("".equals(nombre)){
            etNombre.setError(getString(R.string.errorvalidacion));
            return;
        }

        if("".equals(desc)){
            etApellido.setError(getString(R.string.errorvalidacion));
            return;
        }

       /* if("".equals(uurl)){
            etUrlPortada.setError(getString(R.string.errorvalidacion));
            return;
        }*/

        Contactos contacto = new Contactos( nombre, desc, num,ocup, "");

        Intent datos = new Intent();
        //datos.putExtra("datos_de_contacto",contacto);
        setResult(RESULT_OK,datos);

        Basesdb miBaseDatos = Basesdb.obtenerInstacia(AgregarContacto.this);
        ContactosDAO contactosDAO = miBaseDatos.contactosDAO();
        contactosDAO.insertarElemento(contacto);
        //Intent regresar = new Intent(FormularioActivity.this, MainActivity.class);
        //startActivity(regresar);

        finish();
    }

}