package com.gzeinnumer.myobatnavdrawer.server;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//todo 15.
public class RetroServer {

    public static final String BASE_URL = "http://dev.smart-ics.com:212/pindai-opname/api/History/" ;


    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiServices getInstance(){
        return setInit().create(ApiServices.class);
    }

}
