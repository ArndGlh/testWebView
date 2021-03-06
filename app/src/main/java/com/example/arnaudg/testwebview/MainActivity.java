package com.example.arnaudg.testwebview;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    /* Création de la variable membre mWebView */
    private WebView mWebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);

        // Configure la webview pour l'utilisation du javascript
        WebSettings webSettings = mWebView.getSettings();
        WebSettings.setJavaScriptEnabled(true);

        // Permet l'ouverture des fenêtres
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // Autorise le stockage DOM (Document Object Model)
        webSettings.setDomStorageEnabled(true);

        // Charge l'url
        mWebView.loadUrl("https://blog.thibautlombard.space");

                /*
		 * Les instructions ci-dessous permettent de forcer l'application
		 * à ouvrir les Url directement dans l'application et non dans
		 * un navigateur externe. MyAppWebViewClient() est la fonction
		 * contenue dans le fichier MyAppWebViewClient.java .
		 */

        mWebView.setWebViewClient(new MyAppWebViewClient() {
            @Override
            // Fonction qui permet l'affichage de la page lorsque tout est chargé (événement onPageFinished)

            public void onPageFinished(WebView view, String url) {
                findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
            }
        });
    }

    /*
     * Fonction qui permet de revenir à la page précédente
     * au lieu de quitter l'application lorsque le bouton
     * revenir en arrière est appuyé.
     */
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onStart() {
        super.onStart();

    }


}