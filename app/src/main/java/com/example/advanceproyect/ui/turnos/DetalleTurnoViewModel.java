package com.example.advanceproyect.ui.turnos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.advanceproyect.R;
import com.example.advanceproyect.Dia;

import java.util.ArrayList;

public class DetalleTurnoViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<ArrayList<String>>listaDias,listaHoras;
    private MutableLiveData<String>spinnerDiaMutable;

    public DetalleTurnoViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<ArrayList<String>>getListaDias(){
        if(listaDias==null){
            listaDias=new MutableLiveData<>();
        }
        return listaDias;
    }

    public LiveData<ArrayList<String>>getListaHoras(){
        if(listaHoras==null){
            listaHoras=new MutableLiveData<>();
        }
        return listaHoras;
    }
    public LiveData<String>getSpinnerDiaMutable(){
        if(spinnerDiaMutable==null){
            spinnerDiaMutable=new MutableLiveData<>();
        }
        return spinnerDiaMutable;
    }
    public void cambiarDiaSpinner(String dia){
        spinnerDiaMutable.setValue(dia);
    }
    public void cargarSpinner(String nombre){
        if(nombre.equals("Funcional")||nombre.equals("Funcional+Indoor")){
            ArrayList<String>listaD=new ArrayList<>();
            String dia1="Lunes";
            String dia2="Martes";
            String dia3="Miercoles";
            String dia4="Jueves";
            String dia5="Viernes";
            listaD.add(dia1);
            listaD.add(dia2);
            listaD.add(dia3);
            listaD.add(dia4);
            listaD.add(dia5);
            listaDias.setValue(listaD);
        }
        if(nombre.equals("Indoor")){
            ArrayList<String>listaD=new ArrayList<>();
            String dia2="Martes";
            String dia4="Jueves";
            listaD.add(dia2);
            listaD.add(dia4);
            listaDias.setValue(listaD);
        }
        if(nombre.equals("Musculacion")||nombre.equals("Funcional Intenso")){
            ArrayList<String>listaD=new ArrayList<>();
            String dia1="Lunes";
            String dia3="Miercoles";
            String dia5="Viernes";
            listaD.add(dia1);
            listaD.add(dia3);
            listaD.add(dia5);
            listaDias.setValue(listaD);
        }
    }
    public void cargarSpinnerHoras(String nombre,String dia){
        if(nombre.equals("Funcional")){
            if(dia.equals("Lunes")||dia.equals("Miercoles")||dia.equals("Viernes")){
                ArrayList<String>listaD=new ArrayList<>();
                String h1="08:00";
                String h2="09:00";
                String h3="10:00";
                String h4="15:00";
                String h5="18:00";
                String h6="20:00";
                String h7="21:00";
                listaD.add(h1);
                listaD.add(h2);
                listaD.add(h3);
                listaD.add(h4);
                listaD.add(h5);
                listaD.add(h6);
                listaD.add(h7);
                listaHoras.setValue(listaD);
            }
            if(dia.equals("Martes")||dia.equals("Jueves")){
                ArrayList<String>listaD=new ArrayList<>();

                String h4="15:00";
                String h5="17:00";
                String h6="20:00";
                listaD.add(h4);
                listaD.add(h5);
                listaD.add(h6);
                listaHoras.setValue(listaD);
            }
        }
        if (nombre.equals("Funcional+Indoor")){


        }
        if(nombre.equals("Indoor")){
            ArrayList<String>listaD=new ArrayList<>();
            String dia2="Martes";
            String dia4="Jueves";
            listaD.add(dia2);
            listaD.add(dia4);
            listaDias.setValue(listaD);
        }
        if(nombre.equals("Musculacion")||nombre.equals("Funcional Intenso")){
            ArrayList<String>listaD=new ArrayList<>();
            String dia1="Lunes";
            String dia3="Miercoles";
            String dia5="Viernes";
            listaD.add(dia1);
            listaD.add(dia3);
            listaD.add(dia5);
            listaDias.setValue(listaD);
        }
    }
}
