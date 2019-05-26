package br.com.fiap.componentes.naciot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoint {
    @GET("listar")
    Call<List<IotPojo>> getIot();

}
