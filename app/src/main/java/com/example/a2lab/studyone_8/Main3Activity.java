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

public class Main3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment examfragment3 = getSupportFragmentManager().findFragmentById(R.id.nav_exam3);
    Fragment readfragment3 = getSupportFragmentManager().findFragmentById(R.id.nav_read3);
    Fragment videofragment3 = getSupportFragmentManager().findFragmentById(R.id.nav_video3);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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
            examfragment3 = examFragment3.newInstance("exam3","");
            videofragment3 = videoFragment3.newInstance("video3","");
            readfragment3 = readFragment3.newInstance("read3","");
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
        getMenuInflater().inflate(R.menu.main3, menu);
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
        if (id == R.id.nav_video3) {
            if(videofragment3.isAdded()){
                fragmentManager.beginTransaction().show(videofragment3).commit();
                Log.i("show", "videofragment:");
            }else{
                fragmentManager.beginTransaction().add(R.id.content_frame3,videofragment3).commit();
                Log.i("add", "new videofragment:");
            }
            if(examfragment3.isAdded()){
                fragmentManager.beginTransaction().hide(examfragment3).commit();
                Log.i("hide", "examfragment:(video)");
            }
            if(readfragment3.isAdded()){
                fragmentManager.beginTransaction().hide(readfragment3).commit();
                Log.i("hide", "readfragment:(video)");
            }
        } else if (id == R.id.nav_read3) {
            if(readfragment3.isAdded()){
                fragmentManager.beginTransaction().show(readfragment3).commit();
                Log.i("show", "readfragment: ");
            }else{
                fragmentManager.beginTransaction().add(R.id.content_frame3,readfragment3).commit();
                Log.i("add", "new readfragment: ");
            }
            if(examfragment3.isAdded()){
                fragmentManager.beginTransaction().hide(examfragment3).commit();
                Log.i("hide", "examfragment:(read) ");
            }
            if(videofragment3.isAdded()){
                fragmentManager.beginTransaction().hide(videofragment3).commit();
                VideoView videoView=(VideoView)findViewById(R.id.videoView);
                videoView.pause();
                Log.i("hide", "videofragment:(read) ");
            }
        } else if (id == R.id.nav_exam3) {
            if(examfragment3.isAdded()){
                fragmentManager.beginTransaction().show(examfragment3).commit();
                Log.i("show", "examfragment");
            }else{
                fragmentManager.beginTransaction().add(R.id.content_frame3,examfragment3).commit();
                Log.i("add", "examfragment");
            }
            if(readfragment3.isAdded()){
                fragmentManager.beginTransaction().hide(readfragment3).commit();
                Log.i("hide", "readfragment:(exam)");
            }
            if(videofragment3.isAdded()){
                fragmentManager.beginTransaction().hide(videofragment3).commit();
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
