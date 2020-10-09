package com.example.advanceproyect.ui.micuenta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.advanceproyect.Actividad;
import com.example.advanceproyect.R;
import com.example.advanceproyect.Suscripcion;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterMisSuscripciones extends RecyclerView.Adapter<RecyclerViewAdapterMisSuscripciones.ViewHolder> implements View.OnClickListener {
    private Context context;
    private List<Actividad> lista;
    private View.OnClickListener listener;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.misactividades,parent,false);//aca le digo que vista tiene que inflar en el recycler
        ViewHolder viewHolder=new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.act.setText(lista.get(position).getNombre());
        //holder.cantidadClases.setText(lista.get(position)); es otro servicio!!!
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView act;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            act=itemView.findViewById(R.id.tvActividad);


        }
    }
    public RecyclerViewAdapterMisSuscripciones(List<Actividad> lista, Context context) {
        this.lista = lista;
        this.context = context;

    }
}
