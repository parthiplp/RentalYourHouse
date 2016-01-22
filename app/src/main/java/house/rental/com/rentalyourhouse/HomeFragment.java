package house.rental.com.rentalyourhouse;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import models.LocationModel;


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
  /*      model = new LocationModel();
        model.setLat("13.0610726");
        model.setLon("80.2708475");
        model.setPlace("2BHK");
        list.add(model);*/
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


        for (LocationModel locationModel : list) {


            double latitude = Double.valueOf(locationModel.getLat());
            double longitude = Double.valueOf(locationModel.getLon());
            /*  float[] results = new float[1];
          Location.distanceBetween(13.0610726, 80.2708475, latitude, longitude, results);
            float distanceInMeters = results[0];
            boolean isWithin2km = distanceInMeters < 5000;*/

            // create marker
      /*      MarkerOptions marker = new MarkerOptions().position(
                    new LatLng(latitude, longitude)).title(locationModel.getPlace());*/

            Marker marker = googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(latitude, longitude))
                    .title(locationModel.getPlace()));
            marker.setTitle(locationModel.getPlace());
            marker.showInfoWindow();
            // Changing marker icon
                /*marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));*/
            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location));


            // aisible(tit)dding marker
          //  googleMap.addMarker(marker);
/*
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(latitude, longitude)).zoom(12).build();
            googleMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));*/

        }
        drawCurrentLocation();

        // Perform any camera updates here

        return v;
    }

    private void drawCurrentLocation() {
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(13.0610726, 80.2708475));

        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.my_location));
        googleMap.addMarker(marker);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(13.0610726, 80.2708475)).zoom(12).build();

        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        Circle circle = googleMap.addCircle(new CircleOptions()
                .center(new LatLng(13.0610726, 80.2708475)).radius(3000).fillColor(Color.WHITE).strokeColor(Color.WHITE));
        circle.setVisible(true);
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





