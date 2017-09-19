package fr.telecom_lille.myappimage;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by TSXN4236 on 19/09/2017.
 */

public class GestionPeripherique extends AppCompatActivity {

    public boolean createButton(Button but, int R){
        but = (Button)findViewById(R);
        but.setOnClickListener((View.OnClickListener) this);
        return true;
    }
}
