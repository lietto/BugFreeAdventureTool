package ua.bugfreeadventure.activity;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import ua.bugfreeadventure.notifications.DevToast;
import ua.bugfreeadventure.notifications.LookAtMe;
import ua.bugfreeadventure.utils.ThisDevice;

/**
 * Created by lietto on 11.09.2014.
 */
public abstract class ParentActivity extends ActionBarActivity {

    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getThemeRes() != -1)
            setTheme(getThemeRes());

        super.onCreate(savedInstanceState);

        if (ThisDevice.isTablet(this))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        else
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(getMainLayoutRes());

        createUI();

        if (savedInstanceState == null) {
            nullStartSavingState();
        } else {
            notNullStartSavingState(savedInstanceState);
        }
    }

    protected void createUI() {
        setActionBarSettings();

        initViews();

        initEventListeners();
    }

    protected abstract int getMainLayoutRes();

    protected abstract int getThemeRes();

    /**
     * Set display optins and paramters for action bar
     */
    protected abstract void setActionBarSettings();

    /**
     * Init activity views
     */
    protected abstract void initViews();

    /**
     * Set listeners for item events
     */
    protected abstract void initEventListeners();

    /**
     * Insert code for first launch of activity
     */
    protected abstract void notNullStartSavingState(Bundle state);

    /**
     * Insert code for start with saved instance state
     */
    protected abstract void nullStartSavingState();

    /**
     * Save here the state of the activity
     */
    protected abstract void saveInstanceState(Bundle outState);

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(outState);
    }

    public void showErrorDevToast(String text) {
        DevToast.context(this).showRed(text);
    }

    public void showWarningDevToast(String text) {
        DevToast.context(this).showYellow(text);
    }

    public void showSuccessDevToast(String text) {
        DevToast.context(this).showGreen(text);
    }

    public void showErrorToastToUser(String text) {
        LookAtMe.context(this).showRed(text);
    }

    public void showWarningToastToUser(String text) {
        LookAtMe.context(this).showYellow(text);
    }

    public void showSuccessToastToUser(String text) {
        LookAtMe.context(this).showGreen(text);
    }

    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setMessage("Загрузка...");
        progressDialog.show();
    }

    public void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.cancel();
        }

    }

    protected ActionBar getToolBar() {
        return getSupportActionBar();
    }


}
