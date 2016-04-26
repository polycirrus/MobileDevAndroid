package by.bsuir.polyc_000.mobiledevandroid.common;

import java.util.Collection;

public interface ITaskEventHandler<TProgress, TResult> {

    void onCancelled();

    void onProgressUpdate(TProgress... values);

    void onPostExecute(TResult strings);

    void onPreExecute();

}
