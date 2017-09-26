package children.learn.basics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CatogeryMenu extends AppCompatActivity {
    Button A ,B ,C,E,D,F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catogery_menu);
        A=(Button)findViewById(R.id.a);
        B=(Button)findViewById(R.id.b);
        C=(Button)findViewById(R.id.c);
        E=(Button)findViewById(R.id.e);
        D=(Button)findViewById(R.id.d);
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("catogery","A");
                startActivity(intent);
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("catogery","B");
                startActivity(intent);
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("catogery","C");
                startActivity(intent);
            }
        });


        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("catogery","E");
                startActivity(intent);
            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("catogery","D");
                startActivity(intent);
            }
        });

      }
}
