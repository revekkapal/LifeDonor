package com.iliasfotopoulos.lifedonor.View;

/**
 * Created by ilias on 10/6/2015.
 */
public interface BaseView
{
    public void showProgressBar();
    public void hideProgressBar();
    public void showDialog(String message);
    public boolean isDestroyed();

}