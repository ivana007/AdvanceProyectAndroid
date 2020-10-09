package com.example.advanceproyect.ui.micuenta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.advanceproyect.Actividad;
import com.example.advanceproyect.R;
import com.example.advanceproyect.ui.turnos.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MiCuentaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiCuentaFragment extends Fragment {
    private TextView tvActividad,tvSaldoClases;
   private MiCuentaViewModel vm;
    private  RecyclerViewAdapterMisSuscripciones rv;
    private RecyclerView recyclerView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MiCuentaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MiCuentaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MiCuentaFragment newInstance(String param1, String param2) {
        MiCuentaFragment fragment = new MiCuentaFragment();
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
        View view= inflater.inflate(R.layout.fragment_mi_cuenta, container, false);
        recyclerView=view.findViewById(R.id.recyclerActividades);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(MiCuentaViewModel.class);
        vm.getActividadesMutableLiveData().observe(this, new Observer<List<Actividad>>() {
            @Override
            public void onChanged(List<Actividad> actividads) {
                rv=new RecyclerViewAdapterMisSuscripciones(actividads,getContext());
                recyclerView.setAdapter(rv);
            }
        });
        vm.cargarDatos();
        return view;
    }
}
