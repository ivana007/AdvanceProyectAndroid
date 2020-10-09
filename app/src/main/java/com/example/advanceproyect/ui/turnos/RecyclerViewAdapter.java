package com.example.advanceproyect.ui.turnos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.advanceproyect.Actividad;
import com.example.advanceproyect.ActividadModelo;

import com.example.advanceproyect.Hora;
import com.example.advanceproyect.MainActivity;
import com.example.advanceproyect.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener{
    private Context context;
    private View.OnClickListener listener;
    private List<Actividad> lista;
    private static final String PATH="http://192.168.101.233:45455";
    //private ArrayList<Hora>listaHoras;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item2,parent,false);//aca le digo que vista tiene que inflar en el recycler
        ViewHolder viewHolder=new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(lista.get(position).getNombre());
        //holder.foto.setImageResource(lista.get(position).getImagen());
        Glide.with(context)
                .load(PATH +  lista.get(position).getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.foto);
        holder.cupo.setText(lista.get(position).getCupo()+"");
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre,cupo,disponibilidad;
        private ImageView foto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.tvNombreClase);
            foto=(ImageView) itemView.findViewById(R.id.imagenCard);
           cupo=(TextView)itemView.findViewById(R.id.tvCupoClase);
            disponibilidad=(TextView)itemView.findViewById(R.id.tvDisponibilidad);
        }
    }


    public RecyclerViewAdapter(List<Actividad> lista, Context context) {
        this.lista = lista;
        this.context = context;

    }
}
