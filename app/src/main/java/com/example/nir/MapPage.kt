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
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.location.Location
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.search.SearchFactory
import com.yandex.mapkit.search.SearchManager


class MapPage : AppCompatActivity () {

    lateinit var mapview: MapView
    lateinit var locationmapkit: MapKit
    lateinit var searchEdit: EditText
    lateinit var searchManager: SearchManager
    lateinit var searchSession: com.yandex.mapkit.search.Session
    private lateinit var webView: WebView

    private val REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124
    private val webViewPreviousState = 0
    private val PAGE_STARTED = 0x1
    private val PAGE_REDIRECTED = 0x2
    private val rootView: CoordinatorLayout? = null

    private var currentLocation: Location? = null
    lateinit var locationManager: LocationManager


    //private fun submitQuery(query:String)
    // {searchSession = searchManager.submit(query,VisibleRegionUtils.toPolygon(mapview.map.visibleRegion), SearchOptions(), this)
    // }


    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("a5be6dab-c596-4ed4-b240-909d13f0bac6");
        MapKitFactory.initialize(this);

        setContentView(R.layout.activity_map_page)
        mapview = findViewById<View>(R.id.mapview) as MapView
        webView = findViewById<View>(R.id.webView) as WebView
        /*mapview!!.map.move(
            CameraPosition(Point(54.513845, 36.261215), 9.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F),
            null)*/
        var mapKit: MapKit = MapKitFactory.getInstance()
        //Location()
        //var locationmapkit = mapKit.createUserLocationLayer(mapview.mapWindow)
        //locationmapkit.isVisible = true
        //locationmapkit.setObjectListener(this)
        SearchFactory.initialize(this)
        //searchManager = SearchFactory.getInstance().createSearchManager(SearchManagerType.COMBINED)
        //mapview.map.addCameraListener(this)
        //searchEdit = findViewById(R.id.search_edit)
        /*searchEdit.setOnEditorActionListener {v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                submitQuery(searchEdit.text.toString())
            }
            false
        }*/

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


        //webView = WebView(this)
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
        webView.loadUrl("https://yandex.ru/maps/10693/kaluga-oblast/?ll=35.445185%2C54.371800&z=8")
        webView.evaluateJavascript("showPoint('bl')", null);
        webView.evaluateJavascript("showPoint('pz')", null);
        webView.evaluateJavascript("showPoint('ni')", null);

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)

                // Добавляем клик-обработчик на кнопку геолокации
                view.loadUrl("javascript:document.getElementById('geolocation-button').addEventListener('click', function() { "
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
            }

        }

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)

                // вызвать функцию JavaScript, передав ей параметры
                webView.evaluateJavascript("moveToAddress('Москва')", null)
            }
        }

        //webView.loadUrl("https://yandex.ru/maps/10693/kaluga-oblast/?ll=35.445185%2C54.371800&z=8");
        //setContentView(webView);




       /* var fusedLocationClient = LocationServices.getFusedLocationProviderClient(this@MapPage)

        if (ActivityCompat.checkSelfPermission(this,
                ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationClient.lastLocation.addOnSuccessListener { location: android.location.Location? ->

            Log.d(TAG, "getUserLocation:  $location.latitude")

            Log.d(TAG, "getUserLocation:  $location.longitude")

        }*/
    }

        /*webView.addJavascriptInterface(MyJavascriptInterface(), "Android")
        val script =
            "navigator.geolocation.getCurrentPosition(function(position) { Android.onLocationChanged(position.coords.latitude, position.coords.longitude); });"
        webView.loadUrl("https://yandex.ru/maps/10693/kaluga-oblast/?ll=35.445185%2C54.371800&z=8:$script")*/



        // Регистрируем этот класс как прослушиватель местоположения

        // Регистрируем этот класс как прослушиватель местоположения
        //locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this)
        //val REQUEST_CODE_PERMISSION_ACCESS_FINE_LOCATION = 100

        /*ActivityCompat.requestPermissions(this@MapPage,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            REQUEST_CODE_PERMISSION_ACCESS_FINE_LOCATION)*/
        //Location()

        //askRuntimePermission()

        //webView.Location()


    /*private fun Location() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 0)
            return
        }
    }*/



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



