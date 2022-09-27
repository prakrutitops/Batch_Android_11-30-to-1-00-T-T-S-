package com.example.mapex;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapex.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    LocationManager locationManager;
    LocationListener locationListener;
    double lat, lng;
    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(MapsActivity.this, "GPS is not working", Toast.LENGTH_SHORT).show();
        }
        if (!locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            Toast.makeText(MapsActivity.this, "Network is not working", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MapsActivity.this, "Fetching Location", Toast.LENGTH_SHORT).show();
        }
        locationListener = new LocationListener()
        {
            @Override
            public void onLocationChanged(@NonNull Location location) {

                lat = location.getLatitude();
                lng = location.getLongitude();


            }
        };
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            location =  locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if(location!=null)
            {
                lat = location.getLatitude();
                lng = location.getLongitude();
                Toast.makeText(MapsActivity.this, ""+location.getLatitude(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat,lng);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker at your place"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}