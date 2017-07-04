package com.scwen7.baseproject.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwen7.baseproject.MyApplication;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * Created by 解晓辉  on 2017/6/10 14:18 *
 * QQ  ：811733738
 * 作用:
 */

public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;

    protected MyApplication mApplication;

    protected View mRootView;

    protected Unbinder mUnbinder;

    protected CompositeDisposable disposables;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(),container,false);

        initStatusLayout();

        mUnbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }




    /**
     * 子类如果需要多状态布局，需要重写此方法来配置多状态布局
     * 子类需要执行两部操作
     * Step1 初始化StatusLayout 配置多状态布局
     * Step2 添加到 ContentView的相应位置中
     */
    public void initStatusLayout() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (disposables != null) {
            disposables.dispose();
            disposables = null;
        }
        if(mUnbinder!=null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        mApplication = (MyApplication) mActivity.getApplication();
        initView();
    }


    /**
     * 初始化操作
     */
    protected abstract void initView();

    /**
     * 子类需要提供布局ID
     *
     * @return activity对应的  布局id
     */
    protected abstract int getLayoutId();


    public <T extends Activity> T  getParentActivity(){
        return (T)mActivity;
    }


    public void startActivity(Class <? extends Activity> clazz){
        mActivity.startActivity(new Intent(mActivity,clazz));
    }

    public void addRx(Disposable disposable) {
        if (disposables == null) {
            disposables = new CompositeDisposable();
        }
        disposables.add(disposable);
    }


    public void removeRx(Disposable disposable) {
        if (disposables == null) {
            return;
        }
        disposables.remove(disposable);

    }

}
