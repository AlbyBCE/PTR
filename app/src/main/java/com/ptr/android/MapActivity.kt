package com.ptr.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class MapActivity : AppCompatActivity() {
    lateinit var mapview:MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("71539f6f-9f95-4d29-a6e5-47698d3534fe")
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_map)
        mapview = findViewById(R.id.mapview)
        mapview.map.move(CameraPosition(Point(47.123456,47.123456), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 300f), null
        )


    }

    override fun onStop() {
        mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
    override fun onStart() {
        mapview.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }
}