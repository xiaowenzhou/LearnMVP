package com.zhouxw.learnmvp.model;

import android.content.Context;

import com.zhouxw.learnmvp.interfaces.ValueCallBack;

/**
 * @author zhouxw
 */
public interface ITranslateModel {
   public void handleData(String input , Context mContext, ValueCallBack<String> callBack);
}
