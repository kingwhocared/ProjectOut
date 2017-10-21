package com.out;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.Locale;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.out.EventChatScreen.EventActivity;
import com.out.EventSelectionScreen.EventSelectable;
import com.out.EventSelectionScreen.EventSelectionScreen;
import com.out.MessagesContentView.ChatMessage;
import com.out.PrivateChatScreen.PrivateChatActivity;
import com.out.PrivateChatSelectionScreen.PrivateChatSelectionScreen;
import com.out.TestFragment.TestStuffFragment;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    private static final String TAG = "MainActivity";
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = FirebaseInstanceId.getInstance().getToken();
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbaractivitymain);
        //setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pageractivitymain);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsactivitymain);
        tabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(this, PrivateChatActivity.class);
        startActivity(intent);

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TestStuffFragment();
                case 1:
                    return new EventSelectionScreen();
                case 2:
                    return new PrivateChatSelectionScreen();
                default:
                    return PlaceholderFragment.newInstance(position + 1);
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1mainmenu).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2mainmenu).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3mainmenu).toUpperCase(l);
            }
            return null;
        }
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
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
            View rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);
            return rootView;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static final String EXTRA_DATA = "";

    public void onChatSelected(View view) {
        String selected;
        Class newActivity = null;
        selected = ((TextView) (view.findViewById(R.id.contact_selectable_name))).getText().toString();
        newActivity = PrivateChatActivity.class;

        Intent intent = new Intent(MainActivity.this, newActivity);
        intent.putExtra(EXTRA_DATA, selected);
        startActivity(intent);
    }

    public void onEventSelected(View view) {
        if (true) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            //Bundle bundle = new Bundle();
            //bundle.putSerializable(EXTRA_USER_ID, FirebaseInstanceId.getInstance().getToken());
            startActivity(intent);
        }
        String selected;
        Class newActivity = null;
        selected = ((TextView) (view.findViewById(R.id.event_selectable_name))).getText().toString();
        newActivity = EventActivity.class;

        Intent intent = new Intent(MainActivity.this, newActivity);
        intent.putExtra(EXTRA_DATA, selected);
        startActivity(intent);
    }

    public void onTestButtonClick(View view) {
    }

}