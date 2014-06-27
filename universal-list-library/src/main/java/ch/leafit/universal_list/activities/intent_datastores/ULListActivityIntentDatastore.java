package ch.leafit.universal_list.activities.intent_datastores;

import android.content.Context;
import android.content.Intent;
import ch.leafit.iac.IntentDatastore;
import ch.leafit.universal_list.list_items.ULListItemBaseModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by marius on 27/06/14.
 * Contains the data to be passed to the ULListActivity
 */
public class ULListActivityIntentDatastore extends IntentDatastore {
    /*
	 * data-ids
	 */
    private static final String activity_title_id = "activity_title";
    private static final String list_items_id = "list_items";
    private static final String default_value_id = "default_value";
    private static final String choise_mode_id = "choise_mode";

    /*
     * data members
     */
    public String mActivityTitle;
    public ArrayList<ULListItemBaseModel> mListItems;
    public int mDefaultValuePosition;

    public ULListActivityIntentDatastore(String activityTitle, ArrayList<ULListItemBaseModel> listItems, ULListItemBaseModel defaultValue) {
        mActivityTitle = activityTitle;
        mListItems = listItems;
        mDefaultValuePosition = listItems.indexOf(defaultValue);
    }

    public ULListActivityIntentDatastore(Intent i){
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
        out.putExtra(activity_title_id,mActivityTitle);
        out.putParcelableArrayListExtra(list_items_id, mListItems);
        out.putExtra(default_value_id, mDefaultValuePosition);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void getExtra(Intent in) {
        mActivityTitle = in.getStringExtra(activity_title_id);
        mListItems = in.getParcelableArrayListExtra(list_items_id);
        mDefaultValuePosition = in.getIntExtra(default_value_id, -1);
    }
}
