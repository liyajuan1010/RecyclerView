package com.example.dell.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

//new -->java class-->选继承RecyclerView.Adapter
public class MyAdapter extends RecyclerView.Adapter {
    public static final int ITEM_ITEM=0;
    public static final int FOOT_ITEM=1;
    private Context mContext;
    private List<Map<String,Object>> mdatalist;
    public MyAdapter(Context context, List<Map<String,Object>> datalist){
        mContext=context;
        mdatalist=datalist;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(mContext).inflate(R.layout.item_view,null);
        View footView=LayoutInflater.from(mContext).inflate(R.layout.foot_item,null);
        if(viewType==ITEM_ITEM){
            return new ViewHolder(itemView,viewType);
        }else {
            return new ViewHolder(footView,viewType);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         ViewHolder viewHolder=(ViewHolder)holder;
         if(getItemViewType(position)==ITEM_ITEM){
             viewHolder.ivImage.setImageResource((int)mdatalist.get(position).get("image"));
             viewHolder.tvTitle.setText((String)mdatalist.get(position).get("title"));
             viewHolder.tvInfo.setText((String)mdatalist.get(position).get("info"));
         }else {
             viewHolder.tvFootItem.setText("加载中...");
         }
    }

    @Override
    public int getItemCount() {
        return mdatalist.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(mdatalist.size()==position){
            return FOOT_ITEM;
        }else {
            return ITEM_ITEM;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivImage;
        TextView tvTitle;
        TextView tvInfo;
        TextView tvFootItem;
        public ViewHolder(View itemView,int itemType) {
            super(itemView);
            if(itemType==ITEM_ITEM){
                ivImage=(ImageView)itemView.findViewById(R.id.iv_image);
                tvInfo=(TextView)itemView.findViewById(R.id.tv_info);
                tvTitle=(TextView)itemView.findViewById(R.id.tv_title);
            }else {
                tvFootItem=(TextView)itemView.findViewById(R.id.tv_foot_item);
            }
        }
    }
}
