package com.hekatomsoft.androidcor.bottombarfragment.googlemap;


import android.databinding.BaseObservable;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.databinding.ObservableField;

import com.hekatomsoft.androidcor.bottombarfragment.repository.MarkerPosition;

import java.util.ArrayList;
import java.util.List;

import io.realm.annotations.PrimaryKey;

@InverseBindingMethods({
        @InverseBindingMethod(type = HorizontalPicker.class, attribute = "android:selectedItemPosition"),
})
public class Group extends BaseObservable {


    private String string;
    public List<String> children = new ArrayList<String>();

    public Group(String string) {
        this.string = string;
    }

    private String markerPositionLat;
    private String markerPositionLng;

    @PrimaryKey
    private long melk_id_value;
    private long unitId_value;

    private MarkerPosition markerPosition;

    public MarkerPosition getMarkerPosition() {
        return markerPosition;
    }

    public void setMarkerPosition(MarkerPosition markerPosition) {
        this.markerPosition = markerPosition;
    }

    public ObservableField hpOwners = new ObservableField();

    public ObservableField getHpOwners() {
        return hpOwners;
    }

    public void setHpOwners(ObservableField hpOwners) {
        this.hpOwners = hpOwners;
    }

    private int spTransTypeValue;
    private int spMelkTypeValue;

    private String edtMelkAreaValue;
    private String edtAmountSellPerMetricValue;
    private boolean swInstallmentValue;
    private String edtAmountSellValue;
    private String edtInstallmentTermsValue;
    private String edtAmountRentValue;
    private String edtAmountRahnValue;
    private boolean tgbChangeableToRentValue;
    private boolean tgbChangeableToRahnValue;
    private int hpNumberOfOwnersValue;
    private String edtOwnerInformationsValue;
    private int hpDungForSellValue;
    private String edtSinceQuantityValue;
    private int hpMaxAllowedForResidencesValue;
    private int hpPercentageOfProgressMadeValue;
    private String txtSelectMelkReceiveTimeValue;
    private int hpMelkAgeValue;
    private int hpNumberOfBedRoomsValue;
    private int hpFloorNumberValue;
    private int hpNumberOfFloorsValue;
    private int hpNumberOfUnitInFloorValue;

    private boolean swDateOfQuitValue;
    private String txtDateOfQuitValue;

    private boolean swHasLoanValue;
    private String edtAmountLoanValue;
    private int hpNumberOfElevatorValue;
    private int hpNumberOfBathRoomValue;
    private int hpNumberOfParkingValue;
    private int hpNumberOfKitchenValue;
    private int hpNumberOfMasterRoomValue;
    private int hpNumberOfIranianToiletValue;
    private int hpNumberOfFarangiToiletValue;

    private int hpNumberOfTellSubValue;

    private String edtAmountMountChargeValue;
    private int hpNumberOfRoofSpaceValue;
    private int hpHeightOfTheCeilingValue;
    private int hpMelkWidthValue;

    private boolean tgbFlatUnitTypeValue;
    private boolean tgbDoublexUnitTypeValue;
    private boolean tgbTriplexUnitTypeValue;
    private boolean tgbBeachMelkPositionsValue;
    private boolean tgbJangleMelkPositionsValue;
    private boolean tgbMountainMelkPositionsValue;
    private boolean tgbTownshipMelkPositionsValue;

    private boolean tgbPatioPossibilitiesValue;
    private boolean tgbWaterWellPossibilitiesValue;
    private boolean tgbBalconyPossibilitiesValue;
    private boolean tgbVideoIphonePossibilitiesValue;
    private boolean tgbWallClosetPossibilitiesValue;
    private boolean tgbStorePossibilitiesValue;
    private boolean tgbYardPossibilitiesValue;
    private boolean tgbJantorPossibilitiesValue;
    private boolean tgbRebuildPossibilitiesValue;
    private boolean tgbSofaPossibilitiesValue;
    private boolean tgbCameraPossibilitiesValue;
    private boolean tgbCentralAntennaPossibilitiesValue;
    private boolean tgbChangeablePossibilitiesValue;


    private boolean tgbLobbySpecialFeaturesValue;
    private boolean tgbBathtubSpecialFeaturesValue;
    private boolean tgbSwimmingPoolSpecialFeaturesValue;
    private boolean tgbFirePlaceSpecialFeaturesValue;
    private boolean tgbChildrenPlaySpaceSpecialFeaturesValue;
    private boolean tgbGardenYardSpecialFeaturesValue;
    private boolean tgbCentralVacuumCleanerSpecialFeaturesValue;
    private boolean tgbAmphitheaterSpecialFeaturesValue;
    private boolean tgbConferenceHallSpecialFeaturesValue;
    private boolean tgbFirefightSpecialFeaturesValue;
    private boolean tgbSolarBatterySpecialFeaturesValue;
    private boolean tgbFountainSpecialFeaturesValue;
    private boolean tgbCargoElevatorSpecialFeaturesValue;
    private boolean tgbWaterSupplySpecialFeaturesValue;
    private boolean tgbTennisCourtFeaturesValue;
    private boolean tgbGuestParkingSpecialFeaturesValue;
    private boolean tgbSaunaSpecialFeaturesValue;
    private boolean tgbJacuzziSpecialFeaturesValue;
    private boolean tgbChildrenPoolSpecialFeaturesValue;
    private boolean tgbRoofGardenSpecialFeaturesValue;
    private boolean tgbBarbecueSpecialFeaturesValue;
    private boolean tgbShootingWasteSpecialFeaturesValue;
    private boolean tgbAltarSpecialFeaturesValue;
    private boolean tgbSecuritySystemSpecialFeaturesValue;
    private boolean tgbSmartHomeSpecialFeaturesValue;
    private boolean tgbSafeguardSpecialFeaturesValue;
    private boolean tgbEmergencyPowerSpecialFeaturesValue;
    private boolean tgbCaretakersRoomSpecialFeaturesValue;
    private boolean tgbSecurityDoorSpecialFeaturesValue;
    private boolean tgbWaterPurifierSpecialFeaturesValue;
    private boolean tgbParkingRemoteSpecialFeaturesValue;
    private boolean tgbPoolTableSpecialFeaturesValue;


    private boolean tgbWestGeoPositionValue;
    private boolean tgbEstGeoPositionValue;
    private boolean tgbSouthGeoPositionValue;
    private boolean tgbNorthGeoPositionValue;
    private boolean tgbBlotsButsStructTypeValue;
    private boolean tgbMetalStructTypeValue;
    private boolean tgbConcreteAndBarStructTypeValue;
    private boolean tgbWestLightingDirectValue;
    private boolean tgbEstLightingDirectValue;
    private boolean tgbSouthtLightingDirectValue;
    private boolean tgbNorthLightingDirectValue;

    private boolean tgbGoodwillValue;
    private boolean tgbPropertyValue;
    private boolean tgbThreePhaseElectricValue;
    private boolean tgbOnePhaseElectricValue;
    private boolean tgbShareElectricValue;
    private boolean tgbPrivateElectricValue;
    private boolean tgbShareGasMeterValue;
    private boolean tgbPrivateGasMeterValue;
    private boolean tgbShareWaterMeterValue;
    private boolean tgbPrivateWaterMeterValue;


    private boolean tgbPersonalTypeOfMelkDocumentValue;
    private boolean tgbEndowmentsTypeOfMelkDocumentValue;
    private boolean tgbCommercialTypeOfMelkDocumentValue;
    private boolean tgbShariRulerTypeOfMelkDocumentValue;
    private boolean tgbOrganizationalTypeOfMelkDocumentValue;
    private boolean tgbOfficalTypeOfMelkDocumentValue;
    private boolean tgbCooperativeTypeOfMelkDocumentValue;
    private boolean tgbProxyTypeOfMelkDocumentValue;
    private boolean tgbLetterOfCreditTypeOfMelkDocumentValue;
    private boolean tgbJointlyTypeOfMelkDocumentValue;
    private boolean tgbResidentialTypeOfMelkDocumentValue;
    private boolean tgbIndustrialTypeOfMelkDocumentValue;

    private boolean tgbPackageCoolingHealingSystemValue;
    private boolean tgbHeaterCoolingHealingSystemValue;
    private boolean tgbChilerCoolingHealingSystemValue;
    private boolean tgbWaterCoolerCoolingHealingSystemValue;
    private boolean tgbFanCoilCoolingHealingSystemValue;
    private boolean tgbCentralEngineRoomCoolingHealingSystemValue;
    private boolean tgbFloorHeatingCoolingHealingSystemValue;
    private boolean tgbAirConditionerCoolingHealingSystemValue;
    private boolean tgbGasCoolerCoolingHealingSystemValue;

    private boolean tgbStoneFloorCoveringValue;
    private boolean tgbCarpetFloorCoveringValue;
    private boolean tgbParquetFloorCoveringValue;
    private boolean tgbMosaicFloorCoveringValue;
    private boolean tgbAsphaltFloorCoveringValue;
    private boolean tgbCeramicFloorCoveringValue;
    private boolean tgbLaminatFloorCoveringValue;
    private boolean tgbWoodFloorCoveringValue;
    private boolean tgbGraniteFloorCoveringValue;
    private boolean tgbCementFloorCoveringValue;

    private boolean tgbKonteksBuildingFacadesValue;
    private boolean tgbAluminumBuildingFacadesValue;
    private boolean tgbBrickBuildingFacadesValue;
    private boolean tgbCementBuildingFacadesValue;
    private boolean tgbWoodBuildingFacadesValue;
    private boolean tgbStoneBuildingFacadesValue;
    private boolean tgbCeramicBuildingFacadesValue;
    private boolean tgbGlassBuildingFacadesValue;
    private boolean tgbCompositeBuildingFacadesValue;


    private boolean tgbHiGlassKitchenCabinetsValue;
    private boolean tgbHdfKitchenCabinetsValue;


    private boolean tgbMetalKitchenCabinetsValue;
    private boolean tgbMdfKitchenCabinetsValue;
    private boolean tgbwoodKitchenCabinetsValue;
    private boolean tgbPvcKitchenCabinetsValue;

    private boolean tgbPassageBuildingTypeValue;
    private boolean tgbVillaBuildingTypeValue;
    private boolean tgbTowerBuildingTypeValue;
    private boolean tgbApartmentBuildingTypeValue;
    private boolean tgbIntegratedBuildingTypeValue;

    private boolean tgbLakeViewValue;
    private boolean tgbJangleViewValue;
    private boolean tgbCityViewValue;
    private boolean tgbPanoramaViewValue;
    private boolean tgbParkViewValue;
    private boolean tgbMountainViewValue;
    private boolean tgbSeaViewValue;
    private boolean tgbRiverViewValue;
    private boolean tgbSkyViewValue;

    private boolean tgbLibraryRoomTypeValue;
    private boolean tgbDressingRoomTypeValue;
    private boolean tgbDiningRoomTypeValue;
    private boolean tgbWorkShopRoomTypeValue;
    private boolean tgbWorkRoomTypeValue;
    private boolean tgbHomeLollipopRoomTypeValue;

    private boolean tgbRefrigeratorFurnishedFacilitiesValue;
    private boolean tgbMacrowaveFurnishedFacilitiesValue;
    private boolean tgbCarpeteFurnishedFacilitiesValue;
    private boolean tgbChandelierFurnishedFacilitiesValue;
    private boolean tgbVacuumeCleanerFurnishedFacilitiesValue;
    private boolean tgbDishwasherFurnishedFacilitiesValue;
    private boolean tgbBedFurnishedFacilitiesValue;
    private boolean tgbOvenFurnishedFacilitiesValue;
    private boolean tgbFurnitureFurnishedFacilitiesValue;

    private boolean tgbTelevisionFurnishedFacilitiesValue;
    private boolean tgbOttoFurnishedFacilitiesValue;
    private boolean tgbWashingMachineFurnishedFacilitiesValue;
    private boolean tgbDishesFurnishedFacilitiesValue;
    private boolean tgbDishesCurtainFacilitiesValue;


    private boolean tgbGentleWindowsType;
    private boolean tgbPvcTowShellsWindowsType;
    private boolean tgbMetalWindowsType;
    private boolean tgbWoodWindowsType;
    private boolean tgbMetalTowShellsWindowsType;
    private boolean tgbFiberGlassWindowsType;
    private boolean tgbAluminiumThermalBreak;

    private boolean tgbOfficialUsageTypeValue;
    private boolean tgbCommercialUsageTypeValue;
    private boolean tgbIndustrialUsageTypeValue;
    private boolean tgbStoreUsageTypeValue;
    private boolean tgbAnimalHusbandryUsageTypeValue;
    private boolean tgbEducationalUsageTypeValue;
    private boolean tgbResidentialUsageTypeValue;
    private boolean tgbAdministrativePositionUsageTypeValue;
    private boolean tgbResidentUsageTypeValue;
    private boolean tgbAgricultureUsageTypeValue;
    private boolean tgbSportsUsageTypeValue;
    private boolean tgbClinicUsageTypeValue;

    private int hpDistanceToVehicleValue;
    private String edtMoreInfoValue;


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getMarkerPositionLat() {
        return markerPositionLat;
    }

    public void setMarkerPositionLat(String markerPositionLat) {
        this.markerPositionLat = markerPositionLat;
    }

    public String getMarkerPositionLng() {
        return markerPositionLng;
    }

    public void setMarkerPositionLng(String markerPositionLng) {
        this.markerPositionLng = markerPositionLng;
    }

    public long getMelk_id_value() {
        return melk_id_value;
    }

    public void setMelk_id_value(long melk_id_value) {
        this.melk_id_value = melk_id_value;
    }

    public long getUnitId_value() {
        return unitId_value;
    }

    public void setUnitId_value(long unitId_value) {
        this.unitId_value = unitId_value;
    }

    public int getSpTransTypeValue() {
        return spTransTypeValue;
    }

    public void setSpTransTypeValue(int spTransTypeValue) {
        this.spTransTypeValue = spTransTypeValue;
    }

    public int getSpMelkTypeValue() {
        return spMelkTypeValue;
    }

    public void setSpMelkTypeValue(int spMelkTypeValue) {
        this.spMelkTypeValue = spMelkTypeValue;
    }

    public String getEdtMelkAreaValue() {
        return edtMelkAreaValue;
    }

    public void setEdtMelkAreaValue(String edtMelkAreaValue) {
        this.edtMelkAreaValue = edtMelkAreaValue;
    }

    public String getEdtAmountSellPerMetricValue() {
        return edtAmountSellPerMetricValue;
    }

    public void setEdtAmountSellPerMetricValue(String edtAmountSellPerMetricValue) {
        this.edtAmountSellPerMetricValue = edtAmountSellPerMetricValue;
    }

    public boolean isSwInstallmentValue() {
        return swInstallmentValue;
    }

    public void setSwInstallmentValue(boolean swInstallmentValue) {
        this.swInstallmentValue = swInstallmentValue;
    }

    public String getEdtAmountSellValue() {
        return edtAmountSellValue;
    }

    public void setEdtAmountSellValue(String edtAmountSellValue) {
        this.edtAmountSellValue = edtAmountSellValue;
    }

    public String getEdtInstallmentTermsValue() {
        return edtInstallmentTermsValue;
    }

    public void setEdtInstallmentTermsValue(String edtInstallmentTermsValue) {
        this.edtInstallmentTermsValue = edtInstallmentTermsValue;
    }

    public String getEdtAmountRentValue() {
        return edtAmountRentValue;
    }

    public void setEdtAmountRentValue(String edtAmountRentValue) {
        this.edtAmountRentValue = edtAmountRentValue;
    }

    public String getEdtAmountRahnValue() {
        return edtAmountRahnValue;
    }

    public void setEdtAmountRahnValue(String edtAmountRahnValue) {
        this.edtAmountRahnValue = edtAmountRahnValue;
    }

    public boolean isTgbChangeableToRentValue() {
        return tgbChangeableToRentValue;
    }

    public void setTgbChangeableToRentValue(boolean tgbChangeableToRentValue) {
        this.tgbChangeableToRentValue = tgbChangeableToRentValue;
    }

    public boolean isTgbChangeableToRahnValue() {
        return tgbChangeableToRahnValue;
    }

    public void setTgbChangeableToRahnValue(boolean tgbChangeableToRahnValue) {
        this.tgbChangeableToRahnValue = tgbChangeableToRahnValue;
    }

    public int getHpNumberOfOwnersValue() {
        return hpNumberOfOwnersValue;
    }


    public void setHpNumberOfOwnersValue(int hpNumberOfOwnersValue) {
        this.hpNumberOfOwnersValue = hpNumberOfOwnersValue;
    }

    public String getEdtOwnerInformationsValue() {
        return edtOwnerInformationsValue;
    }

    public void setEdtOwnerInformationsValue(String edtOwnerInformationsValue) {
        this.edtOwnerInformationsValue = edtOwnerInformationsValue;
    }

    public int getHpDungForSellValue() {
        return hpDungForSellValue;
    }

    public void setHpDungForSellValue(int hpDungForSellValue) {
        this.hpDungForSellValue = hpDungForSellValue;
    }

    public String getEdtSinceQuantityValue() {
        return edtSinceQuantityValue;
    }

    public void setEdtSinceQuantityValue(String edtSinceQuantityValue) {
        this.edtSinceQuantityValue = edtSinceQuantityValue;
    }

    public int getHpMaxAllowedForResidencesValue() {
        return hpMaxAllowedForResidencesValue;
    }

    public void setHpMaxAllowedForResidencesValue(int hpMaxAllowedForResidencesValue) {
        this.hpMaxAllowedForResidencesValue = hpMaxAllowedForResidencesValue;
    }

    public int getHpPercentageOfProgressMadeValue() {
        return hpPercentageOfProgressMadeValue;
    }

    public void setHpPercentageOfProgressMadeValue(int hpPercentageOfProgressMadeValue) {
        this.hpPercentageOfProgressMadeValue = hpPercentageOfProgressMadeValue;
    }

    public String getTxtSelectMelkReceiveTimeValue() {
        return txtSelectMelkReceiveTimeValue;
    }

    public void setTxtSelectMelkReceiveTimeValue(String txtSelectMelkReceiveTimeValue) {
        this.txtSelectMelkReceiveTimeValue = txtSelectMelkReceiveTimeValue;
    }

    public int getHpMelkAgeValue() {
        return hpMelkAgeValue;
    }

    public void setHpMelkAgeValue(int hpMelkAgeValue) {
        this.hpMelkAgeValue = hpMelkAgeValue;
    }

    public int getHpNumberOfBedRoomsValue() {
        return hpNumberOfBedRoomsValue;
    }

    public void setHpNumberOfBedRoomsValue(int hpNumberOfBedRoomsValue) {
        this.hpNumberOfBedRoomsValue = hpNumberOfBedRoomsValue;
    }

    public int getHpFloorNumberValue() {
        return hpFloorNumberValue;
    }

    public void setHpFloorNumberValue(int hpFloorNumberValue) {
        this.hpFloorNumberValue = hpFloorNumberValue;
    }

    public int getHpNumberOfFloorsValue() {
        return hpNumberOfFloorsValue;
    }

    public void setHpNumberOfFloorsValue(int hpNumberOfFloorsValue) {
        this.hpNumberOfFloorsValue = hpNumberOfFloorsValue;
    }

    public int getHpNumberOfUnitInFloorValue() {
        return hpNumberOfUnitInFloorValue;
    }

    public void setHpNumberOfUnitInFloorValue(int hpNumberOfUnitInFloorValue) {
        this.hpNumberOfUnitInFloorValue = hpNumberOfUnitInFloorValue;
    }

    public boolean isSwDateOfQuitValue() {
        return swDateOfQuitValue;
    }

    public void setSwDateOfQuitValue(boolean swDateOfQuitValue) {
        this.swDateOfQuitValue = swDateOfQuitValue;
    }

    public String getTxtDateOfQuitValue() {
        return txtDateOfQuitValue;
    }

    public void setTxtDateOfQuitValue(String txtDateOfQuitValue) {
        this.txtDateOfQuitValue = txtDateOfQuitValue;
    }

    public boolean isSwHasLoanValue() {
        return swHasLoanValue;
    }

    public void setSwHasLoanValue(boolean swHasLoanValue) {
        this.swHasLoanValue = swHasLoanValue;
    }

    public String getEdtAmountLoanValue() {
        return edtAmountLoanValue;
    }

    public void setEdtAmountLoanValue(String edtAmountLoanValue) {
        this.edtAmountLoanValue = edtAmountLoanValue;
    }

    public int getHpNumberOfElevatorValue() {
        return hpNumberOfElevatorValue;
    }

    public void setHpNumberOfElevatorValue(int hpNumberOfElevatorValue) {
        this.hpNumberOfElevatorValue = hpNumberOfElevatorValue;
    }

    public int getHpNumberOfBathRoomValue() {
        return hpNumberOfBathRoomValue;
    }

    public void setHpNumberOfBathRoomValue(int hpNumberOfBathRoomValue) {
        this.hpNumberOfBathRoomValue = hpNumberOfBathRoomValue;
    }

    public int getHpNumberOfParkingValue() {
        return hpNumberOfParkingValue;
    }

    public void setHpNumberOfParkingValue(int hpNumberOfParkingValue) {
        this.hpNumberOfParkingValue = hpNumberOfParkingValue;
    }

    public int getHpNumberOfKitchenValue() {
        return hpNumberOfKitchenValue;
    }

    public void setHpNumberOfKitchenValue(int hpNumberOfKitchenValue) {
        this.hpNumberOfKitchenValue = hpNumberOfKitchenValue;
    }

    public int getHpNumberOfMasterRoomValue() {
        return hpNumberOfMasterRoomValue;
    }

    public void setHpNumberOfMasterRoomValue(int hpNumberOfMasterRoomValue) {
        this.hpNumberOfMasterRoomValue = hpNumberOfMasterRoomValue;
    }

    public int getHpNumberOfIranianToiletValue() {
        return hpNumberOfIranianToiletValue;
    }

    public void setHpNumberOfIranianToiletValue(int hpNumberOfIranianToiletValue) {
        this.hpNumberOfIranianToiletValue = hpNumberOfIranianToiletValue;
    }

    public int getHpNumberOfFarangiToiletValue() {
        return hpNumberOfFarangiToiletValue;
    }

    public void setHpNumberOfFarangiToiletValue(int hpNumberOfFarangiToiletValue) {
        this.hpNumberOfFarangiToiletValue = hpNumberOfFarangiToiletValue;
    }

    public int getHpNumberOfTellSubValue() {
        return hpNumberOfTellSubValue;
    }

    public void setHpNumberOfTellSubValue(int hpNumberOfTellSubValue) {
        this.hpNumberOfTellSubValue = hpNumberOfTellSubValue;
    }

    public String getEdtAmountMountChargeValue() {
        return edtAmountMountChargeValue;
    }

    public void setEdtAmountMountChargeValue(String edtAmountMountChargeValue) {
        this.edtAmountMountChargeValue = edtAmountMountChargeValue;
    }

    public int getHpNumberOfRoofSpaceValue() {
        return hpNumberOfRoofSpaceValue;
    }

    public void setHpNumberOfRoofSpaceValue(int hpNumberOfRoofSpaceValue) {
        this.hpNumberOfRoofSpaceValue = hpNumberOfRoofSpaceValue;
    }

    public int getHpHeightOfTheCeilingValue() {
        return hpHeightOfTheCeilingValue;
    }

    public void setHpHeightOfTheCeilingValue(int hpHeightOfTheCeilingValue) {
        this.hpHeightOfTheCeilingValue = hpHeightOfTheCeilingValue;
    }

    public int getHpMelkWidthValue() {
        return hpMelkWidthValue;
    }

    public void setHpMelkWidthValue(int hpMelkWidthValue) {
        this.hpMelkWidthValue = hpMelkWidthValue;
    }

    public boolean isTgbFlatUnitTypeValue() {
        return tgbFlatUnitTypeValue;
    }

    public void setTgbFlatUnitTypeValue(boolean tgbFlatUnitTypeValue) {
        this.tgbFlatUnitTypeValue = tgbFlatUnitTypeValue;
    }

    public boolean isTgbDoublexUnitTypeValue() {
        return tgbDoublexUnitTypeValue;
    }

    public void setTgbDoublexUnitTypeValue(boolean tgbDoublexUnitTypeValue) {
        this.tgbDoublexUnitTypeValue = tgbDoublexUnitTypeValue;
    }

    public boolean isTgbTriplexUnitTypeValue() {
        return tgbTriplexUnitTypeValue;
    }

    public void setTgbTriplexUnitTypeValue(boolean tgbTriplexUnitTypeValue) {
        this.tgbTriplexUnitTypeValue = tgbTriplexUnitTypeValue;
    }

    public boolean isTgbBeachMelkPositionsValue() {
        return tgbBeachMelkPositionsValue;
    }

    public void setTgbBeachMelkPositionsValue(boolean tgbBeachMelkPositionsValue) {
        this.tgbBeachMelkPositionsValue = tgbBeachMelkPositionsValue;
    }

    public boolean isTgbJangleMelkPositionsValue() {
        return tgbJangleMelkPositionsValue;
    }

    public void setTgbJangleMelkPositionsValue(boolean tgbJangleMelkPositionsValue) {
        this.tgbJangleMelkPositionsValue = tgbJangleMelkPositionsValue;
    }

    public boolean isTgbMountainMelkPositionsValue() {
        return tgbMountainMelkPositionsValue;
    }

    public void setTgbMountainMelkPositionsValue(boolean tgbMountainMelkPositionsValue) {
        this.tgbMountainMelkPositionsValue = tgbMountainMelkPositionsValue;
    }

    public boolean isTgbTownshipMelkPositionsValue() {
        return tgbTownshipMelkPositionsValue;
    }

    public void setTgbTownshipMelkPositionsValue(boolean tgbTownshipMelkPositionsValue) {
        this.tgbTownshipMelkPositionsValue = tgbTownshipMelkPositionsValue;
    }

    public boolean isTgbPatioPossibilitiesValue() {
        return tgbPatioPossibilitiesValue;
    }

    public void setTgbPatioPossibilitiesValue(boolean tgbPatioPossibilitiesValue) {
        this.tgbPatioPossibilitiesValue = tgbPatioPossibilitiesValue;
    }

    public boolean isTgbWaterWellPossibilitiesValue() {
        return tgbWaterWellPossibilitiesValue;
    }

    public void setTgbWaterWellPossibilitiesValue(boolean tgbWaterWellPossibilitiesValue) {
        this.tgbWaterWellPossibilitiesValue = tgbWaterWellPossibilitiesValue;
    }

    public boolean isTgbBalconyPossibilitiesValue() {
        return tgbBalconyPossibilitiesValue;
    }

    public void setTgbBalconyPossibilitiesValue(boolean tgbBalconyPossibilitiesValue) {
        this.tgbBalconyPossibilitiesValue = tgbBalconyPossibilitiesValue;
    }

    public boolean isTgbVideoIphonePossibilitiesValue() {
        return tgbVideoIphonePossibilitiesValue;
    }

    public void setTgbVideoIphonePossibilitiesValue(boolean tgbVideoIphonePossibilitiesValue) {
        this.tgbVideoIphonePossibilitiesValue = tgbVideoIphonePossibilitiesValue;
    }

    public boolean isTgbWallClosetPossibilitiesValue() {
        return tgbWallClosetPossibilitiesValue;
    }

    public void setTgbWallClosetPossibilitiesValue(boolean tgbWallClosetPossibilitiesValue) {
        this.tgbWallClosetPossibilitiesValue = tgbWallClosetPossibilitiesValue;
    }

    public boolean isTgbStorePossibilitiesValue() {
        return tgbStorePossibilitiesValue;
    }

    public void setTgbStorePossibilitiesValue(boolean tgbStorePossibilitiesValue) {
        this.tgbStorePossibilitiesValue = tgbStorePossibilitiesValue;
    }

    public boolean isTgbYardPossibilitiesValue() {
        return tgbYardPossibilitiesValue;
    }

    public void setTgbYardPossibilitiesValue(boolean tgbYardPossibilitiesValue) {
        this.tgbYardPossibilitiesValue = tgbYardPossibilitiesValue;
    }

    public boolean isTgbJantorPossibilitiesValue() {
        return tgbJantorPossibilitiesValue;
    }

    public void setTgbJantorPossibilitiesValue(boolean tgbJantorPossibilitiesValue) {
        this.tgbJantorPossibilitiesValue = tgbJantorPossibilitiesValue;
    }

    public boolean isTgbRebuildPossibilitiesValue() {
        return tgbRebuildPossibilitiesValue;
    }

    public void setTgbRebuildPossibilitiesValue(boolean tgbRebuildPossibilitiesValue) {
        this.tgbRebuildPossibilitiesValue = tgbRebuildPossibilitiesValue;
    }

    public boolean isTgbSofaPossibilitiesValue() {
        return tgbSofaPossibilitiesValue;
    }

    public void setTgbSofaPossibilitiesValue(boolean tgbSofaPossibilitiesValue) {
        this.tgbSofaPossibilitiesValue = tgbSofaPossibilitiesValue;
    }

    public boolean isTgbCameraPossibilitiesValue() {
        return tgbCameraPossibilitiesValue;
    }

    public void setTgbCameraPossibilitiesValue(boolean tgbCameraPossibilitiesValue) {
        this.tgbCameraPossibilitiesValue = tgbCameraPossibilitiesValue;
    }

    public boolean isTgbCentralAntennaPossibilitiesValue() {
        return tgbCentralAntennaPossibilitiesValue;
    }

    public void setTgbCentralAntennaPossibilitiesValue(boolean tgbCentralAntennaPossibilitiesValue) {
        this.tgbCentralAntennaPossibilitiesValue = tgbCentralAntennaPossibilitiesValue;
    }

    public boolean isTgbChangeablePossibilitiesValue() {
        return tgbChangeablePossibilitiesValue;
    }

    public void setTgbChangeablePossibilitiesValue(boolean tgbChangeablePossibilitiesValue) {
        this.tgbChangeablePossibilitiesValue = tgbChangeablePossibilitiesValue;
    }

    public boolean isTgbLobbySpecialFeaturesValue() {
        return tgbLobbySpecialFeaturesValue;
    }

    public void setTgbLobbySpecialFeaturesValue(boolean tgbLobbySpecialFeaturesValue) {
        this.tgbLobbySpecialFeaturesValue = tgbLobbySpecialFeaturesValue;
    }

    public boolean isTgbBathtubSpecialFeaturesValue() {
        return tgbBathtubSpecialFeaturesValue;
    }

    public void setTgbBathtubSpecialFeaturesValue(boolean tgbBathtubSpecialFeaturesValue) {
        this.tgbBathtubSpecialFeaturesValue = tgbBathtubSpecialFeaturesValue;
    }

    public boolean isTgbSwimmingPoolSpecialFeaturesValue() {
        return tgbSwimmingPoolSpecialFeaturesValue;
    }

    public void setTgbSwimmingPoolSpecialFeaturesValue(boolean tgbSwimmingPoolSpecialFeaturesValue) {
        this.tgbSwimmingPoolSpecialFeaturesValue = tgbSwimmingPoolSpecialFeaturesValue;
    }

    public boolean isTgbFirePlaceSpecialFeaturesValue() {
        return tgbFirePlaceSpecialFeaturesValue;
    }

    public void setTgbFirePlaceSpecialFeaturesValue(boolean tgbFirePlaceSpecialFeaturesValue) {
        this.tgbFirePlaceSpecialFeaturesValue = tgbFirePlaceSpecialFeaturesValue;
    }

    public boolean isTgbChildrenPlaySpaceSpecialFeaturesValue() {
        return tgbChildrenPlaySpaceSpecialFeaturesValue;
    }

    public void setTgbChildrenPlaySpaceSpecialFeaturesValue(boolean tgbChildrenPlaySpaceSpecialFeaturesValue) {
        this.tgbChildrenPlaySpaceSpecialFeaturesValue = tgbChildrenPlaySpaceSpecialFeaturesValue;
    }

    public boolean isTgbGardenYardSpecialFeaturesValue() {
        return tgbGardenYardSpecialFeaturesValue;
    }

    public void setTgbGardenYardSpecialFeaturesValue(boolean tgbGardenYardSpecialFeaturesValue) {
        this.tgbGardenYardSpecialFeaturesValue = tgbGardenYardSpecialFeaturesValue;
    }

    public boolean isTgbCentralVacuumCleanerSpecialFeaturesValue() {
        return tgbCentralVacuumCleanerSpecialFeaturesValue;
    }

    public void setTgbCentralVacuumCleanerSpecialFeaturesValue(boolean tgbCentralVacuumCleanerSpecialFeaturesValue) {
        this.tgbCentralVacuumCleanerSpecialFeaturesValue = tgbCentralVacuumCleanerSpecialFeaturesValue;
    }

    public boolean isTgbAmphitheaterSpecialFeaturesValue() {
        return tgbAmphitheaterSpecialFeaturesValue;
    }

    public void setTgbAmphitheaterSpecialFeaturesValue(boolean tgbAmphitheaterSpecialFeaturesValue) {
        this.tgbAmphitheaterSpecialFeaturesValue = tgbAmphitheaterSpecialFeaturesValue;
    }

    public boolean isTgbConferenceHallSpecialFeaturesValue() {
        return tgbConferenceHallSpecialFeaturesValue;
    }

    public void setTgbConferenceHallSpecialFeaturesValue(boolean tgbConferenceHallSpecialFeaturesValue) {
        this.tgbConferenceHallSpecialFeaturesValue = tgbConferenceHallSpecialFeaturesValue;
    }

    public boolean isTgbFirefightSpecialFeaturesValue() {
        return tgbFirefightSpecialFeaturesValue;
    }

    public void setTgbFirefightSpecialFeaturesValue(boolean tgbFirefightSpecialFeaturesValue) {
        this.tgbFirefightSpecialFeaturesValue = tgbFirefightSpecialFeaturesValue;
    }

    public boolean isTgbSolarBatterySpecialFeaturesValue() {
        return tgbSolarBatterySpecialFeaturesValue;
    }

    public void setTgbSolarBatterySpecialFeaturesValue(boolean tgbSolarBatterySpecialFeaturesValue) {
        this.tgbSolarBatterySpecialFeaturesValue = tgbSolarBatterySpecialFeaturesValue;
    }

    public boolean isTgbFountainSpecialFeaturesValue() {
        return tgbFountainSpecialFeaturesValue;
    }

    public void setTgbFountainSpecialFeaturesValue(boolean tgbFountainSpecialFeaturesValue) {
        this.tgbFountainSpecialFeaturesValue = tgbFountainSpecialFeaturesValue;
    }

    public boolean isTgbCargoElevatorSpecialFeaturesValue() {
        return tgbCargoElevatorSpecialFeaturesValue;
    }

    public void setTgbCargoElevatorSpecialFeaturesValue(boolean tgbCargoElevatorSpecialFeaturesValue) {
        this.tgbCargoElevatorSpecialFeaturesValue = tgbCargoElevatorSpecialFeaturesValue;
    }

    public boolean isTgbWaterSupplySpecialFeaturesValue() {
        return tgbWaterSupplySpecialFeaturesValue;
    }

    public void setTgbWaterSupplySpecialFeaturesValue(boolean tgbWaterSupplySpecialFeaturesValue) {
        this.tgbWaterSupplySpecialFeaturesValue = tgbWaterSupplySpecialFeaturesValue;
    }

    public boolean isTgbTennisCourtFeaturesValue() {
        return tgbTennisCourtFeaturesValue;
    }

    public void setTgbTennisCourtFeaturesValue(boolean tgbTennisCourtFeaturesValue) {
        this.tgbTennisCourtFeaturesValue = tgbTennisCourtFeaturesValue;
    }

    public boolean isTgbGuestParkingSpecialFeaturesValue() {
        return tgbGuestParkingSpecialFeaturesValue;
    }

    public void setTgbGuestParkingSpecialFeaturesValue(boolean tgbGuestParkingSpecialFeaturesValue) {
        this.tgbGuestParkingSpecialFeaturesValue = tgbGuestParkingSpecialFeaturesValue;
    }

    public boolean isTgbSaunaSpecialFeaturesValue() {
        return tgbSaunaSpecialFeaturesValue;
    }

    public void setTgbSaunaSpecialFeaturesValue(boolean tgbSaunaSpecialFeaturesValue) {
        this.tgbSaunaSpecialFeaturesValue = tgbSaunaSpecialFeaturesValue;
    }

    public boolean isTgbJacuzziSpecialFeaturesValue() {
        return tgbJacuzziSpecialFeaturesValue;
    }

    public void setTgbJacuzziSpecialFeaturesValue(boolean tgbJacuzziSpecialFeaturesValue) {
        this.tgbJacuzziSpecialFeaturesValue = tgbJacuzziSpecialFeaturesValue;
    }

    public boolean isTgbChildrenPoolSpecialFeaturesValue() {
        return tgbChildrenPoolSpecialFeaturesValue;
    }

    public void setTgbChildrenPoolSpecialFeaturesValue(boolean tgbChildrenPoolSpecialFeaturesValue) {
        this.tgbChildrenPoolSpecialFeaturesValue = tgbChildrenPoolSpecialFeaturesValue;
    }

    public boolean isTgbRoofGardenSpecialFeaturesValue() {
        return tgbRoofGardenSpecialFeaturesValue;
    }

    public void setTgbRoofGardenSpecialFeaturesValue(boolean tgbRoofGardenSpecialFeaturesValue) {
        this.tgbRoofGardenSpecialFeaturesValue = tgbRoofGardenSpecialFeaturesValue;
    }

    public boolean isTgbBarbecueSpecialFeaturesValue() {
        return tgbBarbecueSpecialFeaturesValue;
    }

    public void setTgbBarbecueSpecialFeaturesValue(boolean tgbBarbecueSpecialFeaturesValue) {
        this.tgbBarbecueSpecialFeaturesValue = tgbBarbecueSpecialFeaturesValue;
    }

    public boolean isTgbShootingWasteSpecialFeaturesValue() {
        return tgbShootingWasteSpecialFeaturesValue;
    }

    public void setTgbShootingWasteSpecialFeaturesValue(boolean tgbShootingWasteSpecialFeaturesValue) {
        this.tgbShootingWasteSpecialFeaturesValue = tgbShootingWasteSpecialFeaturesValue;
    }

    public boolean isTgbAltarSpecialFeaturesValue() {
        return tgbAltarSpecialFeaturesValue;
    }

    public void setTgbAltarSpecialFeaturesValue(boolean tgbAltarSpecialFeaturesValue) {
        this.tgbAltarSpecialFeaturesValue = tgbAltarSpecialFeaturesValue;
    }

    public boolean isTgbSecuritySystemSpecialFeaturesValue() {
        return tgbSecuritySystemSpecialFeaturesValue;
    }

    public void setTgbSecuritySystemSpecialFeaturesValue(boolean tgbSecuritySystemSpecialFeaturesValue) {
        this.tgbSecuritySystemSpecialFeaturesValue = tgbSecuritySystemSpecialFeaturesValue;
    }

    public boolean isTgbSmartHomeSpecialFeaturesValue() {
        return tgbSmartHomeSpecialFeaturesValue;
    }

    public void setTgbSmartHomeSpecialFeaturesValue(boolean tgbSmartHomeSpecialFeaturesValue) {
        this.tgbSmartHomeSpecialFeaturesValue = tgbSmartHomeSpecialFeaturesValue;
    }

    public boolean isTgbSafeguardSpecialFeaturesValue() {
        return tgbSafeguardSpecialFeaturesValue;
    }

    public void setTgbSafeguardSpecialFeaturesValue(boolean tgbSafeguardSpecialFeaturesValue) {
        this.tgbSafeguardSpecialFeaturesValue = tgbSafeguardSpecialFeaturesValue;
    }

    public boolean isTgbEmergencyPowerSpecialFeaturesValue() {
        return tgbEmergencyPowerSpecialFeaturesValue;
    }

    public void setTgbEmergencyPowerSpecialFeaturesValue(boolean tgbEmergencyPowerSpecialFeaturesValue) {
        this.tgbEmergencyPowerSpecialFeaturesValue = tgbEmergencyPowerSpecialFeaturesValue;
    }

    public boolean isTgbCaretakersRoomSpecialFeaturesValue() {
        return tgbCaretakersRoomSpecialFeaturesValue;
    }

    public void setTgbCaretakersRoomSpecialFeaturesValue(boolean tgbCaretakersRoomSpecialFeaturesValue) {
        this.tgbCaretakersRoomSpecialFeaturesValue = tgbCaretakersRoomSpecialFeaturesValue;
    }

    public boolean isTgbSecurityDoorSpecialFeaturesValue() {
        return tgbSecurityDoorSpecialFeaturesValue;
    }

    public void setTgbSecurityDoorSpecialFeaturesValue(boolean tgbSecurityDoorSpecialFeaturesValue) {
        this.tgbSecurityDoorSpecialFeaturesValue = tgbSecurityDoorSpecialFeaturesValue;
    }

    public boolean isTgbWaterPurifierSpecialFeaturesValue() {
        return tgbWaterPurifierSpecialFeaturesValue;
    }

    public void setTgbWaterPurifierSpecialFeaturesValue(boolean tgbWaterPurifierSpecialFeaturesValue) {
        this.tgbWaterPurifierSpecialFeaturesValue = tgbWaterPurifierSpecialFeaturesValue;
    }

    public boolean isTgbParkingRemoteSpecialFeaturesValue() {
        return tgbParkingRemoteSpecialFeaturesValue;
    }

    public void setTgbParkingRemoteSpecialFeaturesValue(boolean tgbParkingRemoteSpecialFeaturesValue) {
        this.tgbParkingRemoteSpecialFeaturesValue = tgbParkingRemoteSpecialFeaturesValue;
    }

    public boolean isTgbPoolTableSpecialFeaturesValue() {
        return tgbPoolTableSpecialFeaturesValue;
    }

    public void setTgbPoolTableSpecialFeaturesValue(boolean tgbPoolTableSpecialFeaturesValue) {
        this.tgbPoolTableSpecialFeaturesValue = tgbPoolTableSpecialFeaturesValue;
    }

    public boolean isTgbWestGeoPositionValue() {
        return tgbWestGeoPositionValue;
    }

    public void setTgbWestGeoPositionValue(boolean tgbWestGeoPositionValue) {
        this.tgbWestGeoPositionValue = tgbWestGeoPositionValue;
    }

    public boolean isTgbEstGeoPositionValue() {
        return tgbEstGeoPositionValue;
    }

    public void setTgbEstGeoPositionValue(boolean tgbEstGeoPositionValue) {
        this.tgbEstGeoPositionValue = tgbEstGeoPositionValue;
    }

    public boolean isTgbSouthGeoPositionValue() {
        return tgbSouthGeoPositionValue;
    }

    public void setTgbSouthGeoPositionValue(boolean tgbSouthGeoPositionValue) {
        this.tgbSouthGeoPositionValue = tgbSouthGeoPositionValue;
    }

    public boolean isTgbNorthGeoPositionValue() {
        return tgbNorthGeoPositionValue;
    }

    public void setTgbNorthGeoPositionValue(boolean tgbNorthGeoPositionValue) {
        this.tgbNorthGeoPositionValue = tgbNorthGeoPositionValue;
    }

    public boolean isTgbBlotsButsStructTypeValue() {
        return tgbBlotsButsStructTypeValue;
    }

    public void setTgbBlotsButsStructTypeValue(boolean tgbBlotsButsStructTypeValue) {
        this.tgbBlotsButsStructTypeValue = tgbBlotsButsStructTypeValue;
    }

    public boolean isTgbMetalStructTypeValue() {
        return tgbMetalStructTypeValue;
    }

    public void setTgbMetalStructTypeValue(boolean tgbMetalStructTypeValue) {
        this.tgbMetalStructTypeValue = tgbMetalStructTypeValue;
    }

    public boolean isTgbConcreteAndBarStructTypeValue() {
        return tgbConcreteAndBarStructTypeValue;
    }

    public void setTgbConcreteAndBarStructTypeValue(boolean tgbConcreteAndBarStructTypeValue) {
        this.tgbConcreteAndBarStructTypeValue = tgbConcreteAndBarStructTypeValue;
    }

    public boolean isTgbWestLightingDirectValue() {
        return tgbWestLightingDirectValue;
    }

    public void setTgbWestLightingDirectValue(boolean tgbWestLightingDirectValue) {
        this.tgbWestLightingDirectValue = tgbWestLightingDirectValue;
    }

    public boolean isTgbEstLightingDirectValue() {
        return tgbEstLightingDirectValue;
    }

    public void setTgbEstLightingDirectValue(boolean tgbEstLightingDirectValue) {
        this.tgbEstLightingDirectValue = tgbEstLightingDirectValue;
    }

    public boolean isTgbSouthtLightingDirectValue() {
        return tgbSouthtLightingDirectValue;
    }

    public void setTgbSouthtLightingDirectValue(boolean tgbSouthtLightingDirectValue) {
        this.tgbSouthtLightingDirectValue = tgbSouthtLightingDirectValue;
    }

    public boolean isTgbNorthLightingDirectValue() {
        return tgbNorthLightingDirectValue;
    }

    public void setTgbNorthLightingDirectValue(boolean tgbNorthLightingDirectValue) {
        this.tgbNorthLightingDirectValue = tgbNorthLightingDirectValue;
    }

    public boolean isTgbGoodwillValue() {
        return tgbGoodwillValue;
    }

    public void setTgbGoodwillValue(boolean tgbGoodwillValue) {
        this.tgbGoodwillValue = tgbGoodwillValue;
    }

    public boolean isTgbPropertyValue() {
        return tgbPropertyValue;
    }

    public void setTgbPropertyValue(boolean tgbPropertyValue) {
        this.tgbPropertyValue = tgbPropertyValue;
    }

    public boolean isTgbThreePhaseElectricValue() {
        return tgbThreePhaseElectricValue;
    }

    public void setTgbThreePhaseElectricValue(boolean tgbThreePhaseElectricValue) {
        this.tgbThreePhaseElectricValue = tgbThreePhaseElectricValue;
    }

    public boolean isTgbOnePhaseElectricValue() {
        return tgbOnePhaseElectricValue;
    }

    public void setTgbOnePhaseElectricValue(boolean tgbOnePhaseElectricValue) {
        this.tgbOnePhaseElectricValue = tgbOnePhaseElectricValue;
    }

    public boolean isTgbShareElectricValue() {
        return tgbShareElectricValue;
    }

    public void setTgbShareElectricValue(boolean tgbShareElectricValue) {
        this.tgbShareElectricValue = tgbShareElectricValue;
    }

    public boolean isTgbPrivateElectricValue() {
        return tgbPrivateElectricValue;
    }

    public void setTgbPrivateElectricValue(boolean tgbPrivateElectricValue) {
        this.tgbPrivateElectricValue = tgbPrivateElectricValue;
    }

    public boolean isTgbShareGasMeterValue() {
        return tgbShareGasMeterValue;
    }

    public void setTgbShareGasMeterValue(boolean tgbShareGasMeterValue) {
        this.tgbShareGasMeterValue = tgbShareGasMeterValue;
    }

    public boolean isTgbPrivateGasMeterValue() {
        return tgbPrivateGasMeterValue;
    }

    public void setTgbPrivateGasMeterValue(boolean tgbPrivateGasMeterValue) {
        this.tgbPrivateGasMeterValue = tgbPrivateGasMeterValue;
    }

    public boolean isTgbShareWaterMeterValue() {
        return tgbShareWaterMeterValue;
    }

    public void setTgbShareWaterMeterValue(boolean tgbShareWaterMeterValue) {
        this.tgbShareWaterMeterValue = tgbShareWaterMeterValue;
    }

    public boolean isTgbPrivateWaterMeterValue() {
        return tgbPrivateWaterMeterValue;
    }

    public void setTgbPrivateWaterMeterValue(boolean tgbPrivateWaterMeterValue) {
        this.tgbPrivateWaterMeterValue = tgbPrivateWaterMeterValue;
    }

    public boolean isTgbPersonalTypeOfMelkDocumentValue() {
        return tgbPersonalTypeOfMelkDocumentValue;
    }

    public void setTgbPersonalTypeOfMelkDocumentValue(boolean tgbPersonalTypeOfMelkDocumentValue) {
        this.tgbPersonalTypeOfMelkDocumentValue = tgbPersonalTypeOfMelkDocumentValue;
    }

    public boolean isTgbEndowmentsTypeOfMelkDocumentValue() {
        return tgbEndowmentsTypeOfMelkDocumentValue;
    }

    public void setTgbEndowmentsTypeOfMelkDocumentValue(boolean tgbEndowmentsTypeOfMelkDocumentValue) {
        this.tgbEndowmentsTypeOfMelkDocumentValue = tgbEndowmentsTypeOfMelkDocumentValue;
    }

    public boolean isTgbCommercialTypeOfMelkDocumentValue() {
        return tgbCommercialTypeOfMelkDocumentValue;
    }

    public void setTgbCommercialTypeOfMelkDocumentValue(boolean tgbCommercialTypeOfMelkDocumentValue) {
        this.tgbCommercialTypeOfMelkDocumentValue = tgbCommercialTypeOfMelkDocumentValue;
    }

    public boolean isTgbShariRulerTypeOfMelkDocumentValue() {
        return tgbShariRulerTypeOfMelkDocumentValue;
    }

    public void setTgbShariRulerTypeOfMelkDocumentValue(boolean tgbShariRulerTypeOfMelkDocumentValue) {
        this.tgbShariRulerTypeOfMelkDocumentValue = tgbShariRulerTypeOfMelkDocumentValue;
    }

    public boolean isTgbOrganizationalTypeOfMelkDocumentValue() {
        return tgbOrganizationalTypeOfMelkDocumentValue;
    }

    public void setTgbOrganizationalTypeOfMelkDocumentValue(boolean tgbOrganizationalTypeOfMelkDocumentValue) {
        this.tgbOrganizationalTypeOfMelkDocumentValue = tgbOrganizationalTypeOfMelkDocumentValue;
    }

    public boolean isTgbOfficalTypeOfMelkDocumentValue() {
        return tgbOfficalTypeOfMelkDocumentValue;
    }

    public void setTgbOfficalTypeOfMelkDocumentValue(boolean tgbOfficalTypeOfMelkDocumentValue) {
        this.tgbOfficalTypeOfMelkDocumentValue = tgbOfficalTypeOfMelkDocumentValue;
    }

    public boolean isTgbCooperativeTypeOfMelkDocumentValue() {
        return tgbCooperativeTypeOfMelkDocumentValue;
    }

    public void setTgbCooperativeTypeOfMelkDocumentValue(boolean tgbCooperativeTypeOfMelkDocumentValue) {
        this.tgbCooperativeTypeOfMelkDocumentValue = tgbCooperativeTypeOfMelkDocumentValue;
    }

    public boolean isTgbProxyTypeOfMelkDocumentValue() {
        return tgbProxyTypeOfMelkDocumentValue;
    }

    public void setTgbProxyTypeOfMelkDocumentValue(boolean tgbProxyTypeOfMelkDocumentValue) {
        this.tgbProxyTypeOfMelkDocumentValue = tgbProxyTypeOfMelkDocumentValue;
    }

    public boolean isTgbLetterOfCreditTypeOfMelkDocumentValue() {
        return tgbLetterOfCreditTypeOfMelkDocumentValue;
    }

    public void setTgbLetterOfCreditTypeOfMelkDocumentValue(boolean tgbLetterOfCreditTypeOfMelkDocumentValue) {
        this.tgbLetterOfCreditTypeOfMelkDocumentValue = tgbLetterOfCreditTypeOfMelkDocumentValue;
    }

    public boolean isTgbJointlyTypeOfMelkDocumentValue() {
        return tgbJointlyTypeOfMelkDocumentValue;
    }

    public void setTgbJointlyTypeOfMelkDocumentValue(boolean tgbJointlyTypeOfMelkDocumentValue) {
        this.tgbJointlyTypeOfMelkDocumentValue = tgbJointlyTypeOfMelkDocumentValue;
    }

    public boolean isTgbResidentialTypeOfMelkDocumentValue() {
        return tgbResidentialTypeOfMelkDocumentValue;
    }

    public void setTgbResidentialTypeOfMelkDocumentValue(boolean tgbResidentialTypeOfMelkDocumentValue) {
        this.tgbResidentialTypeOfMelkDocumentValue = tgbResidentialTypeOfMelkDocumentValue;
    }

    public boolean isTgbIndustrialTypeOfMelkDocumentValue() {
        return tgbIndustrialTypeOfMelkDocumentValue;
    }

    public void setTgbIndustrialTypeOfMelkDocumentValue(boolean tgbIndustrialTypeOfMelkDocumentValue) {
        this.tgbIndustrialTypeOfMelkDocumentValue = tgbIndustrialTypeOfMelkDocumentValue;
    }

    public boolean isTgbPackageCoolingHealingSystemValue() {
        return tgbPackageCoolingHealingSystemValue;
    }

    public void setTgbPackageCoolingHealingSystemValue(boolean tgbPackageCoolingHealingSystemValue) {
        this.tgbPackageCoolingHealingSystemValue = tgbPackageCoolingHealingSystemValue;
    }

    public boolean isTgbHeaterCoolingHealingSystemValue() {
        return tgbHeaterCoolingHealingSystemValue;
    }

    public void setTgbHeaterCoolingHealingSystemValue(boolean tgbHeaterCoolingHealingSystemValue) {
        this.tgbHeaterCoolingHealingSystemValue = tgbHeaterCoolingHealingSystemValue;
    }

    public boolean isTgbChilerCoolingHealingSystemValue() {
        return tgbChilerCoolingHealingSystemValue;
    }

    public void setTgbChilerCoolingHealingSystemValue(boolean tgbChilerCoolingHealingSystemValue) {
        this.tgbChilerCoolingHealingSystemValue = tgbChilerCoolingHealingSystemValue;
    }

    public boolean isTgbWaterCoolerCoolingHealingSystemValue() {
        return tgbWaterCoolerCoolingHealingSystemValue;
    }

    public void setTgbWaterCoolerCoolingHealingSystemValue(boolean tgbWaterCoolerCoolingHealingSystemValue) {
        this.tgbWaterCoolerCoolingHealingSystemValue = tgbWaterCoolerCoolingHealingSystemValue;
    }

    public boolean isTgbFanCoilCoolingHealingSystemValue() {
        return tgbFanCoilCoolingHealingSystemValue;
    }

    public void setTgbFanCoilCoolingHealingSystemValue(boolean tgbFanCoilCoolingHealingSystemValue) {
        this.tgbFanCoilCoolingHealingSystemValue = tgbFanCoilCoolingHealingSystemValue;
    }

    public boolean isTgbCentralEngineRoomCoolingHealingSystemValue() {
        return tgbCentralEngineRoomCoolingHealingSystemValue;
    }

    public void setTgbCentralEngineRoomCoolingHealingSystemValue(boolean tgbCentralEngineRoomCoolingHealingSystemValue) {
        this.tgbCentralEngineRoomCoolingHealingSystemValue = tgbCentralEngineRoomCoolingHealingSystemValue;
    }

    public boolean isTgbFloorHeatingCoolingHealingSystemValue() {
        return tgbFloorHeatingCoolingHealingSystemValue;
    }

    public void setTgbFloorHeatingCoolingHealingSystemValue(boolean tgbFloorHeatingCoolingHealingSystemValue) {
        this.tgbFloorHeatingCoolingHealingSystemValue = tgbFloorHeatingCoolingHealingSystemValue;
    }

    public boolean isTgbAirConditionerCoolingHealingSystemValue() {
        return tgbAirConditionerCoolingHealingSystemValue;
    }

    public void setTgbAirConditionerCoolingHealingSystemValue(boolean tgbAirConditionerCoolingHealingSystemValue) {
        this.tgbAirConditionerCoolingHealingSystemValue = tgbAirConditionerCoolingHealingSystemValue;
    }

    public boolean isTgbGasCoolerCoolingHealingSystemValue() {
        return tgbGasCoolerCoolingHealingSystemValue;
    }

    public void setTgbGasCoolerCoolingHealingSystemValue(boolean tgbGasCoolerCoolingHealingSystemValue) {
        this.tgbGasCoolerCoolingHealingSystemValue = tgbGasCoolerCoolingHealingSystemValue;
    }

    public boolean isTgbStoneFloorCoveringValue() {
        return tgbStoneFloorCoveringValue;
    }

    public void setTgbStoneFloorCoveringValue(boolean tgbStoneFloorCoveringValue) {
        this.tgbStoneFloorCoveringValue = tgbStoneFloorCoveringValue;
    }

    public boolean isTgbCarpetFloorCoveringValue() {
        return tgbCarpetFloorCoveringValue;
    }

    public void setTgbCarpetFloorCoveringValue(boolean tgbCarpetFloorCoveringValue) {
        this.tgbCarpetFloorCoveringValue = tgbCarpetFloorCoveringValue;
    }

    public boolean isTgbParquetFloorCoveringValue() {
        return tgbParquetFloorCoveringValue;
    }

    public void setTgbParquetFloorCoveringValue(boolean tgbParquetFloorCoveringValue) {
        this.tgbParquetFloorCoveringValue = tgbParquetFloorCoveringValue;
    }

    public boolean isTgbMosaicFloorCoveringValue() {
        return tgbMosaicFloorCoveringValue;
    }

    public void setTgbMosaicFloorCoveringValue(boolean tgbMosaicFloorCoveringValue) {
        this.tgbMosaicFloorCoveringValue = tgbMosaicFloorCoveringValue;
    }

    public boolean isTgbAsphaltFloorCoveringValue() {
        return tgbAsphaltFloorCoveringValue;
    }

    public void setTgbAsphaltFloorCoveringValue(boolean tgbAsphaltFloorCoveringValue) {
        this.tgbAsphaltFloorCoveringValue = tgbAsphaltFloorCoveringValue;
    }

    public boolean isTgbCeramicFloorCoveringValue() {
        return tgbCeramicFloorCoveringValue;
    }

    public void setTgbCeramicFloorCoveringValue(boolean tgbCeramicFloorCoveringValue) {
        this.tgbCeramicFloorCoveringValue = tgbCeramicFloorCoveringValue;
    }

    public boolean isTgbLaminatFloorCoveringValue() {
        return tgbLaminatFloorCoveringValue;
    }

    public void setTgbLaminatFloorCoveringValue(boolean tgbLaminatFloorCoveringValue) {
        this.tgbLaminatFloorCoveringValue = tgbLaminatFloorCoveringValue;
    }

    public boolean isTgbWoodFloorCoveringValue() {
        return tgbWoodFloorCoveringValue;
    }

    public void setTgbWoodFloorCoveringValue(boolean tgbWoodFloorCoveringValue) {
        this.tgbWoodFloorCoveringValue = tgbWoodFloorCoveringValue;
    }

    public boolean isTgbGraniteFloorCoveringValue() {
        return tgbGraniteFloorCoveringValue;
    }

    public void setTgbGraniteFloorCoveringValue(boolean tgbGraniteFloorCoveringValue) {
        this.tgbGraniteFloorCoveringValue = tgbGraniteFloorCoveringValue;
    }

    public boolean isTgbCementFloorCoveringValue() {
        return tgbCementFloorCoveringValue;
    }

    public void setTgbCementFloorCoveringValue(boolean tgbCementFloorCoveringValue) {
        this.tgbCementFloorCoveringValue = tgbCementFloorCoveringValue;
    }

    public boolean isTgbKonteksBuildingFacadesValue() {
        return tgbKonteksBuildingFacadesValue;
    }

    public void setTgbKonteksBuildingFacadesValue(boolean tgbKonteksBuildingFacadesValue) {
        this.tgbKonteksBuildingFacadesValue = tgbKonteksBuildingFacadesValue;
    }

    public boolean isTgbAluminumBuildingFacadesValue() {
        return tgbAluminumBuildingFacadesValue;
    }

    public void setTgbAluminumBuildingFacadesValue(boolean tgbAluminumBuildingFacadesValue) {
        this.tgbAluminumBuildingFacadesValue = tgbAluminumBuildingFacadesValue;
    }

    public boolean isTgbBrickBuildingFacadesValue() {
        return tgbBrickBuildingFacadesValue;
    }

    public void setTgbBrickBuildingFacadesValue(boolean tgbBrickBuildingFacadesValue) {
        this.tgbBrickBuildingFacadesValue = tgbBrickBuildingFacadesValue;
    }

    public boolean isTgbCementBuildingFacadesValue() {
        return tgbCementBuildingFacadesValue;
    }

    public void setTgbCementBuildingFacadesValue(boolean tgbCementBuildingFacadesValue) {
        this.tgbCementBuildingFacadesValue = tgbCementBuildingFacadesValue;
    }

    public boolean isTgbWoodBuildingFacadesValue() {
        return tgbWoodBuildingFacadesValue;
    }

    public void setTgbWoodBuildingFacadesValue(boolean tgbWoodBuildingFacadesValue) {
        this.tgbWoodBuildingFacadesValue = tgbWoodBuildingFacadesValue;
    }

    public boolean isTgbStoneBuildingFacadesValue() {
        return tgbStoneBuildingFacadesValue;
    }

    public void setTgbStoneBuildingFacadesValue(boolean tgbStoneBuildingFacadesValue) {
        this.tgbStoneBuildingFacadesValue = tgbStoneBuildingFacadesValue;
    }

    public boolean isTgbCeramicBuildingFacadesValue() {
        return tgbCeramicBuildingFacadesValue;
    }

    public void setTgbCeramicBuildingFacadesValue(boolean tgbCeramicBuildingFacadesValue) {
        this.tgbCeramicBuildingFacadesValue = tgbCeramicBuildingFacadesValue;
    }

    public boolean isTgbGlassBuildingFacadesValue() {
        return tgbGlassBuildingFacadesValue;
    }

    public void setTgbGlassBuildingFacadesValue(boolean tgbGlassBuildingFacadesValue) {
        this.tgbGlassBuildingFacadesValue = tgbGlassBuildingFacadesValue;
    }

    public boolean isTgbCompositeBuildingFacadesValue() {
        return tgbCompositeBuildingFacadesValue;
    }

    public void setTgbCompositeBuildingFacadesValue(boolean tgbCompositeBuildingFacadesValue) {
        this.tgbCompositeBuildingFacadesValue = tgbCompositeBuildingFacadesValue;
    }

    public boolean isTgbHiGlassKitchenCabinetsValue() {
        return tgbHiGlassKitchenCabinetsValue;
    }

    public void setTgbHiGlassKitchenCabinetsValue(boolean tgbHiGlassKitchenCabinetsValue) {
        this.tgbHiGlassKitchenCabinetsValue = tgbHiGlassKitchenCabinetsValue;
    }

    public boolean isTgbHdfKitchenCabinetsValue() {
        return tgbHdfKitchenCabinetsValue;
    }

    public void setTgbHdfKitchenCabinetsValue(boolean tgbHdfKitchenCabinetsValue) {
        this.tgbHdfKitchenCabinetsValue = tgbHdfKitchenCabinetsValue;
    }

    public boolean isTgbMetalKitchenCabinetsValue() {
        return tgbMetalKitchenCabinetsValue;
    }

    public void setTgbMetalKitchenCabinetsValue(boolean tgbMetalKitchenCabinetsValue) {
        this.tgbMetalKitchenCabinetsValue = tgbMetalKitchenCabinetsValue;
    }

    public boolean isTgbMdfKitchenCabinetsValue() {
        return tgbMdfKitchenCabinetsValue;
    }

    public void setTgbMdfKitchenCabinetsValue(boolean tgbMdfKitchenCabinetsValue) {
        this.tgbMdfKitchenCabinetsValue = tgbMdfKitchenCabinetsValue;
    }

    public boolean isTgbwoodKitchenCabinetsValue() {
        return tgbwoodKitchenCabinetsValue;
    }

    public void setTgbwoodKitchenCabinetsValue(boolean tgbwoodKitchenCabinetsValue) {
        this.tgbwoodKitchenCabinetsValue = tgbwoodKitchenCabinetsValue;
    }

    public boolean isTgbPvcKitchenCabinetsValue() {
        return tgbPvcKitchenCabinetsValue;
    }

    public void setTgbPvcKitchenCabinetsValue(boolean tgbPvcKitchenCabinetsValue) {
        this.tgbPvcKitchenCabinetsValue = tgbPvcKitchenCabinetsValue;
    }

    public boolean isTgbPassageBuildingTypeValue() {
        return tgbPassageBuildingTypeValue;
    }

    public void setTgbPassageBuildingTypeValue(boolean tgbPassageBuildingTypeValue) {
        this.tgbPassageBuildingTypeValue = tgbPassageBuildingTypeValue;
    }

    public boolean isTgbVillaBuildingTypeValue() {
        return tgbVillaBuildingTypeValue;
    }

    public void setTgbVillaBuildingTypeValue(boolean tgbVillaBuildingTypeValue) {
        this.tgbVillaBuildingTypeValue = tgbVillaBuildingTypeValue;
    }

    public boolean isTgbTowerBuildingTypeValue() {
        return tgbTowerBuildingTypeValue;
    }

    public void setTgbTowerBuildingTypeValue(boolean tgbTowerBuildingTypeValue) {
        this.tgbTowerBuildingTypeValue = tgbTowerBuildingTypeValue;
    }

    public boolean isTgbApartmentBuildingTypeValue() {
        return tgbApartmentBuildingTypeValue;
    }

    public void setTgbApartmentBuildingTypeValue(boolean tgbApartmentBuildingTypeValue) {
        this.tgbApartmentBuildingTypeValue = tgbApartmentBuildingTypeValue;
    }

    public boolean isTgbIntegratedBuildingTypeValue() {
        return tgbIntegratedBuildingTypeValue;
    }

    public void setTgbIntegratedBuildingTypeValue(boolean tgbIntegratedBuildingTypeValue) {
        this.tgbIntegratedBuildingTypeValue = tgbIntegratedBuildingTypeValue;
    }

    public boolean isTgbLakeViewValue() {
        return tgbLakeViewValue;
    }

    public void setTgbLakeViewValue(boolean tgbLakeViewValue) {
        this.tgbLakeViewValue = tgbLakeViewValue;
    }

    public boolean isTgbJangleViewValue() {
        return tgbJangleViewValue;
    }

    public void setTgbJangleViewValue(boolean tgbJangleViewValue) {
        this.tgbJangleViewValue = tgbJangleViewValue;
    }

    public boolean isTgbCityViewValue() {
        return tgbCityViewValue;
    }

    public void setTgbCityViewValue(boolean tgbCityViewValue) {
        this.tgbCityViewValue = tgbCityViewValue;
    }

    public boolean isTgbPanoramaViewValue() {
        return tgbPanoramaViewValue;
    }

    public void setTgbPanoramaViewValue(boolean tgbPanoramaViewValue) {
        this.tgbPanoramaViewValue = tgbPanoramaViewValue;
    }

    public boolean isTgbParkViewValue() {
        return tgbParkViewValue;
    }

    public void setTgbParkViewValue(boolean tgbParkViewValue) {
        this.tgbParkViewValue = tgbParkViewValue;
    }

    public boolean isTgbMountainViewValue() {
        return tgbMountainViewValue;
    }

    public void setTgbMountainViewValue(boolean tgbMountainViewValue) {
        this.tgbMountainViewValue = tgbMountainViewValue;
    }

    public boolean isTgbSeaViewValue() {
        return tgbSeaViewValue;
    }

    public void setTgbSeaViewValue(boolean tgbSeaViewValue) {
        this.tgbSeaViewValue = tgbSeaViewValue;
    }

    public boolean isTgbRiverViewValue() {
        return tgbRiverViewValue;
    }

    public void setTgbRiverViewValue(boolean tgbRiverViewValue) {
        this.tgbRiverViewValue = tgbRiverViewValue;
    }

    public boolean isTgbSkyViewValue() {
        return tgbSkyViewValue;
    }

    public void setTgbSkyViewValue(boolean tgbSkyViewValue) {
        this.tgbSkyViewValue = tgbSkyViewValue;
    }

    public boolean isTgbLibraryRoomTypeValue() {
        return tgbLibraryRoomTypeValue;
    }

    public void setTgbLibraryRoomTypeValue(boolean tgbLibraryRoomTypeValue) {
        this.tgbLibraryRoomTypeValue = tgbLibraryRoomTypeValue;
    }

    public boolean isTgbDressingRoomTypeValue() {
        return tgbDressingRoomTypeValue;
    }

    public void setTgbDressingRoomTypeValue(boolean tgbDressingRoomTypeValue) {
        this.tgbDressingRoomTypeValue = tgbDressingRoomTypeValue;
    }

    public boolean isTgbDiningRoomTypeValue() {
        return tgbDiningRoomTypeValue;
    }

    public void setTgbDiningRoomTypeValue(boolean tgbDiningRoomTypeValue) {
        this.tgbDiningRoomTypeValue = tgbDiningRoomTypeValue;
    }

    public boolean isTgbWorkShopRoomTypeValue() {
        return tgbWorkShopRoomTypeValue;
    }

    public void setTgbWorkShopRoomTypeValue(boolean tgbWorkShopRoomTypeValue) {
        this.tgbWorkShopRoomTypeValue = tgbWorkShopRoomTypeValue;
    }

    public boolean isTgbWorkRoomTypeValue() {
        return tgbWorkRoomTypeValue;
    }

    public void setTgbWorkRoomTypeValue(boolean tgbWorkRoomTypeValue) {
        this.tgbWorkRoomTypeValue = tgbWorkRoomTypeValue;
    }

    public boolean isTgbHomeLollipopRoomTypeValue() {
        return tgbHomeLollipopRoomTypeValue;
    }

    public void setTgbHomeLollipopRoomTypeValue(boolean tgbHomeLollipopRoomTypeValue) {
        this.tgbHomeLollipopRoomTypeValue = tgbHomeLollipopRoomTypeValue;
    }

    public boolean isTgbRefrigeratorFurnishedFacilitiesValue() {
        return tgbRefrigeratorFurnishedFacilitiesValue;
    }

    public void setTgbRefrigeratorFurnishedFacilitiesValue(boolean tgbRefrigeratorFurnishedFacilitiesValue) {
        this.tgbRefrigeratorFurnishedFacilitiesValue = tgbRefrigeratorFurnishedFacilitiesValue;
    }

    public boolean isTgbMacrowaveFurnishedFacilitiesValue() {
        return tgbMacrowaveFurnishedFacilitiesValue;
    }

    public void setTgbMacrowaveFurnishedFacilitiesValue(boolean tgbMacrowaveFurnishedFacilitiesValue) {
        this.tgbMacrowaveFurnishedFacilitiesValue = tgbMacrowaveFurnishedFacilitiesValue;
    }

    public boolean isTgbCarpeteFurnishedFacilitiesValue() {
        return tgbCarpeteFurnishedFacilitiesValue;
    }

    public void setTgbCarpeteFurnishedFacilitiesValue(boolean tgbCarpeteFurnishedFacilitiesValue) {
        this.tgbCarpeteFurnishedFacilitiesValue = tgbCarpeteFurnishedFacilitiesValue;
    }

    public boolean isTgbChandelierFurnishedFacilitiesValue() {
        return tgbChandelierFurnishedFacilitiesValue;
    }

    public void setTgbChandelierFurnishedFacilitiesValue(boolean tgbChandelierFurnishedFacilitiesValue) {
        this.tgbChandelierFurnishedFacilitiesValue = tgbChandelierFurnishedFacilitiesValue;
    }

    public boolean isTgbVacuumeCleanerFurnishedFacilitiesValue() {
        return tgbVacuumeCleanerFurnishedFacilitiesValue;
    }

    public void setTgbVacuumeCleanerFurnishedFacilitiesValue(boolean tgbVacuumeCleanerFurnishedFacilitiesValue) {
        this.tgbVacuumeCleanerFurnishedFacilitiesValue = tgbVacuumeCleanerFurnishedFacilitiesValue;
    }

    public boolean isTgbDishwasherFurnishedFacilitiesValue() {
        return tgbDishwasherFurnishedFacilitiesValue;
    }

    public void setTgbDishwasherFurnishedFacilitiesValue(boolean tgbDishwasherFurnishedFacilitiesValue) {
        this.tgbDishwasherFurnishedFacilitiesValue = tgbDishwasherFurnishedFacilitiesValue;
    }

    public boolean isTgbBedFurnishedFacilitiesValue() {
        return tgbBedFurnishedFacilitiesValue;
    }

    public void setTgbBedFurnishedFacilitiesValue(boolean tgbBedFurnishedFacilitiesValue) {
        this.tgbBedFurnishedFacilitiesValue = tgbBedFurnishedFacilitiesValue;
    }

    public boolean isTgbOvenFurnishedFacilitiesValue() {
        return tgbOvenFurnishedFacilitiesValue;
    }

    public void setTgbOvenFurnishedFacilitiesValue(boolean tgbOvenFurnishedFacilitiesValue) {
        this.tgbOvenFurnishedFacilitiesValue = tgbOvenFurnishedFacilitiesValue;
    }

    public boolean isTgbFurnitureFurnishedFacilitiesValue() {
        return tgbFurnitureFurnishedFacilitiesValue;
    }

    public void setTgbFurnitureFurnishedFacilitiesValue(boolean tgbFurnitureFurnishedFacilitiesValue) {
        this.tgbFurnitureFurnishedFacilitiesValue = tgbFurnitureFurnishedFacilitiesValue;
    }

    public boolean isTgbTelevisionFurnishedFacilitiesValue() {
        return tgbTelevisionFurnishedFacilitiesValue;
    }

    public void setTgbTelevisionFurnishedFacilitiesValue(boolean tgbTelevisionFurnishedFacilitiesValue) {
        this.tgbTelevisionFurnishedFacilitiesValue = tgbTelevisionFurnishedFacilitiesValue;
    }

    public boolean isTgbOttoFurnishedFacilitiesValue() {
        return tgbOttoFurnishedFacilitiesValue;
    }

    public void setTgbOttoFurnishedFacilitiesValue(boolean tgbOttoFurnishedFacilitiesValue) {
        this.tgbOttoFurnishedFacilitiesValue = tgbOttoFurnishedFacilitiesValue;
    }

    public boolean isTgbWashingMachineFurnishedFacilitiesValue() {
        return tgbWashingMachineFurnishedFacilitiesValue;
    }

    public void setTgbWashingMachineFurnishedFacilitiesValue(boolean tgbWashingMachineFurnishedFacilitiesValue) {
        this.tgbWashingMachineFurnishedFacilitiesValue = tgbWashingMachineFurnishedFacilitiesValue;
    }

    public boolean isTgbDishesFurnishedFacilitiesValue() {
        return tgbDishesFurnishedFacilitiesValue;
    }

    public void setTgbDishesFurnishedFacilitiesValue(boolean tgbDishesFurnishedFacilitiesValue) {
        this.tgbDishesFurnishedFacilitiesValue = tgbDishesFurnishedFacilitiesValue;
    }

    public boolean isTgbDishesCurtainFacilitiesValue() {
        return tgbDishesCurtainFacilitiesValue;
    }

    public void setTgbDishesCurtainFacilitiesValue(boolean tgbDishesCurtainFacilitiesValue) {
        this.tgbDishesCurtainFacilitiesValue = tgbDishesCurtainFacilitiesValue;
    }

    public boolean isTgbGentleWindowsType() {
        return tgbGentleWindowsType;
    }

    public void setTgbGentleWindowsType(boolean tgbGentleWindowsType) {
        this.tgbGentleWindowsType = tgbGentleWindowsType;
    }

    public boolean isTgbPvcTowShellsWindowsType() {
        return tgbPvcTowShellsWindowsType;
    }

    public void setTgbPvcTowShellsWindowsType(boolean tgbPvcTowShellsWindowsType) {
        this.tgbPvcTowShellsWindowsType = tgbPvcTowShellsWindowsType;
    }

    public boolean isTgbMetalWindowsType() {
        return tgbMetalWindowsType;
    }

    public void setTgbMetalWindowsType(boolean tgbMetalWindowsType) {
        this.tgbMetalWindowsType = tgbMetalWindowsType;
    }

    public boolean isTgbWoodWindowsType() {
        return tgbWoodWindowsType;
    }

    public void setTgbWoodWindowsType(boolean tgbWoodWindowsType) {
        this.tgbWoodWindowsType = tgbWoodWindowsType;
    }

    public boolean isTgbMetalTowShellsWindowsType() {
        return tgbMetalTowShellsWindowsType;
    }

    public void setTgbMetalTowShellsWindowsType(boolean tgbMetalTowShellsWindowsType) {
        this.tgbMetalTowShellsWindowsType = tgbMetalTowShellsWindowsType;
    }

    public boolean isTgbFiberGlassWindowsType() {
        return tgbFiberGlassWindowsType;
    }

    public void setTgbFiberGlassWindowsType(boolean tgbFiberGlassWindowsType) {
        this.tgbFiberGlassWindowsType = tgbFiberGlassWindowsType;
    }

    public boolean isTgbAluminiumThermalBreak() {
        return tgbAluminiumThermalBreak;
    }

    public void setTgbAluminiumThermalBreak(boolean tgbAluminiumThermalBreak) {
        this.tgbAluminiumThermalBreak = tgbAluminiumThermalBreak;
    }

    public boolean isTgbOfficialUsageTypeValue() {
        return tgbOfficialUsageTypeValue;
    }

    public void setTgbOfficialUsageTypeValue(boolean tgbOfficialUsageTypeValue) {
        this.tgbOfficialUsageTypeValue = tgbOfficialUsageTypeValue;
    }

    public boolean isTgbCommercialUsageTypeValue() {
        return tgbCommercialUsageTypeValue;
    }

    public void setTgbCommercialUsageTypeValue(boolean tgbCommercialUsageTypeValue) {
        this.tgbCommercialUsageTypeValue = tgbCommercialUsageTypeValue;
    }

    public boolean isTgbIndustrialUsageTypeValue() {
        return tgbIndustrialUsageTypeValue;
    }

    public void setTgbIndustrialUsageTypeValue(boolean tgbIndustrialUsageTypeValue) {
        this.tgbIndustrialUsageTypeValue = tgbIndustrialUsageTypeValue;
    }

    public boolean isTgbStoreUsageTypeValue() {
        return tgbStoreUsageTypeValue;
    }

    public void setTgbStoreUsageTypeValue(boolean tgbStoreUsageTypeValue) {
        this.tgbStoreUsageTypeValue = tgbStoreUsageTypeValue;
    }

    public boolean isTgbAnimalHusbandryUsageTypeValue() {
        return tgbAnimalHusbandryUsageTypeValue;
    }

    public void setTgbAnimalHusbandryUsageTypeValue(boolean tgbAnimalHusbandryUsageTypeValue) {
        this.tgbAnimalHusbandryUsageTypeValue = tgbAnimalHusbandryUsageTypeValue;
    }

    public boolean isTgbEducationalUsageTypeValue() {
        return tgbEducationalUsageTypeValue;
    }

    public void setTgbEducationalUsageTypeValue(boolean tgbEducationalUsageTypeValue) {
        this.tgbEducationalUsageTypeValue = tgbEducationalUsageTypeValue;
    }

    public boolean isTgbResidentialUsageTypeValue() {
        return tgbResidentialUsageTypeValue;
    }

    public void setTgbResidentialUsageTypeValue(boolean tgbResidentialUsageTypeValue) {
        this.tgbResidentialUsageTypeValue = tgbResidentialUsageTypeValue;
    }

    public boolean isTgbAdministrativePositionUsageTypeValue() {
        return tgbAdministrativePositionUsageTypeValue;
    }

    public void setTgbAdministrativePositionUsageTypeValue(boolean tgbAdministrativePositionUsageTypeValue) {
        this.tgbAdministrativePositionUsageTypeValue = tgbAdministrativePositionUsageTypeValue;
    }

    public boolean isTgbResidentUsageTypeValue() {
        return tgbResidentUsageTypeValue;
    }

    public void setTgbResidentUsageTypeValue(boolean tgbResidentUsageTypeValue) {
        this.tgbResidentUsageTypeValue = tgbResidentUsageTypeValue;
    }

    public boolean isTgbAgricultureUsageTypeValue() {
        return tgbAgricultureUsageTypeValue;
    }

    public void setTgbAgricultureUsageTypeValue(boolean tgbAgricultureUsageTypeValue) {
        this.tgbAgricultureUsageTypeValue = tgbAgricultureUsageTypeValue;
    }

    public boolean isTgbSportsUsageTypeValue() {
        return tgbSportsUsageTypeValue;
    }

    public void setTgbSportsUsageTypeValue(boolean tgbSportsUsageTypeValue) {
        this.tgbSportsUsageTypeValue = tgbSportsUsageTypeValue;
    }

    public boolean isTgbClinicUsageTypeValue() {
        return tgbClinicUsageTypeValue;
    }

    public void setTgbClinicUsageTypeValue(boolean tgbClinicUsageTypeValue) {
        this.tgbClinicUsageTypeValue = tgbClinicUsageTypeValue;
    }

    public int getHpDistanceToVehicleValue() {
        return hpDistanceToVehicleValue;
    }

    public void setHpDistanceToVehicleValue(int hpDistanceToVehicleValue) {
        this.hpDistanceToVehicleValue = hpDistanceToVehicleValue;
    }

    public String getEdtMoreInfoValue() {
        return edtMoreInfoValue;
    }

    public void setEdtMoreInfoValue(String edtMoreInfoValue) {
        this.edtMoreInfoValue = edtMoreInfoValue;
    }
}