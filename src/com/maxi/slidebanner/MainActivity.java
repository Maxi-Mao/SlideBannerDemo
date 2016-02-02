package com.maxi.slidebanner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.maxi.slidebanner.adapter.SlidePageAdapter;
import com.maxi.slidebanner.widget.AutoSlideViewPager;
import com.maxi.slidebanner.widget.AutoSlideViewPager.OnPageSlideSelected;
import com.maxi.slidebanner.widget.SlidePagerPiontsView;

public class MainActivity extends Activity {
	AutoSlideViewPager viewPager;
	SlidePagerPiontsView viewPionts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		init();
	}

	private void findView() {
		viewPager = (AutoSlideViewPager) findViewById(R.id.view_pager);
		viewPionts = (SlidePagerPiontsView) findViewById(R.id.banner_points);
	} 

	private int[] image = { R.drawable.b1, R.drawable.b2, R.drawable.b3,
			R.drawable.b4, R.drawable.b5 };
	private List<Integer> imageList = new ArrayList<Integer>();

	private void init() {
		for (int i = 0; i < image.length; i++) {
			imageList.add(image[i]);
		}
		viewPionts.setPoints(image.length, R.drawable.point_normal, R.drawable.point_read);
		SlidePageAdapter pageAdapter = new SlidePageAdapter(this,imageList);
		viewPager.setAdapter(pageAdapter);
		viewPager.setAutoSlideDuration(5000); //默认3秒 设置自动滚动时间为5秒
		viewPager.setOnPageSlideSelected(new OnPageSlideSelected(){

			@Override
			public void onSlideSelected(int position) {
				// TODO Auto-generated method stub
				viewPionts.setSelectPoint(image.length, position);
			}

			@Override
			public void onClickSelected(int position) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "点击第"+position+"个banner", Toast.LENGTH_SHORT).show();
			}

		});
	}
}
