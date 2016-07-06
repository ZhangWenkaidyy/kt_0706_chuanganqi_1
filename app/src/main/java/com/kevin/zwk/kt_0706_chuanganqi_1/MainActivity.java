package com.kevin.zwk.kt_0706_chuanganqi_1;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensorAccelerometer;
    private TextView textView;
    private boolean isanShake;
    private SoundPool soundpool;
    private boolean isCanplay;
    private int beepId;
    private Vibrator vibrator;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //蜂鸣震动
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        textView = (TextView) findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//加速度传感器
        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//需要注册，第一个是监听器，第二个是监听的传感器，第三个是传感器的精度
        sensorManager.registerListener(this, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundpool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                isCanplay = true;
            }
        });

        beepId = soundpool.load(this, R.raw.outgoing, 0);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    public void click(View view) {
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        int i = 0;
        for (Sensor sensor : sensorList) {

            i++;
            Log.i("-------", i + "-----传感器名称" + sensor.getName() + "类型:" + sensor.getStringType() + "供应商" + sensor.getVendor());
        }
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        isCanplay = true;
        Log.i("---0----", "" + event.values[0]);
        Log.i("---1----", "" + event.values[1]);
        Log.i("---2----", "" + event.values[2]);

        if (Math.abs(event.values[0]) > 15 || Math.abs(event.values[1]) > 15 || Math.abs(event.values[2]) > 15 && isanShake) {
            isanShake = false;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isanShake = true;
                }
            }, 1000);
            Log.i("------", "摇一摇");
            soundpool.play(beepId, 1, 1, 0, 0, 1);
            vibrator.vibrate(1000);
            Toast.makeText(MainActivity.this, "摇一摇", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}