package com.moviles.fullchamba_b.ui.manage_user;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.swipe.util.Attributes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moviles.fullchamba_b.R;
import com.moviles.fullchamba_b.adapter.ActividadListAdapter;
import com.moviles.fullchamba_b.adapter.UsuarioListAdapter;
import com.moviles.fullchamba_b.model.Actividad;
import com.moviles.fullchamba_b.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Manage_UserFragment extends Fragment implements SearchView.OnQueryTextListener{

    private Manage_UserViewModel manageUserViewModel;
    private UsuarioListAdapter adapter;
    private List<Usuario> usuariolist;
    private SearchView vsearch_user;
    private FloatingActionButton fb_add1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        manageUserViewModel =
                ViewModelProviders.of(this).get(Manage_UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_manage_user, container, false);

        manageUserViewModel.getlistaUsuario().observe(getViewLifecycleOwner(), new Observer<List<Usuario>>() {
            @Override
            public void onChanged(List<Usuario> usuarios) {
                usuariolist = usuarios;
                adapter.setUsuarioList(usuarios);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fb_add1=view.findViewById(R.id.fb_AddInUser);
        vsearch_user=view.findViewById(R.id.vsearch_user);
        usuariolist = new ArrayList<>();
        Usuario usu1 = new Usuario("Juan","Martinez","Personal","124332@utp.edu.pe","123","");
        Usuario usu2 = new Usuario("Martin","Vizcarra","Congresista","mvizcarra@gmail.com","123","");
        usuariolist.add(usu1);
        usuariolist.add(usu2);

        RecyclerView recyclerView = view.findViewById(R.id.recycle_user);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new UsuarioListAdapter(getContext(),usuariolist);
        ((UsuarioListAdapter)adapter).setMode(Attributes.Mode.Single);
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
        fb_add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Agregar Usuario",Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_nav_manage_user_to_agregarDialogUsuario);
            }
        });
    }

    private void iniListenner(){
        vsearch_user.setOnQueryTextListener(this);

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