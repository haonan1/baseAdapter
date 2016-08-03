package com.zhy.adapter.abslistview;

import android.content.Context;

import com.zhy.adapter.abslistview.base.ItemViewDelegate;

import java.util.List;

public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T>
{

    public CommonAdapter(Context context, final int layoutId)
    {
        super(context);

        addItemViewDelegate(new ItemViewDelegate<T>()
        {
            @Override
            public int getItemViewLayoutId()
            {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position)
            {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position)
            {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    public CommonAdapter(Context context, final int layoutId, List<T> datas)
    {
        super(context, datas);

        addItemViewDelegate(new ItemViewDelegate<T>()
        {
            @Override
            public int getItemViewLayoutId()
            {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position)
            {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position)
            {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder viewHolder, T item, int position);



    public void replaceAll(List<T> mList) {
        mDatas.clear();
        mDatas.addAll(mList);
    }

    public void addAll(List<T> mList) {
        mDatas.addAll(mList);
    }

    public void addItem(T t) {
        mDatas.add(t);
    }


    public void addItemToFirst(T t){
        mDatas.add(0,t);
    }

    public void deleteItem(int position){
        mDatas.remove(position);
    }



}
