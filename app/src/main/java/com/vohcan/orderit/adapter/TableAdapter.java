package com.vohcan.orderit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vohcan.orderit.R;
import com.vohcan.orderit.model.Table;


public class TableAdapter extends BaseAdapter {

    private Context context;

//constructor

    public TableAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Table.items.length;
    }

    @Override
    public Table getItem(int position) {
        return Table.items[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view ==null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        TextView nameTable = (TextView) view.findViewById(R.id.table_name);
        ImageView imgTable = (ImageView) view.findViewById(R.id.image_bg);

        final Table item = getItem(position);
        imgTable.setImageResource(item.getidDrawable());
        nameTable.setText(item.getName());

        return view;
    }

}
