package com.component.richard.share;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.component.richard.componentbase.ServiceFactory;

@Route(path = "/share/share")
public class ShareActivity extends AppCompatActivity {

    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        if (getIntent() != null) {
            String content = getIntent().getStringExtra("share_content");
            if (!TextUtils.isEmpty(content)) {
                ((TextView) findViewById(R.id.share_tv)).setText(content);
            }
        }

        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareLogin();
            }
        });

        share();
    }

    private void share() {
        if (ServiceFactory.getInstance().getAccountService().isLogin()) {
            Toast.makeText(this, "分享成功！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "分享失败！用户没有登录！", Toast.LENGTH_SHORT).show();
        }
    }

    public void shareLogin() {
        ARouter.getInstance().build("/account/login").navigation();
    }
}
