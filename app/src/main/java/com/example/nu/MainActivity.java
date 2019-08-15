package com.example.nu;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.nu.tabbed_fragments.fridge.FridgeFragment;
import com.example.nu.tabbed_fragments.ListFragment;
import com.example.nu.tabbed_fragments.RecipesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    // Tab Bar Components
    private FrameLayout mFrameLayout;
    private ListFragment mListFrag;
    private final String LIST_FRAG_TAG = "LIST_FRAG_TAG";
    private FridgeFragment mFridgeFrag;
    private final String FRIDGE_FRAG_TAG = "FRIDGE_FRAG_TAG";
    private RecipesFragment mRecipesFrag;
    private final String RECIPES_FRAG_TAG = "RECIPES_FRAG_TAG";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFrag;
            String selectedTag;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(mListFrag == null){
                        mListFrag = ListFragment.newInstance("","");
                    }
                    selectedFrag = mListFrag;
                    selectedTag = LIST_FRAG_TAG;
                    break;
                case R.id.navigation_dashboard:
                    if(mFridgeFrag == null){
                        mFridgeFrag = FridgeFragment.newInstance("","");
                    }
                    selectedFrag = mFridgeFrag;
                    selectedTag = FRIDGE_FRAG_TAG;
                    break;
                case R.id.navigation_notifications:
                    if(mRecipesFrag == null){
                        mRecipesFrag = RecipesFragment.newInstance("","");
                    }
                    selectedFrag = mRecipesFrag;
                    selectedTag = RECIPES_FRAG_TAG;
                    break;
                default:
                    selectedFrag = null;
                    selectedTag = null;
                    break;
            }
            Log.i("asd", "onNavigationItemSelected: "+ selectedTag);
            if(selectedFrag != null){
                if(getSupportFragmentManager().findFragmentByTag(selectedTag) == selectedFrag) {
                    getSupportFragmentManager().beginTransaction().show(selectedFrag).commit();
                }else{
                    getSupportFragmentManager().beginTransaction().replace(mFrameLayout.getId(), selectedFrag, selectedTag).commit();
                }
                return true;
            }else {
                return false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrameLayout = findViewById(R.id.tab_frame);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
