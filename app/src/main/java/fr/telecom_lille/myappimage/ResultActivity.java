package fr.telecom_lille.myappimage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.net.Uri;

/**
 * Created by ZMNF8866 on 10/09/2017.
 */

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    private Button Breturn = null; // creation des variables de la gestions des boutons
    private Button BGoWeb = null;
    GestionPeripherique peripherique = new GestionPeripherique();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        peripherique.createButton(Breturn,R.id.Rreturn);
        /*Breturn = (Button) findViewById(R.id.Rreturn);
        Breturn.setOnClickListener(this);*/
        peripherique.createButton(BGoWeb,R.id.Rweb);
        /*BGoWeb = (Button) findViewById(R.id.Rweb);
        BGoWeb.setOnClickListener(this);*/
        //BGoWeb.setClickable(false);
        BGoWeb.setBackgroundColor(Color.DKGRAY);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            // Si l'identifiant de la vue est celui du bouton capture
            case R.id.Rreturn:
                Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show();
                Intent intentResult = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intentResult);
                break;
            // Si l'identifiant de la vue est celui du bouton photo library
            case R.id.Rweb:
                Toast.makeText(this, "Web", Toast.LENGTH_SHORT).show();
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("https://www.google.fr"));
                startActivity(openURL);
                break;
        }
    }
}
