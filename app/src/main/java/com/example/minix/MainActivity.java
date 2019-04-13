package com.example.minix;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        int images[] = {R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7};
        v_flipper = findViewById(R.id.v_flipper);
        // for loop
       /* for(int i=0; i< images.length; i++) {
            flipperImages(images[i]);
        }*/
        // another method
        for(int image: images){
            flipperImages(image);
        }
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            setTitle("Home");
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }
    //+++++++++++++++++++++++ flipper image +++++++++++++++++++++++++++++



    private void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000); // 3 sec
        v_flipper.setAutoStart(true);

        // animation

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       switch (menuItem.getItemId()){
           case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MessageFragment()).commit();
               setTitle("Home");
               break;
           case R.id.nav_profile:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new ProfileFragment()).commit();
               setTitle("Profile");
               break;
           case R.id.nav_mywishlist:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new ProfileFragment()).commit();
               setTitle("My Wish List");
               break;
           case R.id.nav_chat:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new ChatFragment()).commit();
               setTitle("Chat");
               break;
           case R.id.nav_cart:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new ProfileFragment()).commit();
               setTitle("My Cart");
               break;
           case R.id.nav_myorder:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new ProfileFragment()).commit();
               setTitle("My Order");
               break;
           case R.id.nav_myaddress:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new ProfileFragment()).commit();
               setTitle("My Address");
               break;

           case R.id.nav_share:
               Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
            break;
               case R.id.nav_send:
               Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
            break;
           case R.id.nav_rateus:
               Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
               break;

       }

        //try {
          //  fragment = (Fragment) fragmentClass.newInstance();
        //} catch (Exception e) {
          //  e.printStackTrace();
        //}

        // Insert the fragment by replacing any existing fragment
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        //menuItem.setChecked(true);
        // Set action bar title
       // setTitle(menuItem.getTitle());
        // Close the navigation drawer
        //mDrawer.closeDrawers();


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

}
