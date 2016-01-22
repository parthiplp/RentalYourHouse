package house.rental.com.rentalyourhouse;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.RangeSeekBar;
import adapter.SearchRecyclerViewAdapter;
import adapter.WrapContentLinearLayoutManager;


public class SearchFragment extends Fragment {
    View v;
    ArrayList<String> myLists = new ArrayList<>();
    public static TextView txtMin, txtMax;
    public static LinearLayout layoutDeteils, layoutRow;
    Spinner spinnerRooms, spinnerFacing, spinnerOverLooking, overLookingOne, spinnerParking;
    ArrayList<String> listRooms, listFacing, listOverLooking, listOverLookingOne, listParking;
    Button btnSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.search_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        txtMin = (TextView) v.findViewById(R.id.txt_min);
        txtMax = (TextView) v.findViewById(R.id.txt_max);
        layoutDeteils = (LinearLayout) v.findViewById(R.id.layout_details);
        layoutRow = (LinearLayout) v.findViewById(R.id.layout_list);
        myLists.add("1BHK");
        myLists.add("2BHK");
        myLists.add("3BHK");
       // myLists.add("4BHK");
        myLists.add("Furnished");
        spinnerRooms = (Spinner) v.findViewById(R.id.spinner_rooms);
        spinnerFacing = (Spinner) v.findViewById(R.id.spinner_facing);
        spinnerOverLooking = (Spinner) v.findViewById(R.id.spinner_overlooking);
        overLookingOne = (Spinner) v.findViewById(R.id.spinner_overlooking_1);
        spinnerParking = (Spinner) v.findViewById(R.id.spinner_parking);
        btnSearch = (Button) v.findViewById(R.id.btn_search);
        listRooms = new ArrayList<>();
        listFacing = new ArrayList<>();
        listOverLooking = new ArrayList<>();
        listOverLookingOne = new ArrayList<>();
        listParking = new ArrayList<>();
        listRooms.add("1BHK");
        listRooms.add("2BHK");
        listRooms.add("3BHK");

        listFacing.add("East");
        listFacing.add("West");
        listFacing.add("North");
        listFacing.add("South");

        listOverLooking.add("Garden");
        listOverLooking.add("Park");

        listOverLookingOne.add("Garden");
        listOverLookingOne.add("Park");

        listParking.add("2 Wheeler");
        listParking.add("4 Wheeler");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_list, listRooms);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRooms.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), R.layout.spinner_list, listFacing);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFacing.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), R.layout.spinner_list, listOverLooking);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOverLooking.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getActivity(), R.layout.spinner_list, listOverLookingOne);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        overLookingOne.setAdapter(adapter3);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(getActivity(), R.layout.spinner_list, listParking);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerParking.setAdapter(adapter4);

        SearchRecyclerViewAdapter recyclerViewAdapter = new SearchRecyclerViewAdapter(myLists, getActivity());
       /* LinearLayoutManager llm = new LinearLayoutManager(getActivity());*/
        WrapContentLinearLayoutManager llm = new WrapContentLinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(llm);
   /*     recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                try {
                    RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
                    params.width = parent.getWidth()/2;
                    view.setLayoutParams(params);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });*/
        recyclerView.setAdapter(recyclerViewAdapter);

        RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<>(getActivity());

        // Set the range
        rangeSeekBar.setRangeValues(1000, 2000);
        rangeSeekBar.setSelectedMinValue(1000);
        rangeSeekBar.setSelectedMaxValue(10000);

        // Add to layout
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.seekbar_placeholder);
        layout.addView(rangeSeekBar);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchResultActivity.class);
                startActivity(intent);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        layoutDeteils.setVisibility(View.GONE);
                        layoutRow.setVisibility(View.VISIBLE);
                    }
                }, 2000);

            }
        });

        return v;
    }

}
