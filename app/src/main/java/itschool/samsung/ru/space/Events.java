package itschool.samsung.ru.space;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by user on 21.05.2017.
 */

public class Events extends AppCompatActivity {

    final Context context = this;
    ListView lvMain;
    String[] word1 = {"Затмения"};
    String[] word2 = {"Затмения бывают 2 видов солнечное и лунное."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getSupportActionBar().hide();
        // находим список
        lvMain = (ListView) findViewById(R.id.wlvMain);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.events, android.R.layout.simple_list_item_1);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.promt, null);
                //Создаем AlertDialog
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

                //Настраиваем prompt.xml для нашего AlertDialog:
                mDialogBuilder.setView(promptsView);

                //Настраиваем отображение поля для ввода текста в открытом диалоге:
                final TextView userInput1 = (TextView) promptsView.findViewById(R.id.tv);
                final TextView userInput2 = (TextView) promptsView.findViewById(R.id.tv2);
                userInput1.setText(word1[i]);
                userInput2.setText(word2[i]);

                //Создаем AlertDialog:
                AlertDialog alertDialog = mDialogBuilder.create();

                //и отображаем его:
                alertDialog.show();
            }

        });

    }
}


