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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import static com.example.a2lab.studyone_8.R.layout.buttonshape2;

public class Main1Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Fragment examfragment1 = getSupportFragmentManager().findFragmentById(R.id.nav_exam1);
    Fragment readfragment1 = getSupportFragmentManager().findFragmentById(R.id.nav_read1);
    Fragment videofragment1 = getSupportFragmentManager().findFragmentById(R.id.nav_video1);
    TextView step1,step2;
    Button sure;
    EditText editText;
    String studentnum;
    int studentnumLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.setDrawerLockMode(1);//鎖住drawer


        if (savedInstanceState == null) {
            examfragment1 = examFragment1.newInstance("exam1","");
            videofragment1 = videoFragment1.newInstance("video1","");
            readfragment1 = readFragment1.newInstance("read1","");
        }

        editText=(EditText)findViewById(R.id.editText);//學號
        step1=(TextView) findViewById(R.id.textView2);//step1
        step2=(TextView) findViewById(R.id.textView3);//step2
        sure=(Button)findViewById(R.id.sure);
        studentnumLength=editText.length();
        editText.setVisibility(View.VISIBLE);
        step1.setVisibility(View.VISIBLE);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length()==0)
                    drawer.setDrawerLockMode(1);//鎖住drawer
                else
                    drawer.setDrawerLockMode(0);//開啟drawer
                studentnum=editText.getText().toString();
                Log.i("Studennumber",studentnum);
                editText.setVisibility(View.GONE);
                step1.setVisibility(View.GONE);
                step2.setVisibility(View.VISIBLE);

            }
        });
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
        getMenuInflater().inflate(R.menu.main1, menu);
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
        if (id == R.id.nav_video1) {
            if(videofragment1.isAdded()){
                fragmentManager.beginTransaction().show(videofragment1).commit();
                Log.i("show", "videofragment:");
            }else{
                fragmentManager.beginTransaction().add(R.id.content_frame1,videofragment1,"videofragment1").commit();
                Log.i("add", "new videofragment:");
//                sure.setVisibility(View.INVISIBLE);
            }
            if(examfragment1.isAdded()){
                fragmentManager.beginTransaction().hide(examfragment1).commit();
                Log.i("hide", "examfragment:(video)");
            }
            if(readfragment1.isAdded()){
                fragmentManager.beginTransaction().hide(readfragment1).commit();
                Log.i("hide", "readfragment:(video)");
            }
        } else if (id == R.id.nav_read1) {

            if(readfragment1.isAdded()){
                fragmentManager.beginTransaction().show(readfragment1).commit();
                Log.i("show", "readfragment: ");
            }else{
                fragmentManager.beginTransaction().add(R.id.content_frame1,readfragment1,"readfragment1").commit();
                Log.i("add", "new readfragment: ");
            }

            if(examfragment1.isAdded()){
                fragmentManager.beginTransaction().hide(examfragment1).commit();
                Log.i("hide", "examfragment:(read) ");
            }
            if(videofragment1.isAdded()){
                fragmentManager.beginTransaction().hide(videofragment1).commit();
                VideoView videoView=(VideoView)findViewById(R.id.videoView);
                videoView.pause();
                Log.i("hide", "videofragment:(read) ");
            }


        } else if (id == R.id.nav_exam1) {

            if(examfragment1.isAdded()){
                fragmentManager.beginTransaction().show(examfragment1).commit();
                Log.i("show", "examfragment");
            }else{
                fragmentManager.beginTransaction().add(R.id.content_frame1,examfragment1,"examfragment1").commit();
                Log.i("add", "examfragment");
            }

            if(readfragment1.isAdded()){
                fragmentManager.beginTransaction().hide(readfragment1).commit();
                Log.i("hide", "readfragment:(exam)");
            }
            if(videofragment1.isAdded()){
                fragmentManager.beginTransaction().hide(videofragment1).commit();
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
