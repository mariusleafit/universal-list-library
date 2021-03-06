package ch.leafit.ul.adapters;

import android.content.Context;
import ch.leafit.ul.list_items.ULListItemBaseModel;
import ch.leafit.ul.list_items.ULSectionTitleListItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marius on 27/06/14.
 */
public final class ULListAdapterFactory {

    /**
     *
     * @param context Context for which the adapter is created
     * @param itemsList Items you want to have in the list
     * @return ListAdapter with the optimal type for the task
     */
    public static ULListAdapter getCorrectAdapterForItemsList(Context context, List<ULListItemBaseModel> itemsList) {
        ULListAdapter returnAdapter = null;

        /*
            * get different viewtypes
         */
        ArrayList<Class> availableViewTypes = new ArrayList<Class>();
        //count the different viewtypes
        for (ULListItemBaseModel currentItem : itemsList) {
            Class currentViewType = currentItem.getClass();
            if(!availableViewTypes.contains(currentViewType)) {
                availableViewTypes.add(currentViewType);
            }
        }

        if(availableViewTypes.size() != 0) {
            if (availableViewTypes.size() == 1) { //--> SimpleList
                returnAdapter = new ULSimpleListAdapter<ULListItemBaseModel>(context,itemsList);
            } else if(availableViewTypes.size() == 2 && availableViewTypes.contains(ULSectionTitleListItemModel.class)) { //-> SectionedList
                returnAdapter = new ULSectionedListAdapter<ULListItemBaseModel>(context,itemsList);
            } else { //--> DynamicList
                returnAdapter = new ULDynamicListAdapter(context,itemsList);
            }

        }

        return returnAdapter;
    }

    /**
     *
     * @param context Context for which the adapter is created
     * @param itemsList Items you want to have in the list
     * @return ListAdapter with the optimal type for the task
     */
    public static ULListAdapter getCorrectSearchableAdapterForItemsList(Context context, List<ULListItemBaseModel> itemsList) {
        ULListAdapter returnAdapter = null;

        /*
            * get different viewtypes
         */
        ArrayList<Class> availableViewTypes = new ArrayList<Class>();
        //count the different viewtypes
        for (ULListItemBaseModel currentItem : itemsList) {
            Class currentViewType = currentItem.getClass();
            if(!availableViewTypes.contains(currentViewType)) {
                availableViewTypes.add(currentViewType);
            }
        }

        if(availableViewTypes.size() != 0) {
            if (availableViewTypes.size() == 1) { //--> SimpleList
                returnAdapter = new ULSearchableSimpleListAdapter<ULListItemBaseModel>(context,itemsList);
            } else if(availableViewTypes.size() == 2 && availableViewTypes.contains(ULSectionTitleListItemModel.class)) { //-> SectionedList
                returnAdapter = new ULSearchableSectionedListAdapter<ULListItemBaseModel>(context,itemsList);
            } else { //--> DynamicList
                returnAdapter = new ULSearchableDynamicListAdapter(context,itemsList);
            }

        }

        return returnAdapter;
    }
}
