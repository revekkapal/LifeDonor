package com.iliasfotopoulos.lifedonor.Presenter.Implementation;

import android.app.Activity;
import android.util.Log;

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
    private static final String TAG = "LoginPresenter";
    private LoginView view;

    public LoginPresenterImpl(LoginView loginView)
    {
        this.view = loginView;
    }

    public void authenticateUser(final String username, String password)
    {
        view.showProgressBar();
        // I could have used my User class that extends ParseUser to be decoupled from Parse
        ParseUser.logInInBackground(username, password, new LogInCallback()
        {
            public void done(ParseUser user, ParseException e)
            {
                if (view.isDestroyed())
                {
                    Log.d(TAG,"View has been destroyed!");
                    return;
                }

                view.hideProgressBar();
                if (user != null)
                {
                    Log.d(TAG,"User: "+username+" logged in!");
                    onSuccess();
                }
                else
                {
                    if (e !=null && e.getMessage() != null)
                    {
                        Log.d(TAG,"Login failed: "+ e.toString());
                        view.showDialog(e.getMessage());
                    }
                }
            }
        });
    }
    public void onSuccess()
    {
        view.navigateToHome();
    }
}
