package com.vlike.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vnet.nosql.IRedisUserDao;
import com.vnet.nosql.RedisUser;

/**
 * Redis测试
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class RedisTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private IRedisUserDao RedisUserDao;

	/**
	 * 新增 <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testAddRedisUser() {
		RedisUser RedisUser = new RedisUser();
		RedisUser.setUid("RedisUser1");
		RedisUser.setName("java2000_wl");
		boolean result = RedisUserDao.add(RedisUser);
		Assert.assertTrue(result);
	}

	/**
	 * 批量新增 普通方式 <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testAddRedisUsers1() {
		List<RedisUser> list = new ArrayList<RedisUser>();
		for (int i = 10; i < 50000; i++) {
			RedisUser RedisUser = new RedisUser();
			RedisUser.setUid("RedisUser" + i);
			RedisUser.setName("java2000_wl" + i);
			list.add(RedisUser);
		}
		long begin = System.currentTimeMillis();
		for (RedisUser RedisUser : list) {
			RedisUserDao.add(RedisUser);
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

	/**
	 * 批量新增 pipeline方式 <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testAddRedisUsers2() {
		List<RedisUser> list = new ArrayList<RedisUser>();
		for (int i = 10; i < 1500000; i++) {
			RedisUser RedisUser = new RedisUser();
			RedisUser.setUid("RedisUser" + i);
			RedisUser.setName("java2000_wl" + i);
			list.add(RedisUser);
		}
		long begin = System.currentTimeMillis();
		boolean result = RedisUserDao.add(list);
		System.out.println(System.currentTimeMillis() - begin);
		Assert.assertTrue(result);
	}

	/**
	 * 修改 <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testUpdate() {
		RedisUser RedisUser = new RedisUser();
		RedisUser.setUid("RedisUser1");
		RedisUser.setName("new_password");
		boolean result = RedisUserDao.update(RedisUser);
		Assert.assertTrue(result);
	}

	/**
	 * 通过key删除单个 <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testDelete() {
		String key = "RedisUser1";
		RedisUserDao.delete(key);
	}

	/**
	 * 批量删除 <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testDeletes() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("RedisUser" + i);
		}
		RedisUserDao.delete(list);
	}

	/**
	 * 获取 <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testGetRedisUser() {
		String id = "RedisUser1";
		RedisUser RedisUser = RedisUserDao.get(id);
		Assert.assertNotNull(RedisUser);
		Assert.assertEquals(RedisUser.getName(), "java2000_wl");
	}

	/**
	 * 设置RedisUserDao
	 * 
	 * @param RedisUserDao
	 *            the RedisUserDao to set
	 */
	public void setRedisUserDao(IRedisUserDao RedisUserDao) {
		this.RedisUserDao = RedisUserDao;
	}
}