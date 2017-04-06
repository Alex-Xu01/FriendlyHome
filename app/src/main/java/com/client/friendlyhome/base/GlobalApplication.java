package com.client.friendlyhome.base;

import android.app.Application;

import com.client.friendlyhome.net.HttpRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.squareup.okhttp.OkHttpClient;

import java.io.InputStream;

/**
 * Created by ALex on 2017/4/6.
 */

public class GlobalApplication extends Application {

    private static GlobalApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

    }


    /**
     * 图片加载框架Glide,使用OkHttp处理网络请求
     */
    private void initGlide() {
        OkHttpClient okHttpClient = HttpRequest.getHttpClient();
        Glide.get(this).register(GlideUrl.class, InputStream.class,
                new OkHttpUrlLoader.Factory(okHttpClient));
    }
}
