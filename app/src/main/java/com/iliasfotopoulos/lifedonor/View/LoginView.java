package com.iliasfotopoulos.lifedonor.View;

/**
 * Created by ilias on 13/6/2015.
 */
public interface LoginView extends BaseView
{
    public void navigateToHome();

    public void setUsernameFocus();
    public void setPasswordFocus();

    public void setUsernameError(String anError);
    public void setPasswordError(String anError);
}
