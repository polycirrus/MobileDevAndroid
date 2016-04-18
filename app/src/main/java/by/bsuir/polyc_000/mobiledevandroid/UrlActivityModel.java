package by.bsuir.polyc_000.mobiledevandroid;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class UrlActivityModel extends BaseObservable {
    private String url;

    public UrlActivityModel(String defaultValue) {
        setUrl(defaultValue);
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    @Bindable
    public void setUrl(String url) {
        if (url == null)
            throw new IllegalArgumentException("Url cannot be null.");

        this.url = url;
    }
}
