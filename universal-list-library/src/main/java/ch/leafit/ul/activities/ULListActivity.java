package ch.leafit.ul.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import ch.leafit.ul.activities.intent_datastores.ULListActivityIntentDatastore;
import ch.leafit.ul.adapters.ULListAdapterFactory;

/**
 * Created by marius on 27/06/14.
 */
public class ULListActivity extends ULListBaseActivity {

    protected ULListActivityIntentDatastore mIntentDatastore;



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
                ListView listView = getListView();

                /*set choiceMode*/
                listView.setChoiceMode(mIntentDatastore.mListViewChoiceMode);

                /*set adapter*/
                mListAdapter = ULListAdapterFactory.getCorrectAdapterForItemsList(this, mIntentDatastore.mListItems);
                setListAdapter(mListAdapter);

                /*set defaultValue if necessary*/
                if(mIntentDatastore.mDefaultValuePosition != -1) {
                    listView.setItemChecked(mIntentDatastore.mDefaultValuePosition, true);
                }

                //if single choice we want to leave the list as soon as a selection was made
                if(mIntentDatastore.mListViewChoiceMode == ListView.CHOICE_MODE_SINGLE) {
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                            /*set item as checked & leave the activity*/
                            ((ListView)adapterView).setItemChecked(position, true);
                            ULListActivity.this.returnSelectedItems();
                        }
                    });
                }
            }
        }
    }
}
