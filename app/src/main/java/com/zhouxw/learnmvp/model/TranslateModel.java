package com.zhouxw.learnmvp.model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhouxw.learnmvp.beans.ResponseBean;
import com.zhouxw.learnmvp.interfaces.BaiduTranslateAPI;
import com.zhouxw.learnmvp.interfaces.ValueCallBack;
import com.zhouxw.learnmvp.utils.ConvertUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TranslateModel implements ITranslateModel {
    private static final String TAG = "TranslateModel";
    private static final String BASE_URL = "https://fanyi-api.baidu.com/api/trans/vip/";

    public TranslateModel() {

    }

    @Override
    public void handleData(String input, Context mContext, ValueCallBack<String> callBack) {
        String appid = "20210515000828322";
        String salt1 = ConvertUtil.getRandom(2);
        String sign = getSign(input, appid, salt1);
        final Gson mGson = new GsonBuilder()
                .setLenient()  // 设置GSON的非严格模式setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .build();
        BaiduTranslateAPI request = retrofit.create(BaiduTranslateAPI.class);
        Call<ResponseBean> responseBeanCall = request.getTranslate(input, "zh", "en", appid, salt1, sign);
        responseBeanCall.enqueue(new Callback<ResponseBean>() {
            @Override
            public void onResponse(Call<ResponseBean> call, Response<ResponseBean> response) {
                ResponseBean responseBean = response.body();
                if (responseBean == null) {
                    callBack.onFail("null");
                }
                List<ResponseBean.TransResultBean> transResultBeans = responseBean.getTrans_result();
                callBack.onSuccess(transResultBeans.get(0).getDst());
            }

            @Override
            public void onFailure(Call<ResponseBean> call, Throwable t) {
                t.printStackTrace();
                callBack.onFail("fail");

            }
        });


    }

    private String getSign(String input, String appid, String salt) {
        String pwd = "cmPx8idm6xk1mKtQbxnf";
        return ConvertUtil.stringToMD5(appid + input + salt + pwd);
    }


}
