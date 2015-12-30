package com.wisdomleaf.test.task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.wisdomleaf.test.task.R;
import com.wisdomleaf.test.task.dashboard.MainAdapter;
import com.wisdomleaf.test.task.tab.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        SlidingTabLayout tabs = (SlidingTabLayout) findViewById(R.id.dash_board_tabs);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.color_black);
            }
        });
        ViewPager pager = (ViewPager) findViewById(R.id.dash_board_viewpager);
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager(), context);
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_uninstall) {
            Uri packageUri = Uri.parse("package:com.wisdomleaf.test.task");
            Intent uninstallIntent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageUri);
            startActivity(uninstallIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
