package com.example.android_xutilstest;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyFragment extends Fragment {
	@ViewInject(R.id.bt_add)
	private Button bt_add;
	@ViewInject(R.id.bt_del)
	private Button bt_del;
	@ViewInject(R.id.bt_update)
	private Button bt_update;
	@ViewInject(R.id.bt_find)
	private Button bt_find;
	private dbDao dao;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.activity_main, container,false);
		ViewUtils.inject(this,v);
		dao=new dbDaoImpl(getActivity().getApplicationContext());
		return v;
	}
	@OnClick({R.id.bt_add,R.id.bt_del,R.id.bt_update,R.id.bt_find})
	public void click(View v) {
		switch (v.getId()) {
		case R.id.bt_add:
			dao.add();
			break;
		case R.id.bt_del:
			dao.del();
			break;
		case R.id.bt_update:
			dao.update();
			break;
		case R.id.bt_find:
			dao.find();
			break;
		}
	}
}
