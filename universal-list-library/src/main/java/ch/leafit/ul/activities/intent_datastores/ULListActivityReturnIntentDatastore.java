package ch.leafit.ul.activities.intent_datastores;

import android.content.Context;
import android.content.Intent;
import ch.leafit.iac.IntentDatastore;
import ch.leafit.ul.list_items.ULListItemBaseModel;

import java.util.ArrayList;

/**
 * Created by marius on 27/06/14.
 *
 * contains data which is passed back from the listactivity to the calling activity
 */
public class ULListActivityReturnIntentDatastore extends IntentDatastore {
    /*
         * data-ids
         */
    private static final String selected_items_id = "selected_items";

    /*
     * data members
     */
    public ArrayList<ULListItemBaseModel> mSelectedItems;

    /**
     *
     * @param selectedItems selected items by the user
     */
    public ULListActivityReturnIntentDatastore(ArrayList<ULListItemBaseModel> selectedItems) {
        mSelectedItems = selectedItems;
    }


    public ULListActivityReturnIntentDatastore(Intent i){
        super(i);
        getExtra(i);
    }

    @Override
    public Intent getIntent(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        putExtra(intent);
        return intent;
    }

    @Override
    public Intent getIntent(Intent out) {
        putExtra(out);
        return out;
    }

    @Override
    protected void putExtra(Intent out) {
        out.putParcelableArrayListExtra(selected_items_id, mSelectedItems);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void getExtra(Intent in) {
        mSelectedItems = in.getParcelableArrayListExtra(selected_items_id);
    }
}
