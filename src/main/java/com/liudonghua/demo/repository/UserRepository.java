package com.liudonghua.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.liudonghua.demo.model.User;
import com.liudonghua.demo.model.UserPartial;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(name = "UserRepository.getUserParital", nativeQuery = true)
	List<UserPartial> getUserPartialsByUsername(@Param("username") String username);

	@Query(name = "UserRepository.getAllUserPartials", nativeQuery = true)
	List<UserPartial> getAllUserPartials();

	@Query(value = "select count(*) as count from users", nativeQuery = true)
	List<Object> getUserCount();
}
