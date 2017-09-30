package com.out.PrivateChatScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.out.MainActivity;
import com.out.PrivateChatSelectionScreen.PrivateChatSelectionScreen;
import com.out.R;

import java.util.Locale;

public class PrivateChatActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private static final String TAG = "PrivateChatActivity";
    PrivateChatActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    private String userNameToChatWith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_chat);

        Intent intent = getIntent();
        this.userNameToChatWith = intent.getStringExtra(MainActivity.EXTRA_DATA);

        mSectionsPagerAdapter = new PrivateChatActivity.SectionsPagerAdapter(getSupportFragmentManager(), userNameToChatWith);

        mViewPager = (ViewPager) findViewById(R.id.pageractivityprivatechat);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsactivityprivatechat);
        tabLayout.setupWithViewPager(mViewPager);

        getSupportActionBar().setTitle(R.string.privateChatBarTitle);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private String userNameToChatWith;

        public SectionsPagerAdapter(FragmentManager fm, String userNameToChatWith) {
            super(fm);
            this.userNameToChatWith = userNameToChatWith;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Chat();
                //case 1:
                //    return new PrivateChatSelectionScreen();
                default:
                    return PrivateChatActivity.PlaceholderFragment.newInstance(position + 1);
            }
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return this.userNameToChatWith;
                case 1:
                    return getString(R.string.title_section2privatechat).toUpperCase(l);
            }
            return null;
        }
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PrivateChatActivity.PlaceholderFragment newInstance(int sectionNumber) {
            PrivateChatActivity.PlaceholderFragment fragment = new PrivateChatActivity.PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_privatechat, container,
                    false);
            return rootView;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
