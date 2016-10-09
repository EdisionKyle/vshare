package com.vnet.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl /*implements UserManager*/ {

	public void addUser(String username, String password) {
		// checkSecurity();
		System.out.println("---------UserManagerImpl.add()--------");
	}

	public void delUser(int userId) {
		// checkSecurity();
		System.out.println("---------UserManagerImpl.delUser()--------");
	}

	public String findUserById(int userId) {
		// checkSecurity();
		System.out.println("---------UserManagerImpl.findUserById()--------");
		return "张三";
	}

	public void modifyUser(int userId, String username, String password) {
		// checkSecurity();
		System.out.println("---------UserManagerImpl.modifyUser()--------");
	}

	// private void checkSecurity() {
	// System.out.println("-------checkSecurity-------");
	// }

}
