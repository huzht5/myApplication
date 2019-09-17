package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2019-5-10.
 */

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();

}
