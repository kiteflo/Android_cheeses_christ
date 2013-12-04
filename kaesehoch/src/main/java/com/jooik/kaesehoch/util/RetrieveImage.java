package com.jooik.kaesehoch.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.URL;

/**
 * Asychronous image handler...
 */
public class RetrieveImage extends AsyncTask<String,Void,Bitmap>
{

    private ImageView imageView;

    public RetrieveImage(ImageView imageView)
    {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params)
    {
        try
        {
            URL url= new URL(params[0]);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

            return bmp;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap)
    {
        imageView.setImageBitmap(bitmap);
    }
}
