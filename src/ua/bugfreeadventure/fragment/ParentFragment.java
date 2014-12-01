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

    protected ParentActivity getParentActivity() {
        return (ParentActivity) getActivity();
    }

    protected ActionBar getActionBar() {
        return getParentActivity().getSupportActionBar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentView = getFragmentView(inflater, container);

        initActionBar(fragmentView);

        initViews(fragmentView);

        if (savedInstanceState == null) {
            nullStartSavingState(fragmentView);
        } else {
            notNullStartSavingState(savedInstanceState, fragmentView);
        }

        return fragmentView;
    }

    protected abstract int getViewLayoutId();

    protected abstract void initActionBar(View fragmView);

    protected abstract void initViews(View view);

    protected abstract void initEventListeners(View fragmView);

    protected abstract void notNullStartSavingState(Bundle state, View fragmView);

    protected abstract void nullStartSavingState(View fragmView);

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEventListeners(getMainView());
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

    protected void showErrorDevToast(String text) {
        getParentActivity().showErrorDevToast(text);
    }

    protected void showWarningDevToast(String text) {
        getParentActivity().showWarningDevToast(text);
    }

    protected void showSuccessDevToast(String text) {
        getParentActivity().showSuccessDevToast(text);
    }

    protected void showErrorToastToUser(String text) {
        getParentActivity().showErrorToastToUser(text);
    }

    protected void showWarningToastToUser(String text) {
        getParentActivity().showWarningToastToUser(text);
    }

    protected void showSuccessToastToUser(String text) {
        getParentActivity().showSuccessToastToUser(text);
    }

}
