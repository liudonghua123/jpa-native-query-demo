package com.liudonghua.demo.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.liudonghua.demo.model.User;
import com.liudonghua.demo.model.UserCount;
import com.liudonghua.demo.model.UserPartial;
import com.liudonghua.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public List<UserPartial> getUserPartials(String username) {
		return StringUtils.isEmpty(username) ? userRepository.getAllUserPartials()
				: userRepository.getUserPartialsByUsername(username);
	}

	public UserCount count() {
		UserCount userCount = new UserCount(0);
		List<Object> userCounts = userRepository.getUserCount();
		Object userCountObject = userCounts.get(0);
		if (userCountObject != null) {
			userCount.setCount(((BigInteger) userCountObject).intValue());
		}
		return userCount;
	}

}
