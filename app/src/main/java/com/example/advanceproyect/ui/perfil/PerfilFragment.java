package com.example.advanceproyect.ui.perfil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.advanceproyect.Cliente;
import com.example.advanceproyect.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {
private EditText nombre,apellido,dni,telefono,email;
private Button editarperfil;
private Cliente clienteGuardar=null;
private PerfilViewModel vm;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);
        vm.getClienteMutableLivedata().observe(this, new Observer<Cliente>() {
            @Override
            public void onChanged(Cliente cliente) {

            }
        });
        View view= inflater.inflate(R.layout.fragment_perfil, container, false);
        nombre=view.findViewById(R.id.etNombrePerfil);
        apellido=view.findViewById(R.id.etApellidoPerfil);
        dni=view.findViewById(R.id.etDniPerfil);
        telefono=view.findViewById(R.id.etTelefonoPerfil);
        email=view.findViewById(R.id.etEmailPerfil);
        editarperfil=view.findViewById(R.id.btEditarPerfil);
        editarperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setEnabled(true);
                apellido.setEnabled(true);
                dni.setEnabled(true);
                telefono.setEnabled(true);
                email.setEnabled(true);
                editarperfil.setText("Guardar");
                editarperfil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(getContext()).setTitle("").setMessage("Desea guardar los datos?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                aceptar();

                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //fijarDatos(null);
                            }
                        }).show();
                        Navigation.findNavController(v).navigate(R.id.nav_home);
                    }
                });
            }
        });
        vm.cargarDatos();
        return view;
    }
    public void aceptar(){

        clienteGuardar.setDni(dni.getText().toString());
        clienteGuardar.setApellido(apellido.getText().toString());
        clienteGuardar.setNombre(nombre.getText().toString());
        clienteGuardar.setTelefono(telefono.getText().toString());
        clienteGuardar.setMail(email.getText().toString());
        //propietarioGuardar.setPassword(pass.getText().toString());
        vm.actualizar(clienteGuardar);
    }

}
