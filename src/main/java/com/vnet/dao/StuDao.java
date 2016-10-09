package com.vnet.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.vnet.pojo.Stu;

/**
 * 斯密达
 * @author pengcheng.tian
 *
 */
@Repository
public interface StuDao {

	public void insertStu(Stu stu);

	public PageList<Stu> findStuByPager(Map<String, Object> params,
			PageBounds pageBounds);

}
