package com.languang.bluebox.basework.net;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import com.languang.bluebox.R;
import com.languang.bluebox.basework.BaseApplication;
import com.languang.bluebox.basework.utils.SharedPrefsUtil;
import com.languang.bluebox.entity.user.UserUtils;
import com.languang.bluebox.utils.MobileInfoUtils;
import com.mrj.framworklib.utils.OkHttpCallBack;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络请求工具类
 *
 * @author 49829
 * @date 2018/4/8
 */

public class OkHttpUtils {

    private static OkHttpClient singleton;
    /**
     * 将ui操作放置到主线程
     */
    private Handler mHandler;
    private Context context;

    /**
     * 非常有必要，要不此类还是可以被new，但是无法避免反射，好恶心
     */
    private OkHttpUtils() {
        //初始化
        mHandler = new Handler();
        this.context = context;
    }

    /**
     * 1:懒汉式，静态工程方法，创建实例
     */
    public static OkHttpUtils getInstance() {
        return OkHttpUtilsHolder.instace;
    }

    /**
     * 使用静态内部类来构造实例  降低耦合  线程安全
     */
    private static class OkHttpUtilsHolder {
        private static final OkHttpUtils instace = new OkHttpUtils();
    }

    /**
     * 初始化 OkHttpClient
     *
     * @return OkHttpClient实例
     */
    private static OkHttpClient getSingleton(Context context) {
        if (singleton == null) {
            synchronized (OkHttpUtils.class) {
                if (singleton == null) {
                    File sdCache = context.getExternalCacheDir();
                    int cacheSize = 10 * 1024 * 1024;
                    singleton = new OkHttpClient.Builder()
                            //连接超时(单位:秒)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            //写入超时(单位:秒)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            //读取超时(单位:秒)
                            .readTimeout(20, TimeUnit.SECONDS)
                            //webSocket轮训间隔(单位:秒)
                            .pingInterval(20, TimeUnit.SECONDS)
                            .cache(new Cache(sdCache.getAbsoluteFile(), cacheSize))
                            .build();
                }
            }
        }
        return singleton;
    }

    /**
     * Get 请求（无参）
     *
     * @param callback 回调接口
     * @param url      请求地址
     */
    public void okGet(Context context, final String url, final OkHttpCallBack callback) {
        Request request = addHeaders(context)
                .url(url)
                .build();
        getSingleton(context).newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSucceed(url, res);
                    }
                });
            }
        });
    }


    /**
     * post请求
     *
     * @param callBack 回调
     * @param url      请求地址
     * @param map      参数
     * @param context  上下文对象
     */
    public void okPost(Context context
            , final String url
            , Map<String, Object> map
            , final OkHttpCallBack callBack
    ) {

        FormBody.Builder builder = new FormBody.Builder();
        /**
         * 遍历key
         */
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue().toString());
            }
        }
        Request request = addHeaders(context)
                .url(url)
                .tag(context)
                .post(builder.build())
                .build();
        getSingleton(context).newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFailed();
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSucceed(url, res);
                    }
                });
            }
        });

    }

    /**
     * 添加消息头
     *
     * @return 返回一个builder
     */
    private Request.Builder addHeaders(Context context) {
        Request.Builder builder = null;
        builder = new Request.Builder()
                //addHeader，可添加多个请求头  header，唯一，会覆盖
                .addHeader("Connection", "keep-alive")
                .addHeader("Token",
                        SharedPrefsUtil.getValue("InitialInfo", "AccessToken", ""))
                .addHeader("Imei", MobileInfoUtils.getIMEI(context));
        return builder;
    }


}
