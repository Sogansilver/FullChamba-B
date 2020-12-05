
package com.moviles.fullchamba_b.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.moviles.fullchamba_b.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AgregarDialogActividades extends DialogFragment {

    TextView txt_point;
    SeekBar seekBar_point;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_agregar_actividades, null);

        txt_point = (TextView) view.findViewById(R.id.txt_priority_point);
        seekBar_point = (SeekBar) view.findViewById(R.id.seekBar_actividad_prioridad);
        txt_point.setText("Prioridad: "+seekBar_point.getProgress()+"/"+seekBar_point.getMax());
        seekBar_point.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txt_point.setText("Prioridad: "+i+"/"+seekBar_point.getMax());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        builder.setTitle("Agregar una nueva actividad");
        builder.setView(view)
                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //listener.onDialogPositiveClick(AgregarDialog.this);
                    }
                })
                .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AgregarDialogActividades.this.getDialog().cancel();
                        //listener.onDialogNegativeClick(AgregarDialog.this);
                    }
                });
        return builder.create();



    }

/*    public interface AgregarListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    AgregarListener listener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (AgregarListener) context;
        } catch (ClassCastException e) {

        }
    }*/


}