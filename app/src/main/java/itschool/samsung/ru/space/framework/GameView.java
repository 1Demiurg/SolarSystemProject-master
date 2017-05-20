package itschool.samsung.ru.space.framework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;

import itschool.samsung.ru.space.MainActivity;

/**
 * Created by vv on 14.11.2016.0
 */
public class GameView extends View {
    public static float x;
    public static float y;
    private static final String TAG = "MyApp1";

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        float d=25;
        objects.add(new TestObj("Солнце",  139.1f/4, 0,    "RED",     255,36,0, 0,0));
        objects.add(new TestObj("Меркурий",0.24f+8,  3.48f/2,"GREEN", 128,128,128,   1,d*2.5f+15));
        objects.add(new TestObj("Венера",  0.6f+11,  3.5f/2, "YELLOW",255,255,153,   2,d*1.5f+15));
        objects.add(new TestObj("Земля",   0.63f+13, 2.97f/2,"BLUE",  66,170,255,    3,d*1.25f+15));
        objects.add(new TestObj("Марс",    0.33f+9,  2.41f/2,"RED",   255,43,43 ,    4,d+15));
        objects.add(new TestObj("Юпитер",  6.99f+25, 1.3f/2, "GREEN", 255,201,102,   5,d+15));
        objects.add(new TestObj("Сатурн",  5.82f+22, 0.96f/2,"YELLOW",255,255,153,  6,d+20));
        objects.add(new TestObj("Уран",    2.53f+16, 0.68f/2,"BLUE",  135,206,250 ,  7,d+25));
        objects.add(new TestObj("Нептун",  2.46f+19, 0.54f/2,"BLUE",  0,0,139,    8,d+30));
        objects.add(new TestObj("Плутон",  0.1f+6, 0.45f/2,"GRAY",  255,153,51,    9,d+35));

        //x = MainActivity.width;
        //y = MainActivity.height;
        Log.i(TAG, String.valueOf(x)+" "+ String.valueOf(x));

    }
    ArrayList<Object> objects = new ArrayList<>();

    long lastUpdate = System.currentTimeMillis();

    @Override

    protected void onDraw(Canvas canvas){
        canvas.drawARGB(255, 40, 40, 40);
        long currentTime = System.currentTimeMillis();
        drawObjects(canvas);
        updateObjects((currentTime - lastUpdate)*0.01f);
        lastUpdate = currentTime;
        invalidate();
    }
    void drawObjects(Canvas canvas)
    {
        for (int i = 0; i< objects.size(); i++){
            if (objects.get(i) instanceof Renderable)
            {
                ((Renderable)objects.get(i)).render(canvas);
            }

        }
    }
    void updateObjects(float dt)
    {
        for (int i = 0; i< objects.size(); i++){
            if (objects.get(i) instanceof Updatable)
            {

                ((Updatable)objects.get(i)).update(dt);
            }

        }
    }



}