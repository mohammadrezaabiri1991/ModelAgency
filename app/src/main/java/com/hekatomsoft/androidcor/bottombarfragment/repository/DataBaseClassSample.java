//package com.hekatomsoft.androidcor.bottombarfragment.repository;
//
//
//import android.app.Activity;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.os.Environment;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.google.android.gms.maps.model.Marker;
//import com.hekatomsoft.androidcor.bottombarfragment.googlemap.Group;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.nio.channels.FileChannel;
//import java.util.ArrayList;
//import java.util.HashMap;
//
///**
// * Created by Parsania Hardik on 11/01/2016.
// */
//public class DataBaseClassSample extends SQLiteOpenHelper {
//
//    public Context myContext;
//    public static final int DBVERSION = 1;
//
//    public static final String DATABASE_NAME = "db_hoooooommmee";
//    public static final String TABLE_HOME = "t_home";
//    private static final String TABLE_UNITS = "t_units";
//
//    private static final String KEY_MARKER_LAT = "marker_lat";
//    private static final String KEY_MARKER_LNG = "marker_lng";
//
//    //    public static final String HOME_ID = BaseColumns._ID;
//    public static final String HOME_ID = "home_id";
//    private static final String UNIT_ID = "unit_id";
//    public static final String HOME_TYPE = "home_type";
//    private static final String TRANSACE_ATION_TYPE = "transace_ation_type";
//    public static final String MELK_AREA = "melk_area";
//    public static final String AMOUNT_SELL_PER_METRIC = "amount_sell_per_metric";
//    private static final String AMOUNT_SELL = "amount_sell";
//
//    private String CREATE_TABLE_MAP_MARKERS = "CREATE TABLE IF NOT EXISTS " + TABLE_HOME +
//            "("
//            + HOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
//            + KEY_MARKER_LAT + " TEXT , "
//            + KEY_MARKER_LNG + " TEXT , " +
//            " UNIQUE("
//            + KEY_MARKER_LAT + ","
//            + KEY_MARKER_LNG +
//            ")"
//            + ")";
//    //    AUTOINCREMENT
//    private static final String CREATE_TABLE_MAP_MARKER_INFO = "CREATE TABLE IF NOT EXISTS "
//            + TABLE_UNITS +
//            "("
//            + HOME_ID + " INTEGER NOT NULL,"
//            + UNIT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
//            + HOME_TYPE + " INTEGER ,"
//            + TRANSACE_ATION_TYPE + " INTEGER ,"
//            + MELK_AREA + " TEXT ,"
//            + AMOUNT_SELL_PER_METRIC + " TEXT ,"
//            + AMOUNT_SELL + " TEXT ," +
//            " FOREIGN KEY (home_id) REFERENCES t_home(home_id)" +
//            ")";
//
//
//    public static long keepHomeId;
//    public static HashMap<String, Long> unitsIdHashMap = new HashMap<>();
//
//    public DataBaseClassSample(Context context) {
//        super(context, DATABASE_NAME, null, DBVERSION);
//
//
//        File direct = new File(Environment.getExternalStorageDirectory() + "");
////
//        if (!direct.exists()) {
//            if (direct.mkdir()) {
//                //directory is created;
//                Toast.makeText(context, "created ",
//                        Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(context, "dontExist ",
//                        Toast.LENGTH_LONG).show();
//            }
//
//        }
////        exportDB(context);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TABLE_MAP_MARKER_INFO);
//        db.execSQL(CREATE_TABLE_MAP_MARKERS);
//
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_UNITS + "'");
//        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_HOME + "'");
//        onCreate(db);
//    }
////Constraints محدودیت ها
////    @Override
////    public void onConfigure(SQLiteDatabase db) {
////        db.setForeignKeyConstraintsEnabled(true);
////    }
//
//    public void addInformationToTable(Group item, int mHome_id, Marker mMarker, Activity activity) {
//
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues homeValues = new ContentValues();
//        ContentValues unit_values = new ContentValues();
//
//        homeValues.put(KEY_MARKER_LAT, String.valueOf(mMarker.getPosition().latitude));
//        homeValues.put(KEY_MARKER_LNG, String.valueOf(mMarker.getPosition().longitude));
//
//
//        long home_id = getHomeId(String.valueOf(mMarker.getPosition().latitude), String.valueOf(mMarker.getPosition().longitude));
////        Toast.makeText(activity, "marker_id  : " + marker_id, Toast.LENGTH_LONG).show();
//        db.update(TABLE_HOME, homeValues, HOME_ID + " = ?", new String[]{String.valueOf(home_id)});
//        if (home_id <= 0) {
//            keepHomeId = home_id = db.insertWithOnConflict(TABLE_HOME, null, homeValues, SQLiteDatabase.CONFLICT_IGNORE);
//        }
//
//        unit_values.put(HOME_ID, home_id);
//        unit_values.put(TRANSACE_ATION_TYPE, item.getSpTransTypeValue());
//        unit_values.put(HOME_TYPE, item.getSpMelkTypeValue());
//        unit_values.put(MELK_AREA, item.getEdtMelkAreaValue());
//        unit_values.put(AMOUNT_SELL_PER_METRIC, item.getEdtAmountSellPerMetricValue());
//        unit_values.put(AMOUNT_SELL, item.getEdtAmountSellValue());
//
//
//        if (item.getUnitIdValue() <= 0) {
//            if (unitsIdHashMap != null) {
//                if (unitsIdHashMap.containsKey(item.toString())) {
//                    item.setUnitId_value(unitsIdHashMap.get(item.toString()));
////                    Toast.makeText(activity, "getUnit_id : " + unit_id, Toast.LENGTH_LONG).show();
//                }
//            }
//        }
//
//        db.update(TABLE_UNITS, unit_values, UNIT_ID + " = ?", new String[]{String.valueOf(item.getUnitIdValue())});
//        if (item.getUnitIdValue() <= 0) {
//            item.setUnitId_value(db.insertWithOnConflict(TABLE_UNITS, null, unit_values, SQLiteDatabase.CONFLICT_IGNORE));
//            unitsIdHashMap.put(item.toString(), item.getUnitIdValue());
////            Toast.makeText(activity, "putUnit_id : " + unit_id, Toast.LENGTH_LONG).show();
//        }
//
//
////        ArrayList<String> getUnitId = getUnitId(String.valueOf(marker_id));
//
//
//    }
//
//    //---------------------------------------------------------------------------------*************************--------------------------------------------------------------------------------------------
//    public void updateHomePosition(long home_id, String map_marker_lat_value, String map_marker_lng_value) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues homeValues = new ContentValues();
//
//        homeValues.put(KEY_MARKER_LAT, map_marker_lat_value);
//        homeValues.put(KEY_MARKER_LNG, map_marker_lng_value);
//
//
//        db.update(TABLE_HOME, homeValues, HOME_ID + " = ?", new String[]{String.valueOf(home_id)});
//    }
//
//    //---------------------------------------------------------------------------------*************************--------------------------------------------------------------------------------------------
//    public ArrayList<MapModel> fetchMarkerInfos(Activity mActivity, String
//            marker_lat_value, String marker_lng_value) {
//
//        logAllRows(TABLE_HOME, "MYTAG");
//        logAllRows(TABLE_UNITS, "MYTAG");
//
//        ArrayList<MapModel> mapModels = new ArrayList<MapModel>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT " + HOME_ID + " FROM " + TABLE_HOME + " WHERE " + KEY_MARKER_LAT + " = " + "'" + marker_lat_value + "'" + " AND " + KEY_MARKER_LNG + " = " + "'" + marker_lng_value + "'", null);
//        while (cursor.moveToNext()) {
//            MapModel mapModel = new MapModel();
//            mapModel.setMelk_id_Model(Integer.valueOf(cursor.getString(cursor.getColumnIndex(HOME_ID))));
//            String selectHomeQuery = "SELECT  * FROM " + TABLE_UNITS + " WHERE " + HOME_ID + " = " + mapModel.getMelk_id_Model();
//            Cursor cMarkeInfo = db.rawQuery(selectHomeQuery, null);
//
//            while (cMarkeInfo.moveToNext()) {
//                mapModel.setUnitId_Model(Long.valueOf(cMarkeInfo.getString(cMarkeInfo.getColumnIndex(UNIT_ID))));
//                mapModel.setSpTransTypeModel(Integer.valueOf(cMarkeInfo.getString(cMarkeInfo.getColumnIndex(TRANSACE_ATION_TYPE))));
////                mapModel.setSpHomeTypeModel(Integer.valueOf(cMarkeInfo.getString(cMarkeInfo.getColumnIndex(HOME_TYPE))));
//                mapModel.setEdtMelkAreaModel(cMarkeInfo.getString(cMarkeInfo.getColumnIndex(MELK_AREA)));
//                mapModel.setEdtAmountSellPerMetricModel(cMarkeInfo.getString(cMarkeInfo.getColumnIndex(AMOUNT_SELL_PER_METRIC)));
//                mapModel.setEdtAmountSellModel(cMarkeInfo.getString(cMarkeInfo.getColumnIndex(AMOUNT_SELL)));
//                mapModels.add(mapModel);
//                mapModel = new MapModel();
//                mapModel.setMelk_id_Model(mapModels.get(0).getMelk_id_Model());
//            }
//            cMarkeInfo.close();
//        }
//        cursor.close();
//        return mapModels;
//    }
//
//    public ArrayList<MapModel> fetchMarkerPositions() {
//        ArrayList<MapModel> markerArrayList = new ArrayList<MapModel>();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_HOME + " WHERE " + KEY_MARKER_LAT + " AND " + KEY_MARKER_LNG;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = db.rawQuery(selectQuery, null);
//        if (c.moveToFirst()) {
//            do {
//                MapModel markerPositions = new MapModel();
////                markerPositions.setMelk_id(c.getInt(c.getColumnIndex(KEY_MARKER_LAT)));
//                markerPositions.setMarkerPositionLat(c.getString(c.getColumnIndex(KEY_MARKER_LAT)));
//                markerPositions.setMarkerPositionLng(c.getString(c.getColumnIndex(KEY_MARKER_LNG)));
//                markerArrayList.add(markerPositions);
//            } while (c.moveToNext());
//        }
//        c.close();
//        return markerArrayList;
//    }
//
//
//    public void deleteUnit(long id, Activity activity, Group groupId) {
//        if (id <= 0) {
//            if (unitsIdHashMap != null) {
//                if (groupId != null) {
//                    if (unitsIdHashMap.containsKey(String.valueOf(groupId.toString()))) {
//                        id = unitsIdHashMap.get(String.valueOf(groupId.toString()));
//                    }
//                }
//            }
//        }
////        Toast.makeText(activity, "id  : " + id, Toast.LENGTH_LONG).show();
//        // delete row in students table based on id
//        SQLiteDatabase db = this.getWritableDatabase();
//        //deleting from users_hobby table
//        db.delete(TABLE_UNITS, UNIT_ID + " = ?", new String[]{String.valueOf(id)});
//    }
//
//    public void deleteHome(int id, Activity activity) {
//        if (id <= 0) {
//            id = Integer.parseInt(String.valueOf(keepHomeId));
//        }
//        // delete row in students table based on id
//        SQLiteDatabase db = this.getWritableDatabase();
//        //deleting from users table
//        db.delete(TABLE_HOME, HOME_ID + " = ?", new String[]{String.valueOf(id)});
//    }
//
//    private void logAllRows(String tablename, String TAG) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        StringBuilder sb = new StringBuilder();
//        Cursor csr = db.query(tablename, null, null, null, null, null, null);
//        while (csr.moveToNext()) {
//            sb.append("\nRow # = ").append(String.valueOf(csr.getPosition() + 1));
//            for (int i = 0; i < csr.getColumnCount(); i++) {
//                sb.append("\n\tColumn is ").append(csr.getColumnName(i)).append(" Value is ");
//                int columntype = csr.getType(i);
//                switch (columntype) {
//                    case Cursor.FIELD_TYPE_NULL:
//                        sb.append("NULL");
//                        break;
//                    case Cursor.FIELD_TYPE_FLOAT:
//                        sb.append(String.valueOf(csr.getDouble(i)));
//                        break;
//                    case Cursor.FIELD_TYPE_INTEGER:
//                        sb.append(String.valueOf(csr.getInt(i)));
//                        break;
//                    case Cursor.FIELD_TYPE_STRING:
//                        sb.append(csr.getString(i));
//                        break;
//                    case Cursor.FIELD_TYPE_BLOB:
//                        sb.append("BLOB");
//                        break;
//                }
//            }
//        }
//        csr.close();
//        Log.d("MYTAG", sb.toString());
//    }
//
//    protected void exportDb() {
//        try {
//            File sd = Environment.getExternalStorageDirectory();
//            File data = Environment.getDataDirectory();
//            if (sd.canWrite()) {
//                String currentDBPath = "//data//{com.hekatomsoft.androidcoretemplate}//databases//{dataaaaaaa}";
//                String backupDBPath = "{dataaaaaaa}";
//                File currentDB = new File(data, currentDBPath);
//                File backupDB = new File(sd, backupDBPath);
//
//                if (currentDB.exists()) {
//                    FileChannel src = new FileInputStream(currentDB).getChannel();
//                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
//                    dst.transferFrom(src, 0, src.size());
//                    src.close();
//                    dst.close();
//                }
//            }
//        } catch (Exception e) {
//        }
//    }
//
//    //exporting database
//    private void exportDB(Context mActivity) {
//        // TODO Auto-generated method stub
//
//        try {
//            File sd = Environment.getExternalStorageDirectory();
//            File data = Environment.getDataDirectory();
//
//            if (sd.canWrite()) {
//                String currentDBPath = "//data//" + "com.hekatomsoft.androidcoretemplate"
//                        + "//databases//" + "dataaaaaaa";
//                String backupDBPath = "/dataaaaaaa.db";
//                File currentDB = new File(data, currentDBPath);
//                File backupDB = new File(sd, backupDBPath);
//
//                FileChannel src = new FileInputStream(currentDB).getChannel();
//                FileChannel dst = new FileOutputStream(backupDB).getChannel();
//                dst.transferFrom(src, 0, src.size());
//                src.close();
//                dst.close();
//                Toast.makeText(mActivity, backupDB.toString(),
//                        Toast.LENGTH_LONG).show();
//
//            } else {
//                Toast.makeText(mActivity, "cant ",
//                        Toast.LENGTH_LONG).show();
//            }
//        } catch (Exception e) {
//
//            Toast.makeText(mActivity, e.toString(), Toast.LENGTH_LONG)
//                    .show();
//
//        }
//    }
//
//    public long getHomeId(String marker_lat_value, String marker_lng_value) {
//        Cursor cursor = null;
//        long id = 0;
//        try {
//            SQLiteDatabase db = this.getReadableDatabase();
//            cursor = db.rawQuery("SELECT " + HOME_ID + " FROM " + TABLE_HOME + " WHERE " + KEY_MARKER_LAT + " = " + "'"
//                    + marker_lat_value + "'" + " AND " + KEY_MARKER_LNG + " = " + "'" + marker_lng_value + "'", null);
//            if (cursor.getCount() > 0) {
//                cursor.moveToFirst();
//                id = Long.parseLong(cursor.getString(cursor.getColumnIndex(HOME_ID)));
//
//            }
//            return id;
//        } finally {
//            cursor.close();
//        }
//    }
//
//    public ArrayList<String> getUnitId(String home_id) {
//        Cursor cursor = null;
//        ArrayList<String> id = new ArrayList<>();
//        try {
//            SQLiteDatabase db = this.getReadableDatabase();
//            cursor = db.rawQuery("SELECT " + UNIT_ID + " FROM " + TABLE_UNITS + " WHERE " + HOME_ID + " = " + home_id, null);
//            while (cursor.moveToNext()) {
////                cursor.moveToFirst();
//                String unit_id = cursor.getString(cursor.getColumnIndex(UNIT_ID));
//                id.add(unit_id);
//            }
//            cursor.close();
//            return id;
//
//        } finally {
////            cursor.close();
//        }
//    }
//}