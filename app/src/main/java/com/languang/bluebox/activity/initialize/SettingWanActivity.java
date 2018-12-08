package com.languang.bluebox.activity.initialize;

import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;
import com.mrj.framworklib.utils.OkHttpCallBack;
import com.mrj.framworklib.utils.ToastUtilsBase;

import java.util.HashMap;
import java.util.Map;

import com.languang.bluebox.R;
import com.languang.bluebox.basework.base.BaseFragmentActivity;
import com.languang.bluebox.basework.net.OkHttpUtils;
import com.languang.bluebox.constant.ApiConstant;
import com.languang.bluebox.constant.Constant;
import com.languang.bluebox.entity.ResponseMessage;

/**
 * 设置WAN
 *
 * @author 49829
 * @date 2018/4/10
 */

public class SettingWanActivity extends BaseFragmentActivity implements OkHttpCallBack {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setting_wan;
    }

    @Override
    protected void initView() {
        setTitle("设置WAN");
        setRightText("保存");
        setRightOnclick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateWAN();
            }
        });
    }

    @Override
    protected void initData() {

    }

    /**
     * 设置WAN
     */
    private void updateWAN() {
        Map<String, Object> params = new HashMap<>(4);
        params.put("protocol", "PPPoE");
        params.put("account", "abc");
        params.put("password", "123456");
        params.put("macAddress", "A4-56-03-78-87-B3");
        OkHttpUtils.getInstance().okPost(mContext, ApiConstant.SETTING_WAN_URL, params, this);
    }

    @Override
    public void onSucceed(String requestUrl, String response) {
        ResponseMessage responseMessage = new Gson().fromJson(response, ResponseMessage.class);
        ToastUtilsBase.showToastCenter(mContext, responseMessage.getMsg());
        if (Constant.REQUEST_SUCCEED.equals(responseMessage.getRet())) {
            startActivity(new Intent(mContext, SettingPwdActivity.class));
            finish();
        } else {
//            ToastUtilsBase.showToastCenter(mContext,responseMessage.getMessage());
        }
    }

    @Override
    public void onFailed() {

    }
}
