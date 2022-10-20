package com.example.contactoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Contactos> listaDatos;

    public CustomAdapter(ArrayList<Contactos> listaDatos) {
        this.listaDatos = listaDatos;
    }

    public ArrayList<Contactos> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(ArrayList<Contactos> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrecyclecontacto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cargaDatos(listaDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.it_nom1);
        }

        public void cargaDatos(Contactos contactos) {
            nombre.setText(contactos.getNombre());
        }
    }
}
