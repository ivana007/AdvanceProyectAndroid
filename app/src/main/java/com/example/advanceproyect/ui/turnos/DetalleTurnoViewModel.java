package com.example.advanceproyect.ui.turnos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.advanceproyect.Horario;
import com.example.advanceproyect.HorarioAux;
import com.example.advanceproyect.R;
import com.example.advanceproyect.Dia;
import com.example.advanceproyect.Turno;


import com.example.advanceproyect.request.ApiClient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleTurnoViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<ArrayList<String>>listaDias,listaHoras;
    private MutableLiveData<String>spinnerDiaMutable;
    private MutableLiveData<String>fechaMutable;

    private MutableLiveData<Horario>horarioMutable;

    public DetalleTurnoViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<Horario>getHorarioMutable(){
        if(horarioMutable==null){
            horarioMutable=new MutableLiveData<>();
        }
        return horarioMutable;
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
    public LiveData<String>getFechaMutable(){
        if(fechaMutable==null){
            fechaMutable=new MutableLiveData<>();
        }
        return fechaMutable;
    }
    public void cambiarDiaSpinner(String dia){
        spinnerDiaMutable.setValue(dia);
    }


    public void cargarSpinner(String nombre){

        if(nombre.equals("Funcional")||nombre.equals("Funcional+Indoor")){
            ArrayList<String>listaD=new ArrayList<>();
            //ArrayList<String>semana=calculaSemana();
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
            if(dia.equals("Lunes")||dia.equals("Miercoles")||dia.equals("Viernes")){
                ArrayList<String>listaD=new ArrayList<>();
                String h2="09:00";
                String h5="17:00";
                listaD.add(h2);
                listaD.add(h5);
                listaHoras.setValue(listaD);
            }
            if(dia.equals("Martes")||dia.equals("Jueves")){
                ArrayList<String>listaD=new ArrayList<>();
                String h4="18:00";
                listaD.add(h4);
                listaHoras.setValue(listaD);
            }
        }
        if(nombre.equals("Indoor")){
            if(dia.equals("Martes")||dia.equals("Jueves")){
                ArrayList<String>listaD=new ArrayList<>();
                String h4="19:00";
                listaD.add(h4);
                listaHoras.setValue(listaD);
            }
        }
        if(nombre.equals("Musculacion")){
            if(dia.equals("Lunes")||dia.equals("Miercoles")||dia.equals("Viernes")){
                ArrayList<String>listaD=new ArrayList<>();
                String h5="16:00";
                listaD.add(h5);
                listaHoras.setValue(listaD);
            }
        }
    }
    public void cargarFechaSeleccionada(String diaSeleccionado){
        Calendar c = new GregorianCalendar();
        int dia = c.get(Calendar.DATE);

        String diasemana= Integer.toString(c.get(Calendar.DAY_OF_WEEK));//me devuelve el dia de la semana que corresponde a la fecha actual
        if(diasemana.equals("7")){
            if(diaSeleccionado.equals("Lunes")){
                dia=c.get(Calendar.DATE)+2;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Martes")){
                dia=c.get(Calendar.DATE)+3;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Miercoles")){
                dia=c.get(Calendar.DATE)+4;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Jueves")){
                dia=c.get(Calendar.DATE)+5;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Viernes")){
                dia=c.get(Calendar.DATE)+6;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
        }//sabado
        if(diasemana.equals("1")){
            if(diaSeleccionado.equals("Lunes")){
                dia=c.get(Calendar.DATE)+1;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Martes")){
                dia=c.get(Calendar.DATE)+2;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Miercoles")){
                dia=c.get(Calendar.DATE)+3;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Jueves")){
                dia=c.get(Calendar.DATE)+4;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Viernes")){
                dia=c.get(Calendar.DATE)+5;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
        }//domingo
        if(diasemana.equals("2")){
            if(diaSeleccionado.equals("Lunes")){
                dia=c.get(Calendar.DATE);
               String mes = Integer.toString(c.get(Calendar.MONTH)+1);
               String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Martes")){
                dia=c.get(Calendar.DATE)+1;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Miercoles")){
                dia=c.get(Calendar.DATE)+2;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Jueves")){
                dia=c.get(Calendar.DATE)+3;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Viernes")){
                dia=c.get(Calendar.DATE)+4;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
        }//lunes
        if(diasemana.equals("3")){
            if(diaSeleccionado.equals("Lunes")){
                //dia=c.get(Calendar.DATE)-1;
                fechaMutable.setValue("LOS TURNOS SE ACTUALIZAN FINALIZADA LA SEMANA");
            }
            if(diaSeleccionado.equals("Martes")){
                dia=c.get(Calendar.DATE);
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Miercoles")){
                dia=c.get(Calendar.DATE)+1;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Jueves")){
                dia=c.get(Calendar.DATE)+2;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Viernes")){
                dia=c.get(Calendar.DATE)+3;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
        }//martes
        if(diasemana.equals("4")){
            if(diaSeleccionado.equals("Lunes")){
                //dia=c.get(Calendar.DATE)-1;
                fechaMutable.setValue("No hay turnos");
            }
            if(diaSeleccionado.equals("Martes")){
                fechaMutable.setValue("No hay turnos");
            }
            if(diaSeleccionado.equals("Miercoles")){
                dia=c.get(Calendar.DATE);
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Jueves")){
                dia=c.get(Calendar.DATE)+1;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Viernes")){
                dia=c.get(Calendar.DATE)+2;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
        }//miercoles
        if(diasemana.equals("5")){
            if(diaSeleccionado.equals("Lunes")){
                //dia=c.get(Calendar.DATE)-1;
                fechaMutable.setValue("No hay turnos");
            }
            if(diaSeleccionado.equals("Martes")){
                fechaMutable.setValue("No hay turnos");
            }
            if(diaSeleccionado.equals("Miercoles")){
                fechaMutable.setValue("No hay turnos");
            }
            if(diaSeleccionado.equals("Jueves")){
                dia=c.get(Calendar.DATE);
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
            if(diaSeleccionado.equals("Viernes")){
                dia=c.get(Calendar.DATE)+1;
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
        }//jueves
        if(diasemana.equals("6")){
            if(diaSeleccionado.equals("Lunes")){
                //dia=c.get(Calendar.DATE)-1;
                fechaMutable.setValue("No hay turnos");
            }
            if(diaSeleccionado.equals("Martes")){
                fechaMutable.setValue("No hay turnos");
            }
            if(diaSeleccionado.equals("Miercoles")){
                fechaMutable.setValue("No hay turnos");
            }
            if(diaSeleccionado.equals("Jueves")){
                fechaMutable.setValue("No hay turnos");
            }
            if(diaSeleccionado.equals("Viernes")){
                dia=c.get(Calendar.DATE);
                String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String fecha=Integer.toString(dia)+"/"+mes+"/"+annio;
                fechaMutable.setValue(fecha);
            }
        }//viernes
    }
    public void armarHorario(final HorarioAux horarioAux){
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        //buscar id horario
        Call<Horario> horarioCall= ApiClient.getMyApiClient().BuscarHorario(claveToken,horarioAux);
        horarioCall.enqueue(new Callback<Horario>() {
            @Override
            public void onResponse(Call<Horario> call, Response<Horario> response) {
                if (response.isSuccessful())
                {
                    Horario horarioEncontrado=response.body();
                    horarioMutable.setValue(horarioEncontrado);
                }
            }

            @Override
            public void onFailure(Call<Horario> call, Throwable t) {

            }
        });

    }
    public void sacarTurno(int id)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        //crear el turno
        Call<Turno> turnoCall= ApiClient.getMyApiClient().CrearTurno(claveToken,id);
    }
}
