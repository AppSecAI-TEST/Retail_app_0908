package com.example.fnspl.retail_app.Actvities.fragment;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;

import com.example.fnspl.retail_app.Actvities.adapter.MyCartAdapter;
import com.example.fnspl.retail_app.R;
import com.example.fnspl.retail_app.databinding.FragmentCartBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FNSPL on 8/8/2017.
 */

public class Mycart extends DialogFragment {

    private RecyclerView recyclerView;
    private MyCartAdapter adapter;
    private View v;
    private FragmentCartBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_cart,
                container,
                false);
        binding.setMycart(Mycart.this);
        //v = inflater.inflate(R.layout.fragment_cart,container , false);

        setStyle(DialogFragment.STYLE_NORMAL, R.style.fullscreen_dialog);

        List data = new ArrayList();

        data.add("Avocade");
        data.add("Orange");
        data.add("Kiwi");
        data.add("Manta");

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerGrocery.setLayoutManager(layoutManager);

        adapter = new MyCartAdapter(getActivity(),data);
        binding.recyclerGrocery.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onStart()
    {
        super.onStart();

        //setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //super.onCreateDialog(savedInstanceState);

        Dialog dialog = new Dialog(getActivity());
        final RelativeLayout root = new RelativeLayout(getActivity());
        root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(root);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        return dialog;
    }

    public void closeDialog(){
        dismiss();
    }
}
