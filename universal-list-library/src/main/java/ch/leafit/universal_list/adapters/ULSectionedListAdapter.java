package ch.leafit.universal_list.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import ch.leafit.universal_list.list_items.ULListItemBaseModel;
import ch.leafit.universal_list.list_items.ULSectionTitleListItemModel;

import java.util.List;
import java.util.UUID;

/**
 * Created by marius on 26/06/14.
 *
 * Manages a List which contains Rows of the type T and ULSecitonTileListItemModel
 */
public class ULSectionedListAdapter<T extends ULListItemBaseModel> extends ULListAdapter {

    private static final int SECTION_TITLE_VIEW_TYPE = 0;
    private static final int T_VIEW_TYPE = 1;
    //T and ULSecitonTileListItemModel
    private static final int VIEW_TYPE_COUNT = 2;


    protected List<ULListItemBaseModel> mListItems;
    protected LayoutInflater mInflater;

    public ULSectionedListAdapter(Context context, List<ULListItemBaseModel> listItems) {
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
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        ULListItemBaseModel currentItem = mListItems.get(position);

        if(currentItem.getClass() == ULSectionTitleListItemModel.class) { /*item is a section title*/
            return SECTION_TITLE_VIEW_TYPE;
        } else { /*item is T*/
            return T_VIEW_TYPE;
        }
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
