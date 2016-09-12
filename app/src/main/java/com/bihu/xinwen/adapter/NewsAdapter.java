package com.bihu.xinwen.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bihu.xinwen.R;
import com.bihu.xinwen.activity.MainActivity;
import com.bihu.xinwen.entrty.NewsEntrty;

import java.util.ArrayList;

/**
 * Created by luo on 2016/9/5.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>implements View.OnClickListener {
    private Context context;
    private ArrayList<NewsEntrty> data;
    private AdapterView.OnItemClickListener onItemClickListener;
    public  NewsAdapter(Context context){
        this.context=context;
        data=new ArrayList<NewsEntrty>();
        for(int i=0;i<100;i++){
            NewsEntrty newsEntrty=new NewsEntrty("HHHHHH",2016-2-2,"新闻发布地方");
            data.add(newsEntrty);

        }
    }
    public   void removeItem(int postion){
        data.remove(postion);
        notifyItemRemoved(postion);
    }
    public void setOnItemClickListener(AdapterView.OnItemClickListener itemClickListener){

        this.onItemClickListener = itemClickListener;
    }
    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.view_item, parent, false);
        /*RecyclerView.LayoutParams params=new  RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,0,0,100);
        view.setLayoutParams(params);*/
        view.setOnClickListener(this);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewsEntrty newsEntrty=data.get(position);
        //int positions=holder.getLayoutPosition();
        holder.itemView.setTag(holder);
        holder.title.setText(newsEntrty.getTitle());
        holder.date.setText(newsEntrty.getDate()+"");
        holder.source.setText(newsEntrty.getSource());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {
        MyViewHolder holder=(MyViewHolder)view.getTag();
        int postion=holder.getLayoutPosition();
        onItemClickListener.onItemClick(null,view,postion,getItemId(postion));
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView date;
        TextView  source;
       /* ImageView imageView;
       TextView textView;*/
        //View itemView;
        public MyViewHolder(View itemView) {
            super(itemView);
            //this.itemView=itemView;
            title= (TextView) (itemView.findViewById(R.id.tv_title));
            date= (TextView) (itemView.findViewById(R.id.tv_date));
            source= (TextView)(itemView.findViewById(R.id.tv_source));
        }
    }
     public static class MyItemDecoration extends RecyclerView.ItemDecoration {
        Drawable drawable;

        public MyItemDecoration(Context context,int attr) {
            drawable=context.getResources().getDrawable(attr);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
            int left=0,top=0,right=0,botton=0;
            for(int i=0;i<parent.getChildCount();i++) {
                RelativeLayout relativeLayout = (RelativeLayout) parent.getChildAt(i);
                RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) relativeLayout.getLayoutParams();
                left = parent.getPaddingLeft();
                top = relativeLayout.getBottom()+params.bottomMargin;
                right = relativeLayout.getWidth() - parent.getPaddingRight();
                botton = top + drawable.getIntrinsicHeight();
                drawable.setBounds(left, top, right, botton);
                drawable.draw(c);
            }
        }
    }
}
