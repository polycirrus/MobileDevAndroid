package by.bsuir.polyc_000.mobiledevandroid.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import by.bsuir.polyc_000.mobiledevandroid.R;
import by.bsuir.polyc_000.mobiledevandroid.models.SharedPreferencesString;
import by.bsuir.polyc_000.mobiledevandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREF_KEY = "shared_pref_key";

    private SharedPreferencesString textViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewText = new SharedPreferencesString(this, SHARED_PREF_KEY,
                getString(R.string.text_view_default_value));

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setText(textViewText);
    }

    public void onButton1Click(View view) {
        Toast.makeText(getApplicationContext(), getString(R.string.button1_message)
                , Toast.LENGTH_SHORT).show();

        textViewText.setValue(getString(R.string.button1_text_view_value));
    }

    public void onButton2Click(View view) {
        Toast.makeText(getApplicationContext(), getString(R.string.button2_message)
                , Toast.LENGTH_SHORT).show();

        textViewText.setValue(getString(R.string.button2_text_view_value));
    }

    public void onTask2ButtonClick(View view) {
        Intent intent = new Intent(this, UrlActivity.class);
        startActivity(intent);
    }

    public void onTask4ButtonClick(View view) {
        Intent intent = new Intent(this, StudentsListActivity.class);
        startActivity(intent);
    }
}
