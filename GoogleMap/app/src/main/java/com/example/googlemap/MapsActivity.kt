package com.example.googlemap

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

@Suppress("UNREACHABLE_CODE")
class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    override fun onMarkerClick(p0: Marker?) = false

    //구글 맵 조작을 위한 객체 생성
    private lateinit var map: GoogleMap
    // 현재 위치 표시를 위한 객체 생성
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

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
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        /*         // Add a marker in Sydney and move the camera
                 val daejeon = LatLng(36.35,127.38)
                 map.addMarker(MarkerOptions().position(daejeon).title("Marker in 대전"))
                 map.moveCamera(CameraUpdateFactory.newLatLng(daejeon))
                 map.moveCamera(CameraUpdateFactory.newLatLngZoom(daejeon,12.0f))*/

        map.getUiSettings().isZoomControlsEnabled = true
        map.setOnMarkerClickListener(this)

        setUpMap()
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }

        // isMyLocationEnabled = true는
        // 사용자의 위치에 옅은 파란색 점을 그리는 my-location 계층을 활성화한다.
        // 또한 지도에 버튼을 추가하여, 탭할 때, 지도의 중심을 사용자의 위치에 맞춘다
        map.isMyLocationEnabled = true

        //현재 사용가능한 가장 최근의 위치를 제공한다.
        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->

            //가장 최근의 위치를 검색할 수 있으면 카메라를 사용자의 현재 위치로 이동하십시오.
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                placeMarkerOnMap(currentLatLng)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }
        //map 타입 지정
        map.mapType = GoogleMap.MAP_TYPE_NORMAL
    }

    private fun placeMarkerOnMap(location: LatLng) {
        //MarkerOptions 객체 생성 및 사용자의 현재 위치를 마커 위치로 설정
        val markerOptions = MarkerOptions().position(location).icon(
            BitmapDescriptorFactory.defaultMarker(
                BitmapDescriptorFactory.HUE_GREEN
            )
        )
        //지도에 마커 추가
        map.addMarker(markerOptions)

    }
}
