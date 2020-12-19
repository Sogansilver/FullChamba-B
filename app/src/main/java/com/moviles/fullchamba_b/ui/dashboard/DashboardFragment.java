package com.moviles.fullchamba_b.ui.dashboard;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.moviles.fullchamba_b.R;
import com.moviles.fullchamba_b.graphics.HrXTarea;
import com.moviles.fullchamba_b.graphics.HrsTrabajadsxPersonaFragment;
import com.moviles.fullchamba_b.graphics.TareasFinalizadas;

public class DashboardFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private DashboardViewModel dashboardViewModel;
//    private String val1 = "Pablo";
//    private String val2 = "Juan";
//    private String val3 = "Martin";
    private int pass = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    Spinner sp1;
    Button btnHrsPersona,btnTareasFinalizadas, btnHrsxTarea;
        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            btnHrsPersona = (Button) view.findViewById(R.id.btn_hrsxpersona);
            btnHrsPersona.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(getContext(),R.array.combo_usuarios, android.R.layout.simple_spinner_item);
                    sp1.setAdapter(spinAdapter);

                    pass = 1;
                }
            });

        btnTareasFinalizadas = (Button) view.findViewById(R.id.btn_TareasFinalizadas);
        btnTareasFinalizadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(getContext(),R.array.combo_usuarios, android.R.layout.simple_spinner_item);
                sp1.setAdapter(spinAdapter);

                pass = 2;
            }
        });

        btnHrsxTarea = (Button) view.findViewById(R.id.btn_hrsxtarea);
        btnHrsxTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(getContext(),R.array.combo_usuarios, android.R.layout.simple_spinner_item);
                sp1.setAdapter(spinAdapter);

                pass = 3;
            }
        });


            sp1= (Spinner)view.findViewById(R.id.spinner_dashboard);

            /*ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(getContext(),R.array.combo_usuarios, android.R.layout.simple_spinner_item);
            sp1.setAdapter(spinAdapter);
            spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/
            sp1.setOnItemSelectedListener(this);


        }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(adapterView.getContext(),"El item es: "+adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
        String val = adapterView.getItemAtPosition(i).toString();
        switch (pass){
            case 1:{

                Fragment childFragment = new HrsTrabajadsxPersonaFragment();
                Bundle arguments = new Bundle();
                arguments.putString( "val" , val);
                childFragment.setArguments(arguments);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_fragment_child, childFragment).commit();

            }
            case 2:{
                Fragment childFragment1 = new TareasFinalizadas();
                Bundle arguments1 = new Bundle();
                arguments1.putString( "val" , val);
                childFragment1.setArguments(arguments1);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_fragment_child, childFragment1).commit();


            }
            case 3:{
                Fragment childFragment2 = new HrXTarea();
                Bundle arguments2 = new Bundle();
                arguments2.putString( "val" , val);
                childFragment2.setArguments(arguments2);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_fragment_child, childFragment2).commit();


            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}