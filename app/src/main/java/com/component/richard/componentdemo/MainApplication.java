package com.component.richard.componentdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.component.richard.base.AppConfig;
import com.component.richard.base.BaseAppApplication;

/**
 * 主Module的Application
 */
public class MainApplication extends BaseAppApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化ARouter
        if (isDebug()){
            ARouter.openLog();
            ARouter.openDebug();
        }

        ARouter.init(this);

        //初始化组件 Application
        initModuleApp(this);
        initModuleData(this);
    }

    private boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public void initModuleApp(Application application) {
        //通过反射来解决
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                BaseAppApplication baseApp = (BaseAppApplication) clazz.newInstance();
                baseApp.initModuleApp(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initModuleData(Application application) {
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                BaseAppApplication baseApp = (BaseAppApplication) clazz.newInstance();
                baseApp.initModuleData(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
