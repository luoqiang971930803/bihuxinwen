package com.bihu.xinwen.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bihu.xinwen.R;
import com.bihu.xinwen.adapter.ContentViewPagerAdater;

import java.net.URLEncoder;

public class MainActivity extends FragmentActivity {
     private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView na_view;
    private TabLayout tab_layout;
    private ViewPager view_pager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout= (DrawerLayout) findViewById(R.id.draw_layout);
        na_view= (NavigationView) findViewById(R.id.na_view);
        toolbar= (Toolbar) findViewById(R.id.tool_bar);
        tab_layout= (TabLayout) findViewById(R.id.tab_layout);
        view_pager= (ViewPager) findViewById(R.id.view_pager);
        toolbar.setNavigationIcon(R.drawable.ic_drawer_home);
        toolbar.setLogo(R.drawable.ic_drawer_home);
        toolbar.setTitle("主");
        toolbar.setSubtitle("副");
        toolbar.inflateMenu(R.menu.toolbar_menu);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        na_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setCheckable(true);
                String title=item.getTitle().toString();
                Toast.makeText(MainActivity.this,title,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
       ContentViewPagerAdater pagerAdater=new ContentViewPagerAdater(getSupportFragmentManager());
        view_pager.setAdapter(pagerAdater);
        tab_layout.setupWithViewPager(view_pager);
    }
}
