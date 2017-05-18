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
        objects.add(new TestObj("Солнце",  139.1f/4, 0,    "RED",   0,0));
        objects.add(new TestObj("Меркурий",0.24f+8,  3.48f/2,"GREEN", 1,d*3+5));
        objects.add(new TestObj("Венера",  0.6f+11,  3.5f/2, "YELLOW",2,d*1.5f+5));
        objects.add(new TestObj("Земля",   0.63f+13, 2.97f/2,"BLUE",  3,d*1.25f+5));
        objects.add(new TestObj("Марс",    0.33f+9,  2.41f/2,"RED",   4,d+5));
        objects.add(new TestObj("Юпитер",  6.99f+25, 1.3f/2, "GREEN", 5,d+6));
        objects.add(new TestObj("Сатурн",  5.82f+22, 0.96f/2,"YELLOW",6,d+5));
        objects.add(new TestObj("Уран",    2.53f+16, 0.68f/2,"BLUE",  7,d+5));
        objects.add(new TestObj("Нептун",  2.46f+19, 0.54f/2,"BLUE",  8,d+5));
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