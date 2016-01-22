package house.rental.com.rentalyourhouse;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.RecommendListAdapter;
import models.SearchResultModel;

public class SearchResultDetail extends AppCompatActivity {
    List<SearchResultModel> list=new ArrayList<>();
    RecyclerView search_list;
    RecommendListAdapter adapter;
    Typeface tfl;
    TextView detailprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result_detail);
        search_list = (RecyclerView) findViewById(R.id.recommedlist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detailtoolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.delete);

        tfl = Typeface.createFromAsset(getAssets(), "Rupee_Foradian.ttf");
        TextView title=(TextView) toolbar.findViewById(R.id.tooltext);
        title.setTypeface(tfl);
        title.setText("`");
        title.append(" 4000 - 5000 1200sqft-villa");

        detailprice=(TextView)findViewById(R.id.detailprice);
        detailprice.setTypeface(tfl);
        detailprice.setText("`");
        detailprice.append(" 4000 - 5000");

        LinearLayoutManager layoutManager = new LinearLayoutManager(SearchResultDetail.this);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        search_list.setLayoutManager(layoutManager);

        SearchResultModel model=new SearchResultModel();
        model.setHouseaddress("5361 Augusta Drive Frederick,MD 21710");
        model.setHousedetail("1200 Sqft -Villa ");
        model.setHousestatus("Ready to Move");
        model.setPhoneno("9688624572");
        model.setPricel(" 4000 - 5000 1200 Sqft -Villa");
        list.add(model);

        model=new SearchResultModel();
        model.setHouseaddress("5361 Augusta Drive Frederick,MD 21710");
        model.setHousedetail("1200 Sqft -Villa ");
        model.setHousestatus("Possession to March 2016");
        model.setPhoneno("9688624572");
        model.setPricel(" 4000 - 5000");
        list.add(model);

        model=new SearchResultModel();
        model.setHouseaddress("5361 Augusta Drive Frederick,MD 21710");
        model.setHousedetail("1200 Sqft -Villa ");
        model.setHousestatus("Ready to Move");
        model.setPhoneno("9688624572");
        model.setPricel(" 4000 - 5000");
        list.add(model);

        model=new SearchResultModel();
        model.setHouseaddress("5361 Augusta Drive Frederick,MD 21710");
        model.setHousedetail("1200 Sqft -Villa ");
        model.setHousestatus("Possession to March 2016");
        model.setPhoneno("9688624572");
        model.setPricel(" 4000 - 5000");
        list.add(model);

        model=new SearchResultModel();
        model.setHouseaddress("5361 Augusta Drive Frederick,MD 21710");
        model.setHousedetail("1200 Sqft -Villa ");
        model.setHousestatus("Ready to Move");
        model.setPhoneno("9688624572");
        model.setPricel(" 4000 - 5000");
        list.add(model);
        adapter=new RecommendListAdapter(list,SearchResultDetail.this);
        search_list.setAdapter(adapter);
    }

}
