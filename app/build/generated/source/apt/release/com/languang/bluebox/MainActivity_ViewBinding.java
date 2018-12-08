// Generated code from Butter Knife. Do not modify!
package com.languang.bluebox;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.languang.bluebox.basework.base.BaseFragmentActivity_ViewBinding;
import com.languang.bluebox.coustomview.tabview.TabContainerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding extends BaseFragmentActivity_ViewBinding {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    super(target, source);

    this.target = target;

    target.tabContainer = Utils.findRequiredViewAsType(source, R.id.tab_container, "field 'tabContainer'", TabContainerView.class);
    target.bottomTv = Utils.findRequiredViewAsType(source, R.id.bottom_tv, "field 'bottomTv'", TextView.class);
  }

  @Override
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tabContainer = null;
    target.bottomTv = null;

    super.unbind();
  }
}
