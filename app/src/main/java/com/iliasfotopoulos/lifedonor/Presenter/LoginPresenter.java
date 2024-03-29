package com.iliasfotopoulos.lifedonor.Presenter;

/**
 * Created by ilias on 13/6/2015.
 */
public interface LoginPresenter extends BasePresenter
{
    public void authenticateUser(String username, String password);

    public void onUsernameError(String anError);
    public void onPasswordError(String anError);
}
