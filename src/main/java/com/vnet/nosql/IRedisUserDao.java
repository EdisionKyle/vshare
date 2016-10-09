package com.vnet.nosql;

import java.util.List;

/**
 * Redis操作用户接口
 * 
 * @author Administrator
 *
 */
public interface IRedisUserDao {
	/**
	 * 新增 <br>
	 * ------------------------------<br>
	 * 
	 * @param RedisUser
	 * @return
	 */
	boolean add(RedisUser RedisUser);

	/**
	 * 批量新增 使用pipeline方式 <br>
	 * ------------------------------<br>
	 * 
	 * @param list
	 * @return
	 */
	boolean add(List<RedisUser> list);

	/**
	 * 删除 <br>
	 * ------------------------------<br>
	 * 
	 * @param key
	 */
	void delete(String key);

	/**
	 * 删除多个 <br>
	 * ------------------------------<br>
	 * 
	 * @param keys
	 */
	void delete(List<String> keys);

	/**
	 * 修改 <br>
	 * ------------------------------<br>
	 * 
	 * @param RedisUser
	 * @return
	 */
	boolean update(RedisUser RedisUser);

	/**
	 * 通过key获取 <br>
	 * ------------------------------<br>
	 * 
	 * @param keyId
	 * @return
	 */
	RedisUser get(String keyId);

}
