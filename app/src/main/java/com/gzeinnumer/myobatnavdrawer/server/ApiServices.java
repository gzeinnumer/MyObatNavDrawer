package com.gzeinnumer.myobatnavdrawer.server;



import com.gzeinnumer.myobatnavdrawer.model.ResponseGetData;
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
import retrofit2.http.Query;


public interface ApiServices {
    @GET("History/ListData")
    Call<List<ResponseReadObat>> getAllOpData();

    @GET("barang/getdata")
    Call<ResponseGetData> getOpData(@Query("id") String id);
}
