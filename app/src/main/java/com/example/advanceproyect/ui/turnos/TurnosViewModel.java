package com.example.advanceproyect.ui.turnos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.advanceproyect.ActividadModelo;
import com.example.advanceproyect.R;

import java.util.ArrayList;
import java.util.List;

public class TurnosViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<ArrayList<ActividadModelo>>listaActividad;

    public TurnosViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<ArrayList<ActividadModelo>>getListaActividad(){
        if(listaActividad==null){
            listaActividad=new MutableLiveData<>();
        }
        return listaActividad;
    }

    public void cargarDatos(){
        final ArrayList<ActividadModelo> listaClases= new ArrayList<>();
        ActividadModelo act1 =new ActividadModelo(R.drawable.fotofuncional,"Funcional",10);
        ActividadModelo act2 =new ActividadModelo(R.drawable.funcionalindoor,"Funcional+Indoor",8);
        ActividadModelo act3 =new ActividadModelo(R.drawable.fotoindoor,"Indoor",8);
        ActividadModelo act4 =new ActividadModelo(R.drawable.fotomusculacion,"Musculacion",10);
        listaClases.add(act1);
        listaClases.add(act2);
        listaClases.add(act3);
        listaClases.add(act4);
        listaActividad.setValue(listaClases);

    }

}