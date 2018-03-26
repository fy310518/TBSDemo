package com.example.tbsdemo;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

/**
 * application
 * Created by fangs on 2018/3/26.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //        tbs
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                Log.e("下载：", "onCoreInitFinished");
            }

            @Override
            public void onViewInitFinished(boolean b) {
                Log.e("嘿嘿", "X5内核初始化：" + b);
            }
        });
    }
}
