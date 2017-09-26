package children.learn.basics;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private static int SPLASH_TIME_OUT = 2000;

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
        index = new ArrayList<>();
        index = chosesRandom.getStringArray();

        this_New = new ArrayList<>();
        ArrayRandom = new ArrayList<>();
        ResalutArray= new ArrayList<>();

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

//        if (catogery.equals("D")) {
            arrayList = dataD.getD_dataArray();

//        }
        ResalutArray =getAlArray();

        image.setImageResource(arrayList.get(0).getImage());
        image.setTag(arrayList.get(0).getTage());
        anserOne.setText(ResalutArray.get(0));
        anderTwo.setText(ResalutArray.get(1));
        anserthree.setText(ResalutArray.get(2));

        anserOne.setOnTouchListener(new MyTouchListener() );
        anderTwo.setOnTouchListener(new MyTouchListener() );
        anserthree.setOnTouchListener(new MyTouchListener() );

        image.setOnDragListener(new MyDragListener() );


    }



//    public  ArrayList<String> getlArray() {
//        this_New.add(index.get(0));
//        this_New.add(index.get(1));
//        this_New.add(arrayList.get(0).getTage());
//
//
//        for (int i = 0; i < 10; ++i) {
//            myImgCount = random.nextInt(range);
//            if (myImgCount < this_New.size()) {
//                if (!ArrayRandom.contains(this_New.get(myImgCount))) {
//                    ArrayRandom.add(this_New.get(myImgCount));
//
//
//                }
//            }
//
//        }
//
//        if(ArrayRandom.size()<=2){
//            for (int i = 0; i < 10; ++i) {
//                myImgCount = random.nextInt(arrayList.size());
//                if (myImgCount < this_New.size()) {
//                    if (!ArrayRandom.contains(this_New.get(myImgCount))) {
//                        ArrayRandom.add(this_New.get(myImgCount));
//
//
//                    }
//                }
//
//            }
//
//        }
//
//        if(ArrayRandom.size()<4){
//            for (int i = 0; i < 10; ++i) {
//                myImgCount = random.nextInt(arrayList.size());
//                if (myImgCount < this_New.size()) {
//                    if (!ArrayRandom.contains(this_New.get(myImgCount))) {
//                        ArrayRandom.add(this_New.get(myImgCount));
//
//
//                    }
//                }
//
//            }
//
//        }
//
//      return   ArrayRandom;
//    }


    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.VISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }


    class MyDragListener implements View.OnDragListener  {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            TextView view = (TextView) event.getLocalState();
              ImageView test = (ImageView)v;
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:

//
                    view.setVisibility(View.VISIBLE);


                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    if(view!=null)
                        view.setVisibility(View.VISIBLE);
                     break;
                case DragEvent.ACTION_DRAG_EXITED:
                     if(view!=null)
                        view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:








                    Toast.makeText(getApplicationContext(),test.getTag().toString(),Toast.LENGTH_SHORT).show();

                    if(((ImageView)v).getTag()==view.getText().toString()) {
//
                        String toSpeak = view.getText().toString();
                        Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();
 //                         final int num =checkScore++;
//                        Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_SHORT).show();
//                        Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();

                        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                        int amStreamMusicMaxVol = am.getStreamMaxVolume(am.STREAM_MUSIC);
                        am.setStreamVolume(am.STREAM_MUSIC, amStreamMusicMaxVol, 0);
   //                        nameOfDrage.setText("toSpeak");
 //                        t1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null);

                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {


                                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.TransparentDialog));
                                    View alertView;
                                    LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                                    alertView = inflater.inflate(R.layout.custom_alert_layout, null);
                                    dialogBuilder.setView(alertView);
                                    dialogBuilder.setCancelable(false);


                                    final ImageView img_animation = (ImageView)alertView.findViewById(R.id.img_animation);
                                    final ImageView newImage =(ImageView)alertView.findViewById(R.id.newImage);
                                    Button nextgame =(Button)alertView.findViewById(R.id.nextgame);
                                    Button backToMenu =(Button)alertView.findViewById(R.id.backToMenu);
                                    backToMenu.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent =new Intent(getApplicationContext(),CatogeryMenu.class);
                                            finish();
                                            startActivity(intent);

                                        }
                                    });
                                    nextgame.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {


                                                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                                                  finish();
                                                startActivity(intent);


                                        }
                                    });

                                    TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                                            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                                            0.0f, Animation.RELATIVE_TO_SELF, -5.0f);

                                    //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                                    animation.setDuration(900);  // animation duration
                                    animation.setRepeatCount(2);  // animation repeat count
                                    animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
                                    animation.setFillAfter(true);



                                    animation.setAnimationListener(new Animation.AnimationListener() {

                                        @Override
                                        public void onAnimationStart(Animation animation) {

                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {
                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {

                                            img_animation.clearAnimation();
                                            img_animation.setVisibility(View.GONE);



                                        }

                                    });

                                    img_animation.startAnimation(animation);

                                    TranslateAnimation anation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                                            Animation.RELATIVE_TO_SELF, 5.0f, Animation.RELATIVE_TO_SELF,
                                            0.0f, Animation.RELATIVE_TO_SELF, -5.0f);
//                                    TranslateAnimation anmation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
//                                            400.0f, -5.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                                    anation.setDuration(500);  // animation duration
                                    anation.setRepeatCount(5);  // animation repeat count
                                    anation.setRepeatMode(2);   // repeat animation (left to right, right to left )
                                    anation.setFillAfter(true);
                                    anation.setAnimationListener(new Animation.AnimationListener() {

                                        @Override
                                        public void onAnimationStart(Animation animation) {

                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {
                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {

                                            newImage.clearAnimation();
                                            newImage.setVisibility(View.GONE);



                                        }

                                    });

                                    newImage.startAnimation(anation);

                                    AlertDialog alertDialog = dialogBuilder.create();
                                    alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                                    alertDialog.show();
                                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                                    lp.copyFrom(alertDialog.getWindow().getAttributes());
                                    lp.width = 600;
                                    lp.height = 800;
                                    alertDialog.getWindow().setAttributes(lp);


                            }
                        }, SPLASH_TIME_OUT);


                        break;
//
                    }else{
                        view.setVisibility(View.VISIBLE);
                        Toast.makeText(getApplicationContext()," note done",Toast.LENGTH_SHORT).show();
                    }
//

//

                case DragEvent.ACTION_DRAG_ENDED:



                    break;
                default:

                    view.setVisibility(View.VISIBLE);


//                    Toast.makeText(getApplicationContext(),"default",Toast.LENGTH_SHORT).show();

            }
            return true;
        }
    }

    public  ArrayList<String> getAlArray() {
        this_New.add(index.get(0));
        this_New.add(index.get(1));
        this_New.add(arrayList.get(0).getTage());


        for( int i = 0; i < 30; ++i)
        {
            myImgCount = random.nextInt(range);
            if(myImgCount<this_New.size()){
                if( !ArrayRandom.contains(this_New.get(myImgCount))){
                    ArrayRandom.add(this_New.get(myImgCount));


                }
            }

        }


        if(ArrayRandom.size()<arrayList.size()){

            for( int i = 0; i <30; ++i)
            {
                myImgCount = random.nextInt(arrayList.size());

                if(myImgCount<this_New.size()&&this_New.size()>myImgCount){
                    if( !ArrayRandom.contains(this_New.get(myImgCount))){
                        ArrayRandom.add(this_New.get(myImgCount));


                    }
                }

            }
        }

        if(ArrayRandom.size()==2){

            for( int i = 0; i <30; ++i)
            {
                myImgCount = random.nextInt(range);

                if(myImgCount<this_New.size()&&this_New.size()>myImgCount){
                    if( !ArrayRandom.contains(this_New.get(myImgCount))){
                        ArrayRandom.add(this_New.get(myImgCount));


                    }
                }

            }
        }


        return ArrayRandom;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this,   CatogeryMenu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
