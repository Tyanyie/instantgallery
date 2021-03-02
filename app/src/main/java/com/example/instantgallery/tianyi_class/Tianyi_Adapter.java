package com.example.instantgallery.tianyi_class;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.example.instantgallery.R;

import java.io.File;
import java.net.URI;
import java.util.List;

public class Tianyi_Adapter extends BaseAdapter
{
    public static final String TAG = "My";
    private final Context mContext;
    List<String> photoPathList;
    private ViewHolder myViewHolder;
    public Uri uri;
    public Tianyi_Adapter(Context context, List<String> photoPathList)
    {

        this.mContext = context;
        this.photoPathList = photoPathList;
        
    }



    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount()
    {
        return photoPathList.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position)
    {
        return photoPathList.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position)
    {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        File f = new File(photoPathList.get(position));
        uri = Uri.parse(f.toString());


        /*
        * Todo
        *  [√]use photoPathList.get(position) to get path
        *  [ ]and load path to Bitmap in Tianyi_Single_Image_View
        * */

        if (null == convertView)
        {
            myViewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.tianyi_grid_item, null);
            myViewHolder.myImageView = convertView.findViewById(R.id.iv_grid_item);
            //convertView.setTag(myViewHolder);
        }

        if (f.exists())
        {

            //myViewHolder.myImageView.setImageURI(Uri.fromFile(f));
            Glide.with(mContext).load(photoPathList.get(position)).into(myViewHolder.myImageView);

            Log.i(TAG, "f is " + f.getClass().getName() + "type");


        }
        else
        {
            Log.i(TAG, "Image Not Found");
        }

        return convertView;


    }

    public String getPhotoPathById(int id)
    {
        return photoPathList.get(id);
    }

    public class ViewHolder
    {
        Tianyi_ImageView myImageView;

    }

}
