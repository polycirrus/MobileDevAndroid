package by.bsuir.polyc_000.mobiledevandroid.services;

import android.os.AsyncTask;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Collection;

import by.bsuir.polyc_000.mobiledevandroid.common.ITaskEventHandler;

public class StudentGroupListTask extends AsyncTaskWithHandler<String, Integer, Collection<String>> {

    public StudentGroupListTask() {
        this(null);
    }

    public StudentGroupListTask(ITaskEventHandler<Integer, Collection<String>> taskEventHandler) {
        super(taskEventHandler);
    }

    @Override
    protected Collection<String> doInBackground(String... params) {
        throw new UnsupportedOperationException();
    }

}
