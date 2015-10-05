package com.torerov.customlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter mAdapter;

    int[] resIds = {R.drawable.puppy, R.drawable.rabbit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new MyAdapter();
        listView.setAdapter(mAdapter);
        mAdapter.setOnAdapterImageListener(new MyAdapter.OnAdapterImageListener() {
            @Override
            public void onAdapterImageClick(MyAdapter adapter, ItemView view, ItemData data) {
                Toast.makeText(MainActivity.this, "ItemData : " + data.title, Toast.LENGTH_SHORT).show();
            }
        });
//        mAdapter.setOnImageClickListener(new ItemView.OnImageClickListener() {
//            @Override
//            public void onImageClick(ItemView view, ItemData data) {
//                Toast.makeText(MainActivity.this, "ItemData : " + )
//            }
//        });

        initData();
    }

    private void initData() {
        for(int i=0; i<20; i++)
        {
            ItemData d = new ItemData();
            d.title = "Item Title : " + i;
            d.desc = "Item Desc : " + i;
            d.icon = getResources().getDrawable(resIds[i % resIds.length]);
            mAdapter.add(d);
        }
    }


}
