package com.example.fnspl.retail_app.Actvities.fragment;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fnspl.retail_app.Actvities.activity.DashboardActivity;
import com.example.fnspl.retail_app.Actvities.widget.ExpendableGridView;
import com.example.fnspl.retail_app.R;
import com.example.fnspl.retail_app.databinding.FragmentHomeBinding;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final int NUM_PAGES = 5;
    private View mView;
    private Timer timer;
    private int currentPage=0;
    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_home,
                container,
                false);
        binding.setHome(HomeFragment.this);
        mView = binding.getRoot();
        init(mView);
        return mView;
    }

    private void init(View mView) {
        binding.gridProfession.setExpanded(true);

        MyViewPagerAdapter mAdapter = new MyViewPagerAdapter();
        binding.vpSpecialOffer.setAdapter(mAdapter);

        binding.vpSpecialOffer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        CategoryAdapter mCategoryAdapter = new CategoryAdapter(getActivity());
        binding.gridProfession.setAdapter(mCategoryAdapter);

        timer();
    }

    private void timer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage == NUM_PAGES - 1) {
                            currentPage = 0;
                        }
                        binding.vpSpecialOffer.setCurrentItem(currentPage++, true);
                    }
                });
            }
        }, 500, 1000);
    }

    @Override
    public void onStop() {
        super.onStop();

        if(timer!=null){
            timer.cancel();
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;
        private List<String> items;

        public MyViewPagerAdapter() {

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.item_slider_activity, container,false);

            LinearLayout slider = (LinearLayout)view.findViewById(R.id.ll_slider);
            ImageView iv_slide_image = (ImageView) view.findViewById(R.id.iv_slide_image);


            ((ViewPager) container).addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == ((View)obj);
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View)object;
            ((ViewPager) container).removeView(view);
        }

        public void notifyDataChange(List<String> listOfItems) {
            this.items = listOfItems;
            notifyDataSetChanged();
        }
    }

    public class CategoryAdapter extends BaseAdapter {
        private Context mContext;

        // Constructor
        public CategoryAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return 9;
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
                grid = inflater.inflate(R.layout.grid_single, null);
            } else {
                grid = (View) convertView;
            }

            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            RelativeLayout rl_category = (RelativeLayout) grid.findViewById(R.id.rl_category);

            rl_category.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DashboardActivity)getActivity()).setFragment(new Products(),"producFragment");
                }
            });

            return grid;
        }
    }
}
