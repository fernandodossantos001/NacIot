package br.com.fiap.componentes.naciot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView humidade;
    private TextView luminosidade;
    private Button buttonLed;
    private Button buttonBuzzer;
    private Retrofit retrofit;
    private EndPoint api;
    private IotPojo iot;
    private String statusLed;
    private String statusBuzzer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.143:8080/02-oit/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iniciarServicos();

        humidade = findViewById(R.id.txtHumidade);
        luminosidade = findViewById(R.id.txtLuminosidade);
        buttonLed = findViewById(R.id.btnLed);
        buttonBuzzer = findViewById(R.id.btnBuzzer);



    }

    public void iniciarServicos(){
        requisicao();
        humidade.setText(Integer.toString(iot.getHum()));
        luminosidade.setText(Integer.toString(iot.getLuz()));

        if(iot.getLed()==0){
            statusLed = "ligar";
        }else{
            statusLed="desligar";
        }

        if(iot.getBuzzer()==0){
            statusBuzzer ="ligar";
        }else{
            statusBuzzer="desligar";
        }

        buttonLed.setText(statusLed);
        buttonBuzzer.setText(statusBuzzer);
    }


    public void ligaDesligaLed(){



        api = retrofit.create(EndPoint.class);
        api.ligarLed(statusLed).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                iniciarServicos();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("Erro ");
                t.printStackTrace();

            }
        });
    }


    public void requisicao(){
        api = retrofit.create(EndPoint.class);


        api.getIot().enqueue(new Callback<List<IotPojo>>() {
            @Override
            public void onResponse(Call<List<IotPojo>> call, Response<List<IotPojo>> response) {
                List<IotPojo> iots = response.body();



                iot = iots.get(0);


                System.out.println(iots.size());
                for(IotPojo iot : iots){
                    System.out.println(iot.getId());
                }

            }

            @Override
            public void onFailure(Call<List<IotPojo>> call, Throwable t) {
                System.out.println("Erro ");
                t.printStackTrace();
            }
        });


    }

    public void consultarApi(View view) {
        humidade.setText(Integer.toString(iot.getHum()));
        luminosidade.setText(Integer.toString(iot.getLuz()));

    }
}
