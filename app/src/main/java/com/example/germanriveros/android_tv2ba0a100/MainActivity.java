package com.example.germanriveros.android_tv2ba0a100;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    private ContentResolver contentResolver;
    private BroadcastReceiver mReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d("Ejercutando_metodo: ", "onCreate");
        //Intent i = new Intent(MainActivity.this, SecondActivity.class);
       // i.putExtra("variable","dato");
        //startActivity(i);
        //access();

    }


    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("Ejercutando_metodo: ", "onStart");
    }

    @Override
    protected void onResume()
    {

        this.mReceiver = new HelloBroadcastReceiver();
        registerReceiver(this.mReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        super.onResume();
        Log.d("Ejercutando_metodo: ", "onResume");
    }

    @Override
    protected void onPause()
    {

        unregisterReceiver(mReceiver);

        super.onPause();
        Log.d("Ejercutando_metodo: ", "onPause");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("Ejercutando_metodo: ", "onRestar");
    }


    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("Ejercutando_metodo: ", "onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("Ejercutando_metodo: ", "onDestroy");
    }



    public void access()
    {
        //Este ejemplo no funciono con el simulador

        contentResolver = getContentResolver();
        Cursor cur = contentResolver.query(Contacts.People.CONTENT_URI,
                null, null, null,null);


        if(cur.getCount() > 0)

            while(cur.moveToNext())
            {
                String id = cur.getString(cur.getColumnIndex(Contacts.People._ID));
                String name= cur.getString(cur.getColumnIndex(Contacts.People.DISPLAY_NAME));

                Log.d("ContentProvider",name);
                Log.d("ContentProvider", id);


            }



    }//..




}
