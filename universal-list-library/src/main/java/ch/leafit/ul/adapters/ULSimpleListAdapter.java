package ch.leafit.ul.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ch.leafit.ul.list_items.ULListItemBaseModel;

import java.util.List;

/**
 * Created by marius on 26/06/14.
 *
 *
 * ListAdapter for Lists with only one on Entry type (so no sections etc.) --> use if possible --> better performance
 * than the others
 */
public class ULSimpleListAdapter<T extends ULListItemBaseModel> extends ULListAdapter{
    protected List<T> mListItems;
    protected LayoutInflater mInflater;

    public ULSimpleListAdapter(Context context, List<T> listItems) {
        mListItems = listItems;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mListItems.size();
    }

    @Override
    public T getItem(int i) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ULListItemBaseModel currentItem = mListItems.get(position);
        if(currentItem != null) {

            if(convertView == null) {
                int layoutID = currentItem.getViewLayoutId();
                convertView = mInflater.inflate(layoutID,parent,false);
            }

            currentItem.fillDataInView(convertView);

            return convertView;
        } else {
            return null;
        }
    }


}
