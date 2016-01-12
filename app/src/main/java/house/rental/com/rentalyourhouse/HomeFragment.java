package house.rental.com.rentalyourhouse;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


/**
 * Created by nethaji.r on 05-01-2016.
 */
public class HomeFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        View v = inflater.inflate(R.layout.home_fragment, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();
        // latitude and longitude
        ArrayList<LocationModel> list = new ArrayList<>();
        LocationModel model = new LocationModel();
        model.setLat("13.0650858");
        model.setLon("80.2711479");
        model.setPlace("1BHK");
        list.add(model);
        model = new LocationModel();
        model.setLat("13.0610726");
        model.setLon("80.2708475");
        model.setPlace("2BHK");
        list.add(model);
        model = new LocationModel();
        model.setLat("13.053544");
        model.setLon("80.2514631");
        model.setPlace("3BHK");
        list.add(model);
        model = new LocationModel();
        model.setLat("13.0438865");
        model.setLon("80.2477723");
        model.setPlace("4BHK");
        list.add(model);
        for (LocationModel locationModel:list) {


            double latitude =Double.valueOf(locationModel.getLat());
            double longitude = Double.valueOf(locationModel.getLon());

            // create marker
            MarkerOptions marker = new MarkerOptions().position(
                    new LatLng(latitude, longitude)).title(locationModel.getPlace());

            // Changing marker icon
            marker.icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

            // adding marker
            googleMap.addMarker(marker);

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(latitude, longitude)).zoom(12).build();
            googleMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));
        }
        // Perform any camera updates here
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}





