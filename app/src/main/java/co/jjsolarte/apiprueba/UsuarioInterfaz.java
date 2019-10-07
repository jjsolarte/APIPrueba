package co.jjsolarte.apiprueba;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsuarioInterfaz {

    String API_LOGIN = "webresources/k_soft.jpa.entidades.usuario/androide/{user}/{pass}";
    String API_LOGIN_PAME = "webresources/higina.jpa.entidades.usuario/androide/{user}/{pass}";

    @GET(API_LOGIN_PAME)
    Call<List<Usuario>> autenticarUsuario(@Path("user") String groupId, @Path("pass") String groupPass);

    /*
    @GET(API_LISTAR)
    Call<List<Usuario> > getPost();
    */
}
