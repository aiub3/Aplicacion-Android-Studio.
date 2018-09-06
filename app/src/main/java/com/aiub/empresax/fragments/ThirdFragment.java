package com.aiub.empresax.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.aiub.empresax.R;
import com.aiub.empresax.activities.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    Button boton;
    EditText textNombre;
    EditText textEmail;
    EditText textMensaje;
    String nombre;
    String email;
    String mensaje;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        boton = (Button) view.findViewById(R.id.button);
        textNombre = (EditText) view.findViewById(R.id.editText);
        textEmail = (EditText) view.findViewById(R.id.editText2);
        textMensaje = (EditText) view.findViewById(R.id.editText4);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = textNombre.getText().toString();
                email = textEmail.getText().toString();
                mensaje = textMensaje.getText().toString();
                Toast.makeText(getActivity(),
                        "Se ha enviado este mensaje: " + mensaje + ", siendo los datos del autor: nombre: " + nombre + " y email: " + email
                        + " a nuestra bandeja de entrada, rescibirás una repsuesta lo antes posible.",
                        Toast.LENGTH_LONG).show();
            }
        });


        return view;

    }

}