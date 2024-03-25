package com.cs2340.spotifydataapp;

import java.util.ArrayList;
import java.util.Stack;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;
import android.widget.RelativeLayout;
import android.graphics.Canvas;
import android.media.MediaScannerConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import android.os.Bundle;

public class ExportImage {
    //context is where we are saving the image
    public static void captureAndSaveLayout(Context context, View view) {
        Bitmap bitmap = captureView(view);
        saveBitmap(context, bitmap);
    }
    private static Bitmap captureView(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
        }
    }
    private static void saveBitmap(Context context, Bitmap bitmap) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "captured_layout.png");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            MediaScannerConnection.scanFile(context, new String[]{file.getAbsolutePath()}, null, null);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    //this calls above code
    public static void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void captureLayout(View view) {
        RelativeLayout layout = findViewById(R.id.layout_main);
        LayoutCaptureUtils.captureAndSaveLayout(this, layout);
    }

}
