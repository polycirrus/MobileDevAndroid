package by.bsuir.polyc_000.mobiledevandroid.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.bsuir.polyc_000.mobiledevandroid.R;
import by.bsuir.polyc_000.mobiledevandroid.databinding.StudentsListItemBinding;

public class StudentsListActivity extends AppCompatActivity {

    private List<String> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);

        values = Arrays.asList(
                "Алькевич Александр Святославович",
                "Андреевская Полина Эдуардовна",
                "Величко Антонина Дмитриевна",
                "Владимирова Наталья Геннадьевна",
                "Горбачев Максим Сергеевич",
                "Грачев Ян Юрьевич",
                "Гриновский Роман Дмитриевич",
                "Гурин Дмитрий Николаевич",
                "Дадацкий Иван Васильевич",
                "Жилевич Максим Сергеевич",
                "Житницкий Александр Владимирович",
                "Казак Виктор Васильевич"
        );

        ListView listView = (ListView) findViewById(R.id.studentsListView);
        listView.setAdapter(new StudentsListAdapter(this, -1, values));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowMessage(values.get(position));
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ShowMessage(getString(R.string.scholarship_message));
                return true;
            }
        });
    }

    private void ShowMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

class StudentsListAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> values;

    public StudentsListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        values = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        StudentsListItemBinding binding = StudentsListItemBinding.inflate(inflater,
                parent, false);
        binding.setStudentName(values.get(position));

        if (position == 10)
        {
            TextView textView = (TextView) binding.getRoot().findViewById(R.id.studentNameTextView);
            textView.setTextColor(Color.BLUE);
        }

        return binding.getRoot();
    }

}