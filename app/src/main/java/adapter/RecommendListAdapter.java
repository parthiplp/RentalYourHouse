package adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import house.rental.com.rentalyourhouse.R;
import models.SearchResultModel;

/**
 * Created by BSILIND\parthiban.m on 7/1/16.
 */
public class RecommendListAdapter extends RecyclerView.Adapter<RecommendListAdapter.ViewHolder> {

    List<SearchResultModel> list;
    Context con;
    LayoutInflater inflater;
    Typeface tfl;
    public RecommendListAdapter(List<SearchResultModel> list, Context con) {
        this.list=list;
        this.con=con;
        inflater=LayoutInflater.from(con);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recommendlist, parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.price.setTypeface(tfl);
        holder.price.setText("`");
        holder.price.append(list.get(position).getPricel());
        holder.address.setText(list.get(position).getHouseaddress());
        holder.detail.setText(list.get(position).getHousedetail());
        holder.status.setText(list.get(position).getHousestatus());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView houseimage;
        TextView price;
        TextView address;
        TextView detail;
        TextView status;
        public ViewHolder(View v) {
            super(v);
            houseimage=(ImageView) v.findViewById(R.id.rehouseimage);
            price=(TextView) v.findViewById(R.id.reprice);
            address=(TextView) v.findViewById(R.id.rehouseaddress);
            detail=(TextView) v.findViewById(R.id.rehousedetail);
            status=(TextView) v.findViewById(R.id.rehousestatus);
            tfl = Typeface.createFromAsset(con.getAssets(), "Rupee_Foradian.ttf");
        }
    }
}
