package com.example.android_xutilstest;

import java.util.List;

public interface dbDao {
	public void add();
	public void update();
	public void del();
	public <T> List<T> find();
	

}
