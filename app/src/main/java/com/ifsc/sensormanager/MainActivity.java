package com.ifsc.sensormanager;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager mSensorManager;
    Sensor mSensorLight;
    TextView textView;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       listView = findViewById(R.id.listView);

        mSensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        List <Sensor> listSensor = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        String[] sensorNames = new String[listSensor.size()];

        for(int i = 0; i< listSensor.size(); i++){
            sensorNames[i] = listSensor.get(i).getName();
        }

        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,sensorNames);
        listView.setAdapter(adapter);




    }



}