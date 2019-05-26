package br.com.fiap.componentes.naciot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndPoint {

    @GET(value = "iot/{status}" )
    Call<String> ligarLed(@Path("status") String status);

    @GET(value = "iot" )
    Call<List<IotPojo>> getIot();

}
