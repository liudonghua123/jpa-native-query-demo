package com.liudonghua.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.liudonghua.demo.model.User;
import com.liudonghua.demo.model.UserPartial;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Test
	public void emptyTest() {
		List<User> allUsers = userRepository.findAll();
		assertThat(allUsers).isEmpty();
	}

	@Test
	public void insertUser() {
		User user = new User("user", "password");
		User savedUser = userRepository.save(user);
		User foundUser = userRepository.findOne(user.getId());
		assertThat(foundUser).isNotNull();
	}

	@Test
	public void customMapping() {
		User user = new User("user", "password");
		User savedUser = userRepository.save(user);
		List<UserPartial> userPartials = userRepository.getUserPartialsByUsername(savedUser.getUsername());
//		List<UserPartial> userPartials = entityManager.createNamedQuery("UserRepository.getUserParital", UserPartial.class).setParameter("id", savedUser.getId()).getResultList();
		assertThat(userPartials).isNotNull();
	}
}
