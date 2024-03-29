package com.iliasfotopoulos.lifedonor.Presenter.Implementation;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import com.iliasfotopoulos.lifedonor.LifeDonor;
import com.iliasfotopoulos.lifedonor.Presenter.LoginPresenter;
import com.iliasfotopoulos.lifedonor.R;
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
    boolean cancel = false; // Do you really need that? TEST IT

    public LoginPresenterImpl(LoginView loginView)
    {
        this.view = loginView;

    }

    public void authenticateUser(final String username, String password)
    {
        view.showProgressBar();
        cancel = false;

        if (TextUtils.isEmpty(password))
        {
            onPasswordError( LifeDonor.getContext().getResources().getString(R.string.error_blank_password) );
        }
        else if (!isPasswordValid(password))
        {
            onPasswordError( LifeDonor.getContext().getResources().getString(R.string.error_short_password) );
        }

        if (TextUtils.isEmpty(username))
        {
            onUsernameError(LifeDonor.getContext().getResources().getString(R.string.error_blank_email));
        }
        else if (!isEmailValid(username))
        {
           onUsernameError(LifeDonor.getContext().getResources().getString(R.string.error_invalid_email));
        }

        if(!cancel)
        {
            // I could have used my User class that extends ParseUser to be decoupled from Parse
            ParseUser.logInInBackground(username, password, new LogInCallback() {
                public void done(ParseUser user, ParseException e) {
                    if (view.isDestroyed()) {
                        Log.d(TAG, "View has been destroyed!");
                        return;
                    }

                    view.hideProgressBar();
                    if (user != null) {
                        Log.d(TAG, "User: " + username + " logged in!");
                        onSuccess();
                    } else {
                        if (e != null && e.getMessage() != null) {
                            Log.d(TAG, "Login failed: " + e.toString());
                            view.showDialog(e.getMessage());
                        }
                    }
                }
            });

        }


    }


    public void onUsernameError(String anError)
    {
        view.setUsernameError(anError);
        view.setUsernameFocus();
        view.hideProgressBar();
        cancel = true;
    }

    public void onPasswordError(String anError)
    {
        view.setPasswordError(anError);
        view.setPasswordFocus();
        view.hideProgressBar();
        cancel = true;
    }

    public void onSuccess()
    {
        view.navigateToHome();
    }

    private boolean isEmailValid(String email)
    {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordValid(String password)
    {
        return password.length() > 6;
    }


}
