package by.bsuir.polyc_000.mobiledevandroid;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

public class UrlActivityModel extends BaseObservable implements Parcelable {

    private String url;

    public UrlActivityModel(String defaultValue) {
        setUrl(defaultValue);
    }

    protected UrlActivityModel(Parcel in) {
        url = in.readString();
    }

    public static final Creator<UrlActivityModel> CREATOR = new Creator<UrlActivityModel>() {
        @Override
        public UrlActivityModel createFromParcel(Parcel in) {
            return new UrlActivityModel(in);
        }

        @Override
        public UrlActivityModel[] newArray(int size) {
            return new UrlActivityModel[size];
        }
    };

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (url == null)
            throw new IllegalArgumentException("Url cannot be null.");

        this.url = url;
        notifyChange();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
    }
}
