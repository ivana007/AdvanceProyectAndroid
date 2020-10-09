package com.example.advanceproyect.ui.turnos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.advanceproyect.Actividad;
import com.example.advanceproyect.ActividadModelo;

import com.example.advanceproyect.R;
import com.example.advanceproyect.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TurnosViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<List<Actividad>>listaActividad;

    public TurnosViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<List<Actividad>>getListaActividad(){
        if(listaActividad==null){
            listaActividad=new MutableLiveData<>();
        }
        return listaActividad;
    }

    public void cargarDatos(){
       SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<List<Actividad>> actividad= ApiClient.getMyApiClient().MisActividades(claveToken);
        actividad.enqueue(new Callback<List<Actividad>>() {

            @Override
            public void onResponse(Call<List<Actividad>> call, Response<List<Actividad>> response) {
                if(response.isSuccessful()){
                    List<Actividad> listadeClases=response.body();//cargo la lista que traje de base de datos
                    listaActividad.postValue(listadeClases);
                    }
            }
            @Override
            public void onFailure(Call<List<Actividad>> call, Throwable t) {

            }
        });
        /*final ArrayList<ActividadModelo> listaClases= new ArrayList<>();
        ActividadModelo act1 =new ActividadModelo(1,R.drawable.fotofuncional,"Funcional",10);
        ActividadModelo act2 =new ActividadModelo(2,R.drawable.funcionalindoor,"Funcional+Indoor",8);
        ActividadModelo act3 =new ActividadModelo(3,R.drawable.fotoindoor,"Indoor",8);
        ActividadModelo act4 =new ActividadModelo(4,R.drawable.fotomusculacion,"Musculacion",10);
        listaClases.add(act1);
        listaClases.add(act2);
        listaClases.add(act3);
        listaClases.add(act4);
        listaActividad.setValue(listaClases);*/

    }

}
