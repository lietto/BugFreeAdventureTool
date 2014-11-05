package ua.bugfreeadventure.fragment;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ua.bugfreeadventure.activity.ParentActivity;

/**
 * Created by lietto on 11.09.2014.
 */
public abstract class ParentFragment extends Fragment{

    protected String TAG = this.getClass().getSimpleName();

    protected View fragmentView;


    protected ParentActivity getOwner() {
        return (ParentActivity) getActivity();
    }

    protected ActionBar getActionBar() {
        return getActivity().getActionBar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentView = inflater.inflate(getViewLayoutId(), container, false);

        initActionBar();

        initView(fragmentView);

        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEventListeners();
    }


    protected abstract void initView(View view);

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
