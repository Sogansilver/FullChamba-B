package com.moviles.fullchamba_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moviles.fullchamba_b.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText edtuser, edtpassword;
    private Button btnlogin;
    private List<Usuario> usuariolist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuariolist = new ArrayList<>();
        Usuario usu1 = new Usuario("E001","Walter Perez","Administrador","wperez@gmail.com","123","");
        usuariolist.add(usu1);
        edtuser = (EditText) findViewById(R.id.edtuser);
        edtpassword= (EditText) findViewById(R.id.edtpassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usu1.getCodusu().equalsIgnoreCase(edtuser.getText().toString().toUpperCase()) && usu1.getPassusu().equalsIgnoreCase(edtpassword.getText().toString())){
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    i.putExtra("codigo",usu1.getCodusu());
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"Datos Invalidos",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}