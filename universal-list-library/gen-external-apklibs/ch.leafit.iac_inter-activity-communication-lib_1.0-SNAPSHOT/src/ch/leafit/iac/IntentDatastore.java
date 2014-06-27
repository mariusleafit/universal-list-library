package ch.leafit.iac;

import android.content.Context;
import android.content.Intent;

/**
 * Created by marius on 26/06/14.
 */
public abstract class IntentDatastore {
    /*
	 * data members
	 */

    public IntentDatastore() {}

    /**
     *
     * @param gets the data from intents-extra
     */
    public IntentDatastore(Intent i) {}

    /**
     *
     * @param context
     * @param cls type of Activity
     * @return returns intent with data of intentdatastore in extra
     */
    public abstract Intent getIntent(Context context, Class<?> cls);

    /**
     *
     * @param intent
     * @return returns the passed Intent with the extras of the datastore
     */
    public abstract Intent getIntent(Intent out);

    /**
     *
     * @param out puts the datastores-data into the extra of the intent
     */
    protected abstract void putExtra(Intent out);

    /**
     *
     * @param in takes the extra-data and puts in into the store
     */
    protected abstract void getExtra(Intent in);
}
