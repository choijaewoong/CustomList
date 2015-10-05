package com.torerov.customlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2015-10-05.
 */
public class MyAdapter extends BaseAdapter implements ItemView.OnImageClickListener {

    List<ItemData> items = new ArrayList<ItemData>();

    public interface OnAdapterImageListener{
        public void onAdapterImageClick(MyAdapter adapter, ItemView view, ItemData data);
    }
    OnAdapterImageListener mListener;
    public void setOnAdapterImageListener(OnAdapterImageListener listener){
        mListener = listener;
    }

    ItemView.OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(ItemView.OnImageClickListener listener){
        mImageClickListener = listener;
        notifyDataSetChanged();
        notifyDataSetInvalidated(); //데이터 변경 없어도 다시 알림
    }

    public void add(ItemData item){
        items.add(item);
        notifyDataSetChanged(); //데이터 변경을 알림
    }

//    Context mContext;
//    public MyAdapter(Context Context) {
//        mContext = Context;
//    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView view; //= new ItemView(parent.getContext());
        if(convertView == null){
            view = new ItemView(parent.getContext());
            view.setOnImageClickListener(this);
        }else{
            view = (ItemView)convertView;
        }
        //view.setOnImageClickListener(mImageClickListener);
        view.setItemData(items.get(position));
        return view;
    }

    @Override
    public void onImageClick(ItemView view, ItemData data) {
        if (mListener != null) {
            mListener.onAdapterImageClick(this, view, data);
        }
    }
}
