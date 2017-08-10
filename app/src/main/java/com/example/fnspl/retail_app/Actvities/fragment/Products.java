package com.example.fnspl.retail_app.Actvities.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fnspl.retail_app.Actvities.activity.ProductDetailActivity;
import com.example.fnspl.retail_app.Actvities.adapter.MyCartAdapter;
import com.example.fnspl.retail_app.Actvities.adapter.ProductAdapter;
import com.example.fnspl.retail_app.Actvities.widget.SpacesItemDecoration;
import com.example.fnspl.retail_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FNSPL on 8/8/2017.
 */

public class Products extends Fragment implements ProductAdapter.OnProductClickListener {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_product,container , false);

        List data = new ArrayList();

        data.add("Avocade");
        data.add("Orange");
        data.add("Kiwi");
        data.add("Manta");

        int spanCount = 2; // 3 columns
        int spacing = getResources().getDimensionPixelSize(R.dimen._10sdp);
        boolean includeEdge = true;

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_product);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spanCount, spacing, includeEdge));
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductAdapter(getActivity(),data);
        adapter.setOnProductClickListener(this);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onProductClick(int position) {
        getActivity().startActivity(new Intent(getActivity(), ProductDetailActivity.class));
    }
}
