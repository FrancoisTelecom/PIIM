package fr.telecom_lille.myappimage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ZMNF8866 on 10/09/2017.
 */

public class CaptureActivity extends AppCompatActivity implements View.OnClickListener{
    private Button Breturn = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        /*Breturn = (Button) findViewById(R.id.Creturn);
        Breturn.setOnClickListener(this);*/
        createButton(Breturn,R.id.Creturn);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            // Si l'identifiant de la vue est celui du bouton capture
            case R.id.Creturn:
                Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show();
                Intent intentCapture = new Intent(CaptureActivity.this, MainActivity.class);
                startActivity(intentCapture);
                break;
        }
    }
    private boolean createButton(Button but, int R){
        but = (Button)findViewById(R);
        but.setOnClickListener((View.OnClickListener) this);
        return true;
    }
}
