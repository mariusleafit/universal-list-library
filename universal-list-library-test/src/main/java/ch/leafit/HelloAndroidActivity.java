package ch.leafit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ch.leafit.universal_list.activities.ULListActivity;
import ch.leafit.universal_list.activities.intent_datastores.ULListActivityIntentDatastore;
import ch.leafit.universal_list.adapters.ULDynamicListAdapter;
import ch.leafit.universal_list.adapters.ULSectionedListAdapter;
import ch.leafit.universal_list.adapters.ULSimpleListAdapter;
import ch.leafit.universal_list.list_items.ULListItemBaseModel;
import ch.leafit.universal_list.list_items.ULOneFieldListItemModel;
import ch.leafit.universal_list.list_items.ULSectionTitleListItemModel;
import ch.leafit.universal_list.list_items.ULTwoFieldsListItemModel;
import ch.leafit.universal_list.styles.ULSelectableListRowDefaultSelector;

import java.util.ArrayList;
import java.util.List;

public class HelloAndroidActivity extends Activity {

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.lstTest);

        ArrayList<ULListItemBaseModel> simpleItems = new ArrayList<ULListItemBaseModel>();
        simpleItems.add(new ULSectionTitleListItemModel("Section"));
        simpleItems.add(new ULOneFieldListItemModel("Marius"));
        simpleItems.add(new ULOneFieldListItemModel("Marikus"));
        simpleItems.add(new ULOneFieldListItemModel("Neuchatel"));
        simpleItems.add(new ULOneFieldListItemModel("Computer"));
        simpleItems.add(new ULSectionTitleListItemModel("Section"));
        simpleItems.add(new ULOneFieldListItemModel("IntelliJ"));
        simpleItems.add(new ULOneFieldListItemModel("Einkaufen"));
        simpleItems.add(new ULTwoFieldsListItemModel("Marius","Gächter"));
        simpleItems.add(new ULOneFieldListItemModel("Marius"));



        ULDynamicListAdapter simpleListAdapter = new ULDynamicListAdapter(this, simpleItems);



        //listView.setAdapter(simpleListAdapter);

        List<String> stringItems = new ArrayList<String>();
        stringItems.add("asdfasdf");
        stringItems.add("sdfr");
        stringItems.add("rrr");
        stringItems.add("xcv");
        stringItems.add("45345345345345");

        ArrayAdapter<String> tstAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stringItems);
        listView.setAdapter(tstAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setSelector(new ULSelectableListRowDefaultSelector());
    }

    public void btnOpenListClick(View v) {

        ULOneFieldListItemModel defaultValue = new ULOneFieldListItemModel("Marius");

        ArrayList<ULListItemBaseModel> simpleItems = new ArrayList<ULListItemBaseModel>();
        simpleItems.add(new ULSectionTitleListItemModel("Section"));
        simpleItems.add(defaultValue);
        simpleItems.add(new ULOneFieldListItemModel("Marikus"));
        simpleItems.add(new ULOneFieldListItemModel("Neuchatel"));
        simpleItems.add(new ULOneFieldListItemModel("Computer"));
        simpleItems.add(new ULSectionTitleListItemModel("Section"));
        simpleItems.add(new ULOneFieldListItemModel("IntelliJ"));
        simpleItems.add(new ULOneFieldListItemModel("Einkaufen"));
        simpleItems.add(new ULTwoFieldsListItemModel("Marius","Gächter"));
        simpleItems.add(new ULOneFieldListItemModel("Marius"));

        ULListActivityIntentDatastore intentDatastore = new ULListActivityIntentDatastore("Meine Liste",simpleItems,defaultValue);

        Intent listIntent =  intentDatastore.getIntent(this, ULListActivity.class);

        startActivity(listIntent);
    }


}

