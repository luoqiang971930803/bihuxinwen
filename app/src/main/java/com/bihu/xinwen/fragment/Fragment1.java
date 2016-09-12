package com.bihu.xinwen.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.bihu.xinwen.R;
import com.bihu.xinwen.adapter.NewsAdapter;

/**
 * Created by luo on 2016/9/5.
 */
public class Fragment1 extends Fragment {
  private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recyclerView= (RecyclerView) inflater.inflate(R.layout.frangment_content,null);
        init();
        return recyclerView;
    }
    void init(){
 ;       LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        NewsAdapter.MyItemDecoration decoration=new NewsAdapter.MyItemDecoration(getContext(),R.drawable.recyclerview_item);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLayoutManager(mLayoutManager);
        final NewsAdapter newsAdapter=new NewsAdapter(getContext());
        newsAdapter.setOnItemClickListener(new  AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),"po"+i,Toast.LENGTH_SHORT).show();
                newsAdapter.removeItem(i);
            }
        });
        recyclerView.setAdapter(newsAdapter);
    }
}
