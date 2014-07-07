package ch.leafit.ul.adapters;

import android.content.Context;
import android.widget.Filter;
import android.widget.Filterable;
import ch.leafit.ul.list_items.ULListItemBaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marius on 26/06/14.
 */
public class ULSearchableSimpleListAdapter<T extends ULListItemBaseModel> extends ULSimpleListAdapter<T> implements Filterable {

    private ULItemFilter mFilter;
    private List<T> mUnfilteredMenuItems;

    public ULSearchableSimpleListAdapter(Context context, List<T> listItems) {
        super(context,listItems);
        mUnfilteredMenuItems = listItems;
    }

    /*
	 * @Filterable members
	 */

    public Filter getFilter() {
        if(mFilter == null)
            mFilter = new ULItemFilter();
        return mFilter;
    }


    /*
     * Filter implementation
     */
    private class ULItemFilter extends Filter {

        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (constraint == null || constraint.length() == 0) {
                // No filter implemented we return all the list
                results.values = mUnfilteredMenuItems;
                results.count = mUnfilteredMenuItems.size();
            } else {
                // We perform filtering operation
                List<T> nListItems = new ArrayList<T>();

                for (T item : mUnfilteredMenuItems) {
                    if(item.passesFilterTest(constraint))
                        nListItems.add(item);
                }

                results.values = nListItems;
                results.count = nListItems.size();

            }
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // Now we have to inform the adapter about the new list filtered
            mListItems = (List<T>) results.values;
            notifyDataSetChanged();
        }

    }
}
