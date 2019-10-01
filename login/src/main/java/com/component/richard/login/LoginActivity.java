package com.component.richard.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/account/login")
public class LoginActivity extends AppCompatActivity {

    TextView loginTv;
    Button shareBtn, loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginTv = findViewById(R.id.login_tv);
        loginBtn = findViewById(R.id.login_btn);
        shareBtn = findViewById(R.id.share_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
    }

    public void login(){
        AccountUtils.userInfo = new UserInfo("10086", "Admin");
        updateLoginState();
    }

    private void updateLoginState() {
        loginTv.setText("这里是登录界面：" + (AccountUtils.userInfo == null ? "未登录" : AccountUtils.userInfo.getUserName()));
    }

    public void exit() {
        AccountUtils.userInfo = null;
        updateLoginState();
    }

    public void share() {
        ARouter.getInstance().build("/share/share").withString("share_content", "分享数据到微博").navigation(this);
    }
}
