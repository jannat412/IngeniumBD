package com.ingeniumbd.ingeniumbd;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ingeniumbd.ingeniumbd.Fragments.AndroidApps;
import com.ingeniumbd.ingeniumbd.Fragments.DigitalMarketing;
import com.ingeniumbd.ingeniumbd.Fragments.GraphicsDesign;
import com.ingeniumbd.ingeniumbd.Fragments.HomePage;
import com.ingeniumbd.ingeniumbd.Fragments.ItTreaning;
import com.ingeniumbd.ingeniumbd.Fragments.OurProduct;
import com.ingeniumbd.ingeniumbd.Fragments.SoftwareDevelopment;
import com.ingeniumbd.ingeniumbd.Fragments.WebDesign;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new HomePage()).commit();

        BottomBar mBottombar= BottomBar.attach(this,savedInstanceState);


        mBottombar.setItemsFromMenu(R.menu.bottom_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {

                if (menuItemId==R.id.email)
                {

                }

                else if(menuItemId==R.id.web)
                {

                }

                else if (menuItemId==R.id.play)
                {

                }

                else if (menuItemId==R.id.facebook)
                {
                 startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pages/Khans/158013767557799")));

                }

                else if (menuItemId==R.id.phone)
                {

                }



            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

        mBottombar.mapColorForTab(0,"#BF360C");
        mBottombar.mapColorForTab(1,"#33691E");
        mBottombar.mapColorForTab(2,"#01579B");
        mBottombar.mapColorForTab(3,"#303F9F");
        mBottombar.mapColorForTab(4,"#AD1457");


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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_phone) {
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+8801763432203")));
            return true;
        }

        if (id == R.id.action_email) {
            final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            final PackageManager pm = getPackageManager();
            final List<ResolveInfo> matches = pm.queryIntentActivities(intent, 0);
            ResolveInfo best = null;
            for (final ResolveInfo info : matches)
                if (info.activityInfo.packageName.endsWith(".gm") ||
                        info.activityInfo.name.toLowerCase().contains("gmail")) best = info;
            if (best != null)
            {
                intent.setClassName(best.activityInfo.packageName, best.activityInfo.name);

                String[] TO = {"ingeniumbd04@gmail.com"};
                String[] CC = {"ingeniumbd4@gmail.com"};
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, TO);
                intent.putExtra(Intent.EXTRA_CC, CC);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contract with ingenium");
                intent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
                startActivity(intent);
            }
            else {
                Intent intent1 = new Intent(Intent.ACTION_SEND);

                String[] TO = {"ingeniumbd04@gmail.com"};
                String[] CC = {"ingeniumbd4@gmail.com"};
                intent1.setData(Uri.parse("mailto:"));
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_EMAIL, TO);
                intent1.putExtra(Intent.EXTRA_CC, CC);
                intent1.putExtra(Intent.EXTRA_SUBJECT, "Contract with ingenium");
                intent1.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
                startActivity(intent1);
            }
            return true;
        }
        if (id == R.id.action_web) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ingeniumbd.com")));
            return true;
        }
        if (id == R.id.action_play) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=ingenium%20BD&hl=en")));
            return true;
        }
        if (id == R.id.action_facebook) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ingeniumbd/")));
            return true;
        }
        if (id == R.id.action_twitter) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ingeniumbd4")));
            return true;
        }
        if (id == R.id.action_google) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/2/117505008096786718810")));
            return true;
        }
        if (id == R.id.action_youtube) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCvAaF5Lbe5KeFgiSIgY2M_w")));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fm = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_software) {
            fm.beginTransaction().replace(R.id.content_frame, new SoftwareDevelopment()).commit();
        } else if (id == R.id.nav_webdesign) {
            fm.beginTransaction().replace(R.id.content_frame, new WebDesign()).commit();
        } else if (id == R.id.nav_android) {
            fm.beginTransaction().replace(R.id.content_frame, new AndroidApps()).commit();
        } else if (id == R.id.nav_marketing) {
            fm.beginTransaction().replace(R.id.content_frame, new DigitalMarketing()).commit();
        } else if (id == R.id.nav_graphics) {
            fm.beginTransaction().replace(R.id.content_frame, new GraphicsDesign()).commit();
        } else if (id == R.id.nav_training) {
            fm.beginTransaction().replace(R.id.content_frame, new ItTreaning()).commit();
        } else if (id == R.id.nav_product) {
            fm.beginTransaction().replace(R.id.content_frame, new OurProduct()).commit();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
