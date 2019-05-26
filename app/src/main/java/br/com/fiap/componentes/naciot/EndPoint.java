package br.com.fiap.componentes.naciot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoint {
    @GET("iot")
    Call<List<IotPojo>> getIot();

}
