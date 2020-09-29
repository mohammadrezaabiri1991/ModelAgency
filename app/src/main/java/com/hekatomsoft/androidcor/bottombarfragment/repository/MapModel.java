package com.hekatomsoft.androidcor.bottombarfragment.repository;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class MapModel extends RealmObject {


    private long melk_id_Model;
    @PrimaryKey
    private long unitId_Model;
    //------------------------------------------------------------------------
    private MarkerPosition markerPosition;
    //------------------------------------------------------------------------
    private int spTransTypeModel;
    private int spMelkTypeModel;

    private String edtMelkAreaModel;
    private String edtAmountSellPerMetricModel;
    private boolean swInstallmentModel;
    private String edtAmountSellModel;
    private String edtInstallmentTermsModel;
    private String edtAmountRentModel;
    private String edtAmountRahnModel;
    private boolean tgbChangeableToRentModel;
    private boolean tgbChangeableToRahnModel;
    private int hpNumberOfOwnersModel;
    private String edtOwnerInformationsModel;
    private int hpDungForSellModel;
    private String edtSinceQuantityModel;
    private int hpMaxAllowedForResidencesModel;
    private int hpPercentageOfProgressMadeModel;
    private String txtSelectMelkReceiveTimeModel;
    private int hpMelkAgeModel;
    private int hpNumberOfBedRoomsModel;
    private int hpFloorNumberModel;
    private int hpNumberOfFloorsModel;
    private int hpNumberOfUnitInFloorModel;

    private boolean swDateOfQuitModel;
    private String txtDateOfQuitModel;

    private boolean swHasLoanModel;
    private String edtAmountLoanModel;
    private int hpNumberOfElevatorModel;
    private int hpNumberOfBathRoomModel;
    private int hpNumberOfParkingModel;
    private int hpNumberOfKitchenModel;
    private int hpNumberOfMasterRoomModel;
    private int hpNumberOfIraniToiletModel;
    private int hpNumberOfFarangiToiletModel;

    private int hpNumberOfTellSubModel;

    private String edtAmountMountChargeModel;
    private int hpNumberOfRoofSpaceModel;
    private int hpHeightOfTheCeilingModel;
    private int hpMelkWidthModel;

    private boolean tgbFlatUnitTypeModel;
    private boolean tgbDoublexUnitTypeModel;
    private boolean tgbTriplexUnitTypeModel;
    private boolean tgbBeachMelkPositionsModel;
    private boolean tgbJangleMelkPositionsModel;
    private boolean tgbMountainMelkPositionsModel;
    private boolean tgbTownshipMelkPositionsModel;

    private boolean tgbPatioPossibilitiesModel;
    private boolean tgbWaterWellPossibilitiesModel;
    private boolean tgbBalconyPossibilitiesModel;
    private boolean tgbVideoIphonePossibilitiesModel;
    private boolean tgbWallClosetPossibilitiesModel;
    private boolean tgbStorePossibilitiesModel;
    private boolean tgbYardPossibilitiesModel;
    private boolean tgbJantorPossibilitiesModel;
    private boolean tgbRebuildPossibilitiesModel;
    private boolean tgbSofaPossibilitiesModel;
    private boolean tgbCameraPossibilitiesModel;
    private boolean tgbCentralAntennaPossibilitiesModel;
    private boolean tgbChangeablePossibilitiesModel;


    private boolean tgbLobbySpecialFeaturesModel;
    private boolean tgbBathtubSpecialFeaturesModel;
    private boolean tgbSwimmingPoolSpecialFeaturesModel;
    private boolean tgbFirePlaceSpecialFeaturesModel;
    private boolean tgbChildrenPlaySpaceSpecialFeaturesModel;
    private boolean tgbGardenYardSpecialFeaturesModel;
    private boolean tgbCentralVacuumCleanerSpecialFeaturesModel;
    private boolean tgbAmphitheaterSpecialFeaturesModel;
    private boolean tgbConferenceHallSpecialFeaturesModel;
    private boolean tgbFirefightSpecialFeaturesModel;
    private boolean tgbSolarBatterySpecialFeaturesModel;
    private boolean tgbFountainSpecialFeaturesModel;
    private boolean tgbCargoElevatorSpecialFeaturesModel;
    private boolean tgbWaterSupplySpecialFeaturesModel;
    private boolean tgbTennisCourtFeaturesModel;
    private boolean tgbGuestParkingSpecialFeaturesModel;
    private boolean tgbSaunaSpecialFeaturesModel;
    private boolean tgbJacuzziSpecialFeaturesModel;
    private boolean tgbChildrenPoolSpecialFeaturesModel;
    private boolean tgbRoofGardenSpecialFeaturesModel;
    private boolean tgbBarbecueSpecialFeaturesModel;
    private boolean tgbShootingWasteSpecialFeaturesModel;
    private boolean tgbAltarSpecialFeaturesModel;
    private boolean tgbSecuritySystemSpecialFeaturesModel;
    private boolean tgbSmartHomeSpecialFeaturesModel;
    private boolean tgbSafeguardSpecialFeaturesModel;
    private boolean tgbEmergencyPowerSpecialFeaturesModel;
    private boolean tgbCaretakersRoomSpecialFeaturesModel;
    private boolean tgbSecurityDoorSpecialFeaturesModel;
    private boolean tgbWaterPurifierSpecialFeaturesModel;
    private boolean tgbParkingRemoteSpecialFeaturesModel;
    private boolean tgbPoolTableSpecialFeaturesModel;


    private boolean tgbWestGeoPositionModel;
    private boolean tgbEstGeoPositionModel;
    private boolean tgbSouthGeoPositionModel;
    private boolean tgbNorthGeoPositionModel;
    private boolean tgbBlotsButsStructTypeModel;
    private boolean tgbMetalStructTypeModel;
    private boolean tgbConcreteAndBarStructTypeModel;
    private boolean tgbWestLightingDirectModel;
    private boolean tgbEstLightingDirectModel;
    private boolean tgbSouthtLightingDirectModel;
    private boolean tgbNorthLightingDirectModel;

    private boolean tgbGoodwillModel;
    private boolean tgbPropertyModel;
    private boolean tgbThreePhaseElectricModel;
    private boolean tgbOnePhaseElectricModel;
    private boolean tgbShareElectricModel;
    private boolean tgbPrivateElectricModel;
    private boolean tgbShareGasMeterModel;
    private boolean tgbPrivateGasMeterModel;
    private boolean tgbShareWaterMeterModel;
    private boolean tgbPrivateWaterMeterModel;


    private boolean tgbPersonalTypeOfMelkDocumentModel;
    private boolean tgbEndowmentsTypeOfMelkDocumentModel;
    private boolean tgbCommercialTypeOfMelkDocumentModel;
    private boolean tgbShariRulerTypeOfMelkDocumentModel;
    private boolean tgbOrganizationalTypeOfMelkDocumentModel;
    private boolean tgbOfficalTypeOfMelkDocumentModel;
    private boolean tgbCooperativeTypeOfMelkDocumentModel;
    private boolean tgbProxyTypeOfMelkDocumentModel;
    private boolean tgbLetterOfCreditTypeOfMelkDocumentModel;
    private boolean tgbJointlyTypeOfMelkDocumentModel;
    private boolean tgbResidentialTypeOfMelkDocumentModel;
    private boolean tgbIndustrialTypeOfMelkDocumentModel;

    private boolean tgbPackageCoolingHealingSystemModel;
    private boolean tgbHeaterCoolingHealingSystemModel;
    private boolean tgbChilerCoolingHealingSystemModel;
    private boolean tgbWaterCoolerCoolingHealingSystemModel;
    private boolean tgbFanCoilCoolingHealingSystemModel;
    private boolean tgbCentralEngineRoomCoolingHealingSystemModel;
    private boolean tgbFloorHeatingCoolingHealingSystemModel;
    private boolean tgbAirConditionerCoolingHealingSystemModel;
    private boolean tgbGasCoolerCoolingHealingSystemModel;

    private boolean tgbStoneFloorCoveringModel;
    private boolean tgbCarpetFloorCoveringModel;
    private boolean tgbParquetFloorCoveringModel;
    private boolean tgbMosaicFloorCoveringModel;
    private boolean tgbAsphaltFloorCoveringModel;
    private boolean tgbCeramicFloorCoveringModel;
    private boolean tgbLaminatFloorCoveringModel;
    private boolean tgbWoodFloorCoveringModel;
    private boolean tgbGraniteFloorCoveringModel;
    private boolean tgbCementFloorCoveringModel;

    private boolean tgbKonteksBuildingFacadesModel;
    private boolean tgbAluminumBuildingFacadesModel;
    private boolean tgbBrickBuildingFacadesModel;
    private boolean tgbCementBuildingFacadesModel;
    private boolean tgbWoodBuildingFacadesModel;
    private boolean tgbStoneBuildingFacadesModel;
    private boolean tgbCeramicBuildingFacadesModel;
    private boolean tgbGlassBuildingFacadesModel;
    private boolean tgbCompositeBuildingFacadesModel;


    private boolean tgbHiGlassKitchenCabinetsModel;
    private boolean tgbHdfKitchenCabinetsModel;


    private boolean tgbMetalKitchenCabinetsModel;
    private boolean tgbMdfKitchenCabinetsModel;
    private boolean tgbwoodKitchenCabinetsModel;
    private boolean tgbPvcKitchenCabinetsModel;

    private boolean tgbPassageBuildingTypeModel;
    private boolean tgbVillaBuildingTypeModel;
    private boolean tgbTowerBuildingTypeModel;
    private boolean tgbApartmentBuildingTypeModel;
    private boolean tgbIntegratedBuildingTypeModel;

    private boolean tgbLakeViewModel;
    private boolean tgbJangleViewModel;
    private boolean tgbCityViewModel;
    private boolean tgbPanoramaViewModel;
    private boolean tgbParkViewModel;
    private boolean tgbMountainViewModel;
    private boolean tgbSeaViewModel;
    private boolean tgbRiverViewModel;
    private boolean tgbSkyViewModel;

    private boolean tgbLibraryRoomTypeModel;
    private boolean tgbDressingRoomTypeModel;
    private boolean tgbDiningRoomTypeModel;
    private boolean tgbWorkShopRoomTypeModel;
    private boolean tgbWorkRoomTypeModel;
    private boolean tgbHomeLollipopRoomTypeModel;

    private boolean tgbRefrigeratorFurnishedFacilitiesModel;
    private boolean tgbMacrowaveFurnishedFacilitiesModel;
    private boolean tgbCarpeteFurnishedFacilitiesModel;
    private boolean tgbChandelierFurnishedFacilitiesModel;
    private boolean tgbVacuumeCleanerFurnishedFacilitiesModel;
    private boolean tgbDishwasherFurnishedFacilitiesModel;
    private boolean tgbBedFurnishedFacilitiesModel;
    private boolean tgbOvenFurnishedFacilitiesModel;
    private boolean tgbFurnitureFurnishedFacilitiesModel;

    private boolean tgbTelevisionFurnishedFacilitiesModel;
    private boolean tgbOttoFurnishedFacilitiesModel;
    private boolean tgbWashingMachineFurnishedFacilitiesModel;
    private boolean tgbDishesFurnishedFacilitiesModel;
    private boolean tgbDishesCurtainFacilitiesModel;


    private boolean tgbGentleWindowsType;
    private boolean tgbPvcTowShellsWindowsType;
    private boolean tgbMetalWindowsType;
    private boolean tgbWoodWindowsType;
    private boolean tgbMetalTowShellsWindowsType;
    private boolean tgbFiberGlassWindowsType;
    private boolean tgbAluminiumThermalBreak;

    private boolean tgbOfficialUsageTypeModel;
    private boolean tgbCommercialUsageTypeModel;
    private boolean tgbIndustrialUsageTypeModel;
    private boolean tgbStoreUsageTypeModel;
    private boolean tgbAnimalHusbandryUsageTypeModel;
    private boolean tgbEducationalUsageTypeModel;
    private boolean tgbResidentialUsageTypeModel;
    private boolean tgbAdministrativePositionUsageTypeModel;
    private boolean tgbResidentUsageTypeModel;
    private boolean tgbAgricultureUsageTypeModel;
    private boolean tgbSportsUsageTypeModel;
    private boolean tgbClinicUsageTypeModel;

    private int hpDistanceToVehicleModel;
    private String edtMoreInfoModel;

    public long getMelk_id_Model() {
        return melk_id_Model;
    }

    public void setMelk_id_Model(long melk_id_Model) {
        this.melk_id_Model = melk_id_Model;
    }

    public long getUnitId_Model() {
        return unitId_Model;
    }

    public void setUnitId_Model(long unitId_Model) {
        this.unitId_Model = unitId_Model;
    }

    public MarkerPosition getMarkerPosition() {
        return markerPosition;
    }

    public void setMarkerPosition(MarkerPosition markerPosition) {
        this.markerPosition = markerPosition;
    }

    public int getSpTransTypeModel() {
        return spTransTypeModel;
    }

    public void setSpTransTypeModel(int spTransTypeModel) {
        this.spTransTypeModel = spTransTypeModel;
    }

    public int getSpMelkTypeModel() {
        return spMelkTypeModel;
    }

    public void setSpMelkTypeModel(int spMelkTypeModel) {
        this.spMelkTypeModel = spMelkTypeModel;
    }

    public String getEdtMelkAreaModel() {
        return edtMelkAreaModel;
    }

    public void setEdtMelkAreaModel(String edtMelkAreaModel) {
        this.edtMelkAreaModel = edtMelkAreaModel;
    }

    public String getEdtAmountSellPerMetricModel() {
        return edtAmountSellPerMetricModel;
    }

    public void setEdtAmountSellPerMetricModel(String edtAmountSellPerMetricModel) {
        this.edtAmountSellPerMetricModel = edtAmountSellPerMetricModel;
    }

    public boolean isSwInstallmentModel() {
        return swInstallmentModel;
    }

    public void setSwInstallmentModel(boolean swInstallmentModel) {
        this.swInstallmentModel = swInstallmentModel;
    }

    public String getEdtAmountSellModel() {
        return edtAmountSellModel;
    }

    public void setEdtAmountSellModel(String edtAmountSellModel) {
        this.edtAmountSellModel = edtAmountSellModel;
    }

    public String getEdtInstallmentTermsModel() {
        return edtInstallmentTermsModel;
    }

    public void setEdtInstallmentTermsModel(String edtInstallmentTermsModel) {
        this.edtInstallmentTermsModel = edtInstallmentTermsModel;
    }

    public String getEdtAmountRentModel() {
        return edtAmountRentModel;
    }

    public void setEdtAmountRentModel(String edtAmountRentModel) {
        this.edtAmountRentModel = edtAmountRentModel;
    }

    public String getEdtAmountRahnModel() {
        return edtAmountRahnModel;
    }

    public void setEdtAmountRahnModel(String edtAmountRahnModel) {
        this.edtAmountRahnModel = edtAmountRahnModel;
    }

    public boolean isTgbChangeableToRentModel() {
        return tgbChangeableToRentModel;
    }

    public void setTgbChangeableToRentModel(boolean tgbChangeableToRentModel) {
        this.tgbChangeableToRentModel = tgbChangeableToRentModel;
    }

    public boolean isTgbChangeableToRahnModel() {
        return tgbChangeableToRahnModel;
    }

    public void setTgbChangeableToRahnModel(boolean tgbChangeableToRahnModel) {
        this.tgbChangeableToRahnModel = tgbChangeableToRahnModel;
    }

    public int getHpNumberOfOwnersModel() {
        return hpNumberOfOwnersModel;
    }

    public void setHpNumberOfOwnersModel(int hpNumberOfOwnersModel) {
        this.hpNumberOfOwnersModel = hpNumberOfOwnersModel;
    }

    public String getEdtOwnerInformationsModel() {
        return edtOwnerInformationsModel;
    }

    public void setEdtOwnerInformationsModel(String edtOwnerInformationsModel) {
        this.edtOwnerInformationsModel = edtOwnerInformationsModel;
    }

    public int getHpDungForSellModel() {
        return hpDungForSellModel;
    }

    public void setHpDungForSellModel(int hpDungForSellModel) {
        this.hpDungForSellModel = hpDungForSellModel;
    }

    public String getEdtSinceQuantityModel() {
        return edtSinceQuantityModel;
    }

    public void setEdtSinceQuantityModel(String edtSinceQuantityModel) {
        this.edtSinceQuantityModel = edtSinceQuantityModel;
    }

    public int getHpMaxAllowedForResidencesModel() {
        return hpMaxAllowedForResidencesModel;
    }

    public void setHpMaxAllowedForResidencesModel(int hpMaxAllowedForResidencesModel) {
        this.hpMaxAllowedForResidencesModel = hpMaxAllowedForResidencesModel;
    }

    public int getHpPercentageOfProgressMadeModel() {
        return hpPercentageOfProgressMadeModel;
    }

    public void setHpPercentageOfProgressMadeModel(int hpPercentageOfProgressMadeModel) {
        this.hpPercentageOfProgressMadeModel = hpPercentageOfProgressMadeModel;
    }

    public String getTxtSelectMelkReceiveTimeModel() {
        return txtSelectMelkReceiveTimeModel;
    }

    public void setTxtSelectMelkReceiveTimeModel(String txtSelectMelkReceiveTimeModel) {
        this.txtSelectMelkReceiveTimeModel = txtSelectMelkReceiveTimeModel;
    }

    public int getHpMelkAgeModel() {
        return hpMelkAgeModel;
    }

    public void setHpMelkAgeModel(int hpMelkAgeModel) {
        this.hpMelkAgeModel = hpMelkAgeModel;
    }

    public int getHpNumberOfBedRoomsModel() {
        return hpNumberOfBedRoomsModel;
    }

    public void setHpNumberOfBedRoomsModel(int hpNumberOfBedRoomsModel) {
        this.hpNumberOfBedRoomsModel = hpNumberOfBedRoomsModel;
    }

    public int getHpFloorNumberModel() {
        return hpFloorNumberModel;
    }

    public void setHpFloorNumberModel(int hpFloorNumberModel) {
        this.hpFloorNumberModel = hpFloorNumberModel;
    }

    public int getHpNumberOfFloorsModel() {
        return hpNumberOfFloorsModel;
    }

    public void setHpNumberOfFloorsModel(int hpNumberOfFloorsModel) {
        this.hpNumberOfFloorsModel = hpNumberOfFloorsModel;
    }

    public int getHpNumberOfUnitInFloorModel() {
        return hpNumberOfUnitInFloorModel;
    }

    public void setHpNumberOfUnitInFloorModel(int hpNumberOfUnitInFloorModel) {
        this.hpNumberOfUnitInFloorModel = hpNumberOfUnitInFloorModel;
    }

    public boolean isSwDateOfQuitModel() {
        return swDateOfQuitModel;
    }

    public void setSwDateOfQuitModel(boolean swDateOfQuitModel) {
        this.swDateOfQuitModel = swDateOfQuitModel;
    }

    public String getTxtDateOfQuitModel() {
        return txtDateOfQuitModel;
    }

    public void setTxtDateOfQuitModel(String txtDateOfQuitModel) {
        this.txtDateOfQuitModel = txtDateOfQuitModel;
    }

    public boolean isSwHasLoanModel() {
        return swHasLoanModel;
    }

    public void setSwHasLoanModel(boolean swHasLoanModel) {
        this.swHasLoanModel = swHasLoanModel;
    }

    public String getEdtAmountLoanModel() {
        return edtAmountLoanModel;
    }

    public void setEdtAmountLoanModel(String edtAmountLoanModel) {
        this.edtAmountLoanModel = edtAmountLoanModel;
    }

    public int getHpNumberOfElevatorModel() {
        return hpNumberOfElevatorModel;
    }

    public void setHpNumberOfElevatorModel(int hpNumberOfElevatorModel) {
        this.hpNumberOfElevatorModel = hpNumberOfElevatorModel;
    }

    public int getHpNumberOfBathRoomModel() {
        return hpNumberOfBathRoomModel;
    }

    public void setHpNumberOfBathRoomModel(int hpNumberOfBathRoomModel) {
        this.hpNumberOfBathRoomModel = hpNumberOfBathRoomModel;
    }

    public int getHpNumberOfParkingModel() {
        return hpNumberOfParkingModel;
    }

    public void setHpNumberOfParkingModel(int hpNumberOfParkingModel) {
        this.hpNumberOfParkingModel = hpNumberOfParkingModel;
    }

    public int getHpNumberOfKitchenModel() {
        return hpNumberOfKitchenModel;
    }

    public void setHpNumberOfKitchenModel(int hpNumberOfKitchenModel) {
        this.hpNumberOfKitchenModel = hpNumberOfKitchenModel;
    }

    public int getHpNumberOfMasterRoomModel() {
        return hpNumberOfMasterRoomModel;
    }

    public void setHpNumberOfMasterRoomModel(int hpNumberOfMasterRoomModel) {
        this.hpNumberOfMasterRoomModel = hpNumberOfMasterRoomModel;
    }

    public int getHpNumberOfIraniToiletModel() {
        return hpNumberOfIraniToiletModel;
    }

    public void setHpNumberOfIraniToiletModel(int hpNumberOfIraniToiletModel) {
        this.hpNumberOfIraniToiletModel = hpNumberOfIraniToiletModel;
    }

    public int getHpNumberOfFarangiToiletModel() {
        return hpNumberOfFarangiToiletModel;
    }

    public void setHpNumberOfFarangiToiletModel(int hpNumberOfFarangiToiletModel) {
        this.hpNumberOfFarangiToiletModel = hpNumberOfFarangiToiletModel;
    }

    public int getHpNumberOfTellSubModel() {
        return hpNumberOfTellSubModel;
    }

    public void setHpNumberOfTellSubModel(int hpNumberOfTellSubModel) {
        this.hpNumberOfTellSubModel = hpNumberOfTellSubModel;
    }

    public String getEdtAmountMountChargeModel() {
        return edtAmountMountChargeModel;
    }

    public void setEdtAmountMountChargeModel(String edtAmountMountChargeModel) {
        this.edtAmountMountChargeModel = edtAmountMountChargeModel;
    }

    public int getHpNumberOfRoofSpaceModel() {
        return hpNumberOfRoofSpaceModel;
    }

    public void setHpNumberOfRoofSpaceModel(int hpNumberOfRoofSpaceModel) {
        this.hpNumberOfRoofSpaceModel = hpNumberOfRoofSpaceModel;
    }

    public int getHpHeightOfTheCeilingModel() {
        return hpHeightOfTheCeilingModel;
    }

    public void setHpHeightOfTheCeilingModel(int hpHeightOfTheCeilingModel) {
        this.hpHeightOfTheCeilingModel = hpHeightOfTheCeilingModel;
    }

    public int getHpMelkWidthModel() {
        return hpMelkWidthModel;
    }

    public void setHpMelkWidthModel(int hpMelkWidthModel) {
        this.hpMelkWidthModel = hpMelkWidthModel;
    }

    public boolean isTgbFlatUnitTypeModel() {
        return tgbFlatUnitTypeModel;
    }

    public void setTgbFlatUnitTypeModel(boolean tgbFlatUnitTypeModel) {
        this.tgbFlatUnitTypeModel = tgbFlatUnitTypeModel;
    }

    public boolean isTgbDoublexUnitTypeModel() {
        return tgbDoublexUnitTypeModel;
    }

    public void setTgbDoublexUnitTypeModel(boolean tgbDoublexUnitTypeModel) {
        this.tgbDoublexUnitTypeModel = tgbDoublexUnitTypeModel;
    }

    public boolean isTgbTriplexUnitTypeModel() {
        return tgbTriplexUnitTypeModel;
    }

    public void setTgbTriplexUnitTypeModel(boolean tgbTriplexUnitTypeModel) {
        this.tgbTriplexUnitTypeModel = tgbTriplexUnitTypeModel;
    }

    public boolean isTgbBeachMelkPositionsModel() {
        return tgbBeachMelkPositionsModel;
    }

    public void setTgbBeachMelkPositionsModel(boolean tgbBeachMelkPositionsModel) {
        this.tgbBeachMelkPositionsModel = tgbBeachMelkPositionsModel;
    }

    public boolean isTgbJangleMelkPositionsModel() {
        return tgbJangleMelkPositionsModel;
    }

    public void setTgbJangleMelkPositionsModel(boolean tgbJangleMelkPositionsModel) {
        this.tgbJangleMelkPositionsModel = tgbJangleMelkPositionsModel;
    }

    public boolean isTgbMountainMelkPositionsModel() {
        return tgbMountainMelkPositionsModel;
    }

    public void setTgbMountainMelkPositionsModel(boolean tgbMountainMelkPositionsModel) {
        this.tgbMountainMelkPositionsModel = tgbMountainMelkPositionsModel;
    }

    public boolean isTgbTownshipMelkPositionsModel() {
        return tgbTownshipMelkPositionsModel;
    }

    public void setTgbTownshipMelkPositionsModel(boolean tgbTownshipMelkPositionsModel) {
        this.tgbTownshipMelkPositionsModel = tgbTownshipMelkPositionsModel;
    }

    public boolean isTgbPatioPossibilitiesModel() {
        return tgbPatioPossibilitiesModel;
    }

    public void setTgbPatioPossibilitiesModel(boolean tgbPatioPossibilitiesModel) {
        this.tgbPatioPossibilitiesModel = tgbPatioPossibilitiesModel;
    }

    public boolean isTgbWaterWellPossibilitiesModel() {
        return tgbWaterWellPossibilitiesModel;
    }

    public void setTgbWaterWellPossibilitiesModel(boolean tgbWaterWellPossibilitiesModel) {
        this.tgbWaterWellPossibilitiesModel = tgbWaterWellPossibilitiesModel;
    }

    public boolean isTgbBalconyPossibilitiesModel() {
        return tgbBalconyPossibilitiesModel;
    }

    public void setTgbBalconyPossibilitiesModel(boolean tgbBalconyPossibilitiesModel) {
        this.tgbBalconyPossibilitiesModel = tgbBalconyPossibilitiesModel;
    }

    public boolean isTgbVideoIphonePossibilitiesModel() {
        return tgbVideoIphonePossibilitiesModel;
    }

    public void setTgbVideoIphonePossibilitiesModel(boolean tgbVideoIphonePossibilitiesModel) {
        this.tgbVideoIphonePossibilitiesModel = tgbVideoIphonePossibilitiesModel;
    }

    public boolean isTgbWallClosetPossibilitiesModel() {
        return tgbWallClosetPossibilitiesModel;
    }

    public void setTgbWallClosetPossibilitiesModel(boolean tgbWallClosetPossibilitiesModel) {
        this.tgbWallClosetPossibilitiesModel = tgbWallClosetPossibilitiesModel;
    }

    public boolean isTgbStorePossibilitiesModel() {
        return tgbStorePossibilitiesModel;
    }

    public void setTgbStorePossibilitiesModel(boolean tgbStorePossibilitiesModel) {
        this.tgbStorePossibilitiesModel = tgbStorePossibilitiesModel;
    }

    public boolean isTgbYardPossibilitiesModel() {
        return tgbYardPossibilitiesModel;
    }

    public void setTgbYardPossibilitiesModel(boolean tgbYardPossibilitiesModel) {
        this.tgbYardPossibilitiesModel = tgbYardPossibilitiesModel;
    }

    public boolean isTgbJantorPossibilitiesModel() {
        return tgbJantorPossibilitiesModel;
    }

    public void setTgbJantorPossibilitiesModel(boolean tgbJantorPossibilitiesModel) {
        this.tgbJantorPossibilitiesModel = tgbJantorPossibilitiesModel;
    }

    public boolean isTgbRebuildPossibilitiesModel() {
        return tgbRebuildPossibilitiesModel;
    }

    public void setTgbRebuildPossibilitiesModel(boolean tgbRebuildPossibilitiesModel) {
        this.tgbRebuildPossibilitiesModel = tgbRebuildPossibilitiesModel;
    }

    public boolean isTgbSofaPossibilitiesModel() {
        return tgbSofaPossibilitiesModel;
    }

    public void setTgbSofaPossibilitiesModel(boolean tgbSofaPossibilitiesModel) {
        this.tgbSofaPossibilitiesModel = tgbSofaPossibilitiesModel;
    }

    public boolean isTgbCameraPossibilitiesModel() {
        return tgbCameraPossibilitiesModel;
    }

    public void setTgbCameraPossibilitiesModel(boolean tgbCameraPossibilitiesModel) {
        this.tgbCameraPossibilitiesModel = tgbCameraPossibilitiesModel;
    }

    public boolean isTgbCentralAntennaPossibilitiesModel() {
        return tgbCentralAntennaPossibilitiesModel;
    }

    public void setTgbCentralAntennaPossibilitiesModel(boolean tgbCentralAntennaPossibilitiesModel) {
        this.tgbCentralAntennaPossibilitiesModel = tgbCentralAntennaPossibilitiesModel;
    }

    public boolean isTgbChangeablePossibilitiesModel() {
        return tgbChangeablePossibilitiesModel;
    }

    public void setTgbChangeablePossibilitiesModel(boolean tgbChangeablePossibilitiesModel) {
        this.tgbChangeablePossibilitiesModel = tgbChangeablePossibilitiesModel;
    }

    public boolean isTgbLobbySpecialFeaturesModel() {
        return tgbLobbySpecialFeaturesModel;
    }

    public void setTgbLobbySpecialFeaturesModel(boolean tgbLobbySpecialFeaturesModel) {
        this.tgbLobbySpecialFeaturesModel = tgbLobbySpecialFeaturesModel;
    }

    public boolean isTgbBathtubSpecialFeaturesModel() {
        return tgbBathtubSpecialFeaturesModel;
    }

    public void setTgbBathtubSpecialFeaturesModel(boolean tgbBathtubSpecialFeaturesModel) {
        this.tgbBathtubSpecialFeaturesModel = tgbBathtubSpecialFeaturesModel;
    }

    public boolean isTgbSwimmingPoolSpecialFeaturesModel() {
        return tgbSwimmingPoolSpecialFeaturesModel;
    }

    public void setTgbSwimmingPoolSpecialFeaturesModel(boolean tgbSwimmingPoolSpecialFeaturesModel) {
        this.tgbSwimmingPoolSpecialFeaturesModel = tgbSwimmingPoolSpecialFeaturesModel;
    }

    public boolean isTgbFirePlaceSpecialFeaturesModel() {
        return tgbFirePlaceSpecialFeaturesModel;
    }

    public void setTgbFirePlaceSpecialFeaturesModel(boolean tgbFirePlaceSpecialFeaturesModel) {
        this.tgbFirePlaceSpecialFeaturesModel = tgbFirePlaceSpecialFeaturesModel;
    }

    public boolean isTgbChildrenPlaySpaceSpecialFeaturesModel() {
        return tgbChildrenPlaySpaceSpecialFeaturesModel;
    }

    public void setTgbChildrenPlaySpaceSpecialFeaturesModel(boolean tgbChildrenPlaySpaceSpecialFeaturesModel) {
        this.tgbChildrenPlaySpaceSpecialFeaturesModel = tgbChildrenPlaySpaceSpecialFeaturesModel;
    }

    public boolean isTgbGardenYardSpecialFeaturesModel() {
        return tgbGardenYardSpecialFeaturesModel;
    }

    public void setTgbGardenYardSpecialFeaturesModel(boolean tgbGardenYardSpecialFeaturesModel) {
        this.tgbGardenYardSpecialFeaturesModel = tgbGardenYardSpecialFeaturesModel;
    }

    public boolean isTgbCentralVacuumCleanerSpecialFeaturesModel() {
        return tgbCentralVacuumCleanerSpecialFeaturesModel;
    }

    public void setTgbCentralVacuumCleanerSpecialFeaturesModel(boolean tgbCentralVacuumCleanerSpecialFeaturesModel) {
        this.tgbCentralVacuumCleanerSpecialFeaturesModel = tgbCentralVacuumCleanerSpecialFeaturesModel;
    }

    public boolean isTgbAmphitheaterSpecialFeaturesModel() {
        return tgbAmphitheaterSpecialFeaturesModel;
    }

    public void setTgbAmphitheaterSpecialFeaturesModel(boolean tgbAmphitheaterSpecialFeaturesModel) {
        this.tgbAmphitheaterSpecialFeaturesModel = tgbAmphitheaterSpecialFeaturesModel;
    }

    public boolean isTgbConferenceHallSpecialFeaturesModel() {
        return tgbConferenceHallSpecialFeaturesModel;
    }

    public void setTgbConferenceHallSpecialFeaturesModel(boolean tgbConferenceHallSpecialFeaturesModel) {
        this.tgbConferenceHallSpecialFeaturesModel = tgbConferenceHallSpecialFeaturesModel;
    }

    public boolean isTgbFirefightSpecialFeaturesModel() {
        return tgbFirefightSpecialFeaturesModel;
    }

    public void setTgbFirefightSpecialFeaturesModel(boolean tgbFirefightSpecialFeaturesModel) {
        this.tgbFirefightSpecialFeaturesModel = tgbFirefightSpecialFeaturesModel;
    }

    public boolean isTgbSolarBatterySpecialFeaturesModel() {
        return tgbSolarBatterySpecialFeaturesModel;
    }

    public void setTgbSolarBatterySpecialFeaturesModel(boolean tgbSolarBatterySpecialFeaturesModel) {
        this.tgbSolarBatterySpecialFeaturesModel = tgbSolarBatterySpecialFeaturesModel;
    }

    public boolean isTgbFountainSpecialFeaturesModel() {
        return tgbFountainSpecialFeaturesModel;
    }

    public void setTgbFountainSpecialFeaturesModel(boolean tgbFountainSpecialFeaturesModel) {
        this.tgbFountainSpecialFeaturesModel = tgbFountainSpecialFeaturesModel;
    }

    public boolean isTgbCargoElevatorSpecialFeaturesModel() {
        return tgbCargoElevatorSpecialFeaturesModel;
    }

    public void setTgbCargoElevatorSpecialFeaturesModel(boolean tgbCargoElevatorSpecialFeaturesModel) {
        this.tgbCargoElevatorSpecialFeaturesModel = tgbCargoElevatorSpecialFeaturesModel;
    }

    public boolean isTgbWaterSupplySpecialFeaturesModel() {
        return tgbWaterSupplySpecialFeaturesModel;
    }

    public void setTgbWaterSupplySpecialFeaturesModel(boolean tgbWaterSupplySpecialFeaturesModel) {
        this.tgbWaterSupplySpecialFeaturesModel = tgbWaterSupplySpecialFeaturesModel;
    }

    public boolean isTgbTennisCourtFeaturesModel() {
        return tgbTennisCourtFeaturesModel;
    }

    public void setTgbTennisCourtFeaturesModel(boolean tgbTennisCourtFeaturesModel) {
        this.tgbTennisCourtFeaturesModel = tgbTennisCourtFeaturesModel;
    }

    public boolean isTgbGuestParkingSpecialFeaturesModel() {
        return tgbGuestParkingSpecialFeaturesModel;
    }

    public void setTgbGuestParkingSpecialFeaturesModel(boolean tgbGuestParkingSpecialFeaturesModel) {
        this.tgbGuestParkingSpecialFeaturesModel = tgbGuestParkingSpecialFeaturesModel;
    }

    public boolean isTgbSaunaSpecialFeaturesModel() {
        return tgbSaunaSpecialFeaturesModel;
    }

    public void setTgbSaunaSpecialFeaturesModel(boolean tgbSaunaSpecialFeaturesModel) {
        this.tgbSaunaSpecialFeaturesModel = tgbSaunaSpecialFeaturesModel;
    }

    public boolean isTgbJacuzziSpecialFeaturesModel() {
        return tgbJacuzziSpecialFeaturesModel;
    }

    public void setTgbJacuzziSpecialFeaturesModel(boolean tgbJacuzziSpecialFeaturesModel) {
        this.tgbJacuzziSpecialFeaturesModel = tgbJacuzziSpecialFeaturesModel;
    }

    public boolean isTgbChildrenPoolSpecialFeaturesModel() {
        return tgbChildrenPoolSpecialFeaturesModel;
    }

    public void setTgbChildrenPoolSpecialFeaturesModel(boolean tgbChildrenPoolSpecialFeaturesModel) {
        this.tgbChildrenPoolSpecialFeaturesModel = tgbChildrenPoolSpecialFeaturesModel;
    }

    public boolean isTgbRoofGardenSpecialFeaturesModel() {
        return tgbRoofGardenSpecialFeaturesModel;
    }

    public void setTgbRoofGardenSpecialFeaturesModel(boolean tgbRoofGardenSpecialFeaturesModel) {
        this.tgbRoofGardenSpecialFeaturesModel = tgbRoofGardenSpecialFeaturesModel;
    }

    public boolean isTgbBarbecueSpecialFeaturesModel() {
        return tgbBarbecueSpecialFeaturesModel;
    }

    public void setTgbBarbecueSpecialFeaturesModel(boolean tgbBarbecueSpecialFeaturesModel) {
        this.tgbBarbecueSpecialFeaturesModel = tgbBarbecueSpecialFeaturesModel;
    }

    public boolean isTgbShootingWasteSpecialFeaturesModel() {
        return tgbShootingWasteSpecialFeaturesModel;
    }

    public void setTgbShootingWasteSpecialFeaturesModel(boolean tgbShootingWasteSpecialFeaturesModel) {
        this.tgbShootingWasteSpecialFeaturesModel = tgbShootingWasteSpecialFeaturesModel;
    }

    public boolean isTgbAltarSpecialFeaturesModel() {
        return tgbAltarSpecialFeaturesModel;
    }

    public void setTgbAltarSpecialFeaturesModel(boolean tgbAltarSpecialFeaturesModel) {
        this.tgbAltarSpecialFeaturesModel = tgbAltarSpecialFeaturesModel;
    }

    public boolean isTgbSecuritySystemSpecialFeaturesModel() {
        return tgbSecuritySystemSpecialFeaturesModel;
    }

    public void setTgbSecuritySystemSpecialFeaturesModel(boolean tgbSecuritySystemSpecialFeaturesModel) {
        this.tgbSecuritySystemSpecialFeaturesModel = tgbSecuritySystemSpecialFeaturesModel;
    }

    public boolean isTgbSmartHomeSpecialFeaturesModel() {
        return tgbSmartHomeSpecialFeaturesModel;
    }

    public void setTgbSmartHomeSpecialFeaturesModel(boolean tgbSmartHomeSpecialFeaturesModel) {
        this.tgbSmartHomeSpecialFeaturesModel = tgbSmartHomeSpecialFeaturesModel;
    }

    public boolean isTgbSafeguardSpecialFeaturesModel() {
        return tgbSafeguardSpecialFeaturesModel;
    }

    public void setTgbSafeguardSpecialFeaturesModel(boolean tgbSafeguardSpecialFeaturesModel) {
        this.tgbSafeguardSpecialFeaturesModel = tgbSafeguardSpecialFeaturesModel;
    }

    public boolean isTgbEmergencyPowerSpecialFeaturesModel() {
        return tgbEmergencyPowerSpecialFeaturesModel;
    }

    public void setTgbEmergencyPowerSpecialFeaturesModel(boolean tgbEmergencyPowerSpecialFeaturesModel) {
        this.tgbEmergencyPowerSpecialFeaturesModel = tgbEmergencyPowerSpecialFeaturesModel;
    }

    public boolean isTgbCaretakersRoomSpecialFeaturesModel() {
        return tgbCaretakersRoomSpecialFeaturesModel;
    }

    public void setTgbCaretakersRoomSpecialFeaturesModel(boolean tgbCaretakersRoomSpecialFeaturesModel) {
        this.tgbCaretakersRoomSpecialFeaturesModel = tgbCaretakersRoomSpecialFeaturesModel;
    }

    public boolean isTgbSecurityDoorSpecialFeaturesModel() {
        return tgbSecurityDoorSpecialFeaturesModel;
    }

    public void setTgbSecurityDoorSpecialFeaturesModel(boolean tgbSecurityDoorSpecialFeaturesModel) {
        this.tgbSecurityDoorSpecialFeaturesModel = tgbSecurityDoorSpecialFeaturesModel;
    }

    public boolean isTgbWaterPurifierSpecialFeaturesModel() {
        return tgbWaterPurifierSpecialFeaturesModel;
    }

    public void setTgbWaterPurifierSpecialFeaturesModel(boolean tgbWaterPurifierSpecialFeaturesModel) {
        this.tgbWaterPurifierSpecialFeaturesModel = tgbWaterPurifierSpecialFeaturesModel;
    }

    public boolean isTgbParkingRemoteSpecialFeaturesModel() {
        return tgbParkingRemoteSpecialFeaturesModel;
    }

    public void setTgbParkingRemoteSpecialFeaturesModel(boolean tgbParkingRemoteSpecialFeaturesModel) {
        this.tgbParkingRemoteSpecialFeaturesModel = tgbParkingRemoteSpecialFeaturesModel;
    }

    public boolean isTgbPoolTableSpecialFeaturesModel() {
        return tgbPoolTableSpecialFeaturesModel;
    }

    public void setTgbPoolTableSpecialFeaturesModel(boolean tgbPoolTableSpecialFeaturesModel) {
        this.tgbPoolTableSpecialFeaturesModel = tgbPoolTableSpecialFeaturesModel;
    }

    public boolean isTgbWestGeoPositionModel() {
        return tgbWestGeoPositionModel;
    }

    public void setTgbWestGeoPositionModel(boolean tgbWestGeoPositionModel) {
        this.tgbWestGeoPositionModel = tgbWestGeoPositionModel;
    }

    public boolean isTgbEstGeoPositionModel() {
        return tgbEstGeoPositionModel;
    }

    public void setTgbEstGeoPositionModel(boolean tgbEstGeoPositionModel) {
        this.tgbEstGeoPositionModel = tgbEstGeoPositionModel;
    }

    public boolean isTgbSouthGeoPositionModel() {
        return tgbSouthGeoPositionModel;
    }

    public void setTgbSouthGeoPositionModel(boolean tgbSouthGeoPositionModel) {
        this.tgbSouthGeoPositionModel = tgbSouthGeoPositionModel;
    }

    public boolean isTgbNorthGeoPositionModel() {
        return tgbNorthGeoPositionModel;
    }

    public void setTgbNorthGeoPositionModel(boolean tgbNorthGeoPositionModel) {
        this.tgbNorthGeoPositionModel = tgbNorthGeoPositionModel;
    }

    public boolean isTgbBlotsButsStructTypeModel() {
        return tgbBlotsButsStructTypeModel;
    }

    public void setTgbBlotsButsStructTypeModel(boolean tgbBlotsButsStructTypeModel) {
        this.tgbBlotsButsStructTypeModel = tgbBlotsButsStructTypeModel;
    }

    public boolean isTgbMetalStructTypeModel() {
        return tgbMetalStructTypeModel;
    }

    public void setTgbMetalStructTypeModel(boolean tgbMetalStructTypeModel) {
        this.tgbMetalStructTypeModel = tgbMetalStructTypeModel;
    }

    public boolean isTgbConcreteAndBarStructTypeModel() {
        return tgbConcreteAndBarStructTypeModel;
    }

    public void setTgbConcreteAndBarStructTypeModel(boolean tgbConcreteAndBarStructTypeModel) {
        this.tgbConcreteAndBarStructTypeModel = tgbConcreteAndBarStructTypeModel;
    }

    public boolean isTgbWestLightingDirectModel() {
        return tgbWestLightingDirectModel;
    }

    public void setTgbWestLightingDirectModel(boolean tgbWestLightingDirectModel) {
        this.tgbWestLightingDirectModel = tgbWestLightingDirectModel;
    }

    public boolean isTgbEstLightingDirectModel() {
        return tgbEstLightingDirectModel;
    }

    public void setTgbEstLightingDirectModel(boolean tgbEstLightingDirectModel) {
        this.tgbEstLightingDirectModel = tgbEstLightingDirectModel;
    }

    public boolean isTgbSouthtLightingDirectModel() {
        return tgbSouthtLightingDirectModel;
    }

    public void setTgbSouthtLightingDirectModel(boolean tgbSouthtLightingDirectModel) {
        this.tgbSouthtLightingDirectModel = tgbSouthtLightingDirectModel;
    }

    public boolean isTgbNorthLightingDirectModel() {
        return tgbNorthLightingDirectModel;
    }

    public void setTgbNorthLightingDirectModel(boolean tgbNorthLightingDirectModel) {
        this.tgbNorthLightingDirectModel = tgbNorthLightingDirectModel;
    }

    public boolean isTgbGoodwillModel() {
        return tgbGoodwillModel;
    }

    public void setTgbGoodwillModel(boolean tgbGoodwillModel) {
        this.tgbGoodwillModel = tgbGoodwillModel;
    }

    public boolean isTgbPropertyModel() {
        return tgbPropertyModel;
    }

    public void setTgbPropertyModel(boolean tgbPropertyModel) {
        this.tgbPropertyModel = tgbPropertyModel;
    }

    public boolean isTgbThreePhaseElectricModel() {
        return tgbThreePhaseElectricModel;
    }

    public void setTgbThreePhaseElectricModel(boolean tgbThreePhaseElectricModel) {
        this.tgbThreePhaseElectricModel = tgbThreePhaseElectricModel;
    }

    public boolean isTgbOnePhaseElectricModel() {
        return tgbOnePhaseElectricModel;
    }

    public void setTgbOnePhaseElectricModel(boolean tgbOnePhaseElectricModel) {
        this.tgbOnePhaseElectricModel = tgbOnePhaseElectricModel;
    }

    public boolean isTgbShareElectricModel() {
        return tgbShareElectricModel;
    }

    public void setTgbShareElectricModel(boolean tgbShareElectricModel) {
        this.tgbShareElectricModel = tgbShareElectricModel;
    }

    public boolean isTgbPrivateElectricModel() {
        return tgbPrivateElectricModel;
    }

    public void setTgbPrivateElectricModel(boolean tgbPrivateElectricModel) {
        this.tgbPrivateElectricModel = tgbPrivateElectricModel;
    }

    public boolean isTgbShareGasMeterModel() {
        return tgbShareGasMeterModel;
    }

    public void setTgbShareGasMeterModel(boolean tgbShareGasMeterModel) {
        this.tgbShareGasMeterModel = tgbShareGasMeterModel;
    }

    public boolean isTgbPrivateGasMeterModel() {
        return tgbPrivateGasMeterModel;
    }

    public void setTgbPrivateGasMeterModel(boolean tgbPrivateGasMeterModel) {
        this.tgbPrivateGasMeterModel = tgbPrivateGasMeterModel;
    }

    public boolean isTgbShareWaterMeterModel() {
        return tgbShareWaterMeterModel;
    }

    public void setTgbShareWaterMeterModel(boolean tgbShareWaterMeterModel) {
        this.tgbShareWaterMeterModel = tgbShareWaterMeterModel;
    }

    public boolean isTgbPrivateWaterMeterModel() {
        return tgbPrivateWaterMeterModel;
    }

    public void setTgbPrivateWaterMeterModel(boolean tgbPrivateWaterMeterModel) {
        this.tgbPrivateWaterMeterModel = tgbPrivateWaterMeterModel;
    }

    public boolean isTgbPersonalTypeOfMelkDocumentModel() {
        return tgbPersonalTypeOfMelkDocumentModel;
    }

    public void setTgbPersonalTypeOfMelkDocumentModel(boolean tgbPersonalTypeOfMelkDocumentModel) {
        this.tgbPersonalTypeOfMelkDocumentModel = tgbPersonalTypeOfMelkDocumentModel;
    }

    public boolean isTgbEndowmentsTypeOfMelkDocumentModel() {
        return tgbEndowmentsTypeOfMelkDocumentModel;
    }

    public void setTgbEndowmentsTypeOfMelkDocumentModel(boolean tgbEndowmentsTypeOfMelkDocumentModel) {
        this.tgbEndowmentsTypeOfMelkDocumentModel = tgbEndowmentsTypeOfMelkDocumentModel;
    }

    public boolean isTgbCommercialTypeOfMelkDocumentModel() {
        return tgbCommercialTypeOfMelkDocumentModel;
    }

    public void setTgbCommercialTypeOfMelkDocumentModel(boolean tgbCommercialTypeOfMelkDocumentModel) {
        this.tgbCommercialTypeOfMelkDocumentModel = tgbCommercialTypeOfMelkDocumentModel;
    }

    public boolean isTgbShariRulerTypeOfMelkDocumentModel() {
        return tgbShariRulerTypeOfMelkDocumentModel;
    }

    public void setTgbShariRulerTypeOfMelkDocumentModel(boolean tgbShariRulerTypeOfMelkDocumentModel) {
        this.tgbShariRulerTypeOfMelkDocumentModel = tgbShariRulerTypeOfMelkDocumentModel;
    }

    public boolean isTgbOrganizationalTypeOfMelkDocumentModel() {
        return tgbOrganizationalTypeOfMelkDocumentModel;
    }

    public void setTgbOrganizationalTypeOfMelkDocumentModel(boolean tgbOrganizationalTypeOfMelkDocumentModel) {
        this.tgbOrganizationalTypeOfMelkDocumentModel = tgbOrganizationalTypeOfMelkDocumentModel;
    }

    public boolean isTgbOfficalTypeOfMelkDocumentModel() {
        return tgbOfficalTypeOfMelkDocumentModel;
    }

    public void setTgbOfficalTypeOfMelkDocumentModel(boolean tgbOfficalTypeOfMelkDocumentModel) {
        this.tgbOfficalTypeOfMelkDocumentModel = tgbOfficalTypeOfMelkDocumentModel;
    }

    public boolean isTgbCooperativeTypeOfMelkDocumentModel() {
        return tgbCooperativeTypeOfMelkDocumentModel;
    }

    public void setTgbCooperativeTypeOfMelkDocumentModel(boolean tgbCooperativeTypeOfMelkDocumentModel) {
        this.tgbCooperativeTypeOfMelkDocumentModel = tgbCooperativeTypeOfMelkDocumentModel;
    }

    public boolean isTgbProxyTypeOfMelkDocumentModel() {
        return tgbProxyTypeOfMelkDocumentModel;
    }

    public void setTgbProxyTypeOfMelkDocumentModel(boolean tgbProxyTypeOfMelkDocumentModel) {
        this.tgbProxyTypeOfMelkDocumentModel = tgbProxyTypeOfMelkDocumentModel;
    }

    public boolean isTgbLetterOfCreditTypeOfMelkDocumentModel() {
        return tgbLetterOfCreditTypeOfMelkDocumentModel;
    }

    public void setTgbLetterOfCreditTypeOfMelkDocumentModel(boolean tgbLetterOfCreditTypeOfMelkDocumentModel) {
        this.tgbLetterOfCreditTypeOfMelkDocumentModel = tgbLetterOfCreditTypeOfMelkDocumentModel;
    }

    public boolean isTgbJointlyTypeOfMelkDocumentModel() {
        return tgbJointlyTypeOfMelkDocumentModel;
    }

    public void setTgbJointlyTypeOfMelkDocumentModel(boolean tgbJointlyTypeOfMelkDocumentModel) {
        this.tgbJointlyTypeOfMelkDocumentModel = tgbJointlyTypeOfMelkDocumentModel;
    }

    public boolean isTgbResidentialTypeOfMelkDocumentModel() {
        return tgbResidentialTypeOfMelkDocumentModel;
    }

    public void setTgbResidentialTypeOfMelkDocumentModel(boolean tgbResidentialTypeOfMelkDocumentModel) {
        this.tgbResidentialTypeOfMelkDocumentModel = tgbResidentialTypeOfMelkDocumentModel;
    }

    public boolean isTgbIndustrialTypeOfMelkDocumentModel() {
        return tgbIndustrialTypeOfMelkDocumentModel;
    }

    public void setTgbIndustrialTypeOfMelkDocumentModel(boolean tgbIndustrialTypeOfMelkDocumentModel) {
        this.tgbIndustrialTypeOfMelkDocumentModel = tgbIndustrialTypeOfMelkDocumentModel;
    }

    public boolean isTgbPackageCoolingHealingSystemModel() {
        return tgbPackageCoolingHealingSystemModel;
    }

    public void setTgbPackageCoolingHealingSystemModel(boolean tgbPackageCoolingHealingSystemModel) {
        this.tgbPackageCoolingHealingSystemModel = tgbPackageCoolingHealingSystemModel;
    }

    public boolean isTgbHeaterCoolingHealingSystemModel() {
        return tgbHeaterCoolingHealingSystemModel;
    }

    public void setTgbHeaterCoolingHealingSystemModel(boolean tgbHeaterCoolingHealingSystemModel) {
        this.tgbHeaterCoolingHealingSystemModel = tgbHeaterCoolingHealingSystemModel;
    }

    public boolean isTgbChilerCoolingHealingSystemModel() {
        return tgbChilerCoolingHealingSystemModel;
    }

    public void setTgbChilerCoolingHealingSystemModel(boolean tgbChilerCoolingHealingSystemModel) {
        this.tgbChilerCoolingHealingSystemModel = tgbChilerCoolingHealingSystemModel;
    }

    public boolean isTgbWaterCoolerCoolingHealingSystemModel() {
        return tgbWaterCoolerCoolingHealingSystemModel;
    }

    public void setTgbWaterCoolerCoolingHealingSystemModel(boolean tgbWaterCoolerCoolingHealingSystemModel) {
        this.tgbWaterCoolerCoolingHealingSystemModel = tgbWaterCoolerCoolingHealingSystemModel;
    }

    public boolean isTgbFanCoilCoolingHealingSystemModel() {
        return tgbFanCoilCoolingHealingSystemModel;
    }

    public void setTgbFanCoilCoolingHealingSystemModel(boolean tgbFanCoilCoolingHealingSystemModel) {
        this.tgbFanCoilCoolingHealingSystemModel = tgbFanCoilCoolingHealingSystemModel;
    }

    public boolean isTgbCentralEngineRoomCoolingHealingSystemModel() {
        return tgbCentralEngineRoomCoolingHealingSystemModel;
    }

    public void setTgbCentralEngineRoomCoolingHealingSystemModel(boolean tgbCentralEngineRoomCoolingHealingSystemModel) {
        this.tgbCentralEngineRoomCoolingHealingSystemModel = tgbCentralEngineRoomCoolingHealingSystemModel;
    }

    public boolean isTgbFloorHeatingCoolingHealingSystemModel() {
        return tgbFloorHeatingCoolingHealingSystemModel;
    }

    public void setTgbFloorHeatingCoolingHealingSystemModel(boolean tgbFloorHeatingCoolingHealingSystemModel) {
        this.tgbFloorHeatingCoolingHealingSystemModel = tgbFloorHeatingCoolingHealingSystemModel;
    }

    public boolean isTgbAirConditionerCoolingHealingSystemModel() {
        return tgbAirConditionerCoolingHealingSystemModel;
    }

    public void setTgbAirConditionerCoolingHealingSystemModel(boolean tgbAirConditionerCoolingHealingSystemModel) {
        this.tgbAirConditionerCoolingHealingSystemModel = tgbAirConditionerCoolingHealingSystemModel;
    }

    public boolean isTgbGasCoolerCoolingHealingSystemModel() {
        return tgbGasCoolerCoolingHealingSystemModel;
    }

    public void setTgbGasCoolerCoolingHealingSystemModel(boolean tgbGasCoolerCoolingHealingSystemModel) {
        this.tgbGasCoolerCoolingHealingSystemModel = tgbGasCoolerCoolingHealingSystemModel;
    }

    public boolean isTgbStoneFloorCoveringModel() {
        return tgbStoneFloorCoveringModel;
    }

    public void setTgbStoneFloorCoveringModel(boolean tgbStoneFloorCoveringModel) {
        this.tgbStoneFloorCoveringModel = tgbStoneFloorCoveringModel;
    }

    public boolean isTgbCarpetFloorCoveringModel() {
        return tgbCarpetFloorCoveringModel;
    }

    public void setTgbCarpetFloorCoveringModel(boolean tgbCarpetFloorCoveringModel) {
        this.tgbCarpetFloorCoveringModel = tgbCarpetFloorCoveringModel;
    }

    public boolean isTgbParquetFloorCoveringModel() {
        return tgbParquetFloorCoveringModel;
    }

    public void setTgbParquetFloorCoveringModel(boolean tgbParquetFloorCoveringModel) {
        this.tgbParquetFloorCoveringModel = tgbParquetFloorCoveringModel;
    }

    public boolean isTgbMosaicFloorCoveringModel() {
        return tgbMosaicFloorCoveringModel;
    }

    public void setTgbMosaicFloorCoveringModel(boolean tgbMosaicFloorCoveringModel) {
        this.tgbMosaicFloorCoveringModel = tgbMosaicFloorCoveringModel;
    }

    public boolean isTgbAsphaltFloorCoveringModel() {
        return tgbAsphaltFloorCoveringModel;
    }

    public void setTgbAsphaltFloorCoveringModel(boolean tgbAsphaltFloorCoveringModel) {
        this.tgbAsphaltFloorCoveringModel = tgbAsphaltFloorCoveringModel;
    }

    public boolean isTgbCeramicFloorCoveringModel() {
        return tgbCeramicFloorCoveringModel;
    }

    public void setTgbCeramicFloorCoveringModel(boolean tgbCeramicFloorCoveringModel) {
        this.tgbCeramicFloorCoveringModel = tgbCeramicFloorCoveringModel;
    }

    public boolean isTgbLaminatFloorCoveringModel() {
        return tgbLaminatFloorCoveringModel;
    }

    public void setTgbLaminatFloorCoveringModel(boolean tgbLaminatFloorCoveringModel) {
        this.tgbLaminatFloorCoveringModel = tgbLaminatFloorCoveringModel;
    }

    public boolean isTgbWoodFloorCoveringModel() {
        return tgbWoodFloorCoveringModel;
    }

    public void setTgbWoodFloorCoveringModel(boolean tgbWoodFloorCoveringModel) {
        this.tgbWoodFloorCoveringModel = tgbWoodFloorCoveringModel;
    }

    public boolean isTgbGraniteFloorCoveringModel() {
        return tgbGraniteFloorCoveringModel;
    }

    public void setTgbGraniteFloorCoveringModel(boolean tgbGraniteFloorCoveringModel) {
        this.tgbGraniteFloorCoveringModel = tgbGraniteFloorCoveringModel;
    }

    public boolean isTgbCementFloorCoveringModel() {
        return tgbCementFloorCoveringModel;
    }

    public void setTgbCementFloorCoveringModel(boolean tgbCementFloorCoveringModel) {
        this.tgbCementFloorCoveringModel = tgbCementFloorCoveringModel;
    }

    public boolean isTgbKonteksBuildingFacadesModel() {
        return tgbKonteksBuildingFacadesModel;
    }

    public void setTgbKonteksBuildingFacadesModel(boolean tgbKonteksBuildingFacadesModel) {
        this.tgbKonteksBuildingFacadesModel = tgbKonteksBuildingFacadesModel;
    }

    public boolean isTgbAluminumBuildingFacadesModel() {
        return tgbAluminumBuildingFacadesModel;
    }

    public void setTgbAluminumBuildingFacadesModel(boolean tgbAluminumBuildingFacadesModel) {
        this.tgbAluminumBuildingFacadesModel = tgbAluminumBuildingFacadesModel;
    }

    public boolean isTgbBrickBuildingFacadesModel() {
        return tgbBrickBuildingFacadesModel;
    }

    public void setTgbBrickBuildingFacadesModel(boolean tgbBrickBuildingFacadesModel) {
        this.tgbBrickBuildingFacadesModel = tgbBrickBuildingFacadesModel;
    }

    public boolean isTgbCementBuildingFacadesModel() {
        return tgbCementBuildingFacadesModel;
    }

    public void setTgbCementBuildingFacadesModel(boolean tgbCementBuildingFacadesModel) {
        this.tgbCementBuildingFacadesModel = tgbCementBuildingFacadesModel;
    }

    public boolean isTgbWoodBuildingFacadesModel() {
        return tgbWoodBuildingFacadesModel;
    }

    public void setTgbWoodBuildingFacadesModel(boolean tgbWoodBuildingFacadesModel) {
        this.tgbWoodBuildingFacadesModel = tgbWoodBuildingFacadesModel;
    }

    public boolean isTgbStoneBuildingFacadesModel() {
        return tgbStoneBuildingFacadesModel;
    }

    public void setTgbStoneBuildingFacadesModel(boolean tgbStoneBuildingFacadesModel) {
        this.tgbStoneBuildingFacadesModel = tgbStoneBuildingFacadesModel;
    }

    public boolean isTgbCeramicBuildingFacadesModel() {
        return tgbCeramicBuildingFacadesModel;
    }

    public void setTgbCeramicBuildingFacadesModel(boolean tgbCeramicBuildingFacadesModel) {
        this.tgbCeramicBuildingFacadesModel = tgbCeramicBuildingFacadesModel;
    }

    public boolean isTgbGlassBuildingFacadesModel() {
        return tgbGlassBuildingFacadesModel;
    }

    public void setTgbGlassBuildingFacadesModel(boolean tgbGlassBuildingFacadesModel) {
        this.tgbGlassBuildingFacadesModel = tgbGlassBuildingFacadesModel;
    }

    public boolean isTgbCompositeBuildingFacadesModel() {
        return tgbCompositeBuildingFacadesModel;
    }

    public void setTgbCompositeBuildingFacadesModel(boolean tgbCompositeBuildingFacadesModel) {
        this.tgbCompositeBuildingFacadesModel = tgbCompositeBuildingFacadesModel;
    }

    public boolean isTgbHiGlassKitchenCabinetsModel() {
        return tgbHiGlassKitchenCabinetsModel;
    }

    public void setTgbHiGlassKitchenCabinetsModel(boolean tgbHiGlassKitchenCabinetsModel) {
        this.tgbHiGlassKitchenCabinetsModel = tgbHiGlassKitchenCabinetsModel;
    }

    public boolean isTgbHdfKitchenCabinetsModel() {
        return tgbHdfKitchenCabinetsModel;
    }

    public void setTgbHdfKitchenCabinetsModel(boolean tgbHdfKitchenCabinetsModel) {
        this.tgbHdfKitchenCabinetsModel = tgbHdfKitchenCabinetsModel;
    }

    public boolean isTgbMetalKitchenCabinetsModel() {
        return tgbMetalKitchenCabinetsModel;
    }

    public void setTgbMetalKitchenCabinetsModel(boolean tgbMetalKitchenCabinetsModel) {
        this.tgbMetalKitchenCabinetsModel = tgbMetalKitchenCabinetsModel;
    }

    public boolean isTgbMdfKitchenCabinetsModel() {
        return tgbMdfKitchenCabinetsModel;
    }

    public void setTgbMdfKitchenCabinetsModel(boolean tgbMdfKitchenCabinetsModel) {
        this.tgbMdfKitchenCabinetsModel = tgbMdfKitchenCabinetsModel;
    }

    public boolean isTgbwoodKitchenCabinetsModel() {
        return tgbwoodKitchenCabinetsModel;
    }

    public void setTgbwoodKitchenCabinetsModel(boolean tgbwoodKitchenCabinetsModel) {
        this.tgbwoodKitchenCabinetsModel = tgbwoodKitchenCabinetsModel;
    }

    public boolean isTgbPvcKitchenCabinetsModel() {
        return tgbPvcKitchenCabinetsModel;
    }

    public void setTgbPvcKitchenCabinetsModel(boolean tgbPvcKitchenCabinetsModel) {
        this.tgbPvcKitchenCabinetsModel = tgbPvcKitchenCabinetsModel;
    }

    public boolean isTgbPassageBuildingTypeModel() {
        return tgbPassageBuildingTypeModel;
    }

    public void setTgbPassageBuildingTypeModel(boolean tgbPassageBuildingTypeModel) {
        this.tgbPassageBuildingTypeModel = tgbPassageBuildingTypeModel;
    }

    public boolean isTgbVillaBuildingTypeModel() {
        return tgbVillaBuildingTypeModel;
    }

    public void setTgbVillaBuildingTypeModel(boolean tgbVillaBuildingTypeModel) {
        this.tgbVillaBuildingTypeModel = tgbVillaBuildingTypeModel;
    }

    public boolean isTgbTowerBuildingTypeModel() {
        return tgbTowerBuildingTypeModel;
    }

    public void setTgbTowerBuildingTypeModel(boolean tgbTowerBuildingTypeModel) {
        this.tgbTowerBuildingTypeModel = tgbTowerBuildingTypeModel;
    }

    public boolean isTgbApartmentBuildingTypeModel() {
        return tgbApartmentBuildingTypeModel;
    }

    public void setTgbApartmentBuildingTypeModel(boolean tgbApartmentBuildingTypeModel) {
        this.tgbApartmentBuildingTypeModel = tgbApartmentBuildingTypeModel;
    }

    public boolean isTgbIntegratedBuildingTypeModel() {
        return tgbIntegratedBuildingTypeModel;
    }

    public void setTgbIntegratedBuildingTypeModel(boolean tgbIntegratedBuildingTypeModel) {
        this.tgbIntegratedBuildingTypeModel = tgbIntegratedBuildingTypeModel;
    }

    public boolean isTgbLakeViewModel() {
        return tgbLakeViewModel;
    }

    public void setTgbLakeViewModel(boolean tgbLakeViewModel) {
        this.tgbLakeViewModel = tgbLakeViewModel;
    }

    public boolean isTgbJangleViewModel() {
        return tgbJangleViewModel;
    }

    public void setTgbJangleViewModel(boolean tgbJangleViewModel) {
        this.tgbJangleViewModel = tgbJangleViewModel;
    }

    public boolean isTgbCityViewModel() {
        return tgbCityViewModel;
    }

    public void setTgbCityViewModel(boolean tgbCityViewModel) {
        this.tgbCityViewModel = tgbCityViewModel;
    }

    public boolean isTgbPanoramaViewModel() {
        return tgbPanoramaViewModel;
    }

    public void setTgbPanoramaViewModel(boolean tgbPanoramaViewModel) {
        this.tgbPanoramaViewModel = tgbPanoramaViewModel;
    }

    public boolean isTgbParkViewModel() {
        return tgbParkViewModel;
    }

    public void setTgbParkViewModel(boolean tgbParkViewModel) {
        this.tgbParkViewModel = tgbParkViewModel;
    }

    public boolean isTgbMountainViewModel() {
        return tgbMountainViewModel;
    }

    public void setTgbMountainViewModel(boolean tgbMountainViewModel) {
        this.tgbMountainViewModel = tgbMountainViewModel;
    }

    public boolean isTgbSeaViewModel() {
        return tgbSeaViewModel;
    }

    public void setTgbSeaViewModel(boolean tgbSeaViewModel) {
        this.tgbSeaViewModel = tgbSeaViewModel;
    }

    public boolean isTgbRiverViewModel() {
        return tgbRiverViewModel;
    }

    public void setTgbRiverViewModel(boolean tgbRiverViewModel) {
        this.tgbRiverViewModel = tgbRiverViewModel;
    }

    public boolean isTgbSkyViewModel() {
        return tgbSkyViewModel;
    }

    public void setTgbSkyViewModel(boolean tgbSkyViewModel) {
        this.tgbSkyViewModel = tgbSkyViewModel;
    }

    public boolean isTgbLibraryRoomTypeModel() {
        return tgbLibraryRoomTypeModel;
    }

    public void setTgbLibraryRoomTypeModel(boolean tgbLibraryRoomTypeModel) {
        this.tgbLibraryRoomTypeModel = tgbLibraryRoomTypeModel;
    }

    public boolean isTgbDressingRoomTypeModel() {
        return tgbDressingRoomTypeModel;
    }

    public void setTgbDressingRoomTypeModel(boolean tgbDressingRoomTypeModel) {
        this.tgbDressingRoomTypeModel = tgbDressingRoomTypeModel;
    }

    public boolean isTgbDiningRoomTypeModel() {
        return tgbDiningRoomTypeModel;
    }

    public void setTgbDiningRoomTypeModel(boolean tgbDiningRoomTypeModel) {
        this.tgbDiningRoomTypeModel = tgbDiningRoomTypeModel;
    }

    public boolean isTgbWorkShopRoomTypeModel() {
        return tgbWorkShopRoomTypeModel;
    }

    public void setTgbWorkShopRoomTypeModel(boolean tgbWorkShopRoomTypeModel) {
        this.tgbWorkShopRoomTypeModel = tgbWorkShopRoomTypeModel;
    }

    public boolean isTgbWorkRoomTypeModel() {
        return tgbWorkRoomTypeModel;
    }

    public void setTgbWorkRoomTypeModel(boolean tgbWorkRoomTypeModel) {
        this.tgbWorkRoomTypeModel = tgbWorkRoomTypeModel;
    }

    public boolean isTgbHomeLollipopRoomTypeModel() {
        return tgbHomeLollipopRoomTypeModel;
    }

    public void setTgbHomeLollipopRoomTypeModel(boolean tgbHomeLollipopRoomTypeModel) {
        this.tgbHomeLollipopRoomTypeModel = tgbHomeLollipopRoomTypeModel;
    }

    public boolean isTgbRefrigeratorFurnishedFacilitiesModel() {
        return tgbRefrigeratorFurnishedFacilitiesModel;
    }

    public void setTgbRefrigeratorFurnishedFacilitiesModel(boolean tgbRefrigeratorFurnishedFacilitiesModel) {
        this.tgbRefrigeratorFurnishedFacilitiesModel = tgbRefrigeratorFurnishedFacilitiesModel;
    }

    public boolean isTgbMacrowaveFurnishedFacilitiesModel() {
        return tgbMacrowaveFurnishedFacilitiesModel;
    }

    public void setTgbMacrowaveFurnishedFacilitiesModel(boolean tgbMacrowaveFurnishedFacilitiesModel) {
        this.tgbMacrowaveFurnishedFacilitiesModel = tgbMacrowaveFurnishedFacilitiesModel;
    }

    public boolean isTgbCarpeteFurnishedFacilitiesModel() {
        return tgbCarpeteFurnishedFacilitiesModel;
    }

    public void setTgbCarpeteFurnishedFacilitiesModel(boolean tgbCarpeteFurnishedFacilitiesModel) {
        this.tgbCarpeteFurnishedFacilitiesModel = tgbCarpeteFurnishedFacilitiesModel;
    }

    public boolean isTgbChandelierFurnishedFacilitiesModel() {
        return tgbChandelierFurnishedFacilitiesModel;
    }

    public void setTgbChandelierFurnishedFacilitiesModel(boolean tgbChandelierFurnishedFacilitiesModel) {
        this.tgbChandelierFurnishedFacilitiesModel = tgbChandelierFurnishedFacilitiesModel;
    }

    public boolean isTgbVacuumeCleanerFurnishedFacilitiesModel() {
        return tgbVacuumeCleanerFurnishedFacilitiesModel;
    }

    public void setTgbVacuumeCleanerFurnishedFacilitiesModel(boolean tgbVacuumeCleanerFurnishedFacilitiesModel) {
        this.tgbVacuumeCleanerFurnishedFacilitiesModel = tgbVacuumeCleanerFurnishedFacilitiesModel;
    }

    public boolean isTgbDishwasherFurnishedFacilitiesModel() {
        return tgbDishwasherFurnishedFacilitiesModel;
    }

    public void setTgbDishwasherFurnishedFacilitiesModel(boolean tgbDishwasherFurnishedFacilitiesModel) {
        this.tgbDishwasherFurnishedFacilitiesModel = tgbDishwasherFurnishedFacilitiesModel;
    }

    public boolean isTgbBedFurnishedFacilitiesModel() {
        return tgbBedFurnishedFacilitiesModel;
    }

    public void setTgbBedFurnishedFacilitiesModel(boolean tgbBedFurnishedFacilitiesModel) {
        this.tgbBedFurnishedFacilitiesModel = tgbBedFurnishedFacilitiesModel;
    }

    public boolean isTgbOvenFurnishedFacilitiesModel() {
        return tgbOvenFurnishedFacilitiesModel;
    }

    public void setTgbOvenFurnishedFacilitiesModel(boolean tgbOvenFurnishedFacilitiesModel) {
        this.tgbOvenFurnishedFacilitiesModel = tgbOvenFurnishedFacilitiesModel;
    }

    public boolean isTgbFurnitureFurnishedFacilitiesModel() {
        return tgbFurnitureFurnishedFacilitiesModel;
    }

    public void setTgbFurnitureFurnishedFacilitiesModel(boolean tgbFurnitureFurnishedFacilitiesModel) {
        this.tgbFurnitureFurnishedFacilitiesModel = tgbFurnitureFurnishedFacilitiesModel;
    }

    public boolean isTgbTelevisionFurnishedFacilitiesModel() {
        return tgbTelevisionFurnishedFacilitiesModel;
    }

    public void setTgbTelevisionFurnishedFacilitiesModel(boolean tgbTelevisionFurnishedFacilitiesModel) {
        this.tgbTelevisionFurnishedFacilitiesModel = tgbTelevisionFurnishedFacilitiesModel;
    }

    public boolean isTgbOttoFurnishedFacilitiesModel() {
        return tgbOttoFurnishedFacilitiesModel;
    }

    public void setTgbOttoFurnishedFacilitiesModel(boolean tgbOttoFurnishedFacilitiesModel) {
        this.tgbOttoFurnishedFacilitiesModel = tgbOttoFurnishedFacilitiesModel;
    }

    public boolean isTgbWashingMachineFurnishedFacilitiesModel() {
        return tgbWashingMachineFurnishedFacilitiesModel;
    }

    public void setTgbWashingMachineFurnishedFacilitiesModel(boolean tgbWashingMachineFurnishedFacilitiesModel) {
        this.tgbWashingMachineFurnishedFacilitiesModel = tgbWashingMachineFurnishedFacilitiesModel;
    }

    public boolean isTgbDishesFurnishedFacilitiesModel() {
        return tgbDishesFurnishedFacilitiesModel;
    }

    public void setTgbDishesFurnishedFacilitiesModel(boolean tgbDishesFurnishedFacilitiesModel) {
        this.tgbDishesFurnishedFacilitiesModel = tgbDishesFurnishedFacilitiesModel;
    }

    public boolean isTgbDishesCurtainFacilitiesModel() {
        return tgbDishesCurtainFacilitiesModel;
    }

    public void setTgbDishesCurtainFacilitiesModel(boolean tgbDishesCurtainFacilitiesModel) {
        this.tgbDishesCurtainFacilitiesModel = tgbDishesCurtainFacilitiesModel;
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

    public boolean isTgbOfficialUsageTypeModel() {
        return tgbOfficialUsageTypeModel;
    }

    public void setTgbOfficialUsageTypeModel(boolean tgbOfficialUsageTypeModel) {
        this.tgbOfficialUsageTypeModel = tgbOfficialUsageTypeModel;
    }

    public boolean isTgbCommercialUsageTypeModel() {
        return tgbCommercialUsageTypeModel;
    }

    public void setTgbCommercialUsageTypeModel(boolean tgbCommercialUsageTypeModel) {
        this.tgbCommercialUsageTypeModel = tgbCommercialUsageTypeModel;
    }

    public boolean isTgbIndustrialUsageTypeModel() {
        return tgbIndustrialUsageTypeModel;
    }

    public void setTgbIndustrialUsageTypeModel(boolean tgbIndustrialUsageTypeModel) {
        this.tgbIndustrialUsageTypeModel = tgbIndustrialUsageTypeModel;
    }

    public boolean isTgbStoreUsageTypeModel() {
        return tgbStoreUsageTypeModel;
    }

    public void setTgbStoreUsageTypeModel(boolean tgbStoreUsageTypeModel) {
        this.tgbStoreUsageTypeModel = tgbStoreUsageTypeModel;
    }

    public boolean isTgbAnimalHusbandryUsageTypeModel() {
        return tgbAnimalHusbandryUsageTypeModel;
    }

    public void setTgbAnimalHusbandryUsageTypeModel(boolean tgbAnimalHusbandryUsageTypeModel) {
        this.tgbAnimalHusbandryUsageTypeModel = tgbAnimalHusbandryUsageTypeModel;
    }

    public boolean isTgbEducationalUsageTypeModel() {
        return tgbEducationalUsageTypeModel;
    }

    public void setTgbEducationalUsageTypeModel(boolean tgbEducationalUsageTypeModel) {
        this.tgbEducationalUsageTypeModel = tgbEducationalUsageTypeModel;
    }

    public boolean isTgbResidentialUsageTypeModel() {
        return tgbResidentialUsageTypeModel;
    }

    public void setTgbResidentialUsageTypeModel(boolean tgbResidentialUsageTypeModel) {
        this.tgbResidentialUsageTypeModel = tgbResidentialUsageTypeModel;
    }

    public boolean isTgbAdministrativePositionUsageTypeModel() {
        return tgbAdministrativePositionUsageTypeModel;
    }

    public void setTgbAdministrativePositionUsageTypeModel(boolean tgbAdministrativePositionUsageTypeModel) {
        this.tgbAdministrativePositionUsageTypeModel = tgbAdministrativePositionUsageTypeModel;
    }

    public boolean isTgbResidentUsageTypeModel() {
        return tgbResidentUsageTypeModel;
    }

    public void setTgbResidentUsageTypeModel(boolean tgbResidentUsageTypeModel) {
        this.tgbResidentUsageTypeModel = tgbResidentUsageTypeModel;
    }

    public boolean isTgbAgricultureUsageTypeModel() {
        return tgbAgricultureUsageTypeModel;
    }

    public void setTgbAgricultureUsageTypeModel(boolean tgbAgricultureUsageTypeModel) {
        this.tgbAgricultureUsageTypeModel = tgbAgricultureUsageTypeModel;
    }

    public boolean isTgbSportsUsageTypeModel() {
        return tgbSportsUsageTypeModel;
    }

    public void setTgbSportsUsageTypeModel(boolean tgbSportsUsageTypeModel) {
        this.tgbSportsUsageTypeModel = tgbSportsUsageTypeModel;
    }

    public boolean isTgbClinicUsageTypeModel() {
        return tgbClinicUsageTypeModel;
    }

    public void setTgbClinicUsageTypeModel(boolean tgbClinicUsageTypeModel) {
        this.tgbClinicUsageTypeModel = tgbClinicUsageTypeModel;
    }

    public int getHpDistanceToVehicleModel() {
        return hpDistanceToVehicleModel;
    }

    public void setHpDistanceToVehicleModel(int hpDistanceToVehicleModel) {
        this.hpDistanceToVehicleModel = hpDistanceToVehicleModel;
    }

    public String getEdtMoreInfoModel() {
        return edtMoreInfoModel;
    }

    public void setEdtMoreInfoModel(String edtMoreInfoModel) {
        this.edtMoreInfoModel = edtMoreInfoModel;
    }
}
