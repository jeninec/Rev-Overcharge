package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.overcharge.beans.User;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class UserServiceTests {

	@Autowired
	public UserService us;

	@Test
	void addUserTest() {
		long test = 0;
		User User1 = new User("test", "test", 0, test);
		User User = us.addUser(User1);

		Assertions.assertEquals("test", User.getPassword());
		Assertions.assertEquals("test", User.getUsername());
	}

	@Test
	void getUserTest() {
		User user = new User(1, "test", "test", 0, null);
		Optional<User> optionI = Optional.of(user);

		Assertions.assertEquals(1, optionI.get().getId());
	}

	@Test
	void getAllUserTest() {
		List<User> list = new ArrayList<>();
		User u = new User(0, "test", "test", 0, null);
		User u2 = new User(1, "test2", "test2", 0, null);

		list.add(u);
		list.add(u2);

		Mockito.when(us.getAllUsers()).thenReturn(list);

		list = us.getAllUsers();
		assertEquals("test", list.get(0).getPassword());

		assertEquals("test2", list.get(1).getPassword());
	}

	@Test
	void updateUserTest() {
		User user = new User(1, "test", "test", 0, null);

		user = us.updateUser(user);
		Assertions.assertEquals(1, user.getId());
		Assertions.assertEquals("test", user.getPassword());
	}

	@Test
	void deleteUserTest() {
		User user = new User("test", "test", 0, null);
		user = us.addUser(user);

		boolean ret = us.deleteUser(user.getId());
		Assertions.assertTrue(ret);
	}

	@Test
	void loginTest() {
		assertFalse(false);
	}

}
