package com.bihu.xinwen.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bihu.xinwen.fragment.Fragment1;

/**
 * Created by luo on 2016/9/4.
 */
public class ContentViewPagerAdater extends FragmentPagerAdapter {
    private String[] titles;

    public ContentViewPagerAdater(FragmentManager fm) {
        super(fm);
        titles=new String[10];
        titles = new String[10];
        titles[0] = "推荐";
        titles[1] = "热点";
        titles[2] = "美女";
        titles[3] = "军事";
        titles[4] = "数码";
        titles[5] = "女人";
        titles[6] = "汽车";
        titles[7] = "哈哈";
        titles[8] = "哈哈";
        titles[9] = "哈哈";
    }

    @Override
    public Fragment getItem(int position) {

        return new Fragment1();
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
