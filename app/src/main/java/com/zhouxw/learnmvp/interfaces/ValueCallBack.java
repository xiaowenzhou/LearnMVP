package com.zhouxw.learnmvp.interfaces;

public interface ValueCallBack<T> {
    void onSuccess(T t);
    void onFail(String code);
}
