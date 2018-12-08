package com.languang.bluebox.activity.initialize;

import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;
import com.mrj.framworklib.utils.OkHttpCallBack;
import com.mrj.framworklib.utils.ToastUtilsBase;

import java.util.HashMap;
import java.util.Map;

import com.languang.bluebox.R;
import com.languang.bluebox.activity.facility.MyWifiActivity;
import com.languang.bluebox.basework.base.BaseFragmentActivity;
import com.languang.bluebox.basework.net.OkHttpUtils;
import com.languang.bluebox.constant.ApiConstant;
import com.languang.bluebox.constant.Constant;
import com.languang.bluebox.entity.ResponseMessage;

/**
 * 初始化密码
 *
 * @author 49829
 * @date 2018/4/12
 */

public class SettingPwdActivity extends BaseFragmentActivity implements OkHttpCallBack {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_settting_pwd;
    }

    @Override
    protected void initView() {
        setTitle("宝盒密码");
        setRightText("保存");
        setRightOnclick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePwd();
            }
        });
    }


    @Override
    protected void initData() {

    }

    /**
     * 初始化密码
     */
    private void updatePwd() {
        Map<String, Object> params = new HashMap<>(2);
        params.put("admin", "123456");
        params.put("guest", "abcd");
        OkHttpUtils.getInstance().okPost(mContext, ApiConstant.SETTING_PWD_URL, params, this);
    }


    @Override
    public void onSucceed(String requestUrl, String response) {
        ResponseMessage responseMessage = new Gson().fromJson(response, ResponseMessage.class);
        ToastUtilsBase.showToastCenter(mContext, responseMessage.getMsg());
        if (Constant.REQUEST_SUCCEED.equals(responseMessage.getRet())) {
            startActivity(new Intent(mContext, MyWifiActivity.class));
            finish();
        } else {
//            ToastUtilsBase.showToastCenter(mContext,responseMessage.getMessage());
        }
    }

    @Override
    public void onFailed() {

    }
}
