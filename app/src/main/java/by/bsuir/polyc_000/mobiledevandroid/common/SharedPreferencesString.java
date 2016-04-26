package by.bsuir.polyc_000.mobiledevandroid.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class SharedPreferencesString extends BaseObservable {
    private final String key;
    private final String defValue;
    private final Activity activity;

    public SharedPreferencesString(Activity activity, String key, String defValue) {
        this.key = key;
        this.activity = activity;
        this.defValue = defValue;
    }

    @Bindable
    public String getValue() {
        SharedPreferences sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defValue);
    }

    public void setValue(String value) {
        SharedPreferences sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();

        notifyChange();
    }
}
