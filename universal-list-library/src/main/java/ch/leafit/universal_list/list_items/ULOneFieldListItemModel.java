package ch.leafit.universal_list.list_items;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

/**
 * Created by marius on 26/06/14.
 * Basic List Entry (one Textfield)
 */
public class ULOneFieldListItemModel extends ULListItemBaseModel {

    protected String mTitle;

    public ULOneFieldListItemModel(String title) {
        mTitle = title;
    }

    public ULOneFieldListItemModel(Parcel in) {
        readFromParcel(in);
    }

    /*
     * @return The layoutId of the ListEntryView layout
     */
    public int getViewLayoutId() {
        //activated --> makes that item selection works (don't use simple_list_item_1 (wasted time: 1h :)))
        return android.R.layout.simple_list_item_activated_1;
    }


    /**
     * Fills data of currentInstance into the View
     * @param ListEntryView probably the convertView from the ListAdapter
     */
    public void fillDataInView(View v) {
        if(v != null) {
            TextView txtTitle = (TextView)v.findViewById(android.R.id.text1);
            if(txtTitle != null) {
                txtTitle.setText(mTitle);
            }
        }
    }

    @Override
    public boolean passesFilterTest(CharSequence filterText) {
        return mTitle.toUpperCase(Locale.GERMANY).startsWith(filterText.toString().toUpperCase(Locale.GERMANY));
    }

    /*
	 * @Parcelable
	 */

    public static final Parcelable.Creator<ULOneFieldListItemModel> CREATOR = new Parcelable.Creator<ULOneFieldListItemModel>() {
        public ULOneFieldListItemModel createFromParcel(Parcel in ) {
            return new ULOneFieldListItemModel(in);
        }

        public ULOneFieldListItemModel[] newArray(int size) {
            return new ULOneFieldListItemModel[size];
        }
    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
    }

    private void readFromParcel(Parcel in) {
        mTitle = in.readString();
    }

    public int describeContents() {
        return 0;
    }
}
