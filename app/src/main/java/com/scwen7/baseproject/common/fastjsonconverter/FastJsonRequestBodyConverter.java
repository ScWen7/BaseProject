package com.scwen7.baseproject.common.fastjsonconverter;


import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;


/**
 * Created by Administrator on 2016/9/12.
 */
public class FastJsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    public static final Charset UTF_8= Charset.forName("UTF-8");
    public static final MediaType type= MediaType.parse("application/json; charset=UTF-8");



    @Override
    public RequestBody convert(T value) throws IOException {
        return RequestBody.create(type, JSON.toJSONString(value).getBytes("UTF-8"));
    }
}
