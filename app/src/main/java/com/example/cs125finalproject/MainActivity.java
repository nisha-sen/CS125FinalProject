package com.example.cs125finalproject;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

import android.graphics.Canvas;
import android.view.Display;

public class MainActivity extends AppCompatActivity {
    /** new random number generator. */
    Random rand = new Random();
    /** random number generator for timeout of circle on screen. */
    /** variables for the x and y coordinates. */
    private int locationX;
    private int locationY;
    /** variable for game score. */
    private int score;
    /** game level. */
    private String level;
    /** radius. */
    private int radius;
    //max x value
    private int xCoordinate;
    //max y value
    private int yCoordinate;
    private Canvas circle;
    private CircleView circleview;

    public void setCoordinates() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        xCoordinate = size.x;
        yCoordinate = size.y;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
