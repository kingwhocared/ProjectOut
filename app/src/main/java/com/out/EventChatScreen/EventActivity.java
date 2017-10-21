package com.out.EventChatScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.out.MainActivity;
import com.out.PrivateChatScreen.Chat;
import com.out.R;

import org.w3c.dom.Text;

import java.util.Locale;

public class EventActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private static final String TAG = "EventChatActivity";
    EventActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    private String eventName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent intent = getIntent();
        this.eventName = intent.getStringExtra(MainActivity.EXTRA_DATA);

        mSectionsPagerAdapter = new EventActivity.SectionsPagerAdapter(getSupportFragmentManager(), eventName);

        mViewPager = (ViewPager) findViewById(R.id.pageractivityevent);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsactivityevent);
        tabLayout.setupWithViewPager(mViewPager);

        getSupportActionBar().setTitle(R.string.eventBarTitle);

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
        private String eventName;

        public SectionsPagerAdapter(FragmentManager fm, String eventName) {
            super(fm);
            this.eventName = eventName;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return Event.getInstance();
                case 1:
                    return EventInfo.getInstance();
                default:
                    return EventActivity.PlaceholderFragment.newInstance(position + 1);
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
                    return this.eventName;
                case 1:
                    return getString(R.string.title_section2event).toUpperCase(l);
            }
            return null;
        }
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static EventActivity.PlaceholderFragment newInstance(int sectionNumber) {
            EventActivity.PlaceholderFragment fragment = new EventActivity.PlaceholderFragment();
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


    public void onAcceptVote(View view) {
        ((CheckBox) (findViewById(R.id.declineVoteCheckBox))).setChecked(false);
        setVoteStatus("5/9");
    }

    public void onDeclineVote(View view) {
        ((CheckBox) (findViewById(R.id.acceptVoteCheckBox))).setChecked(false);
        setVoteStatus("3/9");

    }

    private void setVoteStatus(String str) {
        ((TextView) (findViewById(R.id.voteStatus))).setText(str);
    }

    private void onLocationNewVote(View view) {
    }
}
