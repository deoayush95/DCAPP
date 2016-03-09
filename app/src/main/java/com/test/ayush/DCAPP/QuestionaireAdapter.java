package com.test.ayush.DCAPP;

/**
 * Created by ayush on 1/3/16.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by mac on 19/06/15.
 */
public class QuestionaireAdapter extends FragmentStatePagerAdapter {

    int mNumberOfTabs;
    CharSequence mTitles[];

    public QuestionaireAdapter(FragmentManager fm, CharSequence titles[], int numberOfTabs) {
        super(fm);

        this.mTitles = titles;
        this.mNumberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new QuestionaireHospitalFragment();
            case 1:
                return new QuestionaireDoctorFragment();
            case 2:
                return new QuestionaireServiceFragment();
            case 3:
                return new QuestionaireCompleteFragment();
            default:
                return new QuestionaireCompleteFragment();
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}

