package com.example.rollerball;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import nl.dionsegijn.konfetti.xml.KonfettiView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private RollerSurfaceView mSurfaceView;
    private KonfettiView celebrationView;
    private TextView text;
    private RollerGame mGame;
    private Timer timer;
    private TimerTask timerTask;
    private Double time = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSurfaceView = findViewById(R.id.rollerSurface);





        // For testing in the emulator
        mSurfaceView.setOnClickListener(view -> mSurfaceView.shake());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this, mAccelerometer);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        // Get accelerometer values
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        // Move the ball
        mSurfaceView.changeAcceleration(x, y);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }








}