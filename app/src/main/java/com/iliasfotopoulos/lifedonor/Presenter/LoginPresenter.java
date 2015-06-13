package com.iliasfotopoulos.lifedonor.Presenter;

/**
 * Created by ilias on 13/6/2015.
 */
public interface LoginPresenter extends BasePresenter
{
    public void validateCredentials(String username, String password);
}
