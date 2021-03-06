// Generated code from Butter Knife. Do not modify!
package com.languang.bluebox.activity.login;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.languang.bluebox.R;
import com.languang.bluebox.basework.base.BaseFragmentActivity_ViewBinding;
import com.luck.easyrecyclerview.EasyRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FacilityListActivity_ViewBinding extends BaseFragmentActivity_ViewBinding {
  private FacilityListActivity target;

  private View view2131230915;

  private View view2131230914;

  private View view2131230875;

  private View view2131231049;

  @UiThread
  public FacilityListActivity_ViewBinding(FacilityListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FacilityListActivity_ViewBinding(final FacilityListActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.online, "field 'online' and method 'onViewClicked'");
    target.online = Utils.castView(view, R.id.online, "field 'online'", TextView.class);
    view2131230915 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.offline, "field 'offline' and method 'onViewClicked'");
    target.offline = Utils.castView(view, R.id.offline, "field 'offline'", TextView.class);
    view2131230914 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", EasyRecyclerView.class);
    view = Utils.findRequiredView(source, R.id.iv_refresh, "method 'onViewClicked'");
    view2131230875 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_new, "method 'onViewClicked'");
    view2131231049 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  public void unbind() {
    FacilityListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.online = null;
    target.offline = null;
    target.recyclerView = null;

    view2131230915.setOnClickListener(null);
    view2131230915 = null;
    view2131230914.setOnClickListener(null);
    view2131230914 = null;
    view2131230875.setOnClickListener(null);
    view2131230875 = null;
    view2131231049.setOnClickListener(null);
    view2131231049 = null;

    super.unbind();
  }
}
