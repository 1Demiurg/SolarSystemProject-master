package itschool.samsung.ru.space;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;

import itschool.samsung.ru.space.framework.GameView;

public class MainActivity extends AppCompatActivity {
static public int width,height;
    private static final String TAG = "MyApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setT();
        Log.i(TAG, String.valueOf(width)+" "+ String.valueOf(height));
        GameView.x = width;
        GameView.y = height;

        getSupportActionBar().hide();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();


        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.action_sob:
                Intent intentE = new Intent(MainActivity.this, Events.class);
                startActivity(intentE);
                return true;
            case R.id.action_information:
                Intent intent = new Intent(MainActivity.this, information.class);
                //intent.putExtra("OPEN_ID",acmi.id);
                startActivity(intent);
                return true;
            case R.id.action_game:
                Intent intentG = new Intent(MainActivity.this, Game.class);
                //intent.putExtra("OPEN_ID",acmi.id);
                startActivity(intentG);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void setT() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
         width = size.x / 2;
         height = size.y / 2;
    }

}
