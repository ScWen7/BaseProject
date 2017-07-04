package com.scwen7.baseproject.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.scwen7.baseproject.ui.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 解晓辉  on 2017/5/21 09:36 *
 * QQ  ：811733738
 * 作用:
 */

public abstract class BasePresenter<M, V extends BaseView> {

    private CompositeDisposable disposables;// 管理Destroy取消订阅者者

    protected M mModel;
    protected V mView;

    protected Context mContext;

    public BasePresenter(V view) {
        mView = view;
        initContext(view);
        mModel = createModel();
    }

    protected void initContext(V view) {
        if (view instanceof Activity) {
            //Activity
            mContext = (Activity) view;
        } else {
            mContext = ((Fragment) view).getActivity();
        }

    }

    public boolean addRx(Disposable disposable) {
        if (disposables == null) {
            disposables = new CompositeDisposable();
        }
        disposables.add(disposable);
        return true;
    }


    public void removeRx(Disposable disposable) {
        if (disposables == null) {
            disposables.remove(disposable);
        }

    }

    public Context getContext() {
        return mContext;
    }

    protected abstract M createModel();


    public void detachView() {
        if (disposables != null) {
            disposables.dispose();
            disposables = null;
        }
    }


}
