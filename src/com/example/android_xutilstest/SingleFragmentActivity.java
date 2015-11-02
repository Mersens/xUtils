package com.example.android_xutilstest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class  SingleFragmentActivity extends FragmentActivity {
	/**
	 * 抽象方法，返回Fragment实例
	 * @return
	 */
	protected abstract Fragment creatFragment();
	
	@Override
	protected void onCreate(Bundle arg0) { 
		super.onCreate(arg0);
		setContentView(R.layout.main);
		initDatas();
	}

	@SuppressLint("Recycle")
	private void initDatas() {
		FragmentManager fm=getSupportFragmentManager();
		Fragment fragment=fm.findFragmentById(R.id.layout_container);
		if(fragment==null){
			fragment=creatFragment();
			fm.beginTransaction().add(R.id.layout_container, fragment).commit();
		}
	}
}
