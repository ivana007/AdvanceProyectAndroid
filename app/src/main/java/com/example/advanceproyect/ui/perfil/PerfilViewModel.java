package com.example.advanceproyect.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.advanceproyect.Cliente;
import com.example.advanceproyect.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Cliente> clienteMutableLiveData;
    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<Cliente> getClienteMutableLivedata(){
        if(clienteMutableLiveData == null){
            clienteMutableLiveData = new MutableLiveData<>();
        }
        return clienteMutableLiveData;
    }

    public  void cargarDatos(){
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<Cliente> c= ApiClient.getMyApiClient().buscarCliente(claveToken);
        c.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if(response.isSuccessful()){
                    Cliente propietario1=response.body();
                    Toast.makeText(context,propietario1.getNombre()+"",Toast.LENGTH_LONG).show();
                    clienteMutableLiveData.postValue(propietario1);
                }else{
                    Toast.makeText(context,"estoy en el else",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Toast.makeText(context,"on failure",Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }


        });
    }
    public void actualizar(Cliente p){
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<Cliente>c= ApiClient.getMyApiClient().actualizar(claveToken,p);
        c.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context,"Datos Guardados",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Toast.makeText(context,"No Guardado",Toast.LENGTH_LONG).show();
            }
        });
    }
}
