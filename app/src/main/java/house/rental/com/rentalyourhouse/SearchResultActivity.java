package house.rental.com.rentalyourhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity {

    List<SearchResultModel> list=new ArrayList<>();
    RecyclerView search_list;
    SearchResultAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.delete);


        search_list = (RecyclerView) findViewById(R.id.searchlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(SearchResultActivity.this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        search_list.setLayoutManager(layoutManager);
        SearchResultModel model=new SearchResultModel();
        model.setHouseaddress("5361 Augusta Drive Frederick,MD 21710");
        model.setHousedetail("1200 Sqft -Villa ");
        model.setHousestatus("Ready to Move");
        model.setPhoneno("9688624572");
        model.setPricel("$ 4000 - 5000");
        list.add(model);
        model=new SearchResultModel();
        model.setHouseaddress("5361 Augusta Drive Frederick,MD 21710");
        model.setHousedetail("1200 Sqft -Villa ");
        model.setHousestatus("Possession to March 2016");
        model.setPhoneno("9688624572");
        model.setPricel("$ 4000 - 5000");
        list.add(model);
        model=new SearchResultModel();
        model.setHouseaddress("5361 Augusta Drive Frederick,MD 21710");
        model.setHousedetail("1200 Sqft -Villa ");
        model.setHousestatus("Ready to Move");
        model.setPhoneno("9688624572");
        model.setPricel("$ 4000 - 5000");
        list.add(model);
        model=new SearchResultModel();
        model.setHouseaddress("5361 Augusta Drive Frederick,MD 21710");
        model.setHousedetail("1200 Sqft -Villa ");
        model.setHousestatus("Possession to March 2016");
        model.setPhoneno("9688624572");
        model.setPricel("$ 4000 - 5000");
        list.add(model);
        model=new SearchResultModel();
        model.setHouseaddress("5361 Augusta Drive Frederick,MD 21710");
        model.setHousedetail("1200 Sqft -Villa ");
        model.setHousestatus("Ready to Move");
        model.setPhoneno("9688624572");
        model.setPricel("$ 4000 - 5000");
        list.add(model);
        adapter=new SearchResultAdapter(list,SearchResultActivity.this);
        search_list.setAdapter(adapter);
    }

}
