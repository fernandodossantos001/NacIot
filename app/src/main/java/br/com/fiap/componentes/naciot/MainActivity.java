package br.com.fiap.componentes.naciot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/02-oit/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EndPoint api = retrofit.create(EndPoint.class);

        api.getIot().enqueue(new Callback<List<IotPojo>>() {
            @Override
            public void onResponse(Call<List<IotPojo>> call, Response<List<IotPojo>> response) {
                List<IotPojo> iots = response.body();
                for(IotPojo iot : iots){
                    System.out.println(iot.getId());
                }

            }

            @Override
            public void onFailure(Call<List<IotPojo>> call, Throwable t) {
                System.out.println("Fudeu");
            }
        });

    }
}
