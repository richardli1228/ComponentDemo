package com.component.richard.componentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.component.richard.componentbase.ServiceFactory;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        ServiceFactory.getInstance().getAccountService().newUserFragment(this, R.id.fragment_content_layout, getSupportFragmentManager(), null , "");
    }
}
