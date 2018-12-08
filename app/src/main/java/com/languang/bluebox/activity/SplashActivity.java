package com.languang.bluebox.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.mrj.framworklib.utils.ScreenUtilBase;

import com.languang.bluebox.activity.login.LoginActivity;
import com.languang.bluebox.basework.costom.DefaultCode;

/**
 * 启动页
 *
 * @author 49829
 * @date 2018/4/16
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtilBase.setStatusBarColor(this, DefaultCode.G_STATUS_BAR_COLOR);
        if (!checkPermissionAllGranted(
                new String[]{
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                }
        )) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA,
                    Manifest.permission.READ_EXTERNAL_STORAGE}, 10001);
        } else {
            loginOrMain();
        }
    }

    private void loginOrMain() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 检查是否拥有指定的所有权限
     */
    private boolean checkPermissionAllGranted(String[] permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 第 3 步: 申请权限结果返回处理
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10001) {
            boolean isAllGranted = true;
            // 判断是否所有的权限都已经授予了
            for (int grant : grantResults) {
                if (grant != PackageManager.PERMISSION_GRANTED) {
                    isAllGranted = false;
                    break;
                }
            }
            if (isAllGranted) {

            }
            loginOrMain();
        }
    }

}
