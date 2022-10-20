package com.example.contactoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder> {

    ArrayList<Contactos> listadoDatos;

    public OnItemClickListener onItemClickListener;

    public AdaptadorPersonalizado(ArrayList<Contactos> listadoDatos) {
        this.listadoDatos = listadoDatos;
        this.onItemClickListener = null;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setListadoDatos(ArrayList<Contactos> listadoDatos) {
        this.listadoDatos = listadoDatos;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrecyclecontacto, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cargarDatos(listadoDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listadoDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, celular;
        ImageView ivPrincipal;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.it_nom1);
            celular = itemView.findViewById(R.id.it_celular);
            ivPrincipal = itemView.findViewById(R.id.img1);
        }

        public void cargarDatos(Contactos contacto) {
            nombre.setText(contacto.getNombre());
            celular.setText(contacto.getNcelular());
            //ivPrincipal.setImageResource();
            Picasso.get()
                    .load(contacto.getImgperfil())
                    .resize(300, 300)
                    .centerCrop()
                    .error(R.drawable.ic_launcher_background)
                    .into(ivPrincipal);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "> " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
                }
            });*/
            if(onItemClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(contacto, getAdapterPosition());

                        //Toast.makeText(itemView.getContext(), "Click ItemAAA"+ contacto.getNombre(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Contactos contacto, int posicion);
    }
}
