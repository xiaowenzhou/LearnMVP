package com.zhouxw.learnmvp.presenter;

import android.content.Context;
import android.util.Log;

import com.zhouxw.learnmvp.MainActivity;
import com.zhouxw.learnmvp.base.BasePresenter;
import com.zhouxw.learnmvp.interfaces.ValueCallBack;
import com.zhouxw.learnmvp.model.ITranslateModel;
import com.zhouxw.learnmvp.model.TranslateModel;
import com.zhouxw.learnmvp.view.ITranslateView;

public class TranslatePresenter extends BasePresenter<MainActivity> implements IPresenter {
    private static final String TAG = "TranslatePresenter";
    private ITranslateView mView;
    private ITranslateModel mModel;

    public TranslatePresenter(ITranslateView view) {
        this.mView = view;
        this.mModel= new TranslateModel();
    }

    @Override
    public void sendMsg2Model(String input, Context mContext) {
        mModel.handleData(input, mContext, new ValueCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                mView.setInfo(s);
            }

            @Override
            public void onFail(String code) {
                Log.d(TAG, "onFail: "+code);
                mView.setError();
            }
        });
    }

    @Override
    public void initData() {

    }
}
