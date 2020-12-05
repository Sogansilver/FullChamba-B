package com.moviles.fullchamba_b.adapter;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;

import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.daimajia.swipe.implments.SwipeItemRecyclerMangerImpl;
import com.moviles.fullchamba_b.R;
import com.moviles.fullchamba_b.model.Actividad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class ActividadListAdapter extends RecyclerSwipeAdapter<ActividadListAdapter.MyViewHolder> {
    private Context context;
    private List<Actividad> actividadList;
    private List<Actividad> originalactividadList;



    public ActividadListAdapter(Context context, List<Actividad> actividadList) {
        this.context = context;
        this.actividadList = actividadList;
        this.originalactividadList=new ArrayList<>();
        originalactividadList.addAll(actividadList);
    }

    public void setActivityList(List<Actividad> listactividad){
        this.actividadList = listactividad;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_manage_activities,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ActividadListAdapter.MyViewHolder holder, int position) {

        final Actividad  item = actividadList.get(position);

        holder.nomactividad.setText(this.actividadList.get(position).getNomacti().toString());
        holder.prioridadactividad.setText(this.actividadList.get(position).getPrioriacti()+"");
        holder.responsableactividad.setText(this.actividadList.get(position).getResponsableacti().toString());
        holder.estadoactividad.setText(this.actividadList.get(position).getEstadoacti().toString());

        holder.swipeLayout_activities.setShowMode(SwipeLayout.ShowMode.PullOut);
        holder.swipeLayout_activities.addDrag(SwipeLayout.DragEdge.Left,holder.swipeLayout_activities.findViewById(R.id.bottom_wrapper_activities1));
        holder.swipeLayout_activities.addDrag(SwipeLayout.DragEdge.Right,holder.swipeLayout_activities.findViewById(R.id.bottom_wraper_activities));
        holder.swipeLayout_activities.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {

            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });

        holder.swipeLayout_activities.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Tarea:"+actividadList.get(position).getNomacti()+ " \n" +actividadList.get(position).getEstadoacti(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.check_actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Tarea cumplida");
                builder.setMessage("¿La tarea ha sido realizada?");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (actividadList.get(position).getEstadoacti().equalsIgnoreCase("En proceso")){
                            //actividadList.get(position).setEstadoacti("Finalizada");
                            holder.estadoactividad.setText("Finalizada");
                            Toast.makeText(context,"Tarea Validada: "+actividadList.get(position).getNomacti(),Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(context,"La tarea ya ha sido finalizada",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

        holder.edit_actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Editando Tarea: "+actividadList.get(position).getNomacti(),Toast.LENGTH_SHORT).show();
                Bundle bundle1 = new Bundle();
                bundle1.putString("nombre_actividad",actividadList.get(position).getNomacti());
                bundle1.putString("responsable_actividad",actividadList.get(position).getResponsableacti());
                bundle1.putInt("prioridad",actividadList.get(position).getPrioriacti());
                Navigation.findNavController(view).navigate(R.id.action_nav_manage_activities_to_editarDialogActividades,bundle1);
            }
        });


        holder.delete_actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Eliminar Actividad");
                builder.setMessage("¿Esta seguro que desea eliminar esta actividad?");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mItemManger.removeShownLayouts(holder.swipeLayout_activities);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, actividadList.size());
                        mItemManger.closeAllItems();
                        Toast.makeText(context,"Tarea Eliminada: "+actividadList.get(position).getNomacti(),Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
        mItemManger.bindView(holder.itemView, position);
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe_activities;
    }

    @Override
    public int getItemCount() {
        if (actividadList!=null){
            return this.actividadList.size();
        }
        return 0;
    }

    public void filter(final String strsearch){
        if (strsearch.length()==0){
            actividadList.clear();
            actividadList.addAll(originalactividadList);
        }else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                actividadList.clear();
                List<Actividad> collect = originalactividadList.stream().filter(i -> i.getNomacti().toLowerCase().contains(strsearch)).collect(Collectors.toList());
                List<Actividad> collect1 = originalactividadList.stream().filter(i -> i.getResponsableacti().toLowerCase().contains(strsearch)).collect(Collectors.toList());
                List<Actividad> collect2 = originalactividadList.stream().filter(i -> i.getEstadoacti().toLowerCase().contains(strsearch)).collect(Collectors.toList());
                actividadList.addAll(collect);
                actividadList.addAll(collect1);
                actividadList.addAll(collect2);
            }
            else {
                actividadList.clear();
                for (Actividad act: originalactividadList) {
                    if (act.getNomacti().toLowerCase().contains(strsearch)){
                        actividadList.add(act);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nomactividad, prioridadactividad, responsableactividad,estadoactividad;
        ImageButton edit_actividad, delete_actividad, check_actividad;
        public SwipeLayout swipeLayout_activities;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomactividad = (TextView) itemView.findViewById(R.id.txt_adapt_activities);
            prioridadactividad = (TextView) itemView.findViewById(R.id.txt_adapt_priority);
            responsableactividad = (TextView) itemView.findViewById(R.id.txt_adapt_responsable);
            estadoactividad = (TextView) itemView.findViewById(R.id.txt_adapt_estado);

            delete_actividad = (ImageButton) itemView.findViewById(R.id.Delete_activities);
            edit_actividad = (ImageButton) itemView.findViewById(R.id.Edit_activities);
            check_actividad = (ImageButton) itemView.findViewById(R.id.check_activities);
            swipeLayout_activities = (SwipeLayout) itemView.findViewById(R.id.swipe_activities);
        }
    }
}
