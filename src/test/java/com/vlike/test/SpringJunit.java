package com.vlike.test;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.vnet.dao.StuDao;
import com.vnet.pojo.Stu;
import com.vnet.pojo.UserInfo;
import com.vnet.service.UserService;

/**
 * Junit整合Spring单元测试
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)：表示使用自己定制的Junit4.5+运行器来运行测试，
 *    即完成SpringTestContext框架与Junit集成
 * @ContextConfiguration：指定要加载的Spring配置文件，此处注意我们的Spring资源配置文件为
 *    applicationContext-resources-test.xml
 * @TransactionConfiguration：开启测试类的事务管理支持配置，并指定事务管理器和默认回滚行为
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class SpringJunit extends AbstractTransactionalJUnit4SpringContextTests {

	@Resource
	private UserService userService;

	@Resource
	private StuDao stuDao;

	@Test
	public void testFindUser() {
		UserInfo user = userService.findUserInfo();
		System.out.println(user.toString());
		System.out.println(RandomUtils.nextDouble(40.00, 100.00));
	}

	@Test
	public void testInsertStu() {
		for (int i = 100000; i < 100005; i++) {
			if(i % 3 ==0 ) {
				throw new RuntimeException(i + "发生错误");
			}
			userService.insertStu(new Stu(i, "梦梦" + i, "n" + i, RandomUtils.nextDouble(40.00, 100.00)));
		}
	}

	@Test
	public void testBatchInsertStu() {
		userService.batchInsertStu();
	}

}
