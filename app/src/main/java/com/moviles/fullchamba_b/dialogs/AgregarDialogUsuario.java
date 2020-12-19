package com.moviles.fullchamba_b.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.moviles.fullchamba_b.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AgregarDialogUsuario extends DialogFragment implements AdapterView.OnItemSelectedListener {

    EditText dlg_add_usuario_nombre,dlg_add_usuario_correo;
    Spinner dlg_add_usuario_cargo_spin;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_agregar_usuario, null);
        dlg_add_usuario_nombre = (EditText) view.findViewById(R.id.dlg_add_usuario_nombre);
        dlg_add_usuario_correo = (EditText) view.findViewById(R.id.dlg_add_usuario_correo);
        dlg_add_usuario_cargo_spin = (Spinner) view.findViewById(R.id.dlg_add_usuario_cargo_spin);
        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(getContext(),R.array.cargos, android.R.layout.simple_spinner_item);
        dlg_add_usuario_cargo_spin.setAdapter(spinAdapter);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dlg_add_usuario_cargo_spin.setOnItemSelectedListener(this);

        builder.setTitle("Agregar Usuario");
        builder.setView(view)
                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(getContext(),"Nombre: "+dlg_add_usuario_nombre.getText().toString()+"; Cargo: "+dlg_add_usuario_cargo_spin.getSelectedItem().toString()+"; Correo: "+dlg_add_usuario_correo.getText().toString(),Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AgregarDialogUsuario.this.getDialog().cancel();

                    }
                });
        return builder.create();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
