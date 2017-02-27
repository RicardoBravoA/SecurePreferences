package com.rba.securesharedpreference.storage;

import android.content.Context;

import com.rba.securesharedpreference.BuildConfig;
import com.rba.securesharedpreference.component.SecurePreferences;

/**
 * Created by Ricardo Bravo on 27/02/17.
 */

public class SessionManager {

    private static SecurePreferences securePreferences;

    private static void initSessionManager(Context context){
        if(securePreferences == null){
            securePreferences = new SecurePreferences(context, BuildConfig.FILE, BuildConfig.KEY, true);
        }
    }

    public static void addDescription(Context context, String value) {
        initSessionManager(context);
        securePreferences.put(BuildConfig.KEY, value);
    }

    public static String getDescription(Context context) {
        initSessionManager(context);
        return securePreferences.getString(BuildConfig.KEY);
    }

}
