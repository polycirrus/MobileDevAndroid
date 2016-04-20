package by.bsuir.polyc_000.mobiledevandroid.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import by.bsuir.polyc_000.mobiledevandroid.R;
import by.bsuir.polyc_000.mobiledevandroid.models.UrlActivityModel;
import by.bsuir.polyc_000.mobiledevandroid.databinding.ActivityUrlBinding;

public class UrlActivity extends AppCompatActivity {

    private static final String MODEL_KEY = "model";
    static final String URL_KEY = "url_key";
    static final String OLD_URL_KEY = "old_url_key";
    static final String NEW_URL_KEY = "new_url_key";

    private UrlActivityModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        if (savedInstanceState != null) {
            model = savedInstanceState.getParcelable(MODEL_KEY);
        }
        else {
            model = new UrlActivityModel(getString(R.string.default_url));
        }

        ActivityUrlBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_url);
        binding.setModel(model);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(MODEL_KEY, model);
        super.onSaveInstanceState(outState);
    }

    public void onSetUrlActivityButtonClick(View view) {
        Intent intent = new Intent(this, SetUrlActivity.class);
        intent.putExtra(OLD_URL_KEY, model.getUrl());
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && data != null) {
            String newUrl = data.getStringExtra(NEW_URL_KEY);
            if (newUrl != null)
                model.setUrl(newUrl);
        }
    }

    public void onGoButtonClick(View view) {
        Intent intent = new Intent(this, WebPageActivity.class);
        intent.putExtra(URL_KEY, model.getUrl());
        startActivity(intent);
    }
}
