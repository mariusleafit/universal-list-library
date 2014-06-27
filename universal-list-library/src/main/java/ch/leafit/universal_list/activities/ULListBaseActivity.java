package ch.leafit.universal_list.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.widget.ListView;
import ch.leafit.universal_list.activities.intent_datastores.ULListActivityReturnIntentDatastore;
import ch.leafit.universal_list.adapters.ULListAdapter;
import ch.leafit.universal_list.list_items.ULListItemBaseModel;

import java.util.ArrayList;

/**
 * Created by marius on 27/06/14.
 */
public abstract class ULListBaseActivity extends ListActivity {

    protected ULListAdapter mListAdapter;

    protected void returnSelectedItems() {
        ListView listView = getListView();

        ArrayList<ULListItemBaseModel> selectedItems = new ArrayList<ULListItemBaseModel>();

        /*get checked items*/
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();

        if(checkedItemPositions != null) {
            for(int i = 0; i < mListAdapter.getCount(); i++) {
                if(checkedItemPositions.get(i)) {
                    Object checkedItem = mListAdapter.getItem(i);
                    if(checkedItem instanceof ULListItemBaseModel) {
                        selectedItems.add((ULListItemBaseModel)checkedItem);
                    }
                }
            }
        }

        ULListActivityReturnIntentDatastore returnIntentDatastore = new ULListActivityReturnIntentDatastore(selectedItems);

        Intent returnIntent = new Intent();
        //put data into intent
        returnIntentDatastore.getIntent(returnIntent);

        /*return*/
        setResult(ListActivity.RESULT_OK,returnIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        this.returnSelectedItems();
    }
}
