package com.hekatomsoft.androidcor.bottombarfragment.repository;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

import com.google.android.gms.maps.model.Marker;
import com.hekatomsoft.androidcor.bottombarfragment.googlemap.Group;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.REALM_FILE_NAME;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_ANDROID;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_DATA;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_LAT_MARKER_POSITION;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_LNG_MARKER_POSITION;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_MELK_ID_MAP_MODEL;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_MELK_ID_MARKER_POSITION;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_REALM;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_SLASH;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.STR_UNIT_ID;

public class RealmDataBase extends Application {

//    private static final String EXPORT_REALM_PATH = "/data/user/0/";

    public static Context myContext;
    public static HashMap<String, Long> unitsIdHashMap = new HashMap<>();
    private long keepHomeId;


    @Override
    public void onCreate() {
        myContext = this.getApplicationContext();
        super.onCreate();
//        configRealmDatabase();
//        backups();
//        restore();
    }

    public void addToRealmDataBase(final Group group, final Marker mMarker) {


        final Realm mRealm = Realm.getDefaultInstance();
        final MapModel mapModel = new MapModel();
        final MarkerPosition markerPosition = new MarkerPosition();
        try {
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    long melkId = getNextMelkId(mRealm, mMarker);
                    keepHomeId = melkId;
                    MarkerPosition position = addValueToMarkerPosition(mMarker, melkId, markerPosition);
                    long finalUnitId = getNextUnitId(group, mRealm);

                    mapModel.setMarkerPosition(position);
                    mapModel.setMelk_id_Model(melkId);
                    mapModel.setUnitId_Model(finalUnitId);
                    setValueToModelFields(mapModel, group);


                    mRealm.copyToRealmOrUpdate(mapModel);
                    mRealm.commitTransaction();
                }
            });


        } finally {
            if (mRealm != null) {
                mRealm.close();
            }
        }
    }


    public MarkerPosition addValueToMarkerPosition(Marker mMarker, long melkId, MarkerPosition markerPosition) {
        markerPosition.setMelk_id(melkId);
        markerPosition.setMarker_lat(String.valueOf(mMarker.getPosition().latitude));
        markerPosition.setMarker_lng(String.valueOf(mMarker.getPosition().longitude));
        return markerPosition;
    }

    private void configRealmDatabase() {
        RealmConfiguration config = new RealmConfiguration.Builder(myContext)
                .name(REALM_FILE_NAME)
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(config);
    }

    public long getNextMelkId(Realm realm, Marker mMarker) {
        MarkerPosition getCurrentId = realm.where(MarkerPosition.class).equalTo(STR_LAT_MARKER_POSITION, String.valueOf(mMarker.getPosition().latitude))
                .equalTo(STR_LNG_MARKER_POSITION, String.valueOf(mMarker.getPosition().longitude)).findFirst();

        try {
            Number number = realm.where(MarkerPosition.class).max(STR_MELK_ID_MARKER_POSITION);
            if (getCurrentId != null) {
                if (getCurrentId.getMelk_id() != 0) {
                    return getCurrentId.getMelk_id();
                } else {
                    if (number != null) {
                        return (number.longValue() + 1);
                    } else {
                        return 1;
                    }
                }
            } else {
                if (number != null) {
                    return (number.longValue() + 1);
                } else {
                    return 1;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 1;
        }
    }

    public long getNextUnitId(Group item, Realm realm) {
        try {
            Number number = realm.where(MapModel.class).max(STR_UNIT_ID);
            if (item.getUnitId_value() > 0) {
                return item.getUnitId_value();
            } else {
                if (unitsIdHashMap != null) {
                    if (unitsIdHashMap.containsKey(item.toString())) {
                        return unitsIdHashMap.get(item.toString());
                    }
                }
                if (item.getUnitId_value() <= 0 && number != null) {
                    unitsIdHashMap.put(item.toString(), (number.longValue() + 1));
                    return (number.longValue() + 1);
                } else {
                    unitsIdHashMap.put(item.toString(), (long) 1);
                    return 1;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            unitsIdHashMap.put(item.toString(), (long) 1);
            return 1;
        }
    }


    public void backups() {
        Realm realm = Realm.getDefaultInstance();
        File exportRealmFile = null;

        File exportRealmPATH = myContext.getExternalFilesDir(null);
        String exportRealmFileName = REALM_FILE_NAME;


        // create a backup file
        exportRealmFile = new File(exportRealmPATH, exportRealmFileName);

        // if backup file already exists, delete it
        exportRealmFile.delete();

        // copy current realm to backup file
        try {
            realm.writeCopyTo(exportRealmFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String msg = "File exported to Path: " + myContext.getExternalFilesDir(null);
        Toast.makeText(myContext, "path :  " + msg, Toast.LENGTH_LONG).show();
        realm.close();

    }


    public void restore() {
        File exportRealmPATH = myContext.getExternalFilesDir(null);
        String FileName = REALM_FILE_NAME;

        String restoreFilePath = myContext.getExternalFilesDir(null) + STR_SLASH + FileName;
        Toast.makeText(myContext, "paths :  " + restoreFilePath, Toast.LENGTH_LONG).show();
        copyBundledRealmFile(restoreFilePath, FileName);

    }

    private void copyBundledRealmFile(String oldFilePath, String outFileName) {
        try {
            File file = new File(myContext.getFilesDir(), outFileName);

            FileOutputStream outputStream = new FileOutputStream(file);

            FileInputStream inputStream = new FileInputStream(new File(oldFilePath));

            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, bytesRead);
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String dbPath() {
        Realm realm = Realm.getDefaultInstance();
        return realm.getPath();
    }

    public String getRealmPath(Context context) {

        String externalStorageDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        String packageName = context.getApplicationContext().getPackageName();
        return externalStorageDir + File.separator + STR_ANDROID + File.separator + STR_DATA + File.separator + packageName + File.separator + STR_REALM + File.separator;
    }

    public void deleteHome(long id, final Activity activity) {
        Realm realm = Realm.getDefaultInstance();

        Toast.makeText(activity, "idAfter  : " + id, Toast.LENGTH_LONG).show();

        if (id <= 0) {
            id = Integer.parseInt(String.valueOf(keepHomeId));
        }
        Toast.makeText(activity, "idBefore  : " + id, Toast.LENGTH_LONG).show();
        realm.beginTransaction();
        RealmResults<MapModel> rows1 = realm.where(MapModel.class).equalTo(STR_MELK_ID_MAP_MODEL, id).findAll();
        RealmResults<MarkerPosition> rows = realm.where(MarkerPosition.class).equalTo(STR_MELK_ID_MARKER_POSITION, id).findAll();

        Toast.makeText(activity, "size1  : " + rows.size(), Toast.LENGTH_LONG).show();
        Toast.makeText(activity, "size2  : " + rows1.size(), Toast.LENGTH_LONG).show();
        rows1.clear();
        rows.clear();
        realm.commitTransaction();
        realm.close();


    }

    public int deleteUnit(long id, final Activity activity, final Group group) {
        Realm realm = Realm.getDefaultInstance();

        if (id <= 0) {
            if (unitsIdHashMap != null) {
                if (group != null) {
                    if (unitsIdHashMap.containsKey(String.valueOf(group.toString()))) {
                        id = unitsIdHashMap.get(String.valueOf(group.toString()));
                    }
                }
            }
        }
        final long finalId = id;
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
        realm.beginTransaction();
        Toast.makeText(activity, "id  : " + finalId, Toast.LENGTH_LONG).show();
        Toast.makeText(activity, "getUnitIdValue  : " + group.getUnitId_value(), Toast.LENGTH_LONG).show();
        RealmResults<MapModel> rows = realm.where(MapModel.class).equalTo(STR_UNIT_ID, finalId).findAll();
        rows.clear();
        realm.commitTransaction();
//                realm.close();
//            }
//        });


        return 2;
    }


    //    public void exportDatabase() {
//        //deleting from users table
//        SQLiteDatabase db = this.getWritableDatabase();
//        // delete row in students table based on id
//        }
//            id = Integer.parseInt(String.valueOf(keepHomeId));
//        if (id <= 0) {
    private void setValueToModelFields(MapModel mapModel, Group group) {

        mapModel.setSpTransTypeModel(group.getSpTransTypeValue());
        mapModel.setSpMelkTypeModel(group.getSpMelkTypeValue());

        mapModel.setEdtMelkAreaModel(group.getEdtMelkAreaValue());
        mapModel.setEdtAmountSellPerMetricModel(group.getEdtAmountSellPerMetricValue());
        mapModel.setSwInstallmentModel(group.isSwInstallmentValue());
        mapModel.setEdtAmountSellModel(group.getEdtAmountSellValue());
        mapModel.setEdtInstallmentTermsModel(group.getEdtInstallmentTermsValue());
        mapModel.setEdtAmountRentModel(group.getEdtAmountRentValue());
        mapModel.setEdtAmountRahnModel(group.getEdtAmountRahnValue());
        mapModel.setTgbChangeableToRentModel(group.isTgbChangeableToRentValue());
        mapModel.setTgbChangeableToRahnModel(group.isTgbChangeableToRahnValue());
        mapModel.setHpNumberOfOwnersModel(group.getHpNumberOfOwnersValue());
        mapModel.setEdtOwnerInformationsModel(group.getEdtOwnerInformationsValue());
        mapModel.setHpDungForSellModel(group.getHpDungForSellValue());
        mapModel.setEdtSinceQuantityModel(group.getEdtSinceQuantityValue());
        mapModel.setHpMaxAllowedForResidencesModel(group.getHpMaxAllowedForResidencesValue());
        mapModel.setHpPercentageOfProgressMadeModel(group.getHpPercentageOfProgressMadeValue());
        mapModel.setTxtSelectMelkReceiveTimeModel(group.getTxtSelectMelkReceiveTimeValue());
        mapModel.setHpMelkAgeModel(group.getHpMelkAgeValue());
        mapModel.setHpNumberOfBedRoomsModel(group.getHpNumberOfBedRoomsValue());
        mapModel.setHpFloorNumberModel(group.getHpFloorNumberValue());
        mapModel.setHpNumberOfFloorsModel(group.getHpNumberOfFloorsValue());
        mapModel.setHpNumberOfUnitInFloorModel(group.getHpNumberOfUnitInFloorValue());

        mapModel.setSwDateOfQuitModel(group.isSwDateOfQuitValue());
        mapModel.setTxtDateOfQuitModel(group.getTxtDateOfQuitValue());

        mapModel.setSwHasLoanModel(group.isSwHasLoanValue());
        mapModel.setEdtAmountLoanModel(group.getEdtAmountLoanValue());
        mapModel.setHpNumberOfElevatorModel(group.getHpNumberOfElevatorValue());
        mapModel.setHpNumberOfBathRoomModel(group.getHpNumberOfBathRoomValue());
        mapModel.setHpNumberOfParkingModel(group.getHpNumberOfParkingValue());
        mapModel.setHpNumberOfKitchenModel(group.getHpNumberOfKitchenValue());
        mapModel.setHpNumberOfMasterRoomModel(group.getHpNumberOfMasterRoomValue());
        mapModel.setHpNumberOfIraniToiletModel(group.getHpNumberOfIranianToiletValue());
        mapModel.setHpNumberOfFarangiToiletModel(group.getHpNumberOfFarangiToiletValue());

        mapModel.setHpNumberOfTellSubModel(group.getHpNumberOfTellSubValue());

        mapModel.setEdtAmountMountChargeModel(group.getEdtAmountMountChargeValue());
        mapModel.setHpNumberOfRoofSpaceModel(group.getHpNumberOfRoofSpaceValue());
        mapModel.setHpHeightOfTheCeilingModel(group.getHpHeightOfTheCeilingValue());
        mapModel.setHpMelkWidthModel(group.getHpMelkWidthValue());

        mapModel.setTgbFlatUnitTypeModel(group.isTgbFlatUnitTypeValue());
        mapModel.setTgbDoublexUnitTypeModel(group.isTgbDoublexUnitTypeValue());
        mapModel.setTgbTriplexUnitTypeModel(group.isTgbTriplexUnitTypeValue());
        mapModel.setTgbBeachMelkPositionsModel(group.isTgbBeachMelkPositionsValue());
        mapModel.setTgbJangleMelkPositionsModel(group.isTgbJangleMelkPositionsValue());
        mapModel.setTgbMountainMelkPositionsModel(group.isTgbMountainMelkPositionsValue());
        mapModel.setTgbTownshipMelkPositionsModel(group.isTgbTownshipMelkPositionsValue());

        mapModel.setTgbPatioPossibilitiesModel(group.isTgbPatioPossibilitiesValue());
        mapModel.setTgbWaterWellPossibilitiesModel(group.isTgbWaterWellPossibilitiesValue());
        mapModel.setTgbBalconyPossibilitiesModel(group.isTgbBalconyPossibilitiesValue());
        mapModel.setTgbVideoIphonePossibilitiesModel(group.isTgbVideoIphonePossibilitiesValue());
        mapModel.setTgbWallClosetPossibilitiesModel(group.isTgbWallClosetPossibilitiesValue());
        mapModel.setTgbStorePossibilitiesModel(group.isTgbStorePossibilitiesValue());
        mapModel.setTgbYardPossibilitiesModel(group.isTgbYardPossibilitiesValue());
        mapModel.setTgbJantorPossibilitiesModel(group.isTgbJantorPossibilitiesValue());
        mapModel.setTgbRebuildPossibilitiesModel(group.isTgbRebuildPossibilitiesValue());
        mapModel.setTgbSofaPossibilitiesModel(group.isTgbSofaPossibilitiesValue());
        mapModel.setTgbCameraPossibilitiesModel(group.isTgbCameraPossibilitiesValue());
        mapModel.setTgbCentralAntennaPossibilitiesModel(group.isTgbCentralAntennaPossibilitiesValue());
        mapModel.setTgbChangeablePossibilitiesModel(group.isTgbChangeablePossibilitiesValue());


        mapModel.setTgbLobbySpecialFeaturesModel(group.isTgbLobbySpecialFeaturesValue());
        mapModel.setTgbBathtubSpecialFeaturesModel(group.isTgbBathtubSpecialFeaturesValue());
        mapModel.setTgbSwimmingPoolSpecialFeaturesModel(group.isTgbSwimmingPoolSpecialFeaturesValue());
        mapModel.setTgbFirePlaceSpecialFeaturesModel(group.isTgbFirePlaceSpecialFeaturesValue());
        mapModel.setTgbChildrenPlaySpaceSpecialFeaturesModel(group.isTgbChildrenPlaySpaceSpecialFeaturesValue());
        mapModel.setTgbGardenYardSpecialFeaturesModel(group.isTgbGardenYardSpecialFeaturesValue());
        mapModel.setTgbCentralVacuumCleanerSpecialFeaturesModel(group.isTgbCentralVacuumCleanerSpecialFeaturesValue());
        mapModel.setTgbAmphitheaterSpecialFeaturesModel(group.isTgbAmphitheaterSpecialFeaturesValue());
        mapModel.setTgbConferenceHallSpecialFeaturesModel(group.isTgbConferenceHallSpecialFeaturesValue());
        mapModel.setTgbFirefightSpecialFeaturesModel(group.isTgbFirefightSpecialFeaturesValue());
        mapModel.setTgbSolarBatterySpecialFeaturesModel(group.isTgbSolarBatterySpecialFeaturesValue());
        mapModel.setTgbFountainSpecialFeaturesModel(group.isTgbFountainSpecialFeaturesValue());
        mapModel.setTgbCargoElevatorSpecialFeaturesModel(group.isTgbCargoElevatorSpecialFeaturesValue());
        mapModel.setTgbWaterSupplySpecialFeaturesModel(group.isTgbWaterSupplySpecialFeaturesValue());
        mapModel.setTgbTennisCourtFeaturesModel(group.isTgbTennisCourtFeaturesValue());
        mapModel.setTgbGuestParkingSpecialFeaturesModel(group.isTgbGuestParkingSpecialFeaturesValue());
        mapModel.setTgbSaunaSpecialFeaturesModel(group.isTgbSaunaSpecialFeaturesValue());
        mapModel.setTgbJacuzziSpecialFeaturesModel(group.isTgbJacuzziSpecialFeaturesValue());
        mapModel.setTgbChildrenPoolSpecialFeaturesModel(group.isTgbChildrenPoolSpecialFeaturesValue());
        mapModel.setTgbRoofGardenSpecialFeaturesModel(group.isTgbRoofGardenSpecialFeaturesValue());
        mapModel.setTgbBarbecueSpecialFeaturesModel(group.isTgbBarbecueSpecialFeaturesValue());
        mapModel.setTgbShootingWasteSpecialFeaturesModel(group.isTgbShootingWasteSpecialFeaturesValue());
        mapModel.setTgbAltarSpecialFeaturesModel(group.isTgbAltarSpecialFeaturesValue());
        mapModel.setTgbSecuritySystemSpecialFeaturesModel(group.isTgbSecuritySystemSpecialFeaturesValue());
        mapModel.setTgbSmartHomeSpecialFeaturesModel(group.isTgbSmartHomeSpecialFeaturesValue());
        mapModel.setTgbSafeguardSpecialFeaturesModel(group.isTgbSafeguardSpecialFeaturesValue());
        mapModel.setTgbEmergencyPowerSpecialFeaturesModel(group.isTgbEmergencyPowerSpecialFeaturesValue());
        mapModel.setTgbCaretakersRoomSpecialFeaturesModel(group.isTgbCaretakersRoomSpecialFeaturesValue());
        mapModel.setTgbSecurityDoorSpecialFeaturesModel(group.isTgbSecurityDoorSpecialFeaturesValue());
        mapModel.setTgbWaterPurifierSpecialFeaturesModel(group.isTgbWaterPurifierSpecialFeaturesValue());
        mapModel.setTgbParkingRemoteSpecialFeaturesModel(group.isTgbParkingRemoteSpecialFeaturesValue());
        mapModel.setTgbPoolTableSpecialFeaturesModel(group.isTgbPoolTableSpecialFeaturesValue());


        mapModel.setTgbWestGeoPositionModel(group.isTgbWestGeoPositionValue());
        mapModel.setTgbEstGeoPositionModel(group.isTgbEstGeoPositionValue());
        mapModel.setTgbSouthGeoPositionModel(group.isTgbSouthGeoPositionValue());
        mapModel.setTgbNorthGeoPositionModel(group.isTgbNorthGeoPositionValue());
        mapModel.setTgbBlotsButsStructTypeModel(group.isTgbBlotsButsStructTypeValue());
        mapModel.setTgbMetalStructTypeModel(group.isTgbMetalStructTypeValue());
        mapModel.setTgbConcreteAndBarStructTypeModel(group.isTgbConcreteAndBarStructTypeValue());
        mapModel.setTgbWestLightingDirectModel(group.isTgbWestLightingDirectValue());
        mapModel.setTgbEstLightingDirectModel(group.isTgbEstLightingDirectValue());
        mapModel.setTgbSouthtLightingDirectModel(group.isTgbSouthtLightingDirectValue());
        mapModel.setTgbNorthLightingDirectModel(group.isTgbNorthLightingDirectValue());

        mapModel.setTgbGoodwillModel(group.isTgbGoodwillValue());
        mapModel.setTgbPropertyModel(group.isTgbPropertyValue());
        mapModel.setTgbThreePhaseElectricModel(group.isTgbThreePhaseElectricValue());
        mapModel.setTgbOnePhaseElectricModel(group.isTgbOnePhaseElectricValue());
        mapModel.setTgbShareElectricModel(group.isTgbShareElectricValue());
        mapModel.setTgbPrivateElectricModel(group.isTgbShareElectricValue());
        mapModel.setTgbShareGasMeterModel(group.isTgbShareGasMeterValue());
        mapModel.setTgbPrivateGasMeterModel(group.isTgbPrivateGasMeterValue());
        mapModel.setTgbShareWaterMeterModel(group.isTgbShareWaterMeterValue());
        mapModel.setTgbPrivateWaterMeterModel(group.isTgbPrivateWaterMeterValue());


        mapModel.setTgbPersonalTypeOfMelkDocumentModel(group.isTgbPersonalTypeOfMelkDocumentValue());
        mapModel.setTgbEndowmentsTypeOfMelkDocumentModel(group.isTgbEndowmentsTypeOfMelkDocumentValue());
        mapModel.setTgbCommercialTypeOfMelkDocumentModel(group.isTgbCommercialTypeOfMelkDocumentValue());
        mapModel.setTgbShariRulerTypeOfMelkDocumentModel(group.isTgbShariRulerTypeOfMelkDocumentValue());
        mapModel.setTgbOrganizationalTypeOfMelkDocumentModel(group.isTgbOrganizationalTypeOfMelkDocumentValue());
        mapModel.setTgbOfficalTypeOfMelkDocumentModel(group.isTgbOfficalTypeOfMelkDocumentValue());
        mapModel.setTgbCooperativeTypeOfMelkDocumentModel(group.isTgbCooperativeTypeOfMelkDocumentValue());
        mapModel.setTgbProxyTypeOfMelkDocumentModel(group.isTgbProxyTypeOfMelkDocumentValue());
        mapModel.setTgbLetterOfCreditTypeOfMelkDocumentModel(group.isTgbLetterOfCreditTypeOfMelkDocumentValue());
        mapModel.setTgbJointlyTypeOfMelkDocumentModel(group.isTgbJointlyTypeOfMelkDocumentValue());
        mapModel.setTgbResidentialTypeOfMelkDocumentModel(group.isTgbResidentialTypeOfMelkDocumentValue());
        mapModel.setTgbIndustrialTypeOfMelkDocumentModel(group.isTgbIndustrialTypeOfMelkDocumentValue());

        mapModel.setTgbPackageCoolingHealingSystemModel(group.isTgbPackageCoolingHealingSystemValue());
        mapModel.setTgbHeaterCoolingHealingSystemModel(group.isTgbHeaterCoolingHealingSystemValue());
        mapModel.setTgbChilerCoolingHealingSystemModel(group.isTgbChilerCoolingHealingSystemValue());
        mapModel.setTgbWaterCoolerCoolingHealingSystemModel(group.isTgbWaterCoolerCoolingHealingSystemValue());
        mapModel.setTgbFanCoilCoolingHealingSystemModel(group.isTgbFanCoilCoolingHealingSystemValue());
        mapModel.setTgbCentralEngineRoomCoolingHealingSystemModel(group.isTgbCentralEngineRoomCoolingHealingSystemValue());
        mapModel.setTgbFloorHeatingCoolingHealingSystemModel(group.isTgbFloorHeatingCoolingHealingSystemValue());
        mapModel.setTgbAirConditionerCoolingHealingSystemModel(group.isTgbAirConditionerCoolingHealingSystemValue());
        mapModel.setTgbGasCoolerCoolingHealingSystemModel(group.isTgbGasCoolerCoolingHealingSystemValue());

        mapModel.setTgbStoneFloorCoveringModel(group.isTgbStoneFloorCoveringValue());
        mapModel.setTgbCarpetFloorCoveringModel(group.isTgbCarpetFloorCoveringValue());
        mapModel.setTgbParquetFloorCoveringModel(group.isTgbParquetFloorCoveringValue());
        mapModel.setTgbMosaicFloorCoveringModel(group.isTgbMosaicFloorCoveringValue());
        mapModel.setTgbAsphaltFloorCoveringModel(group.isTgbAsphaltFloorCoveringValue());
        mapModel.setTgbCeramicFloorCoveringModel(group.isTgbCeramicFloorCoveringValue());
        mapModel.setTgbLaminatFloorCoveringModel(group.isTgbLaminatFloorCoveringValue());
        mapModel.setTgbWoodFloorCoveringModel(group.isTgbWoodFloorCoveringValue());
        mapModel.setTgbGraniteFloorCoveringModel(group.isTgbGraniteFloorCoveringValue());
        mapModel.setTgbCementFloorCoveringModel(group.isTgbCementFloorCoveringValue());

        mapModel.setTgbKonteksBuildingFacadesModel(group.isTgbKonteksBuildingFacadesValue());
        mapModel.setTgbAluminumBuildingFacadesModel(group.isTgbAluminumBuildingFacadesValue());
        mapModel.setTgbBrickBuildingFacadesModel(group.isTgbBrickBuildingFacadesValue());
        mapModel.setTgbCementBuildingFacadesModel(group.isTgbCementBuildingFacadesValue());
        mapModel.setTgbWoodBuildingFacadesModel(group.isTgbWoodBuildingFacadesValue());
        mapModel.setTgbStoneBuildingFacadesModel(group.isTgbStoneBuildingFacadesValue());
        mapModel.setTgbCeramicBuildingFacadesModel(group.isTgbCeramicBuildingFacadesValue());
        mapModel.setTgbGlassBuildingFacadesModel(group.isTgbGlassBuildingFacadesValue());
        mapModel.setTgbCompositeBuildingFacadesModel(group.isTgbCompositeBuildingFacadesValue());


        mapModel.setTgbHiGlassKitchenCabinetsModel(group.isTgbHiGlassKitchenCabinetsValue());
        mapModel.setTgbHdfKitchenCabinetsModel(group.isTgbHdfKitchenCabinetsValue());


        mapModel.setTgbMetalKitchenCabinetsModel(group.isTgbMetalKitchenCabinetsValue());
        mapModel.setTgbMdfKitchenCabinetsModel(group.isTgbMdfKitchenCabinetsValue());
        mapModel.setTgbwoodKitchenCabinetsModel(group.isTgbwoodKitchenCabinetsValue());
        mapModel.setTgbPvcKitchenCabinetsModel(group.isTgbPvcKitchenCabinetsValue());

        mapModel.setTgbPassageBuildingTypeModel(group.isTgbPassageBuildingTypeValue());
        mapModel.setTgbVillaBuildingTypeModel(group.isTgbVillaBuildingTypeValue());
        mapModel.setTgbTowerBuildingTypeModel(group.isTgbTowerBuildingTypeValue());
        mapModel.setTgbApartmentBuildingTypeModel(group.isTgbApartmentBuildingTypeValue());
        mapModel.setTgbIntegratedBuildingTypeModel(group.isTgbIntegratedBuildingTypeValue());

        mapModel.setTgbLakeViewModel(group.isTgbLakeViewValue());
        mapModel.setTgbJangleViewModel(group.isTgbJangleViewValue());
        mapModel.setTgbCityViewModel(group.isTgbCityViewValue());
        mapModel.setTgbPanoramaViewModel(group.isTgbPanoramaViewValue());
        mapModel.setTgbParkViewModel(group.isTgbParkViewValue());
        mapModel.setTgbMountainViewModel(group.isTgbMountainViewValue());
        mapModel.setTgbSeaViewModel(group.isTgbSeaViewValue());
        mapModel.setTgbRiverViewModel(group.isTgbRiverViewValue());
        mapModel.setTgbSkyViewModel(group.isTgbSkyViewValue());

        mapModel.setTgbLibraryRoomTypeModel(group.isTgbLibraryRoomTypeValue());
        mapModel.setTgbDressingRoomTypeModel(group.isTgbDressingRoomTypeValue());
        mapModel.setTgbDiningRoomTypeModel(group.isTgbDiningRoomTypeValue());
        mapModel.setTgbWorkShopRoomTypeModel(group.isTgbWorkShopRoomTypeValue());
        mapModel.setTgbWorkRoomTypeModel(group.isTgbWorkRoomTypeValue());
        mapModel.setTgbHomeLollipopRoomTypeModel(group.isTgbHomeLollipopRoomTypeValue());

        mapModel.setTgbRefrigeratorFurnishedFacilitiesModel(group.isTgbRefrigeratorFurnishedFacilitiesValue());
        mapModel.setTgbMacrowaveFurnishedFacilitiesModel(group.isTgbMacrowaveFurnishedFacilitiesValue());
        mapModel.setTgbCarpeteFurnishedFacilitiesModel(group.isTgbCarpeteFurnishedFacilitiesValue());
        mapModel.setTgbChandelierFurnishedFacilitiesModel(group.isTgbChandelierFurnishedFacilitiesValue());
        mapModel.setTgbVacuumeCleanerFurnishedFacilitiesModel(group.isTgbVacuumeCleanerFurnishedFacilitiesValue());
        mapModel.setTgbDishwasherFurnishedFacilitiesModel(group.isTgbDishwasherFurnishedFacilitiesValue());
        mapModel.setTgbBedFurnishedFacilitiesModel(group.isTgbBedFurnishedFacilitiesValue());
        mapModel.setTgbOvenFurnishedFacilitiesModel(group.isTgbOvenFurnishedFacilitiesValue());
        mapModel.setTgbFurnitureFurnishedFacilitiesModel(group.isTgbFurnitureFurnishedFacilitiesValue());

        mapModel.setTgbTelevisionFurnishedFacilitiesModel(group.isTgbTelevisionFurnishedFacilitiesValue());
        mapModel.setTgbOttoFurnishedFacilitiesModel(group.isTgbOttoFurnishedFacilitiesValue());
        mapModel.setTgbWashingMachineFurnishedFacilitiesModel(group.isTgbWashingMachineFurnishedFacilitiesValue());
        mapModel.setTgbDishesFurnishedFacilitiesModel(group.isTgbDishesFurnishedFacilitiesValue());
        mapModel.setTgbDishesCurtainFacilitiesModel(group.isTgbDishesCurtainFacilitiesValue());


        mapModel.setTgbGentleWindowsType(group.isTgbGentleWindowsType());
        mapModel.setTgbPvcTowShellsWindowsType(group.isTgbPvcTowShellsWindowsType());
        mapModel.setTgbMetalWindowsType(group.isTgbMetalWindowsType());
        mapModel.setTgbWoodWindowsType(group.isTgbWoodWindowsType());
        mapModel.setTgbMetalTowShellsWindowsType(group.isTgbMetalTowShellsWindowsType());
        mapModel.setTgbFiberGlassWindowsType(group.isTgbFiberGlassWindowsType());
        mapModel.setTgbAluminiumThermalBreak(group.isTgbAluminiumThermalBreak());

        mapModel.setTgbOfficialUsageTypeModel(group.isTgbOfficialUsageTypeValue());
        mapModel.setTgbCommercialUsageTypeModel(group.isTgbCommercialUsageTypeValue());
        mapModel.setTgbIndustrialUsageTypeModel(group.isTgbIndustrialUsageTypeValue());
        mapModel.setTgbStoreUsageTypeModel(group.isTgbStoreUsageTypeValue());
        mapModel.setTgbAnimalHusbandryUsageTypeModel(group.isTgbAnimalHusbandryUsageTypeValue());
        mapModel.setTgbEducationalUsageTypeModel(group.isTgbEducationalUsageTypeValue());
        mapModel.setTgbResidentialUsageTypeModel(group.isTgbResidentialUsageTypeValue());
        mapModel.setTgbAdministrativePositionUsageTypeModel(group.isTgbAdministrativePositionUsageTypeValue());
        mapModel.setTgbResidentUsageTypeModel(group.isTgbResidentUsageTypeValue());
        mapModel.setTgbAgricultureUsageTypeModel(group.isTgbAgricultureUsageTypeValue());
        mapModel.setTgbSportsUsageTypeModel(group.isTgbSportsUsageTypeValue());
        mapModel.setTgbClinicUsageTypeModel(group.isTgbClinicUsageTypeValue());

        mapModel.setHpDistanceToVehicleModel(group.getHpDistanceToVehicleValue());
        mapModel.setEdtMoreInfoModel(group.getEdtMoreInfoValue());


    }
}
