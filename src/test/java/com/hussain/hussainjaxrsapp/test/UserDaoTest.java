package com.hussain.hussainjaxrsapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.hussain.hussainjaxrsapp.dao.UserDao;
import com.hussain.hussainjaxrsapp.model.User;

public class UserDaoTest {
	
	
	
	private int expected = 3;
	
	@Test
	public void testGetUser() {
		UserDao userDao = new UserDao();
		List<User> users = userDao.getUsersFromDb();
		int actual = users.size();
        		
		assertEquals(expected, actual);
	}

}
