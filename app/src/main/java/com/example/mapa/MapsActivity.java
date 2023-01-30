package com.example.mapa;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Marcador a l'institut Jaume Huguet
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng institut = new LatLng(41.289558967903304, 1.2459889876953898);   //Posicio de l'institut
        mMap.addMarker(new MarkerOptions().position(institut).title("Jaume Huguet").icon(BitmapDescriptorFactory.fromResource(R.drawable.icona_mapa2))); //Personalitzacio del marcador
        mMap.moveCamera(CameraUpdateFactory.zoomTo(17.0f)); //Fixem el zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLng(institut));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); //Tipus de mapa
    }
}