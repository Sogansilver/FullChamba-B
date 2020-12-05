package com.moviles.fullchamba_b.model;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nomusu;
    private String apeusu;
    private String cargousu;
    private String correousu;
    private String passusu;
    private String imageusu;

    public Usuario(String nomusu, String apeusu, String cargousu, String correousu, String passusu, String imageusu) {
        this.nomusu = nomusu;
        this.apeusu = apeusu;
        this.cargousu = cargousu;
        this.correousu = correousu;
        this.passusu = passusu;
        this.imageusu = imageusu;
    }

    public Usuario(){

    }

    public String getNomusu() {
        return nomusu;
    }

    public void setNomusu(String nomusu) {
        this.nomusu = nomusu;
    }

    public String getApeusu() {
        return apeusu;
    }

    public void setApeusu(String apeusu) {
        this.apeusu = apeusu;
    }

    public String getCargousu() {
        return cargousu;
    }

    public void setCargousu(String cargousu) {
        this.cargousu = cargousu;
    }

    public String getCorreousu() {
        return correousu;
    }

    public void setCorreousu(String correousu) {
        this.correousu = correousu;
    }

    public String getPassusu() {
        return passusu;
    }

    public void setPassusu(String passusu) {
        this.passusu = passusu;
    }

    public String getImageusu() {
        return imageusu;
    }

    public void setImageusu(String imageusu) {
        this.imageusu = imageusu;
    }
}
