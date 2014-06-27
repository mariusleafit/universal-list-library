package ch.leafit.universal_list.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import ch.leafit.universal_list.activities.intent_datastores.ULListActivityIntentDatastore;
import ch.leafit.universal_list.adapters.ULListAdapter;
import ch.leafit.universal_list.adapters.ULListAdapterFactory;

/**
 * Created by marius on 27/06/14.
 */
public class ULListActivity extends ListActivity {

    protected ULListActivityIntentDatastore mIntentDatastore;
    protected ULListAdapter mListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * initialize IntentDatastore
         * check if null to avoid overwriting in case of overriding of onCreate() by subclass
         */
        if(mIntentDatastore == null) {
            mIntentDatastore = new ULListActivityIntentDatastore(getIntent());

            setTitle(mIntentDatastore.mActivityTitle);

            /*configure list*/
            if(mIntentDatastore.mListItems != null) {

                /*set list selectable*/
                ListView listView = getListView();
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

                //get listitems from intent
                mListAdapter = ULListAdapterFactory.getCorrectAdapterForItemsList(this, mIntentDatastore.mListItems);

                setListAdapter(mListAdapter);

                /*set defaultValue if necessary*/
                if(mIntentDatastore.mDefaultValuePosition != -1) {
                    listView.setSelection(mIntentDatastore.mDefaultValuePosition);
                }
            }
        }
    }
}
