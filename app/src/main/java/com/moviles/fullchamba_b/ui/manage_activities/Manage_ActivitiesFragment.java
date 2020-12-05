package com.moviles.fullchamba_b.ui.manage_activities;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.swipe.util.Attributes;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.moviles.fullchamba_b.R;
import com.moviles.fullchamba_b.adapter.ActividadListAdapter;
import com.moviles.fullchamba_b.model.Actividad;

import java.util.ArrayList;
import java.util.List;

public class Manage_ActivitiesFragment extends Fragment implements SearchView.OnQueryTextListener {

    private Manage_ActivitiesViewModel manageActivitiesViewModel;
    private List<Actividad> actividadlist;

    private FloatingActionButton fb_add;
    //private Animation open_fb,close_fb,from_bottom_anim,to_botton_anim;
    private ActividadListAdapter adapter;
    private SearchView vsearch;
    private boolean isOpen = false;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        manageActivitiesViewModel = ViewModelProviders.of(this).get(Manage_ActivitiesViewModel.class);

        View root = inflater.inflate(R.layout.fragment_manage_activities, container, false);

        manageActivitiesViewModel.getlistaActividad().observe(getViewLifecycleOwner(), new Observer<List<Actividad>>() {
            @Override
            public void onChanged(List<Actividad> actividads) {
                if (actividads!=null){
                    actividadlist = actividads;
                    adapter.setActivityList(actividads);


                }
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fb_add=view.findViewById(R.id.fb_AddInActivities);
        vsearch=view.findViewById(R.id.vsearch);





       // manageActivitiesViewModel.AddActividades(new Actividad("Tarea1","Yo","En proceso",1));


        actividadlist = new ArrayList<>();
        Actividad act2 = new Actividad("Tarea2","Tu","Finalizada",2);
        actividadlist.add(act2);
        Actividad act3 = new Actividad("Tarea3","El","En proceso",3);
        actividadlist.add(act3);
        Actividad act4 = new Actividad("Tarea4","Ella","Finalizada",4);
        actividadlist.add(act4);
        Actividad act5 = new Actividad("Tarea5","Ellos","En proceso",5);
        actividadlist.add(act5);
        Actividad act6 = new Actividad("Tarea6","Ellas","En proceso",2);
        actividadlist.add(act6);
        Actividad act7 = new Actividad("Tarea7","Nosotros","En proceso",1);
        actividadlist.add(act7);
        Actividad act8 = new Actividad("Tarea8","Nosotras","En proceso",2);
        actividadlist.add(act8);
        Actividad act9 = new Actividad("Tarea9","Ustedes","Finalizada",3);
        actividadlist.add(act9);
        Actividad act10 = new Actividad("Tarea10","Vosotros","En proceso",4);
        actividadlist.add(act10);
        //manageActivitiesViewModel.setListaActividad((MutableLiveData<List<Actividad>>) actividadlist);

        RecyclerView  recyclerView = view.findViewById(R.id.recycle_activities);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ActividadListAdapter(getContext(),actividadlist);
        ((ActividadListAdapter)adapter).setMode(Attributes.Mode.Single);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("RecyclerView", "onScrollStateChanged");
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        iniListenner();

        fb_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Agregar Actividad",Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_nav_manage_activities_to_agregarDialogActividades);
            }
        });



    }

    private void iniListenner(){
        vsearch.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }





}