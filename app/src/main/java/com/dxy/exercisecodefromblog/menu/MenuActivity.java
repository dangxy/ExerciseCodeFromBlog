package com.dxy.exercisecodefromblog.menu;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dxy.exercisecodefromblog.R;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.menu_add:
                break;
            case R.id.menu_wallaper:
                break;
            case R.id.menu_search:
               String local =  getIpLocal();


                Log.e("dang",local);

                break;
            case R.id.menu_setting:
                Intent settingIntent = new Intent(Settings.ACTION_SETTINGS);
                settingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

                startActivity(settingIntent);


                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private String getIpLocal(){


        try {


         for(Enumeration<NetworkInterface> enumeration= NetworkInterface.getNetworkInterfaces();enumeration.hasMoreElements();){


             NetworkInterface networkInterface = enumeration.nextElement();

             for(Enumeration<InetAddress> enumeration1 = networkInterface.getInetAddresses();enumeration1.hasMoreElements();){
                 InetAddress inetAddress = enumeration1.nextElement();

                 if(!inetAddress.isLoopbackAddress()){
                     return  inetAddress.getHostAddress().toString();
                 }
             }
         }

        }catch (Exception e){
            e.getStackTrace();
        }

        return null;
    }
}
