package fr.telecom_lille.myappimage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by ZMNF8866 on 10/09/2017.
 */

public class LibraryActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button Breturn = null; // creation des variables de la gestions des boutons
    GestionPeripherique peripherique = new GestionPeripherique();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        peripherique.createButton(Breturn,R.id.Lreturn);
        /*Breturn = (Button) findViewById(R.id.Lreturn);
        Breturn.setOnClickListener(this);*/

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(LibraryActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClick(View v) {
        switch(v.getId()) {
            // Si l'identifiant de la vue est celui du bouton capture
            case R.id.Lreturn:
                Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show();
                Intent intentLibrary = new Intent(LibraryActivity.this, MainActivity.class);
                startActivity(intentLibrary);
                break;
        }
    }
}