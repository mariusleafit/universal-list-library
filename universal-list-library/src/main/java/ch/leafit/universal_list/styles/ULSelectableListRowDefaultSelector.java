package ch.leafit.universal_list.styles;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by marius on 27/06/14.
 */
public class ULSelectableListRowDefaultSelector extends StateListDrawable {
    public ULSelectableListRowDefaultSelector() {

        /*pressed-status*/
        ColorDrawable pressedColor = new ColorDrawable(Color.argb(255,60,153,255));
        this.addState(new int[] { android.R.attr.state_pressed },pressedColor);

        /*selected-status*/
        ColorDrawable selectedColor = new ColorDrawable(Color.argb(255,125,175,255));
        this.addState(new int[] { android.R.attr.state_checked },selectedColor);

        /*activated-status*/
        ColorDrawable activatedColor = new ColorDrawable(Color.argb(255,255,255,255));
        this.addState(new int[] { android.R.attr.state_activated },activatedColor);
    }
}
