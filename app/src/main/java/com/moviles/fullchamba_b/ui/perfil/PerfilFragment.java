package com.moviles.fullchamba_b.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.moviles.fullchamba_b.R;
import com.moviles.fullchamba_b.adapter.ActividadListAdapter;
import com.moviles.fullchamba_b.adapter.UsuarioListAdapter;
import com.moviles.fullchamba_b.model.Actividad;
import com.moviles.fullchamba_b.model.Usuario;

import java.util.List;

public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilViewModel;
    private MutableLiveData<List<Usuario>> listUsuario;
    private UsuarioListAdapter adapter;
    private List<Usuario> usuariolist;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                ViewModelProviders.of(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        perfilViewModel.getlistaUsuario().observe(getViewLifecycleOwner(), new Observer<List<Usuario>>() {
            @Override
            public void onChanged(List<Usuario> usuarios) {
                if (usuarios!=null){
                    usuariolist = usuarios;

                }
            }
        });
        return root;
    }

    TextView txt_nombre,txt_apellido,txt_cargo,txt_correo;
    ImageView imageperfil;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt_nombre = (TextView) view.findViewById(R.id.txt_nombre);
        txt_apellido = (TextView) view.findViewById(R.id.txt_apellido);
        txt_cargo = (TextView) view.findViewById(R.id.txt_cargo);
        txt_correo = (TextView) view.findViewById(R.id.txt_correo);
        imageperfil = (ImageView) view.findViewById(R.id.imagePerfil);

        Usuario usu2 = new Usuario("Martin","Vizcarra","Congresista","mvizcarra@gmail.com","123","");
        txt_nombre.setText(usu2.getNomusu());
        txt_apellido.setText(usu2.getApeusu());
        txt_cargo.setText(usu2.getCargousu());
        txt_correo.setText(usu2.getCorreousu());
        imageperfil.setImageResource(R.drawable.ic_launcher_background);
    }
}