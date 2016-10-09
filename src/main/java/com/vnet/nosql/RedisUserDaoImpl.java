package com.vnet.nosql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * Redis操作用户接口实现类
 * 
 * @author Administrator
 *
 */
@Repository
public class RedisUserDaoImpl extends AbstractRedisDao<String, RedisUser>
		implements IRedisUserDao {

	/**
	 * 新增 <br>
	 * ------------------------------<br>
	 * 
	 * @param RedisUser
	 * @return
	 */
	public boolean add(final RedisUser RedisUser) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(RedisUser.getUid());
				byte[] name = serializer.serialize(RedisUser.getName());
				return connection.setNX(key, name);
			}
		});
		return result;
	}

	/**
	 * 批量新增 使用pipeline方式 <br>
	 * ------------------------------<br>
	 *
	 * @param list
	 * @return
	 */
	public boolean add(final List<RedisUser> list) {
		Assert.notEmpty(list);
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				for (RedisUser RedisUser : list) {
					byte[] key = serializer.serialize(RedisUser.getUid());
					byte[] name = serializer.serialize(RedisUser.getName());
					connection.setNX(key, name);
				}
				return true;
			}
		}, false, true);
		return result;
	}

	/**
	 * 删除 <br>
	 * ------------------------------<br>
	 * 
	 * @param key
	 */
	public void delete(String key) {
		List<String> list = new ArrayList<String>();
		list.add(key);
		delete(list);
	}

	/**
	 * 删除多个 <br>
	 * ------------------------------<br>
	 * 
	 * @param keys
	 */
	public void delete(List<String> keys) {
		redisTemplate.delete(keys);
	}

	/**
	 * 修改 <br>
	 * ------------------------------<br>
	 * 
	 * @param RedisUser
	 * @return
	 */
	public boolean update(final RedisUser RedisUser) {
		String key = RedisUser.getUid();
		if (get(key) == null) {
			throw new NullPointerException("数据行不存在, key = " + key);
		}
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(RedisUser.getUid());
				byte[] name = serializer.serialize(RedisUser.getName());
				connection.set(key, name);
				return true;
			}
		});
		return result;
	}

	/**
	 * 通过key获取 <br>
	 * ------------------------------<br>
	 * 
	 * @param keyId
	 * @return
	 */
	public RedisUser get(final String keyId) {
		RedisUser result = redisTemplate
				.execute(new RedisCallback<RedisUser>() {
					public RedisUser doInRedis(RedisConnection connection)
							throws DataAccessException {
						RedisSerializer<String> serializer = getRedisSerializer();
						byte[] key = serializer.serialize(keyId);
						byte[] value = connection.get(key);
						if (value == null) {
							return null;
						}
						String name = serializer.deserialize(value);
						return new RedisUser(keyId, name, null);
					}
				});
		return result;
	}
}