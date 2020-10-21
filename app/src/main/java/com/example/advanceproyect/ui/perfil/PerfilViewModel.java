package com.example.advanceproyect.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;



import com.example.advanceproyect.request.ApiClient;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class PerfilViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Usuario> clienteMutableLiveData;
    private MutableLiveData<Bitmap>foto;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<Usuario> getClienteMutableLivedata(){
        if(clienteMutableLiveData == null){
            clienteMutableLiveData = new MutableLiveData<>();
        }
        return clienteMutableLiveData;
    }

    public  void cargarDatos(){
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<Usuario> c= ApiClient.getMyApiClient().buscarCliente(claveToken);
        c.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Usuario propietario1=response.body();
                    Toast.makeText(context,propietario1.getNombre()+"",Toast.LENGTH_LONG).show();
                    clienteMutableLiveData.postValue(propietario1);
                }else{
                    Toast.makeText(context,"estoy en el else",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(context,"on failure",Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }


        });
    }
    public void actualizar(Usuario p){
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<Usuario>c= ApiClient.getMyApiClient().actualizar(claveToken,p);
        c.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context,"Datos Guardados",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(context,"No Guardado",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void cargarFoto(int requestCode, int resultCode, Intent data)
    {
        if(resultCode==RESULT_OK){
            Uri imagenUri=data.getData();
            InputStream imageStream=null;
            try{
                imageStream=context.getContentResolver().openInputStream(imagenUri);

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            final Bitmap selectedImage= BitmapFactory.decodeStream(imageStream);
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            selectedImage.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
            foto.postValue(selectedImage);
        }
    }
}
