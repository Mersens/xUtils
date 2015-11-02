package com.example.android_xutilstest;
import android.support.v4.app.Fragment;
public class MainActivity extends SingleFragmentActivity {
	@Override
	protected Fragment creatFragment() {
		// TODO Auto-generated method stub
		return new MyFragment();
	}
}
