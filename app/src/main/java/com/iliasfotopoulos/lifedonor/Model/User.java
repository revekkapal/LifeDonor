package com.iliasfotopoulos.lifedonor.Model;

import com.parse.ParseUser;
import com.parse.ParseClassName;

/**
 * Created by ilias on 10/6/2015.
 */

@ParseClassName(User.CLASS_KEY)
public class User extends ParseUser
{
    public static final String CLASS_KEY = "_User";
    public static final String CITY_KEY = "city";
    public static final String STREET_KEY = "street";
    public static final String ZIP_CODE_KEY = "zipCode";
    public static final String PHONE_KEY = "phone";
    public static final String EMAIL_VERIFIED_KEY ="emailVerified";

    public User()
    {
        super();
    }

    public static User getCurrentUser()
    {
        return (User) ParseUser.getCurrentUser();
    }

    // Accessors
    public String getCity()
    {
        return getString(CITY_KEY);
    }

    public String getStreet()
    {
        return getString(STREET_KEY);
    }

    public int getZipCode()
    {
        return getInt(ZIP_CODE_KEY);
    }

    public int getPhone()
    {
        return getInt(PHONE_KEY);
    }


    // Mutators
    public void setCity(String aCity)
    {
        put(CITY_KEY,aCity);
    }

    public void setStreet(String aStreet)
    {
        put(STREET_KEY,aStreet);
    }

    public void setZipCode(int aZipCode)
    {
        put(ZIP_CODE_KEY,aZipCode);
    }

    public void setPhone(int aPhone)
    {
        put(PHONE_KEY,aPhone);
    }

    // Default ParseUser Info
    public boolean emailVerified()
    {
        return getBoolean(EMAIL_VERIFIED_KEY);
    }

}
