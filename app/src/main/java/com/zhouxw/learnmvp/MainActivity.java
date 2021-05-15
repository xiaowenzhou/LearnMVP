package com.zhouxw.learnmvp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zhouxw.learnmvp.base.BaseActivity;
import com.zhouxw.learnmvp.presenter.TranslatePresenter;
import com.zhouxw.learnmvp.view.ITranslateView;

public class MainActivity extends BaseActivity<TranslatePresenter> implements ITranslateView {
    private EditText mEditText;
    private TextView mTextView;


    @Override
    protected void initView() {
        mEditText= findViewById(R.id.et_translate);
        mTextView= findViewById(R.id.tv_result);
    }

    @Override
    protected TranslatePresenter initPresent() {
        return new TranslatePresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void onPrepare() {

    }

    public void onBtnClick(View view) {
        mTranslatePresenter.sendMsg2Model(mEditText.getText().toString(),MainActivity.this);
    }

    @Override
    public void setError() {
        mTextView.setText("查询失败");
    }

    @Override
    public void setInfo(String str) {
        mTextView.setText(str);
    }
}