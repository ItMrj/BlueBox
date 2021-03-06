// Generated code from Butter Knife. Do not modify!
package com.languang.bluebox.fragment.mapstorage;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.GridView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.languang.bluebox.R;
import com.languang.bluebox.coustomview.CustomEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PictureTagFragment_ViewBinding implements Unbinder {
  private PictureTagFragment target;

  @UiThread
  public PictureTagFragment_ViewBinding(PictureTagFragment target, View source) {
    this.target = target;

    target.searchEt = Utils.findRequiredViewAsType(source, R.id.search_et, "field 'searchEt'", CustomEditText.class);
    target.tagGrid = Utils.findRequiredViewAsType(source, R.id.tag_grid, "field 'tagGrid'", GridView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PictureTagFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.searchEt = null;
    target.tagGrid = null;
  }
}
