package co.edu.javeriana.com.fibonacci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class biografiaFibo extends AppCompatActivity {

    WebView bioFibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biografia_fibo);

        bioFibo = findViewById(R.id.bioFibo);

        bioFibo.setWebViewClient(new MyBroswer());
        String url = "https://es.wikipedia.org/wiki/Leonardo_de_Pisa";
        bioFibo.getSettings().setLoadsImagesAutomatically(true);
        bioFibo.getSettings().setJavaScriptEnabled(true);
        bioFibo.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        bioFibo.loadUrl(url);
    }

    //now lets override default browser  to open browser inside app

    private class MyBroswer extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}
