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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.moviles.fullchamba_b.R;
import com.moviles.fullchamba_b.model.Actividad;
import com.moviles.fullchamba_b.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class UsuarioListAdapter extends RecyclerSwipeAdapter<UsuarioListAdapter.MyViewHolder> {
    private Context context;
    private List<Usuario> usuarioList;
    private List<Usuario> originalusuarioList;
    String url = "";

    public UsuarioListAdapter(Context context, List<Usuario> usuarioList) {
        this.context = context;
        this.usuarioList = usuarioList;
        this.originalusuarioList = new ArrayList<>();
        originalusuarioList.addAll(usuarioList);
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
        notifyDataSetChanged();
    }

    @Override
    public UsuarioListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_manage_user,parent,false);
        return new UsuarioListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsuarioListAdapter.MyViewHolder holder, int position) {

        final Usuario usu = usuarioList.get(position);

         holder.name_user.setText(this.usuarioList.get(position).getNomusu().toString());
         holder.position_user.setText(this.usuarioList.get(position).getCargousu().toString());
         Glide.with(context)
                .load(url+usu.getImageusu())
                .asBitmap()
                .error(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.image_user);

        holder.swipeLayout_user.setShowMode(SwipeLayout.ShowMode.PullOut);
        holder.swipeLayout_user.addDrag(SwipeLayout.DragEdge.Right,holder.swipeLayout_user.findViewById(R.id.bottom_wraper_user));
        holder.swipeLayout_user.addSwipeListener(new SwipeLayout.SwipeListener() {
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
        holder.swipeLayout_user.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Tarea: "+usuarioList.get(position).getNomusu(), Toast.LENGTH_SHORT).show();
            }
        });

                holder.edit_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Usuario Editado",Toast.LENGTH_SHORT).show();
                Bundle bundle1 = new Bundle();
                bundle1.putString("nombre_usuario",usuarioList.get(position).getNomusu());
                //bundle1.putString("apellido_usuario",usuarioList.get(position).getApeusu());
                bundle1.putString("cargo_usuario",usuarioList.get(position).getCargousu());
                bundle1.putString("correo_usuario",usuarioList.get(position).getCorreousu());
                Navigation.findNavController(view).navigate(R.id.action_nav_manage_user_to_editarDialogUsuario,bundle1);
            }
        });
        holder.delete_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Eliminar Usuario");
                builder.setMessage("¿Esta seguro que desea eliminar este usuario?");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mItemManger.removeShownLayouts(holder.swipeLayout_user);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, usuarioList.size());
                        mItemManger.closeAllItems();
                        Toast.makeText(context,"Usuario Eliminada",Toast.LENGTH_SHORT).show();
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
    }

    @Override
    public int getItemCount() {
        if (usuarioList!=null){
            return this.usuarioList.size();
        }
        return 0;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe_user;
    }

    public void filter(String newText) {
        if (newText.length()==0){
            usuarioList.clear();
            usuarioList.addAll(originalusuarioList);
        }else {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                usuarioList.clear();
                List<Usuario> collect = originalusuarioList.stream().filter(i -> i.getNomusu().toLowerCase().contains(newText)).collect(Collectors.toList());
                List<Usuario> collect1 = originalusuarioList.stream().filter(i -> i.getCargousu().toLowerCase().contains(newText)).collect(Collectors.toList());

                usuarioList.addAll(collect);
                usuarioList.addAll(collect1);
            }else {
                 for (Usuario usu: originalusuarioList){
                     if (usu.getNomusu().toLowerCase().contains(newText)){
                         usuarioList.add(usu);
                     }
                 }
            }
        }


        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageButton edit_user, delete_user;
        ImageView image_user;
        TextView name_user, position_user;
        SwipeLayout swipeLayout_user;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            swipeLayout_user = (SwipeLayout) itemView.findViewById(R.id.swipe_user);
            edit_user = (ImageButton) itemView.findViewById(R.id.Edit_user);
            delete_user = (ImageButton) itemView.findViewById(R.id.Delete_user);
            image_user = (ImageView) itemView.findViewById(R.id.image_user);
            name_user = (TextView) itemView.findViewById(R.id.name_user);
            position_user =(TextView) itemView.findViewById(R.id.position_user);

        }
    }
}
