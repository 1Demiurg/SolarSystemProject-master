package itschool.samsung.ru.space.framework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import itschool.samsung.ru.space.R;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getSupportActionBar().hide();
    }
}
