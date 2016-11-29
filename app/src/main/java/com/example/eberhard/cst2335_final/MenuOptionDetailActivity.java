package com.example.eberhard.cst2335_final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class MenuOptionDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(ACTIVITY_NAME, "In onCreateView()");
        setContentView(R.layout.activity_menu_option_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null){
            Bundle bundle = new Bundle();
            bundle.putString(MenuOptionDetailFragment.ITEM_ID, getIntent().getStringExtra(MenuOptionDetailFragment.ITEM_ID));
            MenuOptionDetailFragment fragment = new MenuOptionDetailFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(R.id.option_detail_container, fragment, AUTO_FRAGMENT).commit();
        }else{
            MenuOptionDetailFragment fragment = (MenuOptionDetailFragment) getSupportFragmentManager().getFragment(savedInstanceState, AUTO_FRAGMENT);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedState){
        super.onSaveInstanceState(savedState);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Log.i(ACTIVITY_NAME, "In onOptionsItemSelected()");
        return super.onOptionsItemSelected(item);
    }

    protected static final String ACTIVITY_NAME = "DetailActivity";
    protected static final String AUTO_FRAGMENT = "auto_fragment";

}
