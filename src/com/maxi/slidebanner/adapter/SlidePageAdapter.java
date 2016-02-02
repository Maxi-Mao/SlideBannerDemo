package com.maxi.slidebanner.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SlidePageAdapter extends PagerAdapter {
	private Context context;
	private List<View> viewList = new ArrayList<View>();

	public SlidePageAdapter(Context context,List<Integer> inputList) {
		this.context = context;
		this.viewList = setViewList(inputList);
	}

	private List<View> setViewList(List<Integer> inputList) {
		List<View> viewList = new ArrayList<View>();
		ImageView firstView = new ImageView(context);
		firstView.setBackgroundResource(inputList.get(inputList.size() - 1));
		viewList.add(firstView);
		for (Integer i : inputList) {
			ImageView iv = new ImageView(context);
			iv.setBackgroundResource(i);
			viewList.add(iv);
		}
		ImageView lastView = new ImageView(context);
		lastView.setBackgroundResource(inputList.get(0));
		viewList.add(lastView);
		return viewList;
	}

	@Override
	public void finishUpdate(View arg0) {

	}

	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	@Override
	public int getCount() {
		return viewList.size();
	}

	@Override
	public Object instantiateItem(View view, int position) {
		((ViewGroup) view).addView(viewList.get(position));
		return viewList.get(position);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {

	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void startUpdate(View arg0) {

	}

	@Override
	public void destroyItem(View arg0, int arg1, Object arg2) {
		try {
			((ViewPager) arg0).removeView(viewList.get(arg1));
		} catch (Exception e) {
		}
	}

}