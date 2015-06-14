package com.iliasfotopoulos.lifedonor;

import android.app.Application;
import android.content.Context;

import com.iliasfotopoulos.lifedonor.Model.Donor;
import com.iliasfotopoulos.lifedonor.Model.User;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.SignUpCallback;

/**
 * Created by ilias on 10/6/2015.
 */
public class LifeDonor extends Application
{
    private static LifeDonor instance;
    private static Context mContext;

    @Override
    public void onCreate()
    {
        mContext = this;
        instance = this;

        //Parse Subclasses Register
        ParseObject.registerSubclass(User.class);
        ParseObject.registerSubclass(Donor.class);


        Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);
        Parse.enableLocalDatastore(getApplicationContext());

        Parse.initialize(this, getString(R.string.parse_app_id) ,getString(R.string.parse_client_id) );
        ParseInstallation.getCurrentInstallation().saveInBackground();

    }

    public LifeDonor getInstance()
    {
        return instance;
    }

    public static Context getContext()
    {
        return mContext;
    }

}