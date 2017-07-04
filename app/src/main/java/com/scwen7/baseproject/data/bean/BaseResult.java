package com.scwen7.baseproject.data.bean;

/**
 * Created by 解晓辉  on 2017/6/4 13:54 *
 * QQ  ：811733738
 * 作用:
 */

public class BaseResult<T> {

    public static final int SUCCESS = 1;
    public static final int ERROR = 1000;
    private int status;
    private String info;
    private T data;


    public boolean isSuccess() {
        return (status == SUCCESS);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "status=" + status +
                ", info='" + info + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
