package by.bsuir.polyc_000.mobiledevandroid.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import by.bsuir.polyc_000.mobiledevandroid.R;
import by.bsuir.polyc_000.mobiledevandroid.models.SetUrlActivityModel;
import by.bsuir.polyc_000.mobiledevandroid.databinding.ActivitySetUrlBinding;

public class SetUrlActivity extends AppCompatActivity {

    private static final String MODEL_KEY = "model";

    private SetUrlActivityModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_url);

        if (savedInstanceState != null) {
            model = savedInstanceState.getParcelable(MODEL_KEY);
        }
        else {
            model = new SetUrlActivityModel(getIntent().getStringExtra(UrlActivity.OLD_URL_KEY));
        }

        ActivitySetUrlBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_set_url);
        binding.setModel(model);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(MODEL_KEY, model);
        super.onSaveInstanceState(outState);
    }

    public void onSetUrlButtonClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.format("%s %s ?", getString(R.string.confirmSetUrlDialog_message), model.getNewUrl()));
        builder.setPositiveButton(getString(R.string.confirmSetUrlDialog_positive), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finishActivity();
            }
        });
        builder.setNegativeButton(getString(R.string.confirmSetUrlDialog_negative), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void finishActivity() {
        Intent intent = getIntent();
        intent.putExtra(UrlActivity.NEW_URL_KEY, model.getNewUrl());

        setResult(RESULT_OK, intent);
        finish();
    }

}
