package com.example.advanceproyect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.advanceproyect.ui.turnos.DetalleTurnoViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetalleTurnoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleTurnoFragment extends Fragment {
    private TextView tvDia,tvhora,tvnombreClase;
    private Spinner spDia,spHora;
    private Button btGuardar;
    private DetalleTurnoViewModel vm;
    private String diaSpinner,nbre;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetalleTurnoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleTurnoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleTurnoFragment newInstance(String param1, String param2) {
        DetalleTurnoFragment fragment = new DetalleTurnoFragment();
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
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetalleTurnoViewModel.class);
        vm.getListaDias().observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> dias) {
                ArrayAdapter<String>adapterDia=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,dias);
                spDia.setAdapter(adapterDia);
                //diaSpinner=spDia.getSelectedItem().toString();
               // vm.cambiarDiaSpinner(diaSpinner);
                //vm.cargarSpinnerHoras(nbre,diaSpinner);

            }
        });
        vm.getListaHoras().observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                ArrayAdapter<String>adapterDia=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,strings);
                spHora.setAdapter(adapterDia);
            }
        });
        vm.getSpinnerDiaMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                vm.cargarSpinnerHoras(nbre,s);
                tvDia.setText(s);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_detalle_turno, container, false);
        tvDia=view.findViewById(R.id.tvDiaSeleccionado);
        tvhora=view.findViewById(R.id.tvHoraSeleccionada);
        tvnombreClase=view.findViewById(R.id.tvNombreClaseDetalle);
        spDia=view.findViewById(R.id.spinnerDia);
        spHora=view.findViewById(R.id.spinnerHora);
        btGuardar=view.findViewById(R.id.btAceptar);
        tvnombreClase.setText(getArguments().getString("nombreClase").toString());
        nbre=getArguments().getString("nombreClase");
        vm.cargarSpinner(nbre);
        spDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                diaSpinner=parent.getItemAtPosition(position).toString();
                vm.cambiarDiaSpinner(diaSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spHora.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvhora.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
}
