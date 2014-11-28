package ua.bugfreeadventure.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ua.bugfreeadventure.activity.ParentActivity;

/**
 * Created by lietto on 11.09.2014.
 */
public abstract class ParentFragment extends Fragment {


    protected String TAG = this.getClass().getSimpleName();
    private View fragmentView;

    protected ParentActivity getOwner() {
        return (ParentActivity) getActivity();
    }

    protected ActionBar getActionBar() {
        return getOwner().getSupportActionBar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentView = getFragmentView(inflater, container);

        initActionBar();

        initViews(fragmentView);

        if (savedInstanceState == null) {
            nullStartSavingState();
        } else {
            notNullStartSavingState(savedInstanceState);
        }

        return fragmentView;
    }

    protected abstract void notNullStartSavingState(Bundle state);

    protected abstract void nullStartSavingState();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEventListeners();
    }

    private View getFragmentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(getViewLayoutId(), container, false);
    }

    protected View getMainView() {
        return fragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(outState);
    }

    protected abstract void saveInstanceState(Bundle outState);

    protected abstract void initViews(View view);

    protected abstract void initActionBar();

    protected abstract void initEventListeners();

    protected abstract int getViewLayoutId();

    protected void showErrorDevToast(String text) {
        getOwner().showErrorDevToast(text);
    }

    protected void showWarningDevToast(String text) {
        getOwner().showWarningDevToast(text);
    }

    protected void showSuccessDevToast(String text) {
        getOwner().showSuccessDevToast(text);
    }

    protected void showErrorToastToUser(String text) {
        getOwner().showErrorToastToUser(text);
    }

    protected void showWarningToastToUser(String text) {
        getOwner().showWarningToastToUser(text);
    }

    protected void showSuccessToastToUser(String text) {
        getOwner().showSuccessToastToUser(text);
    }

}
