package by.bsuir.polyc_000.mobiledevandroid;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import by.bsuir.polyc_000.mobiledevandroid.databinding.ActivityUrlBinding;

public class UrlActivity extends AppCompatActivity {

    private UrlActivityModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        model = new UrlActivityModel(getString(R.string.default_url));

        ActivityUrlBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_url);
        binding.setModel(model);
    }

    public void onSetUrlActivityButtonClick(View view) {
        Intent intent = new Intent(this, SetUrlActivity.class);
        intent.putExtra(getString(R.string.old_url_key), model.getUrl());
        startActivityForResult(intent, -1);
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
