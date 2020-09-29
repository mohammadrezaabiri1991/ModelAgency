package com.hekatomsoft.androidcor.bottombarfragment.googlemap;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


import com.hekatomsoft.androidcor.R;
import com.hekatomsoft.androidcor.bottombarfragment.repository.MapModel;
import com.hekatomsoft.androidcor.bottombarfragment.repository.RealmDataBase;
import com.hekatomsoft.androidcor.com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.hekatomsoft.androidcor.com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;
import com.hekatomsoft.androidcor.databinding.DialogBuildingFacadesBinding;
import com.hekatomsoft.androidcor.databinding.DialogBuildingTypeBinding;
import com.hekatomsoft.androidcor.databinding.DialogCoolingHealingSystemBinding;
import com.hekatomsoft.androidcor.databinding.DialogFloorCoveringTypeBinding;
import com.hekatomsoft.androidcor.databinding.DialogFurnishedFacilitiesBinding;
import com.hekatomsoft.androidcor.databinding.DialogKitckenCabinetsBinding;
import com.hekatomsoft.androidcor.databinding.DialogRoomTypeBinding;
import com.hekatomsoft.androidcor.databinding.DialogSpecialFeaturesBinding;
import com.hekatomsoft.androidcor.databinding.DialogTypeOfMelkDocumentBinding;
import com.hekatomsoft.androidcor.databinding.DialogViewBinding;
import com.hekatomsoft.androidcor.databinding.DialogWindowsTypeBinding;
import com.hekatomsoft.androidcor.databinding.ListViewDeatilsBinding;
import com.hekatomsoft.androidcor.zoomphotoview.src.main.java.com.github.chrisbanes.photoview.PhotoView;


import java.text.DecimalFormat;
import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import static com.hekatomsoft.androidcor.bottombarfragment.googlemap.GoogleMapFragment.linearAddNewUnit;
import static com.hekatomsoft.androidcor.bottombarfragment.googlemap.GoogleMapFragment.mHome_id;
import static com.hekatomsoft.androidcor.bottombarfragment.googlemap.GoogleMapFragment.mainBehavior;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.DIALOG_TAG;
import static com.hekatomsoft.androidcor.bottombarfragment.repository.Constant.REALM_FILE_NAME;


public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private static final int MY_PERMISSION_CAMERA = 100;
    private static final int READ_ACCESS_PERMISSION_STORAGE = 101;

    private static final int GALLERY_REQUEST = 1;
    private static final int CAMERA_REQUEST = 0;


    private final ArrayList<Group> groups;
    private final Typeface shabnamFont;
    private final RealmDataBase realmDataBase;
    public LayoutInflater inflater;
    public Activity activity;
    public ChildViewHolder childViewHolder;
    public static Group currentItem;

    //    private DataBaseClassSample dataBaseClassSample;
    public static int isHomeSaved = 0;

    public static boolean isFieldsInitialized;
    public static boolean deleteHomeSuccess;

    public PhotoView imgDialogMelkGallary;


    public MyExpandableListAdapter(Activity act, ArrayList<Group> groups) {
        activity = act;
        this.groups = groups;
        inflater = act.getLayoutInflater();
        realmDataBase = new RealmDataBase();
        shabnamFont = Typeface.createFromAsset(activity.getAssets(), "shabnam.ttf");
    }


    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
//        return Long.parseLong(groups.get(groupPosition).children.get(childPosition));
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }


    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).children.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }


    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded,
                             View convertView, final ViewGroup parent) {
        String groupId = "";

        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_group, null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        final Group group = (Group) getGroup(groupPosition);


        RelativeLayout relativeLayoutHeaderListView = convertView.findViewById(R.id.relative_group);
        CardView cardView = (CardView) relativeLayoutHeaderListView.getChildAt(0);
        final CheckedTextView checkedTextView = (CheckedTextView) cardView.getChildAt(0);
        LinearLayout linearLayout = (LinearLayout) cardView.getChildAt(1);
        ImageView imageViewRemove = (ImageView) linearLayout.getChildAt(0);
        ImageView imgSaveUnitEListView = (ImageView) linearLayout.getChildAt(1);
        checkedTextView.setText(group.getString());
        new Thread(new Runnable() {
            @Override
            public void run() {
                checkedTextView.setChecked(isExpanded);
            }
        }).start();


        if (isExpanded) {
            imgSaveUnitEListView.setBackgroundResource(android.R.drawable.ic_menu_save);
            imageViewRemove.setBackgroundResource(android.R.drawable.ic_delete);
            relativeLayoutHeaderListView.setBackgroundColor(Color.parseColor("#88ff6655"));

            imgSaveUnitEListView.setEnabled(true);
            imageViewRemove.setEnabled(true);
        } else {
            imgSaveUnitEListView.setBackgroundResource(android.R.drawable.ic_lock_lock);
            imageViewRemove.setBackgroundResource(android.R.drawable.ic_lock_lock);
            relativeLayoutHeaderListView.setBackgroundColor(Color.parseColor("#8833aafc"));

            imgSaveUnitEListView.setEnabled(false);
            imageViewRemove.setEnabled(false);

        }
        relativeLayoutHeaderListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideMY_KEYboard(v);
                return false;
            }
        });

        imageViewRemove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialogBoxRemoveUnit(groupPosition, group);
                hideMY_KEYboard(v);
            }
        });


        imgSaveUnitEListView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                checkIsEmptyUnitWidgetsInformation();
//                if (isFieldsInitialized) {
                createDialogBoxSaveUnit(groupPosition, group);
//                } else {
//                    Toast.makeText(activity, R.string.fieldsAreEmpty, Toast.LENGTH_SHORT).show();
//                }
                hideMY_KEYboard(v);

            }


        });

        return convertView;
    }

    //TODO
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        currentItem = (Group) getGroup(groupPosition);

        ListViewDeatilsBinding listViewDeatilsBinding;

        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.list_view_deatils, null);

            listViewDeatilsBinding = DataBindingUtil.bind(convertView);
            childViewHolder = new ChildViewHolder((ViewGroup) convertView);
            convertView.setTag(listViewDeatilsBinding);
        } else {
            listViewDeatilsBinding = (ListViewDeatilsBinding) convertView.getTag();
        }
        childViewHolder.fill(this, currentItem, groupPosition, convertView);
        listViewDeatilsBinding.setGroups(currentItem);

        return listViewDeatilsBinding.getRoot();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private void hideMY_KEYboard(View view) {
        if (activity != null && view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void createDialogBoxRemoveUnit(final int groupPosition, final Group group) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setTitle("Delete entry")
                .setMessage("Are you sure to delete this entry?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (groups.size() > 1) {
                            removeUnit(groupPosition);
                            isHomeSaved = realmDataBase.deleteUnit(group.getUnitId_value(), activity, group);
                        } else {
                            createDialogBoxRemoveUnitAndMarker(groupPosition, group);
                        }

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();


    }

    private void createDialogBoxSaveUnit(final int groupPosition, final Group group) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setTitle("Save entry")
                .setMessage("Are you sure to Save this entry?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        getUnitWidgetsInfoAndSave(group);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void createDialogBoxRemoveUnitAndMarker(final int groupPosition, final Group group) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setTitle("Delete entry")
                .setMessage("Are you sure to delete this entry???")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        removeUnit(groupPosition);
                        final String latRemove = String.valueOf(GoogleMapFragment.mMarker.getPosition().latitude);
                        final String lngRemove = String.valueOf(GoogleMapFragment.mMarker.getPosition().longitude);
                        GoogleMapFragment.mMarker.remove();
                        realmDataBase.deleteHome(mHome_id, activity);
                        deleteHomeSuccess = true;
                        if (mainBehavior != null) {
                            mainBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                        }

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    public void removeUnit(int groupPosition) {
        groups.remove(groupPosition);
        notifyDataSetChanged();
    }


    public class GroupViewHolder {
        public RelativeLayout relativeGroupHolder;

        public GroupViewHolder(View convertView) {
            relativeGroupHolder = convertView.findViewById(R.id.relative_group);


        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public class ChildViewHolder implements DatePickerDialog.OnDateSetListener {


        private final DatePickerDialog datePickerDialog;


        @Nullable
        @BindView(R.id.relative_group_deals)
        RelativeLayout relativeGroupDeals;


        @Nullable
        @BindView(R.id.card_view_list_details)
        CardView cardViewListDetails;


        @Nullable
        @BindView(R.id.ll_view_list_details)
        LinearLayout llViewListDetails;


        @Nullable
        @BindView(R.id.ll_cooling_healing_system_left)
        LinearLayout llCoolingHealingSystemLeft;


        @Nullable
        @BindView(R.id.ll_cooling_healing_system_right)
        LinearLayout llCoolingHealingSystemRight;


        @Nullable
        @BindView(R.id.ll_building_facades_left)
        LinearLayout llBuildingFacadesLeft;


        @Nullable
        @BindView(R.id.ll_building_facades_right)
        LinearLayout llBuildingFacadesRight;


        @Nullable
        @BindView(R.id.ll_kitchen_cabinets_left)
        LinearLayout llKitchenCabinetsLeft;


        @Nullable
        @BindView(R.id.ll_kitchen_cabinets_right)
        LinearLayout llKitchenCabinetsRight;


        @Nullable
        @BindView(R.id.ll_windows_type_left)
        LinearLayout llWindowsTypeLeft;


        @Nullable
        @BindView(R.id.ll_windows_type_right)
        LinearLayout llWindowsTypeRight;


        @Nullable
        @BindView(R.id.ll_room_type_left)
        LinearLayout llRoomTypeLeft;


        @Nullable
        @BindView(R.id.ll_room_type_right)
        LinearLayout llRoomTypeRight;


        @Nullable
        @BindView(R.id.ll_furnished_facilities_left)
        LinearLayout llFurnishedFacilitiesLeft;


        @Nullable
        @BindView(R.id.ll_furnished_facilities_right)
        LinearLayout llFurnishedFacilitiesRight;


        @Nullable
        @BindView(R.id.ll_view_left)
        LinearLayout llViewLeft;


        @Nullable
        @BindView(R.id.ll_view_right)
        LinearLayout llViewRight;


        @Nullable
        @BindView(R.id.ll_special_features_left)
        LinearLayout llSpecialFeaturesLeft;


        @Nullable
        @BindView(R.id.ll_special_features_right)
        LinearLayout llSpecialFeaturesRight;


        @Nullable
        @BindView(R.id.ll_usage_type_left)
        LinearLayout llUsageTypeLeft;


        @Nullable
        @BindView(R.id.ll_usage_type_right)
        LinearLayout llUsageTypeRight;


        @Nullable
        @BindView(R.id.ll_type_of_melk_document_left)
        LinearLayout llTypeOfMelkDocumentLeft;


        @Nullable
        @BindView(R.id.ll_type_of_melk_document_right)
        LinearLayout llTypeOfMelkDocumentRight;


        @Nullable
        @BindView(R.id.ll_floor_covering_type_left)
        LinearLayout llFloorCoveringTypeLeft;


        @Nullable
        @BindView(R.id.ll_floor_covering_type_right)
        LinearLayout llFloorCoveringTypeRight;


        @Nullable
        @BindView(R.id.ll_building_type_left)
        LinearLayout llBuildingTypeLeft;


        @Nullable
        @BindView(R.id.ll_building_type_right)
        LinearLayout llBuildingTypeRight;


        @Nullable
        @BindView(R.id.ll_loan_since_dung)
        LinearLayout llLoanSinceDung;


        @Nullable
        @BindView(R.id.linear_amount_sell)
        LinearLayout linearAmountSell;


        @Nullable
        @BindView(R.id.linear_rent_and_rahn)
        LinearLayout linearAmountRentAndRahn;


        @Nullable
        @BindView(R.id.ll_number_of_owners)
        LinearLayout llNumberOfOwners;


        @Nullable
        @BindView(R.id.ll_owners_information)
        LinearLayout llOwnersInformation;


        @Nullable
        @BindView(R.id.ll_max_allowed_and_convertible)
        LinearLayout llMaxAllowedAndConvertible;


        @Nullable
        @BindView(R.id.ll_melk_age)
        LinearLayout llMelkAge;


        @Nullable
        @BindView(R.id.linear_installment_terms)
        LinearLayout linearInstallmentTerms;


        @Nullable
        @BindView(R.id.ll_percentage_of_made_and_receive_time)
        LinearLayout llPercentageOfMadeAndReceiveTime;


        @Nullable
        @BindView(R.id.ll_floor_number)
        LinearLayout llFloorNumber;


        @Nullable
        @BindView(R.id.ll_number_of_bed_rooms)
        LinearLayout llNumberOfBedRooms;


        @Nullable
        @BindView(R.id.ll_number_of_floors)
        LinearLayout llNumberOfFloors;


        @Nullable
        @BindView(R.id.ll_number_of_unit_in_floor)
        LinearLayout llNumberOfUnitInFloor;


        @Nullable
        @BindView(R.id.ll_unit_type)
        LinearLayout llUnitType;


        @Nullable
        @BindView(R.id.ll_melk_positions)
        LinearLayout llMelkPositions;


        @Nullable
        @BindView(R.id.ll_date_of_quit)
        LinearLayout llDateOfQuit;


        @Nullable
        @BindView(R.id.ll_number_of_elevator)
        LinearLayout llNumberOfElevator;


        @Nullable
        @BindView(R.id.ll_number_of_bathroom)
        LinearLayout llNumberOfBathroom;


        @Nullable
        @BindView(R.id.ll_number_of_parking)
        LinearLayout llNumberOfParking;


        @Nullable
        @BindView(R.id.ll_number_of_kitchen)
        LinearLayout llNumberOfKitchen;


        @Nullable
        @BindView(R.id.ll_number_of_master_room)
        LinearLayout llNumberOfMasterRoom;


        @Nullable
        @BindView(R.id.ll_number_of_iranian_toilet)
        LinearLayout llNumberOfIraniToilet;


        @Nullable
        @BindView(R.id.ll_number_of_farangi_toilet)
        LinearLayout llNumberOfFarangiToilet;


        @Nullable
        @BindView(R.id.rl_plus_special_feature)
        RelativeLayout rlPlusSpecialFeature;


        @Nullable
        @BindView(R.id.ll_amount_mount_charge)
        LinearLayout llAmountMountCharge;


        @Nullable
        @BindView(R.id.ll_geo_position)
        LinearLayout llGeoPosition;


        @Nullable
        @BindView(R.id.ll_structure_type)
        LinearLayout llStructureType;


        @Nullable
        @BindView(R.id.ll_lighting_direct)
        LinearLayout llLightingDirect;


        @Nullable
        @BindView(R.id.ll_number_of_roof_space)
        LinearLayout llNumberOfRoofSpace;


        @Nullable
        @BindView(R.id.ll_ceiling_height)
        LinearLayout llCeilingHeight;


        @Nullable
        @BindView(R.id.ll_melk_width)
        LinearLayout llMelkWidth;


        @Nullable
        @BindView(R.id.ll_goodwill_and_property)
        LinearLayout llGoodwillAndProperty;


        @Nullable
        @BindView(R.id.ll_electric_meter_type)
        LinearLayout llElectricMeterType;


        @Nullable
        @BindView(R.id.ll_share_and_private_electric_meter)
        LinearLayout llShareAndPrivateElectricMeter;


        @Nullable
        @BindView(R.id.ll_gas_meter_type)
        LinearLayout llGasMeterType;


        @Nullable
        @BindView(R.id.ll_water_meter_type)
        LinearLayout llWaterMeterType;


        @Nullable
        @BindView(R.id.ll_number_of_tel_sub)
        LinearLayout llNumberOfTelSub;


        @Nullable
        @BindView(R.id.rl_plus_melk_doc_type)
        RelativeLayout rlPlusMelkDocType;


        @Nullable
        @BindView(R.id.rl_plus_cooling_healing_system)
        RelativeLayout rlPlusCoolingHealingSystem;


        @Nullable
        @BindView(R.id.rl_plus_floor_cover_type)
        RelativeLayout rlPlusFloorCoverType;


        @Nullable
        @BindView(R.id.rl_plus_building_facades)
        RelativeLayout rlPlusBuildingFacades;


        @Nullable
        @BindView(R.id.rl_plus_kitchen_cabinets)
        RelativeLayout rlPlusKitchenCabinets;


        @Nullable
        @BindView(R.id.rl_plus_windows_type)
        RelativeLayout rlPlusWindowsType;


        @Nullable
        @BindView(R.id.rl_plus_building_type)
        RelativeLayout rlPlusBuildingType;


        @Nullable
        @BindView(R.id.rl_plus_melk_view)
        RelativeLayout rlPlusMelkView;


        @Nullable
        @BindView(R.id.rl_plus_type_of_rooms)
        RelativeLayout rlPlusTypeOfRooms;


        @Nullable
        @BindView(R.id.rl_plus_furnished_facilities)
        RelativeLayout rlPlusFurnishedFacilities;


        @Nullable
        @BindView(R.id.ll_distance_to_public_vehicle)
        LinearLayout llDistanceToPublicVehicle;


        @Nullable
        @BindView(R.id.ll_left_possibilities)
        LinearLayout llPossibilitiesLeft;


        @Nullable
        @BindView(R.id.ll_right_possibilities)
        LinearLayout llPossibilitiesRight;


        @Nullable
        @BindView(R.id.ll_center_possibilities)
        LinearLayout llPossibilitiesCenter;


        @Nullable
        @BindView(R.id.linear_max_allowed_for_residences)
        LinearLayout linearMaxAllowedForResidences;


        @Nullable
        @BindView(R.id.linear_since_quantity)
        LinearLayout linearSinceQuantity;

        @Nullable
        @BindView(R.id.rl_plus_usage_type)
        RelativeLayout relativeUsageType;

        //--------------------------------------------------------Spinners

        @Nullable
        @BindView(R.id.sp_trans_type)
        Spinner spTransType;


        @Nullable
        @BindView(R.id.sp_melk_type)
        Spinner spMelkType;


//--------------------------------------------------------EditTexts


        @Nullable
        @BindView(R.id.edt_amount_sell)
        EditText edtAmountSell;


        @Nullable
        @BindView(R.id.edt_amount_rent)
        EditText edtAmountRent;


        @Nullable
        @BindView(R.id.edt_amount_rahn)
        EditText edtAmountRahn;


        @Nullable
        @BindView(R.id.edt_amount_sell_per_metric)
        EditText edtAmountSellPerMetric;


        @Nullable
        @BindView(R.id.edt_owners_information)
        EditText edtOwnerInformation;


        @Nullable
        @BindView(R.id.edt_since_quantity)
        EditText edtSinceQuantity;


        @Nullable
        @BindView(R.id.edt_installment_terms)
        EditText edtInstallmentTerms;


        @Nullable
        @BindView(R.id.edt_amount_loan)
        EditText edtAmountLoan;


        @Nullable
        @BindView(R.id.edt_amount_mount_charge)
        EditText edtAmountMountCharge;


        @Nullable
        @BindView(R.id.edt_more_info)
        EditText edtMoreInfo;

        //--------------------------------------------------------

        @Nullable
        @BindView(R.id.sw_installment)
        Switch swInstallment;


        @Nullable
        @BindView(R.id.sw_date_of_quit)
        Switch swDateOfQuit;


        @Nullable
        @BindView(R.id.sw_has_a_loan)
        Switch swHasLoan;

        //--------------------------------------------------------Buttons

        @Nullable
        @BindView(R.id.btn_plus_special_feature)
        Button btnPlusSpecialFeature;
        //--------------------------------------------------------TextViews


        @Nullable
        @BindView(R.id.txt_date_of_quit)
        TextView txtDateOfQuit;


        @Nullable
        @BindView(R.id.txt_select_melk_receive_time)
        TextView txtSelectMelkReceiveTime;


        @Nullable
        @BindView(R.id.txt_plus_melk_doc_type)
        TextView txtPlusMelkDocType;

        //--------------------------------------------------------HorizontalPickers

        @Nullable
        @BindView(R.id.hp_number_of_owners)
        HorizontalPicker hpNumberOfOwners;


        @Nullable
        @BindView(R.id.hp_dung_for_sell)
        HorizontalPicker hpDungForSell;


        @Nullable
        @BindView(R.id.hp_max_allowed_for_residences)
        HorizontalPicker hpMaxAllowedForResidences;


        @Nullable
        @BindView(R.id.hp_percentage_of_progress_made)
        HorizontalPicker hpPercentageOfProgressMade;


        @Nullable
        @BindView(R.id.hp_melk_age)
        HorizontalPicker hpMelkAge;


        @Nullable
        @BindView(R.id.hp_number_of_bed_rooms)
        HorizontalPicker hpNumberOfBedRooms;


        @Nullable
        @BindView(R.id.hp_floor_number)
        HorizontalPicker hpFloorNumber;


        @Nullable
        @BindView(R.id.hp_number_of_floors)
        HorizontalPicker hpNumberOfFloors;


        @Nullable
        @BindView(R.id.hp_number_of_unit_in_floor)
        HorizontalPicker hpNumberOfUnitInFloor;


        @Nullable
        @BindView(R.id.hp_number_of_elevator)
        HorizontalPicker hpNumberOfElevator;


        @Nullable
        @BindView(R.id.hp_number_of_bath_room)
        HorizontalPicker hpNumberOfBathRoom;


        @Nullable
        @BindView(R.id.hp_number_of_parking)
        HorizontalPicker hpNumberOfParking;


        @Nullable
        @BindView(R.id.hp_number_of_kitchen)
        HorizontalPicker hpNumberOfKitchen;


        @Nullable
        @BindView(R.id.hp_number_of_master_room)
        HorizontalPicker hpNumberOfMasterRoom;


        @Nullable
        @BindView(R.id.hp_number_of_iranian_toilet)
        HorizontalPicker hpNumberOfIraniToilet;


        @Nullable
        @BindView(R.id.hp_number_of_farangi_toilet)
        HorizontalPicker hpNumberOfFarangiToilet;


        @Nullable
        @BindView(R.id.hp_number_of_roof_space)
        HorizontalPicker hpNumberOfRoofSpace;


        @Nullable
        @BindView(R.id.hp_height_of_the_ceiling)
        HorizontalPicker hpHeightOfTheCeiling;


        @Nullable
        @BindView(R.id.hp_melk_width)
        HorizontalPicker hpMelkWidth;


        @Nullable
        @BindView(R.id.hp_number_of_tell_sub)
        HorizontalPicker hpNumberOfTellSub;


        @Nullable
        @BindView(R.id.hp_distance_to_vehicle)
        HorizontalPicker hpDistanceToVehicle;

        //--------------------------------------------------------ToggleButton

        //        @Nullable
//        @BindView(R.id.tgb_official_usage_type)
        ToggleButton tgbOfficialUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_commercial_usage_type)
        ToggleButton tgbCommercialUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_industrial_usage_type)
        ToggleButton tgbIndustrialUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_store_usage_type)
        ToggleButton tgbStoreUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_animal_husbandry_usage_type)
        ToggleButton tgbAnimalHusbandryUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_educational_usage_type)
        ToggleButton tgbEducationalUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_residential_usage_type)
        ToggleButton tgbResidentialUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_administrative_position_usage_type)
        ToggleButton tgbAdministrativePositionUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_resident_usage_type)
        ToggleButton tgbResidentUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_agriculture_usage_type)
        ToggleButton tgbAgricultureUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_sports_usage_type)
        ToggleButton tgbSportsUsageType;

        //        @Nullable
//        @BindView(R.id.tgb_clinic_usage_type)
        ToggleButton tgbClinicUsageType;


        @Nullable
        @BindView(R.id.tgb_changeable_to_rent)
        ToggleButton tgbChangeableToRent;


        @Nullable
        @BindView(R.id.tgb_changeable_to_rahn)
        ToggleButton tgbChangeableToRahn;


        @Nullable
        @BindView(R.id.tgb_flat_unit_type)
        ToggleButton tgbFlatUnitType;


        @Nullable
        @BindView(R.id.tgb_doublex_unit_type)
        ToggleButton tabDoubleUnitType;


        @Nullable
        @BindView(R.id.tgb_triplex_unit_type)
        ToggleButton tgbTriplexUnitType;


        @Nullable
        @BindView(R.id.tgb_beach_melk_positions)
        ToggleButton tgbBeachMelkPositions;


        @Nullable
        @BindView(R.id.tgb_jangle_melk_positions)
        ToggleButton tgbJangleMelkPositions;


        @Nullable
        @BindView(R.id.tgb_mountain_melk_positions)
        ToggleButton tgbMountainMelkPositions;


        @Nullable
        @BindView(R.id.tgb_township_melk_positions)
        ToggleButton tgbTownshipMelkPositions;


        @Nullable
        @BindView(R.id.tgb_patio_possibilities)
        ToggleButton tgbPatioPossibilities;


        @Nullable
        @BindView(R.id.tgb_water_well_possibilities)
        ToggleButton tgbWaterWellPossibilities;


        @Nullable
        @BindView(R.id.tgb_balcony_possibilities)
        ToggleButton tgbBalconyPossibilities;


        @Nullable
        @BindView(R.id.tgb_video_iphone_possibilities)
        ToggleButton tgbVideoIphonePossibilities;


        @Nullable
        @BindView(R.id.tgb_wall_closet_possibilities)
        ToggleButton tgbWallClosetPossibilities;


        @Nullable
        @BindView(R.id.tgb_store_possibilities)
        ToggleButton tgbStorePossibilities;


        @Nullable
        @BindView(R.id.tgb_yard_possibilities)
        ToggleButton tgbYardPossibilities;


        @Nullable
        @BindView(R.id.tgb_janitor_possibilities)
        ToggleButton tgbJanitorPossibilities;


        @Nullable
        @BindView(R.id.tgb_rebuild_possibilities)
        ToggleButton tgbRebuildPossibilities;


        @Nullable
        @BindView(R.id.tgb_sofa_possibilities)
        ToggleButton tgbSofaPossibilities;


        @Nullable
        @BindView(R.id.tgb_camera_possibilities)
        ToggleButton tgbCameraPossibilities;


        @Nullable
        @BindView(R.id.tgb_central_antenna_possibilities)
        ToggleButton tgbCentralAntennaPossibilities;


        @Nullable
        @BindView(R.id.tgb_changeable_possibilities)
        ToggleButton tgbChangeablePossibilities;


        @Nullable
        @BindView(R.id.tgb_west_geo_position)
        ToggleButton tgbWestGeoPosition;


        @Nullable
        @BindView(R.id.tgb_est_geo_position)
        ToggleButton tgbEstGeoPosition;


        @Nullable
        @BindView(R.id.tgb_south_geo_position)
        ToggleButton tgbSouthGeoPosition;


        @Nullable
        @BindView(R.id.tgb_north_geo_position)
        ToggleButton tgbNorthGeoPosition;


        @Nullable
        @BindView(R.id.tgb_blots_nuts_struct_type)
        ToggleButton tgbBlotsButsStructType;


        @Nullable
        @BindView(R.id.tgb_metal_struct_type)
        ToggleButton tgbMetalStructType;


        @Nullable
        @BindView(R.id.tgb_concrete_and_bar_struct_type)
        ToggleButton tgbConcreteAndBarStructType;


        @Nullable
        @BindView(R.id.tgb_west_lighting_direct)
        ToggleButton tgbWestLightingDirect;


        @Nullable
        @BindView(R.id.tgb_est_lighting_direct)
        ToggleButton tgbEstLightingDirect;


        @Nullable
        @BindView(R.id.tgb_sought_lighting_direct)
        ToggleButton tgbSoughtLightingDirect;


        @Nullable
        @BindView(R.id.tgb_north_lighting_direct)
        ToggleButton tgbNorthLightingDirect;


        @Nullable
        @BindView(R.id.tgb_goodwill)
        ToggleButton tgbGoodwill;


        @Nullable
        @BindView(R.id.tgb_property)
        ToggleButton tgbProperty;


        @Nullable
        @BindView(R.id.tgb_three_phase_electric)
        ToggleButton tgbThreePhaseElectric;


        @Nullable
        @BindView(R.id.tgb_one_phase_electric)
        ToggleButton tgbOnePhaseElectric;


        @Nullable
        @BindView(R.id.tgb_share_electric)
        ToggleButton tgbShareElectric;


        @Nullable
        @BindView(R.id.tgb_private_electric)
        ToggleButton tgbPrivateElectric;


        @Nullable
        @BindView(R.id.tgb_share_gas_meter)
        ToggleButton tgbShareGasMeter;


        @Nullable
        @BindView(R.id.tgb_private_gas_meter)
        ToggleButton tgbPrivateGasMeter;


        @Nullable
        @BindView(R.id.tgb_share_water_meter)
        ToggleButton tgbShareWaterMeter;


        @Nullable
        @BindView(R.id.tgb_private_water_meter)
        ToggleButton tgbPrivateWaterMeter;


        //@BindView(R.id.tgb_lobby_special_features)
        ToggleButton tgbLobbySpecialFeatures;


        //@BindView(R.id.tgb_bathtub_special_features)
        ToggleButton tgbBathtubSpecialFeatures;


        //@BindView(R.id.tgb_swimming_pool_special_features)
        ToggleButton tgbSwimmingPoolSpecialFeatures;


        //@BindView(R.id.tgb_fireplace_special_features)
        ToggleButton tgbFirePlaceSpecialFeatures;


        //@BindView(R.id.tgb_children_play_space_special_features)
        ToggleButton tgbChildrenPlaySpaceSpecialFeatures;


        //@BindView(R.id.tgb_garden_yard__special_features)
        ToggleButton tgbGardenYardSpecialFeatures;


        //@BindView(R.id.tgb_central_vacuum_cleaner_special_features)
        ToggleButton tgbCentralVacuumCleanerSpecialFeatures;


        //@BindView(R.id.tgb_amphitheater_special_features)
        ToggleButton tgbAmphitheaterSpecialFeatures;


        //@BindView(R.id.tgb_conference_hall_special_features)
        ToggleButton tgbConferenceHallSpecialFeatures;


        //@BindView(R.id.tgb_firefight_special_features)
        ToggleButton tgbFirefightSpecialFeatures;


        //@BindView(R.id.tgb_solar_battery_special_features)
        ToggleButton tgbSolarBatterySpecialFeatures;


        //@BindView(R.id.tgb_fountain_special_features)
        ToggleButton tgbFountainSpecialFeatures;


        //@BindView(R.id.tgb_cargo_elevator_special_features)
        ToggleButton tgbCargoElevatorSpecialFeatures;


        //@BindView(R.id.tgb_water_supply_special_features)
        ToggleButton tgbWaterSupplySpecialFeatures;


        //@BindView(R.id.tgb_tennis_court_special_features)
        ToggleButton tgbTennisCourtSpecialFeatures;


        //@BindView(R.id.tgb_guest_parking_special_features)
        ToggleButton tgbGuestParkingSpecialFeatures;


        //@BindView(R.id.tgb_sauna_special_features)
        ToggleButton tgbSaunaSpecialFeatures;


        //@BindView(R.id.tgb_jacuzzi_special_features)
        ToggleButton tgbJacuzziSpecialFeatures;


        //@BindView(R.id.tgb_children_pool_special_features)
        ToggleButton tgbChildrenPoolSpecialFeatures;


        //@BindView(R.id.tgb_roof_garden_special_features)
        ToggleButton tgbRoofGardenSpecialFeatures;


        //@BindView(R.id.tgb_barbecue_special_features)
        ToggleButton tgbBarbecueSpecialFeatures;


        //@BindView(R.id.tgb_shooting_waste_special_features)
        ToggleButton tgbShootingWasteSpecialFeatures;


        //@BindView(R.id.tgb_altar_special_features)
        ToggleButton tgbAltarSpecialFeatures;


        //@BindView(R.id.tgb_security_system_special_features)
        ToggleButton tgbSecuritySystemSpecialFeatures;


        //@BindView(R.id.tgb_smart_home_special_features)
        ToggleButton tgbSmartHomeSpecialFeatures;


        //@BindView(R.id.tgb_safeguard_special_features)
        ToggleButton tgbSafeguardSpecialFeatures;


        //@BindView(R.id.tgb_emergency_power_special_features)
        ToggleButton tgbEmergencyPowerSpecialFeatures;


        //@BindView(R.id.tgb_caretakers_room_special_features)
        ToggleButton tgbCaretakersRoomSpecialFeatures;


        //@BindView(R.id.tgb_security_door_special_features)
        ToggleButton tgbSecurityDoorSpecialFeatures;


        //@BindView(R.id.tgb_water_purifier_special_features)
        ToggleButton tgbWaterPurifierSpecialFeatures;


        //@BindView(R.id.tgb_parking_remote_special_features)
        ToggleButton tgbParkingRemoteSpecialFeatures;


        //@BindView(R.id.tgb_pool_table_special_features)
        ToggleButton tgbPoolTableSpecialFeatures;


        //@BindView(R.id.tgb_personal_type_of_melk_document)
        ToggleButton tgbPersonalTypeOfMelkDocument;


        //@BindView(R.id.tgb_endowments_type_of_melk_document)
        ToggleButton tgbEndowmentsTypeOfMelkDocument;


        //@BindView(R.id.tgb_commercial_type_of_melk_document)
        ToggleButton tgbCommercialTypeOfMelkDocument;


        //@BindView(R.id.tgb_shari_ruler_type_of_melk_document)
        ToggleButton tgbShariRulerTypeOfMelkDocument;


        //@BindView(R.id.tgb_organizational_type_of_melk_document)
        ToggleButton tgbOrganizationalTypeOfMelkDocument;


        //@BindView(R.id.tgb_official_type_of_melk_document)
        ToggleButton tgbOfficialTypeOfMelkDocument;


        //@BindView(R.id.tgb_cooperative_type_of_melk_document)
        ToggleButton tgbCooperativeTypeOfMelkDocument;


        //@BindView(R.id.tgb_proxy_type_of_melk_document)
        ToggleButton tgbProxyTypeOfMelkDocument;


        //@BindView(R.id.tgb_letter_of_credit_type_of_melk_document)
        ToggleButton tgbLetterOfCreditTypeOfMelkDocument;


        //@BindView(R.id.tgb_jointly_type_of_melk_document)
        ToggleButton tgbJointlyTypeOfMelkDocument;


        //@BindView(R.id.tgb_residential_type_of_melk_document)
        ToggleButton tgbResidentialTypeOfMelkDocument;


        //@BindView(R.id.tgb_industrial_type_of_melk_document)
        ToggleButton tgbIndustrialTypeOfMelkDocument;


        //@BindView(R.id.tgb_package_cooling_healing)
        ToggleButton tgbPackageCoolingHealingSystem;


        //@BindView(R.id.tgb_heater_cooling_healing)
        ToggleButton tgbHeaterCoolingHealingSystem;


        //@BindView(R.id.tgb_chiller_cooling_healing)
        ToggleButton tgbChillerCoolingHealingSystem;


        //@BindView(R.id.tgb_water_cooler_cooling_healing)
        ToggleButton tgbWaterCoolerCoolingHealingSystem;


        //@BindView(R.id.tgb_fan_coil_cooling_healing)
        ToggleButton tgbFanCoilCoolingHealingSystem;


        //@BindView(R.id.tgb_central_engine_room_cooling_healing)
        ToggleButton tgbCentralEngineRoomCoolingHealingSystem;


        //@BindView(R.id.tgb_floor_heating_cooling_healing)
        ToggleButton tgbFloorHeatingCoolingHealingSystem;


        //@BindView(R.id.tgb_air_conditioner_cooling_healing)
        ToggleButton tgbAirConditionerCoolingHealingSystem;


        //@BindView(R.id.tgb_gas_cooler_cooling_healing)
        ToggleButton tgbGasCoolerCoolingHealingSystem;


        //@BindView(R.id.tgb_stone_floor_covering_type)
        ToggleButton tgbStoneFloorCovering;


        //@BindView(R.id.tgb_carpet_floor_covering_type)
        ToggleButton tgbCarpetFloorCovering;


        //@BindView(R.id.tgb_parquet_floor_covering_type)
        ToggleButton tgbParquetFloorCovering;


        //@BindView(R.id.tgb_mosaic_floor_covering_type)
        ToggleButton tgbMosaicFloorCovering;


        //@BindView(R.id.tgb_asphalt_floor_covering_type)
        ToggleButton tgbAsphaltFloorCovering;


        //@BindView(R.id.tgb_ceramic_floor_covering_type)
        ToggleButton tgbCeramicFloorCovering;


        //@BindView(R.id.tgb_laminat_floor_covering_type)
        ToggleButton tabLaminatFloorCovering;


        //@BindView(R.id.tgb_wood_floor_covering_type)
        ToggleButton tgbWoodFloorCovering;


        //@BindView(R.id.tgb_granite_floor_covering_type)
        ToggleButton tgbGraniteFloorCovering;


        //@BindView(R.id.tgb_cement_floor_covering_type)
        ToggleButton tgbCementFloorCovering;


        //@BindView(R.id.tgb_konteks_building_facades)
        ToggleButton tgbKonteksBuildingFacades;


        //@BindView(R.id.tgb_aluminum_building_facades)
        ToggleButton tgbAluminumBuildingFacades;


        //@BindView(R.id.tgb_brick_facade_building_facades)
        ToggleButton tgbBrickBuildingFacades;


        //@BindView(R.id.tgb_cement_building_facades)
        ToggleButton tgbCementBuildingFacades;


        //@BindView(R.id.tgb_wood_building_facades)
        ToggleButton tgbWoodBuildingFacades;


        //@BindView(R.id.tgb_stone_building_facades)
        ToggleButton tgbStoneBuildingFacades;


        //@BindView(R.id.tgb_ceramic_building_facades)
        ToggleButton tgbCeramicBuildingFacades;


        //@BindView(R.id.tgb_glass_building_facades)
        ToggleButton tgbGlassBuildingFacades;


        //@BindView(R.id.tgb_composite_building_facades)
        ToggleButton tgbCompositeBuildingFacades;


        //@BindView(R.id.tgb_hi_glass_kitchen_cabinets)
        ToggleButton tgbHiGlassKitchenCabinets;


        //@BindView(R.id.tgb_hdf_kitchen_cabinets)
        ToggleButton tgbHdfKitchenCabinets;


        //@BindView(R.id.tgb_metal_kitchen_cabinets)
        ToggleButton tgbMetalKitchenCabinets;


        //@BindView(R.id.tgb_mdf_kitchen_cabinets)
        ToggleButton tgbMdfKitchenCabinets;


        //@BindView(R.id.tgb_wood_kitchen_cabinets)
        ToggleButton tgbWoodKitchenCabinets;


        //@BindView(R.id.tgb_gentle_windows_type)
        ToggleButton tgbGentleWindowsType;


        //@BindView(R.id.tgb_pvc_two_shells_windows_type)
        ToggleButton tgbPvcTwoShellsWindowsType;


        //@BindView(R.id.tgb_metal_windows_type)
        ToggleButton tgbMetalWindowsType;


        //@BindView(R.id.tgb_wood_windows_type)
        ToggleButton tgbWoodWindowsType;


        //@BindView(R.id.tgb_metal_two_shells_windows_type)
        ToggleButton tgbMetalTwoShellsWindowsType;


        //@BindView(R.id.tgb_tower_building_type)
        ToggleButton tgbTowerBuildingType;


        //@BindView(R.id.tgb_passage_building_type)
        ToggleButton tgbPassageBuildingType;


        //@BindView(R.id.tgb_villa_building_type)
        ToggleButton tgbVillaBuildingType;


        //@BindView(R.id.tgb_apartment_building_type)
        ToggleButton tgbApartmentBuildingType;


        //@BindView(R.id.tgb_integrated_building_type)
        ToggleButton tgbIntegratedBuildingType;


        //@BindView(R.id.tgb_lake_view)
        ToggleButton tgbLakeView;


        //@BindView(R.id.tgb_jangle_view)
        ToggleButton tgbJangleView;


        //@BindView(R.id.tgb_city_view)
        ToggleButton tgbCityView;


        //@BindView(R.id.tgb_panorama_view)
        ToggleButton tgbPanoramaView;


        //@BindView(R.id.tgb_park_view)
        ToggleButton tgbParkView;


        //@BindView(R.id.tgb_mountain_room_view)
        ToggleButton tgbMountainView;


        //@BindView(R.id.tgb_sea_view)
        ToggleButton tgbSeaView;


        //@BindView(R.id.tgb_river_view)
        ToggleButton tgbRiverView;


        //@BindView(R.id.tgb_sky_view)
        ToggleButton tgbSkyView;


        //@BindView(R.id.tgb_library_room_type)
        ToggleButton tgbLibraryRoomType;


        //@BindView(R.id.tgb_dressing_room_type)
        ToggleButton tgbDressingRoomType;


        //@BindView(R.id.tgb_dining_room_type)
        ToggleButton tgbDiningRoomType;


        //@BindView(R.id.tgb_workshop_room_type)
        ToggleButton tgbWorkShopRoomType;


        //@BindView(R.id.tgb_work_room_type)
        ToggleButton tgbWorkRoomType;


        //@BindView(R.id.tgb_home_lollipop_room_type)
        ToggleButton tgbHomeLollipopRoomType;


        private ChildViewHolder(final ViewGroup convertView) {
            DatePickerDialog.OnDateSetListener dateListener = this;


            ButterKnife.bind(this, convertView);
            ButterKnife.setDebug(true);


            final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            createAlertDialogMelUsageType(builder, convertView);
            createAlertDialogSpecialFeatures(builder, convertView);
            createAlertDialogTypeOfMelkDocument(builder, convertView);
            createAlertDialogFloorCovering(builder, convertView);
            createAlertDialogCoolingHealingSystem(builder, convertView);
            createAlertDialogBuildingFacades(builder, convertView);
            createAlertDialogKitchenCabinets(builder, convertView);
            createAlertDialogWindowsType(builder, convertView);
            createAlertDialogBuildingType(builder, convertView);
            createAlertDialogView(builder, convertView);
            createAlertDialogRoomType(builder, convertView);
            createAlertDialogFurnishedFacilities(builder, convertView);
            createAlertDialogMelkGallary(convertView);

            ButterKnife.bind(this, convertView);
            ButterKnife.setDebug(true);

            hpFloorNumber.setSelectedItem(5);
            changeFontTypOfTgb(tgbFlatUnitType);
            changeFontTypOfTgb(tabDoubleUnitType);
            changeFontTypOfTgb(tgbTriplexUnitType);
            changeFontTypOfTgb(tgbBeachMelkPositions);
            changeFontTypOfTgb(tgbJangleMelkPositions);
            changeFontTypOfTgb(tgbMountainMelkPositions);
            changeFontTypOfTgb(tgbTownshipMelkPositions);
            changeFontTypOfTgb(tgbNorthGeoPosition);
            changeFontTypOfTgb(tgbSouthGeoPosition);
            changeFontTypOfTgb(tgbWestGeoPosition);
            changeFontTypOfTgb(tgbEstGeoPosition);
            changeFontTypOfTgb(tgbMetalStructType);
            changeFontTypOfTgb(tgbBlotsButsStructType);
            changeFontTypOfTgb(tgbConcreteAndBarStructType);
            changeFontTypOfTgb(tgbNorthLightingDirect);
            changeFontTypOfTgb(tgbSoughtLightingDirect);
            changeFontTypOfTgb(tgbWestLightingDirect);
            changeFontTypOfTgb(tgbEstLightingDirect);
            changeFontTypOfTgb(tgbOnePhaseElectric);
            changeFontTypOfTgb(tgbThreePhaseElectric);
            changeFontTypOfTgb(tgbPrivateElectric);
            changeFontTypOfTgb(tgbShareElectric);
            changeFontTypOfTgb(tgbPrivateGasMeter);
            changeFontTypOfTgb(tgbShareGasMeter);
            changeFontTypOfTgb(tgbPrivateWaterMeter);
            changeFontTypOfTgb(tgbShareWaterMeter);

            changeFontTypOfTgbLinear(llPossibilitiesLeft);
            changeFontTypOfTgbLinear(llPossibilitiesCenter);
            changeFontTypOfTgbLinear(llPossibilitiesRight);

            changeFontTypOfTgbLinear(llSpecialFeaturesLeft);
            changeFontTypOfTgbLinear(llSpecialFeaturesRight);

            changeFontTypOfTgbLinear(llTypeOfMelkDocumentLeft);
            changeFontTypOfTgbLinear(llTypeOfMelkDocumentRight);

            changeFontTypOfTgbLinear(llCoolingHealingSystemLeft);
            changeFontTypOfTgbLinear(llCoolingHealingSystemRight);

            changeFontTypOfTgbLinear(llFloorCoveringTypeLeft);
            changeFontTypOfTgbLinear(llFloorCoveringTypeRight);

            changeFontTypOfTgbLinear(llBuildingFacadesLeft);
            changeFontTypOfTgbLinear(llBuildingFacadesRight);

            changeFontTypOfTgbLinear(llKitchenCabinetsLeft);
            changeFontTypOfTgbLinear(llKitchenCabinetsRight);

            changeFontTypOfTgbLinear(llWindowsTypeLeft);
            changeFontTypOfTgbLinear(llWindowsTypeRight);

            changeFontTypOfTgbLinear(llBuildingTypeLeft);
            changeFontTypOfTgbLinear(llBuildingTypeRight);

            changeFontTypOfTgbLinear(llViewLeft);
            changeFontTypOfTgbLinear(llViewRight);

            changeFontTypOfTgbLinear(llRoomTypeLeft);
            changeFontTypOfTgbLinear(llRoomTypeRight);

            changeFontTypOfTgbLinear(llFurnishedFacilitiesLeft);
            changeFontTypOfTgbLinear(llFurnishedFacilitiesRight);


            setArrayToSpinners(spTransType, R.array.array_trans_type);
            setArrayToSpinners(spMelkType, R.array.array_combo_melk_type_sell_and_rent);


            PersianCalendar persianCalendar = new PersianCalendar();
            datePickerDialog = DatePickerDialog.newInstance(
                    dateListener,
                    persianCalendar.getPersianYear(),
                    persianCalendar.getPersianMonth(),
                    persianCalendar.getPersianDay()
            );


            edtMoreInfo.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    if (edtMoreInfo.hasFocus()) {
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        switch (event.getAction() & MotionEvent.ACTION_MASK) {
                            case MotionEvent.ACTION_SCROLL:
                                v.getParent().requestDisallowInterceptTouchEvent(false);
                                return true;
                        }
                    }
                    return false;
                }
            });

            edtOwnerInformation.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    if (edtOwnerInformation.hasFocus()) {
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        switch (event.getAction() & MotionEvent.ACTION_MASK) {
                            case MotionEvent.ACTION_SCROLL:
                                v.getParent().requestDisallowInterceptTouchEvent(false);
                                return true;
                        }
                    }
                    return false;
                }
            });

            edtInstallmentTerms.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    if (edtInstallmentTerms.hasFocus()) {
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        switch (event.getAction() & MotionEvent.ACTION_MASK) {
                            case MotionEvent.ACTION_SCROLL:
                                v.getParent().requestDisallowInterceptTouchEvent(false);
                                return true;
                        }
                    }
                    return false;
                }
            });


        }

        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
            int mount = monthOfYear + 1;
            String strGetDateFromCalendar = year + "/" + mount + "/" + dayOfMonth;

            if (swDateOfQuit != null && txtDateOfQuit != null) {
                txtDateOfQuit.setText(strGetDateFromCalendar);
                currentItem.setTxtDateOfQuitValue(strGetDateFromCalendar);

                if (!strGetDateFromCalendar.contentEquals("") || !txtDateOfQuit.getText().toString().contentEquals("")) {
                    swDateOfQuit.setChecked(false);
                    currentItem.setSwDateOfQuitValue(false);
                }

            }

        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


        }

        private void changeFontTypOfTgbLinear(LinearLayout linear) {
            if (linear != null) {
                for (int i = 0; i <= linear.getChildCount(); i++) {
                    ToggleButton toggleButton = (ToggleButton) linear.getChildAt(i);
                    if (toggleButton != null) {
                        toggleButton.setTypeface(shabnamFont);
                        toggleButton.setTextSize(10);
                    }
                }
            }
        }

        private void changeFontTypOfTgb(ToggleButton toggleButton) {
            if (toggleButton != null) {
                toggleButton.setTypeface(shabnamFont);
                toggleButton.setTextSize(10);
            }
        }


        private void fill(final MyExpandableListAdapter expendableAdapter, final Group item, int groupPosition, View root) {
            actionSpinnerTransActionType(item);
            actionSpinnerHomeType(item);


//            setCommaForEdittexts(edtMelkArea);
//            setCommaForEdittexts(edtAmountSellPerMetric);
//            setCommaForEdittexts(edtAmountSell);
//            setCommaForEdittexts(edtAmountRahn);
//            setCommaForEdittexts(edtAmountRent);
//            setCommaForEdittexts(edtSinceQuantity);
//            setCommaForEdittexts(edtAmountLoan);
//            setCommaForEdittexts(edtAmountMountCharge);


            spTransType.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    spTransType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            actionSpinnerTransActionType(item);
                            if (spTransType.getSelectedItemPosition() == 2) {
                                setArrayToSpinners(spMelkType, R.array.array_combo_melk_type_partnership);
                            } else {
                                setArrayToSpinners(spMelkType, R.array.array_combo_melk_type_sell_and_rent);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    return false;
                }
            });

            spMelkType.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    spMelkType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            actionSpinnerHomeType(item);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    return false;
                }
            });


            edtInstallmentTerms.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!s.toString().contentEquals("")) {
                        swInstallment.setChecked(true);
                    } else {
                        swInstallment.setChecked(false);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            if (item.isSwInstallmentValue()) {
                linearInstallmentTerms.setVisibility(View.VISIBLE);
            } else {
                linearInstallmentTerms.setVisibility(View.GONE);
            }


            swInstallment.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    Switch mSwitch = (Switch) v;

                    if (!mSwitch.isChecked()) {
                        edtInstallmentTerms.setText("");
                        linearInstallmentTerms.setVisibility(View.GONE);
                    } else {
                        linearInstallmentTerms.setVisibility(View.VISIBLE);
                    }
                }
            });

            edtAmountLoan.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean hasFocus) {
                    if (!hasFocus) {
                        EditText amountVam = (EditText) view;
                        if (amountVam.getText().toString().contentEquals("")) {
                            swHasLoan.setChecked(false);
                        }
                    }
                }
            });


            swDateOfQuit.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Switch caption = (Switch) view;
                    if (caption.isChecked()) {
                        txtDateOfQuit.setText(activity.getString(R.string.str_enter_date_of_discharge));
                    }
                }
            });


            swHasLoan.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Switch caption = (Switch) view;
                    if (!caption.isChecked()) {
                        edtAmountLoan.setText("");
                    }
                }
            });
            edtAmountLoan.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().contentEquals("")) {
                        swHasLoan.setChecked(false);
                    } else {
                        swHasLoan.setChecked(true);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


            tgbFlatUnitType.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    tgbTriplexUnitType.setChecked(false);
                    tabDoubleUnitType.setChecked(false);
                }
            });
            tabDoubleUnitType.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    tgbFlatUnitType.setChecked(false);
                    tgbTriplexUnitType.setChecked(false);
                }
            });

            tgbTriplexUnitType.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    tgbFlatUnitType.setChecked(false);
                    tabDoubleUnitType.setChecked(false);
                }
            });


            txtDateOfQuit.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    datePickerDialog.show(activity.getFragmentManager(), DIALOG_TAG);
                }

            });
            tgbGoodwill.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    tgbProperty.setChecked(false);
                }

            });
            tgbProperty.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    tgbGoodwill.setChecked(false);
                }

            });


            if (item.isTgbOnePhaseElectricValue() || item.isTgbThreePhaseElectricValue()) {
                hideLinearShareAndPrivateElectricMeter(true);
            } else {
                hideLinearShareAndPrivateElectricMeter(false);
            }

            tgbThreePhaseElectric.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    hideLinearShareAndPrivateElectricMeter(caption.isChecked());
                    tgbOnePhaseElectric.setChecked(false);
                }
            });


            tgbOnePhaseElectric.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    hideLinearShareAndPrivateElectricMeter(caption.isChecked());
                    tgbThreePhaseElectric.setChecked(false);
                }
            });


            tgbShareElectric.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    tgbPrivateElectric.setChecked(false);
                }
            });

            tgbPrivateElectric.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    tgbShareElectric.setChecked(false);
                }
            });

            tgbShareGasMeter.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    tgbPrivateGasMeter.setChecked(false);
                }
            });

            tgbPrivateGasMeter.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    tgbShareGasMeter.setChecked(false);
                }
            });

            tgbShareWaterMeter.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    tgbPrivateWaterMeter.setChecked(false);
                }
            });

            tgbPrivateWaterMeter.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    tgbShareWaterMeter.setChecked(false);
                }
            });


            tgbPersonalTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbEndowmentsTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbCommercialTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbShariRulerTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbOrganizationalTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbOfficialTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbCooperativeTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbProxyTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbLetterOfCreditTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbJointlyTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbResidentialTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });
            tgbIndustrialTypeOfMelkDocument.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton caption = (ToggleButton) v;
                    deSelecteOtherTgb(llTypeOfMelkDocumentLeft, caption);
                    deSelecteOtherTgb(llTypeOfMelkDocumentRight, caption);
                }
            });


        }

        private void deSelecteOtherTgb(LinearLayout linear, ToggleButton caption) {
            if (linear != null) {
                for (int i = 0; i <= linear.getChildCount(); i++) {
                    ToggleButton toggleButton = (ToggleButton) linear.getChildAt(i);
                    if (toggleButton != null) {
                        if (toggleButton.getId() != caption.getId()) {
                            toggleButton.setChecked(false);

                        }
                        if (toggleButton.isChecked()) {
                            txtPlusMelkDocType.setText(toggleButton.getText());
                        }
                    }
                }
            }
        }

        private void hideLinearShareAndPrivateElectricMeter(boolean isChecked) {
            if (!isChecked) {
                tgbShareElectric.setVisibility(View.GONE);
                tgbPrivateElectric.setVisibility(View.GONE);

                tgbShareElectric.setChecked(false);
                tgbPrivateElectric.setChecked(false);
            } else {
                tgbShareElectric.setVisibility(View.VISIBLE);
                tgbPrivateElectric.setVisibility(View.VISIBLE);
            }
        }

        private void createAlertDialogSpecialFeatures(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderSpecialFeatures = builder.create();


            final DialogSpecialFeaturesBinding specialFeaturesBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_special_features, convertView, false);
            final View specialFeaturesView = specialFeaturesBinding.getRoot();

            tgbLobbySpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_lobby_special_features);
            tgbBathtubSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_bathtub_special_features);
            tgbSwimmingPoolSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_swimming_pool_special_features);
            tgbFirePlaceSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_fireplace_special_features);
            tgbChildrenPlaySpaceSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_children_play_space_special_features);
            tgbGardenYardSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_garden_yard__special_features);
            tgbCentralVacuumCleanerSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_central_vacuum_cleaner_special_features);
            tgbAmphitheaterSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_amphitheater_special_features);
            tgbConferenceHallSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_conference_hall_special_features);
            tgbFirefightSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_firefight_special_features);
            tgbSolarBatterySpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_solar_battery_special_features);
            tgbFountainSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_fountain_special_features);
            tgbCargoElevatorSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_cargo_elevator_special_features);
            tgbWaterSupplySpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_water_supply_special_features);
            tgbTennisCourtSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_tennis_court_special_features);
            tgbGuestParkingSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_guest_parking_special_features);

            tgbSaunaSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_sauna_special_features);
            tgbJacuzziSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_jacuzzi_special_features);
            tgbChildrenPoolSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_children_pool_special_features);
            tgbRoofGardenSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_roof_garden_special_features);
            tgbBarbecueSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_barbecue_special_features);
            tgbShootingWasteSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_shooting_waste_special_features);
            tgbAltarSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_altar_special_features);
            tgbSecuritySystemSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_security_system_special_features);
            tgbSmartHomeSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_smart_home_special_features);
            tgbSafeguardSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_safeguard_special_features);
            tgbEmergencyPowerSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_emergency_power_special_features);
            tgbCaretakersRoomSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_caretakers_room_special_features);
            tgbSecurityDoorSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_security_door_special_features);
            tgbWaterPurifierSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_water_purifier_special_features);
            tgbParkingRemoteSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_parking_remote_special_features);
            tgbPoolTableSpecialFeatures = specialFeaturesView.findViewById(R.id.tgb_pool_table_special_features);

            rlPlusSpecialFeature.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    specialFeaturesBinding.setSpecialFeatures(currentItem);
                    showDialog(finalBuilderSpecialFeatures, specialFeaturesView);

                }
            });
            final Button btnConfirmDialogSpecialFeatures = specialFeaturesView.findViewById(R.id.btn_confirm_dialog_special_features);
            dismissDialog(finalBuilderSpecialFeatures, btnConfirmDialogSpecialFeatures);
        }

        private void createAlertDialogMelUsageType(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderUsageType = builder.create();
//            final DialogMelkUsageTypeBinding usageTypeBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_melk_usage_type, convertView, false);
//            final View usageMelkTypeView = usageTypeBinding.getRoot();
            final View usageMelkTypeView = inflater.inflate(R.layout.dialog_melk_usage_type, convertView, false);

            llUsageTypeLeft = usageMelkTypeView.findViewById(R.id.ll_usage_type_left);
            llUsageTypeRight = usageMelkTypeView.findViewById(R.id.ll_usage_type_right);

            tgbOfficialUsageType = usageMelkTypeView.findViewById(R.id.tgb_official_usage_type);
            tgbCommercialUsageType = usageMelkTypeView.findViewById(R.id.tgb_commercial_usage_type);
            tgbIndustrialUsageType = usageMelkTypeView.findViewById(R.id.tgb_industrial_usage_type);
            tgbStoreUsageType = usageMelkTypeView.findViewById(R.id.tgb_store_usage_type);
            tgbAnimalHusbandryUsageType = usageMelkTypeView.findViewById(R.id.tgb_animal_husbandry_usage_type);
            tgbEducationalUsageType = usageMelkTypeView.findViewById(R.id.tgb_educational_usage_type);

            tgbResidentialUsageType = usageMelkTypeView.findViewById(R.id.tgb_residential_usage_type);
            tgbAdministrativePositionUsageType = usageMelkTypeView.findViewById(R.id.tgb_administrative_position_usage_type);
            tgbResidentUsageType = usageMelkTypeView.findViewById(R.id.tgb_resident_usage_type);
            tgbAgricultureUsageType = usageMelkTypeView.findViewById(R.id.tgb_agriculture_usage_type);
            tgbSportsUsageType = usageMelkTypeView.findViewById(R.id.tgb_sports_usage_type);
            tgbClinicUsageType = usageMelkTypeView.findViewById(R.id.tgb_clinic_usage_type);

            relativeUsageType.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
//                    usageTypeBinding.setMelkUsageType(currentItem);
                    showDialog(finalBuilderUsageType, usageMelkTypeView);
                }
            });

            final Button btnConfirmDialogMelkUsage = usageMelkTypeView.findViewById(R.id.btn_confirm_dialog_melk_usage_type);
            dismissDialog(finalBuilderUsageType, btnConfirmDialogMelkUsage);


        }


        private void createAlertDialogTypeOfMelkDocument(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderTypeOfDocument = builder.create();


            final DialogTypeOfMelkDocumentBinding melkDocumentBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_type_of_melk_document, convertView, false);
            final View typeOfDocumentView = melkDocumentBinding.getRoot();


            tgbPersonalTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_personal_type_of_melk_document);
            tgbEndowmentsTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_endowments_type_of_melk_document);
            tgbCommercialTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_commercial_type_of_melk_document);
            tgbShariRulerTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_shari_ruler_type_of_melk_document);
            tgbOrganizationalTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_organizational_type_of_melk_document);
            tgbOfficialTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_official_type_of_melk_document);

            tgbCooperativeTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_cooperative_type_of_melk_document);
            tgbProxyTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_proxy_type_of_melk_document);
            tgbLetterOfCreditTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_letter_of_credit_type_of_melk_document);
            tgbJointlyTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_jointly_type_of_melk_document);
            tgbResidentialTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_residential_type_of_melk_document);
            tgbIndustrialTypeOfMelkDocument = typeOfDocumentView.findViewById(R.id.tgb_industrial_type_of_melk_document);


            rlPlusMelkDocType.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    melkDocumentBinding.setMelkDocument(currentItem);
                    showDialog(finalBuilderTypeOfDocument, typeOfDocumentView);

                }
            });

            final Button btnConfirmDialogTypeOfDocument = typeOfDocumentView.findViewById(R.id.btn_confirm_dialog_type_of_melk_document);
            dismissDialog(finalBuilderTypeOfDocument, btnConfirmDialogTypeOfDocument);


        }


        private void createAlertDialogFloorCovering(AlertDialog.Builder builder, ViewGroup convertView) {


            final AlertDialog finalBuilderFloorCovering = builder.create();

            final DialogFloorCoveringTypeBinding coveringTypeBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_floor_covering_type, convertView, false);
            final View floorCoveringView = coveringTypeBinding.getRoot();


            final Button btnPlusDialogFloorCovering = convertView.findViewById(R.id.btn_plus_floor_covering);

            tgbStoneFloorCovering = floorCoveringView.findViewById(R.id.tgb_stone_floor_covering_type);
            tgbCarpetFloorCovering = floorCoveringView.findViewById(R.id.tgb_carpet_floor_covering_type);
            tgbParquetFloorCovering = floorCoveringView.findViewById(R.id.tgb_parquet_floor_covering_type);
            tgbMosaicFloorCovering = floorCoveringView.findViewById(R.id.tgb_mosaic_floor_covering_type);
            tgbAsphaltFloorCovering = floorCoveringView.findViewById(R.id.tgb_asphalt_floor_covering_type);

            tgbCeramicFloorCovering = floorCoveringView.findViewById(R.id.tgb_ceramic_floor_covering_type);
            tabLaminatFloorCovering = floorCoveringView.findViewById(R.id.tgb_laminat_floor_covering_type);
            tgbWoodFloorCovering = floorCoveringView.findViewById(R.id.tgb_wood_floor_covering_type);
            tgbGraniteFloorCovering = floorCoveringView.findViewById(R.id.tgb_granite_floor_covering_type);
            tgbCementFloorCovering = floorCoveringView.findViewById(R.id.tgb_cement_floor_covering_type);


            rlPlusFloorCoverType.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    coveringTypeBinding.setFloorCovering(currentItem);
                    showDialog(finalBuilderFloorCovering, floorCoveringView);
                }
            });

            final Button btnConfirmDialogFloorCovering = floorCoveringView.findViewById(R.id.btn_confirm_dialog_floor_covering);
            dismissDialog(finalBuilderFloorCovering, btnConfirmDialogFloorCovering);


        }

        private void createAlertDialogCoolingHealingSystem(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderCoolingHealing = builder.create();

            final DialogCoolingHealingSystemBinding healingSystemBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_cooling_healing_system, convertView, false);
            final View coolingHealingSystemView = healingSystemBinding.getRoot();

            tgbPackageCoolingHealingSystem = coolingHealingSystemView.findViewById(R.id.tgb_package_cooling_healing);
            tgbHeaterCoolingHealingSystem = coolingHealingSystemView.findViewById(R.id.tgb_heater_cooling_healing);
            tgbChillerCoolingHealingSystem = coolingHealingSystemView.findViewById(R.id.tgb_chiller_cooling_healing);
            tgbWaterCoolerCoolingHealingSystem = coolingHealingSystemView.findViewById(R.id.tgb_water_cooler_cooling_healing);
            tgbFanCoilCoolingHealingSystem = coolingHealingSystemView.findViewById(R.id.tgb_fan_coil_cooling_healing);

            tgbCentralEngineRoomCoolingHealingSystem = coolingHealingSystemView.findViewById(R.id.tgb_central_engine_room_cooling_healing);
            tgbFloorHeatingCoolingHealingSystem = coolingHealingSystemView.findViewById(R.id.tgb_floor_heating_cooling_healing);
            tgbAirConditionerCoolingHealingSystem = coolingHealingSystemView.findViewById(R.id.tgb_air_conditioner_cooling_healing);
            tgbGasCoolerCoolingHealingSystem = coolingHealingSystemView.findViewById(R.id.tgb_gas_cooler_cooling_healing);


            rlPlusCoolingHealingSystem.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    healingSystemBinding.setCoolingHealing(currentItem);
                    showDialog(finalBuilderCoolingHealing, coolingHealingSystemView);

                }
            });
            final Button btnConfirmDialogCoolingHealing = coolingHealingSystemView.findViewById(R.id.btn_confirm_dialog_cooling_healing_system);
            dismissDialog(finalBuilderCoolingHealing, btnConfirmDialogCoolingHealing);


        }

        private void createAlertDialogBuildingFacades(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderBuildingFacades = builder.create();


            final DialogBuildingFacadesBinding buildingFacadesBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_building_facades, convertView, false);
            final View BuildingFacadesView = buildingFacadesBinding.getRoot();


            tgbKonteksBuildingFacades = BuildingFacadesView.findViewById(R.id.tgb_konteks_building_facades);
            tgbAluminumBuildingFacades = BuildingFacadesView.findViewById(R.id.tgb_aluminum_building_facades);
            tgbBrickBuildingFacades = BuildingFacadesView.findViewById(R.id.tgb_brick_facade_building_facades);
            tgbCementBuildingFacades = BuildingFacadesView.findViewById(R.id.tgb_cement_building_facades);
            tgbWoodBuildingFacades = BuildingFacadesView.findViewById(R.id.tgb_wood_building_facades);
            tgbStoneBuildingFacades = BuildingFacadesView.findViewById(R.id.tgb_stone_building_facades);
            tgbCeramicBuildingFacades = BuildingFacadesView.findViewById(R.id.tgb_ceramic_building_facades);
            tgbGlassBuildingFacades = BuildingFacadesView.findViewById(R.id.tgb_glass_building_facades);
            tgbCompositeBuildingFacades = BuildingFacadesView.findViewById(R.id.tgb_composite_building_facades);

            rlPlusBuildingFacades.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    buildingFacadesBinding.setBuildingFacades(currentItem);
                    showDialog(finalBuilderBuildingFacades, BuildingFacadesView);
                }
            });


            final Button btnConfirmBuildingFacades = BuildingFacadesView.findViewById(R.id.btn_confirm_dialog_building_facades);
            dismissDialog(finalBuilderBuildingFacades, btnConfirmBuildingFacades);


        }

        private void createAlertDialogKitchenCabinets(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderKitchenCabinets = builder.create();


            final DialogKitckenCabinetsBinding cabinetsBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_kitcken_cabinets, convertView, false);
            final View kitchenCabinetsView = cabinetsBinding.getRoot();


            tgbHiGlassKitchenCabinets = kitchenCabinetsView.findViewById(R.id.tgb_hi_glass_kitchen_cabinets);
            tgbHdfKitchenCabinets = kitchenCabinetsView.findViewById(R.id.tgb_hdf_kitchen_cabinets);
            tgbMetalKitchenCabinets = kitchenCabinetsView.findViewById(R.id.tgb_metal_kitchen_cabinets);
            tgbMdfKitchenCabinets = kitchenCabinetsView.findViewById(R.id.tgb_mdf_kitchen_cabinets);
            tgbWoodKitchenCabinets = kitchenCabinetsView.findViewById(R.id.tgb_wood_kitchen_cabinets);

            rlPlusKitchenCabinets.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    cabinetsBinding.setKitchenCabinets(currentItem);
                    showDialog(finalBuilderKitchenCabinets, kitchenCabinetsView);
                }
            });


            final Button btnConfirmKitchenCabinets = kitchenCabinetsView.findViewById(R.id.btn_confirm_dialog_kitchen_cabinets);
            dismissDialog(finalBuilderKitchenCabinets, btnConfirmKitchenCabinets);


        }

        private void createAlertDialogWindowsType(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderWindowsType = builder.create();

            final DialogWindowsTypeBinding windowsTypeBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_windows_type, convertView, false);
            final View windowsTypeView = windowsTypeBinding.getRoot();


            tgbGentleWindowsType = windowsTypeView.findViewById(R.id.tgb_gentle_windows_type);
            tgbPvcTwoShellsWindowsType = windowsTypeView.findViewById(R.id.tgb_pvc_two_shells_windows_type);
            tgbMetalWindowsType = windowsTypeView.findViewById(R.id.tgb_metal_windows_type);
            tgbWoodWindowsType = windowsTypeView.findViewById(R.id.tgb_wood_windows_type);
            tgbMetalTwoShellsWindowsType = windowsTypeView.findViewById(R.id.tgb_metal_two_shells_windows_type);


            rlPlusWindowsType.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    windowsTypeBinding.setWindowsType(currentItem);
                    showDialog(finalBuilderWindowsType, windowsTypeView);
                }
            });

            final Button btnConfirmWindowsType = windowsTypeView.findViewById(R.id.btn_confirm_dialog_windows_type);
            dismissDialog(finalBuilderWindowsType, btnConfirmWindowsType);


        }

        private void createAlertDialogBuildingType(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderBuildingType = builder.create();

            final DialogBuildingTypeBinding buildingTypeBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_building_type, convertView, false);
            final View buildingTypeView = buildingTypeBinding.getRoot();


            tgbPassageBuildingType = buildingTypeView.findViewById(R.id.tgb_passage_building_type);
            tgbVillaBuildingType = buildingTypeView.findViewById(R.id.tgb_villa_building_type);
            tgbTowerBuildingType = buildingTypeView.findViewById(R.id.tgb_tower_building_type);
            tgbApartmentBuildingType = buildingTypeView.findViewById(R.id.tgb_apartment_building_type);
            tgbIntegratedBuildingType = buildingTypeView.findViewById(R.id.tgb_integrated_building_type);

            rlPlusBuildingType.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    buildingTypeBinding.setBuildingType(currentItem);
                    showDialog(finalBuilderBuildingType, buildingTypeView);
                }
            });

            final Button btnConfirmBuildingType = buildingTypeView.findViewById(R.id.btn_confirm_dialog_building_type);
            dismissDialog(finalBuilderBuildingType, btnConfirmBuildingType);


        }

        private void createAlertDialogView(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderView = builder.create();

            final DialogViewBinding viewBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_view, convertView, false);
            final View dialogView = viewBinding.getRoot();

            tgbLakeView = dialogView.findViewById(R.id.tgb_lake_view);
            tgbJangleView = dialogView.findViewById(R.id.tgb_jangle_view);
            tgbCityView = dialogView.findViewById(R.id.tgb_city_view);
            tgbPanoramaView = dialogView.findViewById(R.id.tgb_panorama_view);
            tgbParkView = dialogView.findViewById(R.id.tgb_park_view);
            tgbMountainView = dialogView.findViewById(R.id.tgb_mountain_room_view);
            tgbSeaView = dialogView.findViewById(R.id.tgb_sea_view);
            tgbRiverView = dialogView.findViewById(R.id.tgb_river_view);
            tgbSkyView = dialogView.findViewById(R.id.tgb_sky_view);


            rlPlusMelkView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewBinding.setView(currentItem);
                    showDialog(finalBuilderView, dialogView);
                }
            });

            final Button btnConfirmView = dialogView.findViewById(R.id.btn_confirm_dialog_view);
            dismissDialog(finalBuilderView, btnConfirmView);


        }

        private void createAlertDialogRoomType(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderRoomType = builder.create();


            final DialogRoomTypeBinding roomTypeBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_room_type, convertView, false);
            final View dialogRoomType = roomTypeBinding.getRoot();


            tgbLibraryRoomType = dialogRoomType.findViewById(R.id.tgb_library_room_type);
            tgbDressingRoomType = dialogRoomType.findViewById(R.id.tgb_dressing_room_type);
            tgbDiningRoomType = dialogRoomType.findViewById(R.id.tgb_dining_room_type);

            tgbWorkShopRoomType = dialogRoomType.findViewById(R.id.tgb_workshop_room_type);
            tgbWorkRoomType = dialogRoomType.findViewById(R.id.tgb_work_room_type);
            tgbHomeLollipopRoomType = dialogRoomType.findViewById(R.id.tgb_home_lollipop_room_type);


            rlPlusTypeOfRooms.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    roomTypeBinding.setRoomType(currentItem);
                    showDialog(finalBuilderRoomType, dialogRoomType);


                }
            });

            final Button btnConfirmRoomType = dialogRoomType.findViewById(R.id.btn_confirm_dialog_room_type);
            dismissDialog(finalBuilderRoomType, btnConfirmRoomType);


        }

        private void createAlertDialogFurnishedFacilities(AlertDialog.Builder builder, ViewGroup convertView) {
            final AlertDialog finalBuilderFurnishedFacilities = builder.create();


            final DialogFurnishedFacilitiesBinding furnishedFacilitiesBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_furnished_facilities, convertView, false);
            final View dialogFurnishedFacilities = furnishedFacilitiesBinding.getRoot();


            rlPlusFurnishedFacilities.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    furnishedFacilitiesBinding.setFurnishedFacilities(currentItem);
                    showDialog(finalBuilderFurnishedFacilities, dialogFurnishedFacilities);
                }
            });

            final Button btnConfirmFurnishedFacilities = dialogFurnishedFacilities.findViewById(R.id.btn_confirm_dialog_furnished_facilities);
            dismissDialog(finalBuilderFurnishedFacilities, btnConfirmFurnishedFacilities);


        }

        private void showDialog(final AlertDialog mBuilder, final View mView) {
            mBuilder.setView(mView);
            mBuilder.show();

        }

        private void dismissDialog(final AlertDialog mBuilder, Button btnConfirmDialog) {
            if (btnConfirmDialog != null) {
                btnConfirmDialog.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBuilder.dismiss();

                    }
                });
            }
        }


        private void createAlertDialogMelkGallary(final ViewGroup convertView) {
            final Animation showLinearHeaderGallery = AnimationUtils.loadAnimation(activity, R.anim.show_linear_header_dialog_gallery);
            final Animation hideLinearHeaderGallery = AnimationUtils.loadAnimation(activity, R.anim.hide_linear_header_dialog_gallery);

            final Animation showLinearFooterGallery = AnimationUtils.loadAnimation(activity, R.anim.show_linear_footer_dialog_gallery);
            final Animation hideLinearFooterGallery = AnimationUtils.loadAnimation(activity, R.anim.hide_linear_footer_dialog_gallery);


            final Dialog finalBuilderMelkGallary = new Dialog(activity, R.style.DialogTheme);
            final View dialogMelkGallary = inflater.inflate(R.layout.dialog_melk_gallary, null);
            finalBuilderMelkGallary.setContentView(dialogMelkGallary);

//        finalBuilderMelkGallary.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                finalBuilderMelkGallary.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }

            final ImageView imgMelk1 = convertView.findViewById(R.id.img_melk_number1);
            final ImageView imgMelk2 = convertView.findViewById(R.id.img_melk_number2);
            final ImageView imgMelk3 = convertView.findViewById(R.id.img_melk_number3);
            final ImageView imgMelk4 = convertView.findViewById(R.id.img_melk_number4);

            imgDialogMelkGallary = dialogMelkGallary.findViewById(R.id.img_dialog_melk_gallary);

            final LinearLayout linearHeaderDialogGallery = dialogMelkGallary.findViewById(R.id.linear_header_dialog_gallery);
            final LinearLayout linearFooterDialogGallery = dialogMelkGallary.findViewById(R.id.linear_footer_dialog_gallery);

            final Button btnCrop = dialogMelkGallary.findViewById(R.id.btn_crop_melk_gallary);
            final Button btnGallary = dialogMelkGallary.findViewById(R.id.btn_gallary_melk_gallary);
            final Button btnCamera = dialogMelkGallary.findViewById(R.id.btn_camera_melk_gallary);
            final Button btnMinimize = dialogMelkGallary.findViewById(R.id.btn_minimize_melk_gallary);
            final Spinner toolbar = dialogMelkGallary.findViewById(R.id.sp_toolbar_melk_gallary);


//TODO

            btnGallary.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickFromGallery();

//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
//                        && activity.checkSelfPermission(
//                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    activity.requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_ACCESS_PERMISSION_STORAGE);
//                } else {
//                    Intent intent = new Intent(Intent.ACTION_PICK,
//                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    activity.startActivityForResult(intent, GALLERY_REQUEST);
//                }
                }
            });


            btnCamera.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                            && activity.checkSelfPermission(
                            Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        activity.requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_PERMISSION_CAMERA);
                    } else {

                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        activity.startActivityForResult(cameraIntent, CAMERA_REQUEST);
                    }
                }
            });

            btnCrop.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
//                if (finalUri != null) {
////                    performCrop(finalUri);
//
//                }
                }
            });

            imgMelk1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
//                dialogMelkGallary.setAnimation(animationShowDialogGallery);
                    finalBuilderMelkGallary.show();

                }
            });

            imgMelk2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
//                final BitmapDrawable drawable = (BitmapDrawable) imgDialogMelkGallary.getDrawable();
//                final Bitmap bitmap = drawable.getBitmap();

                    finalBuilderMelkGallary.show();
                }
            });
            btnMinimize.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (linearHeaderDialogGallery.getVisibility() != View.VISIBLE && linearFooterDialogGallery.getVisibility() != View.VISIBLE) {
                        linearHeaderDialogGallery.startAnimation(showLinearHeaderGallery);
                        linearFooterDialogGallery.startAnimation(showLinearFooterGallery);

                        linearHeaderDialogGallery.setVisibility(View.VISIBLE);
                        linearFooterDialogGallery.setVisibility(View.VISIBLE);

                        linearHeaderDialogGallery.setClickable(true);
                        linearFooterDialogGallery.setClickable(true);
                    }
                    finalBuilderMelkGallary.dismiss();
                }
            });
            imgDialogMelkGallary.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (linearHeaderDialogGallery.getVisibility() == View.VISIBLE && linearFooterDialogGallery.getVisibility() == View.VISIBLE) {

                        linearHeaderDialogGallery.startAnimation(hideLinearHeaderGallery);
                        linearFooterDialogGallery.startAnimation(hideLinearFooterGallery);

                        linearHeaderDialogGallery.setVisibility(View.GONE);
                        linearFooterDialogGallery.setVisibility(View.GONE);

                    } else if (linearHeaderDialogGallery.getVisibility() != View.VISIBLE && linearFooterDialogGallery.getVisibility() != View.VISIBLE) {
                        linearHeaderDialogGallery.startAnimation(showLinearHeaderGallery);
                        linearFooterDialogGallery.startAnimation(showLinearFooterGallery);

                        linearHeaderDialogGallery.setVisibility(View.VISIBLE);
                        linearFooterDialogGallery.setVisibility(View.VISIBLE);

                        linearHeaderDialogGallery.setClickable(true);
                        linearFooterDialogGallery.setClickable(true);
                    }
                }
            });
            toolbar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ((TextView) view).setText(null);
                    if (toolbar.getSelectedItemPosition() == 1) {
//                    Toast.makeText(activity, "position1", Toast.LENGTH_LONG).show();
                        imgDialogMelkGallary.invalidate();

                        final BitmapDrawable drawable = (BitmapDrawable) imgDialogMelkGallary.getDrawable();
                        final Bitmap bitmap = drawable.getBitmap();


                        if (bitmap != null) {
//                        Toast.makeText(activity, "!null", Toast.LENGTH_LONG).show();
                            MediaStore.Images.Media.insertImage(activity.getContentResolver(), bitmap, "myImage", "KeepIt!");
                        }
                    }
                    if (toolbar.getSelectedItemPosition() == 0) {
//                    Toast.makeText(activity, "position0", Toast.LENGTH_LONG).show();
                        imgDialogMelkGallary.setImageDrawable(null);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

//        public int convertBooleanToInt(boolean myBoolean) {
//            return myBoolean ? 1 : 0;
//        }


//        private boolean convertIntToBoolean(int state) {
//            boolean value = false;
//            if (state == 0) {
//                value = false;
//            } else if (state == 1) {
//                value = true;
//            }
//            return value;
//        }


        private void setCommaForEdittexts(final EditText mEdt) {
            mEdt.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    mEdt.removeTextChangedListener(this);
                    try {
                        String givenstring = s.toString();
                        Long longval;
                        if (givenstring.contains(",")) {
                            givenstring = givenstring.replaceAll(",", "");
                        }
                        longval = Long.parseLong(givenstring);
                        DecimalFormat formatter = new DecimalFormat("#,###,###");
                        String formattedString = formatter.format(longval);
                        mEdt.setText(formattedString);
                        mEdt.setSelection(mEdt.getText().length());
                        // to place the cursor at the end of text
                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    mEdt.addTextChangedListener(this);

                }
            });

        }

        private void actionSpinnerTransActionType(final Group item) {
            if (spTransType.getSelectedItemPosition() == 0) {
                relativeGroupDeals.setVisibility(View.VISIBLE);
                linearAmountSell.setVisibility(View.VISIBLE);
                llLoanSinceDung.setVisibility(View.VISIBLE);
                llAmountMountCharge.setVisibility(View.VISIBLE);
                tgbChangeablePossibilities.setVisibility(View.VISIBLE);
                llPercentageOfMadeAndReceiveTime.setVisibility(View.GONE);

                hpPercentageOfProgressMade.setSelectedItem(0);
                hideWidgetsForRentAndRahn(item);

            } else if (spTransType.getSelectedItemPosition() == 1) {
                relativeGroupDeals.setVisibility(View.VISIBLE);
                linearAmountRentAndRahn.setVisibility(View.VISIBLE);
                llMaxAllowedAndConvertible.setVisibility(View.VISIBLE);
                llAmountMountCharge.setVisibility(View.VISIBLE);
                llPercentageOfMadeAndReceiveTime.setVisibility(View.GONE);

                tgbChangeablePossibilities.setVisibility(View.INVISIBLE);
                tgbChangeablePossibilities.setSelected(false);


                hpPercentageOfProgressMade.setSelectedItem(0);

                hideWidgetsForSell(item);

            } else if (spTransType.getSelectedItemPosition() == 2) {
                relativeGroupDeals.setVisibility(View.GONE);
                llAmountMountCharge.setVisibility(View.VISIBLE);
                llPercentageOfMadeAndReceiveTime.setVisibility(View.GONE);
                llMelkAge.setVisibility(View.GONE);
                hpMelkAge.setSelectedItem(0);


                tgbChangeablePossibilities.setVisibility(View.INVISIBLE);
                tgbChangeablePossibilities.setSelected(false);

                hpPercentageOfProgressMade.setSelectedItem(0);


                hideWidgetsForRentAndRahn(item);
                hideWidgetsForSell(item);

            } else if (spTransType.getSelectedItemPosition() == 3) {
                relativeGroupDeals.setVisibility(View.VISIBLE);

                linearAmountSell.setVisibility(View.VISIBLE);
                llPercentageOfMadeAndReceiveTime.setVisibility(View.VISIBLE);
                llLoanSinceDung.setVisibility(View.VISIBLE);
                tgbChangeablePossibilities.setVisibility(View.VISIBLE);
                llAmountMountCharge.setVisibility(View.GONE);

                edtAmountMountCharge.setText("");

                hideWidgetsForRentAndRahn(item);

            }
        }

        private void hideWidgetsForRentAndRahn(Group item) {
            tgbChangeableToRahn.setChecked(false);
            tgbChangeableToRent.setChecked(false);
            hpMaxAllowedForResidences.setSelectedItem(0);
            edtAmountRent.setText("");
            edtAmountRahn.setText("");
            llMaxAllowedAndConvertible.setVisibility(View.GONE);
            linearAmountRentAndRahn.setVisibility(View.GONE);
        }

        private void hideWidgetsForSell(Group item) {
            edtAmountSell.setText("");
            edtAmountSellPerMetric.setText("");

            swHasLoan.setChecked(false);
            edtAmountLoan.setText("");
            edtSinceQuantity.setText("");
            hpDungForSell.setSelectedItem(0);


            linearAmountSell.setVisibility(View.GONE);
            llLoanSinceDung.setVisibility(View.GONE);

        }

        private void setArrayToSpinners(Spinner spinner, int array) {
            String[] stringArray = activity.getResources().getStringArray(array);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.spinner_layout, stringArray);
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
            spinner.setAdapter(adapter);
        }

        private void actionSpinnerHomeType(Group item) {
            visibleAllViewGroup();
            setVisibilityOfToggleButton(llUsageTypeLeft);
            setVisibilityOfToggleButton(llUsageTypeRight);

            setVisibilityOfToggleButton(llSpecialFeaturesLeft);
            setVisibilityOfToggleButton(llSpecialFeaturesRight);

            setVisibilityOfToggleButton(llPossibilitiesLeft);
            setVisibilityOfToggleButton(llPossibilitiesCenter);
            setVisibilityOfToggleButton(llPossibilitiesRight);

            setVisibilityOfToggleButton(llBuildingTypeLeft);
            setVisibilityOfToggleButton(llBuildingTypeRight);


            actionSpinnerTransActionType(item);
            hideSomeWidgets(item);
//            hideAndVisibleRebuildTgb(item);

//            if (item.getSpMelkTypeValue() == 0) {
//                actionSpHomeTypeOnMelkUsageTypeOnSomeTypeOfMelk(item);
//
//            }
            if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_apart))) {
                actionSpHomeTypeOnMelkUsageTypeOnSomeTypeOfMelk(item);
                //Toast.makeText(activity, "str_apart", Toast.LENGTH_SHORT).show();

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_villa))) {
                //Toast.makeText(activity, "str_villa", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeOnMelkUsageTypeOnSomeTypeOfMelk(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_garden_villa))) {
                //Toast.makeText(activity, "str_garden_villa", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeOnMelkUsageTypeOnSomeTypeOfMelk(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_shop))) {
                //Toast.makeText(activity, "str_shop", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeShop(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_pent_house))) {
                //Toast.makeText(activity, "str_pent_house", Toast.LENGTH_SHORT).show();
                actionSpHomeTypePentHouse(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_earth))) {
                //Toast.makeText(activity, "str_earth", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeEarth();

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_clutter))) {
                //Toast.makeText(activity, "str_clutter", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeClutter(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_garden))) {
                //Toast.makeText(activity, "str_garden", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeGarden(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_mostaghelat))) {
                //Toast.makeText(activity, "str_mostaghelat", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeMostaghelat(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_factory))) {
                //Toast.makeText(activity, "str_factory", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeFactory(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_suit))) {
                //Toast.makeText(activity, "str_suit", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeOnMelkUsageTypeOnSomeTypeOfMelk(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_husbandry))) {
                //Toast.makeText(activity, "str_husbandry", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeAnimalHusbandry(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_repository))) {
                //Toast.makeText(activity, "str_repository", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeStore(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_soole))) {
                //Toast.makeText(activity, "str_soole", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeSoole(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_studio))) {
                //Toast.makeText(activity, "str_studio", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeOnMelkUsageTypeOnSomeTypeOfMelk(item);
                actionSpMelkTypeOnTalarAndStudio(item);

            } else if (spMelkType.getSelectedItem().toString().contentEquals(activity.getString(R.string.str_saloon_talar))) {
                //Toast.makeText(activity, "str_saloon_talar", Toast.LENGTH_SHORT).show();
                actionSpHomeTypeTalar(item);

            }
        }

        private void hideAndVisibleRebuildTgb(Group item) {
            if (item.getSpMelkTypeValue() == 6) {
                tgbRebuildPossibilities.setVisibility(View.VISIBLE);
            } else {
                tgbRebuildPossibilities.setVisibility(View.GONE);
                tgbRebuildPossibilities.setChecked(false);
            }
        }


        private void visibleAllViewGroup() {
            for (int i = 0; i <= llViewListDetails.getChildCount(); i++) {
                ViewGroup view = (ViewGroup) llViewListDetails.getChildAt(i);
                if (view != null) {
                    if (view.getVisibility() != View.VISIBLE) {
                        view.setVisibility(View.VISIBLE);
                    }

                }
            }
        }

        private void actionSpHomeTypeOnMelkUsageTypeOnSomeTypeOfMelk(Group item) {
            actionSpMelkTypeOnUsageTypeOnSomeTypesOfMelk(item);
            llNumberOfUnitInFloor.setVisibility(View.GONE);

            llNumberOfMasterRoom.setVisibility(View.GONE);
            llNumberOfUnitInFloor.setVisibility(View.GONE);

        }


        private void actionSpHomeTypeShop(Group item) {
            actionSpMelkTypeOnUsageType(item);
            actionSpMelkTypeOnUsageTypeonShop(item);
            actionMelkTypeShopOnAllWidgets(item);


        }

        private void actionSpHomeTypeMostaghelat(Group item) {
            llUnitType.setVisibility(View.GONE);
            llMelkPositions.setVisibility(View.GONE);
            llAmountMountCharge.setVisibility(View.GONE);

//            linearSinceQuantity.setVisibility(View.GONE);

            tabDoubleUnitType.setChecked(false);
            tgbFlatUnitType.setChecked(false);
            tgbTriplexUnitType.setChecked(false);


            tgbBeachMelkPositions.setChecked(false);
            tgbJangleMelkPositions.setChecked(false);
            tgbMountainMelkPositions.setChecked(false);
            tgbTownshipMelkPositions.setChecked(false);

            edtAmountMountCharge.setText("");

            tgbProperty.setChecked(false);
            tgbGoodwill.setChecked(false);
        }

        private void actionMelkTypeShopOnAllWidgets(Group item) {
            llNumberOfBedRooms.setVisibility(View.GONE);
            llUnitType.setVisibility(View.GONE);
            llMelkPositions.setVisibility(View.GONE);
            llNumberOfBathroom.setVisibility(View.GONE);
            llNumberOfParking.setVisibility(View.GONE);
            llNumberOfKitchen.setVisibility(View.GONE);
            llNumberOfMasterRoom.setVisibility(View.GONE);
            llNumberOfUnitInFloor.setVisibility(View.GONE);
            llNumberOfElevator.setVisibility(View.GONE);
            rlPlusKitchenCabinets.setVisibility(View.GONE);
            rlPlusTypeOfRooms.setVisibility(View.GONE);
            rlPlusFurnishedFacilities.setVisibility(View.GONE);

//            tgbWallClosetPossibilities.setVisibility(View.GONE);
            tgbSofaPossibilities.setVisibility(View.GONE);

            hpNumberOfBedRooms.setSelectedItem(0);
            tabDoubleUnitType.setChecked(false);
            tgbFlatUnitType.setChecked(false);
            tgbTriplexUnitType.setChecked(false);
//            tgbWallClosetPossibilities.setChecked(false);
            tgbSofaPossibilities.setChecked(false);
            tgbBeachMelkPositions.setChecked(false);
            tgbJangleMelkPositions.setChecked(false);
            tgbMountainMelkPositions.setChecked(false);
            tgbTownshipMelkPositions.setChecked(false);
            hpNumberOfBathRoom.setSelectedItem(0);
            hpNumberOfParking.setSelectedItem(0);
            hpNumberOfKitchen.setSelectedItem(0);
            hpNumberOfMasterRoom.setSelectedItem(0);
            hpNumberOfUnitInFloor.setSelectedItem(0);
            hpNumberOfElevator.setSelectedItem(0);

            tgbSaunaSpecialFeatures.setVisibility(View.GONE);
            tgbLobbySpecialFeatures.setVisibility(View.GONE);
            tgbJacuzziSpecialFeatures.setVisibility(View.GONE);
            tgbBathtubSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPoolSpecialFeatures.setVisibility(View.GONE);
            tgbSwimmingPoolSpecialFeatures.setVisibility(View.GONE);
            tgbRoofGardenSpecialFeatures.setVisibility(View.GONE);
            tgbFirePlaceSpecialFeatures.setVisibility(View.GONE);
            tgbBarbecueSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPlaySpaceSpecialFeatures.setVisibility(View.GONE);
            tgbShootingWasteSpecialFeatures.setVisibility(View.GONE);
            tgbGardenYardSpecialFeatures.setVisibility(View.GONE);
            tgbAltarSpecialFeatures.setVisibility(View.GONE);
            tgbCentralVacuumCleanerSpecialFeatures.setVisibility(View.GONE);
            tgbAmphitheaterSpecialFeatures.setVisibility(View.GONE);
            tgbConferenceHallSpecialFeatures.setVisibility(View.GONE);
            tgbCaretakersRoomSpecialFeatures.setVisibility(View.GONE);
            tgbFountainSpecialFeatures.setVisibility(View.GONE);
            tgbSecurityDoorSpecialFeatures.setVisibility(View.GONE);
            tgbWaterPurifierSpecialFeatures.setVisibility(View.GONE);
            tgbParkingRemoteSpecialFeatures.setVisibility(View.GONE);
            tgbTennisCourtSpecialFeatures.setVisibility(View.GONE);
            tgbPoolTableSpecialFeatures.setVisibility(View.GONE);
            tgbGuestParkingSpecialFeatures.setVisibility(View.GONE);

            setFalseValueToToggleButtonIfItWasGone(llSpecialFeaturesLeft);
            setFalseValueToToggleButtonIfItWasGone(llSpecialFeaturesRight);

            setFalseValueToToggleButton(llKitchenCabinetsLeft);
            setFalseValueToToggleButton(llKitchenCabinetsRight);
            setFalseValueToToggleButtonIfItWasGone(llKitchenCabinetsLeft);
            setFalseValueToToggleButtonIfItWasGone(llKitchenCabinetsRight);

            setFalseValueToToggleButton(llRoomTypeLeft);
            setFalseValueToToggleButton(llRoomTypeRight);
            setFalseValueToToggleButtonIfItWasGone(llRoomTypeLeft);
            setFalseValueToToggleButtonIfItWasGone(llRoomTypeRight);

            setFalseValueToToggleButton(llFurnishedFacilitiesLeft);
            setFalseValueToToggleButton(llFurnishedFacilitiesRight);

            setFalseValueToToggleButtonIfItWasGone(llFurnishedFacilitiesLeft);
            setFalseValueToToggleButtonIfItWasGone(llFurnishedFacilitiesRight);


            hpNumberOfElevator.setSelectedItem(0);

        }
//        private void hideToggleButton(LinearLayout linear) {
//            if (linear != null) {
//                for (int i = 0; i <= linear.getChildCount(); i++) {
//                    ToggleButton toggleButton = (ToggleButton) linear.getChildAt(i);
//                    if (toggleButton != null) {
//                        toggleButton.setVisibility(View.GONE);
//                    }
//                }
//            }
//        }

        private void actionSpHomeTypePentHouse(Group item) {
//            actionSpMelkTypeOnUsageType();
            actionSpMelkTypeOnUsageTypeOnPentHouse(item);
            actionSpMelkTypeOnUsageTypeOnPentHouseOnAllWidgets();

        }

        private void actionSpMelkTypeOnUsageTypeOnPentHouseOnAllWidgets() {
            tgbCementFloorCovering.setVisibility(View.GONE);
            tgbAsphaltFloorCovering.setVisibility(View.GONE);
            tgbVillaBuildingType.setVisibility(View.GONE);
            tgbApartmentBuildingType.setVisibility(View.GONE);
            tgbPassageBuildingType.setVisibility(View.GONE);
            tgbIntegratedBuildingType.setVisibility(View.GONE);
            tgbResidentUsageType.setVisibility(View.GONE);
            tgbAgricultureUsageType.setVisibility(View.GONE);
            tgbAnimalHusbandryUsageType.setVisibility(View.GONE);

            tgbCementFloorCovering.setChecked(false);
            tgbAsphaltFloorCovering.setChecked(false);
            tgbApartmentBuildingType.setChecked(false);
            tgbIntegratedBuildingType.setChecked(false);
            tgbVillaBuildingType.setChecked(false);
            tgbPassageBuildingType.setChecked(false);
            tgbResidentUsageType.setChecked(false);
            tgbAgricultureUsageType.setChecked(false);
            tgbAnimalHusbandryUsageType.setChecked(false);


        }

        private void actionSpHomeTypeEarth() {
            actionSpHomeTypeEarthOnAllWidgets();


        }

        private void actionSpHomeTypeClutter(Group item) {
            actionSpMelkTypeOnClutter(item);
            actionSpMelkTypeClutterOnAllWidgets(item);
        }


        private void actionSpHomeTypeGarden(Group item) {
//            actionSpMelkTypeOnUsageType(item);

            tgbAdministrativePositionUsageType.setVisibility(View.GONE);
            tgbAnimalHusbandryUsageType.setVisibility(View.GONE);
            tgbOfficialUsageType.setVisibility(View.GONE);


            actionSpMelkTypeOnUsageType2(item);
            actionSpMelkTypeOnUsageTypeOnGarden(item);
//            actionSpHomeTypeEarthOnAllWidgets();
            actionSpHomeTypeGardenOnAllWidgets();

        }


        private void actionSpHomeTypeFactory(Group item) {
            actionSpMelkTypeOnUsageType(item);
            actionSpMelkTypeOnUsageType2(item);
            actionSpHomeTypeFactoryOnAllWidgets(item);

            tgbAnimalHusbandryUsageType.setVisibility(View.GONE);
            tgbAnimalHusbandryUsageType.setChecked(false);

            tgbAgricultureUsageType.setVisibility(View.GONE);
            tgbAgricultureUsageType.setChecked(false);
        }


        private void actionSpHomeTypeAnimalHusbandry(Group item) {
            actionSpMelkTypeOnUsageType(item);
            actionSpMelkTypeOnUsageType2(item);
            actionSpMelkTypeOnUsageTypeOnAnimals();
            actionSpMelkTypeOnAnimalsAndSooleOnAllWidgets();


        }

        private void actionSpMelkTypeOnAnimalsAndSooleOnAllWidgets() {
            llNumberOfBedRooms.setVisibility(View.GONE);
            llFloorNumber.setVisibility(View.GONE);
            llNumberOfFloors.setVisibility(View.GONE);
            llNumberOfUnitInFloor.setVisibility(View.GONE);
            llUnitType.setVisibility(View.GONE);
            llMelkPositions.setVisibility(View.GONE);
            llNumberOfElevator.setVisibility(View.GONE);
            llNumberOfBathroom.setVisibility(View.GONE);
            llNumberOfKitchen.setVisibility(View.GONE);
            llNumberOfMasterRoom.setVisibility(View.GONE);
            llNumberOfIraniToilet.setVisibility(View.GONE);
            llNumberOfFarangiToilet.setVisibility(View.GONE);
            linearSinceQuantity.setVisibility(View.GONE);

            hideTabPossibilitiesForGardenAndFactoryAndEarth();

            tgbSaunaSpecialFeatures.setVisibility(View.GONE);
            tgbJacuzziSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPoolSpecialFeatures.setVisibility(View.GONE);
            tgbBathtubSpecialFeatures.setVisibility(View.GONE);
            tgbRoofGardenSpecialFeatures.setVisibility(View.GONE);
            tgbFirePlaceSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPlaySpaceSpecialFeatures.setVisibility(View.GONE);
            tgbShootingWasteSpecialFeatures.setVisibility(View.GONE);
            tgbAltarSpecialFeatures.setVisibility(View.GONE);
            tgbCentralVacuumCleanerSpecialFeatures.setVisibility(View.GONE);
            tgbAmphitheaterSpecialFeatures.setVisibility(View.GONE);
            tgbSmartHomeSpecialFeatures.setVisibility(View.GONE);
            tgbConferenceHallSpecialFeatures.setVisibility(View.GONE);
            tgbSafeguardSpecialFeatures.setVisibility(View.GONE);
            tgbSolarBatterySpecialFeatures.setVisibility(View.GONE);
            tgbFountainSpecialFeatures.setVisibility(View.GONE);
//            tgbCaretakersRoomSpecialFeatures.setVisibility(View.GONE);
            tgbSecurityDoorSpecialFeatures.setVisibility(View.GONE);
            tgbTennisCourtSpecialFeatures.setVisibility(View.GONE);
            tgbParkingRemoteSpecialFeatures.setVisibility(View.GONE);
            tgbGuestParkingSpecialFeatures.setVisibility(View.GONE);
            tgbPoolTableSpecialFeatures.setVisibility(View.GONE);
            tgbBarbecueSpecialFeatures.setVisibility(View.GONE);
            tgbLobbySpecialFeatures.setVisibility(View.GONE);
            tgbSwimmingPoolSpecialFeatures.setVisibility(View.GONE);
            tgbGardenYardSpecialFeatures.setVisibility(View.GONE);
            edtSinceQuantity.setText("");

            setFalseValueToToggleButton(llBuildingFacadesLeft);
            setFalseValueToToggleButton(llBuildingFacadesRight);
            rlPlusBuildingFacades.setVisibility(View.GONE);

            setFalseValueToToggleButton(llKitchenCabinetsLeft);
            setFalseValueToToggleButton(llKitchenCabinetsRight);
            rlPlusKitchenCabinets.setVisibility(View.GONE);

            setFalseValueToToggleButton(llWindowsTypeLeft);
            setFalseValueToToggleButton(llWindowsTypeRight);
            rlPlusWindowsType.setVisibility(View.GONE);

            setFalseValueToToggleButton(llBuildingTypeLeft);
            setFalseValueToToggleButton(llBuildingTypeRight);
            rlPlusBuildingType.setVisibility(View.GONE);

            setFalseValueToToggleButton(llViewLeft);
            setFalseValueToToggleButton(llViewRight);
            rlPlusMelkView.setVisibility(View.GONE);

            setFalseValueToToggleButton(llRoomTypeLeft);
            setFalseValueToToggleButton(llRoomTypeRight);
            rlPlusTypeOfRooms.setVisibility(View.GONE);

            setFalseValueToToggleButton(llFurnishedFacilitiesLeft);
            setFalseValueToToggleButton(llFurnishedFacilitiesRight);
            rlPlusFurnishedFacilities.setVisibility(View.GONE);


        }

        private void actionSpHomeTypeStore(Group item) {
            actionSpMelkTypeOnUsageType(item);
            actionSpMelkTypeOnUsageType2(item);
            actionSpMelkTypeStoreOnAllWidgets(item);

            tgbAgricultureUsageType.setVisibility(View.GONE);
            tgbAgricultureUsageType.setChecked(false);

            tgbIndustrialUsageType.setVisibility(View.GONE);
            tgbIndustrialUsageType.setChecked(false);

            tgbAnimalHusbandryUsageType.setVisibility(View.GONE);
            tgbAnimalHusbandryUsageType.setChecked(false);
        }

        private void actionSpMelkTypeStoreOnAllWidgets(Group item) {
            llNumberOfBedRooms.setVisibility(View.GONE);
            llUnitType.setVisibility(View.GONE);
            llMelkPositions.setVisibility(View.GONE);
            linearSinceQuantity.setVisibility(View.GONE);
            llNumberOfBathroom.setVisibility(View.GONE);
            llNumberOfKitchen.setVisibility(View.GONE);
            llNumberOfMasterRoom.setVisibility(View.GONE);
            llNumberOfIraniToilet.setVisibility(View.GONE);
            llNumberOfFarangiToilet.setVisibility(View.GONE);

            tgbSaunaSpecialFeatures.setVisibility(View.GONE);
            tgbJacuzziSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPoolSpecialFeatures.setVisibility(View.GONE);
            tgbBathtubSpecialFeatures.setVisibility(View.GONE);
            tgbRoofGardenSpecialFeatures.setVisibility(View.GONE);
            tgbFirePlaceSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPlaySpaceSpecialFeatures.setVisibility(View.GONE);
            tgbShootingWasteSpecialFeatures.setVisibility(View.GONE);
            tgbAltarSpecialFeatures.setVisibility(View.GONE);
            tgbCentralVacuumCleanerSpecialFeatures.setVisibility(View.GONE);
            tgbAmphitheaterSpecialFeatures.setVisibility(View.GONE);
            tgbSmartHomeSpecialFeatures.setVisibility(View.GONE);
            tgbConferenceHallSpecialFeatures.setVisibility(View.GONE);
            tgbSafeguardSpecialFeatures.setVisibility(View.GONE);
            tgbSolarBatterySpecialFeatures.setVisibility(View.GONE);
            tgbFountainSpecialFeatures.setVisibility(View.GONE);
//            tgbCaretakersRoomSpecialFeatures.setVisibility(View.GONE);
            tgbSecurityDoorSpecialFeatures.setVisibility(View.GONE);
            tgbTennisCourtSpecialFeatures.setVisibility(View.GONE);
            tgbParkingRemoteSpecialFeatures.setVisibility(View.GONE);
            tgbGuestParkingSpecialFeatures.setVisibility(View.GONE);
            tgbPoolTableSpecialFeatures.setVisibility(View.GONE);
            tgbBarbecueSpecialFeatures.setVisibility(View.GONE);
            tgbLobbySpecialFeatures.setVisibility(View.GONE);
            tgbSwimmingPoolSpecialFeatures.setVisibility(View.GONE);
            tgbGardenYardSpecialFeatures.setVisibility(View.GONE);

            setFalseValueToToggleButton(llBuildingFacadesLeft);
            setFalseValueToToggleButton(llBuildingFacadesRight);
            rlPlusBuildingFacades.setVisibility(View.GONE);

            setFalseValueToToggleButton(llKitchenCabinetsLeft);
            setFalseValueToToggleButton(llKitchenCabinetsRight);
            rlPlusKitchenCabinets.setVisibility(View.GONE);

            setFalseValueToToggleButton(llWindowsTypeLeft);
            setFalseValueToToggleButton(llWindowsTypeRight);
            rlPlusWindowsType.setVisibility(View.GONE);


            setFalseValueToToggleButton(llViewLeft);
            setFalseValueToToggleButton(llViewRight);
            rlPlusMelkView.setVisibility(View.GONE);

            setFalseValueToToggleButton(llRoomTypeLeft);
            setFalseValueToToggleButton(llRoomTypeRight);
            rlPlusTypeOfRooms.setVisibility(View.GONE);

            setFalseValueToToggleButton(llFurnishedFacilitiesLeft);
            setFalseValueToToggleButton(llFurnishedFacilitiesRight);
            rlPlusFurnishedFacilities.setVisibility(View.GONE);

            hideTabPossibilitiesForGardenAndFactoryAndEarth();
            linearMaxAllowedForResidences.setVisibility(View.GONE);
        }

        private void actionSpHomeTypeSoole(Group item) {
            actionSpMelkTypeOnUsageType(item);

            tgbClinicUsageType.setVisibility(View.GONE);
            tgbClinicUsageType.setChecked(false);

            tgbAnimalHusbandryUsageType.setVisibility(View.GONE);
            tgbAnimalHusbandryUsageType.setChecked(false);

            actionSpMelkTypeOnAnimalsAndSooleOnAllWidgets();
            llCeilingHeight.setVisibility(View.VISIBLE);
        }

        private void actionSpHomeTypeTalar(Group item) {
            actionSpMelkTypeOnUsageType(item);
            tgbAgricultureUsageType.setVisibility(View.GONE);
            tgbAgricultureUsageType.setChecked(false);

            tgbAgricultureUsageType.setVisibility(View.GONE);
            tgbAgricultureUsageType.setChecked(false);

            tgbAnimalHusbandryUsageType.setVisibility(View.GONE);
            tgbAnimalHusbandryUsageType.setChecked(false);

            actionSpMelkTypeOnTalarAndStudio(item);
        }

        private void actionSpMelkTypeOnTalarAndStudio(Group item) {
            llNumberOfBedRooms.setVisibility(View.GONE);
            hpNumberOfBedRooms.setSelectedItem(0);
        }


        private void actionSpMelkTypeOnUsageType(Group item) {
            tgbResidentialUsageType.setVisibility(View.GONE);
            tgbResidentUsageType.setVisibility(View.GONE);
            tgbOfficialUsageType.setVisibility(View.GONE);
            tgbAdministrativePositionUsageType.setVisibility(View.GONE);

            tgbOfficialUsageType.setChecked(false);
            tgbResidentialUsageType.setChecked(false);
            tgbAdministrativePositionUsageType.setChecked(false);
            tgbResidentUsageType.setChecked(false);


        }

        private void actionSpMelkTypeOnUsageType2(Group item) {
            tgbCommercialUsageType.setVisibility(View.GONE);
            tgbSportsUsageType.setVisibility(View.GONE);
            tgbEducationalUsageType.setVisibility(View.GONE);
            tgbClinicUsageType.setVisibility(View.GONE);

            tgbCommercialUsageType.setChecked(false);
            tgbEducationalUsageType.setChecked(false);
            tgbSportsUsageType.setChecked(false);
            tgbClinicUsageType.setChecked(false);

        }

        private void actionSpMelkTypeOnUsageTypeOnPentHouse(Group item) {
            tgbIndustrialUsageType.setVisibility(View.GONE);
            tgbSportsUsageType.setVisibility(View.GONE);
            tgbEducationalUsageType.setVisibility(View.GONE);
            tgbClinicUsageType.setVisibility(View.GONE);
            tgbStoreUsageType.setVisibility(View.GONE);

            tgbIndustrialUsageType.setChecked(false);
            tgbSportsUsageType.setChecked(false);
            tgbEducationalUsageType.setChecked(false);
            tgbClinicUsageType.setChecked(false);
            tgbStoreUsageType.setChecked(false);

        }

        private void actionSpMelkTypeOnUsageTypeonShop(Group item) {
            tgbSportsUsageType.setVisibility(View.GONE);
            tgbEducationalUsageType.setVisibility(View.GONE);
            tgbClinicUsageType.setVisibility(View.GONE);
            tgbAnimalHusbandryUsageType.setVisibility(View.GONE);

            tgbAnimalHusbandryUsageType.setChecked(false);
            tgbSportsUsageType.setChecked(false);
            tgbEducationalUsageType.setChecked(false);
            tgbClinicUsageType.setChecked(false);


            tgbAgricultureUsageType.setVisibility(View.GONE);
            tgbAgricultureUsageType.setChecked(false);
        }

        private void actionSpMelkTypeOnUsageTypeOnSomeTypesOfMelk(Group item) {
            tgbIndustrialUsageType.setVisibility(View.GONE);
            tgbAgricultureUsageType.setVisibility(View.GONE);
            tgbAnimalHusbandryUsageType.setVisibility(View.GONE);

            tgbIndustrialUsageType.setChecked(false);
            tgbAgricultureUsageType.setChecked(false);
            tgbAnimalHusbandryUsageType.setChecked(false);

        }


        private void actionSpMelkTypeOnUsageTypeOnGarden(Group item) {
            tgbIndustrialUsageType.setVisibility(View.GONE);
            tgbStoreUsageType.setVisibility(View.GONE);

            tgbIndustrialUsageType.setChecked(false);
            tgbStoreUsageType.setChecked(false);
        }

        private void actionSpMelkTypeOnUsageTypeOnAnimals() {
            tgbStoreUsageType.setVisibility(View.GONE);
            tgbStoreUsageType.setChecked(false);

            tgbIndustrialUsageType.setVisibility(View.GONE);
            tgbIndustrialUsageType.setChecked(false);

            tgbAgricultureUsageType.setVisibility(View.GONE);
            tgbAgricultureUsageType.setChecked(false);
        }

        private void hideSomeWidgets(Group item) {
            if (item.getSpMelkTypeValue() == 12 || item.getSpMelkTypeValue() == 13 || item.getSpMelkTypeValue() == 14 || item.getSpMelkTypeValue() == 15) {
                llCeilingHeight.setVisibility(View.VISIBLE);

            } else {
                llCeilingHeight.setVisibility(View.GONE);
                hpHeightOfTheCeiling.setSelectedItem(0);
            }

            if (item.getSpMelkTypeValue() == 5 || item.getSpMelkTypeValue() == 7 || item.getSpMelkTypeValue() == 8) {
                linearSinceQuantity.setVisibility(View.GONE);
                linearMaxAllowedForResidences.setVisibility(View.GONE);

                edtSinceQuantity.setText("");
                hpMaxAllowedForResidences.setSelectedItem(0);
            } else {
                linearSinceQuantity.setVisibility(View.VISIBLE);
                linearMaxAllowedForResidences.setVisibility(View.VISIBLE);
            }


            if (item.getSpMelkTypeValue() == 3) {
                llGoodwillAndProperty.setVisibility(View.VISIBLE);
            } else {
                llGoodwillAndProperty.setVisibility(View.GONE);
                tgbProperty.setChecked(false);
                tgbGoodwill.setChecked(false);
            }

            if (item.getSpMelkTypeValue() == 9 || item.getSpMelkTypeValue() == 11 || item.getSpMelkTypeValue() == 12 || item.getSpMelkTypeValue() == 13) {
                llNumberOfRoofSpace.setVisibility(View.VISIBLE);

            } else {
                llNumberOfRoofSpace.setVisibility(View.GONE);
                hpNumberOfRoofSpace.setSelectedItem(0);
            }

        }

        private void setVisibilityOfToggleButton(LinearLayout linearLayout) {
            if (linearLayout != null) {
                for (int i = 0; i <= linearLayout.getChildCount(); i++) {
                    ToggleButton toggleButton = (ToggleButton) linearLayout.getChildAt(i);
                    if (toggleButton != null) {
                        toggleButton.setVisibility(View.VISIBLE);
                    }
                }
            }
        }

        private void actionSpHomeTypeEarthOnAllWidgets() {
            llMelkAge.setVisibility(View.GONE);
            llNumberOfBedRooms.setVisibility(View.GONE);
            llDateOfQuit.setVisibility(View.GONE);
            llNumberOfParking.setVisibility(View.GONE);
            rlPlusCoolingHealingSystem.setVisibility(View.GONE);
            rlPlusTypeOfRooms.setVisibility(View.GONE);

            hideTabPossibilitiesForGardenAndFactoryAndEarth();
            tgbJanitorPossibilities.setVisibility(View.GONE);
            tgbJanitorPossibilities.setChecked(false);


            hpMelkAge.setSelectedItem(0);
            hpNumberOfBedRooms.setSelectedItem(0);
            hpFloorNumber.setSelectedItem(5);
            txtDateOfQuit.setText(activity.getString(R.string.str_enter_date_of_discharge));
            swDateOfQuit.setChecked(false);
//            edtAmountLoan.setText("");
//            swHasLoan.setChecked(false);

            setFalseValueToToggleButton(llSpecialFeaturesLeft);
            setFalseValueToToggleButton(llSpecialFeaturesRight);
            rlPlusSpecialFeature.setVisibility(View.GONE);


            commonWidgetsBetweenHomeType();

        }

        private void hideTabPossibilitiesForGardenAndFactoryAndEarth() {
            tgbYardPossibilities.setVisibility(View.GONE);
//            tgbWallClosetPossibilities.setVisibility(View.GONE);
            tgbCentralAntennaPossibilities.setVisibility(View.GONE);
            tgbSofaPossibilities.setVisibility(View.GONE);
            tgbStorePossibilities.setVisibility(View.GONE);
            tgbVideoIphonePossibilities.setVisibility(View.GONE);
            tgbBalconyPossibilities.setVisibility(View.GONE);
            tgbRebuildPossibilities.setVisibility(View.GONE);
            tgbPatioPossibilities.setVisibility(View.GONE);


            tgbYardPossibilities.setChecked(false);
//            tgbWallClosetPossibilities.setChecked(false);
            tgbCentralAntennaPossibilities.setChecked(false);
            tgbSofaPossibilities.setChecked(false);
            tgbStorePossibilities.setChecked(false);
            tgbVideoIphonePossibilities.setChecked(false);
            tgbBalconyPossibilities.setChecked(false);
            tgbRebuildPossibilities.setChecked(false);
            tgbPatioPossibilities.setChecked(false);
        }

        private void actionSpMelkTypeOnClutter(Group item) {
            tgbResidentUsageType.setVisibility(View.GONE);
            tgbAgricultureUsageType.setVisibility(View.GONE);
            tgbAnimalHusbandryUsageType.setVisibility(View.GONE);

            tgbResidentUsageType.setChecked(false);
            tgbAgricultureUsageType.setChecked(false);
            tgbAnimalHusbandryUsageType.setChecked(false);

        }

        private void actionSpMelkTypeClutterOnAllWidgets(Group item) {
            tgbRebuildPossibilities.setVisibility(View.VISIBLE);
            llUnitType.setVisibility(View.GONE);
            llMelkPositions.setVisibility(View.GONE);
            llNumberOfTelSub.setVisibility(View.GONE);

            tgbSaunaSpecialFeatures.setVisibility(View.GONE);
            tgbJacuzziSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPoolSpecialFeatures.setVisibility(View.GONE);
            tgbBathtubSpecialFeatures.setVisibility(View.GONE);
            tgbRoofGardenSpecialFeatures.setVisibility(View.GONE);
            tgbFirePlaceSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPlaySpaceSpecialFeatures.setVisibility(View.GONE);
            tgbShootingWasteSpecialFeatures.setVisibility(View.GONE);
            tgbAltarSpecialFeatures.setVisibility(View.GONE);
            tgbCentralVacuumCleanerSpecialFeatures.setVisibility(View.GONE);
            tgbSecuritySystemSpecialFeatures.setVisibility(View.GONE);
            tgbAmphitheaterSpecialFeatures.setVisibility(View.GONE);
            tgbSmartHomeSpecialFeatures.setVisibility(View.GONE);
            tgbConferenceHallSpecialFeatures.setVisibility(View.GONE);
            tgbSafeguardSpecialFeatures.setVisibility(View.GONE);
            tgbSolarBatterySpecialFeatures.setVisibility(View.GONE);
            tgbEmergencyPowerSpecialFeatures.setVisibility(View.GONE);
            tgbFountainSpecialFeatures.setVisibility(View.GONE);
            tgbCaretakersRoomSpecialFeatures.setVisibility(View.GONE);
            tgbSecurityDoorSpecialFeatures.setVisibility(View.GONE);
            tgbCargoElevatorSpecialFeatures.setVisibility(View.GONE);
            tgbTennisCourtSpecialFeatures.setVisibility(View.GONE);
            tgbParkingRemoteSpecialFeatures.setVisibility(View.GONE);
            tgbGuestParkingSpecialFeatures.setVisibility(View.GONE);
            tgbPoolTableSpecialFeatures.setVisibility(View.GONE);

            llAmountMountCharge.setVisibility(View.GONE);
            llGeoPosition.setVisibility(View.GONE);


            tgbFlatUnitType.setChecked(false);
            tabDoubleUnitType.setChecked(false);
            tgbTriplexUnitType.setChecked(false);
            tgbBeachMelkPositions.setChecked(false);
            tgbJangleMelkPositions.setChecked(false);
            tgbMountainMelkPositions.setChecked(false);
            tgbTownshipMelkPositions.setChecked(false);
            hpNumberOfTellSub.setSelectedItem(0);
            edtAmountMountCharge.setText("");
            tgbNorthGeoPosition.setChecked(false);
            tgbSouthGeoPosition.setChecked(false);
            tgbEstGeoPosition.setChecked(false);
            tgbWestGeoPosition.setChecked(false);


            setFalseValueToToggleButtonIfItWasGone(llSpecialFeaturesLeft);
            setFalseValueToToggleButtonIfItWasGone(llSpecialFeaturesRight);

            setFalseValueToToggleButton(llFurnishedFacilitiesLeft);
            setFalseValueToToggleButton(llFurnishedFacilitiesRight);
            rlPlusFurnishedFacilities.setVisibility(View.GONE);
        }


        private void actionSpHomeTypeFactoryOnAllWidgets(Group item) {
            setFalseValueToToggleButton(llViewLeft);
            setFalseValueToToggleButton(llViewRight);
            hpDistanceToVehicle.setSelectedItem(0);
//            hpNumberOfParking.setSelectedItem(0);
            hpNumberOfBedRooms.setSelectedItem(0);
            edtSinceQuantity.setText("");

            hideTabPossibilitiesForGardenAndFactoryAndEarth();

//            llNumberOfParking.setVisibility(View.GONE);
            linearSinceQuantity.setVisibility(View.GONE);
            llNumberOfBedRooms.setVisibility(View.GONE);
            rlPlusMelkView.setVisibility(View.GONE);
            llDistanceToPublicVehicle.setVisibility(View.GONE);

            tgbSaunaSpecialFeatures.setVisibility(View.GONE);
            tgbJacuzziSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPoolSpecialFeatures.setVisibility(View.GONE);
            tgbBathtubSpecialFeatures.setVisibility(View.GONE);
            tgbRoofGardenSpecialFeatures.setVisibility(View.GONE);
            tgbFirePlaceSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPlaySpaceSpecialFeatures.setVisibility(View.GONE);
            tgbShootingWasteSpecialFeatures.setVisibility(View.GONE);
            tgbAltarSpecialFeatures.setVisibility(View.GONE);
            tgbCentralVacuumCleanerSpecialFeatures.setVisibility(View.GONE);
            tgbAmphitheaterSpecialFeatures.setVisibility(View.GONE);
            tgbSmartHomeSpecialFeatures.setVisibility(View.GONE);
            tgbConferenceHallSpecialFeatures.setVisibility(View.GONE);
            tgbSafeguardSpecialFeatures.setVisibility(View.GONE);
            tgbSolarBatterySpecialFeatures.setVisibility(View.GONE);
            tgbFountainSpecialFeatures.setVisibility(View.GONE);
            tgbCaretakersRoomSpecialFeatures.setVisibility(View.GONE);
            tgbSecurityDoorSpecialFeatures.setVisibility(View.GONE);
            tgbTennisCourtSpecialFeatures.setVisibility(View.GONE);
            tgbParkingRemoteSpecialFeatures.setVisibility(View.GONE);
            tgbGuestParkingSpecialFeatures.setVisibility(View.GONE);
            tgbPoolTableSpecialFeatures.setVisibility(View.GONE);
            tgbBarbecueSpecialFeatures.setVisibility(View.GONE);
            tgbLobbySpecialFeatures.setVisibility(View.GONE);
            tgbSwimmingPoolSpecialFeatures.setVisibility(View.GONE);
            tgbGardenYardSpecialFeatures.setVisibility(View.GONE);


            setFalseValueToToggleButtonIfItWasGone(llSpecialFeaturesLeft);
            setFalseValueToToggleButtonIfItWasGone(llSpecialFeaturesRight);

            commonWidgetsBetweenHomeType();
        }

        private void actionSpHomeTypeGardenOnAllWidgets() {

            hpDungForSell.setSelectedItem(0);
            edtSinceQuantity.setText("");
            edtAmountLoan.setText("");
            swHasLoan.setChecked(false);
            hpMaxAllowedForResidences.setSelectedItem(0);
            hpNumberOfBedRooms.setSelectedItem(0);
            txtDateOfQuit.setText(activity.getString(R.string.str_enter_date_of_discharge));

            llMaxAllowedAndConvertible.setVisibility(View.GONE);
            llLoanSinceDung.setVisibility(View.GONE);
            llNumberOfBedRooms.setVisibility(View.GONE);
            llDateOfQuit.setVisibility(View.GONE);

            setFalseValueToToggleButton(llCoolingHealingSystemLeft);
            setFalseValueToToggleButton(llCoolingHealingSystemRight);
            setFalseValueToToggleButton(llRoomTypeLeft);
            setFalseValueToToggleButton(llRoomTypeRight);
            rlPlusCoolingHealingSystem.setVisibility(View.GONE);
            rlPlusTypeOfRooms.setVisibility(View.GONE);


            hideTabPossibilitiesForGardenAndFactoryAndEarth();

            tgbSaunaSpecialFeatures.setVisibility(View.GONE);
            tgbJacuzziSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPoolSpecialFeatures.setVisibility(View.GONE);
            tgbBathtubSpecialFeatures.setVisibility(View.GONE);
            tgbRoofGardenSpecialFeatures.setVisibility(View.GONE);
            tgbFirePlaceSpecialFeatures.setVisibility(View.GONE);
            tgbChildrenPlaySpaceSpecialFeatures.setVisibility(View.GONE);
            tgbShootingWasteSpecialFeatures.setVisibility(View.GONE);
//            tgbAltarSpecialFeatures.setVisibility(View.GONE);
            tgbCentralVacuumCleanerSpecialFeatures.setVisibility(View.GONE);
            tgbAmphitheaterSpecialFeatures.setVisibility(View.GONE);
            tgbSmartHomeSpecialFeatures.setVisibility(View.GONE);
            tgbConferenceHallSpecialFeatures.setVisibility(View.GONE);
            tgbSafeguardSpecialFeatures.setVisibility(View.GONE);
            tgbSolarBatterySpecialFeatures.setVisibility(View.GONE);
            tgbFountainSpecialFeatures.setVisibility(View.GONE);
//            tgbCaretakersRoomSpecialFeatures.setVisibility(View.GONE);
            tgbSecurityDoorSpecialFeatures.setVisibility(View.GONE);
            tgbTennisCourtSpecialFeatures.setVisibility(View.GONE);
            tgbParkingRemoteSpecialFeatures.setVisibility(View.GONE);
            tgbGuestParkingSpecialFeatures.setVisibility(View.GONE);
            tgbPoolTableSpecialFeatures.setVisibility(View.GONE);
            tgbBarbecueSpecialFeatures.setVisibility(View.GONE);
            tgbLobbySpecialFeatures.setVisibility(View.GONE);
            tgbSwimmingPoolSpecialFeatures.setVisibility(View.GONE);
            tgbGardenYardSpecialFeatures.setVisibility(View.GONE);
            tgbFirefightSpecialFeatures.setVisibility(View.GONE);
            tgbEmergencyPowerSpecialFeatures.setVisibility(View.GONE);
            tgbCargoElevatorSpecialFeatures.setVisibility(View.GONE);
            tgbWaterPurifierSpecialFeatures.setVisibility(View.GONE);

            setFalseValueToToggleButtonIfItWasGone(llSpecialFeaturesLeft);
            setFalseValueToToggleButtonIfItWasGone(llSpecialFeaturesRight);


            commonWidgetsBetweenHomeType();

        }

        private void commonWidgetsBetweenHomeType() {
            hpFloorNumber.setSelectedItem(5);
            hpNumberOfFloors.setSelectedItem(0);
            hpNumberOfUnitInFloor.setSelectedItem(0);

            tabDoubleUnitType.setChecked(false);
            tgbFlatUnitType.setChecked(false);
            tgbTriplexUnitType.setChecked(false);

            tgbBeachMelkPositions.setChecked(false);
            tgbJangleMelkPositions.setChecked(false);
            tgbMountainMelkPositions.setChecked(false);
            tgbTownshipMelkPositions.setChecked(false);
            hpNumberOfElevator.setSelectedItem(0);
            hpNumberOfBathRoom.setSelectedItem(0);
            hpNumberOfKitchen.setSelectedItem(0);
            hpNumberOfMasterRoom.setSelectedItem(0);
            hpNumberOfIraniToilet.setSelectedItem(0);
//            hpNumberOfFarangiToilet.setSelectedItem(0);
            edtAmountMountCharge.setText("");
            tgbMetalStructType.setChecked(false);
            tgbBlotsButsStructType.setChecked(false);
            tgbConcreteAndBarStructType.setChecked(false);
            tgbProperty.setChecked(false);
            tgbGoodwill.setChecked(false);
            setFalseValueToToggleButton(llBuildingFacadesLeft);
            setFalseValueToToggleButton(llBuildingFacadesRight);
            setFalseValueToToggleButton(llKitchenCabinetsLeft);
            setFalseValueToToggleButton(llKitchenCabinetsRight);
            setFalseValueToToggleButton(llWindowsTypeLeft);
            setFalseValueToToggleButton(llWindowsTypeRight);
            tgbTowerBuildingType.setChecked(false);
            tgbApartmentBuildingType.setChecked(false);
            tgbIntegratedBuildingType.setChecked(false);
            setFalseValueToToggleButton(llFurnishedFacilitiesLeft);
            setFalseValueToToggleButton(llFurnishedFacilitiesRight);


            llFloorNumber.setVisibility(View.GONE);
            llNumberOfFloors.setVisibility(View.GONE);
            llNumberOfUnitInFloor.setVisibility(View.GONE);
            llUnitType.setVisibility(View.GONE);
            llMelkPositions.setVisibility(View.GONE);
            llNumberOfElevator.setVisibility(View.GONE);
            llNumberOfBathroom.setVisibility(View.GONE);
            llNumberOfKitchen.setVisibility(View.GONE);
            llNumberOfMasterRoom.setVisibility(View.GONE);
            llNumberOfIraniToilet.setVisibility(View.GONE);
            llNumberOfFarangiToilet.setVisibility(View.GONE);
            llAmountMountCharge.setVisibility(View.GONE);
            llStructureType.setVisibility(View.GONE);

            rlPlusBuildingFacades.setVisibility(View.GONE);
            rlPlusKitchenCabinets.setVisibility(View.GONE);
            rlPlusWindowsType.setVisibility(View.GONE);
            rlPlusBuildingType.setVisibility(View.GONE);
            rlPlusFurnishedFacilities.setVisibility(View.GONE);


        }

        private void setFalseValueToToggleButton(LinearLayout linearLayouts) {
            if (linearLayouts == null) {
                return;
            }
            for (int i = 0; i <= linearLayouts.getChildCount(); i++) {
                ToggleButton toggleButton = (ToggleButton) linearLayouts.getChildAt(i);
                if (toggleButton != null) {
                    toggleButton.setChecked(false);
                }
            }
        }


    }

    private void setFalseValueToToggleButtonIfItWasGone(LinearLayout linearLayouts) {
        if (linearLayouts == null) {
            return;
        }
        for (int i = 0; i <= linearLayouts.getChildCount(); i++) {
            ToggleButton toggleButton = (ToggleButton) linearLayouts.getChildAt(i);
            if (toggleButton != null && toggleButton.getVisibility() != View.VISIBLE) {
                toggleButton.setChecked(false);
            }
        }
    }

    private void pickFromGallery() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && activity.checkSelfPermission(
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_ACCESS_PERMISSION_STORAGE);
        } else {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT)
                    .setType("image/*")
                    .addCategory(Intent.CATEGORY_OPENABLE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                String[] mimeTypes = {"image/jpeg", "image/png"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
            }

            activity.startActivityForResult(Intent.createChooser(intent, activity.getString(R.string.label_select_picture)), GALLERY_REQUEST);
        }
    }

    public void checkIsEmptyUnitWidgetsInformation() {
        if ((currentItem != null)) {
            if (currentItem.getSpTransTypeValue() == 0 || currentItem.getSpTransTypeValue() == 3) {
                isFieldsInitialized = !(currentItem.getEdtAmountSellValue().contentEquals("")
                        || currentItem.getEdtMelkAreaValue().contentEquals(""));

            } else if (currentItem.getSpTransTypeValue() == 1) {
                isFieldsInitialized = !(currentItem.getEdtAmountRentValue().contentEquals("")
                        || currentItem.getEdtMelkAreaValue().contentEquals(""));

            } else if (currentItem.getSpTransTypeValue() == 2) {
                isFieldsInitialized = !(currentItem.getEdtMelkAreaValue().contentEquals(""));
            }


        }


    }

    private void getPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && activity.checkSelfPermission(
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_CAMERA);

        }

    }

    public void getUnitWidgetsInfoAndSave(Group item) {
        if (item != null) {
            realmDataBase.addToRealmDataBase(item, GoogleMapFragment.mMarker);
            isHomeSaved = 2;
        }
    }

    private void configRealmDatabase() {
        RealmConfiguration config = new RealmConfiguration.Builder(activity)
                .name("Fake")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(config);
    }
}

