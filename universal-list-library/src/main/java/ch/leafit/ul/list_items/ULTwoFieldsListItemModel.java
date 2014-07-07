package ch.leafit.ul.list_items;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by marius on 26/06/14.
 */
public class ULTwoFieldsListItemModel extends ULListItemBaseModel {

    protected String mRightText;
    protected String mLeftText;

    public ULTwoFieldsListItemModel(String leftText, String rightText) {
        mLeftText = leftText;
        mRightText = rightText;
    }

    public ULTwoFieldsListItemModel(Parcel in) {
        readFromParcel(in);
    }

    /**
     *
     * @return The layoutId of the ListEntryView layout
     */
    public int getViewLayoutId() {
        //activated --> makes that item selection works (don't use simple_list_item_2 (wasted time: 1h :)))
        return android.R.layout.simple_list_item_activated_2;
    }


    /**
     * Fills data of currentInstance into the View
     * @param ListEntryView probably the convertView from the ListAdapter
     */
    public void fillDataInView(View v) {
        if(v != null) {
            TextView txtLeft = (TextView)v.findViewById(android.R.id.text1);
            TextView txtRight = (TextView)v.findViewById(android.R.id.text2);
            if(txtLeft != null) {
                txtLeft.setText(mLeftText);
            }
            if(txtRight != null) {
                txtRight.setText(mRightText);
            }
        }
    }

    @Override
    public String getValueString() {
        return mRightText;
    }

    @Override
    public boolean passesFilterTest(CharSequence filterText) {
        return mLeftText.toUpperCase(Locale.GERMANY).startsWith(filterText.toString().toUpperCase(Locale.GERMANY));
    }

    /*
	 * @Parcelable
	 */

    public static final Parcelable.Creator<ULTwoFieldsListItemModel> CREATOR = new Parcelable.Creator<ULTwoFieldsListItemModel>() {
        public ULTwoFieldsListItemModel createFromParcel(Parcel in ) {
            return new ULTwoFieldsListItemModel(in);
        }

        public ULTwoFieldsListItemModel[] newArray(int size) {
            return new ULTwoFieldsListItemModel[size];
        }
    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mLeftText);
        dest.writeString(mRightText);
    }

    private void readFromParcel(Parcel in) {
        mLeftText = in.readString();
        mRightText = in.readString();
    }

    public int describeContents() {
        return 0;
    }
}
