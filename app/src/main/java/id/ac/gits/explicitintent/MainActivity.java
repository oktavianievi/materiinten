package id.ac.gits.explicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void panggil(View view) {
        String nomor = "0895701512261" ;
        Intent panggil = new Intent(Intent. ACTION_DIAL);
        panggil.setData(Uri. fromParts("tel",nomor,null));
        startActivity(panggil);
    }

    public void buka(View view) {
        String url = "https://mail.google.com/" ;
        Intent bukabrowser = new Intent(Intent. ACTION_VIEW);
        bukabrowser.setData(Uri. parse(url));
        startActivity(bukabrowser);
    }
    public void bukaWa(View view){
        Intent i = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        startActivity(i);
    }
    public void bukaemail(View view) {
        Intent bukaemail = getPackageManager().getLaunchIntentForPackage("email.com");
        startActivity(bukaemail);
    }
    public void onButtonTap(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"oktavianievi9@gmail.com"});
        intent.putExtra(Intent.EXTRA_CC, new String[]{"evioktaviani@teknokrat.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email dari Aplikasi Android");
        intent.putExtra(Intent.EXTRA_TEXT, "Hai, ini adalah percobaan mengirim email dari aplikasi android");

        try {
            startActivity(Intent.createChooser(intent, "Ingin Mengirim Email ?"));
        } catch (android.content.ActivityNotFoundException ex) {
            //do something else
        }
    }
}