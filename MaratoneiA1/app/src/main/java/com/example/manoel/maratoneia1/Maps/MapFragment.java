package com.example.manoel.maratoneia1.Maps;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dataMovie.manoel.maratoneia1.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.Permissions;
import java.util.zip.Inflater;

public class MapFragment extends Fragment implements OnMapReadyCallback
        , GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    private MapView mapView;
    private GoogleMap googleMap;
    private String[] permissions = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private LocationManager locationManager;
    private LocationListener locationListener;

    public MapFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        mapView = (MapView) view.findViewById(R.id.mapViewFragment);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
//Valid Permissions
        com.example.manoel.maratoneia1.Permissions.validPermission(permissions, (Activity) getContext(), 1);
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapView.getMapAsync(this);

        return view;
    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {

        this.googleMap = googleMap;
        this.googleMap.setOnMyLocationButtonClickListener(this);
        this.googleMap.setOnMyLocationClickListener(this);

        locationManager = (LocationManager) this.getContext().getSystemService(getContext().LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d("Localizacao", "LOCALE" + location.toString());
                Double latitude = location.getLatitude();
                Double longitude = location.getLongitude();
                // Add a marker in Sydney and move the camera
                LatLng userlocation = new LatLng(latitude, longitude);
                googleMap.addMarker(new MarkerOptions()
                                .position(userlocation)
                                .title("Marker in Sydney")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                );
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userlocation, 15));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
            this.locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0,
                    100,
                    locationListener

            );
        }

//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-10.166902f, -48.339601);
//        this.googleMap.addMarker(new MarkerOptions()
//                        .position(sydney)
//                        .title("Marker in Sydney")
//                //.icon(BitmapDescriptionFactory.fromResource()) Define um icone para aquele marcador
//        );
//        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for (int permissionResult : grantResults) {
            if (permissionResult == PackageManager.PERMISSION_DENIED) {
                //Alert
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Permission");
                builder.setMessage("You Denied Permission");
                builder.setCancelable(false);
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            } else if (permissionResult == PackageManager.PERMISSION_GRANTED) {
                //Request user location
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
                    this.locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            0,
                            100,
                            locationListener

                    );
                }
            }
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(getContext(), "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(getContext(), "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }


}

