package hu.petrik.akasztofa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btnPlussz;
    private AppCompatButton btnMinusz;
    private AppCompatButton tipp;
    private TextView abc;
    private ImageView Imgs;
    private TextView showWord;
    private String MagyarAbc = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
    private List<String> abc_List;
    private List<String> szavak_List;
    private Random rnd;
    private String szo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnPlussz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(abc.getText());
                int actualnum = 0;
                for (int i = 0; i < abc_List.size(); i++) {
                    if (s.equals(abc_List.get(i))) {
                        actualnum = i;
                    }
                }
                if (actualnum + 1 == abc_List.size()) {
                    s = "A";
                } else {
                    s = abc_List.get((actualnum + 1));
                }
                abc.setText(s);
            }
        });

        btnMinusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(abc.getText());
                int actualnum = 0;
                for (int i = 0; i < abc_List.size(); i++) {
                    if (s.equals(abc_List.get(i))) {
                        actualnum = i;
                    }
                }
                if (actualnum - 1 == -1) {
                    s = "Z";
                } else {
                    s = abc_List.get((actualnum - 1));
                }
                abc.setText(s);
            }
        });

        tipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Character ch = abc.getText().toString().charAt(0);
                jatek(ch);
            }
        });

    }

    private void jatek(Character tippeles) {
        String szoShadow = (String) showWord.getText();
        szoShadow.replace(" ", "");
        for (int i = 0; i < szo.length(); i++) {
            if (Character.compare(szo.charAt(i), tippeles) == 0) {
                szoShadow.replace(szoShadow.charAt(i), szo.charAt(i));
            }
        }
        showWord.setText(szoShadow);
    }

    private void init() {
        btnPlussz = findViewById(R.id.btnPlussz);
        btnMinusz = findViewById(R.id.btnMinusz);
        tipp = findViewById(R.id.tipp);
        abc = findViewById(R.id.abc);
        Imgs = findViewById(R.id.Imgs);
        showWord = findViewById(R.id.showWord);

        abc_List = new ArrayList<String>();
        String[] temp = MagyarAbc.split(" ");
        abc_List.addAll(Arrays.asList(temp));

        szavak_List = new ArrayList<>();
        beolvas();
        rnd = new Random();

        szo = szavak_List.get((rnd.nextInt(szavak_List.size())));

        String stmp = "_";
        for (int i = 0; i < szo.length() - 1; i++) {
            stmp += " _";
        }
        showWord.setText(stmp);
    }


    private void beolvas() {
        szavak_List.add("verebek");
        szavak_List.add("meg");
        szavak_List.add("meglep");
        szavak_List.add("lep");
        szavak_List.add("kell");
        szavak_List.add("teszt");
        szavak_List.add("bab");
        szavak_List.add("hab");
        szavak_List.add("feled");
        szavak_List.add("keret");
        szavak_List.add("szeret");
    }
}