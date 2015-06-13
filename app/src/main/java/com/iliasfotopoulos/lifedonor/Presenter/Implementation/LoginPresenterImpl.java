package com.iliasfotopoulos.lifedonor.Presenter.Implementation;

import android.app.Activity;

import com.iliasfotopoulos.lifedonor.Presenter.LoginPresenter;
import com.iliasfotopoulos.lifedonor.View.LoginView;

/**
 * Created by ilias on 13/6/2015.
 */
public class LoginPresenterImpl implements LoginPresenter
{
    private LoginView view;

    public void setView(LoginView loginview)
    {
        this.view = loginview;
    }

    public void validateCredentials(String username, String password)
    {

    }
}
