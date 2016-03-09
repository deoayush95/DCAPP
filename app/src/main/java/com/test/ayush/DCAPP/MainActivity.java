package com.test.ayush.DCAPP;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.test.ayush.DCAPP.slidingtab.SlidingTabLayout;

import java.util.List;

public class MainActivity extends FragmentActivity {

    public static LinearLayout linearLayout;

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private CharSequence[] tabTitles = {"HOSPITAL", "DOCTOR", "SERVICE", "COMPLETE"};
    private int numberOfTabs = 4;
    private Spinner spinner;
    private QuestionaireAdapter questionaireAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setbottomlayout();
        createViewPager();
        createSlidingTabs();
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    private void setbottomlayout() {
        linearLayout = (LinearLayout) findViewById(R.id.spinner_layout);
        LinearLayout mLinearLayout = MainActivity.linearLayout;

        spinner = (Spinner) mLinearLayout.findViewById(R.id.questionaire_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hospital_section_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                int item = spinner.getSelectedItemPosition();
                /*item = 2;
                Fragment mFragment = getVisibleFragment();
                Fragment fragment = new QuestionaireDoctorFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(mFragment.getId(), fragment);
                transaction.commit();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });
    }

    private void createSlidingTabs() {
        // Assign the Sliding Tab Layout View
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tab_questionaire);
        mSlidingTabLayout.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.white);
            }
        });
    }

    private void createViewPager() {
        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        questionaireAdapter =  new QuestionaireAdapter(getSupportFragmentManager(), tabTitles, numberOfTabs);

        // Assigning ViewPager View and setting the adapter
        mViewPager = (ViewPager) findViewById(R.id.view_pager_questionaire);
        mViewPager.setAdapter(questionaireAdapter);
    }

    public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if(fragments != null){
            for(Fragment fragment : fragments){
                if(fragment != null && fragment.isVisible())
                    return fragment;
            }
        }
        return null;
    }
}