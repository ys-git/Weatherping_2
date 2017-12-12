package app.ys.weatherping_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by YS on 11-12-2017.
 */

public class Home extends AppCompatActivity {
    SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        TextView t=(TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        String la = intent.getStringExtra("lat");
        String lo = intent.getStringExtra("lon");

         settings = this.getSharedPreferences("my",Context.MODE_PRIVATE);
        String meString = settings.getString("Name", "defaultvalue");
        //t.setText(meString);


    }
}
