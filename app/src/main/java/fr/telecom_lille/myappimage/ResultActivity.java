package fr.telecom_lille.myappimage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ZMNF8866 on 10/09/2017.
 */

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    private Button Breturn = null; // creation des variables de la gestions des boutons
    private Button BGoWeb = null;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        createButton(Breturn,R.id.Rreturn);
        createButton(BGoWeb,R.id.Rweb);
        //BGoWeb.setClickable(false);
        //BGoWeb.setBackgroundColor(Color.DKGRAY);
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
    private boolean createButton(Button but, int R){
        but = (Button)findViewById(R);
        but.setOnClickListener((View.OnClickListener) this);
        return true;
    }
}
