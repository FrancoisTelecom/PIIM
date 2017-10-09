package fr.telecom_lille.myappimage;

import android.net.Uri;

/**
 * Created by TSXN4236 on 28/09/2017.
 */




public class DBdata {

    static Uri monUri = null ;


    public static Uri getMonUri() {
        return monUri;
    }

    public static void setMonUri(Uri uri){
         monUri = uri;
    }
}
