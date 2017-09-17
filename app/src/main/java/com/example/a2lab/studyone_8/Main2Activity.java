package com.example.a2lab.studyone_8;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment examfragment2 = getSupportFragmentManager().findFragmentById(R.id.nav_exam2);
    Fragment readfragment2 = getSupportFragmentManager().findFragmentById(R.id.nav_read2);
    Fragment videofragment2 = getSupportFragmentManager().findFragmentById(R.id.nav_video2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            examfragment2 = examFragment2.newInstance("exam2","");
            videofragment2 = videoFragment2.newInstance("video2","");
            readfragment2 = readFragment2.newInstance("read2","");
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();



        //drawer呼叫到read,video,exam
        if (id == R.id.nav_video2) {
//                fragmentManager.beginTransaction()
//                        .replace(R.id.content_frame,new videoFragment())
//                        .commit();

            if(videofragment2.isAdded()){
                fragmentManager.beginTransaction().show(videofragment2).commit();
                Log.i("show", "videofragment:");
            }else{
                fragmentManager.beginTransaction().add(R.id.content_frame2,videofragment2).commit();
                Log.i("add", "new videofragment:");
            }

            if(examfragment2.isAdded()){
                fragmentManager.beginTransaction().hide(examfragment2).commit();
                Log.i("hide", "examfragment:(video)");
            }
            if(readfragment2.isAdded()){
                fragmentManager.beginTransaction().hide(readfragment2).commit();
                Log.i("hide", "readfragment:(video)");
            }


        } else if (id == R.id.nav_read2) {
            if(readfragment2.isAdded()){
                fragmentManager.beginTransaction().show(readfragment2).commit();
                Log.i("show", "readfragment: ");
            }else{
                fragmentManager.beginTransaction().add(R.id.content_frame2,readfragment2).commit();
                Log.i("add", "new readfragment: ");
            }

            if(examfragment2.isAdded()){
                fragmentManager.beginTransaction().hide(examfragment2).commit();
                Log.i("hide", "examfragment:(read) ");
            }
            if(videofragment2.isAdded()){
                fragmentManager.beginTransaction().hide(videofragment2).commit();
                VideoView videoView=(VideoView)findViewById(R.id.videoView);
                videoView.pause();
                Log.i("hide", "videofragment:(read) ");
            }


        } else if (id == R.id.nav_exam2) {

            if(examfragment2.isAdded()){
                fragmentManager.beginTransaction().show(examfragment2).commit();
                Log.i("show", "examfragment");
            }else{
                fragmentManager.beginTransaction().add(R.id.content_frame2,examfragment2).commit();
                Log.i("add", "examfragment");
            }

            if(readfragment2.isAdded()){
                fragmentManager.beginTransaction().hide(readfragment2).commit();
                Log.i("hide", "readfragment:(exam)");
            }
            if(videofragment2.isAdded()){
                fragmentManager.beginTransaction().hide(videofragment2).commit();
                VideoView videoView=(VideoView)findViewById(R.id.videoView);
                videoView.pause();
                Log.i("hide", "videofragment:(exam)");
            }


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
