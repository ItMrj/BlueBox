// Generated code from Butter Knife. Do not modify!
package com.languang.bluebox.activity.picturestorege;

import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.languang.bluebox.R;
import com.languang.bluebox.basework.base.BaseFragmentActivity_ViewBinding;
import com.languang.bluebox.coustomview.HorizontalListView;
import com.languang.bluebox.coustomview.MyScrollView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShareActivity_ViewBinding extends BaseFragmentActivity_ViewBinding {
  private ShareActivity target;

  private View view2131230988;

  private View view2131230749;

  private View view2131231000;

  private View view2131230930;

  @UiThread
  public ShareActivity_ViewBinding(ShareActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShareActivity_ViewBinding(final ShareActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", ViewPager.class);
    target.date = Utils.findRequiredViewAsType(source, R.id.date, "field 'date'", TextView.class);
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", HorizontalListView.class);
    target.pictureState = Utils.findRequiredViewAsType(source, R.id.picture_state, "field 'pictureState'", TextView.class);
    target.lyView = Utils.findRequiredViewAsType(source, R.id.ly_1, "field 'lyView'", LinearLayout.class);
    target.listview = Utils.findRequiredViewAsType(source, R.id.listview, "field 'listview'", ListView.class);
    target.rl1 = Utils.findRequiredViewAsType(source, R.id.rl_1, "field 'rl1'", RelativeLayout.class);
    target.sv = Utils.findRequiredViewAsType(source, R.id.sv_1, "field 'sv'", MyScrollView.class);
    view = Utils.findRequiredView(source, R.id.share, "method 'onViewClicked'");
    view2131230988 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.add_export, "method 'onViewClicked'");
    view2131230749 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.speak, "method 'onViewClicked'");
    view2131231000 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.privacy, "method 'onViewClicked'");
    view2131230930 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  public void unbind() {
    ShareActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
    target.date = null;
    target.listView = null;
    target.pictureState = null;
    target.lyView = null;
    target.listview = null;
    target.rl1 = null;
    target.sv = null;

    view2131230988.setOnClickListener(null);
    view2131230988 = null;
    view2131230749.setOnClickListener(null);
    view2131230749 = null;
    view2131231000.setOnClickListener(null);
    view2131231000 = null;
    view2131230930.setOnClickListener(null);
    view2131230930 = null;

    super.unbind();
  }
}
