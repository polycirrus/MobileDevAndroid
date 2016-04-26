package by.bsuir.polyc_000.mobiledevandroid.services;

import android.os.AsyncTask;

import java.util.Collection;

import by.bsuir.polyc_000.mobiledevandroid.common.ITaskEventHandler;

public abstract class AsyncTaskWithHandler<TParams, TProgress, TResult> extends AsyncTask<TParams, TProgress, TResult> {

    protected ITaskEventHandler<TProgress, TResult> taskEventHandler;
    protected boolean isCancelled;

    protected AsyncTaskWithHandler(ITaskEventHandler<TProgress, TResult> taskEventHandler) {
        isCancelled = false;
        setTaskEventHandler(taskEventHandler);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        isCancelled = true;
    }

    @Override
    protected void onProgressUpdate(TProgress... values) {
        super.onProgressUpdate(values);
        if (taskEventHandler != null) {
            taskEventHandler.onProgressUpdate(values);
        }
    }

    @Override
    protected void onPostExecute(TResult value) {
        super.onPostExecute(value);
        if (taskEventHandler != null) {
            taskEventHandler.onPostExecute(value);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (taskEventHandler != null) {
            taskEventHandler.onPreExecute();
        }
    }

    public ITaskEventHandler<TProgress, TResult> getTaskEventHandler() {
        return taskEventHandler;
    }

    public void setTaskEventHandler(ITaskEventHandler<TProgress, TResult> taskEventHandler) {
        this.taskEventHandler = taskEventHandler;
    }

    public boolean getCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
