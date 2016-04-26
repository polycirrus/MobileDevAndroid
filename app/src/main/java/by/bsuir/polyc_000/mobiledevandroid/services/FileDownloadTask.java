package by.bsuir.polyc_000.mobiledevandroid.services;

import android.os.AsyncTask;

import by.bsuir.polyc_000.mobiledevandroid.common.ITaskEventHandler;

public class FileDownloadTask extends AsyncTaskWithHandler<String, Integer, byte[]> {

    public FileDownloadTask() {
        this(null);
    }

    public FileDownloadTask(ITaskEventHandler<Integer, byte[]> eventHandler) {
        super(eventHandler);
    }

    @Override
    protected byte[] doInBackground(String... params) {
        if (params.length != 1) {
            throw new UnsupportedOperationException("This class only supports single-file downloads.");
        }


    }
}
