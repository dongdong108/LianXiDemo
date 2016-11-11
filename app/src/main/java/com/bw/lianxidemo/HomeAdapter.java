package com.bw.lianxidemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by asus on 2016/11/11.
 */

public class HomeAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener{
    private List<HomeBean.DataBean> list;
    private Context context;
    private  BitmapUtils bitmapUtils;
    public HomeAdapter(Context context, List<HomeBean.DataBean> list) {
        this.context = context;
        this.list = list;
        bitmapUtils = new BitmapUtils(context);
    }
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //define interface
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item, parent,
                    false);
            MyViewHolder holder = new MyViewHolder(view);
            view.setOnClickListener(this);
            return holder;

    }
    /**
     * 数据的绑定显示
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            ((MyViewHolder) holder).tv.setText(list.get(position).getGoods_name());
            // 参数一:显示图片的容器
            // 参数二:图片路径
            bitmapUtils.display(((MyViewHolder) holder).iv, list.get(position).getGoods_img());
            //将数据保存在itemView的Tag中，以便点击时进行获取
            holder.itemView.setTag(list.get(position).getWatermarkUrl());
    }



    @Override
    public int getItemCount()
    {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(view,(String)view.getTag());
        }
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    class MyViewHolder extends ViewHolder {

        TextView tv;
        ImageView iv;

        public MyViewHolder(View view)
        {
            super(view);

            tv = (TextView) view.findViewById(R.id.id_num);
            iv = (ImageView) view.findViewById(R.id.id_iv);
        }
    }

}