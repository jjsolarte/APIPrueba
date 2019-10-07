package co.jjsolarte.apiprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre, edtContraseña;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializer();
    }

    private void inicializer() {
        edtNombre = findViewById(R.id.mainNombre);
        edtContraseña = findViewById(R.id.mainContrasena);
        btnIngresar = findViewById(R.id.mainBtnImgresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPosts(edtNombre.getText().toString(), edtContraseña.getText().toString());
            }
        });
    }

    private void getPosts(String nombre, String pass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.75.199.99:8083/HiGina-2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UsuarioInterfaz postService = retrofit.create(UsuarioInterfaz.class);

        Call<List<Usuario>> call = postService.autenticarUsuario(nombre,pass);

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                for(Usuario user : response.body()) {
                    if (user.getNombreusuario()!=null)
                        cambioActivity(user);
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Datos Invalidos", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void cambioActivity(Usuario usuario) {
        Toast.makeText(this, "Bienvenido "+usuario.getNombreusuario()
                , Toast.LENGTH_SHORT).show();

        //Intent ....
        //Intent.putExtra("key","value");
    }
}
