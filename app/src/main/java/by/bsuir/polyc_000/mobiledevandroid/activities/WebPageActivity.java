package by.bsuir.polyc_000.mobiledevandroid.activities;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import by.bsuir.polyc_000.mobiledevandroid.R;

public class WebPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        String url = getIntent().getStringExtra(UrlActivity.URL_KEY);
        if (url == null) {
            exitWithError(getString(R.string.url_not_set_message));
        }

        WebView webView = (WebView) findViewById(R.id.webView);
        if (webView != null) {
            configureWebView(url, webView);
        }
        else {
            exitWithError(getString(R.string.webView_not_found_message));
        }
    }

    private void configureWebView(String url, WebView webView) {
        final ProgressDialog loadingDialog = new ProgressDialog(this);
        loadingDialog.setTitle(getString(R.string.loadingDialog_title));

        WebViewClient client = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                loadingDialog.setMessage(String.format("%s %s", getString(R.string.loadingDialog_message), url));
                loadingDialog.show();

                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                loadingDialog.dismiss();
                showToast(String.format("%s %s", getString(R.string.finished_loading_message), url));

                super.onPageFinished(view, url);
            }
        };
        webView.setWebViewClient(client);

        if (!url.startsWith("http")) {
            url = "http://" + url;
        }

        webView.loadUrl(url);
    }

    private void exitWithError(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

        setResult(RESULT_OK);
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
