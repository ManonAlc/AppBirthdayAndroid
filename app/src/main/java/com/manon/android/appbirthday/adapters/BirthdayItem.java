package com.manon.android.appbirthday.adapters;

import com.manon.android.appbirthday.models.Birthday;
public class BirthdayItem extends ListItem {

    public Birthday birthday;

    public BirthdayItem(Birthday birthday) {
        this.birthday = birthday;
    }

    @Override
    public int getType() {
        return TYPE_BIRTHDAY;
    }
}
