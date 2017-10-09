package fr.telecom_lille.myappimage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by ZMNF8866 on 10/09/2017.
 */

public class CaptureActivity extends AppCompatActivity implements View.OnClickListener{
    private Button Breturn = null;
    private Button takePhoto;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView mImageView;
    String mCurrentPhotoPath;
    DBdata db = new DBdata();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);
        createButton(Breturn,R.id.Creturn);
        createButton(takePhoto,R.id.TakePhoto);
        mImageView = (ImageView) findViewById(R.id.imgPhoto);
        //Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            //return main page
            case R.id.Creturn:
                Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show();
                Intent intentCapture = new Intent(CaptureActivity.this, MainActivity.class);
<<<<<<< HEAD
                finish();
=======
                startActivity(intentCapture);
                setResult(RESULT_OK, intentCapture);
                //finish();
>>>>>>> OpenCVIntegration
                break;
            //button take picture
            case R.id.TakePhoto:
                dispatchTakePictureIntent();
                galleryAddPic();
        }

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            setResult(RESULT_OK, takePictureIntent);
            //Toast.makeText(this, RESULT_OK, Toast.LENGTH_SHORT).show();


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(String.valueOf(mCurrentPhotoPath));
        Uri contentUri = Uri.fromFile(f);
        //mediaScanIntent.setData(contentUri);
        db.setMonUri(Uri.fromFile(f));
        mediaScanIntent.setData(db.getMonUri());
        this.sendBroadcast(mediaScanIntent);
        }
    /*Creat picture gallerie */
    /*private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }*/

    //creat buttom
    private boolean createButton(Button but, int R){
        but = (Button)findViewById(R);
        but.setOnClickListener((View.OnClickListener) this);
        return true;
    }

}
