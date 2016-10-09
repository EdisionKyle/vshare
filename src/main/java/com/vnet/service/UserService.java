package com.vnet.service;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.vnet.pojo.Stu;
import com.vnet.pojo.UserInfo;

public interface UserService {

	public UserInfo findUserInfo();
	
	public void insertStu(Stu stu);
	
	public void batchInsertStu();

	public PageList<Stu> findStuByPager(Map<String, Object> params,
			PageBounds pageBounds);
}
