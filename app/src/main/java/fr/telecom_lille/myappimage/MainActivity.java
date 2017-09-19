package fr.telecom_lille.myappimage;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button BTakePhoto = null; // creation des variables de la gestions des boutons
    private Button BPhotoLibrary = null;
    private Button BAnalysis = null;
    GestionPeripherique peripherique = new GestionPeripherique();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peripherique.createButton(BTakePhoto,R.id.TakePhoto);
        /*BTakePhoto = (Button) findViewById(R.id.TakePhoto);
        BTakePhoto.setOnClickListener(this);*/
        peripherique.createButton(BPhotoLibrary,R.id.PhotoLibrary);
       /*BPhotoLibrary = (Button) findViewById(R.id.PhotoLibrary);
        BPhotoLibrary.setOnClickListener(this);*/
        peripherique.createButton(BAnalysis,R.id.Analysis);
        /*BAnalysis = (Button) findViewById(R.id.Analysis);
        BAnalysis.setOnClickListener(this);*/
        //BAnalysis.setClickable(false);
        BAnalysis.setBackgroundColor(Color.DKGRAY);
      //  ImageView imgView = (ImageView)findViewById(R.id.MainPicture);
       //imgView.setImageDrawable(getResources().getDrawable(R.drawable.coca));

    }

    public void onClick(View v) {
        switch(v.getId()) {
            // Si l'identifiant de la vue est celui du bouton capture
            case R.id.TakePhoto:
                Toast.makeText(this, "Capture", Toast.LENGTH_SHORT).show();
                BAnalysis.setClickable(true);
                BAnalysis.setBackgroundColor(Color.LTGRAY);
                Intent intentTakePhoto = new Intent(MainActivity.this, CaptureActivity.class);
                startActivity(intentTakePhoto);
                break;
            // Si l'identifiant de la vue est celui du bouton photo library
            case R.id.PhotoLibrary:
                Toast.makeText(this, "Library", Toast.LENGTH_SHORT).show();
                BAnalysis.setClickable(true);
                BAnalysis.setBackgroundColor(Color.LTGRAY);
                Intent intentPhotoLibrary = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(intentPhotoLibrary);
                break;
            // Si l'identifiant de la vue est celui du bouton de l'analyse
            case R.id.Analysis:
                Toast.makeText(this, "Analysis", Toast.LENGTH_SHORT).show();
                Log.v("Etiquette", "Message à envoyer");// d=debug, e=erreur, w=warning i = information v=commun
                Intent intentAnalysis = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intentAnalysis);
                break;
        }
    }
}
