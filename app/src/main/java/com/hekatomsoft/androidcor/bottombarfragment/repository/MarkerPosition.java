package com.hekatomsoft.androidcor.bottombarfragment.repository;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class MarkerPosition extends RealmObject {
    @PrimaryKey
    private long melk_id;
    private String marker_lat;
    private String marker_lng;

    public long getMelk_id() {
        return melk_id;
    }

    public void setMelk_id(long melk_id) {
        this.melk_id = melk_id;
    }

    public String getMarker_lat() {
        return marker_lat;
    }

    public void setMarker_lat(String marker_lat) {
        this.marker_lat = marker_lat;
    }

    public String getMarker_lng() {
        return marker_lng;
    }

    public void setMarker_lng(String marker_lng) {
        this.marker_lng = marker_lng;
    }
}
