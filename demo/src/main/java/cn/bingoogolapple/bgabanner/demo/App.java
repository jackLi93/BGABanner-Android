package cn.bingoogolapple.bgabanner.demo;

import android.app.Application;

import cn.bingoogolapple.bgabanner.demo.engine.Engine;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/6/21 下午10:13
 * 描述:
 */
public class App extends Application {
    private static App sInstance;
    private Engine mEngine;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        mEngine = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/bingoogolapple/BGABanner-Android/server/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Engine.class);
    }


    public static App getInstance() {
        return sInstance;
    }

    public Engine getEngine() {
        return mEngine;
    }
}