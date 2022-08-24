package com.manon.android.appbirthday.utils;

import android.content.Context;

import com.manon.android.appbirthday.models.User;

import org.json.JSONException;

import java.text.ParseException;
import java.util.Date;

public class Util {
    private static final String PREF_FILE = "pref_file";
    private static final String USER = "user";

    public static void setUser(Context context, String json) {

        // TODO : sauvegarder
    }

    public static User getUser(Context context) throws JSONException, ParseException {
        // TODO : restaurer
        return null;
    }

    public static boolean isUserNameValid(String userName) {
        // TODO : écrire votre règle pour un username valide
        return false;
    }

    public static boolean isPasswordValid(String password) {
        // TODO : écrire votre règle pour un password valide
        return false;
    }

    public static Date initDateFromDB(String date) {
        //TODO
        return null;
    }

    public static boolean printDate(Date date) {
        //TODO
        return false;
    }
}
