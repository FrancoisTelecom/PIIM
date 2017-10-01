package fr.telecom_lille.myappimage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by ZMNF8866 on 10/09/2017.
 */

public class LibraryActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button Breturn = null; // creation des variables de la gestions des boutons
    private int PicturePosition=0;
    public static final int IMAGE_GALLERY_REQUEST = 20;// variable intent
    private ImageView imgPicture;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);// set du layout library
        Breturn = (Button) findViewById(R.id.Lreturn); // gestion du bouton de la library
        Breturn.setOnClickListener(this);

        imgPicture = (ImageView) findViewById(R.id.imageLibrary);
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

        // où les données sont stocké
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();
        // obtention de la représentation URI
        Uri data = Uri.parse(pictureDirectoryPath);

        // obtenir toute les images
        photoPickerIntent.setDataAndType(data, "image/*");

        // invoque l'activité
        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);

    }

    public void onClick(View v) {
        switch(v.getId()) {
            // Si l'identifiant de la vue est celui du bouton capture
            case R.id.Lreturn:
                Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show();
                Intent intentLibrary = new Intent(LibraryActivity.this, MainActivity.class);
                intentLibrary.putExtra(MainActivity.NOMBRE_PICTURE, PicturePosition);
                setResult(RESULT_OK, intentLibrary);
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            // vérification que l'opération s'est bien déroulée
            if (requestCode == IMAGE_GALLERY_REQUEST) {
                // vérification à quel intent on fait référence ici à l'aide de notre identifiant

                // l'adresse de l'image dans la carte SD
                Uri imageUri = data.getData();
                // Flux pour lire les données de la carte SD
                InputStream inputStream;
                try {
                    inputStream = getContentResolver().openInputStream(imageUri);
                    // obtention d'une image Bitmap
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    // Montre l'image à l'utilisateur
                    imgPicture.setImageBitmap(image);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    // Message à l'utilisateur
                    Toast.makeText(this, "Unable to open image", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}