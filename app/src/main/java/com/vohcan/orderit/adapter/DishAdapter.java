package com.vohcan.orderit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vohcan.orderit.DishListActivity;
import com.vohcan.orderit.R;
import com.vohcan.orderit.model.Dish;

import java.util.List;


public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {
    private List<Dish> items;
//    private DishListActivity.OnDishClickListener onDishClickListener;


    public static class DishViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageItem;
        public TextView descriptionItem;
        public TextView nameItem;
        public TextView priceItem;
        public ImageView allergen1Item;
        public ImageView allergen2Item;
        public ImageView allergen3Item;


        public DishViewHolder(View itemView) {
            super(itemView);
            imageItem = (ImageView) itemView.findViewById(R.id.dish_image);
            descriptionItem = (TextView) itemView.findViewById(R.id.dish_description);
            nameItem = (TextView) itemView.findViewById(R.id.dish_name);
            priceItem = (TextView) itemView.findViewById(R.id.dish_price);
            allergen1Item = (ImageView) itemView.findViewById(R.id.dish_allergen1_icon);
            allergen2Item = (ImageView) itemView.findViewById(R.id.dish_allergen2_icon);
            allergen3Item = (ImageView) itemView.findViewById(R.id.dish_allergen3_icon);

        }

        public View getView() {
            return getView();
        }
    }

    public DishAdapter(List<Dish> items){
        this.items = items;
//        this.onDishClickListener = onDishClickListener;
    }





//methods

    @Override
    public DishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dish_list, parent, false);
        return new DishViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DishViewHolder holder, final int position) {
        holder.imageItem.setImageResource(items.get(position).getDishImage());
        holder.descriptionItem.setText(items.get(position).getDescription());
        holder.nameItem.setText(items.get(position).getName());
        //holder.priceItem.setText(String.valueOf(items.get(position).getPrice()));
        holder.priceItem.setText(String.format("Precio: %.2f €",(items.get(position).getPrice())));
        holder.allergen1Item.setImageResource(items.get(position).getAlergen1());
        holder.allergen2Item.setImageResource(items.get(position).getAlergen2());
        holder.allergen3Item.setImageResource(items.get(position).getAlergen3());

//        holder.getView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onDishClickListener != null){
//                    onDishClickListener.onDishClick(position, items.get(position) );
//                }
//
//            }
//        });



    }



    @Override
    public int getItemCount() {
        return items.size();
    }


}
