package com.manon.android.appbirthday.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.manon.android.appbirthday.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Util {
    private static final String PREF_USER = "user credentials";
    private static final String USER = "user";

    public static void setUser(Context context, String json) {
        SharedPreferences preferences = context.getSharedPreferences(Util.PREF_USER,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Util.USER, json);
        editor.apply();
    }

    public static User getUser(Context context) throws JSONException, ParseException {

        SharedPreferences preferences = context.getSharedPreferences(Util.PREF_USER, Context.MODE_PRIVATE);
        String jsonUser = preferences.getString(Util.PREF_USER,"");
        User user = new Gson().fromJson(jsonUser,User.class);
        user.stringJson = jsonUser;

        return user;
    }

    public static boolean isUserNameValid(String userName) {
        // TODO : écrire votre règle pour un username valide
        return true;
    }

    public static boolean isPasswordValid(String password) {
        // TODO : écrire votre règle pour un password valide
        return true;
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
