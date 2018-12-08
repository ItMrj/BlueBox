// Generated code from Butter Knife. Do not modify!
package com.languang.bluebox.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.languang.bluebox.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LightDiskFragment_ViewBinding implements Unbinder {
  private LightDiskFragment target;

  private View view2131231008;

  @UiThread
  public LightDiskFragment_ViewBinding(final LightDiskFragment target, View source) {
    this.target = target;

    View view;
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    target.progressPosition = Utils.findRequiredViewAsType(source, R.id.progress_position, "field 'progressPosition'", TextView.class);
    view = Utils.findRequiredView(source, R.id.start_archive, "method 'onViewClicked'");
    view2131231008 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LightDiskFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.progressBar = null;
    target.progressPosition = null;

    view2131231008.setOnClickListener(null);
    view2131231008 = null;
  }
}
