package com.iliasfotopoulos.lifedonor.Avitivity;

/**
 * Created by ilias on 10/6/2015.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.iliasfotopoulos.lifedonor.R;
import com.iliasfotopoulos.lifedonor.View.BaseView;

public class BaseActivity extends Activity implements BaseView
{

    private static final String TAG = "BaseActivity";
    private ProgressDialog progressDialog;


    @Override
    public void showProgressBar()
    {
        try
        {
            if (progressDialog == null || !progressDialog.isShowing() && !isFinishing()) {
                progressDialog = new ProgressDialog(this);
                progressDialog.setMessage(getString(R.string.loading_message));
                progressDialog.setIndeterminate(true);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setCancelable(true); // τεσταρετω μήπως θέλει false
                progressDialog.show();
            }
        }
        catch(Exception ex)
        {
            Log.e(TAG,"Error start Progress dialog:  " + ex);
        }

    }

    @Override
    public void hideProgressBar()
    {
        try
        {
            if (progressDialog != null && progressDialog.isShowing() && !isFinishing())
            {
                progressDialog.dismiss();
            }
        }
        catch(Exception ex)
        {
            Log.e(TAG,"Error stopping Progress dialog:  " + ex);
        }

    }

    @Override
    public void showDialog(String message)
    {
        try
        {
            if (!isFinishing()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.app_name);
                builder.setMessage(message);
                builder.setNeutralButton(android.R.string.ok, null);
                builder.show();
            }
        }
        catch(Exception ex)
        {
            Log.e(TAG,"Error starting Alert dialog with message:  " + message +". Exception: " + ex);
        }
    }

}