package com.example.contactoapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn_agrgar;
    private RecyclerView RvPrincipal;
    private ArrayList<Contactos> ListaContactos;
    private CustomAdapter adaptador;


    /*@Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.it_id:
                SharedPreferences sharedPreferences = getSharedPreferences("preferencias", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Logueado", false);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Basesdb miBaseDatos = Basesdb.obtenerInstacia(getApplicationContext());
        ContactosDAO contactosDAO = miBaseDatos.contactosDAO();

        Contactos carro1 = new Contactos("Kevisdfsdfn", "jznKxR", "3178508250", "111", "222");
        Contactos carro2 = new Contactos("Kev2", "jznKxR", "3178508250", "111", "222");
        contactosDAO.insertarElemento(carro1);
        contactosDAO.insertarElemento(carro2);


        ListaContactos = (ArrayList<Contactos>) contactosDAO.obtenertodo();

        adaptador = new CustomAdapter(ListaContactos);


        btn_agrgar = findViewById(R.id.button);



       /* adaptador = new AdaptadorPersonalizado(ListaContactos);


        adaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            // MÉTODO CLICK EN UN ITEM -> LLEVA A VER DETALLES Y ATRAPA EL IDENTIFICADOR PARA RELLENAR CON DATOS DE LA DB

            public void onItemClick(Contactos contacto, int posicion) {
                Intent intent = new Intent(MainActivity.this, Detalle.class);
                intent.putExtra("id", contacto.getIdentificador());
                startActivity(intent);
            }
        });*/

        RvPrincipal = findViewById(R.id.item_recycler1);
        RvPrincipal.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RvPrincipal.setAdapter(adaptador);


    }

    /*
    private void cargarDatosBasesDatos(){
        Basesdb miBaseDatos = Basesdb.obtenerInstacia(this);
        ContactosDAO contactosDAO = miBaseDatos.contactosDAO();

        ListaContactos = (ArrayList<Contactos>) contactosDAO.obtenertodo();
        if(ListaContactos.isEmpty()){
            creoPorDefecto();
        }
    }*/
    //CREAMOS UN ITEM POR DEFECTO PARA PROBAR LA FUNCIÓN DE LA BASE DE DATOS
    private void creoPorDefecto() {
        Basesdb miBaseDatos = Basesdb.obtenerInstacia(this);
        ContactosDAO contactosDAO = miBaseDatos.contactosDAO();

        Contactos carro1 = new Contactos("Kevin", "jznKxR", "3178508250", "111", "222");
        Contactos carro2 = new Contactos("Kev2", "jznKxR", "3178508250", "111", "222");
        contactosDAO.insertarElemento(carro1);
        contactosDAO.insertarElemento(carro2);
        ListaContactos = (ArrayList<Contactos>) contactosDAO.obtenertodo();

    }

    //ONCLICK QUE NOS DIRIGE A CREAR UN CONTACTO NUEVO
    public void onClickFormulario(View view) {
        Intent irformulario = new Intent(MainActivity.this, AgregarContacto.class);
        //startActivity(irformulario);
        irFFormulario.launch(irformulario);
    }

    ActivityResultLauncher<Intent> irFFormulario = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override

        //CONFIRMA QUE ATRAPA LOS DATOS
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                //Contactos contactoatrapada = (Contactos) result.getData().getSerializableExtra("datos_de_contacto");
                // ListaContactos.add(contactoatrapada);

                //adaptador.setListadoDatos(ListaContactos);


            }

        }
    });
}