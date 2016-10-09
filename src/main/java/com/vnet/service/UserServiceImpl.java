package com.vnet.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.vnet.dao.StuDao;
import com.vnet.pojo.Stu;
import com.vnet.pojo.UserInfo;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private StuDao stuDao;
	
	public UserInfo findUserInfo() {
		UserInfo user = new UserInfo();
		user.setId("MileLoner");
		user.setAge(29);
		user.setBirth(new Date());
		user.setJob("Java攻城师");
		user.setName("田鹏程");
		return user;
	}
	
	public void insertStu(Stu stu) {
		stuDao.insertStu(stu);
	}
	
	public void batchInsertStu() {
		for (int i = 100000; i < 100005; i++) {
			if(i % 3 ==0 ) {
				System.out.println(i + "发生错误");
				throw new RuntimeException(i + "发生错误");
			}
			stuDao.insertStu(new Stu(i, "梦梦" + i, "n" + i, RandomUtils.nextDouble(40.00, 100.00)));
			System.out.println(i + "操作成功");
		}
	}

	public PageList<Stu> findStuByPager(Map<String, Object> params,
			PageBounds pageBounds) {
		return stuDao.findStuByPager(params, pageBounds);
	}

}
