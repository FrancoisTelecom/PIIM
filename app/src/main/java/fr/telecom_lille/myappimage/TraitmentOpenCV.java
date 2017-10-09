package fr.telecom_lille.myappimage;

import android.util.Log;

import org.opencv.android.OpenCVLoader;

/**
 * Created by TSXN4236 on 06/10/2017.
 */

public class TraitmentOpenCV {
    private static final String TAG = "TraitmentOpenCV";

    static {
        if(!OpenCVLoader.initDebug()){
            Log.d(TAG, "OpenCV not load");
        } else {
            Log.d(TAG, "OpenCV load");
        }
    }
}
