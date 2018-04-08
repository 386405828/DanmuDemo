package com.tidemedia.danmudemo;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2016/8/16.
 */
public class MyApplaction extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //获取ImageLoader默认的设置
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);
        //ImageLoader初始化操作
        ImageLoader.getInstance().init(configuration);

    }
}