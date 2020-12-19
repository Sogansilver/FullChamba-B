
package com.moviles.fullchamba_b.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.moviles.fullchamba_b.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.Navigation;

public class AgregarDialogActividades extends DialogFragment {

    TextView txt_point;
    SeekBar seekBar_point;
    EditText dlg_add_actividad_nombre,dlg_add_actividad_responsable;
    int num_prio = 0;
    //AgregarDialogActividadesListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_agregar_actividades, null);

        txt_point = (TextView) view.findViewById(R.id.txt_priority_point);
        dlg_add_actividad_nombre = (EditText) view.findViewById(R.id.dlg_add_actividad_nombre);
        dlg_add_actividad_responsable = (EditText) view.findViewById(R.id.dlg_add_actividad_responsable);
        seekBar_point = (SeekBar) view.findViewById(R.id.seekBar_actividad_prioridad);
        txt_point.setText("Prioridad: "+seekBar_point.getProgress()+"/"+seekBar_point.getMax());
        seekBar_point.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txt_point.setText("Prioridad: "+i+"/"+seekBar_point.getMax());
                num_prio = i;
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
//                        final String nombre_actividad = dlg_add_actividad_nombre.getText().toString();
//                        final String responsable = dlg_add_actividad_responsable.getText().toString();
//                        //final int prioridad = num_prio;
//                        int prioridad = seekBar_point.getProgress();
                        //listener.Crear_Actividad(nombre_actividad,responsable,prioridad);
//                        Bundle bundle2 = new Bundle();
//                        bundle2.putString("nombre_actividad",dlg_add_actividad_nombre.getText().toString());
//                        bundle2.putString("responsable",dlg_add_actividad_responsable.getText().toString());
//                        bundle2.putInt("prioridad",seekBar_point.getProgress());
//                        Navigation.findNavController(getParentFragment().getView()).navigate(R.id.action_agregarDialogActividades_to_nav_manage_activities,bundle2);


                        //Navigation.createNavigateOnClickListener(R.id.action_agregarDialogActividades_to_nav_manage_activities);



                        //getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK,getActivity().getIntent());
                        //getTargetFragment().onActivityResult(getTargetRequestCode(),
                         //       Activity.RESULT_OK, mIntent);

                        Toast.makeText(getActivity(),"Actividad: "+dlg_add_actividad_nombre.getText().toString()+"; Responsable: "+dlg_add_actividad_responsable.getText().toString()+"; Estado: En proceso ; Dificultad: "+seekBar_point.getProgress(),Toast.LENGTH_SHORT).show();


                    }
                })
                .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AgregarDialogActividades.this.getDialog().cancel();
                        //getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_CANCELED,getActivity().getIntent());
                    }
                });
        return builder.create();



    }



  /* @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            listener = (AgregarDialogActividadesListener) getTargetFragment();
        }catch (ClassCastException e){
            throw new ClassCastException( "Must implement AgregarDialogActividadesListener");
        }
    }*/

    /*public interface  AgregarDialogActividadesListener{
        void Crear_Actividad(String nombre_actividad,String responsable,int prioridad);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (AgregarDialogActividadesListener) context;
        }catch (ClassCastException e){
            e.getMessage();
            throw new ClassCastException(context.toString() +" must implement AgregarDialogActividadesListener");
        }

    }*/

}