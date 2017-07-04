package com.scwen7.baseproject.common.http;


import android.content.Context;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;


/**
 * Created by 解晓辉  on 2017/6/10 09:48 *
 * QQ  ：811733738
 * 作用:
 */

public class HttpParamInterceptor implements Interceptor {


    private Context mContext;



    public HttpParamInterceptor(Context context) {
        this.mContext = context;
        init(context);

    }

    /**
     * 初始化 网络地址工具类
     *
     * @param context
     */
    public void init(Context context) {


    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        //添加公共的头部
        requestBuilder.addHeader("User-Agent", "pinxiango");


        String method = request.method();
        if ("GET".equals(method)) {  //GET请求
        } else if ("POST".equals(method)) {  //POST 请求
            RequestBody body = request.body();

            String data_json = ""; //传入的Json 字符串

            FormBody.Builder builder = new FormBody.Builder();


            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            data_json = buffer.readUtf8();
            builder.add("data", data_json);


            FormBody formBody = builder.build();

            request = requestBuilder
                    .post(formBody)
                    .build();
        }

        return chain.proceed(request);
    }

}
