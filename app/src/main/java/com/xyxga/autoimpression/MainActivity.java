
package com.xyxga.autoimpression;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.xyxga.autoimpression.data.FetchGeoIp;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newButton = (Button)findViewById(R.id.Getlok);
        Button newButton2 = (Button)findViewById(R.id.ClearCache);
        newButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WebView web = (WebView) findViewById(R.id.web_view);
                web.loadUrl("https://www.iptrackeronline.com/ip2countryflag.php");
                web.setWebViewClient(new WebViewClient());
                web.reload();
                web.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Sedang memuat lokasi.", Toast.LENGTH_SHORT).show();
            }});
        newButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WebView web = (WebView) findViewById(R.id.web_view);
                web.clearCache(true);
                Toast.makeText(MainActivity.this, "Cache dihapus.", Toast.LENGTH_SHORT).show();
            }
        });
        viewLayout();
        cekIp();
    }
    public void open(View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/Xyxga"));
        startActivity(browserIntent);
    }

    private void cekIp() {
        FetchGeoIp process = new FetchGeoIp();
        process.execute();
    }


    @SuppressLint("SetTextI18n")
    public void viewLayout(){
        TextView packageName= findViewById(R.id.textView);
        data = findViewById(R.id.textView6);
        packageName.setText("this package :"+getPackageName());
    }
    public void Refresh(View view){
        cekIp();
    }
    public void Banner(View view){
        BananaActivity.startActivity(this);
        Toast.makeText(this, "Banner Activity", Toast.LENGTH_SHORT).show();
    }
    public void Inters(View view){
        InataActivity.startActivity(this);
        Toast.makeText(this, "Interstitial Activity", Toast.LENGTH_SHORT).show();
    }
    public void Setting(View view){
        SettingAct.startActivity(this);
        Toast.makeText(this, "Setting Admob", Toast.LENGTH_SHORT).show();
    }
}