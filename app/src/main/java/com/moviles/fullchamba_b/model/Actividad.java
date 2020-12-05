package com.moviles.fullchamba_b.model;

import android.app.Activity;

import java.io.Serializable;
import java.util.Date;

public class Actividad implements Serializable {
    private String nomacti;
    private String responsableacti;
    private int prioriacti;
    private Date fechaacti;
    private int horaacti;
    private String estadoacti;

    public Actividad(String nomacti, String responsableacti, int prioriacti, Date fechaacti, int horaacti, String estadoacti) {
        this.nomacti = nomacti;
        this.responsableacti = responsableacti;
        this.prioriacti = prioriacti;
        this.fechaacti = fechaacti;
        this.horaacti = horaacti;
        this.estadoacti = estadoacti;
    }

    public Actividad(){
    }



    public Actividad(String nomacti, String responsableacti, String estadoacti, int prioriacti) {
        this.nomacti = nomacti;
        this.responsableacti = responsableacti;
        this.estadoacti = estadoacti;
        this.prioriacti = prioriacti;
    }


    public String getNomacti() {
        return nomacti;
    }

    public void setNomacti(String nomacti) {
        this.nomacti = nomacti;
    }

    public String getResponsableacti() {
        return responsableacti;
    }

    public void setResponsableacti(String responsableacti) {
        this.responsableacti = responsableacti;
    }

    public int getPrioriacti() {
        return prioriacti;
    }

    public void setPrioriacti(int prioriacti) {
        this.prioriacti = prioriacti;
    }

    public Date getFechaacti() {
        return fechaacti;
    }

    public void setFechaacti(Date fechaacti) {
        this.fechaacti = fechaacti;
    }

    public int getHoraacti() {
        return horaacti;
    }

    public void setHoraacti(int horaacti) {
        this.horaacti = horaacti;
    }

    public String getEstadoacti() {
        return estadoacti;
    }

    public void setEstadoacti(String estadoacti) {
        this.estadoacti = estadoacti;
    }
}
