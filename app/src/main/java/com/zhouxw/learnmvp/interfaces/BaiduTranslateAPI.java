package com.zhouxw.learnmvp.interfaces;

import com.zhouxw.learnmvp.beans.ResponseBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BaiduTranslateAPI {

    @GET("translate?")
    Call<ResponseBean> getTranslate(@Query("q") String q, @Query("from") String from, @Query("to") String to, @Query("appid") String appid, @Query("salt") String salt, @Query("sign") String sign);

}
