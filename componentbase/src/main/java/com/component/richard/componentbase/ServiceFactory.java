package com.component.richard.componentbase;

import com.component.richard.componentbase.empty_service.EmptyAccountService;
import com.component.richard.componentbase.service.IAccountService;

public class ServiceFactory {

    private IAccountService accountService;

    private ServiceFactory() {
    }

    private static class Inner {
        private static ServiceFactory f = new ServiceFactory();
    }

    public static ServiceFactory getInstance() {
        return Inner.f;
    }

    public void setAccountService(IAccountService service){
        this.accountService = service;
    }

    public IAccountService getAccountService(){
        if (accountService == null){
            accountService = new EmptyAccountService();
        }
        return accountService;
    }

}
