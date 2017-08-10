package com.example.fnspl.retail_app.Actvities.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fnspl.retail_app.Actvities.fragment.HomeFragment;
import com.example.fnspl.retail_app.Actvities.fragment.Mycart;
import com.example.fnspl.retail_app.Actvities.fragment.Products;
import com.example.fnspl.retail_app.R;
import com.example.fnspl.retail_app.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;
    private ForYouAdapter mAdapter;
    private BrowseAdapter mBrowseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        binding.setActivity(DashboardActivity.this);

        List<String> forYouList = new ArrayList<>();
        forYouList.add("Recommendation");
        forYouList.add("New");
        forYouList.add("Special");
        List<String> browseList = new ArrayList<>();
        browseList.add("Baby");
        browseList.add("Baking");
        browseList.add("Breakfast");
        browseList.add("Drinks");
        browseList.add("Health");
        browseList.add("Fruit");
        browseList.add("Vegetables");

        mAdapter = new ForYouAdapter(this, forYouList);
        mBrowseAdapter = new BrowseAdapter(this, browseList);

        binding.rvForYou.setAdapter(mAdapter);
        binding.rvBrowse.setAdapter(mBrowseAdapter);

        setFragment(new HomeFragment(), "homeFragment");
    }

    public void openDrawerOnClick() {
        if (!binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    public void setFragment(Fragment fragment, String fragmentName) {
        android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.fragment_container, fragment);
        if(getSupportFragmentManager().getBackStackEntryCount()<2) {
            t.addToBackStack(fragmentName);
        }
        t.commit();
    }

    public void showCart() {
        Mycart mDialogCart = new Mycart();
        mDialogCart.show(getSupportFragmentManager(), "Cart");
    }

    public void logout(){
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }

        startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            int fragments = getSupportFragmentManager().getBackStackEntryCount();
            if (fragments == 1) {
                finish();
            } else {
                if (getFragmentManager().getBackStackEntryCount() > 1) {
                    getFragmentManager().popBackStack();
                } else {
                    super.onBackPressed();
                }
            }
        }
    }

    public class ForYouAdapter extends BaseAdapter {
        private Context mContext;
        private List<String> mList;

        // Constructor
        public ForYouAdapter(Context c, List<String> mList) {
            mContext = c;
            this.mList = mList;
        }

        public int getCount() {
            return mList.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            View grid;
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {
                grid = new View(mContext);
                grid = inflater.inflate(R.layout.drawer_single, null);
            } else {
                grid = (View) convertView;
            }

            LinearLayout rl_category = (LinearLayout) grid.findViewById(R.id.rl_item);
            TextView tv_name = (TextView) grid.findViewById(R.id.tv_name);

            tv_name.setText(mList.get(position));

            rl_category.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    setFragment(new Products(),"producFragment");
                }
            });

            return grid;
        }
    }

    public class BrowseAdapter extends BaseAdapter {
        private Context mContext;
        private List<String> mList;

        // Constructor
        public BrowseAdapter(Context c, List<String> mList) {
            mContext = c;
            this.mList = mList;
        }

        public int getCount() {
            return mList.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            View grid;
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {
                grid = new View(mContext);
                grid = inflater.inflate(R.layout.drawer_single, null);
            } else {
                grid = (View) convertView;
            }

            LinearLayout rl_category = (LinearLayout) grid.findViewById(R.id.rl_item);
            TextView tv_name = (TextView) grid.findViewById(R.id.tv_name);

            tv_name.setText(mList.get(position));

            rl_category.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    setFragment(new Products(),"producFragment");
                }
            });

            return grid;
        }
    }
}
