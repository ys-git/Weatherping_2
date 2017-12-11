package app.ys.weatherping_2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class First extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        Button al = (Button) findViewById(R.id.start);
        Button a2= (Button) findViewById(R.id.button2);
        al.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Error", "first");
                Intent i = new Intent(First.this, Intro.class);
                startActivity(i);
            }
        });
        /*a2.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View v) {
                                      Intent i = new Intent(First.this, About.class);
                                      startActivity(i);
                                      return;
                                  }
        });*/


    }
}

/*public void onStart(View v)
    {
        if(v.getId() == R.id.start)
        {
            Intent i  = new Intent(First.this, Second.class);
            startActivity(i);
        }
    }
}
  */
