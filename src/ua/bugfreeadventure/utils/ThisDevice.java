package ua.bugfreeadventure.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import ua.bugfreeadventure.R;

/**
 * Created by lietto on 12.09.2014.
 */
public class ThisDevice {

    public static int height(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        return displayMetrics.heightPixels;
    }

    public static int width(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        return displayMetrics.widthPixels;
    }

    public  static boolean isTablet(Context ctx) {
        return ctx.getResources().getBoolean(R.bool.isTablet);
    }

    public static double diagonal(WindowManager windowManager)	{
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);

        float width = displayMetrics.widthPixels / displayMetrics.densityDpi;
        float height = displayMetrics.heightPixels / displayMetrics.densityDpi;
        double d = Math.sqrt( width * width + height * height);
        Log.e("DisplayDiagonal", "Diagonal = " + d);

        return d;
    }

}
