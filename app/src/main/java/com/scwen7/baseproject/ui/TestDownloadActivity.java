package com.scwen7.baseproject.ui;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.scwen7.baseproject.R;
import com.scwen7.baseproject.base.BaseActivity;
import com.scwen7.baseproject.common.http.download.DownLoadUtil;
import com.scwen7.baseproject.common.http.download.DownloadStatus;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by 解晓辉 on 2017/7/4.
 * 作用：
 */

public class TestDownloadActivity extends BaseActivity {
    @BindView(R.id.btn_download)
    Button mBtnDownload;
    private Disposable mDisposable;

    @Override
    protected void initView() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test_download;
    }

    @OnClick(R.id.btn_download)
    public void download(View view) {
        String url = "http://www.bz55.com/uploads/allimg/150701/140-150F1142638.jpg";

        mDisposable = DownLoadUtil.download(url, Environment.getExternalStorageDirectory().getAbsolutePath(), "140-150F1142638.jpg")
                .subscribe(new Consumer<DownloadStatus>() {
                    @Override
                    public void accept(@NonNull DownloadStatus downloadStatus) throws Exception {
                        long downloadSize = downloadStatus.getDownloadSize();
                        long totalSize = downloadStatus.getTotalSize();
                        Log.e("TAG", "onNext  -->" + downloadSize + "------" + totalSize);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e("TAG", "onError:--->" + throwable);
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e("TAG", "下载完成");
                    }
                });

        addRx(mDisposable);
    }


    @OnClick(R.id.btn_pause)
    public void pause() {
        //取消订阅即为暂停下载
        removeRx(mDisposable);
    }
}
