package app.ys.weatherping_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by YS on 11-12-2017.
 */

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Intent intent = getIntent();
        String la = intent.getStringExtra("lat");
        String lo = intent.getStringExtra("lon");

    }
}
