package children.learn.basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import children.learn.basics.gameMommery.A;
import children.learn.basics.gameMommery.B;
import children.learn.basics.gameMommery.C;
import children.learn.basics.gameMommery.ChosesRandom;
import children.learn.basics.gameMommery.D;
import children.learn.basics.gameMommery.ImagReTag;

public class MainActivity extends AppCompatActivity {

    TextView anserOne ,anderTwo,anserthree;
    ImageView image;
    Bundle bundle;
    String catogery;
    ArrayList<ImagReTag> arrayList;
    A dataA;
    B dataB;
    C dataC;
    D dataD;
    ArrayList<String> index, this_New ,ResalutArray;
    ArrayList<String> ArrayRandom;
    ChosesRandom chosesRandom;
    int myImgCount = 0;
    int range;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        *******
        image = (ImageView) findViewById(R.id.image);
        anserOne =(TextView)findViewById(R.id.anserOne);
        anderTwo =(TextView)findViewById(R.id.anderTwo);
        anserthree =(TextView)findViewById(R.id.anserthree);
         bundle = getIntent().getExtras();
        arrayList = new ArrayList<>();
        chosesRandom = new ChosesRandom();
        index = chosesRandom.getStringArray();
        index = new ArrayList<>();
        this_New = new ArrayList<>();
        ArrayRandom = new ArrayList<>();
        ResalutArray= new ArrayList<>();
        ResalutArray =getAlArray();
        range = index.size();

//        **********
        dataA = new A();
        dataD = new D();
        dataB = new B();
        dataC = new C();
//        ************
        if (bundle != null) {
            catogery = bundle.getString("catogery");
        }

        if (catogery.equals("D")) {
            arrayList = dataD.getD_dataArray();

        }

        image.setImageResource(arrayList.get(0).getImage());
        anserOne.setText(ResalutArray.get(0));
        anderTwo.setText(ResalutArray.get(1));
        anserthree.setText(ResalutArray.get(2));


    }



    public  ArrayList<String> getAlArray() {
        this_New.add(index.get(0));
        this_New.add(index.get(1));
        this_New.add(arrayList.get(0).getTage());


        for (int i = 0; i < 10; ++i) {
            myImgCount = random.nextInt(range);
            if (myImgCount < this_New.size()) {
                if (!ArrayRandom.contains(this_New.get(myImgCount))) {
                    ArrayRandom.add(this_New.get(myImgCount));


                }
            }

        }

      return   ArrayRandom;
    }
}
