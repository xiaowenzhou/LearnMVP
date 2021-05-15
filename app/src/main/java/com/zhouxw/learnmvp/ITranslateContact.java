package com.zhouxw.learnmvp;

import android.content.Context;

import com.zhouxw.learnmvp.interfaces.ValueCallBack;

public interface ITranslateContact {
    interface ITranslateView {
        void setInfo(String str);

        void setError();
    }

    interface ITranslateModel {
        void handleData(String input, Context mContext, ValueCallBack<String> callBack);
    }
}
