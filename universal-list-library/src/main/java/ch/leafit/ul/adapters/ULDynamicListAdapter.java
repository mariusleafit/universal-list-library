package ch.leafit.ul.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ch.leafit.ul.list_items.ULListItemBaseModel;

import java.util.*;

/**
 * Created by marius on 26/06/14.
 *
 * Manages a List with dynamic number of different ViewTypes
 */
public class ULDynamicListAdapter extends ULListAdapter {

    protected List<ULListItemBaseModel> mListItems;
    protected LayoutInflater mInflater;


    protected ArrayList<Class> mItemTypesOfList;

    public ULDynamicListAdapter(Context context, List<ULListItemBaseModel> listItems) {
        mListItems = listItems;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mListItems.size();
    }

    @Override
    public ULListItemBaseModel getItem(int i) {
        if(i >= 0 && i < mListItems.size()) {
            return mListItems.get(i);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        if(mItemTypesOfList == null) {
            mItemTypesOfList = getDifferentViewTypes();
        }
        return mItemTypesOfList.size();
    }

    @Override
    public int getItemViewType(int position) {
        ULListItemBaseModel currentItem = mListItems.get(position);
        if(mItemTypesOfList == null) {
            mItemTypesOfList = getDifferentViewTypes();
        }

        int viewType = mItemTypesOfList.indexOf(currentItem.getClass());
        return  (viewType == -1) ? 0:viewType;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ULListItemBaseModel currentItem = mListItems.get(position);
        if(currentItem != null) {

            if(convertView == null) {
                int layoutID = currentItem.getViewLayoutId();
                convertView = mInflater.inflate(layoutID,parent,false);
            }

            currentItem.fillDataInView(convertView);
        }
        return convertView;
    }

    protected ArrayList<Class> getDifferentViewTypes() {
        ArrayList<Class> availableViewTypes = new ArrayList<Class>();

        //count the different viewtypes
        for (ULListItemBaseModel currentItem : mListItems) {
            Class currentViewType = currentItem.getClass();
            if (!availableViewTypes.contains(currentViewType)) {
                availableViewTypes.add(currentViewType);
            }
        }

        //return minimum 1
        return availableViewTypes;
    }
}
