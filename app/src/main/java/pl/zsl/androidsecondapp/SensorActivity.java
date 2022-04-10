package pl.zsl.androidsecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity {
    TextView sensorX;
    TextView sensorY;
    TextView sensorZ;
    TextView sensorTemperature;
    Sensor accelerometer;
    Sensor temperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        sensorX = findViewById(R.id.sensorX);
        sensorY = findViewById(R.id.sensorY);
        sensorZ = findViewById(R.id.sensorZ);
        sensorTemperature = findViewById(R.id.sensorTemperature);
        SensorManager manager = (SensorManager) getBaseContext().getSystemService(SENSOR_SERVICE);
        accelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        temperature = manager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        manager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                sensorTemperature.setText("Temperatura: " + event.values[0]);
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, temperature, 100_000);

        manager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                sensorX.setText("Oś X: " + event.values[0]);
                sensorY.setText("Oś Y: " + event.values[1]);
                sensorZ.setText("Oś Z: " + event.values[2]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, accelerometer, 100_000);

    }
}