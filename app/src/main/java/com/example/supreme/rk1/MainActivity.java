package com.example.supreme.rk1;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements RVAdapter.ItemClickListener{

    private RVAdapter rvAdapter;
    private FragmentManager manager;
    private FragmentTransaction fragmentTransaction;
    private RecyclerView recyclerView;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showRV();
    }

    private void showRV() {
        recyclerView.setVisibility(View.VISIBLE);
    }
    private void hideRV() {
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_result);
        manager = getSupportFragmentManager();

        ArrayList<String> arrayList = new ArrayList();
        for (Integer i = 1; i <= 1000; ++i) {
            arrayList.add(i.toString());
        }
        String[] data = arrayList.toArray(new String[arrayList.size()]);
        int columns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        rvAdapter = new RVAdapter(this, data);
        rvAdapter.setClickListener(this);
        recyclerView.setAdapter(rvAdapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putString("num", rvAdapter.getItem(position));
        if (position % 2 == 0) {
            bundle.putString("color", "blue");
        } else {
            bundle.putString("color", "default");
        }

        NumFragment numFragment = new NumFragment();
        numFragment.setArguments(bundle);
        fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.container, numFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        hideRV();
    }

}
