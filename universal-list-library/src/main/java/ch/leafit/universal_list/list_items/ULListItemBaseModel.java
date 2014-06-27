package ch.leafit.universal_list.list_items;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.UUID;

/**
 * Created by marius on 26/06/14.
 */
public abstract class ULListItemBaseModel implements Parcelable {

    /**
     *
     * @return The layoutId of the ListEntryView layout
     */
    public abstract int getViewLayoutId();


    /**
     * Fills data of currentInstance into the View
     * @param ListEntryView probably the convertView from the ListAdapter
     */
    public abstract void fillDataInView(View v);


    /**
     *
     * @param text to be compared with the content of the model
     * @return true: "item stays in list" false: "item will be hidden in list"
     */
    public abstract boolean passesFilterTest(CharSequence filterText);
}
