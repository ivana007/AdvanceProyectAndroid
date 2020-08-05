package com.example.advanceproyect.ui.turnos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.advanceproyect.ActividadModelo;
import com.example.advanceproyect.Clase;
import com.example.advanceproyect.R;
import com.example.advanceproyect.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<ArrayList<Clase>> clases= ApiClient.getMyApiClient().misClases(claveToken);
        clases.enqueue(new Callback<ArrayList<Clase>>() {
            @Override
            public void onResponse(Call<ArrayList<Clase>> call, Response<ArrayList<Clase>> response) {
                if(response.isSuccessful()){
                    ArrayList<Clase> listadeClases=response.body();//cargo la lista que traje de base de datos
                    ActividadModelo modelo=null;// creo el modelo
                    ArrayList<ActividadModelo>misclases=new ArrayList<>();//creo la lista que le pasare al recycler
                    for(Clase c : listadeClases){
                        modelo.setActividadId(c.getClaseId());
                       modelo.setNombre(c.getNombre());
                       modelo.setCupo(c.getCupo());
                       if (c.getNombre().equals("Funcional")||c.getNombre().equals("Funcional B")){
                       modelo.setFotoActividad(R.drawable.fotofuncional);
                       }
                        if (c.getNombre().equals("Funcional+Indoor")||c.getNombre().equals("Funcional+Indoor B")){
                            modelo.setFotoActividad(R.drawable.funcionalindoor);
                        }
                        if (c.getNombre().equals("Indoor")||c.getNombre().equals("Indoor B")){
                            modelo.setFotoActividad(R.drawable.fotoindoor);
                        }
                        if (c.getNombre().equals("Musculacion")||c.getNombre().equals("Musculacion B")){
                            modelo.setFotoActividad(R.drawable.fotomusculacion);
                        }
                        misclases.add(modelo);
                    }
                       listaActividad.postValue(misclases);

                    }

            }

            @Override
            public void onFailure(Call<ArrayList<Clase>> call, Throwable t) {

            }
        });
       /* final ArrayList<ActividadModelo> listaClases= new ArrayList<>();
        ActividadModelo act1 =new ActividadModelo(R.drawable.fotofuncional,"Funcional",10);
        ActividadModelo act2 =new ActividadModelo(R.drawable.funcionalindoor,"Funcional+Indoor",8);
        ActividadModelo act3 =new ActividadModelo(R.drawable.fotoindoor,"Indoor",8);
        ActividadModelo act4 =new ActividadModelo(R.drawable.fotomusculacion,"Musculacion",10);
        listaClases.add(act1);
        listaClases.add(act2);
        listaClases.add(act3);
        listaClases.add(act4);
        listaActividad.setValue(listaClases);*/

    }

}
