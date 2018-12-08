package com.languang.bluebox;


import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.languang.bluebox.basework.base.BaseFragmentActivity;
import com.languang.bluebox.basework.net.OkHttpUtils;
import com.languang.bluebox.constant.ApiConstant;
import com.languang.bluebox.constant.Constant;
import com.languang.bluebox.coustomview.tabview.MainViewAdapter;
import com.languang.bluebox.coustomview.tabview.TabContainerView;
import com.languang.bluebox.entity.AccessPoint;
import com.languang.bluebox.entity.CountImgInfo;
import com.languang.bluebox.entity.ResponseMessage;
import com.languang.bluebox.fragment.LightDiskFragment;
import com.languang.bluebox.fragment.facility.FacilityFragment;
import com.languang.bluebox.fragment.mapstorage.MapStorageFragment;
import com.languang.bluebox.fragment.propertysheet.PropertySheetFragment;
import com.languang.bluebox.receiver.ConnectedStateReceiver;
import com.languang.bluebox.receiver.ScanResultReceiver;
import com.languang.bluebox.receiver.WiFiStateReceiver;
import com.languang.bluebox.utils.WiFiHandler;
import com.languang.bluebox.utils.wifi.Courier;
import com.mrj.framworklib.utils.OkHttpCallBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页
 *
 * @author 49829
 */
public class MainActivity extends BaseFragmentActivity {


    @BindView(R.id.tab_container)
    TabContainerView tabContainer;

    protected MainViewAdapter mainViewAdapter;

    @BindView(R.id.bottom_tv)
    TextView bottomTv;

    private WiFiStateReceiver wiFiStateReceiver;
    private ScanResultReceiver scanResultReceiver;
    private ConnectedStateReceiver connectedStateReceiver;

    private WiFiHandler wiFiHandler;

    private List<AccessPoint> currentAps;

    private HashMap<String, Integer> configuredAP;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        mainViewAdapter = new MainViewAdapter(getSupportFragmentManager(),
                new Fragment[]{
                        new MapStorageFragment(), new LightDiskFragment(),
                        new PropertySheetFragment(), new FacilityFragment()});
        tabContainer.setAdapter(mainViewAdapter);


    }

    @Override
    protected void initData() {
//        wiFiHandler = WiFiHandler.instance();
//        wiFiHandler.startScan();

        currentAps = new ArrayList<>();
        configuredAP = new HashMap<>();

        getCountImg();
    }

    private void getCountImg() {
        OkHttpUtils.getInstance().okPost(this, ApiConstant.BOX_COUNT_IMG, null, new OkHttpCallBack() {
            @Override
            public void onSucceed(String requestUrl, String response) {
                ResponseMessage<CountImgInfo> responseMessage = new Gson().fromJson(response,
                        new TypeToken<ResponseMessage<CountImgInfo>>() {
                        }.getType());
                if (Constant.SUCCEED_CODE == responseMessage.getRet()) {
                    bottomTv.setText("新标注" + responseMessage.getData().getTagimg().getImageCount() + "张照片，"
                            + responseMessage.getData().getTagimg().getVideoCount() + "个视频未光盘回档");
                }
            }

            @Override
            public void onFailed() {

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        initReceiver();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterReceiver();
    }

    /**
     * 注册广播接收器
     */
    private void initReceiver() {
        wiFiStateReceiver = new WiFiStateReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wiFiStateReceiver, filter);

        scanResultReceiver = new ScanResultReceiver();
        IntentFilter scanFilter = new IntentFilter();
        scanFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(scanResultReceiver, scanFilter);

        connectedStateReceiver = new ConnectedStateReceiver();
        IntentFilter connectFilter = new IntentFilter();
        connectFilter.addAction(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION);
        connectFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(connectedStateReceiver, connectFilter);
    }

    /**
     * 注销广播
     */
    private void unRegisterReceiver() {
        unregisterReceiver(wiFiStateReceiver);
        unregisterReceiver(scanResultReceiver);
        unregisterReceiver(connectedStateReceiver);
        Courier.recycle();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
