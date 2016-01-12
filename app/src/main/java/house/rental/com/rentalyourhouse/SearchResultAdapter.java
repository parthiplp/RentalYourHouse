package house.rental.com.rentalyourhouse;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BSILIND\parthiban.m on 6/1/16.
 */
public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

    List<SearchResultModel> list;
    Context con;
    LayoutInflater inflater;
    public SearchResultAdapter(List<SearchResultModel> list,Context con) {
        this.list=list;
        this.con=con;
        inflater=LayoutInflater.from(con);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_search_result_adapter, parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.price.setText(list.get(position).getPricel());
        holder.address.setText(list.get(position).getHouseaddress());
        holder.detail.setText(list.get(position).getHousedetail());
        holder.status.setText(list.get(position).getHousestatus());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(con,SearchResultDetail.class);
                con.startActivity(i);
            }
        });
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
        TextView callagent;
        View view;
        public ViewHolder(View v) {
            super(v);
            view=v;
            houseimage=(ImageView) v.findViewById(R.id.houseimage);
            price=(TextView) v.findViewById(R.id.price);
            address=(TextView) v.findViewById(R.id.houseaddress);
            detail=(TextView) v.findViewById(R.id.housedetail);
            status=(TextView) v.findViewById(R.id.housestatus);
            callagent=(TextView) v.findViewById(R.id.callowner);
        }
    }
}
