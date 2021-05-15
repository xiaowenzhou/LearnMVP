package com.zhouxw.learnmvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author zhouxw
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected T mTranslatePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        mTranslatePresenter = initPresent();
        onPrepare();
    }

    protected abstract T initPresent();

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void onPrepare();
}
