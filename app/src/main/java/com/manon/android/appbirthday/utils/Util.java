package com.manon.android.appbirthday.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.manon.android.appbirthday.adapters.BirthdayItem;
import com.manon.android.appbirthday.adapters.ListItem;
import com.manon.android.appbirthday.adapters.MonthItem;
import com.manon.android.appbirthday.models.Birthday;
import com.manon.android.appbirthday.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Util {
    private static final String PREF_USER = "user credentials";
    private static final String USER = "user";
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat FORMAT_INPUT = new SimpleDateFormat("dd/MM/yyyy");

    public static void setUser(Context context, String json) {
        context.getSharedPreferences(PREF_USER, Context.MODE_PRIVATE).edit().putString(USER, json).apply();
    }

    public static User getUser(Context context) throws JSONException, ParseException {
/*        SharedPreferences preferences = context.getSharedPreferences(Util.PREF_USER, Context.MODE_PRIVATE);
        String jsonUser = preferences.getString(Util.PREF_USER,"");
        User user = new Gson().fromJson(jsonUser,User.class);
        user.stringJson = jsonUser;
        return user;*/
        return new User(context.getSharedPreferences(PREF_USER, Context.MODE_PRIVATE).getString(USER, ""));
    }

    public static boolean isUserNameValid(String userName) {
        if(userName.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            return  true;
        }
        return false;
    }

    public static boolean isPasswordValid(String password) {
        // TODO : écrire votre règle pour un password valide
        return true;
    }

    public static Date initDateFromDB(String str) throws ParseException {
        return FORMAT.parse(str);
    }

    public static String printDate(Date date) {
        return FORMAT.format(date);
    }

    public static ArrayList<ListItem> createListItems(ArrayList<Birthday> birthdays) {

        ArrayList<ListItem> listItems = new ArrayList<>();

        int monthNumber = 0;
        String[] months = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Décembre"};
        int index = 0;
        for (String month : months) {

            MonthItem monthItem = new MonthItem(index, month);
            listItems.add(monthItem);

            for (Birthday birthday : birthdays) {

                if (birthday.date.getMonth() == index) {
                    BirthdayItem birthdayItem = new BirthdayItem(birthday);
                    listItems.add(birthdayItem);
                }
            }
            index++;
        }
        return listItems;
    }

    public static boolean isDateValid(String string) {
        try {
            FORMAT_INPUT.parse(string);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static Date initDateFromEditText(String str) throws ParseException {
        return FORMAT_INPUT.parse(str);
    }

    public static long getAge(Date date) {
        long diff = System.currentTimeMillis() - date.getTime();
        return diff / 31622400000l;
    }
}
