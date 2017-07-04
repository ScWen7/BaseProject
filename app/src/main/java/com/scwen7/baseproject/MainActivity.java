package com.scwen7.baseproject;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.scwen7.baseproject.common.http.download.DownLoadUtil;
import com.scwen7.baseproject.common.http.download.DownloadStatus;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private Disposable mSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://www.bz55.com/uploads/allimg/150701/140-150F1142638.jpg";

        mSubscribe = DownLoadUtil.download(url, Environment.getExternalStorageDirectory().getAbsolutePath(), "140-150F1142638.jpg")
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
    }

    private boolean isPause =false;
    public void pause(View view) {
        if(isPause== false) {
            mSubscribe.dispose();
        }
    }
}
