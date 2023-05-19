package com.example.nir

//import androidx.databinding.tool.store.Location

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.*
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.yandex.mapkit.GeoObjectCollection
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.location.Location
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.search.SearchFactory
import com.yandex.mapkit.search.SearchManager


class MapPage : AppCompatActivity () {

    lateinit var mapview: MapView
    private lateinit var webView: WebView
    private lateinit var button: Button

    lateinit var locationManager: LocationManager



    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("a5be6dab-c596-4ed4-b240-909d13f0bac6");
        MapKitFactory.initialize(this);

        setContentView(R.layout.activity_map_page)
        mapview = findViewById<View>(R.id.mapview) as MapView
        webView = findViewById<View>(R.id.webView) as WebView
        button = findViewById(R.id.button25)

        button.setOnClickListener()
        {
            finish()
        }

        var mWebView: WebView

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        //музеи
        val ts = Point(54.517034, 36.230565)
        mapview!!.map.mapObjects.addPlacemark(ts)

        val za = Point(54.494143, 34.445823)
        mapview!!.map.mapObjects.addPlacemark(za)

        val ta = Point(54.729475, 37.180326)
        mapview!!.map.mapObjects.addPlacemark(ta)

        //парки
        val vb = Point(55.158894, 36.778959)
        mapview!!.map.mapObjects.addPlacemark(vb)

        val nl = Point(54.758205, 35.603104)
        mapview!!.map.mapObjects.addPlacemark(nl)

        val ug = Point(54.716682, 35.485415)
        mapview!!.map.mapObjects.addPlacemark(ug)

        //монастыри/ храмы
        val pb = Point(55.214563, 36.532839)
        mapview!!.map.mapObjects.addPlacemark(pb)

        val pp = Point(54.729475, 37.180326)
        mapview!!.map.mapObjects.addPlacemark(pp)

        val tu = Point(54.605073, 36.038772)
        mapview!!.map.mapObjects.addPlacemark(tu)

        //природные объекты
        val ra = Point(55.212136, 36.953962)
        mapview!!.map.mapObjects.addPlacemark(ra)

        val kzs = Point(53.793720, 35.729122)
        mapview!!.map.mapObjects.addPlacemark(kzs)

        val kzu = Point(53.601752, 35.786578)
        mapview!!.map.mapObjects.addPlacemark(kzu)

        val kp = Point(54.427780, 36.644625)
        mapview!!.map.mapObjects.addPlacemark(kp)

        //памятники
        val mt = Point(54.729454, 37.181047)
        mapview!!.map.mapObjects.addPlacemark(mt)

        val nk = Point(54.513208, 36.257543)
        mapview!!.map.mapObjects.addPlacemark(nk)

        val mk = Point(55.011448, 36.470963)
        mapview!!.map.mapObjects.addPlacemark(mk)

        //усадьбы
        val bl = Point(55.125839, 36.593861)
        mapview!!.map.mapObjects.addPlacemark(bl)

        val pz = Point(54.738328, 35.995592)
        mapview!!.map.mapObjects.addPlacemark(pz)

        val ni = Point(55.194388, 36.950672)
        mapview!!.map.mapObjects.addPlacemark(ni)


        val webView = findViewById<View>(R.id.webView) as WebView
        webView.settings.javaScriptEnabled = true // enable javascript
        webView.settings.databaseEnabled = true;
        webView.settings.domStorageEnabled = true;
        val webSettings = webView.settings
        webSettings.loadWithOverviewMode = true;
        webSettings.useWideViewPort = true;
        webSettings.builtInZoomControls = true;
        webSettings.displayZoomControls = false;
        webSettings.setSupportZoom(true);
        webSettings.defaultTextEncodingName = "utf-8";
        webView.settings.pluginState = WebSettings.PluginState.ON
        webSettings.setGeolocationDatabasePath(filesDir.path);


        mWebView = findViewById<View>(R.id.webView) as WebView
        // Brower niceties -- pinch / zoom, follow links in place
        // Brower niceties -- pinch / zoom, follow links in place
        mWebView.settings.javaScriptCanOpenWindowsAutomatically = true
        mWebView.settings.builtInZoomControls = true
        // Below required for geolocation
        // Below required for geolocation
        mWebView.webViewClient = GeoWebViewClient()
        mWebView.settings.javaScriptEnabled = true
        mWebView.settings.setGeolocationEnabled(true)
        mWebView.webChromeClient = GeoWebChromeClient()
        // Load yandex.ru
        mWebView.loadUrl("https://yandex.ru/maps/10693/kaluga-oblast/?ll=35.445185%2C54.371800&z=8")

        webView.webViewClient = WebViewClient()

        val activity: Activity = this



        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String,
            ) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()
            }

            @TargetApi(Build.VERSION_CODES.M)
            override fun onReceivedError(
                view: WebView,
                req: WebResourceRequest,
                rerr: WebResourceError,
            ) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view,
                    rerr.errorCode,
                    rerr.description.toString(),
                    req.url.toString())
            }
        }
        //webView.loadUrl("https://yandex.ru/maps/10693/kaluga-oblast/?ll=35.445185%2C54.371800&z=8")
        webView.evaluateJavascript("showPoint('bl')", null);
        webView.evaluateJavascript("showPoint('pz')", null);
        webView.evaluateJavascript("showPoint('ni')", null);


        webView.loadUrl("javascript:document.getElementById(' https://yandex.ru/captchapgrd').addEventListener('click', function() { "
                + "maps.geolocation.get({"
                + "    provider: 'auto',"
                + "    mapStateAutoApply: true"
                + "}).then(function(result) {"
                + "    var coords = result.geoObjects.get(0).geometry.getCoordinates();"
                + "    var lat = coords[0];"
                + "    var lon = coords[1];"
                + "    alert('Широта: ' + lat + ', Долгота: ' + lon);"
                + "}, function(error) {"
                + "    alert('Ошибка: ' + error.message);"
                + "});"
                + "});")

        //webView.loadUrl("https://yandex.ru/maps/10693/kaluga-oblast/?ll=35.445185%2C54.371800&z=8");
        //setContentView(webView);


    }


    /**
     * WebViewClient subclass loads all hyperlinks in the existing WebView
     */
    class GeoWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            // When user clicks a hyperlink, load in the existing WebView
            view.loadUrl(url)
            return true
        }
    }

    class GeoWebChromeClient : WebChromeClient() {
        override fun onGeolocationPermissionsShowPrompt(
            origin: String,
            callback: GeolocationPermissions.Callback,
        ) {
            // Always grant permission since the app itself requires location
            // permission and the user has therefore already granted it
            callback.invoke(origin, true, false)
        }
    }

    override fun onStop() {
        mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapview.onStart()
    }

}




