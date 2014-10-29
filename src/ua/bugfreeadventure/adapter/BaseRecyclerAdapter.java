package ua.bugfreeadventure.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lietto on 29.10.14.
 *
 * Created like example
 */
abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder> {

    protected  List<? extends Object> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        private View thisView;

        public ViewHolder(View v) {
            super(v);
            thisView = v;
        }

        public View getThisView() {
            return thisView;
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public BaseRecyclerAdapter(List<? extends Object> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BaseRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(getItemLayout(), parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    protected abstract int getItemLayout();

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        setViewItemsData(holder, position);

    }

    protected abstract void setViewItemsData(ViewHolder holder, int position);

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
