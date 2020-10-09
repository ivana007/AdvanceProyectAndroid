package com.example.advanceproyect.ui.turnos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.advanceproyect.Actividad;
import com.example.advanceproyect.ActividadModelo;

import com.example.advanceproyect.Hora;
import com.example.advanceproyect.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TurnosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TurnosFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private TurnosViewModel vm;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TurnosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TurnosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TurnosFragment newInstance(String param1, String param2) {
        TurnosFragment fragment = new TurnosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_turnos, container, false);
        recyclerView=view.findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//damos forma a la lista
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(TurnosViewModel.class);
        vm.getListaActividad().observe(this, new Observer<List<Actividad>>() {
            @Override
            public void onChanged(final List<Actividad> actividad) {
                RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(actividad,getContext());
                recyclerViewAdapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Actividad actividad1=actividad.get(recyclerView.getChildAdapterPosition(v));
                        Bundle bundle=new Bundle();
                        bundle.putString("nombreClase",actividad1.getNombre());
                        bundle.putInt("actividadId",actividad1.getActividadId());
                        Navigation.findNavController(v).navigate(R.id.detalleTurnoFragment,bundle);
                    }
                });
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        //ArrayAdapter<Clase>adapter=new ArrayAdapter<Clase>(getContext(),R.layout.item,listaClases);
        vm.cargarDatos();

        return view;
    }

}
