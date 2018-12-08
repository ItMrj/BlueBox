package com.languang.bluebox.adapter.picturestorege;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.languang.bluebox.constant.ApiConstant;
import com.languang.bluebox.entity.ImgEntity;
import com.mrj.framworklib.utils.ScreenUtilBase;

import java.io.File;
import java.util.List;

import com.languang.bluebox.R;
import com.languang.bluebox.basework.utils.GlideUtils;

/**
 * @author 49829
 * @date 2018/4/12
 */

public class TimeGridAdapter extends BaseAdapter {
    private Context context;
    private List<ImgEntity> list;
    private LayoutInflater inflater;

    public TimeGridAdapter(Context context, List<ImgEntity> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_time_grid, null);
            holder = new ViewHolder();
            holder.relativeLayout = convertView.findViewById(R.id.time_grid_rl);
            ImageView imageView = new ImageView(context);
            holder.relativeLayout.addView(imageView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = (ScreenUtilBase.getScreenWidth(context) / 3 - 10);
            layoutParams.height = (ScreenUtilBase.getScreenWidth(context) / 3 - 10);
            layoutParams.setMargins(5, 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
//            imageView.setImageResource(R.mipmap.meinv);
            ImgEntity imgEntity = list.get(position);
            Glide.with(context).asBitmap().load(ApiConstant.BOX_BASE_URL+"/public/" + imgEntity.getSmallpath() + imgEntity.getSmallname()).into(imageView);
            Log.d("mrjLog", "getView: "+(ApiConstant.BOX_BASE_URL+"/public" + imgEntity.getSmallpath() + imgEntity.getSmallname()));
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();

        return convertView;
    }

    class ViewHolder {
        LinearLayout relativeLayout;
    }
}
