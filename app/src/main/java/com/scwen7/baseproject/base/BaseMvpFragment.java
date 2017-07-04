package com.scwen7.baseproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.scwen7.baseproject.presenter.BasePresenter;


/**
 * Created by 解晓辉  on 2017/6/10 14:52 *
 * QQ  ：811733738
 * 作用:   封装完成之后方法的调用顺序为:
 *   getLayoutId()   -> initView()  -> createPresenter() -> intiData()
 *
 *   生命周期  onDestoryView -> 中包含  presenter 的 detachView 和 presenter的置空
 *
 *
 */

public abstract class BaseMvpFragment <P  extends BasePresenter> extends BaseFragment {


    protected  P mPresenter;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = createPresenter();
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter!=null) {
            mPresenter.detachView();
            mPresenter = null;
        }

    }


    /**
     * 创建 Presenter
     * @return
     */
    public  abstract  P createPresenter() ;

}
