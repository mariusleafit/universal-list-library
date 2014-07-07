package ch.leafit.ul.list_items;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import ch.leafit.ul.R;

/**
 * Created by marius on 26/06/14.
 *
 * Title Row of a List-Section
 */
public class ULSectionTitleListItemModel extends ULListItemBaseModel {

    protected String mTitle;

    public ULSectionTitleListItemModel(String title) {
        mTitle = title;
    }

    public ULSectionTitleListItemModel(Parcel in) {
        readFromParcel(in);
    }


    /**
     *
     * @return The layoutId of the ListEntryView layout
     */
    public int getViewLayoutId() {
        return R.layout.section_title_item;
    }


    /**
     * Fills data of currentInstance into the View
     * @param ListEntryView probably the convertView from the ListAdapter
     */
    public void fillDataInView(View v) {
        if(v != null) {
            TextView txtTitle = (TextView)v.findViewById(R.id.txtTitle);
            if(txtTitle != null) {
                txtTitle.setText(mTitle);
            }
        }
    }

    @Override
    public boolean passesFilterTest(CharSequence filterText) {
        return true;
    }

    @Override
    public String getValueString() {
        return null;
    }


    /*
	 * @Parcelable
	 */

    public static final Parcelable.Creator<ULSectionTitleListItemModel> CREATOR = new Parcelable.Creator<ULSectionTitleListItemModel>() {
        public ULSectionTitleListItemModel createFromParcel(Parcel in ) {
            return new ULSectionTitleListItemModel(in);
        }

        public ULSectionTitleListItemModel[] newArray(int size) {
            return new ULSectionTitleListItemModel[size];
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
