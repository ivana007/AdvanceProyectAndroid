package com.example.advanceproyect.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.advanceproyect.Actividad;
import com.example.advanceproyect.Noticia;
import com.example.advanceproyect.R;
import com.example.advanceproyect.ui.micuenta.RecyclerViewAdapterMisSuscripciones;

import java.util.List;

public class RecyclerViewAdapterHome extends RecyclerView.Adapter<RecyclerViewAdapterHome.ViewHolder> {
    private Context context;
    private List<Noticia> lista;

    @NonNull
    @Override
    public RecyclerViewAdapterHome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemhome,parent,false);//aca le digo que vista tiene que inflar en el recycler
        RecyclerViewAdapterHome.ViewHolder viewHolder=new RecyclerViewAdapterHome.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterHome.ViewHolder holder, int position) {
        holder.texto.setText(lista.get(position).getTextoNoticia());
        //foto
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView texto;
        //private ImageView foto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            texto =itemView.findViewById(R.id.tvTextoHome);
           //foto=itemView.findViewById(R.id.ivImagenHome);


        }
    }
    public RecyclerViewAdapterHome(List<Noticia> lista, Context context) {
        this.lista = lista;
        this.context = context;

    }
}
