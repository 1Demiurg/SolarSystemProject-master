package itschool.samsung.ru.space;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


    public class information extends AppCompatActivity {
        final Context context = this;
        ListView lvMain;
        String[] word1 = {"Солнце",
                "Меркурий",
                "Венера",
                "Земля",
                "Марс",
                "Юпитер",
                "Сатурн",
                "Уран",
                "Нептун",
                "Плутон",
                "О приложении"};
        String[] word2 = {"Солнце это единственная звезда в солнечой системе. Её масса во много раз превышает массу всех остальных обектов  солнечной системе",

                "Цвет серый. Минимальное наличие атмосферы и скалистая поверхность с весьма крупными кратерами.",

                "Цвет желто-белый. Цвет обеспечен плотным слоем облаков из серной кислоты.",

                "Цвет светло-голубой. Океаны и атмосфера придают нашей планете характерный оттенок. Однако, если смотреть на континенты, то вы увидите коричневые, желтые и зеленые цвета. Если же говорить о том, как выглядит наша планета на удаление - это будет исключительно нежно-голубого цвета шарик.",

                "Цвет красно-оранжевый. Планета богата оксидами железа за счет чего почва окрашена в характерный цвет.",

                "Цвет оранжевый с белыми элементами. Оранжевый обусловлен облаками из гидросульфида аммония, белые элементы – облаками аммиака. Твердой поверхности нет.",

                "Цвет светло-желтый. Красные облака планеты покрыты тонкой дымкой белых облаков аммиака, что создает иллюзию светло-желтого цвета. Твердой поверхности нет.",

                "Цвет бледно-голубой. Метановые облака имеют характерный оттенок. Твердой поверхности нет."+
                        "У планеты 27 спутников, все названы именами персонажей Шекспира и Поупа.",


                "Цвет бледно-голубой. Как и Уран покрыт метановыми облаками, однако, удаленность от Солнца создает видимость более темной планеты. Твердой поверхности нет.",

                "Цвет светло-коричневый. Каменистая поверхность и грязная ледяная корка создают весьма приятный светло-коричневый оттенок.",
                ")"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_information);

            getSupportActionBar().hide();

            lvMain = (ListView) findViewById(R.id.lvMain);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this, R.array.names, android.R.layout.simple_list_item_1);
            lvMain.setAdapter(adapter);

            lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    LayoutInflater li = LayoutInflater.from(context);
                    View promptsView = li.inflate(R.layout.promt, null);

                    AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

                    mDialogBuilder.setView(promptsView);

                    final TextView userInput1 = (TextView) promptsView.findViewById(R.id.tv);
                    final TextView userInput2 = (TextView) promptsView.findViewById(R.id.tv2);
                    userInput1.setText(word1[i]);
                    userInput2.setText(word2[i]);

                    AlertDialog alertDialog = mDialogBuilder.create();

                    alertDialog.show();
                }

            });

        }
    }


