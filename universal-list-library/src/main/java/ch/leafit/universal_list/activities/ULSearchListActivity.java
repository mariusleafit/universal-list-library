package ch.leafit.universal_list.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.ListView;
import ch.leafit.R;
import ch.leafit.universal_list.activities.intent_datastores.ULListActivityIntentDatastore;
import ch.leafit.universal_list.adapters.ULListAdapter;
import ch.leafit.universal_list.adapters.ULListAdapterFactory;

/**
 * Created by marius on 27/06/14.
 */
public class ULSearchListActivity extends ULListBaseActivity {
    protected ULListActivityIntentDatastore mIntentDatastore;

    /*UI-Elements*/
    protected EditText mTxtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_list_activity);

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
                mListAdapter = ULListAdapterFactory.getCorrectSearchableAdapterForItemsList(this, mIntentDatastore.mListItems);
                setListAdapter(mListAdapter);

                /*set defaultValue if necessary*/
                if(mIntentDatastore.mDefaultValuePosition != -1) {
                    listView.setItemChecked(mIntentDatastore.mDefaultValuePosition, true);
                }
            }


        /*initialize UI-Elements*/
            mTxtSearch = (EditText)findViewById(R.id.txtSearch);
            if(mListAdapter instanceof Filterable) {
                mTxtSearch.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        ((Filterable) ULSearchListActivity.this.mListAdapter).getFilter().filter(charSequence);
                        Log.i("adsf", "Search!!");
                    }
                    @Override
                    public void afterTextChanged(Editable editable) {}
                });
            }
        }
    }
}
