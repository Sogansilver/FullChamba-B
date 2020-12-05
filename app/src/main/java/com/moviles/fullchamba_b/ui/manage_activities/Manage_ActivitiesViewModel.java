package com.moviles.fullchamba_b.ui.manage_activities;

import com.moviles.fullchamba_b.model.Actividad;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Manage_ActivitiesViewModel extends ViewModel {

    private MutableLiveData<List<Actividad>> listaActividad;
    private List<Actividad> lactividad;

    public  LiveData<List<Actividad>> getlistaActividad(){
        if (listaActividad==null){
            listaActividad = new MutableLiveData<List<Actividad>>();
            lactividad = new ArrayList<>();
        }
        return listaActividad;
    }

    public void AddActividades(Actividad actividad){
        lactividad.add(actividad);
        listaActividad.setValue(lactividad);
    }

    public MutableLiveData<List<Actividad>> getListaActividad() {
        return listaActividad;
    }

    public void setListaActividad(MutableLiveData<List<Actividad>> listaActividad) {
        this.listaActividad = listaActividad;
    }
}
