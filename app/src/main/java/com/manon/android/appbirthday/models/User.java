package com.manon.android.appbirthday.models;

import android.content.Context;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.manon.android.appbirthday.utils.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

public class User {

    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("birthdays")
    @Expose
    public ArrayList<Birthday> birthdays;

    public String stringJson;

/*    public User(String json) throws JSONException, ParseException {

        stringJson = json;

        JSONObject jsonObject = new JSONObject(json);
        id = jsonObject.getLong("id");
        username = jsonObject.getString("username");
        email = jsonObject.getString("email");
        birthdays = new ArrayList<>();

        JSONArray jsonArray = jsonObject.getJSONArray("birthdays");
        for (int i = 0; i < jsonArray.length(); i++) {
            birthdays.add(new Birthday(jsonObject.getJSONArray("birthdays").getJSONObject(i).toString()));
        }
    }*/

    public void addBirthday(Context context, Birthday birthday) {
        birthdays.add(birthday);

        try {

            JSONObject jsonObject = new JSONObject(stringJson);
            jsonObject.getJSONArray("birthdays").put(birthday.toJson());
            stringJson = jsonObject.toString();

            Log.d("lol", "addBirthday: " + stringJson);

            Util.setUser(context, stringJson);
        } catch (JSONException e) {

        }
    }
}
