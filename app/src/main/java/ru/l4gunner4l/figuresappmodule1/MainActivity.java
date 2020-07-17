package ru.l4gunner4l.figuresappmodule1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new DrawView(this);
        setContentView(view);

        final Handler handler = new Handler();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.invalidate();
                handler.postDelayed(this, 700);
            }
        }, 700);

    }



}
