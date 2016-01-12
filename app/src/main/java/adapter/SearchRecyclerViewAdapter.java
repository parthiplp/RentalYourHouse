package adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import house.rental.com.rentalyourhouse.R;
import house.rental.com.rentalyourhouse.SearchFragment;


/**
 * Created by nethaji.r on 06-01-2016.
 */
public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder>{
    ArrayList<String> myList;
    public static Activity activity;

    public SearchRecyclerViewAdapter(ArrayList<String> list,Activity activity) {
        this.myList = list;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageButton.setBackgroundResource(R.drawable.villa);
        holder.tv1.setText(myList.get(position));

    }


    @Override
    public int getItemCount() {
        return myList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv1;
        ImageButton imageButton;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.txt_search_name);
            imageButton = (ImageButton) itemView.findViewById(R.id.btn_search_item);
            imageButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
          //  TextView textView=(TextView)v;
            SearchFragment.layoutDeteils.setVisibility(View.VISIBLE);
            SearchFragment.layoutRow.setVisibility(View.GONE);
        }
    }
}
