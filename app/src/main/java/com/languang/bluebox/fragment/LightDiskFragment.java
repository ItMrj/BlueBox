package com.languang.bluebox.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.languang.bluebox.R;
import com.languang.bluebox.basework.base.BaseFragment;
import com.languang.bluebox.constant.ApiConstant;
import com.languang.bluebox.constant.Constant;
import com.languang.bluebox.model.LightDiskModel;
import com.languang.bluebox.presenter.ILightDisk;
import com.mrj.framworklib.utils.OkHttpCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 光盘页面
 *
 * @author 49829
 * @date 2018/3/26
 */

public class LightDiskFragment extends BaseFragment implements OkHttpCallBack {


    Unbinder unbinder;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.progress_position)
    TextView progressPosition;

    private ILightDisk lightDiskModel;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_light_disk;
    }

    MyThread thread;

    @Override
    protected void initView(View view) {
        thread = new MyThread();
        thread.start();
    }

    @OnClick(R.id.start_archive)
    public void onViewClicked() {
        lightDiskModel.archiveProgress(this);
    }

    @Override
    public void onSucceed(String requestUrl, String response) {
        if (ApiConstant.BOX_START_GUIDANG.equals(requestUrl)) {
            lightDiskModel.archiveProgress(this);
        } else if (ApiConstant.BOX_GUIDANG.equals(requestUrl)) {

        }
    }

    @Override
    public void onFailed() {

    }

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i <= Constant.TOTAL_PROGRESS; i++) {
                if (null == progressBar || null == progressPosition) {
                    return;
                }
                progressBar.setProgress(i);
                //在子线程中发送消息
                final int finalI = i;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressPosition.setText(finalI + "%");
                    }
                });
                if (i == 100) {
                    new MyThread().start();
                    this.interrupt();
                    thread = null;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroy() {


        super.onDestroy();
    }

    @Override
    protected void initData() {
        lightDiskModel = new LightDiskModel(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
