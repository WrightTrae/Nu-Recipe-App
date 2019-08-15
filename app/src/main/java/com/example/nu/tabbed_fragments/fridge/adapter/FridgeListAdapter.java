package com.example.nu.tabbed_fragments.fridge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nu.R;
import com.example.nu.models.FridgeItem;

import java.util.ArrayList;

public class FridgeListAdapter extends BaseAdapter {
    // BASE ID
    private static final long BASE_ID = 0x100000;

    // Reference to our owning screen (context)
    private final Context mContext;

    // Reference to our collection
    private final ArrayList<FridgeItem> fridgeItems;

    // C-tor
    public FridgeListAdapter(Context _context, ArrayList<FridgeItem> _items){
        mContext = _context;
        fridgeItems = _items;
    }

    // Count
    public int getCount(){
        if(fridgeItems !=null) {
            return fridgeItems.size();
        }
        return 0;
    }

    // Item
    public Object getItem(int _position){
        if(fridgeItems !=null) {
            return fridgeItems.get(_position);
        }
        return null;
    }



    // Item ID
    public long getItemId(int _position){
        return BASE_ID + _position;
    }

    // Get the inflated child / line-item view
    public View getView(int _position, View _recycleView, ViewGroup _parentView){
        ViewHolder vh;
        if(_recycleView == null) {
            _recycleView = LayoutInflater.from(mContext).inflate(R.layout.fridge_list_adapter, _parentView, false);
            vh = new ViewHolder(_recycleView);
            _recycleView.setTag(vh);
        }else{
            vh = (ViewHolder) _recycleView.getTag();
        }
        FridgeItem item = (FridgeItem) getItem(_position);
        if(item!=null){
            vh.tvName.setText(item.getName());
        }
        return _recycleView;
    }

    static class ViewHolder{
        final TextView tvName;

        private ViewHolder(View _layout){
            tvName = _layout.findViewById(R.id.fridgeItemName);
        }
    }
}
