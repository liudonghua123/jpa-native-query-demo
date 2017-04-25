package com.liudonghua.demo.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@SqlResultSetMapping(name = "userPartialMapping", classes = {
		@ConstructorResult(targetClass = UserPartial.class, columns = { @ColumnResult(name = "id"),
				@ColumnResult(name = "username") }) })
@NamedNativeQueries({
		@NamedNativeQuery(name = "UserRepository.getAllUserPartials", query = "select id, username from users", resultSetMapping = "userPartialMapping"),
		@NamedNativeQuery(name = "UserRepository.getUserParital", query = "select id, username from users where username = :username", resultSetMapping = "userPartialMapping") })
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
