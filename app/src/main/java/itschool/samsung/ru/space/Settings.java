package itschool.samsung.ru.space;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by student1 on 22.05.17.
 */


public class Settings extends AppCompatActivity {

    public static int size_2_0 = 1;
    public static int radius = 1;
    public static int spid = 1;
    public static int txt = 1;

    TextView text;
    TextView text2;
    TextView text3;
    TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences sp = getSharedPreferences("mPref", MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("Planet 1", size_2_0);
        editor.putInt("Planet 2", radius);
        editor.putInt("Planet 3", spid);
        editor.putInt("Planet 4", txt);
        editor.apply();


        size_2_0= sp.getInt("Planet 1", 1);
        radius = sp.getInt("Planet 2", 1);
        spid= sp.getInt("Planet 3", 1);
        txt= sp.getInt("Planet 4", 1);

        text= (TextView) findViewById(R.id.text);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);

        text.setText(Integer.toString(size_2_0));
        text2.setText(Integer.toString(radius));
        text3.setText(Integer.toString(spid));
        text4.setText(Integer.toString(txt));
    }


    public void minusSize(View view) {
        size_2_0=size_2_0-1;
        text.setText(Integer.toString(size_2_0));

    }
    public void plusSize(View view) {
        size_2_0=size_2_0+1;
        text.setText(Integer.toString(size_2_0));

    }


    public void minusradius(View view) {
        radius=radius-1;
        text2.setText(Integer.toString(radius));
    }
    public void plusradius(View view) {
        radius=radius+1;
        text2.setText(Integer.toString(radius));
    }


    public void minusSpid(View view) {
        spid=spid-1;
        text3.setText(Integer.toString(spid));
    }
    public void plusSpid(View view) {
        spid=spid+1;
        text3.setText(Integer.toString(spid));
    }


    public void minustext(View view) {
        txt=txt-1;
        text4.setText(Integer.toString(txt));
    }

    public void plustext(View view) {
        txt=txt+1;
        text4.setText(Integer.toString(txt));
    }
}
