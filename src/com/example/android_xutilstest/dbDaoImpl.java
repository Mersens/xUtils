package com.example.android_xutilstest;

import java.util.List;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.DbUtils.DaoConfig;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;
import android.content.Context;
public class dbDaoImpl implements dbDao{
	private Context context;
	public dbDaoImpl(Context context){
		this.context= context;
		DaoConfig config = new DaoConfig(context);
		config.setDbName("userdb"); 
		config.setDbVersion(1); 
		DbUtils db = DbUtils.create(config);
		try {
			db.createTableIfNotExist(UserBean.class);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void add() {
		// TODO Auto-generated method stub
		DbUtils db = DbUtils.create(context);
		try {
			UserBean user = new UserBean();
			for (int i = 0; i < 10; i++) {
				user.setId((i + 1) + "");
				user.setAge(22 + i);
				user.setName("Mersens" + i);
				if (i % 2 == 0)
					user.setSex("男");
				else
					user.setSex("女");
				db.save(user);
				System.out.println("保存成功！=====" + user.toString());
			}
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		DbUtils db = DbUtils.create(context);
		try {
			UserBean user = new UserBean();
			user.setName("马新新");
			db.update(user, WhereBuilder.b("id", "=", "6"), "name");
			System.out.println("更新成功！");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void del() {
		// TODO Auto-generated method stub
		DbUtils db = DbUtils.create(context);
		try {
			db.delete(UserBean.class, WhereBuilder.b("id", "=", "5"));
			System.out.println("删除成功！");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBean> find() {
		// TODO Auto-generated method stub
		DbUtils db = DbUtils.create(context);
		List<UserBean> list = null;
		try {
			list = db.findAll(UserBean.class);
			for (UserBean bean : list) {
				System.out.println(bean);
			}
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
