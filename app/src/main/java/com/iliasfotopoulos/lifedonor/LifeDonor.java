package com.iliasfotopoulos.lifedonor;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.SignUpCallback;

/**
 * Created by ilias on 10/6/2015.
 */
public class LifeDonor extends Application
{
    private static LifeDonor instance;

    @Override
    public void onCreate()
    {

        instance = this;

        Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);
        Parse.enableLocalDatastore(getApplicationContext());

        Parse.initialize(this, getString(R.string.parse_app_id) ,getString(R.string.parse_client_id) );
        ParseInstallation.getCurrentInstallation().saveInBackground();

    }

    public LifeDonor getInstance()
    {
        return instance;
    }

}