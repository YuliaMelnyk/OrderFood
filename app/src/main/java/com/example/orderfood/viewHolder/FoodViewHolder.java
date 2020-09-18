package
        com.example.orderfood.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfood.ItemClickListner;
import com.example.orderfood.R;

/**
 * @author yuliiamelnyk on 18/09/2020
 * @project OrderFood
 */
public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView foodName;
    public ImageView foodImage;

    private ItemClickListner mItemClickListner;

    public void setItemClickListner(ItemClickListner itemClickListner) {
        mItemClickListner = itemClickListner;
    }

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        foodName = itemView.findViewById(R.id.food_name);
        foodImage = itemView.findViewById(R.id.food_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mItemClickListner.onClick(view, getBindingAdapterPosition(), false);
    }
}
