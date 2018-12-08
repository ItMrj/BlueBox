// Generated code from Butter Knife. Do not modify!
package com.languang.bluebox.activity.login;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.languang.bluebox.R;
import com.languang.bluebox.basework.base.BaseFragmentActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding extends BaseFragmentActivity_ViewBinding {
  private LoginActivity target;

  private View view2131230840;

  private View view2131230891;

  private View view2131231039;

  private View view2131230995;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.userPhoneEt = Utils.findRequiredViewAsType(source, R.id.user_phone_et, "field 'userPhoneEt'", EditText.class);
    target.pwdEt = Utils.findRequiredViewAsType(source, R.id.pwd_et, "field 'pwdEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.find_pwd, "method 'onViewClicked'");
    view2131230840 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.login_submit, "method 'onViewClicked'");
    view2131230891 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.to_register, "method 'onViewClicked'");
    view2131231039 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sms_login, "method 'onViewClicked'");
    view2131230995 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.userPhoneEt = null;
    target.pwdEt = null;

    view2131230840.setOnClickListener(null);
    view2131230840 = null;
    view2131230891.setOnClickListener(null);
    view2131230891 = null;
    view2131231039.setOnClickListener(null);
    view2131231039 = null;
    view2131230995.setOnClickListener(null);
    view2131230995 = null;

    super.unbind();
  }
}
