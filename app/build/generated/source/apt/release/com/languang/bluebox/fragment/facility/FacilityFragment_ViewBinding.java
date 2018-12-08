// Generated code from Butter Knife. Do not modify!
package com.languang.bluebox.fragment.facility;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.languang.bluebox.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FacilityFragment_ViewBinding implements Unbinder {
  private FacilityFragment target;

  private View view2131230902;

  private View view2131230832;

  private View view2131230813;

  private View view2131230939;

  private View view2131231065;

  private View view2131230947;

  @UiThread
  public FacilityFragment_ViewBinding(final FacilityFragment target, View source) {
    this.target = target;

    View view;
    target.wifiName = Utils.findRequiredViewAsType(source, R.id.wifi_name, "field 'wifiName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.my_wifi_rl, "method 'onViewClicked'");
    view2131230902 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.facility_info_ll, "method 'onViewClicked'");
    view2131230832 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.disk_manage_ll, "method 'onViewClicked'");
    view2131230813 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.pwd_manage_ll, "method 'onViewClicked'");
    view2131230939 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.visitor_pwd_ll, "method 'onViewClicked'");
    view2131231065 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.restart, "method 'onViewClicked'");
    view2131230947 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    FacilityFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.wifiName = null;

    view2131230902.setOnClickListener(null);
    view2131230902 = null;
    view2131230832.setOnClickListener(null);
    view2131230832 = null;
    view2131230813.setOnClickListener(null);
    view2131230813 = null;
    view2131230939.setOnClickListener(null);
    view2131230939 = null;
    view2131231065.setOnClickListener(null);
    view2131231065 = null;
    view2131230947.setOnClickListener(null);
    view2131230947 = null;
  }
}
