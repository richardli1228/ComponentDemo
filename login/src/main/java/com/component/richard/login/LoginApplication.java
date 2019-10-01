package com.component.richard.login;

import android.app.Application;

import com.component.richard.base.BaseAppApplication;
import com.component.richard.componentbase.ServiceFactory;

public class LoginApplication extends BaseAppApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        initModuleData(this);
    }

    @Override
    public void initModuleApp(Application application) {
        ServiceFactory.getInstance().setAccountService(new AccountService());
    }

    @Override
    public void initModuleData(Application application) {

    }
}
