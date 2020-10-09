package com.example.advanceproyect.ui.micuenta;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.advanceproyect.Actividad;
import com.example.advanceproyect.Usuario;
import com.example.advanceproyect.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MiCuentaViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<List<Actividad>> actividadesMutableLiveData;

    public MiCuentaViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<List<Actividad>> getActividadesMutableLiveData(){
        if(actividadesMutableLiveData == null){
            actividadesMutableLiveData = new MutableLiveData<>();
        }
        return actividadesMutableLiveData;
    }
    public void cargarDatos()
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<List<Actividad>>misact= ApiClient.getMyApiClient().MisActividades(claveToken);
        misact.enqueue(new Callback<List<Actividad>>() {
            @Override
            public void onResponse(Call<List<Actividad>> call, Response<List<Actividad>> response) {
                if(response.isSuccessful()){
                    List<Actividad>listaactividades=response.body();
                    actividadesMutableLiveData.postValue(listaactividades);
                }
            }

            @Override
            public void onFailure(Call<List<Actividad>> call, Throwable t) {
                Toast.makeText(context,"on failure mis actividades",Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
    }
}
