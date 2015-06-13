package com.iliasfotopoulos.lifedonor.Presenter.Implementation;

import android.app.Activity;

import com.iliasfotopoulos.lifedonor.Presenter.LoginPresenter;
import com.iliasfotopoulos.lifedonor.View.LoginView;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by ilias on 13/6/2015.
 */
public class LoginPresenterImpl implements LoginPresenter
{
    private LoginView view;

    public LoginPresenterImpl(LoginView loginView)
    {
        this.view = loginView;
    }

    public void validateCredentials(String username, String password)
    {
        view.showProgressBar();
        // I could have used my User class that extends ParseUser to be decoupled from Parse
        ParseUser.logInInBackground(username, password, new LogInCallback()
        {
            public void done(ParseUser user, ParseException e)
            {
                if (user != null)
                {
                    // Hooray! The user is logged in.
                }
                else
                {
                    // Signup failed. Look at the ParseException to see what happened.
                }
            }
        });
    }

    public void onSuccess()
    {
        view.navigateToHome();
    }
}
