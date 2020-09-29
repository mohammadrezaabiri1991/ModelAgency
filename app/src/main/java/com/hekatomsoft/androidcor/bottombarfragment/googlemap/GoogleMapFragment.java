package com.hekatomsoft.androidcor.bottombarfragment.googlemap;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
//import com.hekatomsoft.androidcores.bottombarfragment.repository.DataBaseClassSample;
import com.hekatomsoft.androidcor.R;
import com.hekatomsoft.androidcor.bottombarfragment.repository.MapModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.hekatomsoft.androidcor.bottombarfragment.repository.MarkerPosition;
import com.hekatomsoft.androidcor.googledirection.DirectionCallback;
import com.hekatomsoft.androidcor.googledirection.GoogleDirection;
import com.hekatomsoft.androidcor.googledirection.constant.TransportMode;
import com.hekatomsoft.androidcor.googledirection.model.Direction;
import com.hekatomsoft.androidcor.googledirection.model.Info;
import com.hekatomsoft.androidcor.googledirection.model.Leg;
import com.hekatomsoft.androidcor.googledirection.model.Route;
import com.hekatomsoft.androidcor.googledirection.util.DirectionConverter;
import com.hekatomsoft.androidcor.imagecompressor.FileUtil;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;

import static android.location.GpsStatus.GPS_EVENT_STARTED;
import static android.location.GpsStatus.GPS_EVENT_STOPPED;
import static com.hekatomsoft.androidcor.bottombarfragment.googlemap.MyExpandableListAdapter.deleteHomeSuccess;
import static com.hekatomsoft.androidcor.bottombarfragment.googlemap.MyExpandableListAdapter.isFieldsInitialized;
import static com.hekatomsoft.androidcor.bottombarfragment.googlemap.MyExpandableListAdapter.isHomeSaved;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_MARKER_POSITION_LAT;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_MARKER_POSITION_LNG;
//import static com.hekatomsoft.androidcores.bottombarfragment.repository.DataBaseClassSample.keepHomeId;
//import static com.hekatomsoft.androidcores.bottombarfragment.repository.DataBaseClassSample.unitsIdHashMap;


public class GoogleMapFragment extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener, DirectionCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, PlaceSelectionListener, Animation.AnimationListener {


    private static final int MY_PERMISSION_LOCATION = 1;
    private static final String PREFERENCES_NAME = "last_location";
    private static final double TEHRAN_LAT = 35.6892;
    private static final double TEHRAN_LNG = 51.3890;
    private static final float TEHRAN_ZOOM = 10;
    private static final String LATITUDE_KEY = "latitude";
    private static final String LONGITUDE_KEY = "longitude";
    //    private static final String GOOGLE_MAP_ML_BOTTON = "GoogleMapMyLocationButton";
    private static final String SERVER_KEY = "AIzaSyD3tBRqcERxpYvot5OOCSWNgYMda5vprUk";
    public static BottomSheetBehavior<View> mainBehavior;

    private GoogleMap mGoogleMap;
    public static Marker mMarker;
    private View googleMapFragment;
    private Activity mActivity;

    private FloatingActionButton fabParent;
    private FloatingActionButton fabRemoveMarker;
    private FloatingActionButton fabReplaceMarker;
    private FloatingActionButton fabDirection;

    private Animation animationShowFabRemoveMarker;
    private Animation animationShowFabMove;
    private Animation animationShowFabDirection;
    private Animation animationShowParentFab;
    private Animation animationHideParentFab;
    private Animation animationHideFabRemoveMarker;
    private Animation animationHideFabMove;
    private Animation animationHideFabDirection;

    private Animation animationShowBottomSheetSearchAndDirection;
    private Animation animationHideBottomSheetSearchAndDirection;

    private MarkerOptions markerOptions;
    private LatLng selectedMarkerPosition;
    private LocationRequest mLocationRequest;
    private RelativeLayout mapRelativeLayout;
    private Snackbar snackbar;
    private boolean isExpanded;
    private DrawerLayout mapDrawer;

    private ArrayList<Group> groups = new ArrayList<Group>();
    private Group group;
    public MyExpandableListAdapter adapter;
    private ExpandableListView myExpandableListView;

    public static GoogleApiClient mGoogleApiClient;
    private static final LatLngBounds BOUNDS = new LatLngBounds(
            new LatLng(-0, -0), new LatLng(0, 0));
    private int lastExpandedPosition = -1;
    //    public static FloatingActionButton addUnitBTSfab;
    public static LinearLayout linearAddNewUnit;
    //    private DataBaseClassSample dataBaseClassSample;
    public static long mHome_id;
    protected LocationManager locationManager;
    private LocationSettingsRequest.Builder builder;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private double currentlatitude;
    private double currentlongitude;

    private boolean gps_enabled = false;
    private boolean network_enabled = false;
    private int zoom = 14;
    private double currentlatitudeGPS;
    private double currentlongitudeGPS;
    private Polyline polyline;
    private boolean trafficEnabled;
    private boolean satelliteMode;
    private Marker mMarkerSearch;
    private String placeAddress;
    private String placeName;
    private int doubleBackToExit;
    private boolean isSearch;
    private boolean isShowSmallFabs;
    private boolean isShowParentFab;
    private boolean isDeviceGpsOn;
    private Location currentLocationGps;

    private TextView txtAddressContentLayout;
    private TextView txtDetailsContentLayout;
    private FloatingActionButton fabSecondaryBS;
    public static LatLng searchedPlaceLocation;
    private RelativeLayout rootLayoutSecondaryBS;
    private String placeDescription;
    private boolean isDirection;
    private View popupInfoHome;
    private ProgressBar progressBarSecondaryBS;
    private Handler mHandler = new Handler();
    private LinearLayout contentLayoutSecondaryBSh;
    private Route route;
    private ArrayList<LatLng> directionPositionList;
    private LinearLayout linearErrorSecondaryBS;
    private TextView txtErrorNoRouteFound;
    private ImageView imgErrorNoRouteFound;
    private boolean onDirectionFabClicked;
    private String knownName;
    private Button myLocationButton;
    private int searchZoom = 8;
    private Marker newHomeMarker;
    private boolean isMarkerDraging;
    //    private int isNewHomeAdded = 0;
    private LatLng addNewHomeLatLng;
    private ImageButton imgFakeMarker;
    private LatLng midCameraLatLng;
    private LinearLayout linearCustomZoom;
    private Button btnZoomPlus;
    private Button btnZoomMinus;
    private int holdGroupPosition;
    private Button btnMinimizeBts;
    private CardView cardViewAppBar;
    private Button btnNavigationMap;
    private int isBeforAnimationEnd = 0;
    private int previousGroup = -1;
    private File actualImage;
    private File compressedImage;
    private static final int REQUEST_SELECT_PICTURE_FOR_FRAGMENT = 0x02;
    private static final int GALLERY_REQUEST = 1;
    private static final int CAMERA_REQUEST = 0;
    private RealmResults<MapModel> melkInfoArray;
    private View listviewFooter;

    public static GoogleMapFragment newInstance() {
        GoogleMapFragment googleMapFragment = new GoogleMapFragment();
        return googleMapFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.map_nav_drawer);
        mActivity = this;
        getPermission();
        locationManager = (LocationManager) mActivity.getSystemService(LOCATION_SERVICE);
//        getDisplaySize(inflater, container);
        mActivity.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mActivity);
        editor = sharedPreferences.edit();
        buildGoogleApiClient();
        checkPermissionAndFindLocation();
        createWidgets();
        setTransparentStatusBar();
        googleServiceAvailable();
        createDrawerNavigation();
//        dataBaseClassSample = new DataBaseClassSample(mActivity);
        if (isPermisionAccess()) {
            getDeviceGpsState();
            getLocationFromMyLocationClass();
        }

    }

    private void createWidgets() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        myLocationButton = (Button) findViewById(R.id.btn_my_location);


        cardViewAppBar = (CardView) findViewById(R.id.cardView_appBar);
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.autocomplete_fragment);
        autocompleteFragment.getView().setBackgroundColor(Color.parseColor("#ff8877"));


        EditText edtAutoCompeletePlace = (EditText) autocompleteFragment.getView().findViewById(R.id.place_autocomplete_search_input);
        edtAutoCompeletePlace.setHint(R.string.edtMapSearchHint);
        edtAutoCompeletePlace.setHintTextColor(R.color.font_color_hint);
        edtAutoCompeletePlace.setTextColor(R.color.font_color);
        edtAutoCompeletePlace.setTextSize(13);

//        enablePoweredByContainer={false}
        ImageButton searchIcon = (ImageButton) autocompleteFragment.getView().findViewById(R.id.place_autocomplete_search_button);
        searchIcon.setImageDrawable(getResources().getDrawable(R.drawable.search_ic));

        ImageButton removeIcon = (ImageButton) autocompleteFragment.getView().findViewById(R.id.place_autocomplete_clear_button);
        removeIcon.setImageDrawable(getResources().getDrawable(R.drawable.remove_ic));
        autocompleteFragment.setOnPlaceSelectedListener(this);


        imgFakeMarker = (ImageButton) findViewById(R.id.img_fake_marker);

        linearCustomZoom = (LinearLayout) findViewById(R.id.linear_custom_zoom);
        btnZoomPlus = (Button) findViewById(R.id.btn_zoom_plus);
        btnZoomMinus = (Button) findViewById(R.id.btn_zoom_minus);
        createActionCustomZoom();

        final View bottomSheet = findViewById(R.id.design_bottom_sheet);
        mainBehavior = BottomSheetBehavior.from(bottomSheet);


        mainBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        btnMinimizeBts = (Button) findViewById(R.id.btn_minimize_bts);

        mapRelativeLayout = (RelativeLayout) findViewById(R.id.mapRelativeLayout);
        btnNavigationMap = (Button) findViewById(R.id.btn_nav_map);
        btnNavigationMap.setOnClickListener(this);


        myExpandableListView = (ExpandableListView) findViewById(R.id.recyclerView);
        adapter = new MyExpandableListAdapter(mActivity,
                groups) {
        };

        listviewFooter = ((LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.listview_footer, null, false);
        linearAddNewUnit = (LinearLayout) listviewFooter.findViewById(R.id.linearAddNewUnit);
        myExpandableListView.addFooterView(listviewFooter);


        createFloatingActionButtons();
        setListenerForbBottomSheeBehavior(btnNavigationMap);
        createSecondaryBotomSheetWidgets();

        myExpandableListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, "Clicked", Toast.LENGTH_LONG).show();
            }
        });


//        myExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v,
//                                        int groupPosition, long id) {
//                setListViewHeight(parent, groupPosition);
//                return false;
//            }
//        });

//        myExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                if (lastExpandedPosition != -1
//                        && groupPosition != lastExpandedPosition) {
//                    myExpandableListView.collapseGroup(lastExpandedPosition);
//                }
//                lastExpandedPosition = groupPosition;
////                addUnitBTSfab.hide();
//
//            }
//        });
//        myExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
////                addUnitBTSfab.show();
//
//            }
//        });
//
//
////        myExpandableListView.getChildAdapterPosition()
//
//        myExpandableListView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//
//                if (!view.canScrollList(View.SCROLL_AXIS_VERTICAL) && scrollState == SCROLL_STATE_IDLE) {
////                    addUnitBTSfab.show();
//                } else {
////                    addUnitBTSfab.hide();
//                }
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//
//
//            }
//        });


    }

    private void setListViewHeight(ExpandableListView listView, int group) {
//        MyExpandableListAdapter listAdapter = (MyExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            View groupItem = adapter.getGroupView(i, true, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < adapter.getChildrenCount(i); j++) {
                    View listItem = adapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
                //Add Divider Height
                totalHeight += listView.getDividerHeight() * (adapter.getChildrenCount(i) - 1);
            }
        }
        //Add Divider Height
        totalHeight += listView.getDividerHeight() * (adapter.getGroupCount() - 1);

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + ((adapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    private void createActionCustomZoom() {
        if (btnZoomPlus != null) {
            btnZoomPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mGoogleMap != null) {
                        mGoogleMap.animateCamera(CameraUpdateFactory.zoomIn());
                    }
                }
            });
        }
        if (btnZoomMinus != null) {
            btnZoomMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mGoogleMap != null) {
                        mGoogleMap.animateCamera(CameraUpdateFactory.zoomOut());
                    }
                }
            });
        }


    }

    private void getPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && mActivity.checkSelfPermission(
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            mActivity.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_LOCATION);
        }
    }

    private void setTransparentStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            int toolbarColor = getResources().getColor(R.color.colorStatusBar);
            getWindow().setStatusBarColor(toolbarColor);
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks((this))
                .addOnConnectionFailedListener(this)
                .addApi(Places.GEO_DATA_API)
                .build();
        mGoogleApiClient.connect();
    }


    private void checkPermissionAndFindLocation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && mActivity.checkSelfPermission(
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            mActivity.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_LOCATION);
        } else {
            if (mGoogleMap != null) {
                mGoogleMap.setMyLocationEnabled(true);
            }
            locationManager = (LocationManager) mActivity.getSystemService(LOCATION_SERVICE);
            if (locationManager != null) {
                gps_enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                Location locationGps = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                Location locationNetwork = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                if (locationGps != null) {
                    currentlatitude = locationGps.getLatitude();
                    currentlongitude = locationGps.getLongitude();

                    currentlatitudeGPS = locationGps.getLatitude();
                    currentlongitudeGPS = locationGps.getLongitude();
                    zoom = 16;
                } else if (locationNetwork != null) {
                    currentlatitude = locationNetwork.getLatitude();
                    currentlongitude = locationNetwork.getLongitude();
                    zoom = 16;

                } else {
                    getSharedPreferences();
                    zoom = 14;
                }
            }
        }
    }


    private void getSharedPreferences() {
        String latitude = sharedPreferences.getString(LATITUDE_KEY, String.valueOf(TEHRAN_LAT));
        String longitude = sharedPreferences.getString(LONGITUDE_KEY, String.valueOf(TEHRAN_LNG));
        currentlatitude = Double.parseDouble(latitude);
        currentlongitude = Double.parseDouble(longitude);

    }

    private void checkPermissionAccess() {
        if (!isPermisionAccess()) {
            checkPermissionAndFindLocation();

        }
    }

    private void checkGpsEnabled() {
        if (isPermisionAccess()) {
            if (!isGpsEnabled()) {
                getEnabelGpsPermisionAccessFromUser();
            }
        }
    }

    private boolean isPermisionAccess() {
        return (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED);
    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    private boolean isGpsEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    private void getDeviceGpsState() {
        if (locationManager != null && (isPermisionAccess())) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.addGpsStatusListener(new GpsStatus.Listener() {
                public void onGpsStatusChanged(int event) {
                    switch (event) {
                        case GPS_EVENT_STOPPED:
                            isDeviceGpsOn = false;
                            if (mGoogleMap != null) {
                                mGoogleMap.setMyLocationEnabled(true);
                                mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
                            }
                            break;
                        case GPS_EVENT_STARTED:
                            isDeviceGpsOn = true;
                            if (mGoogleMap != null) {
                                mGoogleMap.setMyLocationEnabled(true);
                                mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
                            }
                            break;
                    }
                }
            });

        }
    }


    private void getSearchAddressAndDynamicZoom(Place place) {
        if (place != null) {
            searchedPlaceLocation = place.getLatLng();

            placeName = place.getName().toString();
            placeAddress = place.getAddress().toString();

            double latDiff = (place.getViewport().northeast.latitude - place.getViewport().southwest.latitude);
            double lngDiff = (place.getViewport().northeast.longitude - place.getViewport().southwest.longitude);

            if (latDiff < 0.007 && lngDiff < 0.007) {
                searchZoom = 21;
            }

            if (latDiff < 0.007 && latDiff > 0.001 || lngDiff < 0.007 && lngDiff > 0.001) {
                searchZoom = 17;
            }


            if (latDiff < 0.01 && latDiff > 0.007 || lngDiff < 0.01 && lngDiff > 0.007) {
                searchZoom = 16;
            }


            if (latDiff < 0.04 && latDiff > 0.01 || lngDiff < 0.04 && lngDiff > 0.01) {
                searchZoom = 15;
            }

            if (latDiff < 0.08 && latDiff > 0.04 || lngDiff < 0.08 && lngDiff > 0.04) {
                searchZoom = 13;
            }


            if (latDiff < 0.1 && latDiff > 0.08 || lngDiff < 0.1 && lngDiff > 0.08) {
                searchZoom = 12;
            }

            if (latDiff < 0.5 && latDiff > 0.1 || lngDiff < 0.5 && lngDiff > 0.1) {
                searchZoom = 11;
            }


            if (latDiff < 1 && latDiff > 0.5 || lngDiff < 1 && lngDiff > 0.5) {
                searchZoom = 10;
            }


            if (latDiff < 3 && latDiff > 1 || lngDiff < 3 && lngDiff > 1) {
                searchZoom = 9;
            }


            if (latDiff < 5 && latDiff > 3 || lngDiff < 5 && lngDiff > 3) {
                searchZoom = 8;
            }


            if (latDiff < 10 && latDiff > 5 || lngDiff < 10 && lngDiff > 5) {
                searchZoom = 7;
            }


            if (latDiff < 15 && latDiff > 10 || lngDiff < 15 && lngDiff > 10) {
                searchZoom = 6;
            }

            if (latDiff < 20 && latDiff > 15 || lngDiff < 20 && lngDiff > 15) {
                searchZoom = 5;
            }

            if (latDiff > 20) {
                searchZoom = 4;
            }


            goToLocationZoom(place.getLatLng().latitude, place.getLatLng().longitude, searchZoom);
            showRootLayoutSecondaryBS();
            showAndInitContentLayoutSecondaryBS(place.getName().toString(), place.getAddress().toString());

            if (mMarkerSearch != null) {
                mMarkerSearch.remove();
            }
            removePolylie();
            hideMarkerDeatils();
            isSearch = true;

            hideSnakeBar();
            removeNewHomeMarker();

            MarkerOptions searchMarkerOptions = new MarkerOptions();
            searchMarkerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_search))
                    .position(new LatLng(searchedPlaceLocation.latitude, searchedPlaceLocation.longitude));
            mMarkerSearch = mGoogleMap.addMarker(searchMarkerOptions);


        } else {
            Toast.makeText(mActivity, "place is null", Toast.LENGTH_LONG).show();
        }
    }

    private void setListenerForbBottomSheeBehavior(final Button btnNavigationMap) {

        btnMinimizeBts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewAppBar.setVisibility(View.VISIBLE);
                mainBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);


            }
        });
        mainBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback()


        {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    isExpanded = true;

                    btnNavigationMap.setEnabled(false);
                    btnNavigationMap.setClickable(false);


                    if (mainBehavior instanceof LockableBottomSheetBehavior) {
                        ((LockableBottomSheetBehavior) mainBehavior).setLocked(true);
                    }

                    if (fabDirection != null && fabRemoveMarker != null && fabReplaceMarker != null) {
                        fabDirection.setClickable(false);
                        fabRemoveMarker.setClickable(false);
                        fabReplaceMarker.setClickable(false);
                    }

                    if (mapDrawer != null) {
                        mapDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                    }


                    linearAddNewUnit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//                            adapter.checkIsEmptyUnitWidgetsInformation();
//                            if (isFieldsInitialized) {
                            if (isHomeSaved == 1) {
                                createAlertDialogBtnAddUnit();
                            } else {
                                int value = groups.size();
                                group = new Group("واحد " + value);
                                group.children.add("");
                                groups.add(value, group);
                                myExpandableListView.setAdapter(adapter);
//                                    fastExpandThread(groups.size() - 1);
                                adapter.notifyDataSetChanged();
                                ++value;
                                isFieldsInitialized = false;
                                isHomeSaved = 1;
                            }

//                            } else {
//                                Toast.makeText(mActivity, R.string.fieldsAreEmpty, Toast.LENGTH_SHORT).show();
//                            }

                        }
                    });


                    hideSnakeBar();

                }
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    isExpanded = false;
                    btnNavigationMap.setEnabled(true);
                    btnNavigationMap.setClickable(true);


                    if (fabDirection != null && fabRemoveMarker != null && fabReplaceMarker != null) {
                        fabDirection.setClickable(true);
                        fabRemoveMarker.setClickable(true);
                        fabReplaceMarker.setClickable(true);
                    }
                    if (deleteHomeSuccess) {
                        if (isShowSmallFabs && isShowParentFab) {
                            hideSmallFloatingButtons();
//                            hideParentFab();
                            if (mMarker != null) {
                                mMarker.remove();
                            }

                        }
                        deleteHomeSuccess = false;
                    }
//                    showAppBars();

                    if (mapDrawer != null) {
                        mapDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                    }


                }
                if (newState == BottomSheetBehavior.STATE_COLLAPSED)

                {
                    mainBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                    isExpanded = false;
                }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                if (isExpanded) {
                    if (slideOffset < 0.85) {
                        if (myLocationButton != null) {
                            myLocationButton.setVisibility(View.VISIBLE);
                            myLocationButton.setClickable(true);
                        }
//                        showAppBars();
//                        mainBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                    }
                }
                if (slideOffset > 0.85) {
//                        hideAppBars();
                    if (myLocationButton != null) {
                        myLocationButton.setVisibility(View.GONE);
                        myLocationButton.setClickable(false);
                    }
                }
                if (slideOffset < 1) {
                    cardViewAppBar.setVisibility(View.VISIBLE);
                } else {
                    cardViewAppBar.setVisibility(View.GONE);
                }


            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == btnNavigationMap) {
            if (mapDrawer.isDrawerOpen(Gravity.RIGHT)) {
                mapDrawer.closeDrawer(Gravity.RIGHT);
            } else {
                mapDrawer.openDrawer(Gravity.RIGHT);
            }
        }

        setListenerToMiniFabs(view);
    }


    public static int getListViewHeightBasedOnChildren(ExpandableListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {
            int totalHeight = 0;
            int size = listAdapter.getCount();
            for (int i = 0; i < size; i++) {
                View listItem = listAdapter.getView(i, null, listView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
            totalHeight = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
            return totalHeight;
        }
        return 0;
    }


    private boolean googleServiceAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(mActivity);
        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isAvailable)) {
            Dialog dialog = api.getErrorDialog(mActivity, isAvailable, 0);
            dialog.show();
        } else {
            Toast.makeText(mActivity, R.string.googlePlayService_notInstalled, Toast.LENGTH_LONG).show();


        }
        return false;
    }


    /**
     * Callback invoked when a place has been selected from the PlaceAutocompleteFragment.
     */
    @Override
    public void onPlaceSelected(Place place) {
        getSearchAddressAndDynamicZoom(place);

        // Format the returned place's details and display them in the TextView.
//        mPlaceDetailsText.setText(formatPlaceDetails(getResources(), place.getName(), place.getId(),
//                place.getAddress(), place.getPhoneNumber(), place.getWebsiteUri()));
//
//        CharSequence attributions = place.getAttributions();
//        if (!TextUtils.isEmpty(attributions)) {
//            mPlaceAttribution.setText(Html.fromHtml(attributions.toString()));
//        } else {
//            mPlaceAttribution.setText("");
//        }
    }

    /**
     * Callback invoked when PlaceAutocompleteFragment encounters an error.
     */
    @Override
    public void onError(Status status) {
        Log.e("TAG", "onError: Status = " + status.toString());

        Toast.makeText(this, "Place selection failed: " + status.getStatusMessage(),
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Helper method to format information about a place nicely.
     */
    @SuppressLint("StringFormatInvalid")
    private static Spanned formatPlaceDetails(Resources res, CharSequence name, String id,
                                              CharSequence address, CharSequence phoneNumber, Uri websiteUri) {
        return Html.fromHtml(res.getString(R.string.place_details, name, id, address, phoneNumber,
                websiteUri));

    }


    private void hideMarkerDeatils() {
        if (mMarker != null) {
            try {
                mMarker.setIcon((BitmapDescriptorFactory.fromResource(R.drawable.map_marker)));
            } catch (IllegalArgumentException i) {
                Log.i("ERROR", "IllegalArgumentException : " + i.getMessage());
            }

            if (mMarker.isInfoWindowShown()) {
                mMarker.hideInfoWindow();
            }
        }

        hideSmallFloatingButtons();
//        hideParentFab();

    }


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.getUiSettings().setCompassEnabled(true);
        mGoogleMap.getUiSettings().setMapToolbarEnabled(false);
//        mMap.getUiSettings().setZoomControlsEnabled(false)
//        mGoogleMap.setPadding(0, 90, 0, 0);


        if (isPermisionAccess()) {
            mGoogleMap.setMyLocationEnabled(true);
            mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
        }
        loadMarker();

        Drawable drawable = getResources().getDrawable(R.drawable.map_marker_dragging);
        final int padding = drawable.getIntrinsicHeight();
        mGoogleMap.setPadding(0, padding, 0, 0);

        myLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermissionAndFindLocation();
                checkGpsEnabled();
                if (isPermisionAccess()) {
                    getLocationFromMyLocationClass();

                    if (isGpsEnabled()) {
                        if (currentlatitudeGPS != 0 && currentlongitudeGPS != 0) {
                            goToLocationZoom(currentlatitudeGPS, currentlongitudeGPS, 16);
                        } else if (currentlatitude != 0 && currentlongitude != 0) {
                            goToLocationZoom(currentlatitude, currentlongitude, 16);
                        }
                        mGoogleMap.setMyLocationEnabled(true);
                        mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
                    }

                    mGoogleMap.setMyLocationEnabled(true);
                    mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
                }
                removeNewHomeMarker();

                hideSnakeBar();
            }
        });


        if (currentlatitude != 0 && currentlongitude != 0) {
            goToLocationZoom(currentlatitude, currentlongitude, zoom);
        } else

        {
            goToLocationZoom(TEHRAN_LAT, TEHRAN_LNG, TEHRAN_ZOOM);
        }

        mGoogleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener()

        {
            @Override
            public void onMapLongClick(final LatLng latLng) {
//                if (isMarkerDraging) {
//                    Toast.makeText(mActivity, R.string.firstFixMarkerDraging, Toast.LENGTH_LONG).show();
//                    return;
////                    isNewHomeAdded &&
//                } else if (isHomeSaved == 1) {
//                    createAlertDialogMelkNotSave();
//                } else {
//                    removePolylie();
//                    if (mMarkerSearch != null) {
//                        mMarkerSearch.remove();
//
//                    }
//                    if (isShowSmallFabs && isShowParentFab) {
//                        hideMarkerDeatils();
////                        hideSmallFloatingButtons();
//                    }
//
//                    removeNewHomeMarker();
//                    hideRootLayoutSecondaryBS();
//                    newHomeMarker = addMarkerMethod(latLng);
//                    addNewHomeLatLng = latLng;
//                    createSnakeBarAddNewHome(latLng);
//                }


                Geocoder geoCoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                String address = "";
                try {
                    List<Address> listAddresses = geoCoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    if (listAddresses != null && listAddresses.size() > 0) {
                        if (listAddresses.get(0).getThoroughfare() != null) {
                            if (listAddresses.get(0).getSubThoroughfare() != null) {
                                address += listAddresses.get(0).getSubThoroughfare() + " ";
                            }
                            address += listAddresses.get(0).getThoroughfare();
                            Log.d("Geocoder", address);
                        }
                    }


                    mGoogleMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(address)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });


        mGoogleMap.setOnMarkerClickListener(new OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (!isMarkerDraging) {
                    if (newHomeMarker != null) {
                        if (newHomeMarker.equals(marker)) {
                            if (addNewHomeLatLng != null) {
                                createSnakeBarAddNewHome(addNewHomeLatLng);
                            }
                            return true;
                        }
                    }


                    if (mMarker != null) {
                        if (!(marker.getPosition().equals(searchedPlaceLocation))) {
                            hideSnakeBar();
                            removeNewHomeMarker();
                            hideRootLayoutSecondaryBS();
                            if (!mMarker.isInfoWindowShown()) {
                                mMarker.showInfoWindow();
                            }
                            selectedMarkerPosition = marker.getPosition();

                            try {
                                if (mMarker != null) {
                                    mMarker.setIcon((BitmapDescriptorFactory.fromResource(R.drawable.map_marker)));
                                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_selected));
                                }
                            } catch (IllegalArgumentException i) {
                            }
                            loadMelkInformations(marker);
//                            initiateExpander();
                            showParentFab();
//                            showSmallFloatingButtons();
                            mMarker = marker;
                        }
                    }

                } else {
                    Toast.makeText(mActivity, R.string.firstFixMarkerDraging, Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }
        });
//        isNewHomeAdded &&
        mGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener()

        {
            @Override
            public void onMapClick(LatLng point) {
                if (isHomeSaved == 1) {
                    createAlertDialogMelkNotSave();
                } else {
                    hideRootLayoutSecondaryBS();
                    removeNewHomeMarker();
                    if (isMarkerDraging) {
                        cancleReplacingHome();
                    }
                    hideSnakeBar();

                    try {
                        if (mMarker != null) {
                            mMarker.setIcon((BitmapDescriptorFactory.fromResource(R.drawable.map_marker)));
                        }
                    } catch (IllegalArgumentException i) {
                    }

                    if (mainBehavior != null && mainBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                        hideSmallFloatingButtons();
//                        hideParentFab();
                        mainBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                    }
                }
            }


        });

        mGoogleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter()

        {
            @Override
            public View getInfoWindow(Marker marker) {

                if (mMarkerSearch != null && marker.getPosition().equals(mMarkerSearch.getPosition())) {
                    removeNewHomeMarker();
                    showRootLayoutSecondaryBS();
                    showAndInitContentLayoutSecondaryBS(placeName, placeAddress);
                }

                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                if (mMarker != null) {
                    if (!(marker.getPosition().equals(searchedPlaceLocation))) {
                        popupInfoHome = mActivity.getLayoutInflater().inflate(R.layout.info_windows, null);
                        ImageView imgMarkerImage = (ImageView) popupInfoHome.findViewById(R.id.imgMarkerImage);
                        TextView txtLocality = (TextView) popupInfoHome.findViewById(R.id.txtLocality);
                        TextView txtLat = (TextView) popupInfoHome.findViewById(R.id.txtLat);
                        TextView txtLng = (TextView) popupInfoHome.findViewById(R.id.txtLng);
                        TextView txtSnippet = (TextView) popupInfoHome.findViewById(R.id.txtSnippet);
                        txtLocality.setText("نوع ملک: فروشی");
                        txtLat.setText("متراژ: 500 متر مربع");


                        txtLng.setText("قیمت فروش: 2000000000 ریال");
                        txtSnippet.setText("نام مالک: محمدرضا عبیری");
                        imgMarkerImage.setImageResource(R.drawable.house);
                        return popupInfoHome;
                    }
                }
                return null;
            }
        });


    }

    private void createSnakeBarAddNewHome(final LatLng latLng) {
        snackbar = createSnakBar(getString(R.string.strDialogBoxMarker));
        snackbar.setAction(getString(R.string.yes), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (latLng != null && mGoogleMap != null) {


//                    mGoogleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng), 1000, new GoogleMap.CancelableCallback() {
//                        @Override
//                        public void onFinish() {
                    addNewHome(latLng);

                    mMarker = newHomeMarker;


                    try {
                        mMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_selected));
                    } catch (IllegalArgumentException i) {
                    }

                    selectedMarkerPosition = mMarker.getPosition();
                    showParentFab();
                    showSmallFloatingButtons();
                    newHomeMarker = null;
//                        }
//
//                        @Override
//                        public void onCancel() {
//
//                        }
//                    });


                }
            }
        });
    }


    private void createAlertDialogMelkNotSave() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(mActivity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(mActivity);
        }
        builder.setTitle("SaveAlert")
                .setMessage("شما اطلاعات ملک مورد نظر ذخیره نکرده اید آیا تمایل به ادامه دارید؟")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (groups.size() <= 1) {
                            if (mMarker != null) {
                                mMarker.remove();
                            }
                        }
                        try {
                            mMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker));
                        } catch (IllegalArgumentException i) {
                        }
                        isHomeSaved = 0;
                        hideSmallFloatingButtons();

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (mainBehavior != null) {
                            mainBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        }
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    private void createAlertDialogBtnAddUnit() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(mActivity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(mActivity);
        }
        builder.setTitle("SaveAlert")
                .setMessage("شما باید ابتدا اطلاعات ملک قبلی را ذخیره کنید آیا تمایل به انجام آن دارید؟ ")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                      saveUnit();
                        int value = groups.size();
                        group = new Group("واحد " + value);
                        group.children.add("");
                        groups.add(value, group);
//                        fastExpandThread(groups.size() - 1);
//                        adapter.notifyDataSetChanged();
                        isHomeSaved = 1;
                        isFieldsInitialized = false;
                        ++value;
                        myExpandableListView.setAdapter(adapter);

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }


    private void removeNewHomeMarker() {
        if (newHomeMarker != null) {
            newHomeMarker.remove();
            newHomeMarker = null;
        }

    }


    private void addNewHome(LatLng latLngs) {
//        int j = groups.size();
        int j = 0;
//        isNewHomeAdded = 1;
        adapter = new MyExpandableListAdapter(mActivity, groups);

        isHomeSaved = 1;
        mHome_id = 0;
//        keepHomeId = 0;
//        if (unitsIdHashMap != null) {
//            unitsIdHashMap.clear();
//        }
        groups = new ArrayList<Group>();
        group = new Group("واحد " + j);
        group.children.add("");
        groups.add(j, group);

        adapter = new MyExpandableListAdapter(mActivity, groups);
        myExpandableListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        j++;
        mainBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);


    }

    private void loadMarker() {
        Realm infoRealm = Realm.getDefaultInstance();
        try {
            RealmResults<MarkerPosition> markerPositions = infoRealm.where(MarkerPosition.class).findAll();
            if (markerPositions != null && markerPositions.size() > 0) {
                for (MarkerPosition struct : markerPositions) {
                    Double latitude = Double.parseDouble(struct.getMarker_lat());
                    Double longitude = Double.parseDouble(struct.getMarker_lng());
                    markerOptions = new MarkerOptions();
                    markerOptions.draggable(false)
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker))
                            .position(new LatLng(latitude, longitude));
                    GoogleMapFragment.mMarker = mGoogleMap.addMarker(markerOptions);
                }
            }

        } finally {
            if (infoRealm != null) {
                infoRealm.close();
            }
        }
    }


    private void loadMelkInformations(final Marker marker) {
        groups = new ArrayList<Group>();


        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Realm infoRealm = null;
                try {
                    infoRealm = Realm.getDefaultInstance();
                    final Realm finalInfoRealm = infoRealm;
                    infoRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            int j = 0;
                            melkInfoArray = finalInfoRealm.where(MapModel.class).equalTo(STR_MARKER_POSITION_LAT, String.valueOf(marker.getPosition().latitude))
                                    .equalTo(STR_MARKER_POSITION_LNG, String.valueOf(marker.getPosition().longitude)).findAll();
                            if (melkInfoArray != null) {

                                for (int i = 0; i <= 20; i++) {
//                                for (MapModel mapModel : melkInfoArray) {
                                    group = new Group("واحد " + j);
                                    group.children.add("");
//                                    mHome_id = mapModel.getMelk_id_Model();
//                                    group.setUnitId_value(mapModel.getUnitId_Model());
//                                    setValueToModelFields(mapModel, group);

                                    groups.add(j, group);
                                    j++;
//                                }
                                }
                            }
                            adapter = new MyExpandableListAdapter(mActivity, groups);
                            myExpandableListView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();


                        }
                    });
                } finally {
                    if (infoRealm != null) {
                        infoRealm.close();
                    }
                }
            }
        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                myExpandableListView.expandGroup(0);
//            }
//        }).start();

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();


            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                }
            }

        }
        return super.dispatchTouchEvent(event);
    }

    //TODO  Update Location
    private void getEnabelGpsPermisionAccessFromUser() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10 * 1000);
        locationRequest.setFastestInterval(1 * 1000);
//        locationRequest.setInterval(1 * 1000);
//        locationRequest.setFastestInterval(1 * 1000);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);

        //**************************
        builder.setAlwaysShow(true); //mActivity is the key ingredient
        //**************************

        PendingResult<LocationSettingsResult> result =
                LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                final LocationSettingsStates state = result.getLocationSettingsStates();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        // All location settings are satisfied. The client can initialize location
                        // requests here.
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        // Location settings are not satisfied. But could be fixed by showing the user
                        // a dialog.
                        try {
                            // Show the dialog by calling startResolutionForResult(),
                            // and check the result in onActivityResult().
                            status.startResolutionForResult(
                                    mActivity, 1000);
                        } catch (IntentSender.SendIntentException e) {
                            // Ignore the error.
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        // Location settings are not satisfied. However, we have no way to fix the
                        // settings so we won't show the dialog.
                        break;
                }
            }
        });
    }


    private void showMarkerDeatils() {

    }


    private Marker addMarkerMethod(LatLng latLng) {
        markerOptions = new MarkerOptions();
        markerOptions.title("NewHome");
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_selected))
                .position(new LatLng(latLng.latitude, latLng.longitude));
        return mGoogleMap.addMarker(markerOptions);
    }


    private Snackbar createSnakBar(String string) {
        Snackbar snackbar = Snackbar
                .make(mapRelativeLayout, string, Snackbar.LENGTH_INDEFINITE);

        ViewCompat.setLayoutDirection(snackbar.getView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        View snackBarView = snackbar.getView();
        FrameLayout.LayoutParams parentParams = (FrameLayout.LayoutParams) snackBarView.getLayoutParams();
        parentParams.height = 112;
        snackBarView.setLayoutParams(parentParams);

        snackbar.show();

        return snackbar;
    }


    private void goToLocationZoom(double lat, double lng, float zoom) {
        LatLng latLng = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
        mGoogleMap.animateCamera(update);
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (isPermisionAccess()) {
//            startLocationUpdates();
        }

    }


    @Override
    public void onConnectionSuspended(int i) {
        if (i == CAUSE_SERVICE_DISCONNECTED) {
        } else if (i == CAUSE_NETWORK_LOST) {
        }
        mGoogleApiClient.connect();
    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(mActivity, connectionResult.RESOLUTION_REQUIRED);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        }

    }

    private void createFloatingActionButtons() {
        fabParent = (FloatingActionButton) findViewById(R.id.parentFab);
        fabRemoveMarker = (FloatingActionButton) findViewById(R.id.fabRemove);
        fabReplaceMarker = (FloatingActionButton) findViewById(R.id.fabMove);
        fabDirection = (FloatingActionButton) findViewById(R.id.fabDirection);

        fabParent.setOnClickListener(this);
        fabRemoveMarker.setOnClickListener(this);
        fabReplaceMarker.setOnClickListener(this);
        fabDirection.setOnClickListener(this);

        fabDirection.setOnLongClickListener(new View.OnLongClickListener()

        {
            @Override
            public boolean onLongClick(View v) {
                if (locationManager != null) {
                    removePolylie();
                }
                return true;
            }
        });


        animationShowParentFab = AnimationUtils.loadAnimation(mActivity, R.anim.parent_fab_show);
        animationShowFabRemoveMarker = AnimationUtils.loadAnimation(mActivity, R.anim.show_fab_remove);
        animationShowFabMove = AnimationUtils.loadAnimation(mActivity, R.anim.show_fab_move);
        animationShowFabDirection = AnimationUtils.loadAnimation(mActivity, R.anim.show_fab_direction);
        animationShowBottomSheetSearchAndDirection = AnimationUtils.loadAnimation(mActivity, R.anim.show_bottom_sheet_search);

        animationShowParentFab.setAnimationListener(this);


        animationHideParentFab = AnimationUtils.loadAnimation(mActivity, R.anim.parent_fab_hide);
        animationHideFabRemoveMarker = AnimationUtils.loadAnimation(mActivity, R.anim.hide_fab_remove);
        animationHideFabMove = AnimationUtils.loadAnimation(mActivity, R.anim.hide_fab_move);
        animationHideFabDirection = AnimationUtils.loadAnimation(mActivity, R.anim.hide_fab_direction);
        animationHideBottomSheetSearchAndDirection = AnimationUtils.loadAnimation(mActivity, R.anim.hide_bottom_sheet_search);

        animationHideFabRemoveMarker.setAnimationListener(this);
        animationHideFabMove.setAnimationListener(this);
        animationHideFabDirection.setAnimationListener(this);
    }


    private void setListenerToMiniFabs(View view) {
        if (view == fabDirection) {
            if (selectedMarkerPosition != null && mGoogleMap != null) {

                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLng(selectedMarkerPosition), 1000, new GoogleMap.CancelableCallback() {
                    @Override
                    public void onFinish() {
                        onDirectionFabClicked = true;
                        onDirectionBtnClicked(selectedMarkerPosition);
                    }

                    @Override
                    public void onCancel() {

                    }
                });


            }
        }
//        TODO
        if (view == fabReplaceMarker) {
            if (mMarker != null) {
                if (!isMarkerDraging) {
                    mGoogleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
                        @Override
                        public void onCameraIdle() {
                            midCameraLatLng = mGoogleMap.getCameraPosition().target;
                        }
                    });

                    if (selectedMarkerPosition != null && mGoogleMap != null) {
                        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLng(selectedMarkerPosition), 1000, new GoogleMap.CancelableCallback() {
                            @Override
                            public void onFinish() {
                                imgFakeMarker.setVisibility(View.VISIBLE);
                                mMarker.setVisible(false);
                                isMarkerDraging = true;
                                linearCustomZoom.setVisibility(View.VISIBLE);
                                Toast.makeText(mActivity, getString(R.string.dragMarkerEnabled), Toast.LENGTH_SHORT).show();
                                snackbar = createSnakBar(getString(R.string.strMassegeReplaceHome));
                                snackbar.setAction(getString(R.string.yes), new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        try {
                                            if (mMarker != null) {
//                                                long getHomeId = dataBaseClassSample.getHomeId(String.valueOf(selectedMarkerPosition.latitude), String.valueOf(selectedMarkerPosition.longitude));
                                                isMarkerDraging = false;
                                                imgFakeMarker.setVisibility(View.GONE);
                                                linearCustomZoom.setVisibility(View.GONE);
                                                if (midCameraLatLng != null) {
                                                    mMarker.setPosition(midCameraLatLng);
                                                    mMarker.setVisible(true);
                                                    mMarker.setIcon((BitmapDescriptorFactory.fromResource(R.drawable.map_marker_selected)));
//                                                    dataBaseClassSample.updateHomePosition(getHomeId, String.valueOf(midCameraLatLng.latitude), String.valueOf(midCameraLatLng.longitude));
//                                                    dataBaseClassSample.updateHomePosition(mHome_id, String.valueOf(midCameraLatLng.latitude), String.valueOf(midCameraLatLng.longitude));
                                                    selectedMarkerPosition = midCameraLatLng;
                                                } else {
                                                    mMarker.setPosition(selectedMarkerPosition);
                                                    mMarker.setVisible(true);
                                                    mMarker.setIcon((BitmapDescriptorFactory.fromResource(R.drawable.map_marker_selected)));
                                                }
                                            }
                                        } catch (IllegalArgumentException i) {

                                        }
                                    }


                                });

                            }

                            @Override
                            public void onCancel() {

                            }
                        });

                    }
                }
            }
        }

        if (view == fabRemoveMarker) {
            if (selectedMarkerPosition != null && mGoogleMap != null) {
                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLng(selectedMarkerPosition), 1000, new GoogleMap.CancelableCallback() {
                    @Override
                    public void onFinish() {

                        final String latRemove = String.valueOf(mMarker.getPosition().latitude);
                        final String lngRemove = String.valueOf(mMarker.getPosition().longitude);
                        snackbar = createSnakBar(getString(R.string.strDialogBoxRemoveMarker));
                        snackbar.setAction(getString(R.string.yes), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                removePolylie();
                                if (mMarker != null) {
                                    mMarker.remove();
                                }
//                                RealmDataBase.deleteFromDatabase(latRemove, lngRemove);
                                hideSmallFloatingButtons();
//                                hideParentFab();
                            }
                        });
                    }

                    @Override
                    public void onCancel() {

                    }
                });


            }
        }


        if (view == fabParent)

        {
            if (selectedMarkerPosition != null && mGoogleMap != null) {

                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLng(selectedMarkerPosition), 1000, new GoogleMap.CancelableCallback() {
                    @Override
                    public void onFinish() {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (isShowSmallFabs && isShowParentFab) {
                                    if (mainBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                                        mainBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                                    }
                                }
                            }
                        }).start();
                    }

                    @Override
                    public void onCancel() {

                    }
                });


            }
        }

        if (view != fabReplaceMarker && mMarker != null && isMarkerDraging) {


            cancleReplacingHome();

            return;
        }
        if (view != fabDirection)
            onDirectionFabClicked = false;

        {
        }

    }


    private void onDirectionBtnClicked(LatLng destinationMarkerPosition) {
        checkPermissionAndFindLocation();
        checkGpsEnabled();
        if (isPermisionAccess()) {
            if (isGpsEnabled()) {
                initCurrentLocation();
                removePolylie();
                if (currentlatitudeGPS == 0 && currentlongitudeGPS == 0) {
                    initCurrentLocation();
                }
                final LatLng origin = new LatLng(currentlatitudeGPS, currentlongitudeGPS);
                final LatLng destenition = new LatLng(destinationMarkerPosition.latitude, destinationMarkerPosition.longitude);
                if (isNetworkConnected()) {

                    showRootLayoutSecondaryBS();
                    showProgressBarSecondaryBS();

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            requestDirection(origin, destenition);

                        }


                    });
                    thread.start();
                } else {
                    Toast.makeText(mActivity, getString(R.string.no_internet_access), Toast.LENGTH_LONG).show();
                }
            }
        }


    }

    private void createSecondaryBotomSheetWidgets() {
        rootLayoutSecondaryBS = (RelativeLayout) findViewById(R.id.search_bottom_sheet_root);
        fabSecondaryBS = (FloatingActionButton) findViewById(R.id.fabDirection_secondary_bs);

        progressBarSecondaryBS = (ProgressBar) findViewById(R.id.progress_bar_secondary_bs);

        contentLayoutSecondaryBSh = (LinearLayout) findViewById(R.id.secondary_bs_content_layout);
        txtAddressContentLayout = (TextView) findViewById(R.id.txtAddress_content_layout);
        txtDetailsContentLayout = (TextView) findViewById(R.id.txtDetails_group_search);

        linearErrorSecondaryBS = (LinearLayout) findViewById(R.id.search_bottom_sheet_linear_error);
        txtErrorNoRouteFound = (TextView) findViewById(R.id.txt_error_no_route_found);
        imgErrorNoRouteFound = (ImageView) findViewById(R.id.img_error_no_route_found);

        fabSecondaryBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchedPlaceLocation != null) {
                    onDirectionBtnClicked(searchedPlaceLocation);
                }
            }
        });


    }


    private void showRootLayoutSecondaryBS() {
        if (rootLayoutSecondaryBS != null && fabSecondaryBS != null) {
            if (rootLayoutSecondaryBS.getVisibility() != View.VISIBLE && fabSecondaryBS.getVisibility() != View.VISIBLE) {

                rootLayoutSecondaryBS.startAnimation(animationShowBottomSheetSearchAndDirection);
                rootLayoutSecondaryBS.setVisibility(View.VISIBLE);

                fabSecondaryBS.startAnimation(animationShowBottomSheetSearchAndDirection);
                fabSecondaryBS.setVisibility(View.VISIBLE);

                rootLayoutSecondaryBS.setClickable(true);
                fabSecondaryBS.setClickable(true);

                if (onDirectionFabClicked) {
                    rootLayoutSecondaryBS.setClickable(false);
                }


                if (isShowSmallFabs && isShowParentFab) {
                    hideMarkerDeatils();
                }
            }
//            ViewGroup.LayoutParams params = rootLayoutSecondaryBS.getLayoutParams();
//            params.height = height;
//            rootLayoutSecondaryBS.setLayoutParams(params);
            hideSnakeBar();
        }
    }

    private void showAndInitContentLayoutSecondaryBS(String str1, String str2) {
        if (rootLayoutSecondaryBS != null && fabSecondaryBS != null && contentLayoutSecondaryBSh != null) {
            if (rootLayoutSecondaryBS.getVisibility() == View.VISIBLE && fabSecondaryBS.getVisibility() == View.VISIBLE) {


                if (contentLayoutSecondaryBSh.getVisibility() != View.VISIBLE) {
                    contentLayoutSecondaryBSh.setVisibility(View.VISIBLE);
                }
                txtAddressContentLayout.setText(str1);
                txtDetailsContentLayout.setText(str2);


                hideProgressBarSecondaryBS();
                hideErrorLayouteSecondaryBS();

            }
        }
    }


    private void showProgressBarSecondaryBS() {
        if (progressBarSecondaryBS != null) {
            if (progressBarSecondaryBS.getVisibility() != View.VISIBLE) {

                progressBarSecondaryBS.setVisibility(View.VISIBLE);
                hideContentLayoutSecondaryBS();
                hideErrorLayouteSecondaryBS();

            }
        }
    }


    private void showErrorLayouteSecondaryBS() {
        if (linearErrorSecondaryBS != null) {
            if (linearErrorSecondaryBS.getVisibility() != View.VISIBLE) {

                linearErrorSecondaryBS.setVisibility(View.VISIBLE);
                hideContentLayoutSecondaryBS();
                hideProgressBarSecondaryBS();
            }
        }
    }

    private void hideRootLayoutSecondaryBS() {
        if (rootLayoutSecondaryBS != null && fabSecondaryBS != null) {
            if (rootLayoutSecondaryBS.getVisibility() == View.VISIBLE
                    && fabSecondaryBS.getVisibility() == View.VISIBLE) {

                rootLayoutSecondaryBS.startAnimation(animationHideBottomSheetSearchAndDirection);
                rootLayoutSecondaryBS.setVisibility(View.INVISIBLE);

                fabSecondaryBS.startAnimation(animationHideBottomSheetSearchAndDirection);
                fabSecondaryBS.setVisibility(View.INVISIBLE);

                fabSecondaryBS.setClickable(false);
                rootLayoutSecondaryBS.setClickable(false);

            }
        }
    }

    private void hideContentLayoutSecondaryBS() {
        if (contentLayoutSecondaryBSh != null) {
            if (contentLayoutSecondaryBSh.getVisibility() == View.VISIBLE) {
                contentLayoutSecondaryBSh.setVisibility(View.INVISIBLE);

                txtAddressContentLayout.setText("");
                txtDetailsContentLayout.setText("");
            }
        }

    }


    private void hideErrorLayouteSecondaryBS() {
        if (linearErrorSecondaryBS != null) {
            if (linearErrorSecondaryBS.getVisibility() == View.VISIBLE) {
                linearErrorSecondaryBS.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void hideProgressBarSecondaryBS() {
        if (progressBarSecondaryBS != null) {
            if (progressBarSecondaryBS.getVisibility() == View.VISIBLE) {
                progressBarSecondaryBS.setVisibility(View.INVISIBLE);
            }
        }
    }


    private void directionSucessAndDrawRoute() {
        if (directionPositionList != null) {
            polyline = mGoogleMap.addPolyline(DirectionConverter.createPolyline(mActivity, directionPositionList, 5
                    , Color.parseColor("#33aafc")));
            setCameraWithCoordinationBounds(route);
            if (route != null) {
                Leg leg = route.getLegList().get(0);
                Info distanceInfo = leg.getDistance();
                Info durationInfo = leg.getDuration();
                String routeDistance = "Distance :  " + distanceInfo.getText();
                String routeDuration = "Estimated Time :  " + durationInfo.getText();
                showAndInitContentLayoutSecondaryBS(routeDistance, routeDuration);
            }
        }

    }

    private void getLocationFromMyLocationClass() {
        MyLocation.LocationResult locationResult = new MyLocation.LocationResult() {
            @Override
            public void gotLocation(Location location) {
                if (location != null) {
                    currentlatitudeGPS = location.getLatitude();
                    currentlongitudeGPS = location.getLongitude();

                    currentlatitude = location.getLatitude();
                    currentlongitude = location.getLongitude();
                }
            }
        };
        MyLocation myLocation = new MyLocation();
        myLocation.getLocation(this, locationResult);
    }

    public void initCurrentLocation() {
        if (isPermisionAccess()) {
            locationManager = (LocationManager) mActivity.getSystemService(LOCATION_SERVICE);
            if (locationManager != null) {
                Location gpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                Location netLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if (gpsLocation != null) {
                    currentlatitudeGPS = gpsLocation.getLatitude();
                    currentlongitudeGPS = gpsLocation.getLongitude();
                } else if (netLocation != null) {
                    currentlatitudeGPS = netLocation.getLatitude();
                    currentlongitudeGPS = netLocation.getLongitude();

                } else if (currentLocationGps != null) {
                    currentlatitudeGPS = currentLocationGps.getLatitude();
                    currentlongitudeGPS = currentLocationGps.getLongitude();
                }
            }
        }

    }

    public void requestDirection(LatLng origin, LatLng destination) {
        GoogleDirection.withServerKey(SERVER_KEY).from(origin).to(destination).transportMode(TransportMode.DRIVING).execute(this);
    }

    @Override
    public void onDirectionSuccess(Direction direction, String rawBody) {
        if (direction != null) {
            if (direction.isOK()) {
                isDirection = true;
                route = direction.getRouteList().get(0);
                directionPositionList = route.getLegList().get(0).getDirectionPoint();
                directionSucessAndDrawRoute();

            } else {
                showErrorLayouteSecondaryBS();
            }
        }
    }


    @Override
    public void onDirectionFailure(Throwable t) {
        showErrorLayouteSecondaryBS();
    }

    private void setCameraWithCoordinationBounds(Route route) {
        LatLng southwest = route.getBound().getSouthwestCoordination().getCoordination();
        LatLng northeast = route.getBound().getNortheastCoordination().getCoordination();
        LatLngBounds bounds = new LatLngBounds(southwest, northeast);
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));

    }

    public void showParentFab() {
        if (fabParent.getVisibility() != View.VISIBLE) {
            fabParent.startAnimation(animationShowParentFab);


            fabParent.setVisibility(View.VISIBLE);
            isShowParentFab = true;

            isBeforAnimationEnd = 2;

        }

    }

    public void hideParentFab() {
        if (fabParent.getVisibility() == View.VISIBLE && fabParent.getVisibility() == View.VISIBLE && fabRemoveMarker.getVisibility() != View.VISIBLE &&
                fabReplaceMarker.getVisibility() != View.VISIBLE &&
                fabDirection.getVisibility() != View.VISIBLE) {
            fabParent.startAnimation(animationHideParentFab);

            isShowParentFab = false;
            fabParent.setVisibility(View.INVISIBLE);

            isBeforAnimationEnd = 0;
        }


    }


    private void showSmallFloatingButtons() {

        if (fabParent.getVisibility() == View.VISIBLE && fabRemoveMarker.getVisibility() != View.VISIBLE &&
                fabReplaceMarker.getVisibility() != View.VISIBLE &&
                fabDirection.getVisibility() != View.VISIBLE) {

            FrameLayout.LayoutParams layoutParamsDirection = (FrameLayout.LayoutParams) fabDirection.getLayoutParams();
            layoutParamsDirection.rightMargin += (int) (fabDirection.getWidth() * 1.7);
            layoutParamsDirection.bottomMargin += (int) (fabDirection.getHeight() * 0.25);
            fabDirection.setLayoutParams(layoutParamsDirection);
            fabDirection.startAnimation(animationShowFabDirection);
            fabDirection.setClickable(true);


            FrameLayout.LayoutParams layoutParamsMove = (FrameLayout.LayoutParams) fabReplaceMarker.getLayoutParams();
            layoutParamsMove.rightMargin += (int) (fabReplaceMarker.getWidth() * 1.5);
            layoutParamsMove.bottomMargin += (int) (fabReplaceMarker.getHeight() * 1.5);
            fabReplaceMarker.setLayoutParams(layoutParamsMove);
            fabReplaceMarker.startAnimation(animationShowFabMove);
            fabReplaceMarker.setClickable(true);


            FrameLayout.LayoutParams layoutParamsRemove = (FrameLayout.LayoutParams) fabRemoveMarker.getLayoutParams();
            layoutParamsRemove.rightMargin += (int) (fabRemoveMarker.getWidth() * 0.25);
            layoutParamsRemove.bottomMargin += (int) (fabRemoveMarker.getHeight() * 1.7);
            fabRemoveMarker.setLayoutParams(layoutParamsRemove);
            fabRemoveMarker.startAnimation(animationShowFabRemoveMarker);
            fabRemoveMarker.setClickable(true);

            fabRemoveMarker.setVisibility(View.VISIBLE);
            fabReplaceMarker.setVisibility(View.VISIBLE);
            fabDirection.setVisibility(View.VISIBLE);
            isShowSmallFabs = true;
        }

    }


    private void hideSmallFloatingButtons() {

        if (fabRemoveMarker.getVisibility() == View.VISIBLE &&
                fabReplaceMarker.getVisibility() == View.VISIBLE &&
                fabDirection.getVisibility() == View.VISIBLE) {


            FrameLayout.LayoutParams layoutParamsDirection = (FrameLayout.LayoutParams) fabDirection.getLayoutParams();
            layoutParamsDirection.rightMargin -= (int) (fabDirection.getWidth() * 1.7);
            layoutParamsDirection.bottomMargin -= (int) (fabDirection.getHeight() * 0.25);
            fabDirection.setLayoutParams(layoutParamsDirection);
            fabDirection.startAnimation(animationHideFabDirection);
            fabDirection.setClickable(false);


            FrameLayout.LayoutParams layoutParamsMove = (FrameLayout.LayoutParams) fabReplaceMarker.getLayoutParams();
            layoutParamsMove.rightMargin -= (int) (fabReplaceMarker.getWidth() * 1.5);
            layoutParamsMove.bottomMargin -= (int) (fabReplaceMarker.getHeight() * 1.5);
            fabReplaceMarker.setLayoutParams(layoutParamsMove);
            fabReplaceMarker.startAnimation(animationHideFabMove);
            fabReplaceMarker.setClickable(false);


            FrameLayout.LayoutParams layoutParamsRemove = (FrameLayout.LayoutParams) fabRemoveMarker.getLayoutParams();
            layoutParamsRemove.rightMargin -= (int) (fabRemoveMarker.getWidth() * 0.25);
            layoutParamsRemove.bottomMargin -= (int) (fabRemoveMarker.getHeight() * 1.7);
            fabRemoveMarker.setLayoutParams(layoutParamsRemove);
            fabRemoveMarker.startAnimation(animationHideFabRemoveMarker);
            fabRemoveMarker.setClickable(false);

            fabRemoveMarker.setVisibility(View.INVISIBLE);
            fabReplaceMarker.setVisibility(View.INVISIBLE);
            fabDirection.setVisibility(View.INVISIBLE);
            isShowSmallFabs = false;
            isBeforAnimationEnd = 1;
        }

    }


    public void getDisplaySize(LayoutInflater inflater, ViewGroup container) {
        DisplayMetrics dm = new DisplayMetrics();

        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        double wi = (double) width / (double) dm.xdpi;
        double hi = (double) height / (double) dm.ydpi;
        double x = Math.pow(wi, 2);
        double y = Math.pow(hi, 2);
        double screenInches = Math.sqrt(x + y);


//        if (screenInches < 6) {
//            mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//            googleMapFragment = inflater.inflate(R.layout.map_nav_drawer, container, false);
//
//        } else {
//            mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//            googleMapFragment = inflater.inflate(R.layout.map_nav_drawer_landscape, container, false);
//
//        }
    }


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
//
//                Rect outRect = new Rect();
//                bottomSheet.getGlobalVisibleRect(outRect);
//
//                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY()))
//                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//            }
//        }
//
//        return super.dispatchTouchEvent(event);
//    }

    private void createDrawerNavigation() {
        mapDrawer = (DrawerLayout) findViewById(R.id.map_drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.map_nav_drawer);
        navigationView.setNavigationItemSelectedListener(this);


        mapDrawer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                removeNewHomeMarker();
                hideSnakeBar();
                return false;
            }


        });

        View hView = navigationView.getHeaderView(0);
        TextView txtEmail = (TextView) hView.findViewById(R.id.txtEmail);
        TextView txtUserName = (TextView) hView.findViewById(R.id.txtUserName);
//        txtEmail.setTypeface(getFont());
//        txtUserName.setTypeface(getFont());

        Menu m = navigationView.getMenu();


        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
//                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
//            applyFontToMenuItem(mi);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {

            if (!trafficEnabled) {
                mGoogleMap.setTrafficEnabled(true);
                trafficEnabled = true;
            } else {
                mGoogleMap.setTrafficEnabled(false);
                trafficEnabled = false;
            }

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            if (mGoogleMap != null) {
                if (!satelliteMode) {
                    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    satelliteMode = true;
                } else {
                    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    satelliteMode = false;
                }
            }

        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(mActivity, "nav_slideshow", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_manage) {
//            MapView mapView = (MapView) findViewById(R.id.mapView);
//            // enable Street view by default
//            mapView.setStreetView(true);

        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.map_drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }


    private void updateCameraBearing(GoogleMap googleMap, float bearing) {
        if (googleMap == null) return;
        CameraPosition camPos = CameraPosition
                .builder(
                        googleMap.getCameraPosition() // current Camera
                )
                .bearing(bearing)
                .build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPos));
    }

//    public Typeface getFont() {
//        Typeface typefaceYekan = Typeface.createFromAsset(mActivity.getAssets(), "font/shabnam.ttf");
//        return typefaceYekan;
//    }

//    private void applyFontToMenuItem(MenuItem mi) {
//        SpannableString mNewTitle = new SpannableString(mi.getTitle());
//        mNewTitle.setSpan(new CustomTypefaceSpanNvd("", getFont()), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        mi.setTitle(mNewTitle);
//    }


    private void cancleReplacingHome() {
        isMarkerDraging = false;
        imgFakeMarker.setVisibility(View.GONE);
        mMarker.setVisible(true);
        try {
            mMarker.setIcon((BitmapDescriptorFactory.fromResource(R.drawable.map_marker_selected)));
        } catch (IllegalArgumentException i) {

        }
        linearCustomZoom.setVisibility(View.GONE);
        if (selectedMarkerPosition != null) {
            mMarker.setPosition(selectedMarkerPosition);
        }

        hideSnakeBar();
    }

    private void hideSnakeBar() {
        if (snackbar != null && snackbar.isShown()) {
            snackbar.dismiss();
        }
    }


    @Override
    public void onResume() {

        super.onResume();

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
        if (currentlatitudeGPS != 0 && currentlongitudeGPS != 0) {
            sharedPreferences.edit().putString(LATITUDE_KEY, String.valueOf(currentlatitudeGPS)).apply();
            sharedPreferences.edit().putString(LONGITUDE_KEY, String.valueOf(currentlongitudeGPS)).apply();
        } else {
            sharedPreferences.edit().putString(LATITUDE_KEY, String.valueOf(currentlatitude)).apply();
            sharedPreferences.edit().putString(LONGITUDE_KEY, String.valueOf(currentlongitude)).apply();
        }

        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        doubleBackToExit++;
        cardViewAppBar.setVisibility(View.VISIBLE);
        if (doubleBackToExit == 1) {

            if (isHomeSaved == 1 && !isExpanded) {
                createAlertDialogMelkNotSave();
                doubleBackToExit = 0;
                return;
            }

            if (mMarker != null && mGoogleMap != null && isMarkerDraging) {
                cancleReplacingHome();
                doubleBackToExit = 0;
                return;
            }

            if (snackbar != null && snackbar.isShown()) {
                removeNewHomeMarker();
                hideSnakeBar();
                doubleBackToExit = 0;
                return;
            }
            if (mainBehavior != null && mainBehavior.getState() != BottomSheetBehavior.STATE_HIDDEN) {
                mainBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                doubleBackToExit = 0;
                return;
            }
            if (mapDrawer != null && mapDrawer.isDrawerOpen(GravityCompat.END)) {
                mapDrawer.closeDrawer(Gravity.RIGHT);
                doubleBackToExit = 0;
                return;
            }

            if (rootLayoutSecondaryBS != null && fabSecondaryBS != null && rootLayoutSecondaryBS.getVisibility() == View.VISIBLE && fabSecondaryBS.getVisibility() == View.VISIBLE) {
                if (isDirection) {
                    removePolylie();
                }
                hideRootLayoutSecondaryBS();
                doubleBackToExit = 0;
                return;
            }


            if (isShowSmallFabs && isShowParentFab) {
                hideMarkerDeatils();
                cardViewAppBar.setVisibility(View.VISIBLE);

                doubleBackToExit = 0;
                return;
            }


            if (mMarkerSearch != null && mMarkerSearch.isVisible()) {

                mMarkerSearch.setVisible(false);
                mMarkerSearch.remove();
                if (polyline != null) {
                    removePolylie();
                    polyline = null;
                }
                doubleBackToExit = 0;
                return;
            }


        }
        new Handler().
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doubleBackToExit = 0;
                    }
                }, 2000);
        if (doubleBackToExit == 2) {
            super.onBackPressed();
        }

    }

    private void removePolylie() {
        if (locationManager != null) {
            if (polyline != null) {
                polyline.remove();
                isDirection = false;
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        if (imageReturnedIntent == null) {
            showError("Failed to open picture!");
            return;
        }
        final Uri selectedUri = imageReturnedIntent.getData();
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    if (selectedUri != null) {
                        selectImageFromDeviceAction(imageReturnedIntent);
                    }

                }
                break;
            case 1:
                if (resultCode == RESULT_OK) {
                    if (selectedUri != null) {
                        selectImageFromDeviceAction(imageReturnedIntent);
                    }
                }
                break;


        }
        if (requestCode == UCrop.REQUEST_CROP) {
            try {
                handleCropResult(imageReturnedIntent);
            } catch (IOException e) {

            }
        }

        if (resultCode == UCrop.RESULT_ERROR) {
            handleCropError(imageReturnedIntent);
        }


    }

    private void handleCropResult(Intent imageReturnedIntent) throws IOException {
        final Uri resultUri = UCrop.getOutput(imageReturnedIntent);
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resultUri);
        if (compressedImage != null) {
            adapter.imgDialogMelkGallary.setImageBitmap(bitmap);
        } else {
            Toast.makeText(mActivity, "cannot_retrieve_cropped_image", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleCropError(@NonNull Intent result) {
        final Throwable cropError = UCrop.getError(result);
        if (cropError != null) {
            Toast.makeText(mActivity, cropError.getMessage(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mActivity, R.string.toast_unexpected_error, Toast.LENGTH_SHORT).show();
        }

    }

    private void startCrop() {
        if (compressedImage != null) {
            UCrop uCrop = UCrop.of(Uri.fromFile(compressedImage), Uri.fromFile(new File(getCacheDir(), "selectedImage")));
            uCrop = uCrop.withAspectRatio(1, 1);
            uCrop.useSourceImageAspectRatio();
            UCrop.Options options = new UCrop.Options();
            options.setCompressionQuality(100);

            if (GALLERY_REQUEST == REQUEST_SELECT_PICTURE_FOR_FRAGMENT) {
                setupFragment(uCrop);
            } else {
                uCrop.start(mActivity);
            }
        }
    }


    private void selectImageFromDeviceAction(Intent imageReturnedIntent) {
        try {
            actualImage = FileUtil.from(mActivity, imageReturnedIntent.getData());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    compressImage();
                }
            }).start();
        } catch (IOException e) {

        }
    }


    public void compressImage() {
        if (actualImage == null) {
            showError("Please choose an image!");
        } else {

            new id.zelory.compressor.Compressor(mActivity)
                    .compressToFileAsFlowable(actualImage)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<File>() {
                        @Override
                        public void accept(File file) {
                            compressedImage = file;
                            startCrop();


                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) {
                            throwable.printStackTrace();
                            showError(throwable.getMessage());
                        }
                    });
        }
    }


    public void setupFragment(UCrop uCrop) {
        UCropFragment fragment = uCrop.getFragment(uCrop.getIntent(mActivity).getExtras());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment, UCropFragment.TAG)
                .commitAllowingStateLoss();

    }

    @Override
    public void onPause() {
        super.onPause();
        if (currentlatitudeGPS != 0 && currentlongitudeGPS != 0) {
            sharedPreferences.edit().putString(LATITUDE_KEY, String.valueOf(currentlatitudeGPS)).apply();
            sharedPreferences.edit().putString(LONGITUDE_KEY, String.valueOf(currentlongitudeGPS)).apply();
        } else {
            sharedPreferences.edit().putString(LATITUDE_KEY, String.valueOf(currentlatitude)).apply();
            sharedPreferences.edit().putString(LONGITUDE_KEY, String.valueOf(currentlongitude)).apply();
        }

    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (isBeforAnimationEnd == 2) {
            showSmallFloatingButtons();
        }
        if (isBeforAnimationEnd == 1) {
            hideParentFab();
        }
    }


    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }


//this code for zooming camera so that showing all marker
//     shoMarker(){
// for (Marker marker : markers) {
//        builder.include(marker.getPosition());
//}
//    LatLngBounds bounds = builder.build();
//
//    int padding = 0; // offset from edges of the map in pixels
//    CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
//                                        googleMap.animateCamera(cu);
// }


    //this code maybe usefull for route title
//                                  RouteOptions routeOptions = new RouteOptions();
//                                  routeOptions.setTransportMode(RouteOptions.TransportMode.CAR);
//                                 routeOptions.setRouteType(RouteOptions.Type.FASTEST);
//                                 routePlan.setRouteOptions(routeOptions);
    private void setValueToModelFields(MapModel mapModel, Group group) {
        group.setSpTransTypeValue(mapModel.getSpTransTypeModel());
        group.setSpMelkTypeValue(mapModel.getSpMelkTypeModel());

        group.setEdtMelkAreaValue(mapModel.getEdtMelkAreaModel());
        group.setEdtAmountSellPerMetricValue(mapModel.getEdtAmountSellPerMetricModel());
        group.setSwInstallmentValue(mapModel.isSwInstallmentModel());
        group.setEdtAmountSellValue(mapModel.getEdtAmountSellModel());
        group.setEdtInstallmentTermsValue(mapModel.getEdtInstallmentTermsModel());
        group.setEdtAmountRentValue(mapModel.getEdtAmountRentModel());
        group.setEdtAmountRahnValue(mapModel.getEdtAmountRahnModel());
        group.setTgbChangeableToRentValue(mapModel.isTgbChangeableToRentModel());
        group.setTgbChangeableToRahnValue(mapModel.isTgbChangeableToRahnModel());
        group.setHpNumberOfOwnersValue(mapModel.getHpNumberOfOwnersModel());
        group.setEdtOwnerInformationsValue(mapModel.getEdtOwnerInformationsModel());
        group.setHpDungForSellValue(mapModel.getHpDungForSellModel());
        group.setEdtSinceQuantityValue(mapModel.getEdtSinceQuantityModel());
        group.setHpMaxAllowedForResidencesValue(mapModel.getHpMaxAllowedForResidencesModel());
        group.setHpPercentageOfProgressMadeValue(mapModel.getHpPercentageOfProgressMadeModel());
        group.setTxtSelectMelkReceiveTimeValue(mapModel.getTxtSelectMelkReceiveTimeModel());
        group.setHpMelkAgeValue(mapModel.getHpMelkAgeModel());
        group.setHpNumberOfBedRoomsValue(mapModel.getHpNumberOfBedRoomsModel());
        group.setHpFloorNumberValue(mapModel.getHpFloorNumberModel());
        group.setHpNumberOfFloorsValue(mapModel.getHpNumberOfFloorsModel());
        group.setHpNumberOfUnitInFloorValue(mapModel.getHpNumberOfUnitInFloorModel());

        group.setSwDateOfQuitValue(mapModel.isSwDateOfQuitModel());
        group.setTxtDateOfQuitValue(mapModel.getTxtDateOfQuitModel());

        group.setSwHasLoanValue(mapModel.isSwHasLoanModel());
        group.setEdtAmountLoanValue(mapModel.getEdtAmountLoanModel());
        group.setHpNumberOfElevatorValue(mapModel.getHpNumberOfElevatorModel());
        group.setHpNumberOfBathRoomValue(mapModel.getHpNumberOfBathRoomModel());
        group.setHpNumberOfParkingValue(mapModel.getHpNumberOfParkingModel());
        group.setHpNumberOfKitchenValue(mapModel.getHpNumberOfKitchenModel());
        group.setHpNumberOfMasterRoomValue(mapModel.getHpNumberOfMasterRoomModel());
        group.setHpNumberOfIranianToiletValue(mapModel.getHpNumberOfIraniToiletModel());
        group.setHpNumberOfFarangiToiletValue(mapModel.getHpNumberOfFarangiToiletModel());

        group.setHpNumberOfTellSubValue(mapModel.getHpNumberOfTellSubModel());

        group.setEdtAmountMountChargeValue(mapModel.getEdtAmountMountChargeModel());
        group.setHpNumberOfRoofSpaceValue(mapModel.getHpNumberOfRoofSpaceModel());
        group.setHpHeightOfTheCeilingValue(mapModel.getHpHeightOfTheCeilingModel());
        group.setHpMelkWidthValue(mapModel.getHpMelkWidthModel());

        group.setTgbFlatUnitTypeValue(mapModel.isTgbFlatUnitTypeModel());
        group.setTgbDoublexUnitTypeValue(mapModel.isTgbDoublexUnitTypeModel());
        group.setTgbTriplexUnitTypeValue(mapModel.isTgbTriplexUnitTypeModel());
        group.setTgbBeachMelkPositionsValue(mapModel.isTgbBeachMelkPositionsModel());
        group.setTgbJangleMelkPositionsValue(mapModel.isTgbJangleMelkPositionsModel());
        group.setTgbMountainMelkPositionsValue(mapModel.isTgbMountainMelkPositionsModel());
        group.setTgbTownshipMelkPositionsValue(mapModel.isTgbTownshipMelkPositionsModel());

        group.setTgbPatioPossibilitiesValue(mapModel.isTgbPatioPossibilitiesModel());
        group.setTgbWaterWellPossibilitiesValue(mapModel.isTgbWaterWellPossibilitiesModel());
        group.setTgbBalconyPossibilitiesValue(mapModel.isTgbBalconyPossibilitiesModel());
        group.setTgbVideoIphonePossibilitiesValue(mapModel.isTgbVideoIphonePossibilitiesModel());
        group.setTgbWallClosetPossibilitiesValue(mapModel.isTgbWallClosetPossibilitiesModel());
        group.setTgbStorePossibilitiesValue(mapModel.isTgbStorePossibilitiesModel());
        group.setTgbYardPossibilitiesValue(mapModel.isTgbYardPossibilitiesModel());
        group.setTgbJantorPossibilitiesValue(mapModel.isTgbJantorPossibilitiesModel());
        group.setTgbRebuildPossibilitiesValue(mapModel.isTgbRebuildPossibilitiesModel());
        group.setTgbSofaPossibilitiesValue(mapModel.isTgbSofaPossibilitiesModel());
        group.setTgbCameraPossibilitiesValue(mapModel.isTgbCameraPossibilitiesModel());
        group.setTgbCentralAntennaPossibilitiesValue(mapModel.isTgbCentralAntennaPossibilitiesModel());
        group.setTgbChangeablePossibilitiesValue(mapModel.isTgbChangeablePossibilitiesModel());


        group.setTgbLobbySpecialFeaturesValue(mapModel.isTgbLobbySpecialFeaturesModel());
        group.setTgbBathtubSpecialFeaturesValue(mapModel.isTgbBathtubSpecialFeaturesModel());
        group.setTgbSwimmingPoolSpecialFeaturesValue(mapModel.isTgbSwimmingPoolSpecialFeaturesModel());
        group.setTgbFirePlaceSpecialFeaturesValue(mapModel.isTgbFirePlaceSpecialFeaturesModel());
        group.setTgbChildrenPlaySpaceSpecialFeaturesValue(mapModel.isTgbChildrenPlaySpaceSpecialFeaturesModel());
        group.setTgbGardenYardSpecialFeaturesValue(mapModel.isTgbGardenYardSpecialFeaturesModel());
        group.setTgbCentralVacuumCleanerSpecialFeaturesValue(mapModel.isTgbCentralVacuumCleanerSpecialFeaturesModel());
        group.setTgbAmphitheaterSpecialFeaturesValue(mapModel.isTgbAmphitheaterSpecialFeaturesModel());
        group.setTgbConferenceHallSpecialFeaturesValue(mapModel.isTgbConferenceHallSpecialFeaturesModel());
        group.setTgbFirefightSpecialFeaturesValue(mapModel.isTgbFirefightSpecialFeaturesModel());
        group.setTgbSolarBatterySpecialFeaturesValue(mapModel.isTgbSolarBatterySpecialFeaturesModel());
        group.setTgbFountainSpecialFeaturesValue(mapModel.isTgbFountainSpecialFeaturesModel());
        group.setTgbCargoElevatorSpecialFeaturesValue(mapModel.isTgbCargoElevatorSpecialFeaturesModel());
        group.setTgbWaterSupplySpecialFeaturesValue(mapModel.isTgbWaterSupplySpecialFeaturesModel());
        group.setTgbTennisCourtFeaturesValue(mapModel.isTgbTennisCourtFeaturesModel());
        group.setTgbGuestParkingSpecialFeaturesValue(mapModel.isTgbGuestParkingSpecialFeaturesModel());
        group.setTgbSaunaSpecialFeaturesValue(mapModel.isTgbSaunaSpecialFeaturesModel());
        group.setTgbJacuzziSpecialFeaturesValue(mapModel.isTgbJacuzziSpecialFeaturesModel());
        group.setTgbChildrenPoolSpecialFeaturesValue(mapModel.isTgbChildrenPoolSpecialFeaturesModel());
        group.setTgbRoofGardenSpecialFeaturesValue(mapModel.isTgbRoofGardenSpecialFeaturesModel());
        group.setTgbBarbecueSpecialFeaturesValue(mapModel.isTgbBarbecueSpecialFeaturesModel());
        group.setTgbShootingWasteSpecialFeaturesValue(mapModel.isTgbShootingWasteSpecialFeaturesModel());
        group.setTgbAltarSpecialFeaturesValue(mapModel.isTgbAltarSpecialFeaturesModel());
        group.setTgbSecuritySystemSpecialFeaturesValue(mapModel.isTgbSecuritySystemSpecialFeaturesModel());
        group.setTgbSmartHomeSpecialFeaturesValue(mapModel.isTgbSmartHomeSpecialFeaturesModel());
        group.setTgbSafeguardSpecialFeaturesValue(mapModel.isTgbSafeguardSpecialFeaturesModel());
        group.setTgbEmergencyPowerSpecialFeaturesValue(mapModel.isTgbEmergencyPowerSpecialFeaturesModel());
        group.setTgbCaretakersRoomSpecialFeaturesValue(mapModel.isTgbCaretakersRoomSpecialFeaturesModel());
        group.setTgbSecurityDoorSpecialFeaturesValue(mapModel.isTgbSecurityDoorSpecialFeaturesModel());
        group.setTgbWaterPurifierSpecialFeaturesValue(mapModel.isTgbWaterPurifierSpecialFeaturesModel());
        group.setTgbParkingRemoteSpecialFeaturesValue(mapModel.isTgbParkingRemoteSpecialFeaturesModel());
        group.setTgbPoolTableSpecialFeaturesValue(mapModel.isTgbPoolTableSpecialFeaturesModel());


        group.setTgbWestGeoPositionValue(mapModel.isTgbWestGeoPositionModel());
        group.setTgbEstGeoPositionValue(mapModel.isTgbEstGeoPositionModel());
        group.setTgbSouthGeoPositionValue(mapModel.isTgbSouthGeoPositionModel());
        group.setTgbNorthGeoPositionValue(mapModel.isTgbNorthGeoPositionModel());
        group.setTgbBlotsButsStructTypeValue(mapModel.isTgbBlotsButsStructTypeModel());
        group.setTgbMetalStructTypeValue(mapModel.isTgbMetalStructTypeModel());
        group.setTgbConcreteAndBarStructTypeValue(mapModel.isTgbConcreteAndBarStructTypeModel());
        group.setTgbWestLightingDirectValue(mapModel.isTgbWestLightingDirectModel());
        group.setTgbEstLightingDirectValue(mapModel.isTgbEstLightingDirectModel());
        group.setTgbSouthtLightingDirectValue(mapModel.isTgbSouthtLightingDirectModel());
        group.setTgbNorthLightingDirectValue(mapModel.isTgbNorthLightingDirectModel());

        group.setTgbGoodwillValue(mapModel.isTgbGoodwillModel());
        group.setTgbPropertyValue(mapModel.isTgbPropertyModel());
        group.setTgbThreePhaseElectricValue(mapModel.isTgbThreePhaseElectricModel());
        group.setTgbOnePhaseElectricValue(mapModel.isTgbOnePhaseElectricModel());
        group.setTgbShareElectricValue(mapModel.isTgbShareElectricModel());
        group.setTgbPrivateElectricValue(mapModel.isTgbShareElectricModel());
        group.setTgbShareGasMeterValue(mapModel.isTgbShareGasMeterModel());
        group.setTgbPrivateGasMeterValue(mapModel.isTgbPrivateGasMeterModel());
        group.setTgbShareWaterMeterValue(mapModel.isTgbShareWaterMeterModel());
        group.setTgbPrivateWaterMeterValue(mapModel.isTgbPrivateWaterMeterModel());


        group.setTgbPersonalTypeOfMelkDocumentValue(mapModel.isTgbPersonalTypeOfMelkDocumentModel());
        group.setTgbEndowmentsTypeOfMelkDocumentValue(mapModel.isTgbEndowmentsTypeOfMelkDocumentModel());
        group.setTgbCommercialTypeOfMelkDocumentValue(mapModel.isTgbCommercialTypeOfMelkDocumentModel());
        group.setTgbShariRulerTypeOfMelkDocumentValue(mapModel.isTgbShariRulerTypeOfMelkDocumentModel());
        group.setTgbOrganizationalTypeOfMelkDocumentValue(mapModel.isTgbOrganizationalTypeOfMelkDocumentModel());
        group.setTgbOfficalTypeOfMelkDocumentValue(mapModel.isTgbOfficalTypeOfMelkDocumentModel());
        group.setTgbCooperativeTypeOfMelkDocumentValue(mapModel.isTgbCooperativeTypeOfMelkDocumentModel());
        group.setTgbProxyTypeOfMelkDocumentValue(mapModel.isTgbProxyTypeOfMelkDocumentModel());
        group.setTgbLetterOfCreditTypeOfMelkDocumentValue(mapModel.isTgbLetterOfCreditTypeOfMelkDocumentModel());
        group.setTgbJointlyTypeOfMelkDocumentValue(mapModel.isTgbJointlyTypeOfMelkDocumentModel());
        group.setTgbResidentialTypeOfMelkDocumentValue(mapModel.isTgbResidentialTypeOfMelkDocumentModel());
        group.setTgbIndustrialTypeOfMelkDocumentValue(mapModel.isTgbIndustrialTypeOfMelkDocumentModel());

        group.setTgbPackageCoolingHealingSystemValue(mapModel.isTgbPackageCoolingHealingSystemModel());
        group.setTgbHeaterCoolingHealingSystemValue(mapModel.isTgbHeaterCoolingHealingSystemModel());
        group.setTgbChilerCoolingHealingSystemValue(mapModel.isTgbChilerCoolingHealingSystemModel());
        group.setTgbWaterCoolerCoolingHealingSystemValue(mapModel.isTgbWaterCoolerCoolingHealingSystemModel());
        group.setTgbFanCoilCoolingHealingSystemValue(mapModel.isTgbFanCoilCoolingHealingSystemModel());
        group.setTgbCentralEngineRoomCoolingHealingSystemValue(mapModel.isTgbCentralEngineRoomCoolingHealingSystemModel());
        group.setTgbFloorHeatingCoolingHealingSystemValue(mapModel.isTgbFloorHeatingCoolingHealingSystemModel());
        group.setTgbAirConditionerCoolingHealingSystemValue(mapModel.isTgbAirConditionerCoolingHealingSystemModel());
        group.setTgbGasCoolerCoolingHealingSystemValue(mapModel.isTgbGasCoolerCoolingHealingSystemModel());

        group.setTgbStoneFloorCoveringValue(mapModel.isTgbStoneFloorCoveringModel());
        group.setTgbCarpetFloorCoveringValue(mapModel.isTgbCarpetFloorCoveringModel());
        group.setTgbParquetFloorCoveringValue(mapModel.isTgbParquetFloorCoveringModel());
        group.setTgbMosaicFloorCoveringValue(mapModel.isTgbMosaicFloorCoveringModel());
        group.setTgbAsphaltFloorCoveringValue(mapModel.isTgbAsphaltFloorCoveringModel());
        group.setTgbCeramicFloorCoveringValue(mapModel.isTgbCeramicFloorCoveringModel());
        group.setTgbLaminatFloorCoveringValue(mapModel.isTgbLaminatFloorCoveringModel());
        group.setTgbWoodFloorCoveringValue(mapModel.isTgbWoodFloorCoveringModel());
        group.setTgbGraniteFloorCoveringValue(mapModel.isTgbGraniteFloorCoveringModel());
        group.setTgbCementFloorCoveringValue(mapModel.isTgbCementFloorCoveringModel());

        group.setTgbKonteksBuildingFacadesValue(mapModel.isTgbKonteksBuildingFacadesModel());
        group.setTgbAluminumBuildingFacadesValue(mapModel.isTgbAluminumBuildingFacadesModel());
        group.setTgbBrickBuildingFacadesValue(mapModel.isTgbBrickBuildingFacadesModel());
        group.setTgbCementBuildingFacadesValue(mapModel.isTgbCementBuildingFacadesModel());
        group.setTgbWoodBuildingFacadesValue(mapModel.isTgbWoodBuildingFacadesModel());
        group.setTgbStoneBuildingFacadesValue(mapModel.isTgbStoneBuildingFacadesModel());
        group.setTgbCeramicBuildingFacadesValue(mapModel.isTgbCeramicBuildingFacadesModel());
        group.setTgbGlassBuildingFacadesValue(mapModel.isTgbGlassBuildingFacadesModel());
        group.setTgbCompositeBuildingFacadesValue(mapModel.isTgbCompositeBuildingFacadesModel());


        group.setTgbHiGlassKitchenCabinetsValue(mapModel.isTgbHiGlassKitchenCabinetsModel());
        group.setTgbHdfKitchenCabinetsValue(mapModel.isTgbHdfKitchenCabinetsModel());


        group.setTgbMetalKitchenCabinetsValue(mapModel.isTgbMetalKitchenCabinetsModel());
        group.setTgbMdfKitchenCabinetsValue(mapModel.isTgbMdfKitchenCabinetsModel());
        group.setTgbwoodKitchenCabinetsValue(mapModel.isTgbwoodKitchenCabinetsModel());
        group.setTgbPvcKitchenCabinetsValue(mapModel.isTgbPvcKitchenCabinetsModel());

        group.setTgbPassageBuildingTypeValue(mapModel.isTgbPassageBuildingTypeModel());
        group.setTgbVillaBuildingTypeValue(mapModel.isTgbVillaBuildingTypeModel());
        group.setTgbTowerBuildingTypeValue(mapModel.isTgbTowerBuildingTypeModel());
        group.setTgbApartmentBuildingTypeValue(mapModel.isTgbApartmentBuildingTypeModel());
        group.setTgbIntegratedBuildingTypeValue(mapModel.isTgbIntegratedBuildingTypeModel());

        group.setTgbLakeViewValue(mapModel.isTgbLakeViewModel());
        group.setTgbJangleViewValue(mapModel.isTgbJangleViewModel());
        group.setTgbCityViewValue(mapModel.isTgbCityViewModel());
        group.setTgbPanoramaViewValue(mapModel.isTgbPanoramaViewModel());
        group.setTgbParkViewValue(mapModel.isTgbParkViewModel());
        group.setTgbMountainViewValue(mapModel.isTgbMountainViewModel());
        group.setTgbSeaViewValue(mapModel.isTgbSeaViewModel());
        group.setTgbRiverViewValue(mapModel.isTgbRiverViewModel());
        group.setTgbSkyViewValue(mapModel.isTgbSkyViewModel());

        group.setTgbLibraryRoomTypeValue(mapModel.isTgbLibraryRoomTypeModel());
        group.setTgbDressingRoomTypeValue(mapModel.isTgbDressingRoomTypeModel());
        group.setTgbDiningRoomTypeValue(mapModel.isTgbDiningRoomTypeModel());
        group.setTgbWorkShopRoomTypeValue(mapModel.isTgbWorkShopRoomTypeModel());
        group.setTgbWorkRoomTypeValue(mapModel.isTgbWorkRoomTypeModel());
        group.setTgbHomeLollipopRoomTypeValue(mapModel.isTgbHomeLollipopRoomTypeModel());

        group.setTgbRefrigeratorFurnishedFacilitiesValue(mapModel.isTgbRefrigeratorFurnishedFacilitiesModel());
        group.setTgbMacrowaveFurnishedFacilitiesValue(mapModel.isTgbMacrowaveFurnishedFacilitiesModel());
        group.setTgbCarpeteFurnishedFacilitiesValue(mapModel.isTgbCarpeteFurnishedFacilitiesModel());
        group.setTgbChandelierFurnishedFacilitiesValue(mapModel.isTgbChandelierFurnishedFacilitiesModel());
        group.setTgbVacuumeCleanerFurnishedFacilitiesValue(mapModel.isTgbVacuumeCleanerFurnishedFacilitiesModel());
        group.setTgbDishwasherFurnishedFacilitiesValue(mapModel.isTgbDishwasherFurnishedFacilitiesModel());
        group.setTgbBedFurnishedFacilitiesValue(mapModel.isTgbBedFurnishedFacilitiesModel());
        group.setTgbOvenFurnishedFacilitiesValue(mapModel.isTgbOvenFurnishedFacilitiesModel());
        group.setTgbFurnitureFurnishedFacilitiesValue(mapModel.isTgbFurnitureFurnishedFacilitiesModel());

        group.setTgbTelevisionFurnishedFacilitiesValue(mapModel.isTgbTelevisionFurnishedFacilitiesModel());
        group.setTgbOttoFurnishedFacilitiesValue(mapModel.isTgbOttoFurnishedFacilitiesModel());
        group.setTgbWashingMachineFurnishedFacilitiesValue(mapModel.isTgbWashingMachineFurnishedFacilitiesModel());
        group.setTgbDishesFurnishedFacilitiesValue(mapModel.isTgbDishesFurnishedFacilitiesModel());
        group.setTgbDishesCurtainFacilitiesValue(mapModel.isTgbDishesCurtainFacilitiesModel());


        group.setTgbGentleWindowsType(mapModel.isTgbGentleWindowsType());
        group.setTgbPvcTowShellsWindowsType(mapModel.isTgbPvcTowShellsWindowsType());
        group.setTgbMetalWindowsType(mapModel.isTgbMetalWindowsType());
        group.setTgbWoodWindowsType(mapModel.isTgbWoodWindowsType());
        group.setTgbMetalTowShellsWindowsType(mapModel.isTgbMetalTowShellsWindowsType());
        group.setTgbFiberGlassWindowsType(mapModel.isTgbFiberGlassWindowsType());
        group.setTgbAluminiumThermalBreak(mapModel.isTgbAluminiumThermalBreak());

        group.setTgbOfficialUsageTypeValue(mapModel.isTgbOfficialUsageTypeModel());
        group.setTgbCommercialUsageTypeValue(mapModel.isTgbCommercialUsageTypeModel());
        group.setTgbIndustrialUsageTypeValue(mapModel.isTgbIndustrialUsageTypeModel());
        group.setTgbStoreUsageTypeValue(mapModel.isTgbStoreUsageTypeModel());
        group.setTgbAnimalHusbandryUsageTypeValue(mapModel.isTgbAnimalHusbandryUsageTypeModel());
        group.setTgbEducationalUsageTypeValue(mapModel.isTgbEducationalUsageTypeModel());
        group.setTgbResidentialUsageTypeValue(mapModel.isTgbResidentialUsageTypeModel());
        group.setTgbAdministrativePositionUsageTypeValue(mapModel.isTgbAdministrativePositionUsageTypeModel());
        group.setTgbResidentUsageTypeValue(mapModel.isTgbResidentUsageTypeModel());
        group.setTgbAgricultureUsageTypeValue(mapModel.isTgbAgricultureUsageTypeModel());
        group.setTgbSportsUsageTypeValue(mapModel.isTgbSportsUsageTypeModel());
        group.setTgbClinicUsageTypeValue(mapModel.isTgbClinicUsageTypeModel());

        group.setHpDistanceToVehicleValue(mapModel.getHpDistanceToVehicleModel());
        group.setEdtMoreInfoValue(mapModel.getEdtMoreInfoModel());


    }
}