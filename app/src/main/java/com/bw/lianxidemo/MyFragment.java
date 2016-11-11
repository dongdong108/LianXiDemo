package com.bw.lianxidemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;

public class MyFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private List<HomeBean.DataBean> list;
    private HomeAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    private String mPath = "http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.fragment,null);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.id_recyclerview);

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        initData();
        super.onActivityCreated(savedInstanceState);
    }

    private void initData() {
        OkHttp.getAsync(mPath,
                new OkHttp.DataCallBack() {


                    @Override
                    public void requestFailure(Request request, IOException e) {

                    }

                    @Override
                    public void requestSuccess(String result) throws Exception {
//                        Log.d("dsadadddd",result);
//                        Toast.makeText(getActivity(),result ,0).show();
                        Gson gson = new Gson();
                        HomeBean mHomeBean = gson.fromJson(result, HomeBean.class);


                        //得到gridView的类
                        list = mHomeBean.getData();
                        mAdapter = new HomeAdapter(getActivity(),list);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.setOnItemClickListener(new HomeAdapter.OnRecyclerViewItemClickListener(){
                            @Override
                            public void onItemClick(View view , String data){
//                                Toast.makeText(getActivity(), data, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getActivity(),Main2Activity.class);
                                intent.putExtra("path",data);
                                startActivity(intent);

                            }
                        });
                    }


                }
        );

    }



}



