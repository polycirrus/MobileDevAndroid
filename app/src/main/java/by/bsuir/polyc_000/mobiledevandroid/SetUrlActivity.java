package by.bsuir.polyc_000.mobiledevandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import by.bsuir.polyc_000.mobiledevandroid.databinding.ActivitySetUrlBinding;

public class SetUrlActivity extends AppCompatActivity {

    static final String MODEL = "model";

    private SetUrlActivityModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_url);

        if (savedInstanceState != null) {
            model = savedInstanceState.getParcelable(MODEL);
        }
        else {
            model = new SetUrlActivityModel(getIntent().getStringExtra(getString(R.string.old_url_key)));
        }

        ActivitySetUrlBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_set_url);
        binding.setModel(model);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(MODEL, model);
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
        intent.putExtra(getString(R.string.new_url_key), model.getNewUrl());

        setResult(RESULT_OK, intent);
        finish();
    }

}
