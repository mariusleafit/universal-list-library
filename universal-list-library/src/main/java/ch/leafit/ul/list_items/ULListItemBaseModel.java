package ch.leafit.ul.list_items;

import android.os.Parcelable;
import android.view.View;

/**
 * Created by marius on 26/06/14.
 *
 * Subclass this class to create your own listItem-types
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
     * @return String which represents the Value of the ListItem
     */
    public abstract String getValueString();

    /**
     *
     * @param text to be compared with the content of the model
     * @return true: "item stays in list" false: "item will be hidden in list"
     */
    public abstract boolean passesFilterTest(CharSequence filterText);
}
