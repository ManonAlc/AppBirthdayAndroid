package com.manon.android.appbirthday.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.manon.android.appbirthday.utils.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;

public class Birthday {
    @SerializedName("date")
    @Expose
    public Date date;
    @SerializedName("firstname")
    @Expose
    public String firstname;
    @SerializedName("lastname")
    @Expose
    public String lastname;

    //    {
    //            "date": "1988-02-02",
    //            "firstName": "Peter",
    //            "lastName": "Bardu"
    //        }
    public Birthday(String json) throws JSONException, ParseException {
        JSONObject jsonObject = new JSONObject(json);

        date = Util.initDateFromDB(jsonObject.getString("date"));
        firstname = jsonObject.getString("firstname");
        lastname = jsonObject.getString("lastname");
    }

    public Birthday(Date date, String firstname, String lastname) {
        this.date = date;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("date", Util.printDate(date));
            json.put("firstname", firstname);
            json.put("lastname", lastname);
        } catch (JSONException e) {
        }
        return json;
    }


    public static class CustomComparator implements Comparator<Birthday> {
        @Override
        public int compare(Birthday birthday1, Birthday birthday2) {

            if (birthday1.date.getMonth() > birthday2.date.getMonth())
                return 1;
            else if (birthday1.date.getMonth() == birthday2.date.getMonth()) {
                if (birthday1.date.getDate() > birthday2.date.getDate())
                    return 1;
                else if (birthday1.date.getDate() == birthday2.date.getDate())
                    return 0;
                else return -1;
            } else
                return -1;
        }
    }
}
