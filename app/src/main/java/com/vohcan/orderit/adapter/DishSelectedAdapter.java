package com.vohcan.orderit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vohcan.orderit.R;
import com.vohcan.orderit.model.SelectedDish;

import java.util.List;



public class DishSelectedAdapter extends RecyclerView.Adapter<DishSelectedAdapter.SelectedViewHolder> {

    private List<SelectedDish> dishSelected;

    public static class SelectedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageSelected;
        public TextView nameSelected;
        public TextView priceSelected;
        public TextView complementSelected;


        public SelectedViewHolder(View itemView)  {
            super(itemView);
            imageSelected = (ImageView) itemView.findViewById(R.id.selected_image);
            nameSelected = (TextView) itemView.findViewById(R.id.selected_name);
            priceSelected = (TextView) itemView.findViewById(R.id.selected_price);
            complementSelected = (TextView) itemView.findViewById(R.id.selected_complement);

        }

        @Override
        public void onClick(View v) {
            //que salga alert dialog
            int position = getLayoutPosition();
        }
    }



//construnctor
    public DishSelectedAdapter(List<SelectedDish> dishSelected) {
        this.dishSelected = dishSelected;
    }
//methods
    @Override
    public DishSelectedAdapter.SelectedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_dish_list, parent, false);
        return new SelectedViewHolder(view);

    }

    @Override
    public void onBindViewHolder(DishSelectedAdapter.SelectedViewHolder holder, int position) {

        holder.imageSelected.setImageResource(dishSelected.get(position).getImageSelected());
        holder.nameSelected.setText(dishSelected.get(position).getNameSelected());
        holder.priceSelected.setText(String.format("Precio: %.2f €",(dishSelected.get(position).getPriceSelected())));
        holder.complementSelected.setText(dishSelected.get(position).getComplementSelected());

    }

    @Override
    public int getItemCount() {
        return dishSelected.size();
    }
}
