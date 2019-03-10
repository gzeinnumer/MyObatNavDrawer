package com.gzeinnumer.myobatnavdrawer.server;



import com.gzeinnumer.myobatnavdrawer.model.ResponseReadObat;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiServices {
    @GET("ListData")
    Call<List<ResponseReadObat>> getAllOpData();

}
