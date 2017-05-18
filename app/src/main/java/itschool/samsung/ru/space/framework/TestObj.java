package itschool.samsung.ru.space.framework;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Dimension;
import android.view.Window;

import itschool.samsung.ru.space.framework.Renderable;
import itschool.samsung.ru.space.framework.Updatable;

/**
 * Created by vv on 14.11.2016.
 */
public class TestObj implements Renderable, Updatable {

    float ox;
    float py;
    float t;
    float g;
    float move;
    float location;
    float between;
    String name;
    String color;


    public TestObj(String name,float g,float move, String color,float location,float between) {
        this.name=name;
        this.g=g;
        this.move=move;
        this.color = color;
        paint.setColor(Color.parseColor(color.toLowerCase()));
        this.location=location;
        this.between=between;
        paint1.setColor(Color.WHITE);

    }



    Paint paint = new Paint();
    Paint paint1= new Paint();

    @Override
    public void render(Canvas canvas) {

        canvas.drawCircle(ox, py,g, paint);
        paint1.setStyle(Paint.Style.FILL);
        canvas.drawText(name, ox-20, py+g+5, paint1);

    }

    @Override
    public void update(float dt) {
            t +=move/100;
            ox = between* location  * (float) Math.cos((double) t) + GameView.x;
            py = between* location *(float) Math.sin((double) t) + GameView.y;

    }
}
