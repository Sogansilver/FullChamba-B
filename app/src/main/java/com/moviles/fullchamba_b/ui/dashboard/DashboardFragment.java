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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.moviles.fullchamba_b.R;
import com.moviles.fullchamba_b.graphics.HrXTarea;
import com.moviles.fullchamba_b.graphics.HrsTrabajadsxPersonaFragment;
import com.moviles.fullchamba_b.graphics.TareasFinalizadas;

public class DashboardFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private DashboardViewModel dashboardViewModel;


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

            sp1= (Spinner)view.findViewById(R.id.spinner_dashboard);
            btnHrsPersona = (Button) view.findViewById(R.id.btn_hrsxpersona);
            btnHrsPersona.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment childFragment = new HrsTrabajadsxPersonaFragment();
                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_fragment_child, childFragment).commit();
                }
            });

        btnTareasFinalizadas = (Button) view.findViewById(R.id.btn_TareasFinalizadas);
        btnTareasFinalizadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment childFragment = new TareasFinalizadas();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_fragment_child, childFragment).commit();
            }
        });

        btnHrsxTarea = (Button) view.findViewById(R.id.btn_hrsxtarea);
        btnHrsxTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment childFragment1 = new HrXTarea();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_fragment_child, childFragment1).commit();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            if(btnHrsPersona.isPressed()){
                String cad=sp1.getSelectedItem().toString();
                String codc=cad.substring(0,5);
                //llenarNombre(codc);
            }



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}