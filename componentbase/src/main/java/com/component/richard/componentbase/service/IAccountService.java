package com.component.richard.componentbase.service;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public interface IAccountService {

    /**
     * 是否已经登录
     * @return
     */
    boolean isLogin();

    /**
     * 获取登录用户的id
     * @return
     */
    String getUserName();

    Fragment newUserFragment(Activity activity, int containerId, FragmentManager manager, Bundle bundle, String tag);

}
