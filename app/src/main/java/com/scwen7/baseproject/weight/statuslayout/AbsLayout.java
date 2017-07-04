package com.scwen7.baseproject.weight.statuslayout;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewStub;

/**
 *
 */
public abstract class AbsLayout {

    protected ViewStub mLayoutVs;

    protected View mContentView;

    protected void initLayout(@LayoutRes int layoutResId, Context context) {
        mLayoutVs = new ViewStub(context);
        mLayoutVs.setLayoutResource(layoutResId);
    }

    protected ViewStub getLayoutVs() {
        return mLayoutVs;
    }

    protected void setView(View contentView) {
        mContentView = contentView;
    }

    protected abstract void setData(Object... objects);
}
