// Generated code from Butter Knife. Do not modify!
package com.languang.bluebox.activity.picturestorege;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.languang.bluebox.R;
import com.languang.bluebox.basework.base.BaseFragmentActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CompilePictureActivity_ViewBinding extends BaseFragmentActivity_ViewBinding {
  private CompilePictureActivity target;

  private View view2131230776;

  private View view2131231023;

  private View view2131230839;

  private View view2131230794;

  private View view2131231066;

  private View view2131230790;

  @UiThread
  public CompilePictureActivity_ViewBinding(CompilePictureActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CompilePictureActivity_ViewBinding(final CompilePictureActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.imageView = Utils.findRequiredViewAsType(source, R.id.image_view, "field 'imageView'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.cancel, "field 'cancel' and method 'onViewClicked'");
    target.cancel = Utils.castView(view, R.id.cancel, "field 'cancel'", TextView.class);
    view2131230776 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tailor, "field 'tailor' and method 'onViewClicked'");
    target.tailor = Utils.castView(view, R.id.tailor, "field 'tailor'", ImageView.class);
    view2131231023 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.filter, "field 'filter' and method 'onViewClicked'");
    target.filter = Utils.castView(view, R.id.filter, "field 'filter'", ImageView.class);
    view2131230839 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.contrast, "field 'contrast' and method 'onViewClicked'");
    target.contrast = Utils.castView(view, R.id.contrast, "field 'contrast'", ImageView.class);
    view2131230794 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.watermark, "field 'watermark' and method 'onViewClicked'");
    target.watermark = Utils.castView(view, R.id.watermark, "field 'watermark'", ImageView.class);
    view2131231066 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.complete, "field 'complete' and method 'onViewClicked'");
    target.complete = Utils.castView(view, R.id.complete, "field 'complete'", TextView.class);
    view2131230790 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  public void unbind() {
    CompilePictureActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageView = null;
    target.cancel = null;
    target.tailor = null;
    target.filter = null;
    target.contrast = null;
    target.watermark = null;
    target.complete = null;

    view2131230776.setOnClickListener(null);
    view2131230776 = null;
    view2131231023.setOnClickListener(null);
    view2131231023 = null;
    view2131230839.setOnClickListener(null);
    view2131230839 = null;
    view2131230794.setOnClickListener(null);
    view2131230794 = null;
    view2131231066.setOnClickListener(null);
    view2131231066 = null;
    view2131230790.setOnClickListener(null);
    view2131230790 = null;

    super.unbind();
  }
}
