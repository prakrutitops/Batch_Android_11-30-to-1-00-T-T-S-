package com.example.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener {

    Button btn1,btn2;
    MediaPlayer mediaPlayer;
   // String url="https://vyasprakruti.000webhostapp.com/file/welcome_to_my_house.mp3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        //mediaPlayer =MediaPlayer.create(getApplicationContext(),R.raw.welcome_to_my_house);

        /*if (mediaPlayer == null)
        {

            try
            {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(this);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


        }
        else
        {

        }*/

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        if(view==btn1)
        {
            //mediaPlayer.start();
            /*Intent i =new Intent(this,MyService.class);
            startService(i);
            */
            BroadcastReceiver receiver = new MyReceiver();
            IntentFilter filter =new IntentFilter();
            filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            registerReceiver(receiver,filter);

        }
        if(view==btn2)
        {
            //mediaPlayer.stop();
         /*   Intent i =new Intent(this,MyService.class);
            stopService(i);*/
        }
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer)
    {
        mediaPlayer.start();
    }
}
