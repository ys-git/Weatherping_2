package app.ys.weatherping_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.animation.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;
import java.util.Locale;

/**
 * Created by YS on 10-12-2017.
 */

public class Intro extends AppCompatActivity implements LocationListener {

    Button next;
    public Double lat;
    public  Double lon;
    EditText e1,e2;
    String name;
    String email;
    RadioGroup radioGroup;



    LocationManager locationManager;

    SharedPreferences sdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.intro);
        getLocation();


sdata= getSharedPreferences("my",Context.MODE_PRIVATE);

        next = (Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.radioButton3) {
                    //Toast.makeText(getApplicationContext(), "choice: A",
                      //      Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.radioButton4) {
                    //Toast.makeText(getApplicationContext(), "choice: B",
                      //      Toast.LENGTH_SHORT).show();
                }
            }

        });


        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }
        name =  e1.getText().toString();
        email =  e2.getText().toString();


        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (e1.getText().toString().trim().length() == 0) {
                    e1.startAnimation(shakeError());
                }
                else
                if (e2.getText().toString().trim().length() == 0) {
                    e2.startAnimation(shakeError());
                }
                else
                if (radioGroup.getCheckedRadioButtonId() == -1)
                {
                    // no radio buttons are checked
                    Toast.makeText(getApplicationContext(),"Please select Gender",
                            Toast.LENGTH_SHORT).show();

                }
                else
                {
                    name =  e1.getText().toString();
                    email =  e2.getText().toString();
                    SharedPreferences.Editor editor = sdata.edit();
                    //editor.clear();
                    editor.putString("Name",name);
                    editor.putString("Email", email);
                    editor.apply();

                    Intent i= new Intent(Intro.this,Home.class);
                    //i.putExtra("lat",lat);
                    //i.putExtra("lon",lon);
                    startActivity(i);

                }
            }


        });
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        /*locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());*/
        //lat=location.getLatitude();
        //lon=location.getLongitude();

        /*try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));
        }catch(Exception e)
        {

        }*/

    }

    @Override
    public void onProviderDisabled(String provider) {
        /*Toast toast = Toast.makeText(getApplicationContext(),
                "Custom toast background color",
                Toast.LENGTH_SHORT);

        View toastView = toast.getView();
        toastView.setBackgroundResource(R.drawable.toast_drawable);
        toast.show();*/

        Toast.makeText(Intro.this, "Please Enable Location", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }
    public TranslateAnimation shakeError() {
        TranslateAnimation shake = new TranslateAnimation(-1, 7, 0, 0);
        shake.setDuration(500);
        shake.setInterpolator(new CycleInterpolator(7));
        return shake;
    }
}

