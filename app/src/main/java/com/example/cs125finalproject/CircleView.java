package com.example.cs125finalproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import java.util.Random;


public class CircleView extends View {

    Paint paint;
    Random rand;
    public EditText setWinner;
    private int xCoordinate;
    private int yCoordinate;
    private int locationX;
    private int locationY;
    private int score;
    public CircleView(Context context) {
        super(context);
        paint = new Paint();
    }

    /** set x coordinate for circle. */
    public int getLocationX() {
        locationX = rand.nextInt(700) + 200;
        return locationX;
    }

    /** set y coordinate for circle. */
    public int getLocationY() {
        locationY = rand.nextInt(900) + 300;
        return locationY;
    }
    /** set coordinates */
    public void setCoordinates() {
        xCoordinate = getLocationX();
        yCoordinate = getLocationY();
    }

    public String setLevel() {
        String level = new String();
        if (score < 5) {
            level = "Bronze";
        } else if (5 <= score && score < 8) {
            level = "Silver";
        } else if (score >= 8) {
            level = "Gold";
        }
        return level;
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        rand = new Random();
        setCoordinates();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint = new Paint();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        setWinner = ((View)(this.getParent())).findViewById(R.id.winner_label);
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // x between locationX + radius and location X - radius
                if (x < (locationX + 50) && x > (locationX - 50)
                        && y < (locationY + 50) && y > (locationY - 50)) {
                    setWinner.setVisibility(View.VISIBLE);
                }
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        final int locationX = getLocationX();
        final int locationY = getLocationY();
        final int radius = 50;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawCircle(locationX, locationY, radius, paint);
    }
}
