package by.bsuir.polyc_000.mobiledevandroid;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import by.bsuir.polyc_000.mobiledevandroid.databinding.ActivityUrlBinding;

public class UrlActivity extends AppCompatActivity {

    static final String MODEL = "model";

    private UrlActivityModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        if (savedInstanceState != null) {
            model = savedInstanceState.getParcelable(MODEL);
        }
        else {
            model = new UrlActivityModel(getString(R.string.default_url));
        }

        ActivityUrlBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_url);
        binding.setModel(model);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(MODEL, model);
        super.onSaveInstanceState(outState);
    }

    public void onSetUrlActivityButtonClick(View view) {
        Intent intent = new Intent(this, SetUrlActivity.class);
        intent.putExtra(getString(R.string.old_url_key), model.getUrl());
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String newUrl = data.getStringExtra(getString(R.string.new_url_key));
            if (newUrl != null)
                model.setUrl(newUrl);
        }
    }

}
