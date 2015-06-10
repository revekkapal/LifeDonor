package com.iliasfotopoulos.lifedonor.Model;

import java.util.Date;

/**
 * Created by ilias on 10/6/2015.
 */
public class Donor extends User
{
//    public static final String ROLE_KEY = "role";
    public static final String FIRST_NAME_KEY = "firstName";
    public static final String LAST_NAME_KEY = "lastName";
    public static final String BLOOD_TYPE_KEY = "bloodType";
    public static final String RHESUS_KEY = "rhesus";
    public static final String BIRTHDAY_KEY = "birthday";
    public static final String SEX_KEY ="sex";

    public Donor()
    {
        super();
    }

    // Accessors
    public String getFirstName()
    {
        return getString(FIRST_NAME_KEY);
    }

    public String getLastName()
    {
        return getString(LAST_NAME_KEY);
    }

    public String getBloodType()
    {
        return getString(BLOOD_TYPE_KEY);
    }

    public String getRhesus()
    {
        return getString(RHESUS_KEY);
    }

    public Date getBirthday()
    {
        return getDate(BIRTHDAY_KEY);
    }

    public String getSex()
    {
        return getString(SEX_KEY);
    }

    // Mutators
    public void setFirstName(String aFirstName)
    {
        put(FIRST_NAME_KEY,aFirstName);
    }

    public void setLastName(String aLastName)
    {
        put(LAST_NAME_KEY,aLastName);
    }

    public void setBloodType(String aBloodType)
    {
        put(BLOOD_TYPE_KEY,aBloodType);
    }

    public void setRhesus(String aRhesus)
    {
        put(RHESUS_KEY,aRhesus);
    }

    public void setBirthday(Date aBirthday)
    {
        put(BIRTHDAY_KEY,aBirthday);
    }

    public void setSex(String aSex)
    {
        put(SEX_KEY,aSex);
    }

}
