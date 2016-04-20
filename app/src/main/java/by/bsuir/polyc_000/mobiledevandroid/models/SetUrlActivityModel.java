package by.bsuir.polyc_000.mobiledevandroid.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;

public class SetUrlActivityModel extends BaseObservable implements Parcelable {

    private String newUrl;
    private String oldUrl;

    public SetUrlActivityModel(String oldUrl) {
        setNewUrl(oldUrl);
        setOldUrl(oldUrl);
    }

    public SetUrlActivityModel(Parcel in) {
        newUrl = in.readString();
        oldUrl = in.readString();
    }

    public static final Creator<SetUrlActivityModel> CREATOR = new Creator<SetUrlActivityModel>() {
        @Override
        public SetUrlActivityModel createFromParcel(Parcel in) {
            return new SetUrlActivityModel(in);
        }

        @Override
        public SetUrlActivityModel[] newArray(int size) {
            return new SetUrlActivityModel[size];
        }
    };

    @Bindable
    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        if (newUrl == null)
            throw new IllegalArgumentException("Url cannot be null.");

        this.newUrl = newUrl;
        notifyChange();
    }

    @Bindable
    public String getOldUrl() {
        return oldUrl;
    }

    public void setOldUrl(String oldUrl) {
        if (oldUrl == null)
            throw new IllegalArgumentException("Url cannot be null.");

        this.oldUrl = oldUrl;
        notifyChange();
    }

    public TextWatcher newUrlEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            setNewUrl(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(newUrl);
        dest.writeString(oldUrl);
    }

}
