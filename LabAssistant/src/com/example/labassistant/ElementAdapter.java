package com.example.labassistant;

import android.content.Context;
//import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ElementAdapter extends BaseAdapter {

    private Context mContext;

    public ElementAdapter(Context c) // Constructor
    {
        mContext = c;
    }

    public Integer[] mThumbs = { R.drawable.e1, R.drawable.e2,
            R.drawable.e3, R.drawable.e4, R.drawable.e5,
            R.drawable.e6, R.drawable.e7, R.drawable.e8,
            R.drawable.e9, R.drawable.e10, R.drawable.e11,
            R.drawable.e12, R.drawable.e13, R.drawable.e14,
            R.drawable.e15, R.drawable.e16, R.drawable.e17,
            R.drawable.e18, R.drawable.e19, R.drawable.e20,
            R.drawable.e21, R.drawable.e22, R.drawable.e23,
            R.drawable.e24, R.drawable.e25, R.drawable.e26,
            R.drawable.e27, R.drawable.e28, R.drawable.e29,
            R.drawable.e30, R.drawable.e31, R.drawable.e32,
            R.drawable.e33, R.drawable.e34, R.drawable.e35,
            R.drawable.e36, R.drawable.e37, R.drawable.e38,
            R.drawable.e39, R.drawable.e40, R.drawable.e41,
            R.drawable.e42, R.drawable.e43, R.drawable.e44,
            R.drawable.e45, R.drawable.e46, R.drawable.e47,
            R.drawable.e48, R.drawable.e49, R.drawable.e50,
            R.drawable.e51, R.drawable.e52, R.drawable.e53,
            R.drawable.e54, R.drawable.e55, R.drawable.e56,
            R.drawable.e57, R.drawable.e58, R.drawable.e59,
            R.drawable.e60, R.drawable.e61, R.drawable.e62,
            R.drawable.e63, R.drawable.e64, R.drawable.e65,
            R.drawable.e66, R.drawable.e67, R.drawable.e68,
            R.drawable.e69, R.drawable.e70, R.drawable.e71,
            R.drawable.e72, R.drawable.e73, R.drawable.e74,
            R.drawable.e75, R.drawable.e76, R.drawable.e77,
            R.drawable.e78, R.drawable.e79, R.drawable.e80,
            R.drawable.e81, R.drawable.e82, R.drawable.e83,
            R.drawable.e84, R.drawable.e85, R.drawable.e86,
            R.drawable.e87, R.drawable.e88, R.drawable.e89,
            R.drawable.e90, R.drawable.e91, R.drawable.e92,
            R.drawable.e93, R.drawable.e94, R.drawable.e95,
            R.drawable.e96, R.drawable.e97, R.drawable.e98,
            R.drawable.e99, R.drawable.e100, R.drawable.e101,
            R.drawable.e102, R.drawable.e103, R.drawable.e104,
            R.drawable.e105, R.drawable.e106, R.drawable.e107,
            R.drawable.e108, R.drawable.e109, R.drawable.e110,
            R.drawable.e111, R.drawable.e112};

    @Override
    public int getCount()
    {
        return mThumbs.length;
    }

    @Override
    public Object getItem(int position)
    {
        return mThumbs[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        if (convertView == null)
        // Recycled View
        {
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new GridView.LayoutParams(220, 220));
        } else
        // Re-use the view
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbs[position]);
        return imageView;
    }

}

