package com.moviles.fullchamba_b.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.moviles.fullchamba_b.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class EditarDialogActividades extends DialogFragment {


    TextView txt_priority_point_edit;
    EditText dlg_edit_actividad_nombre,dlg_edit_actividad_responsable;
    SeekBar seekBar_point_edit;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_editar_actividades, null);

        dlg_edit_actividad_nombre = (EditText) view.findViewById(R.id.dlg_edit_actividad_nombre);
        dlg_edit_actividad_responsable = (EditText) view.findViewById(R.id.dlg_edit_actividad_responsable);
        txt_priority_point_edit = (TextView) view.findViewById(R.id.txt_priority_point_edit);
        seekBar_point_edit = (SeekBar) view.findViewById(R.id.seekBar_actividad_prioridad_edit);

        dlg_edit_actividad_nombre.setText(getArguments().getString("nombre_actividad"));
        dlg_edit_actividad_responsable.setText(getArguments().getString("responsable_actividad"));
        txt_priority_point_edit.setText("Prioridad: "+getArguments().getInt("prioridad")+"/"+seekBar_point_edit.getMax());
        seekBar_point_edit.setProgress(getArguments().getInt("prioridad"));





        txt_priority_point_edit.setText("Prioridad: "+seekBar_point_edit.getProgress()+"/"+seekBar_point_edit.getMax());
        seekBar_point_edit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txt_priority_point_edit.setText("Prioridad: "+i+"/"+seekBar_point_edit.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        builder.setTitle("Editar Actividad");
        builder.setView(view)
                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditarDialogActividades.this.getDialog().cancel();

                    }
                });
        return builder.create();

    }
}
