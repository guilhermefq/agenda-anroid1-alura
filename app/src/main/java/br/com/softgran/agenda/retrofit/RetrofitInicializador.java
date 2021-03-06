package br.com.softgran.agenda.retrofit;

import br.com.softgran.agenda.service.ContatoService;
import br.com.softgran.agenda.service.DispositivoService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by guilhermefq on 14/12/17.
 */

public class RetrofitInicializador {

    private final Retrofit retrofit;

    public RetrofitInicializador() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Criação de um Client para poder vincular o LogInterceptor ao Retrofit
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(httpLoggingInterceptor);


        retrofit = new Retrofit.Builder()
                .baseUrl("http:192.168.15.180:8080/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public ContatoService getContatoService() {
        return retrofit.create(ContatoService.class);
    }

    public DispositivoService getDispositivoService() { return retrofit.create(DispositivoService.class);}
}
