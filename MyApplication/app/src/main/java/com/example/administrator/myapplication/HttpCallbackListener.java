package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2019-5-9.
 */

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}
