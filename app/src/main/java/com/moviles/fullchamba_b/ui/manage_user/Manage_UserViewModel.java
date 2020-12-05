package com.moviles.fullchamba_b.ui.manage_user;

import com.moviles.fullchamba_b.model.Usuario;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Manage_UserViewModel extends ViewModel {

    private MutableLiveData<List<Usuario>> listaUsuario;
    private List<Usuario> lisUsuario;

    public LiveData<List<Usuario>> getlistaUsuario(){
        if (listaUsuario==null){
            listaUsuario = new MutableLiveData<List<Usuario>>();
            lisUsuario = new ArrayList<>();
        }
        return listaUsuario;
    }


    public void setListaUsuario(MutableLiveData<List<Usuario>> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

}